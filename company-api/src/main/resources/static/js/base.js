
var Company={
	id:0,
	name:"",
	domain:""
};
var Menu={
	init:function(){
		var lis = document.getElementById("navmenu").getElementsByTagName("LI");
		for (var i=0; i<lis.length; i++) {
			lis[i].onmouseover=function() {
				this.className+=" iehover";
			}
			lis[i].onmouseout=function() {
				this.className=this.className.replace(new RegExp(" iehover\\b"), "");
			}
		}
	}
};
var VIP={
	logoutVip:function(inp){
		var s = new Date().getSeconds();
		$.post("/sa/product/vip/exitVIPRoom.do",{companyID:Company.id,s:s},function(data){
			if(data==null||data==""){
				location.href="/vip/index.html";
			}else{
				alert(data);
			}
		});
	},
	loginVip:function(sub){
		var form=sub.form;
		var pass=form.vippwd.value;

		var s = new Date().getSeconds();

		$.post("/sa/product/vip/login.do",{password:pass,companyID:Company.id,s:s},function(data){
		if(data==null||data==""){
			location.href="/vip/vipwelcome.html";
		}else{
			alert(Lang.show(Lang.Incorrect_Password_Please_try_again));
		}
		});
	},

	loginVipToList:function(sub){
		var form=sub.form;
		var pass=form.vippwd.value;

		var s = new Date().getSeconds();

		$.post("/sa/product/vip/loginToList.do",{password:pass,companyID:Company.id,s:s},function(data){
		if(data==null||data==""){
			location.href="/vip/vipwelcome.html";
		}else if(data=="1"){
			alert(Lang.show(Lang.Incorrect_Password_Please_try_again));
		}else{
				location.href="/vip/productList_"+ data +"_1_index.html";
			}
		});
	},

	loadProduct:function(id,div){
	  	$("#"+div).load("/sa/product/vip/vipOneProductData.do",{id:id,companyID:Company.id},function(data){
			if(data==null||data==""){
			    location.href="/vip/index.html";
			}
		});
    },
	loadOtherProduct:function(id,div){
	  $("#"+div).load("/sa/product/vip/vipOtherProducts.do",{id:id});
    },
	loadProductList:function(id,div){
		var list=id.split(",");
		var groupID=list[0];
		var curPage=list[1];
		$("#"+div).load("/sa/product/vip/categoryProductList.do",{groupID:groupID,curPage:curPage,companyID:Company.id});
	},
	loadVipCategoryNav:function(id,div){
		var list=id.split(",");
		var groupID=list[0];
		$("#"+div).load("/sa/product/vip/loadVipCategoryH3.do",{groupID:groupID},function(data){
			if(data==null||data==""){

			    location.href="/vip/index.html";
			}
		});
	},
	loadVipCategoryLink:function(id,div){
		var list=id.split(",");
		var groupID=list[0];
		$("#"+div).load("/sa/product/vip/loadVipCategoryLink.do",{groupID:groupID,companyID:Company.id});
	},
	getChildrenGroup:function(id,div,div2){
	    document.getElementById(div2).style.display="none";
		var list=id.split(",");
		var groupID=list[0];
		$.post("/sa/product/vip/getChildrenGroup.do",{groupID:groupID,companyID:Company.id},function(data){
				if(data==null || data==""){

				}else{
				    document.getElementById(div2).style.display="block";
		            document.getElementById(div).innerHTML=data;
		        }
		});

	},
	vipCategoryLoad:function(div){
		var s = new Date().getTime();
		$.post("/sa/product/vip/category.do",{s:s},function(data){
			if(data==null||data==""){
				document.getElementById("vipProductCategory").style.display="block";
			    var s = new Date().getTime();
				$("#"+div).load("/sa/product/vip/openCategory.do",{s:s,companyID:Company.id});
			}else{
				document.getElementById("vipProductCategory").style.display="block";
				document.getElementById(div).innerHTML=data;
			}
		});
	},
	loadVipCategoryH3:function(){

		$.post("/sa/product/vip/inVIP.do",function(data){
		if(data==null||data==""){
			document.getElementById("vipForm").style.display="block";
			document.getElementById("vipProductCategory").style.display="block";

		}else{
		    location.href="/vip/vipwelcome.html";
		   }
		});
	},

	loadQuery:function(){

		$.post("/sa/queryFollow/queryInfo.do",{companyID:Company.id},function(data){
		if(data==null||data==""){
		document.getElementById("querySelect").innerHTML="<select id='queryMethodID' name='queryMethodID'><option  value='-1'>no data</option></select>";
		}else{
		document.getElementById("querySelect").innerHTML=data;
		}
		});

	},

	loginQueryLogin:function(sub){
	var form=sub.form;
	var cmethodId=form.configureMethodID.value;
	var queryno=form.queryNo.value;
	var pass=form.password.value;

	if(queryno==null||queryno==""){
			alert("num");
			return false;
		}
	if(document.getElementById("password").style.display==""){

		if(pass==null||pass==""){
				alert("pass");
				return false;
		}
	}
	$.post("/sa/queryFollow/queryLogin.do",{companyID:Company.id,configureMethodID:cmethodId,queryNo:queryno,password:pass},function(data){
		if(data==null||data==""){

		alert(Lang.show(Lang.Incorrect_Password_Please_try_again));
		}else{
		location.href="/profile/queryList.html";
		}

		});
	return true;

	},
	loadQueryList:function(sub){
	$.post("/sa/queryFollow/query.do",{companyID:Company.id},function(data){
		if(data==null||data==""){

		document.getElementById("queryList").innerHTML="No Information";
		}else{

		document.getElementById("queryList").innerHTML=data;
		}

		});
	}

};

