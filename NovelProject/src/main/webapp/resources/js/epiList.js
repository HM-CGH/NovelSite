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
	
	fetch(url)
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
				
				let allTr=
				`
				<tr  data-no="${item.episode_id }">
					<th scope="row">${item.rn }</th>
					<td >${item.series_id }</td>
					<td >${item.episode_num }</td>
					<td >${item.title }</td>
					<td >${item.user_id}</td>
					<td >${item.counts}</td>
					<td >${item.created_date }</td>
				</tr>
				`
				tbody.appendChild(allTr);
			})
		}
	})//fetch 끝 
	
	
	
})