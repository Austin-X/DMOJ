#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    int adj[n + 1][n + 1], dp[n + 1][n + 1];
    rep(i, 1, n) rep(j, 1, n) cin >> adj[i][j];

    dp[1][1] = 0;
    dp[2][1] = dp[2][2] = adj[1][2];
    rep(i, 3, n) {
        dp[i][i] = dp[i][i - 1] = INT_MAX;
        rep(j, 1, i - 2) {
            dp[i][j] = adj[i][i - 1] + dp[i - 1][j];
            dp[i][i - 1] = min(dp[i][i - 1], adj[i][j] + dp[i - 1][j]);
        }
    }

    int ans = INT_MAX;
    rep(i, 1, n - 1) ans = min(ans, dp[n][i]); 
    cout << ans << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
