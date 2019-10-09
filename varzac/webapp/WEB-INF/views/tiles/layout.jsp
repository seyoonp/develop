<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="resource" />
</head>
<body>
	<div id="wrap">
        <!-- header -->
        <tiles:insertAttribute name="header" />
        <!--// header -->

        <div class="container">
            <!-- lnb -->
            <tiles:insertAttribute name="leftBanner" />
            <!--// lnb -->

            <!-- contents -->
            <section>
                <div class="contents">
					<tiles:insertAttribute name="content" />
                </div>
            </section>
            <!--// contents -->
        </div>

        <!-- footer -->
        <tiles:insertAttribute name="footer" />
        <!--// footer -->
    </div>
</body>
</html>