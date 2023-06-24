#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    
    if (n % 4 == 0) {
        rep(i, 1, n / 4) cout << (n / 2) << ' ';
        rep(i, 1, n / 4) cout << "0 ";
        rep(i, 1, n / 2) cout << "-1 ";
    } else if (n % 4 == 1) {
        rep(i, 1, n / 2 / 2) cout << (n / 2) << ' ';
        rep(i, 1, n / 2 / 2 + 1) cout << "0 ";
        rep(i, 1, n / 2) cout << "-1 ";
    } else if (n % 4 == 2) {
        rep(i, 1, n / 4) cout << (n / 2) << ' ';
        cout << (n / 4) << ' ';
        rep(i, 1, n / 4) cout << "0 ";
        rep(i, 1, n / 2) cout << "-1 ";
    } else if (n % 4 == 3) {
        rep(i, 1, n / 4) cout << (n / 2) << ' ';
        cout << (n / 4) << " 0 ";
        rep(i, 1, n / 4) cout << "0 ";
        rep(i, 1, n / 2) cout << "-1 ";
    }
    cout << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
