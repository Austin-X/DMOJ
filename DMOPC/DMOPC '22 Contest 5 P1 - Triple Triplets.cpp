#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    ll n, mx = 0, twoCnt = 1;
    cin >> n;
    for (ll i = n - 2; i >= 2; i -= 2) {
        mx = max(mx, (i - 1) * i / 2 * twoCnt);
        twoCnt ++;
    }
    cout << mx << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
