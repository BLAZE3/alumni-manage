package cn.blaze.utils;

import java.util.UUID;

public class SystemUtils {
	/**
	 * 生成唯一的主键值
	 * @Title buildUniqueId
	 * @Description：
	 * @return
	 * @user LiuLei 2017年4月23日
	 * @updater：
	 * @updateTime：
	 */
	public static String buildUniqueId() {
		return UUID.randomUUID().toString().replaceAll("\\-", "");
	}
}
