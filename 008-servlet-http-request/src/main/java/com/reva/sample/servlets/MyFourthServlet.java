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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet(name = "My Fourth Servlet", urlPatterns = "/s4")
public class MyFourthServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StringBuilder op = new StringBuilder();
		BufferedReader inputStream = req.getReader();

		String contentLine = inputStream.readLine();
		while (contentLine != null) {
			op.append(contentLine);
			contentLine = inputStream.readLine();

		}

		resp.setHeader("Content-Type", "text/html");

		PrintWriter pw = resp.getWriter();

		pw.append("<hr/>");

		pw.append("<h2> Read Request using <Strong>BufferedReader</strong></h2>");
		pw.append("<p> " + op.toString() + " </p>");

		pw.append("<hr/>");

		MyUtils.sendReqInfo(req, pw);

		pw.append("<h3><a href='index.html'> Home </a></h3>");
	}

}
