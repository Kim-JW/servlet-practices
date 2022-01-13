<%@page import="com.poscocit.guestbook.dao.GuestBookDao"%>
<%@page import="com.poscoict.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	Long no = Long.valueOf(request.getParameter("no"));
	String password = request.getParameter("password");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setNo(no);
	vo.setPassword(password);
	
	boolean result = new GuestBookDao().delete(vo);
	
	response.sendRedirect("/guestbook02/index.jsp");
	
%>