package com.entrance.tools;

import java.util.HashMap;
import java.util.Map;

public class Jurisdiction {
public String jurisdictionClassify(int jurisdictionNum){
	Map<Integer, String> map = new HashMap<Integer, String>();
	map.put(1, "普通用户");
	map.put(2, "初级咨询师");
	map.put(3, "高级咨询师");
	map.put(4, "系统管理员");
	String jurisdiction = map.get(jurisdictionNum);
	return jurisdiction;
}
}
