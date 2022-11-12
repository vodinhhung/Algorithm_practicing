#include "stdio.h"
#include "conio.h"
#include "math.h"

float a1,a2,a3,a4,a5;
/* Nhap cac he so cua ham bac 3 */
Inputdata()
{
    printf("Nhap cac he so cua ham f(x): ");
    fflush(stdin);
    scanf("%f %f %f  %f %f",&a5,&a4,&a3,&a2,&a1);
}

float f(float x) /* Ham f(x) */
{
    float p;
    p = a5*x*x*x*x + a4*x*x*x + a3*x*x + a2*x +a1;
    return((float) p);
}
float f1(float x) /* Dao ham cap 1 cua ham f(x) */
{
    float p;
    p = 4*a5*x*x*x + 3*a4*x*x + 2*a3*x +a2;
    return((float) p);
}
float f2(float x) /* Dao ham cap 2 cua ham f(x) */
{
    float p;
    p = 12*a5*x*x + 6*a4*x + 2*a3;
    return((float) p);
}
/* Kiem tra tinh ly nghiem cua khoang (x,y) */
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
    Inputdata();
    float a,b,e,dau,z,c,x;
    int t;
    printf("Nhap gia tri cua a,b: ");
    fflush(stdin);
    scanf("%f%f",&a,&b);
    if (f(a) > 0) dau = 1;
    if (f(a) < 0) dau = -1;
    printf("Nhap gia tri muon tinh cua e = "); scanf("%f",&e);
    t=0;
    if(kiemtra(a,b) == 0) printf("(%f,%f) khong phai khoang phan ly",a,b);
    else 
    {
        printf("(%f,%f) la khoang phan ly",a,b);
        for(;;)
        {
            t=t+1;
            c=(a+b)/2;
            z=f(c);
            if (z==0)
            {
                x=c;
                break;
            }
            else
            {
                if (z*dau < 0) b=c;
                else a=c;
                if ((b-a)<e) break;
                else x=c;
            }
        }
    printf(" Gia tri cua nghiem phuong trinh la %f va so lan lap la %d",x,t);
    }
}

