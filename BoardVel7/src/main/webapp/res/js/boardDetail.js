var cmtFrmElem = document.querySelector('#cmtFrm');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;

	var param = {
		iboard: cmtFrmElem.dataset.iboard,
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
					alert('등록 성공!');
					break;
			}
		});
}

// 서버에게 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtFrmElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard=' + iboard)
	.then(function(res){
		return res.json();		
	})
	.then(function(myJson){
		console.log(myJson);
	});
}

getListAjax(); // 이 파일이 임포트되면 함수 1회 호출!!



