<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"
	+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../user.jsp"/>
<html>
<head>
    <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="<%=basePath%>css/site.css" type="text/css" rel="stylesheet">
  <title>后台管理 -- 修改运单</title>
  <style type="text/css"></style>
  <script src="<%=basePath%>js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/jquery.validate.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=basePath%>js/DatePicker/WdatePicker.js" defer="defer"></script>
	<script type="text/javascript">
		$().ready(function() {
			if ( $("#ttypeid").val() != "" ){
				$("#nametext").hide();
			}
			
			$.ajax({
				url : 'getTeamJSON',
				cache : false, async : true, type : "get", dataType : 'json',
				success : function (json){
					var optionHtml= [];
					for( var p in json ){
						if( isNaN(p) )continue;
						
						optionHtml.push(
							"<option value='"
							+ json[p].teamtype
							+ "' " + ($("#ttypeid").val() == json[p].teamtype?"selected":"" ) +">" + json[p].teamname
							+"</option>");
					}
					$("#teamselect").append(optionHtml.join(''));
				},
				error: function (XMLHttpRequest, textStatus, errorThrown){
					 try{
						 log(XMLHttpRequest.responseText);
					 }
					 catch (e){}
				 }
			});
			
			//表单验证
			$("#shipment_from_id").validate({
				rules: {
					'shipment.kdno': {required:true, maxlength:100},
					'shipment.teamname': {maxlength:100},
					'shipment.teamno': {maxlength:100},
					'shipment.shipper': {maxlength:100},
					'shipment.deliverytime': {maxlength:100},
					'shipment.receiver': {maxlength:100},
					'shipment.gtype': {maxlength:100},
					'shipment.actualweight': {number:true, maxlength:100},
					'shipment.volweight': {number:true, maxlength:100},
					'shipment.pcs': {digits:true, maxlength:100},
					'shipment.chargeweight': {number:true, maxlength:100}
				}
			});
			
			//去空格
			$("input[type=text]").change(function(){ 
			    $('input[type=text]:not(:disabled)').each(function(){
			        $(this).val($.trim($(this).val()));   
			    });   
			});
			

			$("#teamselect").change(function(){
				if( $("#teamselect").val() == "" ){
					$("#nametext").show();
				}else{
					$("#nametext").hide();
				}
				
				$("#ttypeid").val( $("#teamselect").val() );
				
				if( $("#teamselect").val() != '' ){
					$("#tnameid").val( $("#teamselect").find("option:selected").text() );
				}else{
					$("#tnameid").val( '' );
				}
			});
			
			$("#nametext").change(function(){
				$("#tnameid").val( $("#nametext").val() );
			});
			
			
		});
	</script>
