#include<iostream>
#include <conio.h>
#include <stdio.h>
using namespace std;
double GTTD(double x)
   {if (x>=0)
   {
    return (x); }
   else return (-x);
      }
void NhapHPT(double A[20][20],int m)
      {
  for (int i=1;i<=m;i++)
   for (int j=1;j<=m+1;j++)
    cin>> A[i][j];
}
double Tong(double A[20][20],int hang,int m)
{double S=0;
 int k;
 for (k=1;k<=m;k++) if (k!=hang) S=S+GTTD(A[hang][k]);
 return S;
}
int KTDK(double A[20][20],int m)
   {   int kt=1,i,j;
       for (i=1;i<=m;i++)
      if (GTTD(A[i][i]<Tong(A,i,m))) { kt=0;
                               break;
                              }
      return kt;
   }
double maxerr(double X1[20], double X0[20],int m)
{ int k,v;
  double max=GTTD(X1[1]-X0[1]);
  for (k=1;k<=m;k++)
      if (max< GTTD(X1[k]-X0[k])) max=GTTD(X1[k]-X0[k]);
  return max;
}
void Biendoi(double A[20][20],int m)
{ int i,j;
 for (i=1;i<=m;i++)
   for (j=1;j<=m+1;j++) if (j!=i) if (j==m+1)  A[i][j]=A[i][j]/A[i][i];
                           else
                             A[i][j]=-A[i][j]/A[i][i];
for (i=1;i<=m;i++)  A[i][i]=0;
}
void GiaiPT(double A[20][20],int m,double err)
{ int i,j;
  double q,X0[20],X1[20];
  double err0;
  q=Tong(A,1,m);
    for (i=2;i<=m;i++) if (q<Tong(A,i,m)) q=Tong(A,i,m);
    cout<<"q="<<q<<endl;
    err0=err*(1-q)/q;
  for (i=1;i<=m;i++) X0[i]=A[i][m+1];
  for (i=1;i<=m;i++)4

    6
  { X1[i]=0;
   for (j=1;j<=m;j++) X1[i]=X1[i]+A[i][j]*X0[j];
   X1[i]=X1[i]+A[i][m+1];
       }
  while (maxerr(X1,X0,m) > err0)
    { for (i=1;i<=m;i++) X0[i]=X1[i];
    for (i=1;i<=m;i++)
       { X1[i]=0;
         for (j=1;j<=m;j++) X1[i]=X1[i]+A[i][j]*X0[j];
         X1[i]=X1[i]+A[i][m+1];
       }

    }
cout<<"nghiem cua he la: "<<endl;
for (i=1;i<=m;i++) cout<<"X"<<i<<"="<<X1[i]<<endl;
}
int main()
{ double A[20][20],err;
   int m,ktra=0;
cout<<"nhap m=";cin>>m;
cout<<"nhap sai so =";cin>>err;
cout<<"nhap he phuong trinh:"<<endl;
NhapHPT(A,m);
ktra=KTDK(A,m);
if (ktra=0) { cout<<"He khong thoa man dieu kien lap Jacobi cheo troi hang";}
Biendoi(A,m);
GiaiPT(A,m,err);

for (int k=1;k<=m;k++)
    {for (int v=1;v<=m+1;v++)
     cout <<A[k][v]<<" ";
     cout<<"\n";
            }
getch();
}

