/* 
find_if()  +vector 举例

*/

#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

class aa {
public:
       int a;

       aa(int arg) {
              a = arg;
       }
};

template<int n>
bool cc(aa obj) {
       return obj.a > n;
}

int main() {

       vector<aa>  aaList;
       aa a1(4);
       aa a2(1);
       aa a3(5);
       aaList.push_back(a1);
       aaList.push_back(a2);
       aaList.push_back(a3);

        vector<aa>::iterator it=find_if(aaList.begin(), aaList.end(),cc<4>);
        int a = distance(aaList.begin(), it);//计算找到的第一个符合要求的值的下标
       return 0;
}
