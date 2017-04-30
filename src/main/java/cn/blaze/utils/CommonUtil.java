package cn.blaze.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public class CommonUtil {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim()))
			return true;
		return false;
	}

	/**
	 * 判断字符串是否非空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * @Title decodeStr
	 * @Description：字符串转码 对用JS中的encodeURIComponent(encodeURIComponent(xxx))传到后台的字符串进行转码，防止乱码
	 * @param encodedStr request中获取的从前台传过来的值
	 * @return 解码后的字符串
	 * @throws UnsupportedEncodingException
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	public static String decodeStr(String encodedStr) throws UnsupportedEncodingException {
		return encodedStr == null ? "" : java.net.URLDecoder.decode(encodedStr, "UTF-8").trim();
	}

	/**
	 * @Title dealJsonData
	 * @Description：处理JSON字符串中的特殊字符
	 * @param jsonData 原字符串
	 * @return 处理完的字符串
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	public static String dealJsonData(String jsonData) {
		if (jsonData == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < jsonData.length(); i++) {
			char ch = jsonData.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				if (ch >= '\u0000' && ch <= '\u001F') {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}

	public static void doAjaxResponse(HttpServletResponse response, String message) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(message);
		out.flush();
		out.close();
	}

	
	/**
	 * 把page、total、list转换为json格式的数据，形如{"page":1,"rows":[{"id":"001","name":"ser"
	 * },{"id":"002","name":"serdd"}],"total":"10"} 供页面的flexigrid使用
	 * 新版本的ligerUI使用
	 * @param page
	 * @param list
	 * @param total
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String list2FlexigridJson(String page, List list, String total) {
		StringBuilder sb=new StringBuilder(120);
		sb.append("{\"page\":");
		sb.append(page);
		sb.append(",\"Rows\":");
		sb.append(JsonUtils.list2json(list));
		sb.append(",\"Total\":");
		sb.append(total);
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * @Title listLigerUIgridJson
	 * @Description： 把list转换为json格式的数据，形如{rows":[{"id":"001","name":"ser"
	 * },{"id":"002","name":"serdd"}]} 供页面的flexigrid使用
	 * @param list
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	public static String listLigerUIgridJson(List<Object> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"rows\":");
		sb.append(JsonUtils.list2json(list));
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * @Title toWhereIn
	 * @Description：将一个整型数组生成SQL用的where … in ( … )语句
	 * 例如数组{ 1,2,3 }，则生成   ("1","2","3")
	 * @param array
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	public static String toWhereIn(int[] array){
		String in="(";
		for(int i=0;i<array.length;i++){
			in+="'"+array[i]+"'"+(i==array.length-1?"":",");
		}
		in+=")";
		return in;
	}
	
	/**
	 * @Title toWhereIn
	 * @Description：将一个字符串数组生成SQL用的where … in ( … )语句
	 * 例如数组{ "1","2","3" }，则生成   ("1","2","3")
	 * @param array
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	public static String toWhereIn(String[] array){
		String in="(";
		for(int i=0;i<array.length;i++){
			in+="'"+array[i]+"'"+(i==array.length-1?"":",");
		}
		in+=")";
		return in;
	}
	
	/**
	 * @Title stringToIn
	 * @Description：aaa,bbb,ccc转换成('aaa','bbb','ccc')
	 * @param data
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	public static String stringToIn(String data){
		String[] arr=data.split(",");
		String result="( ";
		for(int i=0;i<arr.length;i++){
			result+="'"+arr[i]+"'"+(i==arr.length-1?"":",");
		}
		result+=" )";
		return result;
	}
	
    /**
     * 获得2个日期之间的天数
     * @param start yyyy-MM-dd
     * @param end yyyy-MM-dd
     * @return
     */
    public static Long getDayBetweenDate(String start, String end){
    	try{
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		Date sDate = sdf.parse(start);
    		Date eDate = sdf.parse(end);
    		Long day = (eDate.getTime()-sDate.getTime())/(24*60*60*1000)+1;
    		return day;
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    /**
     * 数组转换为('xxx','yyyy','zzz')
     * @param strs
     * @return
     */
    public static final String generateInString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        } else {
            String strAll = "(";
            for (int i = 0, length = strs.length; i < length; i++) {
                String str = strs[i];
                strAll += "'" + str + "'" + (i == length - 1 ? ")" : ",");

            }
            return strAll;
        }
    }
}
