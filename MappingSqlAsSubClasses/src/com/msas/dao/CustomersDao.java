package com.msas.dao;

import javafx.animation.KeyValue.Type;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.msas.bo.CustomersBo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class CustomersDao {
	private final String SQL_INSERT_CUSTOMERS = "INSERT into CUSTOMERS(FIRST_NM,LAST_NM,email_addr,mobile_no) values(:first_nm,:last_nm,:email_addr,:mobile_no)";
	private final String SQL_getAll_CUSTOMERS = "select customer_no,first_nm,last_nm,email_addr,mobile_no  from customers where first_nm like :f_name";
	private DataSource datasource;
	private InsertCustomers insertCustomers;
	private GetAllCustomers customers;

	/*public CustomersDao(DataSource datasource) {
		this.datasource = datasource;
		insertCustomers = new InsertCustomers(datasource, SQL_INSERT_CUSTOMERS);
	}*/
	public CustomersDao(DataSource datasource) {
		this.datasource = datasource;
		customers=new GetAllCustomers(datasource, SQL_getAll_CUSTOMERS);
		
		
	}
	

	public int save(CustomersBo bo) {
		return insertCustomers.save(bo);
	}
	
	public List<CustomersBo> getAll(String firstname){
		return customers.execute(new Object[]{"%"+firstname+"%"});
		
	}

	

	private final class InsertCustomers extends SqlUpdate {

		public InsertCustomers(DataSource ds, String sql) {
			super(ds, sql);
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}

		public int save(CustomersBo bo) {
			return super.update(new Object[] { bo.getFirst_nm(),
					bo.getLast_nm(), bo.getEmail_addr(), bo.getMobile_no() });

		}

	}
	
	public final class GetAllCustomers extends MappingSqlQuery<CustomersBo>{
		

		public GetAllCustomers(DataSource ds, String sql) {
			super(ds, sql);
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
			
		}

		@Override
		protected CustomersBo mapRow(ResultSet rs, int row)
				throws SQLException {
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
