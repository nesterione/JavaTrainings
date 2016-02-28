package com.itclass.services;

import java.util.HashMap;
import java.util.Map;

import com.itclass.model.User;

public class UserService implements AutoCloseable{
	
	// TODO 
	//private static Map<String , User> users = new HashMap<>();
	
	public boolean checkLogin(String login) {
		
		
		// TODO проверяем, нет логина 
		
		//users.containsKey(login);
		
		return false;
	}
	
	public boolean registration(String login, String password) {
		
		// TODO сохраняем в БД 
		
		return false;
	}
	
	public User login(String login, String password) {
		
		// TODO проверка пользователя 
		// TODO вернуть объект если пользователь есть
		
		// TODO вместо этого, будет извелечение из БД
		// пользователя по логину, и проверка его пароля
		if("admin".equals(login)&&"123".equals(password)){
			return new User(-1, login, password);
		} 
		
		return null;		
	}

	@Override
	public void close() throws Exception {
		// TODO закрытие соединения 
		
	}

}
