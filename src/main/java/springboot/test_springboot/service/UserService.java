package springboot.test_springboot.service;

import java.util.List;

import springboot.test_springboot.controller.PageBean;
import springboot.test_springboot.controller.ResultCode;
import springboot.test_springboot.model.User;

public interface UserService {
	public ResultCode add(User user);
	
	public void delById(int id);
	
	public List<User> select();
	
	public User update(User user);
	
	public User findUserById(int id);
	
	public PageBean findByPage(int page, int size);
	
	public List<User>findByCode(String name,String code);
	
	public ResultCode login(User u);

}