var Basket={
	loadInquireProductList:function(div){
		$("#"+div).load("/sa/feedback/listBasket.do?"+new Date().getTime());
	},

	loadFeedbackProductList:function(div){
		var companyID=Company.id;
		//
        $.post("/sa/feedback/listfeedbackProduct.do",{companyID:companyID},function(data){
		    if(data!=''){
			$("#"+div).get(0).innerHTML=data;
			}
		});

	},
    //获取询盘的产品或者目录
	loadFeedbackProductsAndCatagory:function(div){
		var companyID=Company.id;
        //
		$.post("/sa/feedback/listFeedbackProductAndCatagory.do",{companyID:companyID},function(data){
		    if(data!=''){
			$("#"+div).get(0).innerHTML=data;
			$("#"+div+"Out").get(0).style.display="";
			}
		});
	},
  //显示产品
	showProducts:function(img){
		if(img.alt=='s1'){
			img.alt='s2';
			img.src='/css/images/menu_open.gif';
			document.getElementById('feedbackProduct').style.display='block';
		}else{
			img.alt='s1';
			img.src='/css/images/menu_close.gif';
			document.getElementById('feedbackProduct').style.display='none';
		}
	},
	checkFeedback:function(inp){
		var form=inp.form;
      	form.companyID.value=Company.id;


		var guestname=form.guestname.value;
		if(guestname==null||guestname==""){
			alert(Lang.show(Lang.please_specify_your_name));
			return false;
		}

		var guestemail=form.guestemail.value;
		if(guestemail==null||guestemail==""){
			alert(Lang.show(Lang.please_specify_your_email_address));
			return false;
		}

		var pattern=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	    flag=pattern.test(guestemail);
	    if (!flag){
		    alert(Lang.show(Lang.please_input_valid_email_address));
	        return false;
	    }

		var guestphone1=form.guestphone1.value;
		var guestphone2=form.guestphone2.value;
		var guestphone3=form.guestphone3.value;
		var guestfax1=form.guestfax1.value;
		var guestfax2=form.guestfax2.value;
		var guestfax3=form.guestfax3.value;
		var guestmessage=form.guestmessage.value;
		if(guestmessage==null||guestmessage==""){
			alert(Lang.show(Lang.please_specify_content));
			return false;
		}
		//php  begin
		var companyID=Company.id;
		var country=form.country.value;
		var productIDs=allCheckBox('pSelected');
		var guestphone=guestphone1+"-"+guestphone2+"-"+guestphone3;
        var guestfax=guestfax1+"-"+guestfax2+"-"+guestfax3;
		var guestcompany=form.guestcompany.value;
		//
       $.post("/js/feedback.php",{companyID:companyID,country:country,guestname:guestname,productIDs:productIDs,
	   guestphone:guestphone,guestfax:guestfax,guestcompany:guestcompany,guestemail:guestemail,guestmessage:guestmessage,serverMechine:58});
	   //php  end
		var str=Lang.please_waiting;

		$(form).before('<div id="show_pop_msg" class="pop_msg">'+str+'</div>');
		form.setAttribute("id","feedbackform");
		$(form).css("display","none");
	    return true;
	},
	hidePopMsg:function(p){
		if(p){
			switch(p){
				case 1: alert(Lang.show(Lang.Feedback_Error_1));break;
				case 2: alert(Lang.show(Lang.Feedback_Error_2));break;
				case 3: alert(Lang.show(Lang.Feedback_Error_3));break;
				case 4: alert(Lang.show(Lang.Feedback_Error_4));break;
				case 5: alert(Lang.show(Lang.Feedback_Error_5));break;
			}
		}
		$("#show_pop_msg").remove();
		$("#feedbackform").css("display","");
	},
	addBasket:function(){ 
	     var  id=allCheckBox("pSelected");
		  if(id==""){
		       alert(Lang.show(Lang.please_select_product_into_basket));
		   }else{
		      $.post("/sa/feedback/addfeedback.do",{str:id},function(){alert(Lang.show(Lang.add_successfully));});
			  }
	 },

	inquireNow:function(){ //add product and goto basket  到询盘basket页面

	       var  id=allCheckBox("pSelected");
		    if(id==""){
		       alert(Lang.show(Lang.please_select_product_into_basket));
		    }else{
		      $.post("/sa/feedback/addfeedback.do",{str:id},function(){
		      location.href="/profile/basketmanager.html";
		      });
			}
	  },

    addGoToBasket:function(){ //add product and goto basket  到询盘basket页面

	   var  id=allCheckBox("pSelected");
		 if(id==""){
		     alert(Lang.show(Lang.please_select_product_into_basket));
		  }else{
		      $.post("/sa/feedback/addfeedback.do",{str:id},function(){
		     location.href="/profile/feedback.html";
		      });
		}
	},

	delFeedbackProducts:function(){
	 var  id=allCheckBox("pSelected");
		if(id==""){
		       alert(Lang.show(Lang.please_select_product));
		  }else{
		      $.post("/sa/feedback/deleteBasket.do",{str:id},function(){
				location.href="/profile/basketmanager.html";
				 });
            }
	}
};


