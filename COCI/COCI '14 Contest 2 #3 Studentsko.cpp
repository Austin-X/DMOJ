#include <bits/stdc++.h>
#define fox(i, n) for (int i = 0; i < (n); ++i)
#define rep(i, a, b) for (int i = (a); i <= (b); ++i)
#define pii pair<int, int>
#define tomax(a, b) ((a) = max((a), (b)))
#define tomin(a, b) ((a) = min((a), (b)))
#define F first
#define S second
#define EL "\n"
using namespace std;
typedef long long ll;

void solve() {
    int n, k;
    cin >> n >> k;

    vector<int> v(n + 1, 0), tmp;
    rep(i, 1, n) cin >> v[i];
    tmp = v;
    sort(tmp.begin(), tmp.end());
    unordered_map<int, int> mp;
    for (int i = 1, team = 1; i <= n; team += i % k == 0, i ++) mp[tmp[i]] = team;
    rep(i, 1, n) v[i] = mp[v[i]];

    vector<int> dp(n + 1, INT_MAX);
    dp[0] = INT_MIN;
    rep(i, 1, n) *upper_bound(dp.begin(), dp.end(), v[i]) = v[i];
    int lis = 0;
    rep(i, 1, n) if (dp[i] != INT_MAX) lis = i;
    cout << (n - lis) << EL;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
