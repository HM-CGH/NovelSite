/**
 * 
 */
window.addEventListener('load', function(){
	insertBtn.addEventListener('click', function(){
		location.href='/insertSer';
	})
	
	let trList = document.querySelectorAll('tr'); 
	trList.forEach(function(item){
	    item.addEventListener('click', function(){
            let num = item.dataset.no;
         
         	if('${param.pageNo}'== null){
         		location.href='/detailSer?series_id='+num+'&pageNo=1';
         	}else{
            	location.href='/detailSer?series_id='+num+'&pageNo=${map.pageDto.pageNo}';
         	}
	    })
	})
})
function go(pageNo){
	//document.location='/serList?pageNo='+pageNo;
	searchForm.pageNo.value = pageNo;
	searchForm.submit();
}