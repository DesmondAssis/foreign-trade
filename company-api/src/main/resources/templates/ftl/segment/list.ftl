<#if page?? && (page.list?size > 0) >
    <#list page.list as prod>
    <div class="bk_pro">
        <input name="pSelected" value="${prod.id}" type="checkbox">
        <div class="imageDiv">
            <a class="bg-pic" href="product_detail.html?id=${prod.id}&pcatId=${prod.categoryId}">
                <img src="${prod.url}" title=""
                     alt=""/>
            </a>
        </div>
        <div>
            <div class="standardProductName">Product Name:</div>
            <a href="product_detail.html?id=${prod.id}&pcatId=${prod.categoryId}" class="name">
                <strong>${prod.code}</strong>
            </a><br/>
            <div class="standardModel">Model:</div>
            <span class="standardModelContent">
                                                <a href="product_detail.html?id=${prod.id}&pcatId=${prod.categoryId}"
                                                   class="item">${prod.name}</a>
                                            </span>
            <br/>
            <div class="standardDescription">Description:</div>
            <span class="description">
                ${prod.desc}
            </span>
        </div>
    </div>
    </#list>
</#if>