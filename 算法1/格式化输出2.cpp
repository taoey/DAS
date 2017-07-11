#include <iostream>
#include <string>
#include <vector>
#include <sstream>  
using namespace std;


vector<string> getStrList(char * str)
{
	char ch;
	int num=0;
	vector<string> list;
	ch=str[num];
	string temp="";

	while(ch!='\0')
	{

		if (ch>='0'&&ch<='9')//数字
		{
			temp+=ch;
			ch=str[++num];
		}
		else                //运算符
		{
			string s_ch;   //将运算符转化为string类型（char—>string）
			stringstream stream;
			stream<<ch;
			s_ch = stream.str();  

			list.push_back(temp);
			list.push_back(s_ch);
			temp="";
			ch=str[++num];

		}	

	}
	list.push_back(temp);

	return list;
}


int main()
{
	char str[100];
	cin.getline(str,100);
	vector<string> rstr;
	rstr=getStrList(str);
	return 0;
}