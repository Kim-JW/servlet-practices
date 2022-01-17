package com.poscoict.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscocit.guestbook.dao.GuestBookDao;
import com.poscoict.guestbook.vo.GuestBookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String actionName = request.getParameter("a");
		
		Long no = null;
		
		if (request.getParameter("no")!= null)
			no = Long.parseLong(request.getParameter("no"));

		if ("deleteform".equals(actionName)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			request.setAttribute("no", no);
			rd.forward(request, response);

		} else if ("add".equals(actionName)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
		 	String message = request.getParameter("message");
		 	
		 	GuestBookVo vo = new GuestBookVo();
		 	vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			boolean result = new GuestBookDao().insert(vo);

			response.sendRedirect(request.getContextPath() + "/gl");
		} else if ("delete".equals(actionName)) {
			
			String password = request.getParameter("password");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);
			vo.setPassword(password);
			
			boolean result = new GuestBookDao().delete(vo);
			response.sendRedirect(request.getContextPath() +"/gl");
			
		} else {
			GuestBookDao dao = new GuestBookDao();
			List<GuestBookVo> list = dao.findAll();

			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
