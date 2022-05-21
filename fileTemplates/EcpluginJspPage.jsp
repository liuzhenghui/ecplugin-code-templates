<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="org.apache.commons.logging.Log" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>

<%!
    Log log;
%>

<%
    response.setHeader("Access-Control-Allow-Origin", "*");
    log = LogFactory.getLog(page.getClass());

    try {

        out.print("完成");
    } catch (Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        log.error(sw.toString());
        out.print(e);
    }

%>