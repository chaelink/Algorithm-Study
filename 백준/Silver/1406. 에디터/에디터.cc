#include <iostream>
#include <list>
#include <string>

using namespace std;

int main() {
    string input;
    cin >> input;

    list<char> editor(input.begin(), input.end());
    auto cursor = editor.end();

    int m;
    cin >> m;

    while (m--) {
        char command;
        cin >> command;

        if (command == 'L') {
            if (cursor != editor.begin()) cursor--;
        } 
        else if (command == 'D') {
            if (cursor != editor.end()) cursor++;
        } 
        else if (command == 'B') {
            if (cursor != editor.begin()) {
                cursor--;
                cursor = editor.erase(cursor);
            }
        } 
        else if (command == 'P') {
            char x;
            cin >> x;
            editor.insert(cursor, x);
        }
    }

    for (char c : editor) {
        cout << c;
       
    }
    
    return 0;
}