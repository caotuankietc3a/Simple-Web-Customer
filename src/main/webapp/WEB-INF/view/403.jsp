<%@page contentType="text/html;charset=UTF-8" language="java" %>
	<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link
    href="https://fonts.googleapis.com/css?family=Varela+Round"
    rel="stylesheet"
  />
  <link
    href="https://fonts.googleapis.com/css?family=Poppins"
    rel="stylesheet"
  />
  <link
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/403.css"
  />
</head>
<body>
  <div class="message">You are not authorized.</div>
  <div class="message2">
    You tried to access a page you did not have prior authorization for.
  </div>
  <div class="container">
    <div class="neon">403</div>
    <div class="door-frame">
      <div class="door">
        <div class="rectangle"></div>
        <div class="handle"></div>
        <div class="window">
          <div class="eye"></div>
          <div class="eye eye2"></div>
          <div class="leaf"></div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
