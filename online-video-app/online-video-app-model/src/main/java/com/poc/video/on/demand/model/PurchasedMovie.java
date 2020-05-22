package com.poc.video.on.demand.model;

import java.time.Instant;

public class PurchasedMovie extends Movie{

	private final Instant time;

	public PurchasedMovie(Integer id, String title, Integer price, Instant time) {
		super(id, title, price);
		this.time = time;
	}

	public Instant getTime() {
		return time;
	}
	
	public Instant getExpiresOn() {
		return time.plusSeconds(30);
	}
	
	public String getStatus() {
		return (time.plusSeconds(30).isBefore(Instant.now()))?"Expired":"Servable";
	}
	
	public static void main(String[] str) throws InterruptedException {
		System.out.println(pPercentOfN(25, 200));
		/*
		PurchasedMovie movie = new PurchasedMovie(1, "", 10, Instant.now());
		System.out.println(movie.getStatus());
		Thread.sleep(10*1000);
		System.out.println(movie.getStatus());
		Thread.sleep(10*1000);
		System.out.println(movie.getStatus());
		Thread.sleep(10*1000);
		System.out.println(movie.getStatus());*/
	}
	
	private static Integer pPercentOfN(Integer p, Integer n) {
		return (n*p)/100;
	}
	
}
