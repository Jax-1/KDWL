<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"
	+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="../user.jsp"/>
<html>
<head>
    <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="<%=basePath%>css/site.css" type="text/css" rel="stylesheet">
  <title>后台管理 -- 修改动向</title>
  <script src="<%=basePath%>js/jquery-1.10.2.min.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/jquery.validate.js" type="text/javascript"></script>
  <script type="text/javascript" src="<%=basePath%>js/DatePicker/WdatePicker.js" defer="defer"></script>
  <style type="text/css"></style>
  <script type="text/javascript">
		$().ready(function() {
			//表单验证

			$("#activity_from_id").validate({
				rules: {
					'activity.activitytext': {maxlength:100},
					'activity.location': {maxlength:100},
					'activity.memo': {maxlength:1000}
				}
			});
			
			//去空格
			$("input[type=text]").change(function(){ 
			    $('input[type=text]:not(:disabled)').each(function(){
			        $(this).val($.trim($(this).val()));   
			    });   
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
			<div id="title_text">修改动向</div>
			
			<div class="linktext" style="line-height: 50px;text-align: right;">
				<a href="<%=basePath%>queryDetail?shipmentid=${shipmentid}">返回管理页面</a>
                &nbsp;<a href="<%=basePath%>logout">登出</a>
			</div>
		</div>

  	<form name="activity_from" id="activity_from_id" action="<%=basePath%>updateActivity" method="post">
  		<input type="hidden" name="shipmentid" value="${shipmentid}">
  		<input type="hidden" name="activity.id" value="${activity.id}">
  		
		<div id="chartarea">
		  	<div style="margin: 0 auto;">
				<table width="100%" height="100" border="0" >
					<tr>
						<td align="right" width="30%">单号：</td>
						<td align="left" width="70%">
							<input type="text" name="activity.kdno" value="${activity.kdno}" readonly>
						</td>
					</tr>
					<tr>
						<td align="right">合作物流公司：</td>
						<td align="left">
							<input type="hidden" name="activity.teamtype" value="${activity.teamtype}" readonly>
							<input type="text" name="activity.teamname" value="${activity.teamname}" readonly>
						</td>
					</tr>
					<tr>
						<td align="right">合作物流公司运单号：</td>
						<td align="left">
							<input type="text" name="activity.teamno" value="${activity.teamno}" readonly>
						</td>
					</tr>
					
					<tr>
						<td align="right">动向：</td>
						<td align="left">
							<input type="text" name="activity.activitytext" value="${activity.activitytext}">
						</td>
					</tr>
					<tr>
						<td align="right">时间：</td>
						<td align="left"><input type="text" name="activity.recordtime" class="Wdate" readonly
								 onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="${shipment.deliverytime}">
						</td>
					</tr>
					<tr>
						<td align="right">货物详情：</td>
						<td align="left">
							<input type="text" name="activity.location" value="${activity.location}">
						</td>
					</tr>
					<tr>
						<td align="right">备注：</td>
						<td align="left">
							<input type="text" name="activity.memo" value="${activity.memo}">
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