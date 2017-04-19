package cn.blaze.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.blaze.domain.StudentInfo;
import cn.blaze.service.StudentInfoService;

/**
 * 学生信息
 * @ClassName StudentController
 * @author LiuLei
 * @date 2017年4月18日 下午7:43:47
 */
@Controller
@RequestMapping("/studentInfo")
public class StudentInfoController {
	@Autowired
	private StudentInfoService studentInfoService;
	
	@RequestMapping("studentRegister")
	public String studentRegister(HttpServletRequest request){
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setAddress("大唐长安");
		studentInfo.setAge("12");
		studentInfo.setEmail("tsz@126.com");
		studentInfo.setImgpath("/src/option.jpg");
		studentInfo.setStudentName("唐三藏");
		studentInfo.setQq("234567");
		studentInfo.setTelephone("15627289820");
		studentInfo.setWechat("tyuw");
		for (int i = 0; i < 10; i++) {
			studentInfoService.studentRegister(studentInfo);
		}
		return null;
	}
	
	@RequestMapping("queryStudentInfo")
	public String queryStudentInfo(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentName", "唐三藏");
		List<StudentInfo> queryStudentInfoByParameterMap = studentInfoService.queryStudentInfoByParameterMap(map);
		return "success";
	}
}
