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
	
	fetch(url)
	.then((response) => response.json())
	.then(data => {
	
		let tbody = document.querySelector('tbody');
		tbody.innerHTML='';
		
		data.list.forEach(function(item) {
			
			let allTr=
			`
			<tr data-no="${item.series_id }">
				<th scope="row">${item.rn }</th>
				<td>${item.category_name }</td>
				<td>${item.title }</td>
				<td>${item.description }</td>
				<td>${item["user_id"]}</td>
			</tr>
			`
			tbody.appendChild(allTr);
			
	})//fetch 끝 
	
})
	
	
	
})	
	

