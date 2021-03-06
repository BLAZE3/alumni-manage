
function f_initGrid()
{
    g = manager = $("#maingrid").ligerGrid({
    	url:"user/queryUserInfoJson?jsonType=student",
//    	dataType : 'json',
        columns: [
        { 
        	display: '学生ID', 
        	name: 'student_id',
        	hide:true
        },
        { 
        	display: '账号', 
        	name: 'user_name',
        	align:'left',
        	width: '8%',
            render:function(row){
            	return row.userName;
            }
        },
        { 
        	display: '密码', 
        	name: 'password',
        	align:'left',
        	width: '7%',
        	render: function(rowdata){
        		return "<p title='"+rowdata.password+"'>"+rowdata.password+"</p>";
        	}
        },
        { 
        	display: '性别', 
        	width: '3%',
        	name: 'sex', 
        },
        { 
        	display: '创建时间', 
        	name: 'createTimeStr',
        	width: '8%',
        },
        { 
        	display: '更新时间', 
        	name: 'updateTimeStr',
        	width: '8%',
        },
        { 
        	display: '状态', 
        	name: 'status',
        	width: '4%',
            render: function (rowdata)
        	{
	           if(rowdata.status=="0"){
	        	   return "<p style='color:green'>正常</p>";
	           }else{
	        	   return "<p style='color:red'>其他</p>";
	           }
        	}
        },
        { 
        	display: '类型', 
        	name: 'type',
        	width: '4%',
            render: function (rowdata)
        	{
	           if(rowdata.type=="0"){
	        	   return "<p>管理员</p>";
	           }else if(rowdata.type=="1"){
	        	   return "<p style='color:green'>学生</p>";
	           }else if(rowdata.type=="2"){
	        	   return "<p style='color:yellow'>未认证</p>";
	           }else if(rowdata.type=="3"){
	        	   return "<p style='color:blue'>认证中</p>";
	           }else{
	        	   return "<p style='color:red'>其他</p>";
	           }
        	}
        },
        { 
        	display: '姓名', 
        	name: 'student_name',
        	width: '5%',
            render:function(row){
            	return row.studentName;
            }
        },
        { 
        	display: '年龄', 
        	name: 'age', 
        	type: 'int',
        	hide: true,
        	width: '3%'
        },
        { 
        	display: '手机', 
        	name: 'telephone',
        	width: '7%',
        	align:'left',
        	render: function(rowdata){
        		return "<p title='"+rowdata.telephone+"'>"+rowdata.telephone+"</p>";
        	}
        },
        { 
        	display: '地址', 
        	name: 'address',
        	align: 'left',
        	width: '10%',
        	render: function(rowdata){
        		return "<p title='"+rowdata.address+"'>"+rowdata.address+"</p>";
        	}
        },
        { 
        	display: '邮箱', 
        	name: 'email',
        	width: '10%',
        	render: function(rowdata){
        		return "<p title='"+rowdata.email+"'>"+rowdata.email+"</p>";
        	}
        },
        { 
        	display: '微信号', 
        	name: 'wechat',
        	width: '8%',
        	render: function(rowdata){
        		return "<p title='"+rowdata.wechat+"'>"+rowdata.wechat+"</p>";
        	}
        },
        { 
        	display: 'QQ', 
        	name: 'qq',
        	width: '5%',
        	render: function(rowdata){
        		return "<p title='"+rowdata.qq+"'>"+rowdata.qq+"</p>";
        	}
        },
        { 
        	display: '操作', 
        	isSort: false, 
        	width: '13%',
        	render: function (rowdata, rowindex, value)
        	{
	           var h = "";
	           h += "<a href='educationInfo/forwardEducationInfoPage?studentId="+rowdata.studentId+"' target='_blank'>学历</a> ";
	           if(operate == "yes"){// 管理员可以操作
	        	   h += "<a href='javascript:editRow(\""+rowdata.id+"\")'>修改</a> ";
	        	   if(rowdata.isvalid=="Y"){
	        		   h += "<a href='javascript:cancelRow(\""+rowdata.id+"\")'>注销</a> ";
	        	   }else{
	        		   h += "<a href='javascript:enableRow(\""+rowdata.id+"\")'>启用</a> ";
	        	   }
	        	   h += "<a href='javascript:resetPassword(\""+rowdata.id+"\")'>重置密码</a> ";
	           }
	           return h;
        	}
        }
        ],
        dataAction: 'server', 
        usePager:true,
        checkbox:true,
        isScroll: true, 
        showTableToggleBtn:true,
        sortName: "id",
        sortOrder : "DESC",
        showTitle: true,
        pageSize : 50,
        pageSizeOptions: [15,30,50],
        resizable :true,
        width: '99%',
        height : "100%",
        onSelectRow: function (rowdata, rowindex)
        {
            $("#txtrowindex").val(rowindex);
        }
    });
    
    /***提交***/
	$("#submit_btn").click(function(){
		gridManager = $("#maingrid").ligerGetGridManager(); 
		var userName = $("#userName").val().trim();
		var studentName = $("#studentName").val().trim();
		var status = $("#status").val().trim();
		var sex = $("#sex").val().trim();
		
		gridManager.setOptions({ 
			parms: [
					{ name: 'userName', value: userName},
					{ name: 'studentName', value: studentName},
					{ name: 'sex', value: sex},
					{ name: 'status', value: status}
				]
		}); 
		gridManager.loadData(); 
	});
	
	/***重置***/
	$("#reset_btn").click(function(){
		$(".select").val("");
		reloadGrid();
	});
    
	/***导出***/
	$("#export_btn").click(function(){
		var conditions = "";
		var userName = $("#userName").val();
		var studentName = $("#studentName").val();
		var status = $("#status").val();
		var isvalid = $("#isvalid").val();
		var sex = $("#sex").val();
		
		if(userName!=null && userName!=""){
			conditions+="&userName="+userName;
		}
		if(studentName!=null && studentName!=""){
			conditions+="&studentName="+studentName;
		}
		if(status!=null && status!=""){
			conditions+="&status="+status;
		}
		if(isvalid!=null && isvalid!=""){
			conditions+="&isvalid="+isvalid;
		}
		if(sex!=null && sex!=""){
			conditions+="&sex="+sex;
		}
		window.open("studentInfo/exportStudentInfo?abc=abc"+conditions);// 弹出下载框
		$("#submit_btn").click();// 刷新数据
	});
}

