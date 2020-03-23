package com.medical.shop.management.system.Medical.Managment.Dao;

import java.util.List;

import com.medical.shop.management.system.Medical.Managment.Model.Product;

public interface ProductDao {

	public List<String> getProductTypeList();

	public List<Product> getProductList(Product product);

	public List<String> getProductsName();

	public Product getProductByName(String product_name);

	public int updateQuantityByProductName(String product_name, int quantity);

	public int deleteQunatityByProductName(String product_name, int quantity);

	public List<String> getSupplierList();

	public boolean addProductDB(Product product);

	public boolean deleteProduct(Product product);
	
	public boolean updateProduct(Product product);
}
