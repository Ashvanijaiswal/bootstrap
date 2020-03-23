package com.medical.shop.management.system.Medical.Managment.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.shop.management.system.Medical.Managment.Model.Supplier;

public class SupplierRowMapper implements RowMapper<Supplier> {

	@Override
	public Supplier mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Supplier supplier = new Supplier();
		supplier.setSupplier_id(resultSet.getInt(1));
		supplier.setSupplier_name(resultSet.getString(2));
		supplier.setSupplier_contact_no(resultSet.getString(3));
		supplier.setSupplier_email_id(resultSet.getString(4));
		return supplier;
		
	}

}
