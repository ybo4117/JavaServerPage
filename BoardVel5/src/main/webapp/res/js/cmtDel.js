function delCmt(icmt, iboard) {	
	if (confirm('댓글을 삭제하시겠습니까?')) {
		//location.href = 'cmt?icmt=' + icmt + '&iboard=' + iboard;
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
		
	}
}
