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
            if (ans >= dis - k) d[i + 1] -= dis - k;
            else {
                d[i + 1] -= ans;
                double time = max(0.0, (d[i + 1] - d[i] - k) / 2);
                ans += time; d[i + 1] -= time;
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
