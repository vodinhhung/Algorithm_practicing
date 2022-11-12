#include "stdio.h"
#include "conio.h"
#include "math.h"

float a1,a2,a3,a4;

Inputdata()
{
    printf("Nhap cac he so cua phuong trinh: ");
    scanf("%f\n %f\n %f\n %f\n",&a1,&a2,&a3,&a4);
}

float f(float x)
{
    float p;
    p = a1*x*x*x + a2*x*x + a3*x +a4;
    return((float) p);
}
float f1(float x)
{
    float p;
    p = 3*a1*x*x + 2*a2*x + a3;
    return((float) p);
}
float f2(float x)
{
    float p;
    p = 6*a1*x + 2*a2;
    return((float) p);
}

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
    Inputdata();
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
