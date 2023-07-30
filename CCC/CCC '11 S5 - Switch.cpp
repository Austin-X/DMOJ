#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int k;
    cin >> k;
    int start = 0;
    for (int i = 0, t; i < k; i ++) {
        cin >> t;
        start += (1 << i) * t;
    }

    int res[1 << k];
    fill(res, res + (1 << k), -1);
    res[start] = 0;
    queue<int> q;
    q.push(start);

    while (!q.empty()) {
        int bm = q.front(); q.pop();
        if (bm == 0) {
            cout << res[bm] << '\n';
            break;
        }
        
        int x = 1;
        while (x < (1 << k)) {
            if (!(bm & x)) {
                int tmp = bm | x, lb = x >> 1, ub = x << 1;
                while (lb > 0 && tmp & lb) lb >>= 1;
                while (ub < (1 << k) && tmp & ub) ub <<= 1;
                lb = lb == 0 ? 1 : lb << 1;
                ub >>= 1;
                if (ub / lb >= 8) {
                    while (lb <= ub) {
                        tmp -= lb;
                        lb <<= 1;
                    }
                }
                if (res[tmp] == -1) {
                    res[tmp] = res[bm] + 1;
                    q.push(tmp);
                }
            }
            x <<= 1;
        }
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
