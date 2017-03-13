package maijiayunTips.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import maijiayunTips.Dao.UserDao;
import maijiayunTips.Dao.model.User;
import maijiayunTips.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> select(int id) {
		return userDao.select(id);
	}

	@Override
	@Transactional
	public List<User> select(String name) {
		return userDao.select(name);
	}

	@Override
	@Transactional
	public List<User> select(Date date) {
		return userDao.select(date);
	}

	@Override
	@Transactional
	public List<User> selectByVip(int vip) {
		return userDao.selectByVip(vip);
	}

	@Override
	@Transactional
	public void insert(User u) {
		userDao.insert(u);
		
	}

	@Override
	@Transactional
	public void delete(User u) {
		userDao.delete(u);
		
	}

	@Override
	@Transactional
	public void modify(User u) {
		userDao.modify(u);		
		
	}

	@Override
	public List<User> select() {
		
		return userDao.select();
	}
	
}
