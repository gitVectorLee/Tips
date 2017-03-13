package maijiayunTips.service;

import java.util.Date;
import java.util.List;

import maijiayunTips.Dao.model.User;

public interface UserService {
	public List<User> select();
	public List<User> select(int id);
	public List<User> select(String name);
	public List<User> select(Date date);
	public List<User> selectByVip(int vip);
	public void insert(User u);
	public void delete(User u);
	public void modify(User u);
}
