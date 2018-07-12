package com.xhwl.utils.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

import com.xhwl.po.User;

public class HtmlUtil {

	public static void writerJson(HttpServletResponse response, String jsonStr) {
		writer(response, jsonStr);
	}

	public static void writerJson(HttpServletResponse response, Object object) {
		try {
			response.setContentType("application/json");
			writer(response, JSONUtil.toJSONString(object));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public static void writerJson(HttpServletResponse response,
			Object... objects) {
		try {
			response.setContentType("application/json");

			JSONArray jSONArray = new JSONArray();
			for (Object obj : objects) {
				jSONArray.put(JSONUtil.toJSONString(obj));
			}
			writer(response, jSONArray.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private static void writer(HttpServletResponse response, String str) {
		System.out.println("向客户端传递:" + str);
		try {
			// 设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] ages) {
		User user = new User();
		user.setQq(10000l);
		user.setCity("广州");

		User user2 = new User();
		user2.setQq(20000l);
		user2.setCity("深圳");

		User user3 = new User();
		user3.setQq(30000l);
		user3.setCity("上海");

		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user2);

		try {
			JSONArray jSONArray = new JSONArray();
			jSONArray.put(JSONUtil.toJSONString(true));
			// jSONArray.put(JSONUtil.toJSONString(list));
			// jSONArray.put(JSONUtil.toJSONString(user3));
			System.out.println(jSONArray.toString());
			// System.out.println(JSONUtil.toJSONString(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
