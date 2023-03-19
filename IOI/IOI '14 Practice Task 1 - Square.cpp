#include <bits/stdc++.h>
#include <unistd.h>

using namespace std;

typedef long long ll;

const int MX_N = 1e3;
static int psa[MX_N][MX_N];

int works(int n, int size) {
    int cnt = 0;
    for (int i = 1; i <= n - size + 1; i ++) {
        for (int j = 1; j <= n - size + 1; j ++) {
            if (psa[i + size - 1][j + size - 1] - psa[i + size - 1][j - 1] - psa[i - 1][j + size - 1] + psa[i - 1][j - 1] == 0) cnt ++;
        }
    }
    return cnt;
}

int main() {
    int n;
    cin >> n;

    int grid[n + 1][n + 1];
    fill(psa[0], psa[0] + (n + 1) * (n + 1), 0);

    for (int i = 1; i <= n; i ++) {
        for (int j = 1; j <= n; j ++) {
            cin >> grid[i][j];
            psa[i][j] = grid[i][j] == 0 ? psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + 1 : psa[i - 1] [j] + psa[i][j - 1] - psa[i - 1][j - 1];
       }
    }

    int lo = 0, hi = n, cnt;
    while (lo <= hi) {
        int mid = (lo + hi) >> 1;
        cnt = works(n, mid);
        if (cnt) lo = mid + 1;
        else hi = mid - 1;
    }

    cnt = works(n, hi);
    cout << hi * cnt << '\n';
    return 0;
}
