package maijiayunTips.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maijiayunTips.Dao.model.User;
import maijiayunTips.service.UserService;

@RestController
public class IndexController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("scanner")
	public Map<String, List<User>> getAll(){
		List<User> users=userService.select();
		Map<String,List<User>> map=new HashMap<>();
		map.put("data", users);
		return map;		
	}
	
	@RequestMapping("scanner1")
	public List<User> getAll(int id){
		List<User> users=userService.select(id);
		return users;		
	}
	@RequestMapping("scanner2")
	public List<User> getAll(String name){
		List<User> users=userService.select(name);
		return users;		
	}
	@RequestMapping("scanner3")
	public List<User> getAll(Date date){
		List<User> users=userService.select(date);
		return users;		
	}
	@RequestMapping("insert")
	public void insert(){
		User u=new User();
		
		userService.insert(u);
	}
	@RequestMapping("delete")
	public void delete(){
		User u=new User();
		
		userService.delete(u);
	}
	@RequestMapping("modify")
	public void modify(){
		User u=new User();
		
		userService.modify(u);
	}
	
}
