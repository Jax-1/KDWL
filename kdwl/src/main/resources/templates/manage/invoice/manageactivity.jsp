<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="p" uri="/WEB-INF/page.tld"%>
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
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
	<link href="<%=basePath%>css/pagination.css" type="text/css" rel="stylesheet"/>
	<link href="<%=basePath%>css/site.css" type="text/css" rel="stylesheet">
	<title>后台管理 -- 运单详情查询</title>
	<style type="text/css">
		.detial_tr{
			font-size:13px;
		}
		.detial_tr td{
			border-left: #d0d0d0 1px dotted;
			border-bottom: #d0d0d0 1px dotted;
			padding: 2px;
		}
		a img
		{ 
			border:none;
		}
	</style>
	<script src="<%=basePath%>js/jquery-1.10.2.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
<form name="activity_from" action="<%=basePath%>queryactivity" method="post">
<div id="wrapper">
	<div id="container">
  
		<div id="header" style="text-align: left;">
			<span style="font-size: 45px;font-weight: bold;color:#0313D6">深圳市快德物流有限公司</span>
			<span style="font-size: 15px;font-weight: bold;">后台管理</span>
		</div>
    
    	<div id="screen_icon" 
    		style="background-image:url(http://www.kdsexp.com/images/screen_icon_purple.gif);">
			<div id="title_text">运单详情查询</div>
      
			<div class="linktext" style="line-height: 50px;text-align: right;">
				<a href="<%=basePath%>manage/manageshipment.jsp">返回管理页面</a>
				&nbsp;
				<a href="<%=basePath%>opennewActivity?shipmentid=${shipmentid}">新增动向</a>
                &nbsp;<a href="<%=basePath%>logout">登出</a>
			</div>
		</div>
			
		<div id="chartnavi" class="dateinfo">
			<div class="dateinfo"></div>
		</div>
		

		<div class="dateinfo" style="height:25px;"></div>
		
		<div id="chartarea_deatil" class="mgn_top_13 clearfix" 
				style="width: 972px;border: #d0d0d0 1px solid;padding: 3px;">
			<div id="charttitle">
				<table border="0" cellpadding="0" cellspacing="0" summary="sample">
				<tbody>
					<tr>
					<th class="bg" rowspan="1" colspan="1">
						<span class="mgn_r_5">
						<img src="http://www.kdsexp.com/images/tabletitle_mark.gif" alt="title" width="5" height="12">
						</span>
						运单详细
					</th>
					</tr>
					<tr>
						<td rowspan="1" colspan="1">
							<img src="http://www.kdsexp.com/images/spacer.gif" alt="" width="1px" height="1px">
						</td>
					</tr>
				</tbody>
				</table>
			</div>
			
			<table border="0" width="100%" height="25px"
				class="table" align="center">
				<tbody id="chart_header">
				<tr>
					<td width="90">货运单号</td>
					<td width="100">物流公司</td>
					<td width="90">物流单号</td>
					<td width="100">发货公司</td>
					<td width="150">时间</td>
					<td width="100">签收人</td>
					<td width="90">类型</td>
					<td width="50">数量</td>
					<td width="60">净重</td>
					<td width="60">体积重</td>
					<td width="60">计费重</td>
					<td width="50" title="已签收，表示不再更新动态">签收</td>
				</tr>
			</tbody>
			</table>
			<table border="0" width="100%" height="25px" class="table" align="center">
			<tbody id="chart">
		   		<tr class="a1" id="tr_data_<s:property value="shipment.id"/>">
		   			<td width="90"><s:property value="shipment.kdno"/></td>
					<td width="100"><s:property value="shipment.teamname"/></td>
					<td width="90"><s:property value="shipment.teamno"/></td>
					<td width="100"><s:property value="shipment.shipper"/></td>
					<td width="150">
						<s:date name="shipment.deliverytime" format="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td width="100"><s:property value="shipment.receiver"/></td>
					<td width="90"><s:property value="shipment.gtype"/></td>
					<td width="50"><s:property value="shipment.pcs"/><s:property value="shipment.pcsunit"/></td>
					<td width="60"><s:property value="shipment.actualweight"/><s:property value="shipment.awunit"/></td>
					<td width="60"><s:property value="shipment.volweight"/><s:property value="shipment.vwunit"/></td>
					<td width="60"><s:property value="shipment.chargeweight"/><s:property value="shipment.cwunit"/></td>
					<td width="50">
						<s:if test="shipment.receiveflag==1">是</s:if>
						<s:else>否</s:else>
					</td>
		   		</tr>
			</tbody>
			</table>
        
			<table border="0" cellpadding="0" cellspacing="0" 
					summary="sample" style="border:#d0d0d0 1px dotted;" width="100%">
			<tbody id="chart_header">
				<tr>
					<td width="250">动向</td>
					<td width="150">时间</td>
					<td width="250">货物详情</td>
					<td width="100">备注</td>
					<td width="50">操作</td>
				</tr>
			</tbody>
			<tbody id="chart">
			   	<s:iterator value="shipment.activitylist" id="obj" status="status">
				<tr class="detial_tr">
				  <td width="250" style="border-width:0px 0px 1px 0px;"><s:property value="activitytext"/></td>
				  <td width="150" style="border-width:0px 0px 1px 0px;">
				  	<s:date name="recordtime" format="yyyy-MM-dd HH:mm:ss" />
				  </td>
				  <td width="250" align="left"><s:property value="location"/></td>
				  <td width="100" style="border-width:0px 0px 1px 0px;"><s:property value="memo"/></td>
				  <td width="50" style="border-width:0px 0px 1px 0px;">
				  	<div class="editdiv" title="修改">
					  	<a style="text-decoration:none" href="<%=basePath%>modifyActivity?id=<s:property value="id"/>&shipmentid=${shipmentid}">
					  		&nbsp;
					  	</a>
				  	</div>
					<div class="deldiv" title="删除">
						<a style="text-decoration:none" href="<%=basePath%>delActivity?id=<s:property value="id"/>&shipmentid=${shipmentid}" 
				    		onclick="return confirm('确认删除\'<s:property value="activitytext"/>\'吗?');">
					    	&nbsp;
					    </a>
				    </div>
				  </td>
				</tr>
				</s:iterator>
			</tbody>
			</table>
		
		
		
		
      </div>
		
	</div>
</div>


</form>


</body>
</html>