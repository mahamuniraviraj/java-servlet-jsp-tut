/*-
 *  File    :   MyUtils.java
 *  Version :   1.0
 *  Date    :   Apr 21, 2018
 *  Author  :   raviraj
 *
    This file is part of 008-servlet-http-request.

    008-servlet-http-request is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    008-servlet-http-request is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with 008-servlet-http-request.  If not, see <http://www.gnu.org/licenses/>.

 */
package com.reva.sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author raviraj
 * @date   Apr 21, 2018
 * @since  1.0
 */
public class MyUtils {

	/**
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public static void genOutput(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setHeader("Content-Type", "text/html");

		String a = req.getParameter("a");
		String b = req.getParameter("b");

		String c = req.getParameter("c");

		PrintWriter pw = resp.getWriter();

		Enumeration<String> itr = req.getParameterNames();

		while (itr.hasMoreElements()) {
			String x = itr.nextElement();

			String op = " parameter name : " + x + " :: parameter value  : " + req.getParameter(x);
			System.out.println(op);

			pw.append(" <p>" + op + "</p>");
		}

		pw.append("<hr/>");

		pw.append("<br/> a : " + a);
		pw.append("<br/> b : " + b);
		pw.append("<br/> c : " + c);

		sendReqInfo(req, pw);

		pw.append("<h3><a href='index.html'> Home </a></h3>");
	}

	/**
	 * @param req
	 * @param pw
	 */
	public static void sendReqInfo(HttpServletRequest req, PrintWriter pw) {
		pw.append("<hr/>");

		pw.append("<p> Remote Address :: " + req.getRemoteAddr() + " </p>");
		pw.append("<p> Remote Host :: " + req.getRemoteHost() + " </p>");
		pw.append("<p> Remote Port :: " + req.getRemotePort() + " </p>");

		pw.append("<p> Local Address :: " + req.getLocalAddr() + " </p>");

		pw.append("<p> Req URL :: " + req.getRequestURL().toString() + " </p>");
		pw.append("<p> Req URI :: " + req.getRequestURI() + " </p>");

		pw.append("<p>ctxPath1 :: " + req.getContextPath() + "</p>");
		pw.append("<p>ctxPath2 :: " + req.getServletContext().getContextPath() + "</p>");

		pw.append("<p> Scheme :: " + req.getScheme() + " </p>");
		pw.append("<p> Server name :: " + req.getServerName() + " </p>");

		pw.append("<p> Server Path :: " + req.getServletPath() + " </p>");
		pw.append("<p> Server Port :: " + req.getServerPort() + " </p>");
		pw.append("<p> Protocol :: " + req.getProtocol() + " </p>");

		pw.append("<p> Path Info :: " + req.getPathInfo() + " </p>");
		pw.append("<p> Path Translated :: " + req.getPathTranslated() + " </p>");

		pw.append("<p> Req Method :: " + req.getMethod() + " </p>");

		pw.append("<p> QueryString :: " + req.getQueryString() + " </p>");

		pw.append("<hr/>");

		Enumeration<String> itr2 = req.getHeaderNames();

		pw.append(" <p> Request header name :: header value   </p>");
		while (itr2.hasMoreElements()) {
			String x = itr2.nextElement();

			String op = "  " + x + "       ::  " + req.getHeader(x);
			System.out.println(op);

			pw.append(" <p>" + op + "</p>");
		}

		pw.append("<hr/>");
	}

}
