#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef long double ld;
 
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;
typedef pair<ld, ld> pd;
 
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<ld> vd;
typedef vector<pi> vpi;
typedef vector<pl> vpl;
typedef vector<pd> vpd;

#define f first
#define s second
#define mp make_pair
#define pb push_back
#define lb lower_bound
#define ub upper_bound
#define all(x) x.begin(), x.end()
#define rep(x,y,z) for(ll x=y;x<=z;x++)

const int MN = 2e5 + 5;

int n, m;
int leftmost[MN], t[MN<<2], lazy[MN<<2];

void push(int v) {
    t[v<<1] += lazy[v];
    t[v<<1|1] += lazy[v];
    lazy[v<<1] += lazy[v];
    lazy[v<<1|1] += lazy[v];
    lazy[v] = 0;
}

void update(int v, int tl, int tr, int l, int r, int add) {
    if (l > r) return;
    if (l == tl && r == tr) {
        t[v] += add;
        lazy[v] += add;
    } else {
        push(v);
        int tm = (tl + tr)>>1;
        update(v<<1, tl, tm, l, min(r, tm), add);
        update(v<<1|1, tm + 1, tr, max(l, tm + 1), r, add);
        t[v] = min(t[v<<1], t[v<<1|1]);
    }
}

int query(int v, int tl, int tr, int l, int r) {
    if (l > r) return MN;
    if (l == tl && r == tr) return t[v];
    push(v);
    int tm = (tl + tr)>>1;
    return min(query(v<<1, tl, tm, l, min(r, tm)), query(v<<1|1, tm + 1, tr, max(l, tm + 1), r));
}

void solve() {
    cin >> n >> m;
    iota(leftmost + 1, leftmost + n + 2, 1);

    for (int i = 0, a, b; i < m; i ++) {
        cin >> a >> b;
        leftmost[a] = min(leftmost[a], b);
        leftmost[b] = min(leftmost[b], a);
    }

    int suf[n + 2], dp[n + 1];
    suf[n + 1] = n;
    for (int i = n; i >= 1; i --) suf[i] = min(leftmost[i], suf[i + 1]);

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
