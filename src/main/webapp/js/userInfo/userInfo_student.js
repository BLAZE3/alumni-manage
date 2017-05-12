
function f_initGrid()
{
    g = manager = $("#maingrid").ligerGrid({
    	url:"user/queryUserInfoJson?type=student",
//    	dataType : 'json',
        columns: [
        { 
        	display: '学生ID', 
        	name: 'student_id',
        	width: 50,
        	hide:true
           
        },
        { 
        	display: '账号', 
        	name: 'user_name',
            editor: { type: 'text'},
            render:function(row){
            	return row.userName;
            }
        },
        { 
        	display: '密码', 
        	name: 'password',
        	editor: { type: 'text' }
        },
        { 
        	display: '性别', 
        	width: 50, 
        	name: 'sex', 
            /*editor: { type: 'select', data: sexData, valueField: 'Sex' },
            render: function (item)
            {
                if (parseInt(item.Sex) == 1) return '男';
                return '女';
            }*/
        },
        { 
        	display: '创建时间', 
        	name: 'createTimeStr',
        	width: 50
        },
        { 
        	display: '更新时间', 
        	name: 'updateTimeStr',
        	width: 50
        },
        { 
        	display: '状态', 
        	name: 'status',
            editor: { type: 'text' },
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
            render: function (rowdata)
        	{
	           if(rowdata.status=="0"){
	        	   return "<p>管理员</p>";
	           }else if(rowdata.status=="1"){
	        	   return "<p style='color:green'>学生</p>";
	           }else if(rowdata.status=="2"){
	        	   return "<p style='color:yellow'>未认证</p>";
	           }else if(rowdata.status=="3"){
	        	   return "<p style='color:blue'>认证中</p>";
	           }else{
	        	   return "<p style='color:red'>其他</p>";
	           }
        	}
        },
        { 
        	display: '姓名', 
        	name: 'student_name',
            editor: { type: 'text'},
            render:function(row){
            	return row.studentName;
            }
        },
        { 
        	display: '年龄', 
        	name: 'age', 
        	type: 'int', 
        	editor: { type: 'int'} 
        },
        { 
        	display: '手机', 
        	name: 'telephone',
            editor: { type: 'text' }
        },
        { 
        	display: '地址', 
        	name: 'address',
        	width: 150,
            editor: { type: 'text' }
        },
        { 
        	display: '邮箱', 
        	name: 'email',
            editor: { type: 'text' }
        },
        { 
        	display: '微信号', 
        	name: 'wechat',
            editor: { type: 'text' }
        },
        { 
        	display: 'QQ', 
        	name: 'qq',
        	editor: { type: 'text' }
        },
        { 
        	display: '操作', 
        	isSort: false, 
        	width: 150,
        	render: function (rowdata, rowindex, value)
        	{
	           var h = "";
	           h += "<a href='javascript:studentInfoDetail(\""+rowdata.id+"\")'>查看</a> ";
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
        enabledEdit: true,
        clickToEdit:false,
        width: '100%',
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
		gridManager.setOptions( 
				{ 
					parms: [
							{ name: 'userName', value: userName},
							{ name: 'studentName', value: studentName},
							{ name: 'status', value: status}
						]
				} 
			); 
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
		var userName = $("#userName").val().trim();
		var studentName = $("#studentName").val().trim();
		var status = $("#status").val().trim();
		var isvalid = $("#isvalid").val().trim();
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