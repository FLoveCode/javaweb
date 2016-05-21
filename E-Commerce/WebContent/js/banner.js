$(function(){
	var $oBannerContainer = $('.bannerContainer');  
	var $aItem = $oBannerContainer.find('.item');  
	var iItemLength = $aItem.length; 
	var $banner = $('#banner');
	var $oOlNav = $banner.find('ol');
	var $aNavLi = $oOlNav.find('li');

	$aItem.each(function(){
		$(this).css("zIndex",iItemLength - $aItem.index($(this)));
	});  //初始化z-index
	var i = 0;
	var jilu=0;
	var timer = setInterval(function(){
		i = slider(++i);
	},4000);
	$oBannerContainer.mouseover(function(){
		clearInterval(timer);
		jilu = i;
	}).mouseout(function(){
		timer = setInterval(function(){
			i = jilu = slider(++jilu);
		},4000);
	})
	$oOlNav.mouseover(function(){
		clearInterval(timer);
		jilu = i;
	}).mouseout(function(){
		timer = setInterval(function(){
			i = jilu = slider(++jilu);
		},4000);
	})
	$oOlNav.click(function(event){
		if(event.target != this){
			jilu = $aNavLi.index(event.target);
			slider(jilu);
			i = jilu;
		}
		
	})
	function slider(index){
		$aItem.stop(false,false).animate({"opacity":0},220);
		if(index >= 3){
			index = 0;
		}
		for(k=0;k<iItemLength;k++){
			if(k == index){
				$aItem.eq(index).stop(false,false).animate({"z-index":100},0);
			}
			else{
				$aItem.eq(k).animate({"z-index":10},0);
			}
		}
		$aItem.eq(index).stop(false,false).animate({"opacity":1},200,function(){
			$aNavLi.removeClass("active");
			$aNavLi.eq(index).addClass("active");
		});
		return index;
	}

})