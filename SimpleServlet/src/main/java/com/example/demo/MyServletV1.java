package com.example.demo;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServletV1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		if (req.getRequestURI().equals("/")) {
			resp.setContentType("text/html");
			resp.setContentType("text/html");
			resp.getWriter()
					.print("<html><head></head><body><h1>Welcome!</h1><p>This is a very cool page!</p></body></html>");
		} else {
			throw new IllegalStateException("Help, I don't know what to do with this url");
		}

	}

}
