#include <iostream>
#include "bits/stdc++.h"
using namespace std;

float m,n;
// ios::sync_with_stdio(0);
// cin.tie(0);
// cout.tie(0);

int main()
{
	cin >>m>>n;
	if (m!=n) \
	{ 
		if (m>n)
			cout<<m-n<<'\n'<<m+n;
		else 
			cout<<n-m<<'\n'<<n+m;
	}
	return 0; 
}