/**
 * 弹出编辑窗
 * @param studentId
 */
function editRow(userId){
	$.ligerDialog.open({
		height : 500,
		url : 'studentInfo/forwardStudentInfoUpdate?userId='+userId,
		width : null,
		showMax : true,
		showToggle : false,
		showMin : false,
		isResize : false,
		modal : false,
		title : "修改用户信息"
	});
}

/**
 * 弹出详情窗
 * @param studentId
 */
function studentInfoDetail(userId){
	$.ligerDialog.open({
		height : 500,
		url : 'studentInfo/forwardStudentInfoView?userId='+userId,
		width : null,
		showMax : true,
		showToggle : false,
		showMin : false,
		isResize : false,
		modal : false,
		title : "查看用户信息"
	});
}

/**
 * 根据studentId注销账号
 * @param studentId
 */
function cancelRow(id){
	var url = "user/changeUserValidById";
	$.post(
		url,
		{id:id,isvalid:'N'},
		function(data){
			if(data.info=="success"){
				g.reload();
			}
		}
	);
}
/**
 * 根据studentId启用账号
 * @param studentId
 */
function enableRow(id){
	var url = "user/changeUserValidById";
	$.post(
		url,
		{id:id,isvalid:'Y'},
		function(data){
			if(data.info=="success"){
				g.reload();
			}
		}
	);
}
/**
 * 根据studentId重置密码
 * @param studentId
 */
function resetPassword(id){
	var url = "user/resetUserPasswordById";
	if(confirm("确认重置用户密码?")){
		$.post(
				url,
				{id:id},
				function(data){
					if(data.info=="success"){
						g.reload();
					}
				}
		);
	}
}

function reloadGrid(){
	gridManager.setOptions( {parms: []} );
	gridManager.loadData();
}