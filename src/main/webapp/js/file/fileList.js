function f_initGrid()
{
    g = manager = $("#maingrid").ligerGrid({
    	url:dataUrl/*"fileOperate/queryFileResourcesJson"*/,
        columns: [
        { 
        	display: '资源名', 
        	name: 'fileName',
        	width: '20%'
        },
        { 
        	display: '大小', 
        	name: 'fileSize',
        	width: '10%'
        },
        { 
        	display: '发布者', 
        	name: 'publisherName',
        	width: '10%'
        },
        { 
        	display: '发布时间', 
        	name: 'publishTimeStr', 
        	width: '20%'
        },
        { 
        	display: '下载次数', 
        	name: 'downCount', 
        	width: '20%'
        },
        { 
        	display: '操作', 
        	isSort: false, 
        	width: '20%',
        	render: function (rowdata, rowindex, value)
        	{
	           var h = "";
               h += "<a href='javascript:fileDownload(\""+rowdata.id+"\")'>下载</a> ";
               h += "<a href='javascript:viewDetail(\""+rowdata.id+"\")'>查看详情</a> ";
               if(file_cancel=="Y"){
            	   h += "<a href='javascript:cancelFile(\""+rowdata.id+"\")'>删除</a> ";
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
        sortName: "publish_time",
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
		var isvalid = $("#isvalid").val().trim();
		gridManager.setOptions( 
				{ 
					parms: [
							{ name: 'userName', value: userName},
							{ name: 'studentName', value: studentName},
							{ name: 'status', value: status},
							{ name: 'isvalid', value: isvalid}
						]
				} 
			); 
			gridManager.loadData(); 
	});
	
	/***重置***/
	$("#reset_btn").click(function(){
		$(".select").val("");
	});
    
}

/**
 * 根据id下载
 * @param id
 */
function fileDownload(id){
	$.ligerDialog.open({
		height : 500,
		url : 'studentInfo/forwardStudentInfoUpdate?id='+id,
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
 * 根据id查看详情
 * @param id
 */
function viewDetail(id){
	var url = "fileOperate/showFileResourceById?id="+id;
	$.ligerDialog.open({
		height : 500,
		url : url,
		width : null,
		showMax : true,
		showToggle : false,
		showMin : false,
		isResize : false,
		modal : false,
		title : "资源详情"
	});
}
/**
 * 根据id删除
 * @param id
 */
function cancelFile(id){
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
