package com.grocerystore.controller;

import com.grocerystore.service.CategoryService;
import com.grocerystore.service.CustomerService;
import com.grocerystore.service.MemberService;
import com.grocerystore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminConsoleController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private OrderService orderService;
        
        @Autowired
        private CategoryService categoryService; 
	
	/**
	 * Auth process
	 */
	@RequestMapping(value = "/login", method= RequestMethod.GET )
	public String loginConsole(@RequestParam(value = "error", required = false) boolean error, ModelMap mm) {
		if(error == true) {
			mm.put("message", "Login Failed!");
		} else {
			mm.put("message", false);
		}
		return "admin_console/login";
	}
	
	/**
	 * Login succeeded, inside AdminConsole
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String customerConsole(ModelMap mm) {
		mm.put("customerList", customerService.getAll());
		return "admin_console/customer";
	}
        
        
        
        
        @RequestMapping(value = "/category", method = RequestMethod.GET)
        public String categoryConsole(ModelMap mm) {
            mm.put("categoryList", categoryService.getAll());
            return "admin_console/category";
        }
        
        
        
        
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String memberConsole(ModelMap mm) {
		mm.put("memberList", memberService.getAll());
		return "admin_console/member";
	}
        
        
        
        
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderConsole(ModelMap mm) {
		mm.put("orderList", orderService.getAll());
		return "admin_console/order";
	}
	
}
