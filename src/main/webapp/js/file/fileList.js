
function f_initGrid()
{
    g = manager = $("#maingrid").ligerGrid({
    	url:dataUrl/*"fileOperate/queryFileResourcesJson"*/,
        columns: [
        { 
        	display: '资源名', 
        	name: 'file_name',
        	width: '20%',
        	render:function(row){
        		return row.fileName;
        	}
        },
        { 
        	display: '大小', 
        	name: 'file_size',
        	width: '10%',
        	render:function(row){
        		return row.fileSize;
        	}
        },
        { 
        	display: '发布者', 
        	name: 'publisher_name',
        	width: '10%',
        	render:function(row){
        		return row.publisherName;
        	}
        },
        { 
        	display: '发布时间', 
        	name: 'publish_time', 
        	width: '20%',
        	render:function(row){
        		return row.publishTimeStr;
        	}
        },
        { 
        	display: '下载次数', 
        	name: 'down_count', 
        	width: '20%',
        	render:function(row){
        		return row.downCount;
        	}
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
               if(file_cancel=="yes"){
            	   h += "<a href='javascript:cancelFile(\""+rowdata.id+"\")'>删除</a> ";
 	           }else if(file_restore=="yes"){
            	   h += "<a href='javascript:restoreFile(\""+rowdata.id+"\")'>恢复</a> ";
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
        width: '100%',
        height: '100%',
        isChecked: f_isChecked, 
        onCheckRow: f_onCheckRow, 
        onCheckAllRow: f_onCheckAllRow
    });
    
    function f_onCheckAllRow(checked)
    {
        for (var rowid in this.records){
            if(checked){
            	addCheckedRow(this.records[rowid]['id']);
            }else {
            	removeCheckedRow(this.records[rowid]['id']);
            }
        }
    }

    /*
	    该例子实现 表单分页多选
	    即利用onCheckRow将选中的行记忆下来，并利用isChecked将记忆下来的行初始化选中
    */
    var checkedRow = [];
    function findCheckedRow(id)
    {
        for(var i =0;i<checkedRow.length;i++)
        {
            if(checkedRow[i] == id) return i;
        }
        return -1;
    }
    function addCheckedRow(id)
    {
        if(findCheckedRow(id) == -1)
            checkedRow.push(id);
    }
    function removeCheckedRow(id)
    {
        var i = findCheckedRow(id);
        if(i==-1) return;
        checkedRow.splice(i,1);
    }
    function f_isChecked(rowdata)
    {
        if (findCheckedRow(rowdata.id) == -1)
            return false;
        return true;
    }
    function f_onCheckRow(checked, data)
    {
        if (checked) addCheckedRow(data.id);
        else removeCheckedRow(data.id);
    }
    function f_getChecked()
    {
        return checkedRow.join(',');
    }
    
    /***提交***/
	$("#submit_btn").click(function(){
		gridManager = $("#maingrid").ligerGetGridManager(); 
		var fileName = $("#fileName").val().trim();
		var publisherName = $("#publisherName").val().trim();
		gridManager.setOptions( 
				{ 
					parms: [
							{ name: 'fileName', value: fileName},
							{ name: 'publisherName', value: publisherName}
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
	
	/***删除***/
	$("#del_btn").click(function(){
		var ids = f_getChecked();
		var url = "fileOperate/delFileByIds";
		$.post(url,{ids:ids},
			function(data){
				if(data=="success"){
					g.reload();
				}else {
					alert(data);
				}
			}
		);
	});
    
}

/**
 * 根据id下载
 * @param id
 */
function fileDownload(id){
	var url = "fileOperate/download?id="+id;
	window.open(url,"资源下载");
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
	var url = "fileOperate/cancelFile";
	$.post(url,{id:id},
		function(data){
			if(data=="success"){
				g.reload();
			}else {
				alert(data);
			}
		}
	);
}

/**
 * 根据id恢复
 * @param id
 */
function restoreFile(id){
	var url = "fileOperate/restoreFile";
	$.post(url,{id:id},
		function(data){
			if(data=="success"){
				g.reload();
			}else {
				alert(data);
			}
		}
	);
}

function reloadGrid(){
	gridManager.setOptions( {parms: []} );
	gridManager.loadData();
}