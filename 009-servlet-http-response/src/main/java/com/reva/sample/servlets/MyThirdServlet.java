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
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
@WebServlet(name = "MyThirdServlet", urlPatterns = "/s3")
public class MyThirdServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setHeader("Content-Type", "text/html");

		ServletOutputStream stream = resp.getOutputStream();

		// sending response as binary data : This just illustration of using
		// ServletOutputStream
		StringBuilder stringBuilder = new StringBuilder(250);
		stringBuilder.append("<html>                                           ");
		stringBuilder.append("<head>                                           ");
		stringBuilder.append("	<title> Reva on Java</title>                   ");
		stringBuilder.append("</head>                                          ");
		stringBuilder.append("<body>                                           ");
		stringBuilder.append("	<h1> This is a valid html response</h1>        ");
		stringBuilder.append("	<h3 style='color:red'>I am fiery Red</h3>     ");
		stringBuilder.append("</body>                                          ");
		stringBuilder.append("</html>                                          ");

		String outputString = stringBuilder.toString();

		byte[] data = outputString.getBytes(StandardCharsets.UTF_8);
		stream.write(data);

		stream.flush();
	}

}
