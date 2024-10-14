package com.example.demo;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServletV2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (req.getRequestURI().equals("/")) {
			resp.setContentType("text/html");
			resp.getWriter()
					.print("<html><head></head><body><h1>Welcome!</h1><p>This is a very cool page!</p></body></html>");
		} else if (req.getRequestURI().startsWith("/api/users/")) {

			Integer prettyFragileUserId = Integer.valueOf(req.getRequestURI().lastIndexOf("/") + 1);

			resp.setContentType("application/json");

			// User user = dao.findUser(prettyFragileUserId)
			// actually: jsonLibrary.toString(user)
			resp.getWriter().print("{\n" + "  \"id\":" + prettyFragileUserId + ",\n" + "  \"age\": 55,\n" +
					"  \"name\" : \"John Doe\"\n" + "}");
		} else {
			throw new IllegalStateException("Help, I don't know what to do with this url");
		}
	}
}