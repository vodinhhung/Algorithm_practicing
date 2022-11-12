#include "stdio.h"
#include "conio.h"
#include "math.h"

float a;
int n;

float f(x)
float x;
{
    float p;
    p = pow(x,n) - a;
    return ((float) p);
}
float f1(x)
float x;
{
    float p;
    p = n*pow(x,n-1);
    return ((float) p);
}
float f2(x)
float x;
{
    float p;
    p = n*(n-1)*pow(x,n-2);
    return ((float) p);
}

main()
{
    float b,c,err,e,m,x0,x1,d;
    printf("Nhap a va n: "); scanf("%f \n %d",&a,&n);
    printf("Nhap so e: "); scanf("%f",&e);
    if(a==0) x1=0; if(a==1) x1=1;
    if(n%2==0)
    {
        if(a<0) printf("khong ton tai can bac n cua a");
        if(a>0 && a<1) {b=0; c=1;}
        if(a>1) {b=1; c=a; }
        if(f1(b) > f1(c)) m =f1(c);
        else m = f1(b);
        if(f2(b) > 0) { d = c; x0 = b; }
        else { d = b; x0 = c; }
        err = 10000;
        while(err>e)
        {
            x1 = x0 - f(x0)*(x0-d)/(f(x0) - f(d));
            err = f(x1)/m;
            if (err>0) err=err;
            else err=-err;
            x0=x1;
        }
    }
    if(n%2!=0)
    {
        if(a>1) {b=1; c=a;}
        if(a>0 && a<1) {b=0; c=1;}
        if(a<0 && a>(-1)) {b=-1; c=0;}
        if(a<-1) {b=a; c=-1;}
        if(f1(b) > f1(c)) m=f1(c);
        else m = f1(b);
        if(f2(b) > 0) { d = c; x0 = b; }
        else { d = b; x0 = c; }
        err = 10000;
        while(err>e)
        {
            x1 = x0 - f(x0)*(x0-d)/(f(x0) - f(d));
            err = fabs(f(x1)/m);
            if (err > 0) err = err;
            else err = -err;
            x0=x1;
        }
    }
    printf("can ban %d cua %f la %f",n,a,x1);
}
