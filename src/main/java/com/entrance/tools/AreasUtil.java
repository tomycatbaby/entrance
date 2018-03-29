package com.entrance.tools;

import java.util.HashMap;
import java.util.Map;

public class AreasUtil {
	public boolean areasClassify(String areas) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("重庆", "0");
		map.put("四川", "1");
		map.put("广东", "2");
		map.put("湖南", "3");
		map.put("黑龙江", "4");
		map.put("广西", "5");
		map.put("河南", "6");
		map.put("河北", "7");
		map.put("山东", "8");
		map.put("山西", "9");
		map.put("江西", "10");
		map.put("江苏", "11");
		map.put("西藏", "12");
		map.put("台湾", "13");
		map.put("安徽", "14");
		map.put("浙江", "15");
		map.put("福建", "16");
		map.put("湖北", "17");
		map.put("海南", "18");
		map.put("云南", "19");
		map.put("贵州", "20");
		map.put("青海", "21");
		map.put("甘肃", "22");
		map.put("陕西", "23");
		map.put("天津", "24");
		map.put("上海", "25");
		map.put("北京", "26");
		map.put("内蒙古", "27");
		map.put("新疆", "28");
		map.put("宁夏", "29");
		map.put("香港", "30");
		map.put("澳门", "31");
		map.put("吉林", "32");
		map.put("辽宁", "33");
		boolean result = map.containsKey(areas);
		return result;
	}
}
