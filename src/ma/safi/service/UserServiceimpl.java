package ma.safi.service;

import ma.safi.dao.users.UserDaoImpl;
import ma.safi.entities.Users;
import ma.safi.dao.users.UserDao;

public class UserServiceimpl implements UserService {
	UserDao userDao;
	
	
	
	public UserServiceimpl() {
		userDao = new UserDaoImpl();
	}


	@Override
	public Users getUserByloginService(String login)  {
		return userDao.getUserByloginDao(login);
	}

}
