#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

const int VALID_SIZE = 4;
int valid[] = {0, 4, 7, 10};

void solve() {
    int n, k, ans = 0;
    cin >> n >> k;
    int p[n + 1];
    rep(i, 1, n) cin >> p[i];

    rep(t, 0, 11) {
        vector<int> v;
        rep(i, 1, n) {
            int val = p[i] - t;
            if (val < 0) val += 12;
            if (find(valid, valid + VALID_SIZE, val % 12) == valid + VALID_SIZE) v.push_back(i);
        }
        int v_siz = v.size();

        if (v_siz <= k) ans = n;
        else {
            for (int i = k - 1; i < v_siz; i ++) {
                int r = i == v_siz - 1 ? n : v[i + 1] - 1, l = i == k - 1 ? 1 : v[i - k] + 1;
                ans = max(ans, r - l + 1);
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
