package learn.web.dao;


import learn.web.po.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public interface UserDao {

	void addUser(User user);
	
	public List<User> selectUserByAge(int age);
	
//	public User selectUserByAge(int age);

	public User selectInfo(int id);

	public List<User> selectAll();
}
