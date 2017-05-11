$(function() {
	if (operate != null && operate == "yes") {
		$("#add_education_form").show();
		$(".del_btn").show();
	} else {
		$("#add_education_form").hide();
		$(".del_btn").hide();
	}
	
	fillCountry();
	
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

// 填国家
function fillCountry(){
	var url = "school/queryAllCountry";
	$.post(url,{},
		function(data){
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
	var url = "school/queryProvinceByCountry";
	$.post(url,{country:country},
		function(data){
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
	var url = "school/queryCityByProvince";
	$.post(url,{province:province},
		function(data){
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
			for(var o in data){  
				var schoolName = data[o];
				var option = "<option value='"+schoolName+"'>"+schoolName+"</option>";
				$("#schoolName").append(option);
			} 
		}
	);
}

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
	if (!msg) {
		return true;
	} else {
		alert(msg);
		return false;
	}
}