<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.Member" %>
<%@ page import="hello.servlet.domain.MemberRepository" %>

<%

    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String userName = request.getParameter("userName");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(userName, age);
    System.out.println("member = " + member);
    memberRepository.save(member);

%>

<html>
<head>
<meta charset="UTF-8">
</head>
<body>
성공
    <ul>
        <li>id=<%=member.getId()%></li>
        <li>userName=<%=member.getUserName()%></li>
        <li>age=<%=member.getAge()%></li>
    </ul>
<a href="/index.html">메인</a>
</body>
</html>