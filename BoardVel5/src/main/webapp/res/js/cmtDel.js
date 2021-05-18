var insFormElem = document.querySelector('#insForm');
var updFormElem = document.querySelector('#updForm');

// 댓글 삭제
function delCmt(icmt, iboard) {	
	if (confirm('댓글을 삭제하시겠습니까?')) {
		//location.href = 'cmt?icmt=' + icmt + '&iboard=' + iboard;
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;		
	}
}

// 댓글 수정
function updCmt(icmt, cmt){	
	console.log('icmt : %d', icmt);
	console.log('cmt : %s', cmt);
	
	updForm.icmt.value = icmt;
	updForm.cmt.value = cmt;
	
	insForm.className = 'hidden';
	updForm.className = '';
}

function showInsForm(){
	insForm.className = '';
	updForm.className = 'hidden';
}