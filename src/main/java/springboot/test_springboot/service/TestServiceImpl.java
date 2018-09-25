package springboot.test_springboot.service;

import org.springframework.stereotype.Service;

import springboot.test_springboot.model.Teacher;
@Service
public class TestServiceImpl implements TestService {
	
	public Teacher select() {
		Teacher t=new Teacher();
		t.setClassId(1);
		t.setName("deng");
		t.setAge(26);
		return t;
	}
	
}
