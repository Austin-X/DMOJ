#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

const int M = 405;
bool good[M][M];
int maxUp[M][M];

void solve() {
    int r, c;
    cin >> r >> c;

    rep(i, 1, r) rep(j, 1, c) { char c; cin >> c; good[i][j] = c == '.'; }
    rep(j, 1, c) for (int i = r; i >= 1; i --) maxUp[i][j] = !good[i][j] ? 0 : maxUp[i + 1][j] + 1;
    
    int ans = 0;
    for (int i = 1; i <= r; i ++) {
        for (int j = 1; j <= c;) {
            int start = j;
            stack<pii> s;

            while (j <= c) {
                if (!good[i][j]) break;
                int val = maxUp[i][j];
                while (!s.empty() && s.top().first >= val) {
                    pii p = s.top(); s.pop();
                    ans = s.empty() ? max(ans, p.first * 2 + (j - start) * 2 - 1) : max(ans, p.first * 2 + (j - s.top().second - 1) * 2 - 1);
                }
                s.push({val, j});
                j ++;
            }
            while (!s.empty()) {
                pii p = s.top(); s.pop();
                ans = s.empty() ? max(ans, p.first * 2 + (j - start) * 2 - 1) : max(ans, p.first * 2 + (j - s.top().second - 1) * 2 - 1);
            }
            j ++;
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
