package com.dc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.data.DatabaseConnection;

/**
 * Servlet implementation class QuanxianFenpei
 */
@WebServlet("/QuanxianFenpei")
public class QuanxianFenpei extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanxianFenpei() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("users");
		String[] qx=request.getParameterValues("qx");
		String xqzj="1",xqgl="1",yhxx="1",yhxg="1",xssh="1",bmsh="1",tjcx="1",power="0";
		
		
		DatabaseConnection db = new DatabaseConnection();
		
        for(int i=0;i<qx.length;i++)
        {
        	if(qx[i].equals("��������"))
        	{
        		xqzj="0";
        	}
        	else if(qx[i].equals("�������"))
        	{
        		xqgl="0";
        	}
        	else if(qx[i].equals("�û���Ϣ"))
        	{
        		yhxx="0";
        	}
        	else if(qx[i].equals("�޸�����"))
        	{
        		yhxg="0";
        	}
        	else if(qx[i].equals("��ʽ���"))
        	{
        		xssh="0";
        	}
        	else if(qx[i].equals("�������"))
        	{
        		bmsh="0";
        	}
        	else if(qx[i].equals("ͳ�Ʋ�ѯ"))
        	{
        		tjcx="0";
        	}
        }
        
        String sql="UPDATE [dbo].[users] set  [xqzj_qx] ='"+xqzj+"'"
      +",[xqgl_qx] = '"+xqgl+"'"
      +",[yhxx_qx] = '"+yhxx+"'"
      +",[yhxg_qx] = '"+yhxg+"'"
      +",[xssh_qx] = '"+xssh+"'"
      +",[bmsh_qx] = '"+bmsh+"'"
      +",[tjcx_qx] = '"+tjcx+"'"
      +",[power] = '"+power+"'"
      +" where userName='"+userName+"'";
        db.executeUpdate(sql);
        
       response.sendRedirect("User_gl.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
