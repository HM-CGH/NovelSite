/**
 * 
 */

 window.addEventListener('load', function(){

	let Btn = document.querySelector('#signupBtn');
	Btn.addEventListener('click', function(){
		location.href='/signup';	
	
	})
	
	
	
	
})


function findId(){
	
	loginForm.classList.add("none");
	findIdForm.classList.remove("none");
	findPwForm.classList.add("none");
	
};


function findPw(){
	
	loginForm.classList.add("none");
	findIdForm.classList.add("none");
	findPwForm.classList.remove("none");
	
	
};

function login(){
	
	loginForm.classList.remove("none");
	findIdForm.classList.add("none");
	findPwForm.classList.add("none");
	
};


function fn_findIdAction(){
	
	let data={
		user_name : setId_name.value
		, email : setId_email.value
		
	};
	fetch("/findId", {
		
		method : 'post'
		, headers: {
		      "Content-Type": "application/json",
		    }
		, body : JSON.stringify(data)    
	})
	.then(res=>res.json())
	.then(data=>{
		fn_findIdActionRes(data);
		
	})
	.catch(error=>{
		console.log('error', error)
	});
	
}

function fn_findPwAction(){
	
	let data={
		user_id : setPw_id.value
		, user_name : setPw_name
		, email : setPw_email
	};
	
	fetch('/findPw', {
		method : 'post'
		, headers : {
			 "Content-Type": "application/json",
		}
		, body : JSON.stringify(data)
		
	})
	.then(res=>res.json())
	.then(data=>{
		fn_findPwActionRes(data);
	})
	.catch(error=>{
		console.log('error', error);
	})
	
	
}

function fn_findIdActionRes(data){
	console.log('응답데이터', data);
	findIdMsgBox.innerHTML = data.msg;
}
function fn_findPwActionRes(data){
	console.log('응답데이터', data);
	findPwMsgBox.innerHTML = data.msg;
	findPwForm.classList.add("none");
	
} // 재설정페이지로 넘어갈 수 있는 url을 메세지에 넣어주고 그 메세지 내용을 url에 적용 