var Category={
	id:0,
	unique:"",
	show:function(t,num,id){
		var c=t.src;
		var cid=id.replace("cid","");
		num=num+1;
		if(num>3) return;
		if(c.indexOf("close")!=-1){
			t.src="/css/images/menu_open.gif";
			$("#uid"+cid).css("display","block");
		}else{

			t.src="/css/images/menu_close.gif";
			$("#uid"+cid).css("display","none");
		}
	},
	cateInit:function(){
		try{
			var c=$("#cid"+this.id);
			while(p!=null){
				p.style.display="block";
				if(p.tagName=="LI"){
					$("#"+p.id+"/img")[0].src="/css/images/menu_open.gif";
				}
				if(p.className=="category"){
					break;
				}
				p=p.parentNode;
			}
			/*
			p=c.parentNode;
			if(p.tagName=="LI"){
					$("#"+p.id+" .u2").css("display","block");
					if(p.className=="l2"){
						$("#"+p.id+" .u3").css("display","block");
					}
			}
			*/
		}catch(e){}
	}
};

var Base={
	inputClear:function(inp){
		inp.value="";
	},
	selectAll:function(inp){
	   var form=inp.form;
	   var arrObj=form.pSelected;
       if(arrObj!=null){
       if(inp.checked){
       	   arrObj.checked = true;
       }else{
       	   arrObj.checked = false;
       }

	  if(inp.checked){
       	for(var i=0;i<arrObj.length;i++){
       		arrObj[i].checked = true;
       	}
       }else{
       	for(var i=0;i<arrObj.length;i++){
       		arrObj[i].checked = false;
       	}
       }
       }
 	},
		searchSiteTo:function(sub){
		var search=encodeURIComponent(sub.form.value.value);
		location.href="/profile/searchSite.html?"+search;
	},

	searchSiteDO:function(){
		 var str = decodeURIComponent(location.search.substr(1));
	  // var value=document.getElementById("searchValue123456").value;
	   alert("1="+str);
	   //var search=encodeURIComponent(value);
	    //  alert("2="+search);
	   $.post("/sa/search.do",{str:str,companyID:Company.id},function(data){
														//	alert(data);
			    document.getElementById("searchContent").innerHTML=data;

	   });

	},

  //产品搜索
 	searchSubmit:function(sub){
		var search=sub.form.value.value;
		var productCatagoryID=$("#catagoryID").val();
		if(productCatagoryID==null){
		   productCatagoryID=-1;
		}
		var search=encodeURIComponent(search+"&&1&&"+productCatagoryID);
		location.href="/profile/search.html?"+search;
	},
 //加载搜索产品
	loadSearchProduct:function(){
       //
	   var productCatagoryID="";
	   var str=decodeURIComponent(location.search);
	   str=str.substring(1);
	   var params=str.split("&&");
       var flog=params.length;
	   //
	   var  searchStr="";
	   var  productCatagoryID="";
	   
	   if(flog==3){
         productCatagoryID=params[2];
		
	     }else{
	    productCatagoryID=$("#productCatagoryID").val();
		if(productCatagoryID==null){productCatagoryID==-1;}
	        }
       //
	    $("#searchContent").get(0).innerHTML="<div style='margin:20px;text-align:center; '>Loading...</div><div style='margin:20px;text-align:center;'><img src='/css/images/searchLoading.gif' border='0' ></div>";
       //	    	
	   $.post("/sa/product/search.do",{searchStr:params[0],curPage:params[1],companyID:Company.id,productCatagoryID:productCatagoryID},function(data){
		    $("#searchStr").attr("value",params[0]);
			$("#catagoryID").attr("value",productCatagoryID);//

		   if(data!=""){
			   $("#searchContent").get(0).innerHTML=data;
			  var searchFoundNum= $("#searchFoundNum").val();
			   if(searchFoundNum==0){
				$("#searchFoundTitle").get(0).innerHTML="ProductCatagory about "+params[0];
			    }else{
			    $("#searchFoundTitle").get(0).innerHTML="Found "+searchFoundNum+" products for "+params[0];
			   }
		    }
	   });
	},
	loadSearchProductCn:function(){
		    //
	   var productCatagoryID="";
	   var str=decodeURIComponent(location.search);
	   str=str.substring(1);
	  
	   var params=str.split("&&");
       var flog=params.length;
	   //
	   var  searchStr="";
	   var  productCatagoryID="";
	   
	   if(flog==3){
         productCatagoryID=params[2];
	     }else{
	    productCatagoryID=$("#productCatagoryID").val();
		if(productCatagoryID==null){productCatagoryID==-1;}
	        }
       //
      $.post("/sa/product/search.do",{searchStr:params[0],curPage:params[1],companyID:Company.id,productCatagoryID:productCatagoryID},function(data){
		    $("#searchStr").attr("value",params[0]);
			$("#catagoryID").attr("value",productCatagoryID);//

		   if(data!=""){
			   $("#searchContent").get(0).innerHTML=data;
			  var searchFoundNum= $("#searchFoundNum").val();
			   if(searchFoundNum==0){
				$("#searchFoundTitle").get(0).innerHTML="产品目录关于"+params[0];
			    }else{
			   
			    $("#searchFoundTitle").get(0).innerHTML="找到 "+$("#searchFoundNum").val()+" 个，关于 "+params[0];
			   }
		    }
	      });
	   },

	productPrevNext:function(id,f){
		$.post("/sa/product/productPrevNext.do",{id:id,f:f},function(data){
		   if(data==null || data==""){

		   }else{
			  location.href="/product/"+data+"/";
		   }
	   });
	}
};


