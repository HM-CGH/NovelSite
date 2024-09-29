let amountSelect = document.querySelector("#amountSelect");
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


amountSelect.addEventListener('change', function(){
	amountValue = document.querySelector("#amountSelect").value;
	let url = '/resEpiList?searchField='+encodeURIComponent(searchField.value)+'&searchWord='
			+encodeURIComponent(searchWord.value)+'&pageNo='+encodeURIComponent(pageNo)+'&amount='+encodeURIComponent(amountValue);
	console.log('url : '+url)
	fetch(url, {
	    method: 'GET',
	    headers: {
	        'Content-Type': 'application/json', // GET 요청에서는 보통 필요하지 않음
	    }
	})
	.then((response) => response.json())
	.then(data => {
	
		let tbody = document.querySelector('tbody');
		tbody.innerHTML='';
		
		if(data.list== null){
			let tr = document.createElement("tr");
			tbody.appendChild(tr);
			
			let td = document.createElement("td");
			td.colSpan = 7;
	        td.innerHTML = '조회된 게시물이 없습니다.';
	        tr.appendChild(td);
		}else{
			data.list.forEach(function(item) {
				let tr = document.createElement("tr");
		        tr.dataset.no=item.episode_id;
		        tbody.appendChild(tr);
		        
		        let th = document.createElement("th");
		        th.innerHTML = item.rn;
		        tr.appendChild(th);
		        
		        let td_series_id = document.createElement("td");
		        td_series_id.innerHTML = item.series_id;
		        tr.appendChild(td_series_id);
		        
		        let td_episode_num = document.createElement("td");
		        td_episode_num.innerHTML = item.episode_num;
		        tr.appendChild(td_episode_num);
		        
		        let td_title = document.createElement("td");
		        td_title.innerHTML = item.title;
		        tr.appendChild(td_title);
		        
		        let td_user_id = document.createElement("td");
		        td_user_id.innerHTML = item.user_id;
		        tr.appendChild(td_user_id);
		        
		        let td_counts = document.createElement("td");
		        td_counts.innerHTML = item.counts;
		        tr.appendChild(td_counts);
		        
		        let td_created_date = document.createElement("td");
		        td_created_date.innerHTML = item.created_date;
		        tr.appendChild(td_created_date);         
			})
		}
	})//fetch 끝 
	
	
	
})