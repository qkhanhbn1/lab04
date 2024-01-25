<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
*{
	margin:0;
	padding:0
}
nav{
	background-color:#3578E5;
}
nav ul{
	display:flex;
	justify-content:flex-start;
	align-items:center;
	list-style:none;
}
nav ul li a{
	color:#fff;
	display:block;
	padding:1rem;
	text-decoration :none;
}
nav ul li:first-child a{
	padding-left:0 !imortant;
}
nav ul li a:hover{
	color:yellow;
}

</style>
<nav>
	<ul class="container">
		<li>
			<a href="${pageContext.request.contextPath }/home">
			Home</a></li>
		<li>
			<a href="${pageContext.request.contextPath }/productlist">
			Product List</a></li>
			<li>
			<a href="${pageContext.request.contextPath }/userlist">
			User List</a></li>
	</ul>
</nav>
