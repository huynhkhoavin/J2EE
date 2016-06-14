package com.grocerystore.controller;

import com.grocerystore.service.CategoryService;
import com.grocerystore.service.CustomerService;
import com.grocerystore.service.MemberService;
import com.grocerystore.service.OrderService;
import com.grocerystore.service.ProductService;
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
	
        @Autowired
        private ProductService productService;
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

    /**
    * Customer
    */
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customerConsole(ModelMap mm) {
        mm.put("customerList", customerService.getAll());
        return "admin_console/customer";
    }
        
    @RequestMapping(value = "/inscus", method = RequestMethod.GET)
	public String insertCustomer(ModelMap mm) {
                mm.put("customerList", customerService.getAll());
		return "admin_console/customer_insert";
	}
        
    @RequestMapping(value = "/detcus", method = RequestMethod.GET)
	public String customerDetail(@RequestParam("id") Integer id, ModelMap mm) {
                mm.put("customerID", id);
                mm.put("customerList", customerService.getAll());
                mm.put("customer",customerService.getById(id));
		return "admin_console/customer_detail";
	}
        
    @RequestMapping(value = "/delcus", method = RequestMethod.GET)
    public String custdelete(@RequestParam("id") Integer id, ModelMap mm) {
            mm.put("customerList", customerService.getAll());
		return "admin_console/customer";
	}
        
    @RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
    public String editCustomer(ModelMap mm,
            @RequestParam("id") String id, 
            @RequestParam("name") String name,
            @RequestParam("mail") String mail,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("num") String num) {
            mm.put("customerID", id);
//            mm.put("customerList", customerService.getAll());
            return "admin_console/";
    }
        
    /**
    * Product
    */
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String productConsole(ModelMap mm) {
        mm.put("productList", productService.getAll());
        return "admin_console/product";
    }
    @RequestMapping(value = "/inspro", method = RequestMethod.GET)
    public String insertProduct(ModelMap mm) {
            mm.put("productList", productService.getAll());
            return "admin_console/product_insert";
    }
        
    @RequestMapping(value = "/detpro", method = RequestMethod.GET)
	public String detailProduct(@RequestParam("id") Integer id, ModelMap mm) {
                mm.put("productID", id);
                mm.put("productList", productService.getAll());
                mm.put("product",productService.getById(id));
		return "admin_console/product_detail";
	}
        
    @RequestMapping(value = "/delpro", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") Integer id, ModelMap mm) {
            mm.put("productList", productService.getAll());
		return "admin_console/product";
	}
        
    @RequestMapping(value = "/editProduct", method = RequestMethod.GET)
    public String editProduct(ModelMap mm,
            @RequestParam("id") Integer id, 
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("desc") String description) {
            mm.put("productID", id);
            mm.put("productList", productService.getAll());
            return "admin_console/product_detail";
    }

    /**
    * Category
    */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String categoryConsole(ModelMap mm) {
        mm.put("categoryList", categoryService.getAll());
        return "admin_console/category";
    }
    @RequestMapping(value = "/inscat", method = RequestMethod.GET)
    public String insertCategory(ModelMap mm) {
            mm.put("categoryList", categoryService.getAll());
            return "admin_console/member_insert";
    }
        
    @RequestMapping(value = "/detcat", method = RequestMethod.GET)
	public String detailCategory(@RequestParam("id") Integer id, ModelMap mm) {
                mm.put("categoryID", id);
                mm.put("categoryList", categoryService.getAll());
//                mm.put("category",categoryService.getById(id));
		return "admin_console/category_detail";
	}
        
    @RequestMapping(value = "/delcat", method = RequestMethod.GET)
    public String deleteCategory(@RequestParam("id") Integer id, ModelMap mm) {
            mm.put("categoryList", categoryService.getAll());
		return "admin_console/category";
	}
        
    @RequestMapping(value = "/editCategory", method = RequestMethod.GET)
    public String editCategory(ModelMap mm,
            @RequestParam("id") Integer id, 
            @RequestParam("name") String name) {
            mm.put("categoryID", id);
            mm.put("categoryList", categoryService.getAll());
            return "admin_console/category_detail";
    }
        
        
    /**
    * Member
    */
    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public String memberConsole(ModelMap mm) {
            mm.put("memberList", memberService.getAll());
            return "admin_console/member";
    }
    @RequestMapping(value = "/insmem", method = RequestMethod.GET)
    public String insertMember(ModelMap mm) {
            mm.put("memberList", memberService.getAll());
            return "admin_console/member_insert";
    }
        
    @RequestMapping(value = "/detmem", method = RequestMethod.GET)
	public String detailMember(@RequestParam("id") Integer id, ModelMap mm) {
                mm.put("memberID", id);
                mm.put("memberList", memberService.getAll());
                mm.put("member",memberService.getById(id));
		return "admin_console/member_detail";
	}
        
    @RequestMapping(value = "/delmem", method = RequestMethod.GET)
    public String deleteMember(@RequestParam("id") Integer id, ModelMap mm) {
            mm.put("memberList", memberService.getAll());
		return "admin_console/member";
	}
        
    @RequestMapping(value = "/editMember", method = RequestMethod.GET)
    public String editMember(ModelMap mm,
            @RequestParam("id") String id, 
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("status") String status,
            @RequestParam("role") String role) {
            mm.put("memberID", id);
            mm.put("memberList", memberService.getAll());
            return "admin_console/member_detail";
    }
    /**
    * Order
    */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String orderConsole(ModelMap mm) {
            mm.put("orderList", orderService.getAll());
            return "admin_console/order";
    }
    @RequestMapping(value = "/insord", method = RequestMethod.GET)
    public String insertOrder(ModelMap mm) {
            mm.put("orderList", orderService.getAll());
            return "admin_console/order_insert";
    }
        
    @RequestMapping(value = "/detord", method = RequestMethod.GET)
	public String detailOrder(@RequestParam("id") Integer id, ModelMap mm) {
                mm.put("orderID", id);
                mm.put("orderList", orderService.getAll());
//                mm.put("order",orderService.getById(id));
		return "admin_console/order_detail";
	}
        
    @RequestMapping(value = "/delord", method = RequestMethod.GET)
    public String deleteOrder(@RequestParam("id") Integer id, ModelMap mm) {
            mm.put("orderList", orderService.getAll());
		return "admin_console/order";
	}
        
    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
    public String editOrder(ModelMap mm,
            @RequestParam("id") Integer id, 
            @RequestParam("prod") String prod,
            @RequestParam("order") String order,
            @RequestParam("num") String quantity) {
            mm.put("orderID", id);
            mm.put("orderList", orderService.getAll());
            return "admin_console/order_detail";
    }
    
}
