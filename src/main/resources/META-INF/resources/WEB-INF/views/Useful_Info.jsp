<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Application Name: ${gav}</h3>
<p>${configProp.name}</p>
<p>${configProp.email[0]} <br> ${configProp.email[1]} </p>
<p>${configProp.company}</p>
<p>Java Experience - ${configProp.tech.javaExp}</p>
<p>iSeries Experience - ${configProp.tech.iSeriesExp}</p>
<p>Career Start date - ${configProp.tech.careerStartDate}</p>
<p>UUID - ${configProp.uuid}</p>
</body>
</html>