package com.poc.video.on.demand.apis.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.poc.video.on.demand.mock.db.MoviesDatabase;
import com.poc.video.on.demand.mock.db.PurchaseDatabase;
import com.poc.video.on.demand.mock.db.UsersDatabase;
import com.poc.video.on.demand.model.Movie;
import com.poc.video.on.demand.model.Purchase;
import com.poc.video.on.demand.model.PurchasedMovie;
import com.poc.video.on.demand.model.User;
import com.poc.video.on.demand.model.UserType;

@Service
public class Services {
	public Collection<Movie> getMovies(){
		return MoviesDatabase.getAllMovies();
	}
	
	public Movie getMovie(Integer movieId) {
		return MoviesDatabase.getMovie(movieId);
	}
	
	public PurchasedMovie purchaseMovie(Integer movieId, Integer userId) {
		Movie movie = getMovie(movieId);
		User user = UsersDatabase.getUser(userId);
		
		PurchasedMovie purchasedMovie = new PurchasedMovie(movie.getId(), movie.getTitle(), getPriceByUserType(movie.getPrice(),user.getUserType()) , Instant.now());
		Purchase purchase = PurchaseDatabase.getPurchases(user);
		if(purchase==null) {
			// first time purchase
			purchase = new Purchase(user);
		}
		purchase.addPurchase(purchasedMovie);
		PurchaseDatabase.addPurchase(purchase);
		return purchasedMovie;
	}

	private Integer getPriceByUserType(Integer price, UserType userType) {
		switch(userType) {
			case GOLD: return pPercentOfN(25, price);
			case SILVER: return pPercentOfN(50, price);
			case BRONZE: return price;
		}
		return 0;
	}
	
	private static Integer pPercentOfN(Integer p, Integer n) {
		return (n*p)/100;
	}

	public Collection<Movie> getMovies(Integer userId) {
		Collection<Movie> movies = new ArrayList<>();
		Collection<Movie> allMovies = MoviesDatabase.getAllMovies();
		User user = UsersDatabase.getUser(userId);
		allMovies.forEach(m -> m.setPrice(getPriceByUserType(m.getPrice(), user.getUserType())));
		Purchase userPurchases = PurchaseDatabase.getPurchases(user);
		if(Objects.isNull(userPurchases)) {
			return allMovies;
		} else {
			List<PurchasedMovie> purchasedMovies = userPurchases.getPurchasedMovies();
			
			List<Integer> purchasedMovieIds = purchasedMovies.stream().map(pm -> pm.getId()).collect(Collectors.toList());
			movies.addAll(purchasedMovies);
			for(Movie movie: allMovies) {
				if(!purchasedMovieIds.contains(movie.getId())) {
					
					movies.add(movie);
				}
			}
		}
		return movies;
	}
}
