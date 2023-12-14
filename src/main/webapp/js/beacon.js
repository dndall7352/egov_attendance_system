/**
 * 
 */

$(function() {
	
	$.ajax({
		url:"/systemAdmin/getHeader.do",
		type: 'get',
		data:{pageName:"beacon"},
		success:function(response){
			$('#header').html(response);
		}
	});
	
	const form = $('form[name="searchPage"]');

	$('#button-addon2').on('click', function(){ // 검색 기능
		let searchType = $('#searchType').val();
		let searchName = $('#searchName').val();
		if(searchName == null || searchName == ''){
			$('#searchName').addClass('null-check');
			setTimeout(function(){
				$('#searchName').removeClass('null-check');
			}, 2000);
		}else{
    		form.find('input[name="searchType"]').val(searchType);
    		form.find('input[name="searchName"]').val(searchName);
    		form.submit();
		}
	});
	
	
	$('#beaconPage .page-item').on('click', function(){ // 페이지 기능
		let pageNum = $(this).find('.page-link').data('pagenum');
		if(pageNum != pageVO_pageNum){
    		form.find('input[name="pageNum"]').val(pageNum);
    		form.submit();
		}else{
			return;
		}
	});
	
	$('#add-beacon-btn').on('click', function(){ // 신규 비콘 추가
		
	if($(this).hasClass('onClicked')){
		$('#detail-field').empty();
		$(this).text('+ 신규비콘');
	}else{
		$(this).text('- 신규비콘');
		$.ajax({
			type:'get',
			url:'/beacon/insertJspPage.do',
			success:function(response){
				$('#detail-field').html(response);
			}
		});
	}
	$(this).toggleClass('onClicked');
	});
	
    $('table').on('click', '.beacon-item', function() { // 해당 비콘 상세 정보
    	$('#add-beacon-btn').removeClass('onClicked');
    	$('#add-beacon-btn').text('+ 신규비콘');
        let beaconNumber = $(this).children('.beacon-number').text();
        if(!$('#detail-field').is(':empty') && $('.table.select-beacon-table #detail-number').text() == beaconNumber){
        	$('#detail-field').empty();
        }else{
            $.ajax({
                type: 'GET',
                url: '/beacon/selectBeacon.do',
                data: { beaconNumber: beaconNumber },
                success: function(response) {
                    $('#detail-field').html(response);
                    
                },
            });
        }
    });
     $('#detail-field').on('click','#update-beacon-btn', function(){ // 상세 비콘 수정
    	 let com_number = $('input[name="com_number"]').val();
		let emplacement = $('input[name="emplacement"]').val();
		let uuid = $('input[name="uuid"]').val();
		let major = $('input[name="major"]').val();
		let minor = $('input[name="minor"]').val();
		let com_name = $('#cpn-com-name').text();
		if(com_number != ""){
     		findComName(com_number);
     		com_name = $('#cpn-com-name').text();
		}else{
			$('#cpn-com-name').text('');
			$('#beaconModal').find('.modal-body p').text('일치하는 회사가 없습니다.');
			$('#beaconModal').modal('show');
			return;
		}
    	if($('#cpn-com-name').text() != "" && emplacement != "" && uuid != "" && major != "" && minor != "" && com_number != ""){
    		var addData = {
    				beacon_number : $('#detail-number').text(),
    				com_name : $('#cpn-com-name').text(),
    				use : $('#beacon-state').find('.selected').data('state'),
    				pageNum : pageVO_pageNum,
    				amount : pageVO_amount,
    				searchType : pageVO_searchType,
    				searchName : pageVO_searchName
    		}
    		$.each(addData, function(key, value){
    			var appendInput = $("<input>").attr({
        			type:"hidden",
        			name:key,
        			value: value
        		});
    			$('#update-beacon-form').append(appendInput);
    		});
    		
    		$('#update-beacon-form').submit();
    	}else{
    		$('#beaconModal').find('.modal-body p').text('내용을 입력하세요');
			$('#beaconModal').modal('show');
    	}
		
    });
   
    $('#detail-field').on('click', '#insert-beacon-btn', function(){ // 비콘 추가
    	let com_number = $('input[name="com_number"]').val();
		let emplacement = $('input[name="emplacement"]').val();
		let uuid = $('input[name="uuid"]').val();
		let major = $('input[name="major"]').val();
		let minor = $('input[name="minor"]').val();
		let com_name = $('#cpn-com-name').text();
		if(com_number != ""){
    		findComName(com_number);
    		com_name = $('#cpn-com-name').text();
		}else{
			$('#cpn-com-name').text('');
			$('#beaconModal').find('.modal-body p').text('일치하는 회사가 없습니다.');
			$('#beaconModal').modal('show');
			return;
		}
		if(com_name != "" && emplacement != "" && uuid != "" && major != "" && minor != "" && com_number != ""){
    		var addData = {
    				com_name : $('#cpn-com-name').text(),
    				use : $('#beacon-state').find('.selected').data('state'),
     		//		pageNum : ${pageVO.cri.pageNum},
    		//		amount : ${pageVO.cri.amount},
    		//		searchType : '${pageVO.cri.searchType}',
    		//		searchName : '${pageVO.cri.searchName}' 
    		}
    		$.each(addData, function(key, value){
    			var appendInput = $("<input>").attr({
        			type:"hidden",
        			name:key,
        			value: value
        		});
    			$('#insert-beacon-form').append(appendInput);
    		});
    		
    		$('#update-beacon-form').submit();
    	}else{
    		$('#beaconModal').find('.modal-body p').text('내용을 입력하세요');
			$('#beaconModal').modal('show');
    	}
	
	});
});