var Subscriber={
   addSubscriber:function(sub){
       var form=sub.form;
	   var name=form.name.value;
	   var email=form.email.value;
	   var company=form.company.value;
	   var note="";
       if(form.note!=null){
	     note=form.note.value;
	   }
	   if(name==null || name=="" ){
	      alert(Lang.show(Lang.please_specify_your_subscr_name));
	      return false;
	   }
	   if(company==null || company=="" ){
	      alert(Lang.show(Lang.please_specify_your_company));
	      return false;
	   }
	   if(email==null || email=="" ){
	      alert(Lang.show(Lang.please_specify_your_email_address));
	      return false;
	   }
	  // var pattern=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	   var pattern=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	  flag=pattern.test(email);
	  if (!flag){
		  alert(Lang.show(Lang.please_input_valid_email_address));
	     return false;
	  }
	   if(name==null || name=="" || email==null || email==""||company==null || company==""){
	      alert(Lang.show(Lang.please_specify_content));
	      return false;
	   }else{
          var  website=getWebsite();
		$.post("http://seoms.veeao.com/pub/subscription!add.do",{contact:name,email:email,categoryID:1,website:website});
	    $.post("/sa/addSubscriber.do",{name:name,email:email,company:company,companyID:Company.id,note:note},function(){
				  alert(Lang.show(Lang.thanks_for_your_subscription));
			});

	   }
   },
     addSubscriber2:function(){
      
	   var name=$("#sub_name").val();
	   var email=$("#sub_email").val();
	   var company=$("#sub_company").val();
	   var phone=$("#sub_phone").val();
	   if(name==null || name=="" ){
	      alert(Lang.show(Lang.please_specify_your_subscr_name));
	      return false;
	   }
	   if(company==null || company=="" ){
	      alert(Lang.show(Lang.please_specify_your_company));
	      return false;
	   }
	   if(email==null || email=="" ){
	      alert(Lang.show(Lang.please_specify_your_email_address));
	      return false;
	   }
	    if(phone==null || phone=="" ){
	      alert(Lang.show(Lang.please_specify_your_email_phone));
	      return false;
	   }
	   var pattern=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	   flag=pattern.test(email);
	  if (!flag){
		  alert(Lang.show(Lang.please_input_valid_email_address));
	     return false;
	  }
     $.post("/sa/subscribe/subscriberAndShowResult.do",{name:name,email:email,company:company,companyID:Company.id,phone:phone},function(data){
	    document.getElementById("showVideo").innerHTML=data;;
	 });

   }

};

