package com.myjob.interviews.service;

import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import com.myjob.interviews.plain.Applicant;
import com.myjob.interviews.plain.Login;

import com.myjob.interviews.database.DatabaseClass;

public class LoginService {
	Map<Integer,Login> logins=DatabaseClass.getAllLoginUsers();

	public Login addLoginUser(Login login)
	{
		Set<Integer> keys=logins.keySet();
		System.out.println(keys);
		int id=Collections.max(keys)+1;
		login.setId(id);
		logins.put(id,login);
		return login;
	}
	
	public Login deleteLoginUser(int id)
	{
		return logins.remove(id);
	}
	
	public Login updateLoginUser(int id,Login login)
	{
		login.setId(id);
		logins.put(id, login);
		return login;
	}
	public List<Login> getAllUsersLogin()
	{
		return new ArrayList<Login>(logins.values());
	}
	public Login getUserLogin(int id)
	{
		return logins.get(id);
	}
}
