
function f_initGrid()
{
    g = manager = $("#maingrid").ligerGrid({
    	url:"user/queryUserInfoJson?jsonType=admin",
//    	dataType : 'json',
        columns: [
		{ 
			display: '用户ID', 
			name: 'id',
			hide:true
		},
        { 
        	display: '账号', 
        	name: 'userName',
        	width: '30%'
        },
        { 
        	display: '密码', 
        	name: 'password',
        	width: '20%'
        },
        { 
        	display: '是否删除', 
        	name: 'isvalid',
        	width: '20%',
        	render: function (rowdata)
        	{
	           if(rowdata.isvalid=="Y"){
	        	   return "<p style='color:green'>否</p>";
	           }else{
	        	   return "<p style='color:red'>是</p>";
	           }
        	}
        },
        { 
        	display: '操作', 
        	isSort: false, 
        	width: '30%',
        	render: function (rowdata, rowindex, value)
        	{
	           var h = "";
               if(rowdata.isvalid=="Y"){
            	   h += "<a href='javascript:cancelRow(\""+rowdata.id+"\")'>注销</a> ";
 	           }else{
 	        	   h += "<a href='javascript:enableRow(\""+rowdata.id+"\")'>启用</a> ";
 	           }
               h += "<a href='javascript:resetPassword(\""+rowdata.id+"\")'>重置密码</a> ";
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
        pagesize : 50,
        pageSizeOptions: [15,30,50],
        resizable :true,
        enabledEdit: true,
        clickToEdit:false,
        width: '100%',
        height : "100%"
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