<%@page import="java.util.Map"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="pack.order.CartMgr"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session" />
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr" />
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />

<%
//Hashtable hCart = cartMgr.getCartList();
//Enumeration enu = hCart.keys();
//위의 2줄은 아래 주석처리된 enumeration 쓸 때 필요한 구문

Hashtable<String, OrderBean> hCart = (Hashtable<String, OrderBean>)cartMgr.getCartList();

if(hCart.isEmpty()){
%>

	<script>
	alert("주문 내역이 없습니다");
	location.href="orderlist.jsp";
	</script>
	
<%	
}else{
/*
	while(enu.hasMoreElements()){
		OrderBean orderBean = (OrderBean)hCart.get(enu.nextElement());
		orderMgr.insertOrder(orderBean); // 주문정보 DB에 저장
		productMgr.reduceProduct(orderBean); // 주문 수량만큼 재고량 빼기
		cartMgr.deleteCart(orderBean);
	}
*/	//위에 enumeration 대신 map.entry를 써서 표현 가능
	for(Map.Entry<String, OrderBean> entry:hCart.entrySet()){
		OrderBean orderBean = entry.getValue();
		orderMgr.insertOrder(orderBean); // 주문정보 DB에 저장
		productMgr.reduceProduct(orderBean); // 주문 수량만큼 재고량 빼기
		cartMgr.deleteCart(orderBean);
	}

%>

<script>
	alert("주문 처리가 잘 되었습니다. \n고객님 감사합니다");
	location.href="orderlist.jsp";
	</script>
<%
}
%>