package com.jqb.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public abstract class AbstactPagination<T> implements ResultSetExtractor<T> {
	private int pagesize;
	private int pageNo;

	public AbstactPagination(int pagesize, int pageNo) {
		this.pagesize = pagesize;
		this.pageNo = pageNo;
	}

	@Override
	public T extractData(ResultSet rs) throws SQLException, DataAccessException {
		int lowerBound = (pagesize * (pageNo - 1)) + 1;
		int upperBound = (lowerBound + pagesize);
		int counter = 1;
		T data = null;
		List<T> sheets = new ArrayList<T>();
		while (rs.next() && counter <= upperBound) {
			if (counter >= lowerBound && counter <= upperBound) {
				data = (T) getRows(rs);
				sheets.add((T) data);

			}
			counter++;

		}

		return (T) sheets;
	}

	public abstract Object getRows(ResultSet rs) throws SQLException;

}
