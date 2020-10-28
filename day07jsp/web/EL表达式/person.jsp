<%@ page import="pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: Au revoir
  Date: 2020/10/26
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>person</title>
</head>
<body>

<%
    Person person = new Person();
    person.setName("李冥迷");
    person.setPhones(new String[]{"111111","122222","1333333"});

    List<String> cities = new ArrayList<>();
    cities.add("北京");
    cities.add("上海");
    cities.add("广州");
    cities.add("深圳");
    person.setCities(cities);

    Map<String,Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);
    pageContext.setAttribute("p",person);
%>

输出：
    person对象：${p}  <br>
    name:       ${p.name}    <br>
    phones:     ${p.phones[2]} <br>
    cities:     ${p.cities}     <br>
    city:       ${p.cities[1]}  <br>
    Map:        ${p.map}    <br>
    key:        ${p.map.key3}   <br>
    age:        ${p.age}    <br>

</body>
</html>
