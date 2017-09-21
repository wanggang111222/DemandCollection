package com.dc.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class Updatezj
 */
@WebServlet("/Updatezj")
public class Updatezj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatezj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		DatabaseConnection db = new DatabaseConnection();
		request.setCharacterEncoding("UTF-8");
		//String id = request.getParameter("OrganizationId");
		String OrganizationName = request.getParameter("OrganizationName");
		String adress = request.getParameter("adress");
		String suozaidiyu = request.getParameter("suozaidiyu");
		String website = request.getParameter("website");
		String mail = request.getParameter("mail");
		String legalPerson = request.getParameter("legalPerson");
		String postcode = request.getParameter("postcode");
		String connectionPerson = request.getParameter("connectionPerson");
		String tel = request.getParameter("tel");
		String phone = request.getParameter("phone");
		String fax = request.getParameter("fax");
		String property = request.getParameter("property");
		String Centralized = request.getParameter("Centralized");
		String info = request.getParameter("info");
		String requestName = request.getParameter("requestName");
		String firstYear=request.getParameter("first-year");
		String secondYear=request.getParameter("second-year");
		String requestInfo1 = request.getParameter("requestInfo1");
		String requestInfo2= request.getParameter("requestInfo2");
		String requestInfo3 = request.getParameter("requestInfo3");
		String keyword1 = request.getParameter("keyword1");
		String keyword2 = request.getParameter("keyword2");
		String keyword3 = request.getParameter("keyword3");
		String keyword4 = request.getParameter("keyword4");
		String keyword5 = request.getParameter("keyword5");
		String studyClassfied = request.getParameter("studyClassfied");
		//String subjectClassfied = request.getParameter("subjectClassfied");
		String subjectClassfied1 = request.getParameter("subjectClassfied1");
		String subjectClassfied2 = request.getParameter("subjectClassfied2");
		String subjectClassfied3 = request.getParameter("subjectClassfied3");
		String[] techArea = request.getParameterValues("techArea");
		
		String tech1 = request.getParameter("tech1");
		String tech2 = request.getParameter("tech2");
		String tech3 = request.getParameter("tech3");
		String tec_id = request.getParameter("tec_id");
		
		String techArea1 = "";
		if(!studyClassfied.equals("»ù´¡ÑÐ¾¿"))
		{
			for(int i = 0;i < techArea.length; i++)
			{ 
				techArea1 = techArea1 + techArea[i] + ",";
			}
			
		}
		
		
		String[] cooperation = request.getParameterValues("cooperation");
		String cooperativeUnit = request.getParameter("cooperativeUnit");
		String projectSum = request.getParameter("projectSum");
		//String self = request.getParameter("self");
		//String borrow = request.getParameter("borrow");
		//String other = request.getParameter("other");
		String xsCheck = "false";
		String jsCheck="false";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String currentTime=df.format(new Date());

		
		String cooperation1 = "";
		for(int i = 0;i < cooperation.length; i++)
		{ 
			cooperation1 = cooperation1 + cooperation[i] + ",";
		}
		String subjectClassfied =subjectClassfied1+","+subjectClassfied2+","+subjectClassfied3;
		String tech=tech1+","+tech2+","+tech3;
		String year=firstYear+","+secondYear;
		String keyword=keyword1+","+keyword2+","+keyword3+","+keyword4+","+keyword5;
       
		String CompanySQL = "UPDATE [dbo].[company]"
      +"SET [id] = '"+request.getSession().getAttribute("id")+"'"
      +",[name] = '"+OrganizationName+"'"
      +",[adress] = '"+adress+"'"
      +",[suozaidiyu] = '"+suozaidiyu+"'"
      +",[website] = '"+website+"'"
      +",[mail] = '"+mail+"'"
      +",[legalPerson] = '"+legalPerson+"'"
      +",[postcode] = '"+postcode+"'"
      +",[connectionPerson] = '"+connectionPerson+"'"
      +",[tel] = '"+tel+"'"
      +",[phone] = '"+phone+"'"
      +",[fax] = '"+fax+"'"
      +",[property] = '"+property+"'"
      +",[Centralized] = '"+Centralized+"'"
      +",[info] = '"+info+"'"
      +" WHERE tec_id='"+tec_id+"'";
		
		String tecneedSQL = "UPDATE [dbo].[tecneed]"
   +"SET [id] ='"+request.getSession().getAttribute("id")+"'"
     +",[name] = '"+OrganizationName+"'" 
      +",[requestName] = '"+requestName+"'"
     +" ,[year] = '"+year+"'"
      +",[requestInfo1] = '"+requestInfo1+"'"
      +",[requestInfo2] = '"+requestInfo2+"'"
      +",[requestInfo3] = '"+requestInfo3+"'"
      +",[keyword] = '"+keyword+"'"
      +",[studyClassfied] = '"+studyClassfied+"'"
      +",[subjectClassfied] = '"+subjectClassfied+"'"
      +",[techArea] = '"+techArea1+"'"
      +",[tech] = '"+tech+"'"
      +",[cooperation] = '"+cooperation1+"'"
      +",[cooperativeUnit] = '"+cooperativeUnit+"'"
      +",[projectSum] = '"+projectSum+"'"
      +",[xsCheck] = '"+xsCheck+"'"
      +",[jsCheck] = '"+jsCheck+"'"
      +",[tjTime] = '"+currentTime+"'"
      +" WHERE tec_id='"+tec_id+"'";
		Boolean j = db.executeUpdate(tecneedSQL);
		
	   response.sendRedirect("Check.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
