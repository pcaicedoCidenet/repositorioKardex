package com.kardex.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.kardex.core.mapper.ProductMapper;
import com.kardex.core.model.Product;
import com.kardex.core.repository.ProductRepo;

@Service
public class ProductService implements ProductRepo{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Product object) {
		
		try {
			String sql = String.format("insert into product(PRODUCTNAME, PRODUCTPRICE, PRODUCTCATEGORY) "
					+ "values('%s', '%d', '%s')", 
					object.getPRODUCTNAME(), object.getPRODUCTPRICE(), object.getPRODUCTCATEGORY());
			jdbcTemplate.execute(sql);
			return true;
		} catch (DataAccessException e) {
			
			return false;
		}
	}

	@Override
	public boolean update(Product object) {

		if(object.getPRODUCTID() != 0) {
			
			String sql = String.format("update kardex.product set PRODUCTNAME='%s', PRODUCTPRICE='%d', PRODUCTCATEGORY='%s' "
					+ "where PRODUCTID='%d'", 
					object.getPRODUCTNAME(), object.getPRODUCTPRICE(), object.getPRODUCTCATEGORY(), object.getPRODUCTID());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> productList = jdbcTemplate.query("select * from product", new ProductMapper());
		return productList;
	}

	public Product findById(int Id) {
		
		return jdbcTemplate.queryForObject("select * from product where PRODUCTID = ?", new Object[]{Id},new ProductMapper());

	}

	@Override
	public boolean deleteById(int Id) {
		
		try {
			String sql = String.format("delete from kardex.product where PRODUCTID='%d'",Id);
			jdbcTemplate.execute(sql);
			return true;
		} catch (DataAccessException e) {
			
			return false;
		}

	}
}
