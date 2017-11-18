package com.jqb.beans;

import java.sql.Date;

public class JobsheetBo {
	private int jobsheet_no;
	private Date opened_dt;
	private String jobsheet_type;
	private String chachis_no;
	private String engine_no;
	private int fuel_level;

	public int getJobsheet_no() {
		return jobsheet_no;
	}

	public void setJobsheet_no(int jobsheet_no) {
		this.jobsheet_no = jobsheet_no;
	}

	public Date getOpened_dt() {
		return opened_dt;
	}

	public void setOpened_dt(Date opened_dt) {
		this.opened_dt = opened_dt;
	}

	public String getJobsheet_type() {
		return jobsheet_type;
	}

	public void setJobsheet_type(String jobsheet_type) {
		this.jobsheet_type = jobsheet_type;
	}

	public String getChachis_no() {
		return chachis_no;
	}

	public void setChachis_no(String chachis_no) {
		this.chachis_no = chachis_no;
	}

	public String getEngine_no() {
		return engine_no;
	}

	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	public int getFuel_level() {
		return fuel_level;
	}

	public void setFuel_level(int fuel_level) {
		this.fuel_level = fuel_level;
	}

	@Override
	public String toString() {
		return "JobsheetBo [jobsheet_no=" + jobsheet_no + ", opened_dt="
				+ opened_dt + ", jobsheet_type=" + jobsheet_type
				+ ", chachis_no=" + chachis_no + ", engine_no=" + engine_no
				+ ", fuel_level=" + fuel_level + "]";
	}

}
