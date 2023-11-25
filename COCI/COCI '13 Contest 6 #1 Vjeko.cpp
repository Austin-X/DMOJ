#include <bits/stdc++.h>
#define rep(x,y,z) for(ll x=y;x<=z;x++)
#define pii pair<int, int>
#define tomax(a, b) ((a) = max((a), (b)))
#define tomin(a, b) ((a) = min((a), (b)))
#define EL "\n"
using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    string pat;
    cin >> pat;
    
    while (n--) {
        string word;
        cin >> word;
        
        bool flag = true;
        
        for (int i = 0; i < pat.length(); i ++) {
            if (pat[i] == '*') break;
            if (pat[i] != word[i]) flag = false;
        }
        for (int i = 0; i < pat.length(); i ++) {
            if (i == word.length()) { flag = false; break; }
            if (pat[pat.length() - i] == '*') break;
            if (pat[pat.length() - i] != word[word.length() - i]) flag = false;
        }
        cout << (flag ? "DA" : "NE") << EL;
    }
}

int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);

    solve();
    return 0;
}
