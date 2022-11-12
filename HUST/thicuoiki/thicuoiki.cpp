#include<iostream>
#include <conio.h>
#include <stdio.h>
#include<math.h>
using namespace std;
double X[100],Y[100];
double f(double x)
{ return 1/x;
}
double tp(double a,double b,int n)
{ double h,f1=0;
  int t;
   X[0]=a;Y[0]=f(a);
   h=(b-a)/n;
  for (t=1;t<=n;t++)
	 {
	 	X[t]=X[t-1]+h;
	 	Y[t]=f(X[t]);
	  }
	for (t=0;t<=n;t++)
	  if ((t==0) || (t==n)) f1=f1+Y[t];
	 else if (t%2==1) f1=f1+4*Y[t];
	       else f1=f1+2*Y[t];
   return f1*h/3;
}
int main()
{   int n,i;
    double f2,h,a,b,s;
	cout<<"Nhap n: ";cin>>n;
	cout<<"Nhap a: ";cin>>a;
	cout<<"Nhap b: ";cin>>b;
	f2=tp(a,b,n);
	cout<<"x :";for (int i=0;i<=n;i++) cout<<X[i]<<"  ";
    cout<<"\ny: ";for (int i=0;i<=n;i++) cout<<Y[i]<<"  ";
    cout<<"\n";
	s=(f2-tp(a,b,2*n))/15;
    cout<<f2<<"\n";
    cout<<s;
	getch();
}
