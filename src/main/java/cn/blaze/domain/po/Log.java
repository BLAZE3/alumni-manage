package cn.blaze.domain.po;

import java.util.Date;

public class Log {
    private String id;

    private String actorid;

    private String actinfo;

    private Date inserttime;

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
}