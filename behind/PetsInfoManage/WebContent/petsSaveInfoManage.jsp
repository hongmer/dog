<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>流浪猫狗后台信息管理平台</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	function deletePetsSave(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].save_id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("petsSaveDelete",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示',result.errorMsg);
					}
				},"json");
			}
		});
	}

	function searchPetsSave(){
		$('#dg').datagrid('load',{
			save_id:$('#save_id').val(),
			save_linkman:$('#save_linkman').val(),
			save_lmPhone:$('#save_lmPhone').val(),
			save_address:$('#save_address').combobox("getValue"),
			save_describe:$('#save_describe').val(),
			
		});
	}
	
	
	function openPetsSaveAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加宠物求助发布信息");
		url="petsSaveSave";
	}
	
	function savePetsSave(){
		$("#dlg").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function resetValue(){
		$("#save_linkman").val("");
		$("#save_lmPhone").val("");
		$("#save_address").combobox("setValue","");
		$("#save_describe").val("");
	}
	
	function closePetsSaveDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openPetsSaveModifyDialog(){
		var selectedRows=$("#dlg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑宠物求助发布信息");
		$("#fm").form("load",row);
		url="PetsAdopSave?save_id="+row.save_id;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="宠物领养信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="petsSaveList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="save_id" width="50" align="center">编号</th>
				<th field="save_linkman" width="50" align="center">联系人</th>
				<th field="save_lmPhone" width="50" align="center" >联系电话</th>
				<th field="save_address" width="50" align="center" >地址</th>
				<th field="save_describe" width="100" align="center">宠物描述</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openPetsSaveAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openPetsSaveModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deletePetsSave()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
		&nbsp;地址：&nbsp;<select class="easyui-combobox" id="save_address" name="save_address" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="长沙">长沙</option>
			<option value="株洲">株洲</option>
		</select>
		&nbsp;发送时间：&nbsp;<input class="easyui-datebox" name="btime" id="btime" editable="false" size="10"/>-><input class="easyui-datebox" name="etime" id="etime" editable="false" size="10"/>
		<a href="javascript:searchPetsSave()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>联系人：</td>
					<td><input type="text" name="stuNo" id="stuNo" class="easyui-validatebox" required="true"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>联系电话：</td>
					<td><input type="text" name="stuName" id="stuName" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>联系地址：</td>
					<td><select class="easyui-combobox" id="save_address" name="save_address" editable="false" panelHeight="auto" style="width: 155px">
					    <option value="">请选择...</option>
						<option value="长沙">长沙</option>
						<option value="株洲">株洲</option>
					</select></td>
					<td></td>
					<td>发送时间：</td>
					<td><input class="easyui-datebox" name="save_time" id="save_time" required="true" editable="false" /></td>
				</tr>
				<tr>
					<td valign="top">宠物现状描述：</td>
					<td colspan="4"><textarea rows="7" cols="50" name="save_describe" id="save_describe"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:savePetsSave()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closePetsSaveDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>