var Spry;
if (!Spry) Spry = {};
if (!Spry.Widget) Spry.Widget = {};

Spry.Widget.TabbedPanels = function(element, opts)
{
	this.element = this.getElement(element);
	this.defaultTab = 0; // Show the first panel by default.
	this.bindings = [];
	this.tabSelectedClass = "TabbedPanelsTabSelected";
	this.tabHoverClass = "TabbedPanelsTabHover";
	this.tabFocusedClass = "TabbedPanelsTabFocused";
	this.panelVisibleClass = "TabbedPanelsContentVisible";
	this.focusElement = null;
	this.hasFocus = false;
	this.currentTabIndex = 0;
	this.enableKeyboardNavigation = true;

	Spry.Widget.TabbedPanels.setOptions(this, opts);

	// If the defaultTab is expressed as a number/index, convert
	// it to an element.

	if (typeof (this.defaultTab) == "number")
	{
		if (this.defaultTab < 0)
			this.defaultTab = 0;
		else
		{
			var count = this.getTabbedPanelCount();
			if (this.defaultTab >= count)
				this.defaultTab = (count > 1) ? (count - 1) : 0;
		}

		this.defaultTab = this.getTabs()[this.defaultTab];
	}

	// The defaultTab property is supposed to be the tab element for the tab content
	// to show by default. The caller is allowed to pass in the element itself or the
	// element's id, so we need to convert the current value to an element if necessary.

	if (this.defaultTab)
		this.defaultTab = this.getElement(this.defaultTab);

	this.attachBehaviors();
};

