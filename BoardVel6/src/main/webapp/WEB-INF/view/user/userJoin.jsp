<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>${errMsg}</div>
<div>
	<div>
		<a href="login"> Login으로 이동 </a>
	</div>
	<form id="frm">
		<div>
			<input type="text" name="uid" placeholder="id">
		</div>

		<div>
			<input type="password" name="upw" placeholder="password">
		</div>

		<div>
			<input type="text" name="unm" placeholder="name">
		</div>
		<div>
			성별 : <label>남성 <input type="radio" name="gender" value="1"
				checked></label> <label>여성 <input type="radio" name="gender"
				value="0"></label>
		</div>
	</form>

	<input type="button" value="회원가입" onclick="join();">


	<script>
		function join() {
			var frmElem = document.querySelector('#frm');
			var uid = frmElem.uid.value;
			var upw = frmElem.upw.value;
			var unm = frmElem.unm.value;
			var gender = frmElem.gender.value;			
			
			var param ={
					uid: uid,
					upw: upw,
					unm: unm,
					gender: gender				
			};
			
			var param2 = { uid, upw, unm, gender };
			// 변수명이랑 멤버필드랑 똑같으면 간략하게 적어도됨
			
			ajax(param);
		}
		
		function ajax(param) {
			const init={
					method : 'POST',
					// headers:{ 'Content-Type' : 'application/json'},
					// body: JSON.stringify(param)
					body : new URLSearchParams(param)
			}
			
			fetch('/user/join',init)
			.then(function(res){
				return res.json();
			})
			.then(function(myJson) {
				switch(myJson.result){
				case 0:
					alert('회원가입 실패');
					break;
				case 1:
					location.href = '/user/login';
					break;
				}
			});
		}
	
	</script>
</div>


