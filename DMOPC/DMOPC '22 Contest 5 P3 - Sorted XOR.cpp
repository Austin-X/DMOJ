#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

const int MPOW = 30;
bool canFlip[MPOW + 1];

void solve() {
    int n, ans = 0, x;
    cin >> n;

    int b[n + 1];
    b[0] = 0;
    
    rep(i, 1, n) {
        cin >> x;
        b[i] = b[i - 1] ^ x;

        int diffIdx = -1;
        for (int j = MPOW; j >= 0; j --) if ((b[i] & (1 << j)) != (b[i - 1] & (1 << j))) { diffIdx = j; break; }

        if (b[i] < b[i - 1]) {
            if (canFlip[diffIdx]) {
                canFlip[diffIdx] = false;
                b[i] = b[i] ^ (1 << diffIdx);
            } else {
                ans ++;
                fill(canFlip, canFlip + MPOW + 1, true);
            }
        } else if (diffIdx != -1) canFlip[diffIdx] = false;
    }

    cout << ans << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
