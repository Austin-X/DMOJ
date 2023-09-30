#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

const int MN = 1e5;
int freq[MN * 200];

void solve() {
    int n;
    cin >> n;
    
    int psa[n + 1];
    psa[0] = 0;
    rep(i, 1, n) { cin >> psa[i]; psa[i] += psa[i - 1]; }

    ll ans = 0;
    rep(i, 1, 100) {
        rep(j, 1, n) {
            freq[psa[j - 1] - i * (j - 1) + 100 * MN] ++; 
            ans += freq[psa[j] - i * j + 100 * MN];
        }
        rep(j, 0, n - 1) freq[psa[j] - i * j + 100 * MN] --;
    }

    cout << ans << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
