#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, k;
    cin >> n >> k;
    ll v[n];
    rep(i, 0, n - 1) cin >> v[i];
    sort(v, v + n);

    map<ll, ll> mn;
    for (int i = k; i < n - 1; i ++) mn[v[i + 1] - v[i]] ++;

    ll ans = LLONG_MAX;
    for (int i = k - 1; i >= -1; i --) {
        int diff = (k - 1) - i, endIdx = n - diff - 1;
        ans = min(ans, (v[n - diff - 1] - v[i + 1]) + mn.begin()->first);
        mn[v[endIdx] - v[endIdx - 1]] --;
        if (!mn[v[endIdx] - v[endIdx - 1]]) mn.erase(v[endIdx] - v[endIdx - 1]);
        mn[v[i + 1] - v[i]] ++;
    }
    cout << ans << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
