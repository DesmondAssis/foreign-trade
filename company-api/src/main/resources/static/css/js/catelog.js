 


var menuids=["uid0"] 

function buildsubmenus(){
for (var i=0; i<menuids.length; i++){
  	var ultags=document.getElementById(menuids[i]).getElementsByTagName("ul")
    for (var t=0; t<ultags.length; t++){
		//if this is a first level submenu
 		//else if this is a sub level submenu (ul)
		  //position menu to the right of menu item that activated it
    	   ultags[t].parentNode.onmouseover=function(){
			   $(this).addClass("hover");
    			this.getElementsByTagName("ul")[0].style.display="block"
    		}
    		ultags[t].parentNode.onmouseout=function(){
				this.getElementsByTagName("ul")[0].style.display="none";
				$(this).removeClass("hover")
			}
    }
		for (var t=ultags.length-1; t>-1; t--){ //loop through all sub menus again, and use "display:none" to hide menus (to prevent possible page scrollbars
		ultags[t].style.visibility="visible"
		ultags[t].style.display="none"
		}
  }
}

if (window.addEventListener)
window.addEventListener("load", buildsubmenus, false)
else if (window.attachEvent)
window.attachEvent("onload", buildsubmenus)