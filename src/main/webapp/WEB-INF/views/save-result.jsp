 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
 <head>
    <meta charset="UTF-8">
 </head>
 <body>
성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.userName}</li>
    <li>age=${member.age}</li>
 </ul>
 <a href="/index.html">메인</a>
 <br/>
 <a href="/front-controller/v5/v4/members">현재 목록 조회</a>
 <br/>
 <a href="/front-controller/v5/v4/members/new-form">추가등록</a>
 </body>
 </html>