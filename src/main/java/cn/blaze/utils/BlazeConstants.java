package cn.blaze.utils;

/**
 * @ClassName BlazeConstants
 * @Description 存储项目常量
 * @author LiuLei
 * @date 2017年5月7日 下午4:39:04
 */
public class BlazeConstants {
	/**
	 * 存储在session中用户对应的key
	 */
	public static final String SESSION_SAVE_LOGIN = "loginUser";
	/**
	 * 存储错误页面的错误信息
	 */
	public static final String ERROR_PAGE_MESSAGE = "error_message";
	/**
	 * 用户类型--管理员
	 */
	public static final String USER_TYPE_ADMIN="0";
	/**
	 * 用户类型--学生
	 */
	public static final String USER_TYPE_STUDENT="1";
	/**
	 * 用户类型--普通
	 */
	public static final String USER_TYPE_COMMON="2";
	/**
	 * 用户类型--认证中
	 */
	public static final String USER_TYPE_CONFIRM = "3";

	/**
	 * 是否有效--有效
	 */
	public static final String ISVALID_YES="Y";
	/**
	 * 是否有效--无效
	 */
	public static final String ISVALID_NO="N";
	
}
