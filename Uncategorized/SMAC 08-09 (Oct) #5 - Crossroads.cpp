#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int w, h, b;
    cin >> w >> h >> b;
    int c[h + 1][w + 1], psa[h + 1][w + 1];
    fill(psa[0], psa[0] + (h + 1) * (w + 1), 0);
    rep(i, 1, h) rep(j, 1, w) { cin >> c[i][j]; psa[i][j] = psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + c[i][j]; }

    int l, r, ans = 0;
    for (int i = 1; i <= h; i ++) {
        for (int j = i; j <= h; j ++) {
            l = 1; r = 1;
            while (r <= w) {
                if (l > r) { r ++; continue; }
                int cost = (psa[j][w] - psa[i - 1][w]) + (psa[h][r] - psa[h][l - 1]) - (psa[j][r] - psa[i - 1][r] - psa[j][l - 1] + psa[i - 1][l - 1]);
                if (cost <= b) {
                    ans = max(ans, (j - i + 1) * w + (r - l + 1) * h - (j - i + 1) * (r - l + 1));
                    r ++;
                } else {
                    l ++;
                }
            }
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
