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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
@WebServlet(name = "MySecondServlet", urlPatterns = { "/hello", "/s2", "/servlet2" })
public class MySecondServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setHeader("Content-Type", "text/html");

		ServletContext ctx = this.getServletContext();

		String msg = (String) ctx.getAttribute("msg");

		Sample sample = (Sample) ctx.getAttribute("you");

		ctx.setAttribute("me", new Sample("Raviraj", 21));

		ctx.setAttribute("msg", "Servlet 2 is called");

		if (msg == null && sample == null) {
			resp.getWriter().write("<a href='s1'>Visit Another path to set Context attributes </a>");
		} else {
			resp.getWriter().write("msg : " + msg + " and sample :: " + sample + "<br/>");

			resp.getWriter().write("<a href='index.html'> Visit Home </a>");
		}
		resp.getWriter().write("" + LocalDateTime.now() + "");

	}

}
