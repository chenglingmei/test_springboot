package springboot.test_springboot.service.org;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.test_springboot.dao.org.OrgRepository;
import springboot.test_springboot.model.Organization;
import springboot.test_springboot.model.User;
import springboot.test_springboot.utils.RandomString;
@Service
public class OrgServiceImp implements OrgService {
	@Autowired
	private OrgRepository orgRepository;
	@Override
	public Organization addOrgnization(Organization organization,User u) {
		String code;
		Organization organi;
		String name=u.getName();
		organization.setUserId(u.getId());
		organization.setUserName(name);
		Date date=new Date();
		organization.setCreateDate(date);
		code=RandomString.getCode(4);
		organi=orgRepository.findByCode(code);
		while(organi!=null) {
			code=RandomString.getCode(4);
			organi=orgRepository.findByCode(code);
		    
		}
		organization.setCode(code);
		organization=orgRepository.save(organization);
		return organization;
	}

}
