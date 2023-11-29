#include <bits/stdc++.h>
#define fox(i, n) for (int i = 0; i < (n); ++i)
#define rep(i, a, b) for (int i = (a); i <= (b); ++i)
#define pii pair<int, int>
#define tomax(a, b) ((a) = max((a), (b)))
#define tomin(a, b) ((a) = min((a), (b)))
#define F first
#define S second
#define EL "\n"
using namespace std;
typedef long long ll;

const int MN = 3e5;

vector<int> adj[MN + 1];
int dp[MN + 1];

void solve() {
    int n, m, k;
    cin >> n >> m;
    for (int i = 0, a, b; i < m; i ++) {
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    fill(dp, dp + n + 1, INT_MAX);
    cin >> k;
    queue<int> q;
    for (int i = 1, office; i <= k; i ++) {
        cin >> office;
        dp[office] = 0;
        q.push(office);
    }

    int ans = 0;
    while (!q.empty()) {
        int u = q.front(); q.pop();
        for (int v: adj[u]) {
            if (dp[u] + 1 < dp[v]) {
                dp[v] = dp[u] + 1;
                q.push(v);
                tomax(ans, dp[v]);
            }
        }
    }

    cout << ans << EL;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
