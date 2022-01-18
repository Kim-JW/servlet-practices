package main.java.helloweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet.service() called");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet.destroy() called");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet.init() called");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet.doGet(...) called");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet.do.poPost(...) called");
		doGet(request, response);
	}

}
