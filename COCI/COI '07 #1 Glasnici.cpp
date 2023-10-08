#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    double k;
    int n;
    cin >> k >> n;

    double d[n + 1];
    rep(i, 1, n) cin >> d[i];

    double ans = 0;
    for (int i = 1; i < n; i ++) {
        double dis = d[i + 1] - d[i];
        if (dis <= k) d[i + 1] += min(ans, (d[i] + k) - d[i + 1]);
        else {
            double diff = min(ans, dis - k);
            d[i + 1] -= diff;
            if (d[i + 1] - d[i] > k) {
                diff = (d[i + 1] - d[i] - k) / 2;
                ans += diff;
                d[i + 1] -= diff;
            }
        }
    }
    
    cout << fixed << setprecision(8) << ans << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
