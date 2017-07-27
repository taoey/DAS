/*
2017-03-1 分蛋糕
*/

#include<iostream>
#include<list>
using namespace std;


int main() {

	int n, k;
	list<int> cake;
	int sum =0;
	
	//input
	cin >> n >> k;
	for (int i = 0; i < n;i++) {
		int temp;
		cin >> temp;
		cake.push_back(temp);
	}

	//slove
	int weight = 0;
	while (! cake.empty() && weight < k) {
		weight+=cake.front();
		cake.pop_front();
		if (weight>=k) {
			sum++;
			weight = 0;
		}
	}
	//output
	if (weight!=0) {
		sum++;
	}
	cout << sum;



	return 0;
}