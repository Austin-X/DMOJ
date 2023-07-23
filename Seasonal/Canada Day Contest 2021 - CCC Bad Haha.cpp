#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    string n;
    int k;
    cin >> n >> k;
    vector<char> bg, ed;
    for (char c: n) {
        while (k && !bg.empty() && c < bg.back()) { k --; ed.push_back(bg.back()); bg.pop_back(); }
        bg.push_back(c);
    }
    while (k && !bg.empty()) { k --; ed.push_back(bg.back()); bg.pop_back(); }

    sort(ed.begin(), ed.end());
    for (char x: bg) cout << x;
    for (char x: ed) cout << x;
    cout << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while (t-- > 0) solve();
    return 0;
}
