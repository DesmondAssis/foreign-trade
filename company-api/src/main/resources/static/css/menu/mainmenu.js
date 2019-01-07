$(document).ready(function(){
	var m_over_t_id=[];
	var m_out_t_id=[];
	$("#navmenu>li").each(function(index){
		$(this).hover(
			function(){
				var _self = this;
				m_over_t_id[index]=setTimeout(
					function(){$(_self).find('ul:eq(0)').fadeIn(400); $(_self).addClass('hover')},400
				);				
			},
			function(){
				var _self = this;
				clearTimeout(m_over_t_id[index]);
				m_out_t_id[index]=setTimeout(
					function(){$(_self).find('ul:eq(0)').fadeOut(200); $(_self).removeClass('hover')},200
					);
			})	
	})		
})
