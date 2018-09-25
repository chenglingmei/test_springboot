package springboot.test_springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.test_springboot.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByMobile(String mobile);
	
}
