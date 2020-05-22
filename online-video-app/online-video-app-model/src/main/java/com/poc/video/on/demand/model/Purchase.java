package com.poc.video.on.demand.model;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
	
	private User user;
	private List<PurchasedMovie> purchasedMovies = new ArrayList<>();
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<PurchasedMovie> getPurchasedMovies() {
		return purchasedMovies;
	}
	public void addPurchase(PurchasedMovie movie) {
		purchasedMovies.add(movie);
	}
	public Purchase(User user) {
		super();
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
