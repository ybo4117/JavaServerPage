var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;

	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt: cmtVal
	};

	regAjax(param);
}

//서버에게 등록해줘~~~
function regAjax(param) {
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};

	fetch('cmtInsSel', init)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson);

			switch (myJson.result) {
				case 0:
					alert('등록 실패!');
					break;
				case 1:
					cmtFrmElem.cmt.value = '';
					getListAjax();
					alert('등록 성공!');
					break;
			}
		});
}

// 서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;

	fetch('cmtInsSel?iboard=' + iboard)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson);

			makeCmtElemList(myJson);
		});
}

function makeCmtElemList(data) {	

	cmtListElem.innerHTML = '';
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');

	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemBigo.innerText = '비고';

	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);

	tableElem.append(trElemTitle);
	cmtListElem.append(tableElem);

	var loginUserPk = cmtListElem.dataset.login_user_pk;

	data.forEach(function(item) {
		var trElemCtnt = document.createElement('tr');
		var tdElemCtnt = document.createElement('td');
		var tdElemWriter = document.createElement('td');
		var tdElemRegdate = document.createElement('td');
		var tdElemBigo = document.createElement('td');


		tdElemCtnt.append(item.cmt);
		tdElemWriter.append(item.writerNm);
		tdElemRegdate.append(item.regdate);
		//tdElemBigo.append(item.??);

		if (parseInt(loginUserPk) === item.iuser) {
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			
			// 삭제 버튼 클릭시 delAjax 호출
			delBtn.addEventListener('click',function(){
				
				delAjax(item.icmt);
			});
			
			
			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';

			tdElemBigo.append(delBtn);
			tdElemBigo.append(modBtn);
		}

		trElemCtnt.append(tdElemCtnt);
		trElemCtnt.append(tdElemWriter);
		trElemCtnt.append(tdElemRegdate);
		trElemCtnt.append(tdElemBigo);

		tableElem.append(trElemCtnt);
		//cmtListElem.append(tableElem);
	});

}

function delAjax(icmt){
	fetch('cmtDelUpd?icmt=' + icmt)
	.then(function(res){
		return res.json();
	})
	.then(function(data){
		console.log(data);
		
		switch(data.result){
			case 0:
				alert('댓글 삭제를 실패하였습니다.');
			break;
			case 1:
				alert('댓글 삭제 성공 !!');
				getListAjax();
			break;
		}
	});
	
}

getListAjax(); // 이 파일이 임포트되면 함수 1회 호출!!



