
window.addEventListener('load', function(){
		
	
		inputIdBtn.addEventListener('click', checkId);
		inputId.addEventListener('change', function(){
			
			checkIdTxt.value=0;
			
			
		})
		signupBtn.addEventListener('click', function(e){
		
			e.preventDefault();
			if(checkForm()){
				checksignForm.submit();
			}
			
		});
		
	
		
		
	});
	
	
	function checkId(){
	let user_id = document.querySelector('#inputId').value;
	let msg = document.querySelector('#msg');
		
		if(user_id != null && user_id !=''){
				fetch("/checkId?user_id="+user_id) 
				.then((response) => response.json()) 
				.then((res) => { 
					console.log(res);
					
					if(res.msg == ''){
						checkIdTxt.value=1;
						msg.innerHTML="사용가능한 아이디입니다. ";
					}else{
						checkIdTxt.value=0;
						msg.innerHTML=res.msg;
					};
					
				}).catch(err=>{
		      console.log(err);
		    });	
	
		}else{
			
			alert('아이디를 입력해주세요. ');
		};
	};
	function checkForm(){
		
		if(checkIdTxt.value != 1){
			alert('아이디 중복검사를 진행해주세요.');
			return false;
		}
		if(inputPassword.value != inputPasswordCheck.value || inputPassword == null || inputPassword ==''){
			alert('비밀번호가 일치하지 않습니다. ');
			return false;
		}
		if(inputEmail == null || inputEmail ==''){
			alert('이메일이 비어있습니다. ');
			return false;
		}
		if(inputName == null || inputName ==''){
			alert('이름이 비어있습니다. ');
			return false;
		}
		
			return true;
	}