</head>
<body>
<div id="wrapper">
	<div id="container">
  
		<div id="header" style="text-align: left;">
			<span style="font-size: 45px;font-weight: bold;color:#0313D6">深圳市快德物流有限公司</span>
			<span style="font-size: 15px;font-weight: bold;">后台管理</span>
		</div>
    
		<div id="screen_icon" style="background-image:url(http://www.kdsexp.com/images/screen_icon_purple.gif);">
			<div id="title_text">修改运单</div>
			
			<div class="linktext" style="line-height: 50px;text-align: right;">
				<a href="<%=basePath%>manage/manageshipment.jsp">返回管理页面</a>
                &nbsp;<a href="<%=basePath%>logout">登出</a>
			</div>
		</div>

  	<form name="shipment_from" id="shipment_from_id" action="<%=basePath%>updateShipment" method="post">
  		<input type="hidden" name="shipment.id" value="${shipment.id}">
        <input type="hidden" name="shipment.uid" value="${shipment.uid}">
  	
		<div id="chartarea">
		  	<div style="margin: 0 auto;">
				<table width="100%" height="100" border="0" >
					<tr>
						<td align="right" width="30%">单号：</td>
						<td align="left" width="70%">
							<input type="text" name="shipment.kdno" value="${shipment.kdno}">
						</td>
					</tr>
					<tr>
						<td align="right">合作物流公司：</td>
						<td align="left">
							<select id="teamselect">
								<option value=""> 其他 </option>
							</select>
							<input type="hidden" name="shipment.teamtype" id="ttypeid" value="${shipment.teamtype}"/>
							<input type="hidden" name="shipment.teamname" id="tnameid" value="${shipment.teamname}"/>
							<input type="text" id="nametext" value="${shipment.teamname}"/>
						</td>
					</tr>
					<tr>
						<td align="right">合作物流公司运单号：</td>
						<td align="left">
							<input type="text" name="shipment.teamno" value="${shipment.teamno}">
						</td>
					</tr>
					<tr>
						<td align="right">发货公司：</td>
						<td align="left">
							<input type="text" name="shipment.shipper" value="${shipment.shipper}">
						</td>
					</tr>
					<tr>
						<td align="right">发货时间：</td>
						<td align="left">
							<input type="text" name="shipment.deliverytime" class="Wdate" readonly
								 onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="${shipment.deliverytime}">
						</td>
					</tr>
					<tr>
						<td align="right">接收人：</td>
						<td align="left">
							<input type="text" name="shipment.receiver" value="${shipment.receiver}">
						</td>
					</tr>
					<tr>
						<td align="right">货物类型：</td>
						<td align="left">
							<input type="text" name="shipment.gtype" value="${shipment.gtype}">
						</td>
					</tr>
					<tr>
						<td align="right">净重：</td>
						<td align="left">
							<input type="text" name="shipment.actualweight" value="${shipment.actualweight}">
                            &nbsp;
                            <select name="shipment.awunit">
                                <option ${shipment.awunit=='KG'?'selected':''}>KG</option>
                                <option ${shipment.awunit=='G'?'selected':''}>G</option>
                                <option ${shipment.awunit=='m³'?'selected':''}>m³</option>
                            </select>
						</td>
					</tr>
					<tr>
						<td align="right">体积重：</td>
						<td align="left">
							<input type="text" name="shipment.volweight" value="${shipment.volweight}">
                            &nbsp;
                            <select name="shipment.vwunit">
                                <option ${shipment.vwunit=='KG'?'selected':''}>KG</option>
                                <option ${shipment.vwunit=='G'?'selected':''}>G</option>
                                <option ${shipment.vwunit=='m³'?'selected':''}>m³</option>
                            </select>
						</td>
					</tr>
					<tr>
						<td align="right">件数：</td>
						<td align="left">
							<input type="text" name="shipment.pcs" value="${shipment.pcs}">
                            &nbsp;
                            <select name="shipment.pcsunit">
                                <option ${shipment.pcsunit=='件'?'selected':''}>件</option>
                                <option ${shipment.pcsunit=='卡板'?'selected':''}>卡板</option>
                            </select>
						</td>
					</tr>
					<tr>
						<td align="right">计费重量：</td>
						<td align="left">
							<input type="text" name="shipment.chargeweight" value="${shipment.chargeweight}">
                            &nbsp;
                            <select name="shipment.cwunit">
                                <option ${shipment.cwunit=='KG'?'selected':''}>KG</option>
                                <option ${shipment.cwunit=='G'?'selected':''}>G</option>
                                <option ${shipment.cwunit=='m³'?'selected':''}>m³</option>
                            </select>
						</td>
					</tr>
					<tr>
						<td align="right">是否签收：</td>
						<td align="left">
							<select name="shipment.receiveflag">
								<option value="0">否</option>
								<option value="1" ${shipment.receiveflag == 1?'selected':''}>是</option>
							</select>
							已签收，表示不再更新动态
						</td>
					</tr>
					
					<tr><td></td><td align="left"><input type="submit" value="提交"></td></tr>
				</table>
			</div>
		
		</div>
    </form>

	</div>
</div>
</body>
</html>