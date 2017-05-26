$(function() {
	if (operate != null && operate == "yes") {
		$("#add_education_form").show();
		$(".del_btn").show();
	} else {
		$("#add_education_form").hide();
		$(".del_btn").hide();
	}
	
	fillCountry();// 填充国家的下拉选项
	
	$("#entranceTimeStr").ligerDateEditor({ /*showTime: true, label: '入学时间', */labelWidth: 100, labelAlign: 'left' });
	$("#graduationTimeStr").ligerDateEditor({ /*showTime: true, label: '入学时间', */labelWidth: 100, labelAlign: 'left' });
	
	$("#add_btn").click(function() {
		if (submitCheck()) {// 表单校验
			var url = "educationInfo/addEducationInfo";
			$.post(url, $("#add_education_form").serialize(), function(data) {
				if (data.info == "success") {
					location.reload();
				} else {
					alert(data.info + "原因:" + data.data);
				}
			});
		}
	});
});

/************************下拉框联动-start************************/
// 填国家
function fillCountry(){
	resetProvince();
	var url = "school/queryAllCountry";
	$.post(url,{},
		function(data){
			$("#country").html("");
			$("#country").append("<option value=''>--请选择国家--</option>");
			
			for(var o in data){  
		       var country = data[o];
		       var option = "<option value='"+country+"'>"+country+"</option>";
		       $("#country").append(option);
		    } 
		}
	);
}
// 填省份
function fillProvince(country){
	resetCity();// 初始化城市
	var url = "school/queryProvinceByCountry";
	$.post(url,{country:country},
		function(data){
			$("#province").html("");
			$("#province").append("<option value=''>--请选择省份--</option>");
			for(var o in data){  
				var province = data[o];
				var option = "<option value='"+province+"'>"+province+"</option>";
				$("#province").append(option);
			} 
		}
	);
}
// 填城市
function fillCity(province){
	resetSchoolName();// 初始化学校
	var url = "school/queryCityByProvince";
	$.post(url,{province:province},
		function(data){
			$("#city").html("");
			$("#city").append("<option value=''>--请选择城市--</option>");
			for(var o in data){  
				var city = data[o];
				var option = "<option value='"+city+"'>"+city+"</option>";
				$("#city").append(option);
			} 
		}
	);
}
// 填学校名
function fillSchoolName(city){
	var url = "school/querySchoolNameByCity";
	$.post(url,{city:city},
		function(data){
			$("#schoolName").html("");
			$("#schoolName").append("<option value=''>--请选择学校--</option>");
			for(var o in data){  
				var schoolName = data[o];
				var option = "<option value='"+schoolName+"'>"+schoolName+"</option>";
				$("#schoolName").append(option);
			} 
		}
	);
}

//初始化省份
function resetProvince(){
	$("#province").html("");
	$("#province").append("<option value=''>--请选择省份--</option>");
	resetCity();// 初始化城市
}

//初始化城市
function resetCity(){
	$("#city").html("");
	$("#city").append("<option value=''>--请选择城市--</option>");
	resetSchoolName();// 初始化学校
}

//初始化学校
function resetSchoolName(){
	$("#schoolName").html("");
	$("#schoolName").append("<option value=''>--请选择学校--</option>");
}
/************************下拉框联动-end************************/

function delEducationById(id) {
	var url = "educationInfo/delEducationById";
	$.post(url, {
		"id" : id
	}, function(data) {// 回调函数
		if (data.info == "success") {
			location.reload();// 刷新
		} else {
			alert(data.info);
		}
	}, "json");
}

// 提交前验证
function submitCheck() {
	var msg = null;// 错误提示
	$(".submit_check").each(function(i, n) {
		var time = $(n).val();
		if (time == null || time == "") {
			msg = $(n).attr("title");
			return;
		}
	});
	
	// 插件自带日期格式校正,此处日期格式验证不需要
//	$(".submit_time").each(function(i, n) {
//		var time = $(n).val();
//		if (time == null || time == "") {// 不可为空
//			$(n).focus();
//			msg =  $(n).attr("title");
//			return;
//		}else {// 判断格式
//			var formate = /^(\d{4})-(\d{2})-(\d{2})$/;
//			if (!formate.test(time)){
//				$(n).focus();
//				msg =  "日期格式不正确!";
//				return;
//			}
//		}
//	});
	
	if (!msg) {
		return true;
	} else {
		alert(msg);
		return false;
	}
}