package springboot.test_springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import springboot.test_springboot.controller.PageBean;
import springboot.test_springboot.controller.ResultCode;
import springboot.test_springboot.dao.UserRepository;
import springboot.test_springboot.model.User;
import springboot.test_springboot.utils.Md5Util;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResultCode add(User user) {
		String p1=user.getPassword();
		String p2=user.getPassword2();
		if(!(p1.equals(p2))){
			return ResultCode.errorCode("两次密码输入不一致");
		}
		String mobile = user.getMobile();
		User u = userRepository.findByMobile(mobile);
		if (u != null) {
			return ResultCode.errorCode("手机号已存在");
		}
        String md5password=Md5Util.EncoderByMd5(p1);
        user.setPassword(md5password);
		userRepository.save(user);
		return ResultCode.succese();
	}
	
	@Override
	public void delById(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User update(User u) {
		if (u.getId() > 0) {
			User user = userRepository.getOne(u.getId());
			user.setName(u.getName());
			user = userRepository.save(user);
			return user;
		}
		return null;
	}

	@Override
	public User findUserById(int id) {
		 User user=userRepository.findById(id).get();
		return user;
	}

	@Override
	public PageBean findByPage(int page, int size) {
		PageRequest pageTable = new PageRequest(page, size);
		// List<User> list=new ArrayList<>();

		Page<User> resp = userRepository.findAll(pageTable);
		Long total = resp.getTotalElements();
		PageBean pageBean = new PageBean();
		pageBean.setData(resp.getContent());
		pageBean.setTotal(total);
		return pageBean;
		// Iterator<User> iterator =resp.iterator();
		// while(iterator.hasNext()) {
		// User u=iterator.next();
		// list.add(u);
		// }
		// return list;

	}

	@Override
	public List<User> findByCode(String name, String code) {

		return null;
	}
	
	public ResultCode login(User u) {
		User user=userRepository.findByMobile(u.getMobile());
		if(user==null) {
			return ResultCode.errorCode("用户名不正确");
		}
		String md5Str=Md5Util.EncoderByMd5(u.getPassword());
		if(user.getMobile().equals(u.getMobile())&&user.getPassword().equals(md5Str)){
			
			return ResultCode.succese(user);
		}
		else {
			return ResultCode.errorCode("没有此用户，或用户名密码错误");
		}
	}
	
	

}
