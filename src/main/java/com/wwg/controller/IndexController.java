package com.wwg.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		
		//获取cas给我们传递回来的对象，这个东西放到了session中
		//session的 key是 _const_cas_assertion_
		Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);  

		//获取登录用户名
		String loginName =assertion.getPrincipal().getName();
		System.out.printf("登录用户名:%s\r\n",loginName);
		System.out.printf("登录用户名=%s\r\n",request.getRemoteUser());
		//获取自定义返回值的数据
		Principal principal  = (AttributePrincipal) request.getUserPrincipal();
		if (request.getUserPrincipal() != null) {

		    if (principal instanceof AttributePrincipal) {
		        //cas传递过来的数据
		        Map<String,Object> result =( (AttributePrincipal)principal).getAttributes();
		        for(Map.Entry<String, Object> entry :result.entrySet()) {
		            String key = entry.getKey();
		            Object val = entry.getValue();
		            System.out.printf("%s:%s\r\n",key,val);
		        }
		    }
		}
			
		return "index";
	}
}
