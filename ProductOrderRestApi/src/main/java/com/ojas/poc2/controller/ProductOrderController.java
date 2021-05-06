package com.ojas.poc2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.poc2.model.Message;
import com.ojas.poc2.model.Orders;
import com.ojas.poc2.model.Product;
import com.ojas.poc2.service.ProductOrdersService;


@RestController
@RequestMapping("/api/product")
public class ProductOrderController {
	
	@Autowired
	ProductOrdersService productservice;
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productservice.addProduct(product);
	}
	
	@GetMapping("/displayAllProducts")
	public Iterable<Product> getAllProducts() {
		return productservice.getAllProduct();
	}
	
	@GetMapping("/displayProduct/{product_id}")
	public Optional<Product> getProductById(@PathVariable("product_id") Integer product_Id) {
		return productservice.getProductById(product_Id);
	}
	
	@GetMapping("/displayAllOrders")
	public Iterable<Orders> getAllOrders(){
		return productservice.getAllOrders();
	}
	
	@GetMapping("/placeOrder")
	public Message placeOrder(@RequestParam("product_id") Integer product_id,@RequestParam("quantity") Integer quantity) {
		Message msg = new Message();
		Orders order = new Orders();
		int code=productservice.placeOrder(product_id,quantity,order);
		if(code == 0) {
			msg.setCode(code);
			msg.setMessage("sucess");
		}
		else {
			msg.setCode(code);
			msg.setMessage("unsucessful");
		}
		return msg;
	}
	
	@GetMapping("/updateOrder")
	public Message updateOrder(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
		Message msg = new Message();
		
		int code = productservice.updateOrder(id, quantity);
		
		if(code == 0) {
			msg.setCode(code);
			msg.setMessage("sucess");
		}
		else {
			msg.setCode(code);
			msg.setMessage("unsucessful");
		}
		return msg;
	}
	
	
	@DeleteMapping("/cancelOrder")
	public Message cancelOrder(@RequestParam("id") Integer id) {
		Message msg = new Message();
		
		int code = productservice.cancelOrder(id);
		
		if(code == 0) {
			msg.setCode(code);
			msg.setMessage("order cancelled");
		}
		else {
			msg.setCode(code);
			msg.setMessage("order not found");
		}
		
		return msg;
	}
	

}
