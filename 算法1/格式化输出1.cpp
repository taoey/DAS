/************************************************************************/
/* 
题目要求：
读入三个整数，按每个整数占8个字符的宽度，右对齐输出它们。

考查内容：
C++的格式化输出（参考文档：）

*/
/************************************************************************/



#include <iostream>
#include <iomanip>
using namespace std;
int main ()
{
	int a,b,c;
	cin>>a>>b>>c;
	cout<<setw(8)<<setiosflags(ios::right)<<a<<" ";
	cout<<setw(8)<<setiosflags(ios::right)<<b<<" ";
	cout<<setw(8)<<setiosflags(ios::right)<<c;
	return 0;
	
}