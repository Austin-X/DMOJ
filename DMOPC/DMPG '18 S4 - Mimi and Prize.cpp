#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

const int MN = 2e5 + 5;

int a[MN];
bool vis[MN];
vector<int> adj[MN];

pii dfs(int u, bool odd) {
    vis[u] = true;

    int oddCnt = a[u] % 2 == 0 ? 0 : 1, tot = 1;
    for (int v: adj[u]) {
        if (!vis[v]) {
            if (odd && a[v] % 2 == 0) {
                pii p = dfs(v, false);
                oddCnt += p.first;
                tot += p.second;
            }
            else if (!odd && a[v] % 2 == 1) {
                pii p = dfs(v, true);
                oddCnt += p.first;
                tot += p.second;
            }
        }
    }
    return {oddCnt, tot};
}

void solve() {
    int n;
    cin >> n;
    rep(i, 1, n) cin >> a[i];
    for (int i = 0, a, b; i < n - 1; i ++) {
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    ll ans = 0;
    rep(i, 1, n) {
        if (!vis[i] && a[i] % 2 == 1) {
            pii p = dfs(i, true);
            ans += (ll)p.first * p.second;
        }
    }
    cout << ans << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
