<%@page import="com.user.dao.UserDao"%>  
<jsp:useBean id="u" class="com.user.bean.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=UserDao.update(u);  
response.sendRedirect("viewusers.jsp");  
%> 