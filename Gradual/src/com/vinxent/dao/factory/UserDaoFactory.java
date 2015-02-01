package com.vinxent.dao.factory;

import com.vinxent.dao.UserDao;
import com.vinxent.dao.impl.UserDaoImpl;

public class UserDaoFactory {
	public static UserDao getUserDaoInstance() {
		return new UserDaoImpl();
	}
}
