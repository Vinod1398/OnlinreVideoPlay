package com.poc.video.on.demand.mock.db;

import java.util.HashMap;
import java.util.Map;

import com.poc.video.on.demand.model.User;
import com.poc.video.on.demand.model.UserType;

public class UsersDatabase {
	private static final Map<Integer, User> USER_DATABASE = new HashMap<>();
	private UsersDatabase() {}
	static {
		bootUserDatabase();
	}
	public static final User getUser(Integer userId) {
		return USER_DATABASE.get(userId);
	}
	private static void bootUserDatabase() {
		USER_DATABASE.put(1, new User(1, "Vinod", UserType.GOLD));
		USER_DATABASE.put(2, new User(2, "Jay", UserType.SILVER));
		USER_DATABASE.put(3, new User(3, "Kiran", UserType.BRONZE));
	}
}
