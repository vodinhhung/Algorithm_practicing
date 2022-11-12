#include "stdio.h"
#include "conio.h"
#include "ham.h"
float kiemtra(x,y)
float x,y;
{
    float z,t,p;
    for(z=x;z<y;z=z+0.01)
    {
        if (f1(z)*f1(z+0.01)>0) t=1;
        else t=0;
    }
    if(f(x)*f(y)<0 && t==1) p=1;
    else p=0;
    return((float) p);
}
main()
{
    float a,b,e,x0,x1,d,err,m;
    printf("nhap gia tri e, a, b : "); scanf("%f %f %f",&e,&a,&b);
    if(kiemtra(a,b) == 0) printf("(%f;%f) khong la khoang ly nghiem",a,b);
    else
    {
        printf("(%f;%f) la khoang ly nghiem",a,b);
        if(f1(a) > f1(b)) m=f1(b);
        else m = f1(a);
        if(f2(a) > 0) { d = b; x0 = a; }
        else { d = a; x0 = b; }
        err = 1000;
        while(err>e)
        {
            x1 = x0 - f(x0)*(x0-d)/(f(x0) - f(d));
            err = f(x1)/m;
            x0=x1;
        }
    printf("\n nghiem cua phuong trinh la %f",x1);
    }
}
