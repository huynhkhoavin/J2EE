package com.grocerystore.controller;

import com.grocerystore.service.CategoryService;
import com.grocerystore.service.CustomerService;
import com.grocerystore.service.MemberService;
import com.grocerystore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
	public String homeConsole(ModelMap mm) {
		return "admin_console/home";
	}
        
        
        @RequestMapping(value = "/customer", method = RequestMethod.GET)
        public String customerConsole(ModelMap mm) {
            mm.put("customerList", customerService.getAll());
            return "admin_console/customer";
        }
        
        @RequestMapping(value = "/insertCustomer", method = RequestMethod.GET)
	public String insertCustomer(ModelMap mm) {
                mm.put("customerList", customerService.getAll());
		return "admin_console/customer_insert";
	}
        
        @RequestMapping(value = "/custdetail", method = RequestMethod.GET)
	public String customerDetail(@RequestParam("id") Integer id, ModelMap mm) {
                mm.put("custID", id);
                mm.put("customerList", customerService.getAll());
                mm.put("cust",customerService.getById(id));
		return "admin_console/customer_detail";
	}
        
        @RequestMapping(value = "/custdelete", method = RequestMethod.GET)
        public String custdelete(@RequestParam("id") Integer id, ModelMap mm) {
                mm.put("customerList", customerService.getAll());
		return "admin_console/customer";
	}
        
        @RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public String editCustomer(
                @RequestParam("id") String id, 
                @RequestParam("name") String name,
                @RequestParam("mail") String mail,
                @RequestParam("phone") String phone,
                @RequestParam("address") String address,
                @RequestParam("city") String city,
                @RequestParam("num") String num,
                ModelMap mm) {
//		mm.put("test", id);
                System.out.println("****************************************");
                System.out.println("****************************************");
                System.out.println(id);
                System.out.println("****************************************");
                System.out.println("****************************************");
                mm.put("custID", id);
                mm.put("customerList", customerService.getAll());
		return "admin_console/customer_edit";
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
