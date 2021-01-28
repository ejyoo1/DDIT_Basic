<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 조건 -->
${param.num1}-${param.num2}=${param.num1>param.num2}
<c:if test="${param.num1 > param.num2}">
	${param.num1} 앞에 값이 크다 ${param.num2}
</c:if>
<c:if test="${param.num1<param.num2}">
	${param.num1} 앞에 값이 작다 ${param.num2}
</c:if>