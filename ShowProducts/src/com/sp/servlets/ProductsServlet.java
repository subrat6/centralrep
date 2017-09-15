package com.sp.servlets;

import com.sp.beans.Products;
import com.sp.dao.ProductsDao;
import com.sp.util.Cache;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;













@WebServlet({"/ProductsServlet"})
public class ProductsServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public ProductsServlet() {}
  
  protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    List<Products> listproducts = null;
    Cache cache = null;
    ProductsDao pdao = null;
    PrintWriter out = response.getWriter();
    out.println("hello");
    String type = null;
    String category = null;
    type = request.getParameter("type");
    if (type.equalsIgnoreCase("category")) {
      category = request.getParameter("category");
      out.println("Products category =" + category);
      cache = Cache.getInstance();
      if (!cache.ContainsKey(category + ".product")) {
        System.out.println(category + ".product");
        pdao = new ProductsDao();
        try {
          listproducts = pdao.getProducts(category);
        }
        catch (Exception e) {
          out.println("Data is not fetch from dao");
        }
        if (listproducts != null) {
          cache.put(category + ".product", listproducts);
        } else {
          out.println("listproducts is empty");
        }
        
      }
      else if (cache != null) {
        listproducts = (List)cache.get(category + ".product");
      } else {
        out.println("Cache is empty");
      }
      
      request.setAttribute("lifestyleproduct", listproducts);
      RequestDispatcher rd = request.getRequestDispatcher("/lifestyle.jsp");
      rd.forward(request, response);
    }
    else {
      out.println("Products not found");
    }
  }
}
