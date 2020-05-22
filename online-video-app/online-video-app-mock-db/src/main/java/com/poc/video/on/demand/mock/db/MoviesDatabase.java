package com.poc.video.on.demand.mock.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.poc.video.on.demand.model.Movie;

public class MoviesDatabase {
	private static final Map<Integer, Movie> MOVIES_DATABASE = new HashMap<>();
	private MoviesDatabase() {}
	static {
		bootMovieDatabase();
	}
	public static final Movie getMovie(Integer movieId) {
		return MOVIES_DATABASE.get(movieId);
	}
	private static void bootMovieDatabase() {
		MOVIES_DATABASE.put(1, new Movie(1, "Titanic", 100));
		MOVIES_DATABASE.put(2, new Movie(2, "Avatar", 200));
		MOVIES_DATABASE.put(3, new Movie(3, "Terminator", 300));
	}
	
	public static Collection<Movie> getAllMovies() {
		return MOVIES_DATABASE.values().stream().map(e -> new Movie(e.getId(), e.getTitle(), e.getPrice())).collect(Collectors.toList());
	}
}
