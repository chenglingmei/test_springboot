package springboot.test_springboot.interceptor;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import springboot.test_springboot.controller.ResultCode;
import springboot.test_springboot.model.User;
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

	private static Logger log=Logger.getLogger(AuthorizationInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 String url=request.getRequestURI();
		log.info("请求处理前............:"+url);
			User user=(User)request.getSession().getAttribute("user");
			if(user==null) {
				ResultCode result=ResultCode.errorCode("1001","您还没有登录，请先登录");
				response.setCharacterEncoding("UTF-8");
				String resp=JSON.toJSONString(result);
				Writer write=response.getWriter();
				write.write(resp);
				write.flush();
				write.close();
				log.info("您没有登录请先登录............");
				return false;
			}
			
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("请求处理中...........:"+request.getRequestURI());
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("请求处理完成后.............:"+request.getRequestURI());
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	

}
