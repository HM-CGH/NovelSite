window.addEventListener('load', function(){
	
	
	
	let prevBtn = document.querySelector('#prevEpi');
	
	if(prevBtn != null){
		prevBtn.addEventListener('click', function(){
			let num = prevBtn.dataset.num
			let Eid = prevBtn.dataset.eid
			let pageNo = prevBtn.dataset.page
			location.href='/detailPrev?episode_num='+num+'&episode_id='+Eid+'&pageNo='+pageNo;
		})
	};
	
	
	let nextBtn = document.querySelector('#nextEpi');
	if(nextBtn != null){
		nextBtn.addEventListener('click', function(){
			let Nnum = nextBtn.dataset.num
			let Nid = nextBtn.dataset.eid
			let pageNo = nextBtn.dataset.page
			location.href='/detailNext?episode_num='+Nnum+'&episode_id='+Nid+'&pageNo='+pageNo;
	})
	}
	
	
	let delEpi = document.querySelector('#delEpi');
	delEpi.addEventListener('click', function(e){
		e.preventDefault();
		if(1==1){
			let result = confirm('정말 삭제하시겠습니까? ');
			
            if (result) {
            	let delform = document.querySelector('#delform');
            	delform.submit();
            } else {
                alert("취소되었습니다.");
               	
            }
		};
	});
	
});