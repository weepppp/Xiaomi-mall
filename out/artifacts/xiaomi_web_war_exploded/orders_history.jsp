<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
    <title>购物车</title>
    <link href="css/index.css"  rel="stylesheet"  rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
</script>
</head>
<body>
    <div class="order_head">
        <div class="head_background">
            <div class="head_box">
                <a href="index.html" class="head_left_a"><img src="img/logo.jpg" alt="" class="head_left_p"></a>
                <h1 class="head_h1">历史订单</h1>
                <div class="head_right">
                    <span class="head_right_in">${sessionScope.user.name }</span>
                    <span class="head_right_in">|</span>
                    <a href="IndexServlet?mark=showIndexData" class="head_right_in">继续购物</a>
                </div>

            </div>
        </div>
    </div>
    <div class="trolley_background" >
    		<table border="1" cellspacing="0" style="width: 1200px;background-color: #FFF;margin-left: 80px" >
	           	<tr style="height: 80px;">
	           		<th width="220px">订单号</th>
	           		<th>商品信息</th>
	           		<th>总价</th>
	           		<th>订单状态</th>
	           		<th width="220px">创建时间</th>

	           	</tr>
	           	
                   <c:forEach items="${ordersList}"  var="orders">
		           	<tr  style="height: 80px;">
		           		<td style="text-align: center;">${orders.orders_number}</td>
		           		<td style="text-align: center;">
                               <c:forEach items="${orders.trolleyList}" var="trolley" varStatus="sta">
								    <c:if test="${sta.index==0}">
										${trolley.product.name}
									</c:if>

								   <c:if test="${sta.index!=0}">
									   ,${trolley.product.name}
								   </c:if>

							   </c:forEach>
		           		</td>
		           		<td style="text-align: center;">${orders.sum_price}</td>
		           		<td style="text-align: center;">
		           			<!-- 0,未支付、1,待发货、2,已发货、3,已收货 -->
		           			<c:if test="${orders.state==0}">未支付</c:if>
		           			<c:if test="${orders.state==1}">待发货</c:if>
		           			<c:if test="${orders.state==2}">已发货</c:if>
		           			<c:if test="${orders.state==3}">已收货</c:if>
		           		</td>
		           		<td style="text-align: center;">${orders.create_time}</td>
		           		<td style="text-align: center;"></td>
		           	</tr>
				   </c:forEach>
           </table>
    </div>



    <script>
    </script>
</body>
</html>