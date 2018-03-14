package com.entrance.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.entrance.bean.CollegeEnroll;
import com.entrance.bean.User;
import com.entrance.service.impl.CollegeEnrollServiceImpl;
import com.entrance.service.impl.UserServiceImpl;
import com.entrance.tools.Jurisdiction;

@Controller
@RequestMapping("/entrance")
public class EntranceAction {
	@Resource
	private UserServiceImpl userService;
	@Resource
	private CollegeEnrollServiceImpl collegeEnrollService;

	@RequestMapping("/login")
	public void login(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();
		try {
			User u = userService.getUser(username);
			if (u.getPassword().equals(password)) {
				session.setAttribute("user", username);
				json.put("resultCode", 200);
				json.put("user", u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		out.write(json.toJSONString());
		out.close();

	}

	@RequestMapping("/loginOut")
	public void loginOut(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		JSONObject json = new JSONObject();
		PrintWriter out;
		try {
			out = response.getWriter();
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/getName")
	public void getName(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		User u = userService.getUser(username);
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			json.put("resultCode", 200);
			json.put("user", u.getName());
			String jurisdiction = new Jurisdiction().jurisdictionClassify(u.getJurisdiction());
			json.put("Jurisdiction", jurisdiction);
			json.put("place", u.getPlace());
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping("/search")
	public void search(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String college = request.getParameter("information");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		User u = userService.getUser(username);
		String areas = u.getPlace();
		JSONObject json = new JSONObject();
		try {
			 List<CollegeEnroll>  collegeEnrollList= collegeEnrollService.find(college);
			PrintWriter out = response.getWriter();
			json.put("resultCode", 200);
			json.put("user", u);
			json.put("data", collegeEnrollList);
			
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
