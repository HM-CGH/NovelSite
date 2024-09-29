/**
 * 
 */
	
	
let amountSelect = document.querySelector("#amountSelect");
let amountValue = amountSelect.value
let searchField = document.querySelector("#inputGroupSelect04");

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
	let url = '/resSerList?searchField='+encodeURIComponent(searchField.value)+'&searchWord='
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
		
		data.list.forEach(function(item) {
			let tr = document.createElement("tr");
	        tr.dataset.no=item.series_id;
	        tbody.appendChild(tr);
	        
	        let th = document.createElement("th");
	        th.innerHTML = item.rn;
	        tr.appendChild(th);
	        
	        let td_category_id = document.createElement("td");
	        td_category_id.innerHTML = item.category_id;
	        tr.appendChild(td_category_id);
	        
	        
	        let td_title = document.createElement("td");
	        td_title.innerHTML = item.title;
	        tr.appendChild(td_title);
	        
	        
	        let td_description = document.createElement("td");
	        td_description.innerHTML = item.description;
	        tr.appendChild(td_description);
	        
	        let td_user_id = document.createElement("td");
	        td_user_id.innerHTML = item.user_id;
	        tr.appendChild(td_user_id);
	})//fetch 끝 
	
})
	
	
	
})	
	

