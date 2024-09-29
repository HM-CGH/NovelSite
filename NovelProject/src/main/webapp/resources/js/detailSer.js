/**
 * 
 */
	
	
let amountSelect = document.querySelector("#amount");
let amountValue = amountSelect.value
let searchField = document.querySelector("#searchField");


if(searchField.value == null){
	searchField.value='';
}
let searchWord = document.querySelector("#searchWord");
console.log('searchWord : '+searchWord);

if(searchWord.value==null){
	searchWord.value='';
}
let pageNo = document.querySelector("#pageNo").value;
	pageNo=1;
let series_id =document.querySelector("#series_id");

amountSelect.addEventListener('change', function(){
	amountValue = document.querySelector("#amount").value;
	let url = '/resDetailSer?searchField='+encodeURIComponent(searchField.value)+'&searchWord='
			+encodeURIComponent(searchWord.value)+'&pageNo='+encodeURIComponent(pageNo)
			+'&amount='+encodeURIComponent(amountValue)+'&series_id='+encodeURIComponent(series_id.value);
	console.log('url : '+url)
	fetch(url, {
	    method: 'GET',
	    headers: {
	        'Content-Type': 'application/json', // GET 요청에서는 보통 필요하지 않음
	    }
	})
	.then((response) => response.json())
	.then(data => {
	
		let tbody = document.querySelector("#tbody");
		tbody.innerHTML='';
		
		
		data.list.forEach(function(item) {
			let tr = document.createElement("tr");
	        tr.dataset.no=item.episode_id;
	        tbody.appendChild(tr);
	        
	        let td_episode_num = document.createElement("td");
	        td_episode_num.innerHTML = item.episode_num;
	        tr.appendChild(td_episode_num);
	        
	        let td_title = document.createElement("td");
	        td_title.innerHTML = item.title;
	        tr.appendChild(td_title);
	        
	        let td_user_id = document.createElement("td");
	        td_user_id.innerHTML = item.user_id;
	        tr.appendChild(td_user_id);
	        
	        
	        let td_created_date = document.createElement("td");
	        td_created_date.innerHTML = item.created_date;
	        tr.appendChild(td_created_date);     
	        
	        
	        let td_counts = document.createElement("td");
	        td_counts.innerHTML = item.counts;
	        tr.appendChild(td_counts);    
		})
			
		
	})//fetch 끝 
	

})	
	
	
	
	

