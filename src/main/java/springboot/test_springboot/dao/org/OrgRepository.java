package springboot.test_springboot.dao.org;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.test_springboot.model.Organization;

public interface OrgRepository extends JpaRepository<Organization, Integer> {
	
	public Organization findByCode(String code);

}
