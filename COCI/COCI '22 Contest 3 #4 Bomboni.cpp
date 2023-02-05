#include <bits/stdc++.h>
#include <unistd.h>

using namespace std;

typedef tuple<int, int, int> triple;
const int MOD = 998244353, MX = 500;
int field[MX + 1][MX + 1], ways[MX + 1][MX + 1];
int n;
map<triple, int> cache;

static int gcd (int a, int b) {
    return b == 0 ? a : gcd (b, a % b);
}

static int solve(int row, int col, int k) {
    if (row == 0 || col == 0 || field[row][col] == -1) return 0;
    
    triple c = make_tuple(row, col, k);
    if (cache.count(c) == 1) return cache[c];
    
    k /= gcd(field[row][col], k);
    
    if (k == 1) cache[c] = ways[row][col];
    else cache[c] = (solve(row - 1, col, k) + solve(row, col - 1, k)) % MOD;
    return cache[c];
}

int main() {
    int k;
    cin >> n >> k;
    memset(ways, 0, sizeof(ways));
    ways[1][0] = 1;
    for (int i = 1; i <= n; i ++) for (int j = 1; j <= n; j ++) { cin >> field[i][j]; ways[i][j] = field[i][j] != -1 ? (ways[i][j - 1] + ways[i - 1][j]) % MOD : 0; }
    
    cout << solve(n, n, k) << endl;
    return 0;
}
