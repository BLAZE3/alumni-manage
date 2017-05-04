package cn.blaze.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName StudentRegisterVo
 * @Description 学生认证vo
 * @author LiuLei
 * @date 2017年5月4日 下午10:18:29
 */
public class StudentRegisterVo {
	
	private String id;// userId用户信息表的主键
    private String studentId;// 学生信息表的主键
    private String userName;// 账户名
    private String password;
    private String status;// 状态
    private String type;// 类型
    private String isvalid;// 是否有效
	private String studentName;// 学生姓名
	private Integer age;
	private String telephone;
	private String address;
	private String email;
	private String wechat;
	private String qq;
	private String imagePath;// 头像地址
	private String emailShow;// 是否显示邮箱
	private String qqShow;// 是否显示QQ
	private String wechatShow;// 是否显示微信
	private String sex;//性别
	private Date createTime;// 创建时间
    private String createTimeStr;
    private Date updateTime;// 更新时间
    private String updateTimeStr;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsvalid() {
		return isvalid;
	}
	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateTimeStr() {
		return createTimeStr==null?sf.format(createTime):createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateTimeStr() {
		return updateTimeStr==null?sf.format(updateTime):updateTimeStr;
	}
	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}
}
