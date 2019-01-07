<html>
<body>
Hi, Alina<br/>
<span>您有新的询盘提醒：</span>
<ul>
    <li>1. 名字：${name}</li>
    <li>2. 客人邮箱：${email}</li>
    <li>3. 客人留言：${message}</li>
    <li>4. 询问的产品：
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