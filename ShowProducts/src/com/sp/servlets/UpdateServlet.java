package com.sp.servlets;

import com.sp.beans.Products;
import com.sp.dao.UpdateProductDao;
import com.sp.util.Cache;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;














@WebServlet({"/UpdateServlet"})
public class UpdateServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public UpdateServlet() {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    PrintWriter out = response.getWriter();
    String productcode = null;
    String productname = null;
    String productprice = null;
    Cache cache = Cache.getInstance();
    productcode = request.getParameter("productno");
    productname = request.getParameter("productname");
    productprice = request.getParameter("productprice");
    Products pros = new Products();
    pros.setProductcode(Integer.parseInt(productcode));
    pros.setProductname(productname);
    pros.setProductprice(Double.parseDouble(productprice));
    UpdateProductDao upd = new UpdateProductDao();
    upd.update(pros);
    cache.clear();
    RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
    rd.forward(request, response);
  }
}
