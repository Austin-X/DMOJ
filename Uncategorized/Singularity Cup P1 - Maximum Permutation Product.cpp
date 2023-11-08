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
    int n;
    cin >> n;
    int p[n];
    rep(i, 1, n) cin >> p[i];

    if (n == 1) cout << "1 1";
    else if (p[1] == 1) cout << "2 " << n;
    else if (p[n] == 1) cout << "1 " << (n - 1);
    else if (n == 3 && p[1] != 1 && p[3] != 1) cout << (p[1] == 3 ? "1 1" : "3 3");
    else cout << "1 " << n;
    cout << EL;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
