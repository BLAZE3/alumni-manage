package cn.blaze.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EducationInfoVo {
	
    private String id;
    private String studentId;// 学生Id
    private String schoolId;// 学校信息表主键
    private String schoolName;// 学校名
    private Date entranceTime;// 入学时间
    private String entranceTimeStr;// 入学时间
    private Date graduationTime;// 毕业时间
    private String graduationTimeStr;// 毕业时间
    private String institute;// 所在院
    private String major;// 专业
    private String education;// 学历

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Date getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute == null ? null : institute.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEntranceTimeStr() {
		return entranceTimeStr==null?sf.format(entranceTime):entranceTimeStr;
	}

	public void setEntranceTimeStr(String entranceTimeStr) {
		this.entranceTimeStr = entranceTimeStr;
	}

	public String getGraduationTimeStr() {
		return graduationTimeStr==null?sf.format(graduationTime):graduationTimeStr;
	}

	public void setGraduationTimeStr(String graduationTimeStr) {
		this.graduationTimeStr = graduationTimeStr;
	}
	
}