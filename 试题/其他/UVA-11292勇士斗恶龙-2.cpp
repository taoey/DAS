#include<iostream>
#include<stack>
#include<algorithm>

#define MAX 2000+10
using namespace std;


int main() {

	stack<int> drigon;
	int kingnight[MAX];

	int n, m;
	while (cin >> n >> m &&n != 0 && m != 0) {
		//input
		for (int i = 0; i < n; i++) {
			int t;	cin >> t; drigon.push(t);			
		}
		for (int i = 0; i < m; i++) cin >> kingnight[i];

		//solve
		int cur = 0; //当前位置
		int cost = 0;//花费
		sort(kingnight, kingnight + m);


		while (!drigon.empty() && cur < m) {
			int dtop = drigon.top();
			
			if (kingnight[cur] >= dtop) {
				drigon.pop();
				cost += kingnight[cur];
				cur++;
			}
				
		}//end while


		if (drigon.empty())
			cout << cost << endl;
		else
			cout << "Loowater is doomed!" << endl;

	}
	return 0;
}