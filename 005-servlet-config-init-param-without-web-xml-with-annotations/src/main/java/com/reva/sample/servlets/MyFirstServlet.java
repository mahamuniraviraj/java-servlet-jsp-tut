/*-
 *  File    :   MyFirstServlet.java
 *  Version :   1.0
 *  Date    :   Mar 9, 2018
 *  Author  :   raviraj
 *
    This file is part of 001-hello-servlet.

    001-hello-servlet is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    001-hello-servlet is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with 001-hello-servlet.  If not, see <http://www.gnu.org/licenses/>.

 */
package com.reva.sample.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author raviraj
 * @date   Mar 9, 2018
 * @since  1.0
 */
@SuppressWarnings("serial")
@WebServlet(name = "MyFirstServlet", urlPatterns = { "/hi", "/s1", "/servlet1" },
		initParams = {
				@WebInitParam(name = "myParam1", value = "hello there"),
				@WebInitParam(name = "myParam2",
						value = "What is real? How do you define 'real'? If you're talking about what you can feel, what you can smell, what you can taste and see, then 'real' is simply electrical signals interpreted by your brain. ")
		})
public class MyFirstServlet extends HttpServlet {

	private static String param1;
	private static String param2;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		System.out.println(" Servlet 1 Initialised");

		param1 = config.getInitParameter("myParam1");
		param2 = config.getInitParameter("myParam2");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.getWriter().write("<h2>Hello World from Servlet : 1 ::</h2><br/><h2>" + LocalDateTime.now() + "</h2>");

		resp.getWriter().write("Init params are  param1: " + param1 + " and  param2 :" + param2);
	}

}
