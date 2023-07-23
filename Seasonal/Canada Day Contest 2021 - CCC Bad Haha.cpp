#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    string n;
    int k;
    cin >> n >> k;
    vector<int> bg, ed;
    for (char c: n) {
        int d = c - '0';
        while (k && !bg.empty() && d < bg.back()) { k --; ed.push_back(bg.back()); bg.pop_back(); }
        bg.push_back(d);
    }
    while (k && !bg.empty()) { k --; ed.push_back(bg.back()); bg.pop_back(); }

    sort(ed.begin(), ed.end());
    for (int x: bg) cout << x;
    for (int x: ed) cout << x;
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
