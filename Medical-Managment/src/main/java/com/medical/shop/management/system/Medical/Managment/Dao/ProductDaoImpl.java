package com.medical.shop.management.system.Medical.Managment.Dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.medical.shop.management.system.Medical.Managment.Model.Product;
import com.medical.shop.management.system.Medical.Managment.RowMapper.ProductRowMapper;

@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<String> getProductTypeList() {
		String sql = "SELECT product_type FROM product GROUP BY product_type ORDER BY product_type";
		List<String> query;
		try {
			query = jdbcTemplate.queryForList(sql, String.class);
		}
		catch (Exception e) {
			return null;
		}
		return query;
	}

	@Override
	public List<Product> getProductList(Product product) {
		String sql = "SELECT * FROM product WHERE product_type = ?";
		ProductRowMapper productRowMapper = new ProductRowMapper();
		List<Product> query;
		try{
			query = jdbcTemplate.query(sql, productRowMapper, product.getProduct_type());			
		}
		catch (Exception e) {
			query = new ArrayList<>();
		}
		return query;
	}

	@Override
	public List<String> getProductsName() {
		String sql = "SELECT product_name FROM product";
		List<String> query;
		try {
			query = jdbcTemplate.queryForList(sql, String.class);
		}
		catch (Exception e) {
			return null;
		}
		return query;
	}

	@Override
	public Product getProductByName(String product_name) {
		String sql = "select * from product where product_name = ?";
		ProductRowMapper productRowMapper = new ProductRowMapper();
		Product product = new Product();
		try {
			product = jdbcTemplate.queryForObject(sql, productRowMapper, product_name);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return product;
	}

	@Override
	public int updateQuantityByProductName(String product_name, int quantity) {
		Product product = getProductByName(product_name);
		if(product != null) {
			quantity += product.getQuantity();
		}
		String sql = "update product set quantity = ? where product_name = ?";
		try {
			jdbcTemplate.update(sql, quantity, product_name);
		} catch (Exception e) {
			return -1;
		}
		return quantity;
	}

	@Override
	public int deleteQunatityByProductName(String product_name, int quantity) {
		Product product = getProductByName(product_name);
		if(product != null && product.getQuantity() >= quantity) {
			quantity = product.getQuantity() - quantity;
		}
		String sql = "update product set quantity = ? where product_name = ?";
		try {
			jdbcTemplate.update(sql, quantity, product_name);
		} catch (Exception e) {
			return -1;
		}
		return quantity;
	}

	public List<String> getSupplierList()
	{
		String sql = "SELECT supplier_name FROM supplier";
		List<String> mp;
		//SupplierRowMapper supplierRowMapper = new SupplierRowMapper();
		try
		{
			mp = jdbcTemplate.queryForList(sql, String.class);
		}
		catch (Exception e) {
			mp = new ArrayList<>();
		}
		return mp;
	}
	
	@Override
	public boolean addProductDB(Product product)
	{
		String sql = "INSERT INTO product(product_name,company_name,product_price,mfd_date,exp_date,quantity,purchase_date,product_type,supplier_name) VALUES(?,?,?,?,?,?,?,?,?)";
		int report=0;
		try
		{
			report  = jdbcTemplate.update(sql, product.getProduct_name(),product.getCompany_name(),product.getProduct_price(),
					product.getMfd_date(),product.getExp_date(),product.getQuantity(),product.getPurchase_date(),product.getProduct_type(),
					product.getSupplier_name());
			//System.out.println("Adding data to the database");
		}
		catch(Exception e)
		{
			report = 0;
			System.out.println(e);
		}
		if(report == 0)
		{
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean deleteProduct(Product product)
	{
		String sql = "DELETE FROM product where product_name = ?";
		int result = 0;
		try
		{
			result = jdbcTemplate.update(sql, product.getProduct_name());
		}
		catch(Exception e)
		{
			result = 0;
		}
		if (result == 0)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		String sql = "update product set company_name = ?, product_price = ?, mfd_date = ?, exp_date = ?, quantity = ?, purchase_date = ?, product_type = ?, supplier_name = ? where product_name = ?";
		System.out.println(product);
		try {
			jdbcTemplate.update(sql, product.getCompany_name(), product.getProduct_price(), product.getMfd_date(), product.getExp_date(), product.getQuantity(), product.getPurchase_date(), product.getProduct_type(), product.getSupplier_name(), product.getProduct_name());
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
