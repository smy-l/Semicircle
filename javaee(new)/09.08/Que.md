
有如下的servlet url的定义
```
<servlet-mapping>
    <servlet-name>servlet1</servlet-name>
    <url-pattern>/hello</url-pattern>
</servlet-mapping>

<servlet-mapping>
    <servlet-name>servlet2</servlet-name>
    <url-pattern>/bbs/admin/*</url-pattern>
</servlet-mapping>

<servlet-mapping>
    <servlet-name>servlet3</servlet-name>
    <url-pattern>/bbs/*</url-pattern>
</servlet-mapping>

<servlet-mapping>
    <servlet-name>servlet4</servlet-name>
    <url-pattern>*.jsp</url-pattern>
</servlet-mapping>

<servlet-mapping>
    <servlet-name>servlet5</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```
以下url匹配到的servlet分别是什么
| 路径                  | servlet |
| -------------------- | -------- |
| /hello               | servlet1 |
| /bbs/admin/login     | servlet2 |
| /bbs/admin/index.jsp | servlet2 |
| /bbs/display         | servlet3 |
| /bbs/index.jsp       | servlet3 |
| /bbs                 | servlet3 |
| /index.jsp           | servlet4 |
| /hello/index.jsp     | servlet4 |
| /hello/index.html    | servlet5 |
| /news                | servlet5 |