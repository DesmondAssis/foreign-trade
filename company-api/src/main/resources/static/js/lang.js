var Lang={
please_select_product_into_basket:"please select product into basket",
successfully:"Successfully",
add_successfully:"add successfully",
please_select_product:"please select product",
delete_successfully:"delete successfully",
please_specify_your_name:"Please specify your subject!",
please_specify_your_subscr_name:"Please specify your name!",
please_specify_your_email_address:"Please specify your email address!",
please_specify_your_email_phone:"Please specify your phone!",
please_specify_your_company:"Please specify your company!",
please_specify_your_country:"Please specify your country!",
please_specify_content:"Please specify content!",
please_specify_password:"Please specify password!",
please_specify_num:"Please specify num!",
please_waiting:"Please waiting...",
thanks_for_your_subscription:"Thanks for your subscription!",
please_input_valid_email_address:"Please input a valid email address",
Incorrect_Password_Please_try_again:"Incorrect Password Please try again!",
Feedback_Error_1:"Please input a valid email address.",
Feedback_Error_2:"System Error.",
Feedback_Error_3:"The attachment is failed. But the inquire is sent successfully.",
Feedback_Error_4:"System Error! Feedback product error.",
Feedback_Error_5:"Send feedback mail error. But the inquire is sent successfully.",
blog_message_content:"Please input  message",
sys_validateCode:"Please input validateCode",
sys_validateCode_error:"validateCode error",
search_message_before:"search ",
search_message_end:"products£¬about",
feedback_validateCode:"please input the validateCode ",

	show:function(key,ary){
		var str=key;
		if(ary){
			for(var i=0;i<ary.length;i++){
				str=str.replaceAll('{'+(i+1)+'}',ary[i]);
			}
		}
		return str;
	}
};