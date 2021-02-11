package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")    //адресс класса
public class FirstController {

	@GetMapping("/helloPage")
	public String helloPage (HttpServletRequest request){   //передача параметров запроса( пример http://localhost:8081/first/helloPage?name=Tom&age=65)
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("Name: " + name + ", " + "age" + Integer.valueOf(age));		
		return "/first/hello_page";
	}
	
	@GetMapping("/goodbyePage")
	public String byePage (@RequestParam(name = "city", required = false) String city, 
								@RequestParam(name = "address") String address){
		System.out.println("City: " + city + ", " + "address" + address);		
		return "/first/bye_Page";
	}
	
}