Spry.Widget.TabbedPanels.prototype.getElement = function(ele)
{
	if (ele && typeof ele == "string")
		return document.getElementById(ele);
	return ele;
}

Spry.Widget.TabbedPanels.prototype.getElementChildren = function(element)
{
	var children = [];
	var child = element.firstChild;
	while (child)
	{
		if (child.nodeType == 1 /* Node.ELEMENT_NODE */)
			children.push(child);
		child = child.nextSibling;
	}
	return children;
};

Spry.Widget.TabbedPanels.prototype.addClassName = function(ele, className)
{
	if (!ele || !className || (ele.className && ele.className.search(new RegExp("\\b" + className + "\\b")) != -1))
		return;
	ele.className += (ele.className ? " " : "") + className;
};

Spry.Widget.TabbedPanels.prototype.removeClassName = function(ele, className)
{
	if (!ele || !className || (ele.className && ele.className.search(new RegExp("\\b" + className + "\\b")) == -1))
		return;
	ele.className = ele.className.replace(new RegExp("\\s*\\b" + className + "\\b", "g"), "");
};

Spry.Widget.TabbedPanels.setOptions = function(obj, optionsObj, ignoreUndefinedProps)
{
	if (!optionsObj)
		return;
	for (var optionName in optionsObj)
	{
		if (ignoreUndefinedProps && optionsObj[optionName] == undefined)
			continue;
		obj[optionName] = optionsObj[optionName];
	}
};

Spry.Widget.TabbedPanels.prototype.getTabGroup = function()
{
	if (this.element)
	{
		var children = this.getElementChildren(this.element);
		if (children.length)
			return children[0];
	}
	return null;
};

Spry.Widget.TabbedPanels.prototype.getTabs = function()
{
	var tabs = [];
	var tg = this.getTabGroup();
	if (tg)
		tabs = this.getElementChildren(tg);
	return tabs;
};

Spry.Widget.TabbedPanels.prototype.getContentPanelGroup = function()
{
	if (this.element)
	{
		var children = this.getElementChildren(this.element);
		if (children.length > 1)
			return children[1];
	}
	return null;
};

Spry.Widget.TabbedPanels.prototype.getContentPanels = function()
{
	var panels = [];
	var pg = this.getContentPanelGroup();
	if (pg)
		panels = this.getElementChildren(pg);
	return panels;
};

Spry.Widget.TabbedPanels.prototype.getIndex = function(ele, arr)
{
	ele = this.getElement(ele);
	if (ele && arr && arr.length)
	{
		for (var i = 0; i < arr.length; i++)
		{
			if (ele == arr[i])
				return i;
		}
	}
	return -1;
};

Spry.Widget.TabbedPanels.prototype.getTabIndex = function(ele)
{
	var i = this.getIndex(ele, this.getTabs());
	if (i < 0)
		i = this.getIndex(ele, this.getContentPanels());
	return i;
};

Spry.Widget.TabbedPanels.prototype.getCurrentTabIndex = function()
{
	return this.currentTabIndex;
};

Spry.Widget.TabbedPanels.prototype.getTabbedPanelCount = function(ele)
{
	return Math.min(this.getTabs().length, this.getContentPanels().length);
};

Spry.Widget.TabbedPanels.addEventListener = function(element, eventType, handler, capture)
{
	try
	{
		if (element.addEventListener)
			element.addEventListener(eventType, handler, capture);
		else if (element.attachEvent)
			element.attachEvent("on" + eventType, handler);
	}
	catch (e) {}
};

Spry.Widget.TabbedPanels.prototype.onTabClick = function(e, tab)
{
	this.showPanel(tab);
};

Spry.Widget.TabbedPanels.prototype.onTabMouseOver = function(e, tab)
{
	this.addClassName(tab, this.tabHoverClass);
};

