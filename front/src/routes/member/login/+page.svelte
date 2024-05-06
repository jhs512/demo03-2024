<script lang="ts">
	async function submitLoginForm(this: HTMLFormElement) {
		const form: HTMLFormElement = this;

		form.username.value = form.username.value.trim();

		if (form.username.value.length === 0) {
			alert('아이디를 입력해주세요.');
			form.username.focus();

			return;
		}

		form.password.value = form.password.value.trim();

		if (form.password.value.length === 0) {
			alert('비밀번호를 입력해주세요.');
			form.password.focus();

			return;
		}

		const rs = await fetch('http://localhost:8070/api/v1/members/login', {
			method: 'POST',
			credentials: 'include',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				username: form.username.value,
				password: form.password.value
			})
		}).then((res) => res.json());

		console.log(rs);
	}
</script>

<form on:submit|preventDefault={submitLoginForm}>
	<div>
		<input type="text" name="username" placeholder="아이디" />
	</div>
	<div>
		<input type="password" name="password" placeholder="비밀번호" />
	</div>
	<div>
		<button type="submit">로그인</button>
	</div>
</form>
