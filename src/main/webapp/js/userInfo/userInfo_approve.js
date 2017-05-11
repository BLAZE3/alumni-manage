
function f_initGrid()
{
    g = manager = $("#maingrid").ligerGrid({
    	url:"user/queryUserInfoJson?type=confirm",
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
        width: '100%',
        height : "100%",
        onSelectRow: function (rowdata, rowindex)
        {
            $("#txtrowindex").val(rowindex);
        }
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

/***重置表格***/
function resetGrid(){
	$(".select").val("");
	gridManager.setOptions( {parms: []} );
	gridManager.loadData();
}

/***重新载入表格***/
function reloadGrid(){
	gridManager.setOptions( {parms: []} );
	gridManager.loadData();
}