Spry.Widget.TabbedPanels.prototype.onTabMouseOut = function(e, tab)
{
	this.removeClassName(tab, this.tabHoverClass);
};

Spry.Widget.TabbedPanels.prototype.onTabFocus = function(e, tab)
{
	this.hasFocus = true;
	this.addClassName(this.element, this.tabFocusedClass);
};

Spry.Widget.TabbedPanels.prototype.onTabBlur = function(e, tab)
{
	this.hasFocus = false;
	this.removeClassName(this.element, this.tabFocusedClass);
};

Spry.Widget.TabbedPanels.ENTER_KEY = 13;
Spry.Widget.TabbedPanels.SPACE_KEY = 32;

Spry.Widget.TabbedPanels.prototype.onTabKeyDown = function(e, tab)
{
	var key = e.keyCode;
	if (!this.hasFocus || (key != Spry.Widget.TabbedPanels.ENTER_KEY && key != Spry.Widget.TabbedPanels.SPACE_KEY))
		return true;

	this.showPanel(tab);

	if (e.stopPropagation)
		e.stopPropagation();
	if (e.preventDefault)
		e.preventDefault();

	return false;
};

Spry.Widget.TabbedPanels.prototype.preorderTraversal = function(root, func)
{
	var stopTraversal = false;
	if (root)
	{
		stopTraversal = func(root);
		if (root.hasChildNodes())
		{
			var child = root.firstChild;
			while (!stopTraversal && child)
			{
				stopTraversal = this.preorderTraversal(child, func);
				try { child = child.nextSibling; } catch (e) { child = null; }
			}
		}
	}
	return stopTraversal;
};

Spry.Widget.TabbedPanels.prototype.addPanelEventListeners = function(tab, panel)
{
	var self = this;
	Spry.Widget.TabbedPanels.addEventListener(tab, "click", function(e) { return self.onTabClick(e, tab); }, false);
	Spry.Widget.TabbedPanels.addEventListener(tab, "mouseover", function(e) { return self.onTabMouseOver(e, tab); }, false);
	Spry.Widget.TabbedPanels.addEventListener(tab, "mouseout", function(e) { return self.onTabMouseOut(e, tab); }, false);

	if (this.enableKeyboardNavigation)
	{
		// XXX: IE doesn't allow the setting of tabindex dynamically. This means we can't
		// rely on adding the tabindex attribute if it is missing to enable keyboard navigation
		// by default.

		// Find the first element within the tab container that has a tabindex or the first
		// anchor tag.

		var tabIndexEle = null;
		var tabAnchorEle = null;

		this.preorderTraversal(tab, function(node) {
			if (node.nodeType == 1 /* NODE.ELEMENT_NODE */)
			{
				var tabIndexAttr = tab.attributes.getNamedItem("tabindex");
				if (tabIndexAttr)
				{
					tabIndexEle = node;
					return true;
				}
				if (!tabAnchorEle && node.nodeName.toLowerCase() == "a")
					tabAnchorEle = node;
			}
			return false;
		});

		if (tabIndexEle)
			this.focusElement = tabIndexEle;
		else if (tabAnchorEle)
			this.focusElement = tabAnchorEle;

		if (this.focusElement)
		{
			Spry.Widget.TabbedPanels.addEventListener(this.focusElement, "focus", function(e) { return self.onTabFocus(e, tab); }, false);
			Spry.Widget.TabbedPanels.addEventListener(this.focusElement, "blur", function(e) { return self.onTabBlur(e, tab); }, false);
			Spry.Widget.TabbedPanels.addEventListener(this.focusElement, "keydown", function(e) { return self.onTabKeyDown(e, tab); }, false);
		}
	}
};

