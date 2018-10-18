package springboot.test_springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import springboot.test_springboot.model.Teacher;
import springboot.test_springboot.model.User;
import springboot.test_springboot.model.UserVo;
import springboot.test_springboot.service.TestService;
import springboot.test_springboot.service.UserService;
import springboot.test_springboot.utils.VerifyUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private TestService testService;
	@Autowired
	private UserService userService;

	@RequestMapping("/test")
	public Map hello() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "zhu");
		return map;

	}

	@RequestMapping("/test2")
	public User testUser() {
		User u = new User();
		u.setAge(20);
		u.setName("zhu");
		return u;
	}

	@RequestMapping("/test3")
	public Teacher testService() {
		return testService.select();

	}
	
    //注册用户
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResultCode addUser(@RequestBody User u,HttpServletRequest request) {

		// if(u.getName()==null||"".equals(u.getName())) {}

		if (StringUtils.isEmpty(u.getName()) || StringUtils.isEmpty(u.getPassword())
				|| StringUtils.isEmpty(u.getMobile())||StringUtils.isEmpty(u.getPassword2())) {
			return ResultCode.errorCode("必填数据不能为空");
		}

		boolean b = VerifyUtil.isMobileNO(u.getMobile());
		if (!b) {
			return ResultCode.errorCode("手机号格式不正确");
		}
		 
         ResultCode resultCode=userService.add(u);
         User user=(User)resultCode.getData();
         request.getSession().setAttribute("user", user);
         return resultCode;

	}

	@RequestMapping(value = "delUserById", method = RequestMethod.GET)
	public void delById(int id) {
		userService.delById(id);
	}

	@RequestMapping("findUsers")
	public ResultCode select(HttpServletRequest request) {
		boolean b=verify(request);
		if(b) {
			List<User> u = userService.select();
			return ResultCode.succese(u);
		}
		else return ResultCode.errorCode("您还没有登录，请先登录");
		
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResultCode update(@RequestBody User u,HttpServletRequest request) {
		boolean b=verify(request);
		if(b) {
			if (u == null) {
				return ResultCode.errorCode("修改的数据为空");
			}
			User user = userService.update(u);
			return ResultCode.succese(user);
		}
		else return ResultCode.errorCode("您还没有登录，请先登录");
		
	}

	@RequestMapping("findById")
	public ResultCode findById(int id, HttpServletRequest request) {
		boolean b=verify(request);
		if(b) {
			if (id <= 0) {
				return ResultCode.errorCode("id必须大于零");
			}
			User u = userService.findUserById(id);
			return ResultCode.succese(u);
		}
		else return ResultCode.errorCode("您还没有登录，请先登录");

	}

	@RequestMapping(value = "/findByPage", method = RequestMethod.GET)
	public ResultCode findByPage(int page, int size) {
		page = page > 0 ? page - 1 : page;
		if (page < 0) {
			return ResultCode.errorCode("null exption", "参数不能小于零");
		}
		PageBean pageBean = userService.findByPage(page, size);

		return ResultCode.succese(pageBean);
	}
	@Test
	public void test() {
		User u=new User();
		System.out.println(JSON.toJSONString(u, true));
		
	}
	@RequestMapping("login")
	public ResultCode login(@RequestBody User u,HttpServletRequest request) {
		ResultCode resultCode=userService.login(u);
		if(resultCode.getStatus()!=200) {
			return resultCode;
		}
		User user=(User)resultCode.getData();
		request.getSession().setAttribute("user", user);
		//因为对应的password不能返回给前端，所以重新建立了一个对象来接收从数据库中查询出来的用户信息
		UserVo userVo=new UserVo();
		userVo.setOrgCode(user.getOrgCode());
		userVo.setAge(user.getAge());
		userVo.setMobile(user.getMobile());
		userVo.setName(user.getName());
		resultCode.setData(userVo);
		
		return resultCode;
		
	}

	public 	boolean verify(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		return user!=null;
		
		
	
	}
}