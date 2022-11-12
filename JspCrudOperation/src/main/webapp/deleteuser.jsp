<%@page import="com.user.dao.UserDao"%>  
<jsp:useBean id="u" class="com.user.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
UserDao.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  