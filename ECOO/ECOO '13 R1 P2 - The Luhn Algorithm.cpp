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
    for (int t = 0; t < 5; t ++) {
        string s;
        cin >> s;
        reverse(s.begin(), s.end());
        int res = 0;
        for (int i = 0; i < s.size(); i ++) {
            if (i % 2 == 1) res += s[i] - '0';
            else {
                string x = to_string((s[i] - '0') * 2);
                for (char c: x) res += c - '0';
            }
        }
        int rem = res % 10;
        cout << to_string((10 - rem) % 10);
    }
    cout << EL;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    rep(i, 1, 5) solve();
    return 0;
}
