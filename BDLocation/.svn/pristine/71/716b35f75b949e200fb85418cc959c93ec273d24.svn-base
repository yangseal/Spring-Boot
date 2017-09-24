package com.cnten.bdlocation.checkMard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cnten.platform.util.CheckMard;

@Controller
public class CheckMardController {
	@RequestMapping(value = "/checkMard/getChekMard")
	public void getChekMard(HttpServletRequest request, HttpServletResponse response){
		new CheckMard().getChekMard(request,response);
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkMard/check")
	public String chek(HttpServletRequest request){
		return new CheckMard().check(request);
	}
}
