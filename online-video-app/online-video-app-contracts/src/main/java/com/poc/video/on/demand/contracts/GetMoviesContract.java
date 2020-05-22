package com.poc.video.on.demand.contracts;

import java.util.Collection;

import com.poc.video.on.demand.model.Movie;

public interface GetMoviesContract {
	public Collection<Movie> getMovies(final Integer userId);
}
