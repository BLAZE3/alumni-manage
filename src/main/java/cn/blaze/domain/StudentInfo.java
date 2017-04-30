package cn.blaze.domain;

public class StudentInfo {

	private String id;
	private String studentName; // 学生姓名
	private Integer age;// 学生年龄
	private String telephone;// 电话
	private String address;// 地址
	private String email;// 邮箱
	private String wechat;// 微信
	private String qq;// QQ号
	private String imagePath;// 头像地址
	private String emailShow;// 是否显示邮箱
	private String qqShow;// 是否显示QQ
	private String wechatShow;// 是否显示微信
	private String sex;//性别
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getEmailShow() {
		return emailShow;
	}

	public void setEmailShow(String emailShow) {
		this.emailShow = emailShow;
	}

	public String getQqShow() {
		return qqShow;
	}

	public void setQqShow(String qqShow) {
		this.qqShow = qqShow;
	}

	public String getWechatShow() {
		return wechatShow;
	}

	public void setWechatShow(String wechatShow) {
		this.wechatShow = wechatShow;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}