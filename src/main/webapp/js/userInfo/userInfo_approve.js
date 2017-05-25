
function f_initGrid()
{
    g = manager = $("#maingrid").ligerGrid({
    	url:"user/queryUserInfoJson?jsonType=confirm",
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
        	width: '10%',
        	align:'left',
            render:function(row){
            	return row.userName;
            }
        },
        { 
        	display: '密码', 
        	name: 'password',
        	hide:true
        },
        { 
        	display: '性别', 
        	width: '5%',
        	name: 'sex' 
        },
        { 
        	display: '创建时间', 
        	name: 'createTimeStr',
        	width: '10%'
        },
        { 
        	display: '更新时间', 
        	name: 'updateTimeStr',
        	width: '10%'
        },
        { 
        	display: '状态', 
        	name: 'status',
        	width: '5%',
            render: function (rowdata)
        	{
	           if(rowdata.status=="0"){
	        	   return "<p style='color:green'>正常</p>";
	           }else {
	        	   return "<p style='color:red'>其他</p>";
	           }
        	}
        },
        { 
        	display: '类型', 
        	name: 'type',
        	width: '5%',
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
        	width: '3%'
        },
        { 
        	display: '手机', 
        	name: 'telephone',
        	width: '10%',
        	align:'left',
        	render: function(rowdata){
        		return "<p title='"+rowdata.telephone+"'>"+rowdata.telephone+"</p>";
        	}
        },
        { 
        	display: '地址', 
        	name: 'address',
        	width: '10%',
        	align:'left',
        	render: function(rowdata){
        		return "<p title='"+rowdata.address+"'>"+rowdata.address+"</p>";
        	}
        },
        { 
        	display: '邮箱', 
        	name: 'email',
        	width: '9%',
        	align:'left',
        	render: function(rowdata){
        		return "<p title='"+rowdata.email+"'>"+rowdata.email+"</p>";
        	}
        },
        { 
        	display: '微信号', 
        	name: 'wechat',
        	width: '5%',
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
        	width: '8%',
        	render: function (rowdata, rowindex, value)
        	{
	           var h = "";
	           h += "<a href='javascript:approve(\""+rowdata.id+"\")'>通过</a> ";
	           h += "<a href='javascript:refuse(\""+rowdata.id+"\")'>拒绝</a> ";
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
        width: '99%',
        height : "100%"
    });
    
    /***提交***/
	$("#submit_btn").click(function(){
		gridManager = $("#maingrid").ligerGetGridManager(); 
		var userName = $("#userName").val().trim();
		var studentName = $("#studentName").val().trim();
		var sex = $("#sex").val().trim();
		gridManager.setOptions( 
				{ 
					parms: [
							{ name: 'userName', value: userName},
							{ name: 'sex', value: sex},
							{ name: 'studentName', value: studentName}
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
 * 批准
 * @param studentId
 */
function approve(id){
	var url = "user/userApplyOpertate";
	$.post(
		url,
		{id:id,type:"approve"},
		function(data){
			if(data=="success"){
				g.reload();
			}
		}
	);
}

/**
 * 拒绝
 * @param id
 */
function refuse(id){
	var url = "user/userApplyOpertate";
	$.post(
		url,
		{id:id,type:"refuse"},
		function(data){
			if(data=="success"){
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

/***重新载入表格***/
function reloadGrid(){
	gridManager.setOptions( {parms: []} );
	gridManager.loadData();
}