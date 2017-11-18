package com.jqb.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class CustomersDelegate {
	private JdbcTemplate jtemplete;
	private final String SQL_CUSTOMER_BY_MOBILE_NO = "select customer_no,first_nm,last_nm,email_addr from customer where mobile_no=?";
	private final String SQL_CUSTOMER = "select customer_no,first_nm,last_nm,email_addr,mobile_no from customer";
	private final String SQL_GET_CUSTOMS_FOR_JOBSHEET =
	"select c.CUSTOMER_NO,c.FIRST_NM,c.LAST_NM,c.EMAIL_ADDR,c.MOBILE_NO,js.JOBSHEET_NO,js.OPENED_DT,js.JOBSHEET_TYPE,js.CHACHIS_NO,js.ENGINE_NO,js.CUSTOMER_NO,js.FUEL_LEVEL from CUSTOMER c INNER join JOBSHEET js on c.CUSTOMER_NO=js.CUSTOMER_NO";
	private final String SQL_GET_JOBSHEET ="select js.JOBSHEET_NO,js.OPENED_DT,js.JOBSHEET_TYPE,js.CHACHIS_NO,js.ENGINE_NO,js.CUSTOMER_NO,js.FUEL_LEVEL from JOBSHEET js ORDER by js.JOBSHEET_NO desc";
	private final String SQL_GET_KEYS="insert into customers(FIRST_NM,LAST_NM,EMAIL_ADDR,MOBILE_NO) values(?,?,?,?)";
	
	
	public CustomersDelegate(JdbcTemplate jtemplete) {
		this.jtemplete = jtemplete;
	}

	public CustomerBo getCustomerByMobileNo(String mobile_no) {
		return jtemplete.queryForObject(SQL_CUSTOMER_BY_MOBILE_NO,
				new CustomerResultRowMapper(), new Object[] { mobile_no });

	}

	public List<CustomerBo> getAll() {
		return jtemplete.query(SQL_CUSTOMER, new CustomerResultRowMapper());
	}
	
	public List<CustomerJobSheetBo> getAllRecords() {
		/*return jtemplete.query(SQL_GET_CUSTOMS_FOR_JOBSHEET, new CustomerJobsheetRowExtractor());*/
		return jtemplete.query(SQL_GET_CUSTOMS_FOR_JOBSHEET, new CustomerJobSheetExtractor());
	}

	public List<JobsheetBo> getAll(int pagesize,int pageNo){
		return jtemplete.query(SQL_GET_JOBSHEET, new JobSheetPagination(pagesize, pageNo));
	}
	
	public final class CustomerResultRowMapper implements RowMapper<CustomerBo> {

		@Override
		public CustomerBo mapRow(ResultSet rs, int row) throws SQLException {
			CustomerBo cbo = new CustomerBo();
			cbo.setCustomer_no(rs.getInt(1));
			cbo.setFirst_nm(rs.getString(2));
			cbo.setLast_nm(rs.getString(3));
			cbo.setEmail_addr(rs.getString(4));
			cbo.setMobile_no(rs.getString(5));
			return cbo;
		}

	}
	

	public final class CustomerJobsheetRowExtractor implements
			ResultSetExtractor<List<CustomerJobSheetBo>> {

		@Override
		public List<CustomerJobSheetBo> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			CustomerBo cbo = null;
			JobsheetBo jbo = null;
			cbo = new CustomerBo();
			int key = 0;
			Map<Integer, CustomerJobSheetBo> customerinfoMap = null;
			customerinfoMap = new HashMap<Integer, CustomerJobSheetBo>();
			List<JobsheetBo> jobsheeets = null;
			CustomerJobSheetBo cjs = null;
			List<CustomerJobSheetBo> cjsbo = new ArrayList<CustomerJobSheetBo>();
			while (rs.next()) {
				key=rs.getInt(1);
				if (customerinfoMap.containsKey(key) == false) {
					cbo = new CustomerBo();
					cbo.setCustomer_no(rs.getInt(1));
					cbo.setFirst_nm(rs.getString(2));
					cbo.setLast_nm(rs.getString(3));
					cbo.setEmail_addr(rs.getString(4));
					cbo.setMobile_no(rs.getString(5));
					//key = cbo.getCustomer_no();
					jbo = new JobsheetBo();
					jbo.setJobsheet_no(rs.getInt(6));
					jbo.setOpened_dt(rs.getDate(7));
					jbo.setJobsheet_type(rs.getString(8));
					jbo.setChachis_no(rs.getString(8));
					jbo.setEngine_no(rs.getString(10));
					jbo.setFuel_level(rs.getInt(11));
					jobsheeets = new ArrayList<JobsheetBo>();
					cjs = new CustomerJobSheetBo();
					cjs.setCustomer(cbo);
					jobsheeets.add(jbo);
					cjs.setJobsheets(jobsheeets);
					customerinfoMap.put(key, cjs);
				} else {
					jbo = new JobsheetBo();
					jbo.setJobsheet_no(rs.getInt(6));
					jbo.setOpened_dt(rs.getDate(7));
					jbo.setJobsheet_type(rs.getString(8));
					jbo.setChachis_no(rs.getString(9));
					jbo.setEngine_no(rs.getString(10));
					jbo.setFuel_level(rs.getInt(11));
					//jobsheeets = cjsbo.get(key).getJobsheets();
					System.out.println("size :"+jobsheeets.size());
					jobsheeets.add(jbo);
					cjs.setJobsheets(jobsheeets);
					customerinfoMap.put(key, cjs);
					Set<Integer> keyset = customerinfoMap.keySet();
				//	System.out.println(keyset.toString());
					for (Integer keys : keyset) {
						cjsbo.add(customerinfoMap.get(keys));

					}

				}

			}

			return cjsbo;
		}
	

	}
	public  Object inset_getKeys(final CustomerBo cbo){
		GeneratedKeyHolder ghk=new GeneratedKeyHolder();
		Object customer_no=0;
		jtemplete.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement pstmt=null;
				pstmt=conn.prepareStatement(SQL_GET_KEYS, new String[]{"customer_no"});
				pstmt.setString(1,cbo.getFirst_nm());
				pstmt.setString(2, cbo.getLast_nm());
				pstmt.setString(3, cbo.getEmail_addr());
				pstmt.setString(4, cbo.getMobile_no());
				return pstmt;
			}
		},ghk);
		Map<String,Object> keyMap=ghk.getKeys();
		return customer_no=keyMap.get("customer_no");
		
		
	}
	public int insertRecords(){
		return jtemplete.update(SQL_GET_KEYS, new Object[]{"bunty","m","bunty@gmail.com","82929292929"});
	}
	

}
