package com.jqb.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JobSheetPagination extends AbstactPagination<List<JobsheetBo>>{
	//private int pageSize;
	//private int pageNo;
	public JobSheetPagination(int pagesize, int pageNo) {
		super(pagesize, pageNo);
		// TODO Auto-generated constructor stub
	}



	

	@Override
	public Object getRows(ResultSet rs) throws SQLException {
		JobsheetBo jbo = new JobsheetBo();
		jbo.setJobsheet_no(rs.getInt(1));
		jbo.setOpened_dt(rs.getDate(2));
		jbo.setJobsheet_type(rs.getString(3));
		jbo.setChachis_no(rs.getString(4));
		jbo.setEngine_no(rs.getString(5));
		jbo.setFuel_level(rs.getInt(6));
		
		return jbo;
	}
	
	

}
