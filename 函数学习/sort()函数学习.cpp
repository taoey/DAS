#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class aa {
public:
       int x;
       aa(int a) {
              x = a;
       }
};

bool compare(aa a, aa b) {
       return a.x < b.x;    // "<"是升序排列   ">"是降序排列
}

int main() {

       vector<aa> aaList;
       aaList.push_back(aa(2));
       aaList.push_back(aa(77));
       aaList.push_back(aa(9));
       aaList.push_back(aa(19));
       sort(aaList.begin(), aaList.end(), compare);
       return 0;
}
