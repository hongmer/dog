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
	
	function deletePetsAdop(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].pets_id);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("petsAdopDelete",{delIds:ids},function(result){
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

	function searchPetsAdop(){
		$('#dg').datagrid('load',{
			pets_id:$('#pets_id').val(),
			pets_name:$('#pets_name').val(),
			pets_species:$('#pets_species').val(),
			pets_kind:$('#pets_kind').combobox("getValue"),
			pets_address:$('#pets_address').combobox("getValue"),
			pets_adopCondition:$('#pets_adopCondition').val(),
			pets_describe:$('#pets_describe').val(),
			pets_linkman:$('#pets_linkman').val(),
			pets_lmPhone:$('#pets_lmPhone').val(),
		});
	}
	
	
	function openPetsAdopAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加宠物领养发布信息");
		url="petsAdopSave";
	}
	
	function savePetsAdop(){
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
		$("#pets_name").val("");
		$("#pets_species").val("");
		$("#pets_kind").combobox("setValue","");
		$("#pets_address").combobox("setValue","");
		$("#pets_linkman").val("");
		$("#pets_lmPhone").val("");
		$("#send_time").datebox("setValue","");
		$("#pets_adopCondition").val("");
		$("#pets_describe").val("");
		
	}
	
	function closePetsAdopDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openPetsAdopModifyDialog(){
		var selectedRows=$("#dlg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.message.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑宠物领养发布信息");
		$("#fm").form("load",row);
		url="PetsAdopSave?pets_id="+row.pets_id;
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="宠物领养信息" class="easyui-datagrid" fitColumns="true"
	 pagination="true" rownumbers="true" url="petsAdopList" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="pets_id" width="50" align="center">编号</th>
				<th field="pets_name" width="50" align="center">姓名</th>
				<th field="pets_kind" width="50" align="center" hidden="true">物种</th>
				<th field="pets_species" width="50" align="center" >品种</th>
				<th field="pets_address" width="50" align="center">所在地</th>
				<th field="pets_adopCondition" width="50" align="center">领养条件</th>
				<th field="pets_describe" width="50" align="center">宠物描述</th>
				<th field="pets_linkman" width="50" align="center">联系人</th>
				<th field="pets_lmPhone" width="50" align="center">联系人电话</th>
				<th field="sender_id" width="50" align="center" hidden="true">发布者ID</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openPetsAdopAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openPetsAdopModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deletePetsAdop()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
		&nbsp;编号：&nbsp;<input type="text" name="pets_id" id="pets_id" size="10"/>
		&nbsp;姓名：&nbsp;<input type="text" name="pets_name" id="pets_name" size="10"/>
		&nbsp;物种：&nbsp;<select class="easyui-combobox" id="pets_kind" name="pets_kind" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="猫">猫</option>
			<option value="狗">狗</option>
			<option value="其他">其他</option>
		</select>
		&nbsp;发布时间：&nbsp;<input class="easyui-datebox" name="btime" id="btime" editable="false" size="10"/>-><input class="easyui-datebox" name="etime" id="etime" editable="false" size="10"/>
		&nbsp;所在地：&nbsp;<select class="easyui-combobox" id="pets_address" name="pets_address" editable="false" panelHeight="auto">
		    <option value="">请选择...</option>
			<option value="长沙">长沙</option>
			<option value="株洲">株洲</option>
			<option value="其他">其他</option>
		</select>
		<a href="javascript:searchPetsAdop()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a></div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="pets_name" id="pets_name" class="easyui-validatebox" required="true"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>品种：</td>
					<td><input type="text" name="pets_species" id="pets_species" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>物种：</td>
					<td><select class="easyui-combobox" id="pets_kind" name="pets_kind" editable="false" panelHeight="auto" style="width: 155px">
					    <option value="">请选择...</option>
						<option value="狗">狗</option>
						<option value="猫">猫</option>
						<option value="其他">其他</option>
					</select></td>
					<td></td>
					<td>联系人：</td>
					<td><input type="text" name="pets_linkman" id="pets_linkman" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>联系人电话：</td>
					<td><input type="text" name="pets_lmPhone" id="pets_lmPhone" class="easyui-validatebox" required="true" /></td>
					<td></td>
					<td>发布时间：</td>
					<td><input class="easyui-datebox" name="btime" id="btime" editable="false" size="10"/></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>	
				</tr>
				<tr>
					<td valign="top">宠物描述：</td>
					<td colspan="4"><textarea rows="7" cols="50" name="pets_describe" id="pets_describe"></textarea></td>
				</tr>
				<tr>
					<td valign="top">领养条件：</td>
					<td colspan="4"><textarea rows="7" cols="50" name="pets_adopCondition" id="pets_adopCondition"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:savePetsAdop()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closePetsAdopDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>