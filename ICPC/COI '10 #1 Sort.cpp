#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    int boxes[n + 1];
    bool vis[n + 1];
    fill(vis, vis + n + 1, false);
    rep(i, 1, n) cin >> boxes[i];

    vector<vector<int>> ops;
    while (true) {
        int idx = -1;
        rep(i, 1, n) if (!vis[i]) { idx = i; break; }
        if (idx == -1) break;

        int start = idx;
        vis[start] = true;

        if (idx == boxes[idx]) continue;
        
        idx = boxes[idx];
        vector<int> temp;
        temp.push_back(start);
        while (idx != start) {
            vis[idx] = true;
            temp.push_back(idx);
            idx = boxes[idx];
        }
        ops.push_back(temp);
    }

    if (ops.size() > 2) {
        vector<int> op1, op2;
        for (vector<int> v: ops) for (int x: v) op1.push_back(x);
        op2.push_back(1);
        for (int i = ops.size() - 1; i > 0; i --) op2.push_back(*ops[i].begin());
        ops.clear();
        ops.push_back(op1);
        ops.push_back(op2);
    }

    cout << ops.size() << '\n';
    for (vector<int> v: ops) {
        cout << v.size() << ":";
        for (int x: v) cout << ' ' << x;
        cout << '\n';
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
