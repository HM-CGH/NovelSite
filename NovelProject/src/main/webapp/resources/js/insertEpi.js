window.addEventListener('load', function(){
	
	insertNewSer.addEventListener('click', function(){
		location.href='/insertSer';
	});
	insertEpiBtn.addEventListener('click', function(e){
		e.preventDefault();
		if(checkForm()){
			let result = confirm('게시물을 등록하시겠습니까? ');
			
            if (result) {
            	insertEpiForm.submit();
            } else {
                alert("등록이 취소되었습니다.");
               	
            }
		};
	});
	
	series_id.addEventListener('change', function(){
		console.log('시리즈 바뀜 ')
		let data={
				series_id : series_id.value
		};
		
		fetch("/findEpiNum", {
			method:'post'
			, headers : {
			 "Content-Type": "application/json",
			}
			, body : JSON.stringify(data)
		})
		.then(res=>res.json())
		.then(data=>{
			fn_findEpiNum(data);
		})
		.catch(error=>{
			console.log('error', error)
		});
		
	})
	
});
	function fn_findEpiNum(data){
		console.log('응답데이터', data);
		
			episode_num.value=data.msg;
		
	}
	

	//무결성 검사
	function checkForm(){
	if(series_id.value =='' || series_id.value == null){
		
		alert('시리즈를 입력해주세요. ');
		return false;
	}
	if(episode_num == null){
		
		alert('회차를 입력해주세요. ');
		return false;
	}
	if(title == null || title ==''){
		
		alert('제목을 입력해주세요. ');
		return false;
	}if(content == null || content ==''){
		
		alert('내용을 입력해주세요. ');
		return false;
	}
	return true;
	}