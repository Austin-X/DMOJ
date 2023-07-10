#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;
    pii research[n];
    for (int i = 0, a, s; i < n; i ++) {
        cin >> a >> s;
        research[i] = {a, s};
    }

    sort(research, research + n); 
    multiset<int> stations;
    int needed = 0;
    for (int i = 0; i < n; i ++) {
        if (!stations.empty() && stations.lower_bound(research[i].first - m) != stations.end() && *stations.lower_bound(research[i].first - m) <= research[i].first) stations.erase(stations.lower_bound(research[i].first - m));
        else needed ++;
        stations.insert(research[i].first + research[i].second);
    }

    cout << (n - needed) << '\n';
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
