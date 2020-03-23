package com.medical.shop.management.system.Medical.Managment.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.shop.management.system.Medical.Managment.Model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Product product = new Product();
		product.setProduct_id(resultSet.getInt(1));
		product.setProduct_name(resultSet.getString(2));
		product.setCompany_name(resultSet.getString(3));
		product.setProduct_price(resultSet.getFloat(4));
		product.setMfd_date(resultSet.getDate(5));
		product.setExp_date(resultSet.getDate(6));
		product.setQuantity(resultSet.getInt(7));
		product.setPurchase_date(resultSet.getDate(8));
		product.setProduct_type(resultSet.getString(9));
		product.setSupplier_name(resultSet.getString(10));
		return product;
	}

}
