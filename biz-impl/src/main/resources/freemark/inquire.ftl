<html>
<body>
Hi, Alina<br/>
<span>任务细节：</span>
<ul>
    <li>1. name：${name}</li>
    <li>2. email：${email}</li>
    <li>3. message：${message}</li>
    <li>4. 产品细节：
        <ul>
        <#list products as p>
            <li>
                id: ${p.id}<br>
                代码：${p.code}<br>
                名称: ${p.name}
            </li>
        </#list>
        </ul>
    </li>
</ul>
</body>
</html>