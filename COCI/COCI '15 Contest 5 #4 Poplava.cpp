#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    ll n, x;
    cin >> n >> x;
    ll mx = n * (n + 1) / 2;
    mx -= n;
    mx -= n - 1;

    if (x > mx) { cout << -1 << '\n'; return; }
    
    ll val = mx, subtr = n - 2, cnt = 1;
    while (val - x >= subtr) {
        val -= subtr;
        subtr --;
        cnt ++;
    }

    rep(i, 1, cnt) cout << (n - i + 1) << ' ';

    if (!val) {
        rep(i, cnt + 1, n - 1) cout << i - cnt << ' ';
        cout << (n - cnt) << '\n';
    } else {
        int tmp = 1, diff = val - x;
        rep(i, cnt + 1, n - diff - 1) cout << tmp++ << ' ';
        cout << (n - cnt) << ' ';
        rep(i, n - diff + 1, n) cout << tmp++ << ' ';
        cout << '\n';
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
