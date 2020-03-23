package com.medical.shop.management.system.Medical.Managment.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Product {
	
	private int product_id;
	@NotEmpty(message = "product name  is required")
	private String product_name;
	@NotEmpty(message = "company  is required")
	private String company_name;
	private float product_price;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 @NotEmpty(message = "Please provide a date.")
	@PastOrPresent
	private Date mfd_date;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 @NotEmpty(message = "Please provide a date.")
	@FutureOrPresent
	private Date exp_date;
	@Min(value = 0L, message = "The value must be positive")
	private int quantity;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	 @NotEmpty(message = "Please provide a date.")
	@PastOrPresent
	private Date purchase_date;
	private String product_type;
	@NotEmpty(message = "suplier name  is required")
	private String supplier_name;

	public Product(int product_id, String product_name, String company_name, float product_price, Date mfd_date,
			Date exp_date, int quantity, Date purchase_date, String product_type, String supplier_name) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.company_name = company_name;
		this.product_price = product_price;
		this.mfd_date = mfd_date;
		this.exp_date = exp_date;
		this.quantity = quantity;
		this.purchase_date = purchase_date;
		this.product_type = product_type;
		this.supplier_name = supplier_name;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	public Date getMfd_date() {
		return mfd_date;
	}

	public void setMfd_date(Date mfd_date) {
		this.mfd_date = mfd_date;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", company_name=" + company_name
				+ ", product_price=" + product_price + ", mfd_date=" + mfd_date + ", exp_date=" + exp_date
				+ ", quantity=" + quantity + ", purchase_date=" + purchase_date + ", product_type=" + product_type
				+ ", supplier_supplier_id=" + supplier_name + "]";
	}

}
