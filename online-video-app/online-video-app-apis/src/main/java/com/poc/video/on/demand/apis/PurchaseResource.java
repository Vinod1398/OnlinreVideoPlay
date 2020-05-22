package com.poc.video.on.demand.apis;

import javax.ws.rs.POST;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.video.on.demand.apis.service.Services;
import com.poc.video.on.demand.contracts.PurchaseMovieContract;
import com.poc.video.on.demand.model.PurchasedMovie;

@RestController
public class PurchaseResource implements PurchaseMovieContract{

	private Services services;

	public PurchaseResource(Services services) {
		super();
		this.services = services;
	}
	
	@POST
	@Override
	@RequestMapping("/purchase")
	public PurchasedMovie purchase(@RequestParam(value="movie-id") Integer movieId, @RequestHeader(value="user-id") Integer userId) {
		return services.purchaseMovie(movieId, userId);
	}

}
