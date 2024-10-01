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
	
	fetch(url)
	.then((response) => response.json())
	.then(data => {
		// 기존 목록 삭제
		let tbody = document.querySelector("#tbody");
		tbody.innerHTML='';
		// 새로운 목록 삽입
		data.list.forEach(function(item) {
			let allTr =
				`
				<tr data-no="${item.episode_id }" >
				    <th scope="row">${item.episode_num }</th>
				    <td>${item.title }</td>
				    <td>${item.user_id}</td>
				    <td>${item.created_date }</td>
				    <td>${item.counts }</td>
				</tr>
				`
			tbody.appendChild(allTr);
		})
	})//fetch 끝 
	

})	
	
	
	
	

