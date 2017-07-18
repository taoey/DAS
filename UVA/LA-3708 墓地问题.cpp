#include<iostream>
#include<math.h>
using namespace std;

int main() {
	int n, m;
	while (scanf_s("%d %d", &n, &m) != EOF) {
		double ans = 0.0;
		for (int i = 1; i < n;i++) {
			double pos = (double)i / n * (n + m);
			ans += fabs(pos - floor(pos + 0.5))/(n+m);
		}//end for
		printf("%.4lf\n", ans * 10000);
	}
	return 0;
}