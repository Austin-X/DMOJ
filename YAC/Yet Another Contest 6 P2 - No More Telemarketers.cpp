#include <bits/stdc++.h>
#include <unistd.h>

using namespace std;

int ceo;

static void dfs(int u, bool vis[], int parent[], int t[]) {
    if (u == ceo) return;
    if (!vis[t[u]]) dfs(t[u], vis, parent, t);
    vis[u] = true;
    if (parent[u] != t[u])  cout << u << " " << t[u] << endl;
}

int main() {
    int n, ans = 0, x;
    cin >> n;
    
    int parent[n + 1], t[n + 1]; 
    bool vis[n + 1];
    for (int i = 1; i <= n; i++) vis[i] = false;
    
    for (int i = 1; i <= n; i ++) {
        cin >> x;
        if (x == -1) ceo = i;
        parent[i] = x; 
    }
    
    for (int i = 1; i <= n; i ++) {
        cin >> t[i];
        if (t[i] == -1 && ceo != i) { cout << -1 << endl; return 0; }
        if (parent[i] != t[i]) ans ++;
    }
    
    cout << ans << endl;
    for (int i = 1; i <= n; i ++) if (!vis[i]) dfs(i, vis, parent, t);
    return 0;
}
