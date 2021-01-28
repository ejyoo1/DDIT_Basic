<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="java.util.Date"
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<h2>시각</h2>
<c:set var="date" value="<%=new Date() %>"></c:set>
<fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short"/>
<br>

<fmt:formatDate value="${date}" type="both" dateStyle="medium" timeStyle="medium"/><br>
<br>

<fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long"/>
<br>

<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full"/>
<br>
<h2>숫자 포맷</h2>
<fmt:formatNumber value="100000000" type="currency" currencySymbol="$"></fmt:formatNumber>
<br>
<fmt:formatNumber value="0.99" type="percent"></fmt:formatNumber>
<br>

<h2>국가별 포멧</h2>
<fmt:setLocale value="ko_kr"/>
<fmt:formatNumber value="100000000" type="currency"></fmt:formatNumber>
<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full"/>
<br>

<fmt:setLocale value="en_us"/>
<fmt:formatNumber value="100000000" type="currency"></fmt:formatNumber>
<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full"/>
<br>

<fmt:setLocale value="ja_jp"/>
<fmt:formatNumber value="100000000" type="currency"></fmt:formatNumber>
<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full"/>
<br>

<h2>세계별 시간대</h2>
<fmt:timeZone value="Aisa/Hong_kong">
	홍콩 : <fmt:formatDate value="${date}" type="both"/>
</fmt:timeZone>
</body>
</html>