<div class="leftbar clear">
    <div class="category clear" id="left_bar_category">
        <!-- 标题 -->
        <div class="category_title">
            <h2>Product Catalog</h2>
        </div>

        <!-- 列表 -->
        <ul id='uid0' class='u1'>
        <#list cats as l1>
            <li id='cat${l1.id}' class='l1'><img src='css/images/menu_close.gif' onClick='Category.show(this,1,"cid12399");' alt='' >
                <a class='' href='product.html?catId=${l1.id}'>${l1.name}</a>

                <#if l1.subList?? && (l1.subList?size > 0) >
                    <ul id='scat${l1.id}' class='u2'>
                        <#list l1.subList as l>
                            <li id='cat${l.id}' class='l2'><img src='css/images/menu_open.gif' alt='' />
                                <a class='' href='product.html?pcatId=${l1.id}&catId=${l.id}'>${l.name}</a>
                            </li>
                        </#list>
                    </ul>
                </#if>
            </li>
        </#list>
        </ul>
    </div>

    <div class="subs">

        <div class="subs_title"><h2>Subscriptions</h2></div>
        <div class="intro">Get E-mail on new products</div>

        <form id="subscribe_form" action="subscribe.html" method="post">
            <div><label>Name:</label><input type="text" name="name" value="" onClick="Base.inputClear(this);"/></div><br/>
            <div><label>Company:</label><input type="text" name="company" value="" onClick="Base.inputClear(this);"/></div><br/>
            <div><label>Email:</label><input type="text" name="email" value="" onClick="Base.inputClear(this);"/></div><br/>
            <input name="sdf" id="btn_subscribe" type="button" class="button"  value=" "/>
        </form>
    </div>

    <script>
        $('#btn_subscribe').click(function () {
            $('#subscribe_form').submit();

            alert("Thanks for your subscription.");
        });
    </script>

</div>