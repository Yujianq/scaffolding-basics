package com.yujianq.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Yujianq
 * @description 订单编号生成：生成32位数字编码， 1位订单号类型 + 17位时间戳 + 14位(用户 ID 加密 & 随机数)
 * @date 2020-05-14 11:18
 */
public class OrderCodeFactory {

	/**
	 * 订单号类型：普通支付订单
	 */
	private static final String PAY_ORDER = "1";

	/**
	 * 订单号类型：退款订单
	 */
	private static final String REFUND_ORDER = "2";

	/**
	 * 订单号类型：提现订单
	 */
	private static final String CASH_ORDER = "3";

	/**
	 * 随机编码数
	 */
	private static final int[] RANDOM_INT = new int[] { 7, 9, 6, 2, 8, 1, 3, 0, 5, 4 };

	/**
	 * 用户 ID 加密和随机数总长度
	 */
	private static final int MAX_LEN = 14;

	/**
	 * 根据 ID 进行加密 + 加随机数组成固定长度编码
	 * 
	 * @param id
	 * @return
	 */
	private static String toCode(Long id) {
		String idStr = id.toString();
		StringBuilder idsbs = new StringBuilder();
		for (int i = idStr.length() - 1; i >= 0; i--) {
			idsbs.append(RANDOM_INT[idStr.charAt(i) - '0']);
		}
		return idsbs.append(getRandom(MAX_LEN - idStr.length())).toString();
	}

	/**
	 * 生成时间戳
	 * 
	 * @return
	 */
	private static String getDateTime() {
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	/**
	 * 生成固定长度随机码
	 * 
	 * @param n
	 * @return
	 */
	private static long getRandom(long n) {
		long min = 1, max = 9;
		for (int i = 1; i < n; i++) {
			min *= 10;
			max *= 10;
		}
		long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
		return rangeLong;
	}

	/**
	 * 生成不带订单号类型的编码
	 * 
	 * @param userId
	 * @return
	 */
	private static synchronized String getCode(Long userId) {
		userId = userId == null ? 10000 : userId;
		return getDateTime() + toCode(userId);
	}

	/**
	 * 生成订单编号：普通支付订单
	 * @param userId
	 * @return
	 */
	public static String getPayOrderCode(Long userId) {
		return PAY_ORDER + getCode(userId);
	}
	
	/**
	 * 生成订单编号：退款订单
	 * @param userId
	 * @return
	 */
	public static String getRefundOrderCode(Long userId) {
		return REFUND_ORDER + getCode(userId);
	}
	
	/**
	 * 生成订单编号：提现订单
	 * @param userId
	 * @return
	 */
	public static String getCashOrderCode(Long userId) {
		return CASH_ORDER + getCode(userId);
	}

}
