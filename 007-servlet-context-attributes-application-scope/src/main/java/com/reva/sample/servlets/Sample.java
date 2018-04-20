/*-
 *  File    :   Sample.java
 *  Version :   1.0
 *  Date    :   Apr 20, 2018
 *  Author  :   raviraj
 *
    This file is part of 007-servlet-context-attributes-application-scope.

    007-servlet-context-attributes-application-scope is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    007-servlet-context-attributes-application-scope is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with 007-servlet-context-attributes-application-scope.  If not, see <http://www.gnu.org/licenses/>.

 */
package com.reva.sample.servlets;

import java.io.Serializable;

/**
 * @author raviraj
 * @date   Apr 20, 2018
 * @since  1.0
 */
@SuppressWarnings("serial")
public class Sample implements Serializable {

	private String name;
	private Integer age;

	/**
	 *
	 */
	public Sample() {

	}

	public Sample(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sample [name=" + name + ", age=" + age + "]";
	}

}
