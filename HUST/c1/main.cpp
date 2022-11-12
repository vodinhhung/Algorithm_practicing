#include <iostream>
#include <conio.h>
#include <stdio.h>
#include <math.h>
using namespace std;
/*Cau truc du lieu luu tru khoang phan ly*/
double GTTD(double x)
   {if (x>0)
   {
    return (x); }
   else return (-x);
      }
typedef struct  {
   int n;
   double*a;
   double*b;
}PhanLy;
/*Khoi tao khoang phan ly nghiem */
PhanLy KhoiTaoPhanLy(int n) {
   PhanLy PL;
   PL.a = new double [n];
   PL.b = new double [n];
   PL.n = 0;
   return PL;
}
/*Nhap vao mot da thuc*/
double*NhapDaThuc(int Bac) {
   double *A = new double [Bac+1];
   for(int i= 0; i<=Bac; i++) {
      cout<<"a"<<i<<" = ";
      cin>>A[i];
   }
   return A;
}
/*Xuat da thuc co he so A[] va Bac*/
void XuatDaThuc( double*A,int Bac, char s) {
   cout<<"Da Thuc Vua Nhap la:\n";
   cout<<s<<" = "<<A[0];
   for(int i=1; i<=Bac; i++){
      if(A[i]>0)
         cout<<" + "<<A[i]<<"x^"<<i;
      if(A[i]<0)
         cout<<A[i]<<"x^"<<i;
}
   }
/*Tinh gia tri cua da thuc tai diem x su dung luoc do hoocner*/
double f(double*A, int Bac, double x) {
    double KetQua = A[Bac];
   for(int i=Bac-1; i>=0; i--)
      KetQua=KetQua*x + A[i];
   return KetQua;
}
double dh1f(double*A, int Bac, double x){
	double ketqua = 0;
	for (int i=Bac;i>1;i--)
	ketqua= ketqua + i*A[i]*pow(x,i-1);
	ketqua=ketqua+A[1];
	return ketqua;
}
double dh2f(double*A, int Bac, double x){
	double ketqua = 0;
	for (int i=Bac;i>2;i--)
	ketqua= ketqua + i*(i-1)*A[i]*pow(x,i-2);
	ketqua=ketqua+ 2*A[2];
	return ketqua;
}
/*Tim Moi Khoang Phan Ly Nghiem*/
PhanLy TimPhanLy( double*A, int Bac,  double Xa,  double Xb, double BuocNhay) {
   PhanLy PL = KhoiTaoPhanLy(Bac);
   double k=Xa;
   while(k<=Xb){
      if(f(A,Bac,k)*f(A,Bac,k+BuocNhay)<0){
         PL.a[PL.n] = k;
         PL.b[PL.n] = k+BuocNhay;
         PL.n++;
      }
      k=k+BuocNhay;
   }
   return PL;
}
/*Xuat Moi Khoang Phan Ly Nghiem*/
void XuatPhanLy(PhanLy PL) {
   if(PL.n==0)
      cout<<"\nKhong Tim Duoc Khoang Phan Ly";
   else {
      for(int i = 0; i<PL.n; i++)
         cout<<"("<<PL.a[i]<<","<<PL.b[i]<<")\t";
   }
}
void GiaiPt( double*A,int Bac,double pl1, double pl2, double err)
{ double x0=0,d,h,z,x1=0,m1=0,M1=0,err1,k1,k2;
    k1=GTTD(dh1f(A,Bac,pl1));
    k2=GTTD(dh1f(A,Bac,pl2));
   if (k1<k2)
          { m1= k1;
            M1=k2;
	      }
	  else { M1=k1;
	         m1=k2;
	       }
	    err1= err*m1/(M1-m1);
  if ((f(A,Bac,pl1)*dh2f(A,Bac,pl1))>=0)
    {d=pl1;
	  z=f(A,Bac,d);
	  x0=pl2;
	       }
	else { d=pl2;
	       z=f(A,Bac,pl2);
	       x0=pl1;
	};
	x1=x0 - ( (f(A,Bac,x0)*(x0-d) )/( f(A,Bac,x0)-z) );
	h=x1-x0;
  while (GTTD(h) > err1)
    { x0=x1;
      x1=x0-((f(A,Bac,x0)*(x0-d))/(f(A,Bac,x0)-z));
      h=x1-x0;
    };
printf("\n  nghiem cua phuong trinh la x: %f",x1);
}

/*Chuong Trinh Chinh*/
int main(){

   double*Fx,a,b,BuocNhay,err;
   int n;
   char q='f';
   cout<<"nhap vao sai so: "; cin>>err;
   cout<<"Nhap Vao Bac Cua Phuong Trinh:";
   cin>>n;
   Fx = NhapDaThuc(n);
   XuatDaThuc(Fx,n,q);
   cout<<"\nNhap [a,b] Can Tim Khoang Phan Ly Nghiem:\n";
   cout<<"a = ";
   cin>>a;
   cout<<"b = ";
   cin>>b;
   cout<<"Nhap Buoc Nhay: ";
    cin>>BuocNhay;
   PhanLy PL = TimPhanLy(Fx,n,a,b,BuocNhay);
   cout<<"Khoang Phan Ly Tim Duoc:";
   XuatPhanLy(PL);
   for (int i=0;i<PL.n;i++)
   GiaiPt(Fx,n,PL.a[i],PL.b[i],err);
   getch();
   delete Fx;
}