Spry.Widget.TabbedPanels.prototype.showPanel = function(elementOrIndex)
{
	var tpIndex = -1;

	if (typeof elementOrIndex == "number")
		tpIndex = elementOrIndex;
	else // Must be the element for the tab or content panel.
		tpIndex = this.getTabIndex(elementOrIndex);

	if (!tpIndex < 0 || tpIndex >= this.getTabbedPanelCount())
		return;

	var tabs = this.getTabs();
	var panels = this.getContentPanels();

	var numTabbedPanels = Math.max(tabs.length, panels.length);

	for (var i = 0; i < numTabbedPanels; i++)
	{
		if (i != tpIndex)
		{
			if (tabs[i])
				this.removeClassName(tabs[i], this.tabSelectedClass);
			if (panels[i])
			{
				this.removeClassName(panels[i], this.panelVisibleClass);
				panels[i].style.display = "none";
			}
		}
	}

	this.addClassName(tabs[tpIndex], this.tabSelectedClass);
	this.addClassName(panels[tpIndex], this.panelVisibleClass);
	try{panels[tpIndex].style.display = "block";}catch(e){}

	this.currentTabIndex = tpIndex;
};

Spry.Widget.TabbedPanels.prototype.attachBehaviors = function(element)
{
	var tabs = this.getTabs();
	var panels = this.getContentPanels();
	var panelCount = this.getTabbedPanelCount();

	for (var i = 0; i < panelCount; i++)
		this.addPanelEventListeners(tabs[i], panels[i]);

	this.showPanel(this.defaultTab);
};



function correctPNG()
{
for(var i=0; i<document.images.length; i++)
{
var img = document.images[i]
var imgName = img.src.toUpperCase()
if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
{
var imgID = (img.id) ? "id='" + img.id + "' " : ""
var imgClass = (img.className) ? "class='" + img.className + "' " : ""
var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
var imgStyle = "display:inline-block;" + img.style.cssText
if (img.align == "left") imgStyle = "float:left;" + imgStyle
if (img.align == "right") imgStyle = "float:right;" + imgStyle
if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle
var strNewHTML = "<span " + imgID + imgClass + imgTitle
+ " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
+ "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
+ "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>"
img.outerHTML = strNewHTML
i = i-1
}
}
}
if(window.attachEvent){window.attachEvent("onload", correctPNG);}

//针对商品目录描述进行询盘 sky
var CategoryDescFeedBack={
	feedbackByCategoryDesc:function(desc){
		//alert("***"+desc);
	  $.post("/sa/cateGoryDesc/addSession.do",{str:desc},function(data){
		location.href="/profile/feedback.html";
		    });
	}
	                     }
 //针对客户访问提醒显示
function changeVisitStatus(){

}
//
function  allCheckBox(name){
    var ids= document.getElementsByName(name);
	var idstr="";
    for(i=0;i<ids.length;i++){
        if(ids[i].checked){
          idstr+=ids[i].value+",";
                  }
                }
    return idstr;
}
//询盘其他产品
  function feedbackOtherProductsAndCatagory(){ // 直接跳到询盘页面

       var  groupID=$("#groupID").val();
	   var  productIDs=allCheckBox("pSelected");
	   if(groupID==null){groupID=-1;}
       if(productIDs==null){productIDs="";}
	 $.post("/sa/feedback/feedbackAddCatagoryAndProducts.do",{productIDs:productIDs,catagoryID:groupID},function(){
	     location.href="/profile/feedback.html";
	    });
	
	}
//询盘某个产品 
  function feedbackOneProductsAndCatagory(){ // 直接跳到询盘页面
	  var  productID=$("#productID").val();
	 $.post("/sa/feedback/feedbackAddCatagoryAndProducts.do",{productIDs:productID,catagoryID:-1},function(){
	     location.href="/profile/feedback.html";
	    });
	
	}
//询盘某个产品 
  function feedbackOneProduct(pid){ // 直接跳到询盘页面
     pid=pid+","
	 $.post("/sa/feedback/feedbackAddCatagoryAndProducts.do",{productIDs:pid,catagoryID:-1},function(){
	     location.href="/profile/feedback.html";
	    });
	
	}
//
function getWebsite(){
  var path=location.href;
  var  temss=path.substring(0,7);
  var  url="";
  if(temss="http://"){
      url=path.substring(7);
    }

  var ss=url.split("/");
  return ss[0];
}

