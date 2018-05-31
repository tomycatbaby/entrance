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
import com.entrance.bean.AreasEnroll;
import com.entrance.bean.CollegeEnroll;
import com.entrance.bean.MajorEnroll;
import com.entrance.bean.Position;
import com.entrance.bean.User;
import com.entrance.service.impl.AreasEnrollServiceImpl;
import com.entrance.service.impl.CollegeEnrollServiceImpl;
import com.entrance.service.impl.MajorServiceImpl;
import com.entrance.service.impl.PositionServiceImpl;
import com.entrance.service.impl.UserServiceImpl;
import com.entrance.tools.AreasUtil;
import com.entrance.tools.Jurisdiction;
import com.entrance.tools.RandomCode;

@Controller
@RequestMapping("/entrance")
public class EntranceAction {
	@Resource
	private UserServiceImpl userService;
	@Resource
	private CollegeEnrollServiceImpl collegeEnrollService;
	@Resource
	private MajorServiceImpl majorService;
	@Resource
	private AreasEnrollServiceImpl areasEnrollService;
	@Resource
	private PositionServiceImpl positionService;
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
	public void getName(HttpServletResponse response, HttpServletRequest request)throws Exception{
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
			json.put("username", u.getUsername());
			String jurisdiction = new Jurisdiction().jurisdictionClassify(u.getJurisdiction());
			json.put("Jurisdiction", jurisdiction);
			json.put("place", u.getPlace());
			out.write(json.toJSONString());
			out.close();
		} catch (Exception e) {
		}

	}

	/*
	 * 搜索框内
	 */
	@RequestMapping("/search")
	public void search(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String information = request.getParameter("information");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		String subject = request.getParameter("subject");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		User u = userService.getUser(username);
		String areas = u.getPlace();
		JSONObject json = new JSONObject();
		try {

			// 判断输入的信息是省市
			if (new AreasUtil().areasClassify(information)) {
				if (subject == null || subject == "") {
					subject = "理科";
				}
				List<AreasEnroll> areasEnrollList = areasEnrollService.findAreasEnroll(information, subject, batch,
						year);
				json.put("data", areasEnrollList);
				json.put("city", 1);
			} else {
				if (subject == null || subject == "") {
					subject = "理科";
				}
				List<CollegeEnroll> collegeEnrollList = collegeEnrollService.find(information, areas, subject);
				json.put("data", collegeEnrollList);
				json.put("city", 0);
			}
			PrintWriter out = response.getWriter();
			json.put("resultCode", 200);
			json.put("user", u);

			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	/*
	 * 选择框改变
	 */

	@RequestMapping("/searchBy")
	public void searchByAreaSubject(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String areas = request.getParameter("areas");
		String subject = request.getParameter("subject");
		String college = request.getParameter("college");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		User u = userService.getUser(username);
		JSONObject json = new JSONObject();
		try {
			List<CollegeEnroll> collegeEnrollList = collegeEnrollService.searchBy(college, areas, subject, batch, year);
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

	/*
	 * 按专业
	 */
	@RequestMapping("/searchMajor")
	public void searchMajor(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String areas = request.getParameter("areas");
		String subject = request.getParameter("subject");
		String major = request.getParameter("major");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		String limit = request.getParameter("limit");
		int lt = 0;
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		User u = userService.getUser(username);
		int juri = u.getJurisdiction();
		if (areas == "" || areas == null) {
			if (juri > 2) {
				areas = "";
			} else {
				areas = u.getPlace();
			}
		}
		if (subject == null || subject == "") {
			subject = "理科";
		}
		if (limit != null && limit != "") {
			lt = Integer.valueOf(limit);
		}
		JSONObject json = new JSONObject();
		try {
			List<MajorEnroll> majorEnrollList = majorService.findMajor(major, areas, subject, batch, year, lt);
			int count = majorService.findCount(major, areas, subject, batch, year);
			PrintWriter out = response.getWriter();
			json.put("resultCode", 200);
			json.put("user", u);
			json.put("data", majorEnrollList);
			json.put("count", count);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping("/addCollege")
	public void addCollege(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String areas = request.getParameter("areas");
		String subject = request.getParameter("subject");
		String college = request.getParameter("college");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		String control_line = request.getParameter("control_line");
		String highest_score = request.getParameter("highest_score");
		String average = request.getParameter("average");
		String lowest_score = request.getParameter("lowest_score");
		String shift_line = request.getParameter("shift_line");
		String enrollment = request.getParameter("enrollment");
		CollegeEnroll collegeEnroll = new CollegeEnroll();
		collegeEnroll.setAreas(areas);
		collegeEnroll.setAverage(Integer.valueOf(average));
		collegeEnroll.setBatch(batch);
		collegeEnroll.setCollege(college);
		collegeEnroll.setControl_line(Integer.valueOf(control_line));

		if (enrollment != null && enrollment != "") {
			collegeEnroll.setEnrollment(Integer.valueOf(enrollment));
		}

		if (highest_score != null && highest_score != "") {
			collegeEnroll.setHighest_score(Integer.valueOf(highest_score));
		}
		if (lowest_score != null && lowest_score != "") {
			collegeEnroll.setLowest_score(Integer.valueOf(lowest_score));
		}
		if (shift_line != null && shift_line != "") {
			collegeEnroll.setShift_line(Integer.valueOf(shift_line));
		}

		collegeEnroll.setSubject(subject);
		collegeEnroll.setYear(Integer.valueOf(year));
		System.out.println(collegeEnroll.toString());
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			collegeEnrollService.addCollege(collegeEnroll);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/addUser")
	public void addUser(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = new RandomCode().getCode();
		String jurisdiction = request.getParameter("jurisdiction");
		String place = request.getParameter("place");
		User user = new User();
		user.setJurisdiction(Integer.valueOf(jurisdiction));
		user.setUsername(username);
		user.setName(name);
		user.setPassword(password);
		user.setPlace(place);
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			userService.insertUser(user);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/getUser")
	public void getUser(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			List<User> list = userService.getUserList(username);
			json.put("resultCode", 200);
			json.put("data", list);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/updateUser")
	public void updateUser(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String jurisdiction = request.getParameter("jurisdiction");
		String place = request.getParameter("place");
		User user = new User();
		user.setJurisdiction(Integer.valueOf(jurisdiction));
		user.setUsername(username);
		user.setPlace(place);
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			userService.updateUser(user);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/getUserList")
	public void getUserList(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			List<User> list = userService.getUserList(username);
			json.put("resultCode", 200);
			json.put("data", list);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/choose")
	public void choose(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String subject = request.getParameter("subject");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		String areas = request.getParameter("areas");
		String place = request.getParameter("place");
		String score = request.getParameter("score");
		int s = Integer.valueOf(score)+10;
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
		
			List<CollegeEnroll> list = collegeEnrollService.choose(place, areas, subject, batch, year,String.valueOf(s));
			json.put("data", list);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/getCollege")
	public void getCollege(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String subject = request.getParameter("subject");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		String place = request.getParameter("place");
		String areas = request.getParameter("areas");
	
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			List<MajorEnroll> list = majorService.getCollege(place, areas, subject, batch, year);
			json.put("data", list);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/getMajor")
	public void getMajor(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String subject = request.getParameter("subject");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		String place = request.getParameter("place");
		String areas = request.getParameter("areas");
		
		String college = request.getParameter("college");
	
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			List<MajorEnroll> list = majorService.getMajor(place, areas, subject, batch, year, college);
			json.put("data", list);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/rank")
	public void rank(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String subject = request.getParameter("subject");
		String batch = request.getParameter("batch");
		String year = request.getParameter("year");
		String place = request.getParameter("place");
		String areas = request.getParameter("areas");
		String rank = request.getParameter("rank");
		rank = String.valueOf(Integer.valueOf(rank)-50);
		String college = request.getParameter("college");
		String major = request.getParameter("major");
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			List<MajorEnroll> list = majorService.rank(place, areas, subject, batch, year, college, rank, major);
			json.put("size", list.size());
			json.put("data", list);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	@RequestMapping("/getPositionCollege")
	public void getPositionCollege(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		String year = request.getParameter("year");
		String areas = request.getParameter("areas");

		String college = request.getParameter("college");
		String major = request.getParameter("major");
		JSONObject json = new JSONObject();
		try {
			PrintWriter out = response.getWriter();
			List<Position> list = positionService.findPosition(year, areas, college, major);
			json.put("data", list);
			json.put("resultCode", 200);
			out.write(json.toJSONString());
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
