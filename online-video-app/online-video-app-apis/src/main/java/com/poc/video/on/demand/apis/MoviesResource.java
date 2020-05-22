package com.poc.video.on.demand.apis;

import java.util.Collection;
import java.util.Optional;

import javax.ws.rs.GET;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.video.on.demand.apis.service.Services;
import com.poc.video.on.demand.contracts.GetMoviesContract;
import com.poc.video.on.demand.model.Movie;

@RestController
public class MoviesResource implements GetMoviesContract{

	private Services services;

	public MoviesResource(Services services) {
		super();
		this.services = services;
	}

	@GET
	@Override
	@RequestMapping("/movies")
	public Collection<Movie> getMovies(@RequestHeader(required=false, value="user-id") Integer userId) {
		if(Optional.ofNullable(userId).isPresent()) {
			return services.getMovies(userId);
		}
		return services.getMovies();
	}

}
