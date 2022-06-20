<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加商品</title>
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/admin/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">添加商品</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>商品信息</span></div>
    
    <form action="" method="post">
    	<input name="method" value="add" type="hidden" />
	    <ul class="forminfo">
	    	 
	    	 <!-- 商品分类信息 -->
	    	 <li>
	    	 	<label>商品分类</label>
	    	 	<select name="cid" class="dfinput">
	    	 		<option value="0">===请选择===</option>
	    	 		
	    	 	</select>
	    	 </li>
	    	 
	    	 
		    <li><label>商品名称</label><input name="pname" type="text" class="dfinput" /><i>商品名称不能超过30个字符</i></li>
		    <li><label>颜色</label><input name="color" type="text" class="dfinput" /></li>
		    <li><label>单价</label><input name="price" type="text" class="dfinput" /></li>
		    <li><label>简介</label>
		    	<textarea name="description" cols="10" rows="10" class="textinput" style="height: 80px"></textarea>
		    </li>
		    <li><label>商品展示图</label>
		    	<input name="pic" type="file"/><font style="color: red"></font>
		    </li>
		    <li><label>商品小类别</label>
			    <cite>
				    <input name="state" type="radio" value="0" checked="checked" />正常&nbsp;&nbsp;&nbsp;&nbsp;
				    <input name="state" type="radio" value="1" />热门产品
				    <input name="state" type="radio" value="2" />为你推荐
				    <input name="state" type="radio" value="3" />新品
				    <input name="state" type="radio" value="4" />小米明星单品
			    </cite>
		    </li>
		    <li><label>型号</label><input name="version" type="text" class="dfinput" /></li>
		    
		    <li><label>生产日期</label>
		    	<input class="Wdate" style="width: 345px;height: 32px;line-height: 32px;" onclick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" name="product_date" type="text" class="dfinput" value="" />
		    </li>
		    
		    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
	    </ul>
    </form>
    </div>
</body>
</html>
