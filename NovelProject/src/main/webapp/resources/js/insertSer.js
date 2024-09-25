/**
 * 
 */
window.addEventListener('load', function(){
	insertSerBtn.addEventListener('click', function(e){
		e.preventDefault();
		if(checkForm()){
			let result = confirm('시리즈를 등록하시겠습니까? ');
			
			// 확인 클릭
            if (result) {
            	insertSerForm.submit();
            	alert("등록이 완료되었습니다. ");
            	location.href='/serList';
            // 취소클릭    
            } else {
                alert("등록이 취소되었습니다."); 	
            }
		};
	});
});

//무결성 검사
function checkForm(){
if(category_id.value =='' || category_id.value == null){
	alert('카테고리를 선택해주세요. ');
	return false;
}
if(title == null || title == ''){
	alert('제목을 입력해주세요. ');
	return false;
}
if(description == null || description ==''){
	alert('줄거리를 입력해주세요. ');
	return false;
}
return true;
}