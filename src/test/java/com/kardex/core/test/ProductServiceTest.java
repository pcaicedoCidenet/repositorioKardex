package com.kardex.core.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kardex.core.model.Product;
import com.kardex.core.services.ProductService;

@SpringBootTest
class ProductServiceTest {
	
	@Autowired
	private ProductService productRepository;
	
	@Test
	public void saveTest() {
		
		Product testProduct = new Product();
		testProduct.setPRODUCTNAME("VasoCapitan");
		testProduct.setPRODUCTPRICE(20000);
		testProduct.setPRODUCTCATEGORY("Vasos");
		boolean expectedResult = true;
		boolean result = productRepository.save(testProduct);
		assertEquals(expectedResult,result);
		
	}
	
	@Test
	public void updateTest() {
		
		Product testProduct = new Product();
		testProduct.setPRODUCTID(1);
		testProduct.setPRODUCTNAME("VasoCapitan");
		testProduct.setPRODUCTPRICE(20000);
		testProduct.setPRODUCTCATEGORY("Vasos");
		boolean expectedResult = true;
		boolean result = productRepository.update(testProduct);
		assertEquals(expectedResult,result);
		
	}
	
	@Test
	public void deleteTest() {
		
		boolean expectedResult = true;
		boolean result = productRepository.deleteById(1);
		assertEquals(expectedResult,result);
		
	}
}
