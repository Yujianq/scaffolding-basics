package com.yujianq.filter;

import org.apache.commons.lang.StringUtils;

import com.yujianq.exception.CustomException;

/**
 * @author Yujianq
 * @description SQL 语句过滤器
 * @date 2020-05-14 11:18
 */
public class SqlFilter {
	
	/**
	 * SQL注入过滤
	 * @param str 待验证的字符串
	 */
	public static String sqlInject(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		// 去掉'|"|;|\字符
		str = StringUtils.replace(str, "'", "");
		str = StringUtils.replace(str, "\"", "");
		str = StringUtils.replace(str, ";", "");
		str = StringUtils.replace(str, "\\", "");

		// 转换成小写
		str = str.toLowerCase();

		// 非法字符
		String[] keywords = { "master", "truncate", "insert", "select", "delete", "update", "declare", "alter",
				"drop" };

		// 判断是否包含非法字符
		for (String keyword : keywords) {
			if (str.indexOf(keyword) != -1) {
				throw new CustomException("包含非法字符");
			}
		}

		return str;
	}

}