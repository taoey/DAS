#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;


void mySwap(int name, int step, vector<int> &dataList)
{
	vector<int>::iterator it = find(dataList.begin(), dataList.end(), name);
	
	int loc = it - dataList.begin();
	
	if (step > 0)
	{
		for (int i = 0; i < step; i++)
		{
			int c = loc + 1;
			swap(dataList[loc], dataList[c]);
			loc++;
		}
	}
	else if (step < 0)
	{
		for (int i = 0; i < -step; i++)
		{
			int c = loc - 1;
			swap(dataList[loc], dataList[c]);
			loc--;
		}
	}
}

int main() {
	int n, m,name,step;
	cin >> n;
	cin >> m;
	vector<int> v;

	for (int i = 1; i <= n; i++)
	{
		v.push_back(i);
	}

	for (int i = 0; i < m; i++)
	{
		cin >> name >> step;
		mySwap(name, step, v);
	}
	
	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i] << " ";
	}

	return 0;
}







/*
vector<int>().swap(myvector);//释放掉无用内存
*/