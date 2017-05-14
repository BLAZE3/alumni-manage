package cn.blaze.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName LogVo
 * @Description 日志显示类
 * @author LiuLei
 * @date 2017年5月14日 下午12:56:13
 */
public class LogVo {
	
    private String id;
    private String actorid; // 操作者用户id
    private String actinfo; // 操作信息
    private String userName;// 用户账号
    private Date inserttime;// 插入时间
    private String inserttime_str;
    
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActorid() {
        return actorid;
    }

    public void setActorid(String actorid) {
        this.actorid = actorid == null ? null : actorid.trim();
    }

    public String getActinfo() {
        return actinfo;
    }

    public void setActinfo(String actinfo) {
        this.actinfo = actinfo == null ? null : actinfo.trim();
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInserttime_str() {
		return inserttime_str==null && inserttime!=null?sf.format(inserttime):inserttime_str;
	}

	public void setInserttime_str(String inserttime_str) {
		this.inserttime_str = inserttime_str;
	}
}