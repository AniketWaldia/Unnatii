$(document).ready(function(){
	
	$('.productList li').on('mouseover',function(){
		
		$(this).find('.productListSub').show();
		$(this).append('<img src="'+PATH.rootPath+'/resources/images/arrow.png" style="margin: 15px 10px 0 0px;position:relative; float:right;"/>');
		
	});
	$('.productList li').on('mouseout',function(){
		
		$(this).find('.productListSub').hide();
		$(this).find('img').remove();
		
	});
	
	
});