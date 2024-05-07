<script lang="ts">
	import createClient from 'openapi-fetch';

	import type { paths } from '$lib/backend/apiV1/schema';

	type Client = ReturnType<typeof createClient<paths>>;

	const client: Client = createClient<paths>({
		baseUrl: import.meta.env.VITE_CORE_API_BASE_URL,
		credentials: 'include'
	});

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

		const { data, error } = await client.POST('/api/v1/members/login', {
			body: {
				username: form.username.value,
				password: form.password.value
			}
		});

		if (data) {
			data.msg && alert(data.msg);
			location.href = '/';
		} else if (error) {
			error.msg && alert(error.msg);
		}
	}
</script>

<form on:submit|preventDefault={submitLoginForm}>
	<div>
		<label>
			<span>아이디</span>
			<input type="text" name="username" placeholder="아이디" />
		</label>
	</div>
	<div>
		<label>
			<span>비밀번호</span>
			<input type="password" name="password" placeholder="비밀번호" />
		</label>
	</div>
	<div>
		<label>
			<span>로그인</span>
			<input type="submit" value="로그인" />
		</label>
	</div>
</form>
