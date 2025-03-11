#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int L, C;
vector<char> letters;
vector<char> selected;

void dfs(int index, int vowels, int consonants) {
    if (selected.size() == L) {
        if (vowels >= 1 && consonants >= 2) {
            for (char c : selected) cout << c;
            cout << '\n';
        }
        return;
    }

    for (int i = index; i < C; i++) {
        selected.push_back(letters[i]);

        if (letters[i] == 'a' ||letters[i] == 'e'|| letters[i] == 'i' || letters[i] == 'o' || letters[i] == 'u') {
            dfs(i + 1, vowels + 1, consonants);
        } else {
            dfs(i + 1, vowels, consonants + 1);
        }
        selected.pop_back();
    }
}

int main() {
    cin >> L >> C;
    letters.resize(C);

    for (int i = 0; i < C; i++) cin >> letters[i];
    sort(letters.begin(), letters.end());

    dfs(0, 0, 0);
    return 0;
}
