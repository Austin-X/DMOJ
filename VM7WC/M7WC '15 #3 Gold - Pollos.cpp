#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;

const int MN = 1e5 + 5;
int n, k;
int p[MN], f[MN];
map<int, int> mp;

bool works(int x) {
    int dp[n + 1];
    dp[0] = 0;

    int lastFringy = -1;
    for (int i = 1; i <= n; i ++) {
        int idx = (*mp.lower_bound(p[i] - x)).second;
        if (idx == i) return false;

        if (lastFringy != -1 && p[i] - p[lastFringy] <= x) dp[i] = dp[lastFringy] + 1;
        else dp[i] = dp[idx] + 1;

        if (f[i]) {
            if (dp[i] > k) return false;
            lastFringy = i;
        }
    }
    return dp[n] <= k;
}

void solve() {
    cin >> n >> k;
    mp[0] = 0;
    for (int i = 1, pi, fi; i <= n; i ++) {
        cin >> pi >> fi;
        p[i] = pi;
        f[i] = fi;
        mp[p[i]] = i;
    }

    int l = 1, r = 1e9;
    while (l <= r) {
        int mid = (l + r) >> 1;
        if (works(mid)) r = mid - 1;
        else l = mid + 1;
    }

    if (l > 1e9) cout << "DEA Bust!";
    else cout << l;
    cout << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
