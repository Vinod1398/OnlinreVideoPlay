package com.poc.video.on.demand.contracts;

import org.springframework.web.bind.annotation.RequestParam;

import com.poc.video.on.demand.model.PurchasedMovie;

public interface PurchaseMovieContract {
	public PurchasedMovie purchase(@RequestParam Integer movieId, Integer userId);
}
