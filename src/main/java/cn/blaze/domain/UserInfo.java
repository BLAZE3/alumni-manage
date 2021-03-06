package cn.blaze.domain;

import java.util.Date;

public class UserInfo {

    private String id;
    private String studentId; // 学生信息表主键
    private String userName;//用户账号
    private String password;//用户密码
    private String status;//用户状态.待审核,正常
    private String type;// 用户类型,管理员,普通用户
    private String isvalid;// 是否有效.Y 有效,N 无效(禁用)
    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", studentId=" + studentId
				+ ", userName=" + userName + ", password=" + password
				+ ", status=" + status + ", type=" + type + ", isvalid="
				+ isvalid + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
}