#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
using namespace std;
typedef long long ll;
const int N = 2e5 + 5;

int n, m;
int leftmost[N], lazy[N<<2], t[N<<2];

void push(int v) {
    t[v<<1] += lazy[v];
    lazy[v<<1] += lazy[v];
    t[v<<1|1] += lazy[v];
    lazy[v<<1|1] += lazy[v];
    lazy[v] = 0;
}

void update(int v, int tl, int tr, int l, int r, int addend) {
    if (l > r) return;
    if (l == tl && r == tr) {
        t[v] += addend;
        lazy[v] += addend;
    } else {
        push(v);
        int tm = (tl + tr)>>1;
        update(v<<1, tl, tm, l, min(tm, r), addend);
        update(v<<1|1, tm + 1, tr, max(l, tm + 1), r, addend);
        t[v] = min(t[v<<1], t[v<<1|1]);
    }
}

int query(int v, int tl, int tr, int l, int r) {
    if (l > r) return N;
    if (l == tl && r == tr) return t[v];
    push(v);
    int tm = (tl + tr)>>1;
    if (r <= tm) return query(v<<1, tl, tm, l, r);
    else return min(query(v<<1, tl, tm, l, tm), query(v<<1|1, tm+1, tr, tm+1, r));
}

void solve() {
    cin >> n >> m;
    for (int i = 1; i <= n; i ++) leftmost[i] = i;
    for (int i = 0, a, b; i < m; i ++) {
        cin >> a >> b;
        leftmost[a] = min(leftmost[a], b);
        leftmost[b] = min(leftmost[b], a);
    }

    int suf[n + 2], dp[n + 1];
    suf[n + 1] = n;
    for (int i = n; i >= 1; i --) suf[i] = min(suf[i + 1], leftmost[i]);
    dp[1] = 0;

    for (int i = 2; i <= n; i ++) {
        update(1, 1, n, 1, leftmost[i] - 1, 1);
        dp[i] = query(1, 1, n, 1, min(suf[i + 1] - 1, i - 1));
        update(1, 1, n, i, i, dp[i]);
    }

    cout << dp[n] << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    solve();
    return 0;
}
