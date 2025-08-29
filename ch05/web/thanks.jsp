<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Survey Result - Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" />
  </head>
  <body>
    <div class="container">
      <header>
        <img src="images/murachlogo.jpg" alt="Murach Logo" class="logo" />
        <h1>Thank you for completing the survey!</h1>
      </header>

      <p class="intro">Here is the information you entered:</p>

      <div class="result-box">
        <p><strong>First Name:</strong> ${user.firstName}</p>
        <p><strong>Last Name:</strong> ${user.lastName}</p>
        <p><strong>Email:</strong> ${user.email}</p>
        <p><strong>Gender:</strong> ${user.gender}</p>
        <p><strong>Date of Birth:</strong> ${user.dateOfBirth}</p>
        <p><strong>Heard from:</strong> ${user.heardFrom}</p>
        <p><strong>Wants Updates:</strong> ${user.wantsUpdates}</p>
      </div>

      <p class="note">
        To enter another response, click the Back button in your browser 
        or use the Return button below.
      </p>

<form action="${pageContext.request.contextPath}/index.html" method="get" class="form-actions">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return" />
</form>
      </form>
    </div>
  </body>
</html>
