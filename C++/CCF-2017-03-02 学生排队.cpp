/*
2017-03-02 学生排队
*/

#include<iostream>
#include<algorithm>
#include<math.h>

# define MAX 1000+10
using namespace std;


int main() {
	int n, m;
	int arr[MAX];
	//input
	cin >> n;
	for (int i = 1; i <= n; i++) {
		arr[i] = i;
	}

	cin >> m;
	for (int i = 0; i < m; i++) {
		int num, step;
		cin >> num >> step;
		//solve
		if (step>0) {//--->
			for (int j = 0; j < abs(step); j++) {
				int *d = find(arr + 1, arr + n, num);
				int place = distance(arr , d);
				swap(arr[place], arr[place++]);
			}

		}
		else {//<--
			for (int j = 0; j < abs(step); j++) {
				int *d = find(arr + 1, arr + n, num);
				int place = distance(arr, d);
				swap(arr[place], arr[place--]);

			}

		}
	}

	//output

	for (int i = 1; i <= n; i++) {
		cout << arr[i] << " ";
	}
	return 0;
}