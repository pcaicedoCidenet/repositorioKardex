package com.kardex.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kardex.core.model.Product;
import com.kardex.core.services.ProductService;

@Controller
public class KardexController {
	
	@Autowired
	private ProductService productRepository;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("producto", this.productRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/findById")
	@ResponseBody
	public Product findProduct(@RequestParam int id) {
		
		return this.productRepository.findById(id);
	}
	
	@PostMapping("/update")
	public String update(@RequestParam int id, @RequestParam String name, @RequestParam int price, @RequestParam String category) {
		
		Product product = productRepository.findById(id);
		product.setPRODUCTNAME(name);
		product.setPRODUCTPRICE(price);
		product.setPRODUCTCATEGORY(category);
		productRepository.update(product);
		return "redirect:/";
	}
	
	@PostMapping("/new")
	public String newProduct(@RequestParam String name, @RequestParam int price, @RequestParam String category) {
		
			Product product = new Product();
			product.setPRODUCTNAME(name);
			product.setPRODUCTPRICE(price);
			product.setPRODUCTCATEGORY(category);
			productRepository.save(product);
			
			return "redirect:/";
	}
	
	@GetMapping("/sell")
	public String sellById(@RequestParam int id) {
		
		productRepository.deleteById(id);
		return "redirect:/";
	}
	
}
