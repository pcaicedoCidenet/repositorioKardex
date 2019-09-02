package com.kardex.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kardex.core.model.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Product product = new Product();
		product.setPRODUCTID(rs.getInt("PRODUCTID"));
		product.setPRODUCTNAME(rs.getString("PRODUCTNAME"));
		product.setPRODUCTPRICE(rs.getInt("PRODUCTPRICE"));
		product.setPRODUCTCATEGORY(rs.getString("PRODUCTCATEGORY"));
		return product;
	}

}
