#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

const int MN = 3e5 + 5, MOD = 1e9 + 7;
int n, m, k;
vector<pii> adj[MN];
bool vis[MN], neg[MN];
int mx[MN], cnst[MN];
int l, r;

void dfs(int u, int prev, int u_cnst) {
    vis[u] = true;

    for (pii v: adj[u]) {
        int dest = v.first, weight = v.second;
        if (!vis[dest]) {
            cnst[dest] = !neg[u] ? u_cnst - weight : u_cnst + weight;
            neg[dest] = !neg[u];

            if (neg[dest]) {
                l = max(l, cnst[dest] + 1);
                r = min(r, cnst[dest] + k);
            } else {
                l = max(l, cnst[dest] - k);
                r = min(r, cnst[dest] - 1);
            }
            dfs(dest, u, cnst[dest]);
        } else if (dest != prev) {
            int tmp_cnst = !neg[u] ? u_cnst - weight : u_cnst + weight, tmp_neg = !neg[u];
            if (neg[dest] == tmp_neg) {
                if (cnst[dest] - tmp_cnst != 0) l = k + 1;
            } else {
                if ((cnst[dest] + tmp_cnst) % 2 != 0) l = k + 1;
                else {
                    int x = (cnst[dest] + tmp_cnst) / 2;
                    l = max(l, x);
                    r = min(r, x);
                }
            }
        }
    }
}

void solve() {
    cin >> n >> m >> k;
    fill(mx, mx + n + 1, k);

    for (int i = 1, a, b, c; i <= m; i ++) {
        cin >> a >> b >> c;
        adj[a].push_back({b, c});
        adj[b].push_back({a, c});
        mx[a] = min(mx[a], c - 1);
        mx[b] = min(mx[b], c - 1);
    }

    ll ans = 0;
    for (int i = 1; i <= n; i ++) {
        if (!vis[i]) {
            l = 1; r = mx[i]; neg[i] = true;
            dfs(i, i, 0);

            if (l > r) {
                ans = 0;
                break;
            }

            ans = ans == 0 ? r - l + 1 : ans * (r - l + 1);
            ans %= MOD;
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
