#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

bool canFlip[31];

void solve() {
    int n, ans = 0, x;
    cin >> n;

    int b[n + 1];
    b[0] = 0;
    
    rep(i, 1, n) {
        cin >> x;
        b[i] = b[i - 1] ^ x;
        if (b[i] < b[i - 1]) {
            for (int j = 30; j >= 0; j --) {
                if ((b[i] & (1 << j)) != (b[i - 1] & (1 << j))) {
                    if (canFlip[j]) {
                        canFlip[j] = false;
                        b[i] = b[i] ^ (1 << j);
                    } else {
                        ans ++;
                        fill(canFlip, canFlip + 31, true);
                    }
                    break;
                }
            }
        } else {
            for (int j = 30; j >= 0; j --) if ((b[i] & (1 << j)) != (b[i - 1] & (1 << j))) { canFlip[j] = false; break; }
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
