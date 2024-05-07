import { goto } from '$app/navigation';
import type { paths } from '$lib/backend/apiV1/schema';
import createClient from 'openapi-fetch';

type Client = ReturnType<typeof createClient<paths>>;

const client: Client = createClient<paths>({
	baseUrl: import.meta.env.VITE_CORE_API_BASE_URL,
	credentials: 'include'
});

class Rq {
	// URL
	public goto(url: string) {
		goto(url);
	}

	public replace(url: string) {
		goto(url, { replaceState: true });
	}

	// API END POINTS
	public getApiEndPoints() {
		return client;
	}
}

const rq = new Rq();

export default rq;
