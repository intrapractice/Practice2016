<%@tag description="Main Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:master>
    <jsp:attribute name="header">
      <!-- TODO: Put here HTML navigation -->
    </jsp:attribute>
    <jsp:attribute name="footer">
      <!-- TODO: Put here HTML footer -->
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</template:master>