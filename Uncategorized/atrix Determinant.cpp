#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
const ll MOD = 1e9 + 7;

ll binexp(ll base, ll exp) {
    ll ans = 1;
    while (exp) {
        if (exp & 1) ans = ans * base % MOD;
        base = base * base % MOD;
        exp >>= 1;
    }
    return ans;
}

ll inv(ll num) {
    return binexp(num, MOD - 2);
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;

    ll a[n + 1][n + 1];
    ll det = 1;
    for (int i = 1; i <= n; i ++) {
        for (int j = 1; j <= n; j ++) {
            cin >> a[i][j];
            if (a[i][j] < 0) a[i][j] += MOD;
        }
    }

    for (int idx = 1; idx < n; idx ++) {
		int rowNum = 0;
		
		for (int i = idx; i <= n; i ++) {
			if (a[i][idx] != 0) { rowNum = i; break; }
		}
		
		if (!rowNum) {
			cout << 0 << '\n';
			return 0;
		}
		
		for (int i = idx; i <= n; i ++) swap(a[rowNum][i], a[idx][i]);
		if (idx != rowNum) det = MOD - det;
	
		ll div = inv(a[idx][idx]);
		det = det * a[idx][idx] % MOD;
		for (int i = idx; i <= n; i ++) a[idx][i] = a[idx][i] * div % MOD;

		for (int i = idx + 1; i <= n; i ++) {
			if (a[i][idx]) {
				div = -a[i][idx] + MOD;
				for (int j = idx; j <= n; j ++) a[i][j] = (a[i][j] + a[idx][j] * div) % MOD;
			}
		}
	}
	
    det = (det * a[n][n]) % MOD;
    cout << det << '\n';

    return 0;
}
