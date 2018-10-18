package springboot.test_springboot.controller.org;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import springboot.test_springboot.controller.ResultCode;
import springboot.test_springboot.model.Organization;
import springboot.test_springboot.model.User;
import springboot.test_springboot.service.UserService;
import springboot.test_springboot.service.org.OrgService;

@RestController
@RequestMapping("/org")
public class OrgController {
	@Autowired
	private OrgService orgService;
	@Autowired
	private UserService userService;
	@RequestMapping("addOrg")
	public ResultCode addOrg(@RequestBody Organization organization, HttpServletRequest request) {
		User u=(User)request.getSession().getAttribute("user");
		organization=orgService.addOrgnization(organization,u);
		u.setOrgId(organization.getId());
		u.setOrgCode(organization.getCode());
		userService.update(u);
		return ResultCode.succese();
		
	}
	//获取JESON数据格式
	public void  joinOrg() {
		
	}
	@Test
	public void test() {
		Organization org=new Organization();
		org.setCode("345");
		org.setEmail("selina_java@jkgnkd.com");
		org.setUserName("邓");
		org.setName("积成电子");
		
		System.out.println(JSON.toJSONString(org,true));
	}

}
