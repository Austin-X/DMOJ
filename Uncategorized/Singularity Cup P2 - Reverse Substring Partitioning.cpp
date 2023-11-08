#include <bits/stdc++.h>
#define fox(i, n) for (int i = 0; i < (n); ++i)
#define rep(i, a, b) for (int i = (a); i <= (b); ++i)
#define pii pair<int, int>
#define tomax(a, b) ((a) = max((a), (b)))
#define tomin(a, b) ((a) = min((a), (b)))
#define F first
#define S second
#define EL "\n"
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    string s;
    cin >> s;
    s = " " + s;
    
    int contiguousMatchingSubsequences = 1;
    rep(i, 1, n - 1) contiguousMatchingSubsequences += s[i] != s[i + 1];
    cout << (s[1] != s[n] ? n : max(contiguousMatchingSubsequences - 1, 1)) << EL;
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
