#include<stdio.h>
#include<conio.h>
#include<math.h>
#include"ham.h"

#include<stdio.h>
#include<conio.h>
#include<math.h>
float cung(float x)
{
 float b;
 b=6.5*x*x*x - 26*x + 3.9;    
 return(b);
}
float cung1(float x)
{float b;
b = 6.5*3*x*x - 26;
return(b);
}
float cung2(float x)
{float b;
b = 6.5*3*2*x;
return(b)
}
int main()
{
 float x1,x2,x3,f1,f2,f3,e,err,n;
 printf("nhap x1 va x2");
 scanf("%f",&x1);
 scanf("%f",&x2);
 printf("nhap margin error");
 scanf("%f", &e);
 do
 {
  f1=cung(x1);
  f2=cung(x2);
  x3=x1-(f1*(x1-x2)/(f1-f2)));
  err=fabs((f1))/(x3);
  x1=x2;
  x2=x3;
  printf("x1=\n%f\t",x1);
 }
 while(err>e);
  
  getch();
}
