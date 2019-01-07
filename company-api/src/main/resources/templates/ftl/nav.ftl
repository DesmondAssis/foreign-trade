<#if navs?? && (navs?size > 1) >
<ul class="nav">
    <#assign idx = 1>
    <#list navs as nav>
        <#if idx == 1>
            <li><a href="index.html"><span class="newshome">Home</span></a></li>
        <#else>
            <li><a href="${nav.link}">${nav.name}</a></li>
        </#if>

        <#if idx < navs?size>
            <li>&gt;</li>
        </#if>
        <#assign idx = idx + 1>
    </#list>
</ul>
</#if>