
function f_initGrid(){
	
	/***日期控件初始化***/
	$("#startTime").ligerDateEditor({ /*showTime: true, label: '入学时间', */labelWidth: 100, labelAlign: 'left' });
	$("#endTime").ligerDateEditor({ /*showTime: true, label: '入学时间', */labelWidth: 100, labelAlign: 'left' });
	
    g = manager = $("#maingrid").ligerGrid({
    	url:dataUrl,
        columns: [
        { 
        	display: '执行用户', 
        	name: 'userName',
        	width: '10%',
        	render:function(row){
        		return row.userName;
        	}
        },
        { 
        	display: '执行时间', 
        	name: 'inserttime',
        	width: '30%',
        	render:function(row){
        		return row.inserttime_str;
        	}
        },
        { 
        	display: '操作内容', 
        	name: 'actinfo',
        	width: '60%',
        	isSort:false
        }
        ],
        dataAction: 'server', 
        usePager:true,
        checkbox:true,
        isScroll: true, 
        showTableToggleBtn:true,
        sortName: "inserttime",
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
    
    /***提交***/
	$("#submit_btn").click(function(){
		gridManager = $("#maingrid").ligerGetGridManager(); 
		var userName = $("#userName").val().trim();
		var startTime = $("#startTime").val().trim();
		var endTime = $("#endTime").val().trim();
		gridManager.setOptions( 
				{ 
					parms: [
							{ name: 'userName', value: userName},
							{ name: 'startTime', value: startTime},
							{ name: 'endTime', value: endTime}
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
	
	/***批量删除***/
	$("#cancel_btn").click(function(){
		var ids = f_getChecked();
		var url = "log/cancelLogByIds";
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

function f_onCheckAllRow(checked)
{
    for (var rowid in this.records)
    {
        if(checked)
            addCheckedRow(this.records[rowid]['id']);
        else
            removeCheckedRow(this.records[rowid]['id']);
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

///**
// * 根据id下载
// * @param id
// */
//function fileDownload(id){
//	var url = "fileOperate/download?id="+id;
//	window.open(url,"资源下载");
//}
///**
// * 根据id查看详情
// * @param id
// */
//function viewDetail(id){
//	var url = "fileOperate/showFileResourceById?id="+id;
//	$.ligerDialog.open({
//		height : 500,
//		url : url,
//		width : null,
//		showMax : true,
//		showToggle : false,
//		showMin : false,
//		isResize : false,
//		modal : false,
//		title : "资源详情"
//	});
//}

function reloadGrid(){
	gridManager.setOptions( {parms: []} );
	gridManager.loadData();
}