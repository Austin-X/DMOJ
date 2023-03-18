#include <bits/stdc++.h>
#include <unistd.h>

using namespace std;

typedef long long ll;
typedef pair<int, ll> node;
typedef tuple<int, int, ll, ll> edge;

const int MX_N = 2000;
const ll INF = 1e18;
int n, m;
vector<node> adj[MX_N + 1];
vector<edge> edges;
ll dis[MX_N + 1];

bool edge_comp(const edge& a,  const edge& b) {
    return (get<2>(a) == get<2>(b)) ? (get<3>(a) < get<3>(b)) : (get<2>(a) < get<2>(b));
}

class Node_compare {
public:
    bool operator() (node a, node b) {
        return a.second == b.second ? a.first > b.first : a.second > b.second;
    }
};

void dijkstra(int src) {
    priority_queue<node, vector<node>, Node_compare> pq;
    pq.push({src, 0});
    while (!pq.empty()) {
        node n = pq.top();
        pq.pop();
        for (node u: adj[n.first]) {
            if (n.second + u.second < dis[u.first]) {
                dis[u.first] = n.second + u.second;
                pq.push({u.first, dis[u.first]});
            }
        }
    }
}

int main() {
    cin >> n >> m;
    for (int i = 0, u, v, l, c; i < m; i ++) {
        cin >> u >> v >> l >> c;
        edges.push_back({u, v, l, c});
    }

    ll ans = 0;
    sort(edges.begin(), edges.end(), edge_comp);
    bool vis[n + 1] = { 0 };

    for (edge e: edges) {
        int src = get<0>(e), dest = get<1>(e);
        ll length = get<2>(e), cost = get<3>(e);
        fill_n(dis, n + 1, INF);
        dis[src] = 0;
        dijkstra(src);

        if (!vis[src] || !vis[dest] || length < dis[dest]) {
            vis[src] = true;
            vis[dest] = true;
            ans += cost;
        }
        adj[src].push_back({dest, length});
        adj[dest].push_back({src, length});
    }

    cout << ans << '\n';
    return 0;
}
