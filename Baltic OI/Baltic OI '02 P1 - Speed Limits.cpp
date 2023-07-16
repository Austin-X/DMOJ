#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
#define triple tuple<int, int, int>
#define node tuple<double, int, int, int, int>
using namespace std;
typedef long long ll;

const int MV = 500;

void solve() {
    int n, m, d;
    cin >> n >> m >> d;

    vector<triple> adj[n];
    while (m-- > 0) {
        int a, b, v, l;
        cin >> a >> b >> v >> l;
        adj[a].push_back({b, v, l});
    }

    bool vis[n][MV + 1];
    fill(vis[0], vis[0] + n * (MV + 1), false);
    pii res[n][MV + 1];
    priority_queue<node, vector<node>, greater<node>> pq;
    res[0][70] = {0, 0};
    pq.push({0.0, 70, 0, 0, 0});

    while (!pq.empty()) {
        node u = pq.top();
        pq.pop();
        if (vis[get<2>(u)][get<1>(u)]) continue;
        
        double time = get<0>(u);
        int u_limit = get<1>(u), src = get<2>(u), prev = get<3>(u), prev_lim = get<4>(u);

        vis[src][u_limit] = true;
        if (src != 0) res[src][u_limit] = {prev, prev_lim};

        if (src == d) {
            pii cur = {src, u_limit};
            stack<int> s;
            while (cur.first != 0) {
                s.push(cur.first);
                cur = {res[cur.first][cur.second].first, res[cur.first][cur.second].second};
            }
            s.push(0);
            while(!s.empty()) { cout << s.top() << ' '; s.pop(); }
            cout << '\n';
            break;
        }

        for (triple t: adj[src]) {
            int dest = get<0>(t), v_limit = get<1>(t) == 0 ? u_limit : get<1>(t), length = get<2>(t);
            if (!vis[dest][v_limit]) pq.push(make_tuple(time + (double)length / v_limit, v_limit, dest, src, u_limit));
        }
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
