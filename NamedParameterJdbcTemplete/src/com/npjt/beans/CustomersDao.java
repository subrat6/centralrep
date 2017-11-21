package com.npjt.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.npjt.bo.CustomersBo;

public class CustomersDao {
	private final String SQL_getAll_CUSTOMERS = "select customer_no,first_nm,last_nm,email_addr,mobile_no  from customers where first_nm like :f_name";
	private final String SQL_INSERT_CUSTOMERS="INSERT into CUSTOMERS(FIRST_NM,LAST_NM,email_addr,mobile_no) values(:first_nm,:last_nm,:email_addr,:mobile_no)";
	

	private NamedParameterJdbcTemplate templete;

	public CustomersDao(NamedParameterJdbcTemplate templete) {
		this.templete = templete;
	}
	public List<CustomersBo> getAll(String firstName){
		/*Map<String, Object> customerMap=new HashMap<String, Object>();
		customerMap.put("f_name", firstName+"%");*/
		MapSqlParameterSource source=new MapSqlParameterSource();
		source.addValue("f_name", firstName+"%");
		return templete.query(SQL_getAll_CUSTOMERS, source, new GetCutomers());
	}
	public int insertACustomer(CustomersBo cbo){
		BeanPropertySqlParameterSource source=new BeanPropertySqlParameterSource(cbo);
		return templete.update(SQL_INSERT_CUSTOMERS, source);
		
	}
	
	
	private final class GetCutomers implements RowMapper<CustomersBo> {

		@Override
		public CustomersBo mapRow(ResultSet rs, int row) throws SQLException {
			CustomersBo cbo=new CustomersBo();
			cbo.setCustomer_no(rs.getInt(1));
			cbo.setFirst_nm(rs.getString(2));
			cbo.setLast_nm(rs.getString(3));
			cbo.setEmail_addr(rs.getString(4));
			cbo.setMobile_no(rs.getString(5));
			return cbo;
		}
		
		
	}

}
