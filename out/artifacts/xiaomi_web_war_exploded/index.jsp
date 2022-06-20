<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>小米首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <style>

    </style>
   
</head>
<body>
    <div class="box">
        <div class="inner whiteGL">
            <div class="left">
                <a class="mix" href="${pageContext.request.contextPath}/indexServlet?mark=showInfoIndex">仿小米商城-学习专用</a>
            </div>
            <div class="right">
                <c:if test="${user !=null}">
                    <a class="mix" href="#"> ${user.username}</a>

                </c:if>
                <c:if test="${user ==null}">

                    <a class="mix" href="${pageContext.request.contextPath}/login.jsp">登录</a>
                </c:if>

                <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
                <a class="max"  href="${pageContext.request.contextPath}/ordersServlet?mark=showOrders">历史订单</a>
                <a href="${pageContext.request.contextPath}/trolleyServlet?mark=showTrolley">购物车<span id="tv_span" style="color: red">(${count})</span></a>
            </div>
        </div>
    </div>
    <div class="logo">
        <div class="logo_left">
            <div>
                <a href="javascript:void(0);" title="小米官网"><img class="xiaomi" src="img/logo.jpg"></a>
            </div>
        </div>
        <ul class="logo_center orangeGL">
           <c:forEach items="${categoryList}" var="category" varStatus="sta">
               <c:if test="${sta.index <7}">

               <a href="#">${category.name}</a>
               </c:if>

           </c:forEach>

           <%-- <a href="">红米</a>
            <a href="">笔记本</a>
            <a href="">电视</a>
            <a href="">盒子</a>
            <a href="">新品</a>
            <a href="">路由器</a>
            <a href="">智能硬件</a>
            <a href="">服务</a>
            <a href="">社区</a>--%>
        </ul>
        <formv class="logo_right">
           <div class="logo_input"><input type="text">
             <!--   <div class="logo_input_div">
                   <a class="logo_input_a" href="">小米5 新品</a>
                   <a class="logo_input_a" href="">小米Note 3</a>
               </div> -->


           </div>
            <a class="logo_right_a"><img src="img/find.jpg"></a>
            <!--<a href="">红米5新品</a>-->
            <!--<a href="">小米Noto 3</a>-->
        </formv>
    </div>
    <!-- 滚动图片 -->
    <div class="scroll">
        <ul>
            <li><a href=""><img width="1226px" height="460px" src="img/scroll_01.jpg" alt=""></a></li>
            <li><a href=""><img width="1226px" height="460px" src="img/scroll_02.jpg" alt=""></a></li>
            <li><a href=""><img width="1226px" height="460px" src="img/scroll_03.jpg" alt=""></a></li>
            <li><a href=""><img width="1226px" height="460px" src="img/scroll_04.jpg" alt=""></a></li>
            <li><a href=""><img width="1226px" height="460px" src="img/scroll_05.jpg" alt=""></a></li>
            <li><a href=""><img width="1226px" height="460px" src="img/scroll_06.jpg" alt=""></a></li>
        </ul>
        <div class="scroll_dot">
            <span class="scroll_dot_span"></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
        <div class="scroll_arrows">
            <a href="javascript:void(0);"><span class="left scroll_arrows_back">〈</span></a>
            <a href="javascript:void(0);"><span class="right scroll_arrows_back">〉</span></a>
        </div>
        <div class="scroll_left" style="height: 420px;">
            <ul class="scr-ul">
                 <c:forEach items="${categoryList}" var="category">
                <li class="scr_li"><a href="">${category.name}</a><i class="scr_i"></i></li>
                 </c:forEach>
              
            </ul>
        </div>

    </div>

    <div class="time">
        <div class="H">小米明星单品</div>
        <div class="time_in">

             <c:forEach items="${productList}" var="pro">
                <div style="background-color: #fff;width: 234px;height:320px;float: left;margin-left: 11px; ">
                    <a href="${pageContext.request.contextPath}/productServlet?mark=selectById&sid=${pro.pid}" target="_self">
                        <img class="time_min" style="width:234px;height: 234px;" src="${pageContext.request.contextPath}/file/${pro.pic}" alt="">
                    </a>
                    <div style="clear: both;"></div>

                    <div style="width: 234px;height: 85px;">
                        <div style="width: 234px;height: 20px;line-height: 20px;text-align: center;font-size: 14px;font-family: Arial">
                              ${pro.name}
                        </div>
                        <div style="width: 234px;height: 30px;line-height: 30px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">
                             ${pro.price} <span style="color: #000"> &nbsp;起始价 </span>
                        </div>
                        <div style="width: 234px;height: 35px;line-height: 35px;text-align: center;color: #000;font-size: 14px;font-family: Arial">
                            ${pro.description}
                          
                        </div>
                    </div>
                </div>
             </c:forEach>
        </div>
    </div>
    <div class="appliances">
        <div class="app_width" style="padding-top: 0px">
            <div class="app_A">家电</div>
            <div class="app_Ar orangeGL">

            </div>
            <div class="app_max">
                <div class="appl"><a href=""><img width="233px" height="615px" src="${pageContext.request.contextPath}/file/1.png" alt=""></a></div>
                <div class="appr">
                    <div class="appr_top">
                        <!-- 循环后台取到的家电的集合 -->
                        <c:forEach items="${proList}" var="p" varStatus="i">
                            <c:if test="${i.count <=4 }">
                                <div class="appr_min" id="appr_min1" style="margin-left: 12px;width: 234px;height: 300px;background-color: #FFF;text-align: center;">
                            <%--点击图片，展示商品详情页面--%>
                                    <a href="${pageContext.request.contextPath}/productServlet?mark=selectById&sid=${p.pid}" target="_self"><img width="180px" height="180px;" src="${pageContext.request.contextPath}/file/${p.pic}" alt=""></a>

                                    <div style="width: 234px;height: 100px;">
                                        <div style="width: 100%;height: 33px;text-align: center;font-size: 14px;font-family: Arial">${p.name }</div>
                                        <div style="width: 100%;height: 33px;text-align: center;font-size: 14px;font-family: Arial">${p.description }</div>
                                        <div style="width: 100%;height: 33px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">${p.price }</div>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${i.count > 4 }">
                                <div class="appr_min" style="margin-left: 12px;width: 234px;height: 300px;background-color: #FFF;text-align: center;margin-top: 15px;" id="appr_min1">
                                    <a href="${pageContext.request.contextPath}/productServlet?mark=selectById&sid=${p.pid}" target="_self"><img width="180px" height="180px;" src="${pageContext.request.contextPath}/file/${p.pic}" alt=""></a>
                                    <div style="width: 234px;height: 100px;">
                                        <div style="width: 100%;height: 33px;text-align: center;font-size: 14px;font-family: Arial">${p.name }</div>
                                        <div style="width: 100%;height: 33px;text-align: center;font-size: 14px;font-family: Arial">${p.description }</div>
                                        <div style="width: 100%;height: 33px;text-align: center;color: #ff6700;font-size: 14px;font-family: Arial">${p.price }</div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>`
    <%--<div class="capabackground">
        <div class="capacity" style="padding-top: 0px">
            <div class="capa_box_top">
                <div class="capa_box_top_al">哈哈老师</div>
                <div class="capa_box_top_ar">
                </div>
            </div>
            <div class="capa_box scrip_capa_box scrip_capa_box_on">
                <div class="capa_top">

                    <!-- 军火库  -->
                    <c:forEach items="${JHKCommodityList }" var="jhk">
                        <div class="capa capa_shadow" style="width: 231px;height: 301px;text-align: center;background-color: #FFFFFF;margin-top: 15px;">
                            <a href="IndexServlet?mark=showCommodityById&cid=${jhk.cid}" target="_blank"><img width="180px" height="180px" src="http://localhost:8080/${jhk.pic }">
                                <div class="tran">
                                    <span>${jhk.full_description }</span>
                                </div>
                            </a>
                            <div class="capa_a">
                                <ul>
                                    <li style="color: #333333">${jhk.name } </li>
                                    <li style="color: #b0b0b0">${jhk.description }</li>
                                    <li style="font-size: 14px;margin-top: 10px; color: #ff6700" >${jhk.price } 元</li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
    </div>
    <div class="recommend">
        <div class="capacity">
            <div class="capa_box_top">
                <div class="capa_box_top_al">明星单品</div>
                <div class="capa_box_top_ar">
                </div>
            </div>
            <div class="capa_box">
                <div class="capa_top">

                    <!-- 动态数据使用，仅供参考 -->
                    <c:forEach items="${MXDPCommodityList }" var="mxdp">
                        <div class="capa capa_shadow" style="margin-right: 10px;background-color: #fff">
                            <a href="IndexServlet?mark=showCommodityById&cid=${mxdp.cid}" target="_blank"><img width="234"  src="http://localhost:8080/${mxdp.pic}">

                            </a>
                            <div class="capa_a">
                                <ul>
                                    <li style="color: #333333"> ${mxdp.name } </li>
                                    <li style="color: #b0b0b0"> ${mxdp.description } </li>
                                    <li style="font-size: 14px;margin-top: 10px; color: #ff6700" >${mxdp.price } 元</li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>

                </div>


            </div>

        </div>
    </div>
    <div class="popular">
        <div class="popular_background">
            <div class="popular_box_top">
                <div class="popular_box_top_al">热门产品</div>

            </div>
            <div class="popu_box">


                <c:forEach items="${RMCommodityList }" var="rm" varStatus="i">

                    <c:if test="${i.count ==1 }">
                        <div class="popu popu_unleft popu_shadow" >
                            <a href="IndexServlet?mark=showCommodityById&cid=${rm.cid}" target="_blank"><img style="width: 296px" height="220px" src="http://localhost:8080/${rm.pic}"></a>
                            <div class="popu_bottom">
                                <p class="review">
                                        ${rm.full_description }
                                </p>
                                <p class="author"> 来自于 秘密 的评价 </p>
                                <div class="info">
                                    <h3 class="title">${rm.name }</h3>
                                    <span class="sep">|</span>
                                    <p class="price"><span>${rm.price }</span>元</p>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${i.count !=1 }">
                        <div class="popu popu_unleft popu_shadow" style="margin-left: 13px;">
                            <a href="" target="_blank"><img style="width: 296px" height="220px" src="http://localhost:8080/${rm.pic}"></a>
                            <div class="popu_bottom">
                                <p class="review">
                                        ${rm.full_description }
                                </p>
                                <p class="author"> 来自于 秘密 的评价 </p>
                                <div class="info">
                                    <h3 class="title">${rm.name }</h3>
                                    <span class="sep">|</span>
                                    <p class="price"><span>${rm.price }</span>元</p>
                                </div>
                            </div>
                        </div>
                    </c:if>

                </c:forEach>

            </div>
        </div>
    </div>

    <div class="video">
        <div class="popular_background">
            <div class="popular_box_top">
                <div class="popular_box_top_al">视频</div>

            </div>
            <div class="popu_box">
                <div class="vid popu_unleft popu_shadow">
                    <div class="video_top">
                        <a href=""><video class="this_vid" src="img/snowPerson.mp4" controls loop  poster="img/video_01.jpg"></video></a>
                    </div>
                    <div class="video_bottom">
                        <h3 class="vid_title"><a href="">小米8，一部与众不同的手机</a></h3>
                        <p class="vid_desc">透明探索版，将科技与美学完美结合</p>
                    </div>
                </div>
                <div class="vid  popu_shadow">
                    <div class="video_top">
                        <a href=""><video class="this_vid" src="img/snowPerson.mp4" controls loop  poster="img/video_02.jpg"></video></a>
                    </div>
                    <div class="video_bottom">
                        <h3 class="vid_title"><a href="">小米MIX 2S，一面科技 一面艺术</a></h3>
                        <p class="vid_desc">艺术品般陶瓷机身，惊艳、璀璨</p>
                    </div>
                </div>
                <div class="vid  popu_shadow">
                    <div class="video_top">
                        <a href=""><video class="this_vid" src="img/snowPerson.mp4" controls loop  poster="img/video_03.jpg"></video></a>
                    </div>
                    <div class="video_bottom">
                        <h3 class="vid_title"><a href="">天生丽质的小米6X</a></h3>
                        <p class="vid_desc">让你一见倾心</p>
                    </div>
                </div>
                <div class="vid  popu_shadow">
                    <div class="video_top">
                        <a href=""><video class="this_vid" src="img/snowPerson.mp4" controls loop  poster="img/video_01.jpg"></video></a>
                    </div>
                    <div class="video_bottom">
                        <h3 class="vid_title"><a href="">生活中无所不在的小爱同学</a></h3>
                        <p class="vid_desc">透明探索版，将科技与美学完美结合</p>
                    </div>
                </div>
            </div>
        </div>
    </div>--%>

    <div class="foot">
        <ul class="foot_ul">
            <li class="foot_li">预约维修服务</li>
            <li class="foot_li">7天无理由退货</li>
            <li class="foot_li">15天免费换货</li>
            <li class="foot_li">满15元包邮</li>
            <li class="foot_li foot_fot">520余家售后网点</li>
        </ul>
        <div class="foot_center">
            <div class="foot_cen_left">
                <dl class="foot_dl">
                    <dt class="foot_dt">帮助中心</dt>
                    <dd class="foot_dd"><a>账户管理</a></dd>
                    <dd class="foot_dd"><a>购物指南</a></dd>
                    <dd class="foot_dd"><a>订单操作</a></dd>
                </dl>
                <dl class="foot_dl">
                    <dt class="foot_dt">帮助中心</dt>
                    <dd class="foot_dd"><a>账户管理</a></dd>
                    <dd class="foot_dd"><a>购物指南</a></dd>
                    <dd class="foot_dd"><a>订单操作</a></dd>
                </dl>
                <dl class="foot_dl">
                    <dt class="foot_dt">帮助中心</dt>
                    <dd class="foot_dd"><a>账户管理</a></dd>
                    <dd class="foot_dd"><a>购物指南</a></dd>
                    <dd class="foot_dd"><a>订单操作</a></dd>
                </dl>
                <dl class="foot_dl">
                    <dt class="foot_dt">帮助中心</dt>
                    <dd class="foot_dd"><a>账户管理</a></dd>
                    <dd class="foot_dd"><a>购物指南</a></dd>
                    <dd class="foot_dd"><a>订单操作</a></dd>
                </dl>
                <dl class="foot_dl">
                    <dt class="foot_dt">帮助中心</dt>
                    <dd class="foot_dd"><a>账户管理</a></dd>
                    <dd class="foot_dd"><a>购物指南</a></dd>
                    <dd class="foot_dd"><a>订单操作</a></dd>
                </dl>
                <dl class="foot_dl">
                    <dt class="foot_dt">帮助中心</dt>
                    <dd class="foot_dd"><a>账户管理</a></dd>
                    <dd class="foot_dd"><a>购物指南</a></dd>
                    <dd class="foot_dd"><a>订单操作</a></dd>
                </dl>
            </div>
            <div class="foot_cen_right">
                <p class="foot-phone">400-100-5678</p>
                <p class="foot-right-center">周一至周日 8:00-18:00<br>（仅收市话费)</p>
                <a class="foot-right-bottmo" href="">联系客服</a>
            </div>
        </div>
    </div>
    <div class="fot_bot_max">
        <div class="fot_bot">
            <img src="img/logo.jpg" class="fot_bot_logo" >
            <div class="fot_bot_text">
                <p class="fot_bot_p">
                    <a class="fot_bot_a" href="">小米商城</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">MIUI</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">米家</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">米聊</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">多看</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">游戏</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">路由器</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">米粉卡</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">政企服务</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">小米天猫店</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">隐私政策</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">问题反馈</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">廉政举报</a>
                    <span class="fot_bot_span">|</span>
                    <a class="fot_bot_a" href="">Select Region</a>
                </p>
                <p class="fot_bot_p fot_bot_a1">
                    "©"
                    <a class="fot_bot_a1" href="">mi.con</a>
                    " 京ICP证110507号"
                    <a class="fot_bot_a1" href="">京ICP备10046444号</a>
                    <a class="fot_bot_a1" href="">京公网安备11010802020134号</a>
                    <a class="fot_bot_a1" href="">京网文[2017]1530-131号</a>
                    "<br>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试"



                </p>
            </div>
            <div class="fot_bot_right">
                <a href="" class="fot_bot_right_img"><img src="img/foot_01.png" alt=""></a>
                <a href="" class="fot_bot_right_img"><img src="img/foot_02.png" alt=""></a>
                <a href="" class="fot_bot_right_img"><img src="img/foot_03.png" alt=""></a>
                <a href="" class="fot_bot_right_img"><img src="img/foot_04.png" alt=""></a>
                <a href="" class="fot_bot_right_img"><img src="img/foot_05.png" alt=""></a>
            </div>

        </div>
        <img class="fot_bottom_img" src="img/foot_06.png">
    </div>

    <script>
        var abc = document.getElementsByClassName("script_capa_box_top_ar");
        console.log("abc:"+abc);
        console.log("abc[0]"+abc[0]);
        var box = document.getElementsByClassName("scrip_capa_box");
        console.log("box:"+box);
        console.log("box[0]:"+box[0]);
        for(var i = 0; i<abc.length;i++){
            abc[i].index=i;
            abc[i].onmouseover=function(){
                for(var j = 0 ;j<abc.length;j++){
                    box[j].className="capa_box scrip_capa_box";
                }
                box[this.index].className="capa_box scrip_capa_box scrip_capa_box_on"
                console.log("this.index:"+this.index);
            }
        }
        var n = 0;

        /*setInterval(function () {
            n++;
             if(n > $(".scroll ul li").length){
             n=0;
             }
            $(".scroll ul li").css("opacity","0").eq(n).css("opacity","1")
        },100)*/
        var t = setInterval(fun,1000);
        function  fun() {
            n++;
            if(n > $(".scroll>ul>li").length-1){
                n = 0;
            }
            $(".scroll>ul>li").css("opacity","0").eq(n).css("opacity","1")
            $(".scroll_dot span").eq(n).addClass("scroll_dot_span").siblings().removeClass("scroll_dot_span");
        }
        $(".scroll_arrows .left").click(function() {
            n -= 2;
            if(n <-1){
                n=4;
            }
            fun()

        } );
        $(".scroll_arrows .right").click(function() {
            fun()
        });
        $(".scroll_dot span").click(function () {
            console.log($(this).index());
            n=$(this).index()-1;
            $(this).siblings().removeClass("scroll_dot_span").end().addClass("scroll_dot_span");
            fun()
        }); $(".scroll").hover(function () {
                clearInterval(t);
            },
            function () {
                t = setInterval(fun,1000);
            });

    </script>
</body>
</html>