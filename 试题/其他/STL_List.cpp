#include<iostream>
#include<list>
#include <algorithm>
using namespace std;




int main()
{
// 	int n;
// 	cin>>n;
// 	list<int> numList;      //声明一个双向链表
// 
// 	for(int i=1;i<=n;i++)   //初始化一个链表
// 	{
// 		numList.push_back(i);
// 	}
// 
// 	list<int>::iterator it; //声明一个双向链表迭代器
// 
// 	numList.remove_if([](int t){return t<3;});

	int  v1[10] = {1,3,2,5,4}; 
	list<int> a1;
	int a=sizeof(v1);
	int b=sizeof(int);
	int c=sizeof(char);
	int len=sizeof(v1)/sizeof(int);
	for(int i=0;i<len;i++)
	{
		a1.push_back(v1[i]);

	}
	

	int d=a1.size();
	a1.unique();
	list<int>::iterator it;
	cout << "unique:";
	for(it = a1.begin();it!=a1.end();it++){
		cout << *it << " ";
	}
	cout << endl;
	return 0;



	
}