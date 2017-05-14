package cn.blaze.utils;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;


public class CommonUtils {
	public static final String RPROPERTIES_PATH = "/properties.properties";
	
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
	
	/**
	 * @Title getPropertiesValue
	 * @Description：获取properties文件的值
	 * @param key
	 * @return
	 * @user LiuLei 2017年5月11日
	 * @updater：
	 * @updateTime：
	 */
	public static String getPropertiesValue(String key){
		String value = "";
		Properties properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(CommonUtils.class.getResource(RPROPERTIES_PATH).getPath());
			properties.load(fileInputStream);
			fileInputStream.close();
			if (properties.containsKey(key)) {
				value = new String(properties.getProperty(key).getBytes("ISO8859-1") ,"UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
    
    /**
     * @Title isEmpty
     * @Description：为null或者为空字符串返回true,否则返回false
     * @param obj
     * @return
     * @user LiuLei 2017年5月4日
     * @updater：
     * @updateTime：
     */
    public static boolean isEmpty(Object obj){  
        return obj == null || obj.toString().length() == 0;  
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
	 * @Title stringForWhereIn
	 * @Description：aaa,bbb,ccc转换成'aaa','bbb','ccc'
	 * @param data
	 * @return
	 * @user LiuLei 2017年4月26日
	 * @updater：
	 * @updateTime：
	 */
	public static String stringForWhereIn(String data){
		String[] arr=data.split(",");
		StringBuilder result = new StringBuilder();
//		result.append("(");
		for(int i=0;i<arr.length;i++){
			result.append("'"+arr[i]+"'"+(i==arr.length-1?"":","));
		}
//		result.append(")");
		return result.toString();
	}
	
    /**
     * @Title removeNullValue
     * @Description：移除map中的value为""和null
     * @param map
     * @user LiuLei 2017年5月4日
     * @updater：
     * @updateTime：
     */
    @SuppressWarnings("rawtypes")
	public static void removeNullValue(Map map){   
        Set set = map.keySet();   
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {   
            Object obj = (Object) iterator.next();   
            Object value =(Object)map.get(obj);   
            remove(value, iterator);   
        }
    }
    
    /**
     * @Title remove
     * @Description：移除map中值为null和""
     * Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。  
     * Iterator 被创建之后会建立一个指向原来对象的单链索引表，当原来的对象数量发生变化时，这个索引表的内容不会同步改变， 
     * 所以当索引指针往后移动的时候就找不到要迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出 java.util.ConcurrentModificationException 异常。 
     * 所以 Iterator 在工作的时候是不允许被迭代的对象被改变的。 
     * 但你可以使用 Iterator 本身的方法 remove() 来删除对象， Iterator.remove() 方法会在删除当前迭代对象的同时维护索引的一致性。
     * @param obj
     * @param iterator
     * @user LiuLei 2017年5月4日
     * @updater：
     * @updateTime：
     */
    @SuppressWarnings("rawtypes")
	private static void remove(Object obj,Iterator iterator){   
        if(obj instanceof String){   
            String str = (String)obj;  
            if(isEmpty(str)){  //过滤掉为null和""的值 主函数输出结果map：{2=BB, 1=AA, 5=CC, 8=  }  
                iterator.remove();   
            }   
        }else if(obj instanceof Collection){   
            Collection col = (Collection)obj;   
            if(col==null||col.isEmpty()){   
                iterator.remove();   
            }
        }else if(obj instanceof Map){   
            Map temp = (Map)obj;   
            if(temp==null||temp.isEmpty()){   
                iterator.remove();   
            }
        }else if(obj instanceof Object[]){   
            Object[] array =(Object[])obj;   
            if(array==null||array.length<=0){   
            	iterator.remove();   
            } 
        }else{   
            if(obj==null){   
                iterator.remove();   
            }   
        }   
    }   

}
