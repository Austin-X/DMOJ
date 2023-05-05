#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;
const int MN = 1001, MOD = 1e9 + 7;

int n, k;
string s;
ll dp[MN][MN][2];

void solve() {
    cin >> n >> k >> s;
    reverse(s.begin(), s.end());
    dp[0][0][0] = 1;

    for (int i = 1; i <= n; i ++) {
        dp[i][0][0] = dp[i - 1][0][0] == 1 && s[i - 1] == '0';
        for (int j = 1; j <= k; j ++) {
            if (s[i - 1] == '0') {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1] + dp[i - 1][j - 1][0]) % MOD;
                dp[i][j][1] = dp[i - 1][j][1];
            } else {
                dp[i][j][0] = dp[i - 1][j - 1][0];
                dp[i][j][1] = (dp[i - 1][j][1] + dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) % MOD;
            }
        }
    }
    cout << (dp[n][k][0] + dp[n][k][1]) % MOD << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
