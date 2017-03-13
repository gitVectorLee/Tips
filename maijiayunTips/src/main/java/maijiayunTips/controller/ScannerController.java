package maijiayunTips.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import maijiayunTips.Dao.model.User;

@Controller
public class ScannerController {
	 @RequestMapping("index")
	 public String web(Map<String,Object> model){ 
			User u=new User();
			u.setName("管理员");
			model.put("name", u.getName());
			return "index";
			
	 }
}
