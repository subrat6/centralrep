package com.jm.servlets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.wrox.book.types.Auther;
import com.wrox.book.types.Book;
import com.wrox.book.types.Publisher;

/**
 * Servlet implementation class MarshallerServlet
 */
@WebServlet("/MarshallerServlet")
public class MarshallerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarshallerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("started");
		String isbn1=request.getParameter("isbn");
		int iisbn=Integer.parseInt(isbn1);
		String tittle=request.getParameter("tittle");
		String authername=request.getParameter("authername");
		String dob=request.getParameter("dob");
		String pubname=request.getParameter("pubname");
		String pubdt=request.getParameter("pubdt");
		/*Date publisheddt=null;
		GregorianCalendar cal=null;
	    XMLGregorianCalendar xmlGregCal =null;*/
	    XMLGregorianCalendar resultpubdt =null;
	    XMLGregorianCalendar resultdob =null;
		try {
			
			/*publisheddt=new SimpleDateFormat("yyyy-MM-dd").parse(pubdt);
			cal = new GregorianCalendar();
			cal.setTime(publisheddt);
			xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
*/			
			resultpubdt = DatatypeFactory.newInstance().newXMLGregorianCalendar(pubdt);
			resultdob = DatatypeFactory.newInstance().newXMLGregorianCalendar(dob);
			//Date dofbirth=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Publisher pb=new Publisher();
		pb.setPublisherName(pubname);
		pb.setEstDt(resultpubdt);
		Auther auther=new Auther();
		auther.setAutherName(authername);
		auther.setDateOfBirth(resultdob);
		Book book=new Book();
		book.setIsbn(iisbn);
		book.setTitle(tittle);
		book.setAuther(auther);
		book.setPublisher(pb);
		JAXBContext jcontext=null;
		Marshaller marshaller=null;
		
		try {
			jcontext=JAXBContext.newInstance("com.wrox.book.types");
			marshaller=jcontext.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			marshaller.marshal(book,new FileOutputStream("E:/marshall.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("Reading complete");
		
	}

}
