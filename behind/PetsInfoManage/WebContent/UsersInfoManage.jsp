<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息管理</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	function deleteUsers(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].users_id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("usersDelete",{delIds:ids},function(result){
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

	function searchUsers(){
		$('#dg').datagrid('load',{
			users_id:$('#users_id').val(),
			users_name:$('#users_name').val(),
			users_address:$('#users_address').combobox("getValue"),
			users_phone:$('#users_phone').val(),
			users_role:$('#users_role').combobox("getValue")
		});
	}
	
	
	function openUsersAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加用户信息");
		url="usersSave";
	}
	
	function saveUsers(){
		$("#fm").form("submit",{
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
		$("#users_name").val("");
		$("#users_password").val("");
		$("#users_address").combobox("setValue","");
		$("#users_role").combobox("setValue","");
		$("#users_phone").val("");
	}
	
	function closeUsersDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openUsersModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑用户信息");
		$("#fm").form("load",row);
		url="usersSave?users_id="+row.users_id;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="用户信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="usersList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="users_id" width="50" align="center">编号</th>
				<th field="users_name" width="70" align="center">姓名</th>
				<th field="users_password" width="100" align="center" hidden="true">密码</th>
				<th field="users_address" width="100" align="center">地址</th>
				<th field="users_phone" width="100" align="center">联系电话</th>
				<th field="users_role" width="100" align="center" hidden="true">角色ID</th>
				<th field="roles_name" width="100" align="center">角色类别</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openUsersAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openUsersModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteUsers()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
		&nbsp;姓名：&nbsp;<input type="text" name="users_name" id="users_name" size="10"/>
		
		&nbsp;地址：&nbsp;<select class="easyui-combobox" id="users_address" name="users_address" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="长沙">长沙</option>
			<option value="株洲">株洲</option>
		</select>
		&nbsp;所属角色：&nbsp;<select class="easyui-combobox" id="users_role" name="users_role" editable="false" panelHeight="auto">
		    <option value="-1">请选择...</option>
			<option value="1">系统管理员</option>
			<option value="2">普通用户</option>
		</select>
		<a href="javascript:searchUsers()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="users_name" id="users_name" class="easyui-validatebox" required="true"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>密码：</td>
					<td><input type="text" name="users_password" id="users_password" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><select class="easyui-combobox" id="users_address" name="users_address" editable="false" panelHeight="auto" style="width: 155px">
					    <option value="">请选择...</option>
						<option value="长沙">长沙</option>
						<option value="株洲">株洲</option>
					</select></td>
					<td></td>
					<td>电话号码：</td>
					<td><input type="text" name="users_phone" id="users_phone" class="easyui-validatebox" required="true" validType="users_phone"/></td>
				</tr>
				<tr>
					<td>角色类别：</td>
					<td><select class="easyui-combobox" id="users_role" name="users_role" editable="false" panelHeight="auto" style="width: 155px">
					    <option value="-1">请选择...</option>
			            <option value="1">系统管理员</option>
			            <option value="2">普通用户</option>
					</select></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:saveUsers()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeUsersDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>