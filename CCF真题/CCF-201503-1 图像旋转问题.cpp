#include<iostream>
#define MAX 1000+10
using namespace std;



int map[MAX][MAX];
int main() {
		
	int n, m;//ÐÐ£¬ÁÐ

	 //input+solve
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[m- 1 - j][i];
		}
	}

	//output
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cout << map[i][j]<<" ";
		}
		cout << endl;
	}

	return 0;
}