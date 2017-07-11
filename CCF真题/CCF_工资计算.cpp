#include<iostream>
using namespace std;



int resMoney(int n)
{
	if (n < 3500)
	{
		return n;
	}
	else if (n>3500)
	{
		int a = n - 3500;
		if (a < 1500)
		{
			return 3500 + a*0.97;
		}
		else if (a<4500)
		{
			return 3500 + 1500 * 0.97 + (a-1500)* 0.8;
		}
		else if (a<9000)
		{
			return 3500 + 1500 * 0.97 + 3000 * 0.9 + (a - 4500)*0.8;
		}
		else if (a<35000)
		{
			return 3500 + 1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8 + (a - 9000)*0.75;
		}
		else if (a<55000)
		{
			return 3500 + 1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8 + (35000 - 9000)*0.75 + (a - 35000)*0.7;
		}
		else if(a<80000)
		{
			return 3500 + 1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8 + (35000 - 9000)*0.75 + (55000 - 35000)*0.7 + (a - 55000)*0.65;
		}
		else
		{
			return 3500 + 1500 * 0.97 + 3000 * 0.9 + 4500 * 0.8 + (35000 - 9000)*0.75 + (55000 - 35000)*0.7 + (80000 - 55000)*0.65 + (a - 80000)*0.55;
		}
	}
}

int main()
{
	int a;
	cin >> a;
	cout << resMoney(a);
	cout << resMoney(a);
	cout << resMoney(a);
	cout << resMoney(a);
	cout << resMoney(a);



	return 0;
}