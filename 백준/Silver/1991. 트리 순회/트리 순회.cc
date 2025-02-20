#include <iostream>
using namespace std;

char tree[26][2]; 

void preorder(char node) {           //전위 순회
    if (node == '.') return;
    cout << node; 
    preorder(tree[node - 'A'][0]);
    preorder(tree[node - 'A'][1]);
}

void inorder(char node) {           //중위 순회 
    if (node == '.') return;
    inorder(tree[node - 'A'][0]);
    cout << node; 
    inorder(tree[node - 'A'][1]);
}

void postorder(char node) {         //후위 순회
    if (node == '.') return;
    postorder(tree[node - 'A'][0]);
    postorder(tree[node - 'A'][1]);
    cout << node;
}


int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        char parent, left, right;
        cin >> parent >> left >> right;
        tree[parent - 'A'][0] = left; 
        tree[parent - 'A'][1] = right; 
    }

    preorder('A'); cout << "\n";
    inorder('A'); cout << "\n";
    postorder('A'); cout << "\n";

    return 0;
}
