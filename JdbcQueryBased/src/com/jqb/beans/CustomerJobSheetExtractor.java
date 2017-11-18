package com.jqb.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerJobSheetExtractor implements
		ResultSetExtractor<List<CustomerJobSheetBo>> {

	@Override
	public List<CustomerJobSheetBo> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		CustomerBo cbo = null;
		JobsheetBo jbo = null;
		CustomerJobSheetBo customerjbo = null;
		List<CustomerJobSheetBo> listOfJobsheets = null;
		Map<Integer, CustomerJobSheetBo> mapcustomerjosheet = new HashMap<Integer, CustomerJobSheetBo>();
		List<JobsheetBo> jobsheets = null;
		int counter = 0;
		while (rs.next()) {
			counter = rs.getInt(1);
			if (mapcustomerjosheet.containsKey(counter)==false) {
				cbo = new CustomerBo();
				cbo.setCustomer_no(rs.getInt(1));
				cbo.setFirst_nm(rs.getString(2));
				cbo.setLast_nm(rs.getString(3));
				cbo.setEmail_addr(rs.getString(4));
				cbo.setMobile_no(rs.getString(5));
				// ///////////////////////////////
				jbo = new JobsheetBo();
				jbo.setJobsheet_no(rs.getInt(6));
				jbo.setOpened_dt(rs.getDate(7));
				jbo.setJobsheet_type(rs.getString(8));
				jbo.setChachis_no(rs.getString(8));
				jbo.setEngine_no(rs.getString(10));
				jbo.setFuel_level(rs.getInt(11));
				// /////////////////////////////////
				jobsheets = new ArrayList<JobsheetBo>();
				jobsheets.add(jbo);
				customerjbo = new CustomerJobSheetBo();
				customerjbo.setCustomer(cbo);
				customerjbo.setJobsheets(jobsheets);
				mapcustomerjosheet.put(counter, customerjbo);
			} else {
				jbo = new JobsheetBo();
				jbo.setJobsheet_no(rs.getInt(6));
				jbo.setOpened_dt(rs.getDate(7));
				jbo.setJobsheet_type(rs.getString(8));
				jbo.setChachis_no(rs.getString(8));
				jbo.setEngine_no(rs.getString(10));
				jbo.setFuel_level(rs.getInt(11));

				jobsheets = new ArrayList<JobsheetBo>();
				jobsheets = mapcustomerjosheet.get(counter).getJobsheets();
				jobsheets.add(jbo);
				/*mapcustomerjosheet.get(counter).setJobsheets(jobsheets);
				listOfJobsheets = new ArrayList<CustomerJobSheetBo>();
				for (Integer key : mapcustomerjosheet.keySet()) {
					
					listOfJobsheets.add(mapcustomerjosheet.get(key));
				}*/

			}
			mapcustomerjosheet.get(counter).setJobsheets(jobsheets);
			listOfJobsheets = new ArrayList<CustomerJobSheetBo>();
			for (Integer key : mapcustomerjosheet.keySet()) {
				
				listOfJobsheets.add(mapcustomerjosheet.get(key));
			}

		}

		return listOfJobsheets;
	}

}
