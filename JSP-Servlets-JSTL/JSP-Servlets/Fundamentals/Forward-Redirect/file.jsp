Two ways of forwarding:

<jsp:forward page="index.jsp" />

<%
request.getRequestDispatcher("index.jsp").forward(request, response);
%>


Redirect: 

<%
response.sendRedirect("index.jsp"); // Client Side redirect, enter a response where the redirect method is present
                                    // and will redirect to index.jsp
%>
