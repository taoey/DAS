#include<iostream>
#include<vector>
#include<stack>
#include<algorithm>
#include <functional>
using namespace std;

class kingnight {
public:
	int x;
	bool isgy;// «∑ÒπÕ”∂

	kingnight(int a) {
		x = a;
		isgy = false;
	}

};
bool compare(kingnight a, kingnight b) {
	return a.x < b.x;
}
struct com : binary_function<kingnight, int, bool> {
	bool operator()(kingnight & a, int b) const {
		return (a.x>=b && a.isgy==false);
	}
};
int main() {

	//input
	int n, m;
	stack<int> dragon;
	vector<kingnight> kingList;
	while (cin >> n >> m && n!=0 && m!=0) {

		int nn = n;
		int mm = m;
		while (nn--) {
			int temp;
			cin >> temp;
			dragon.push(temp);
		}
		while (mm--) {
			int temp;
			cin >> temp;
			kingnight tk(temp);
			kingList.push_back(tk);
		}

		//solve
		sort(kingList.begin(), kingList.end(), compare);
		
		int sum = 0;//ª®∑—
		while(!dragon.empty()) {
			
			int temp = dragon.top();			
			vector<kingnight>::iterator it = find_if(kingList.begin(), kingList.end(), bind2nd(com(), temp));
			int t = distance(kingList.begin(), it);
			if (it != kingList.end()) {
				dragon.pop();
				kingList[t].isgy = true;
				sum += kingList[t].x;
			}
			else {
				break;
			}
		}
		if (!dragon.empty())
			cout << "Loowater is doomed!" << endl;
		else
			cout << sum << endl;
	}
	return 0;
}