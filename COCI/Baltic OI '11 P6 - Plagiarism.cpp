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

const int M = 1e5 + 1;
int f[M];

void solve() {
    int n;
    cin >> n;
    fox(i, n) { cin >> f[i]; f[i] *= 9; }
    sort(f, f + n);

    ll ans = 0;
    fox(i, n) ans += (upper_bound(f, f + n, f[i] / 9 * 10) - &f[i]) - 1;
    cout << ans << EL;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
