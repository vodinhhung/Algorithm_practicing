#include "stdio.h"
#include "conio.h"
#include "math.h"

float GTTD(float x)
{
    if(x>0) return x;
    else return (-x);
}

float a1,a2,a3,a4,a5;
/* Nhap cac he so cua ham bac 3 */
Inputdata()
{
    printf("Nhap cac he so cua ham f(x): ");
    fflush(stdin);
    scanf("%f %f %f  %f %f",&a5,&a4,&a3,&a2,&a1);
}

float p(float x)
{
    float f;
    f = a5*x*x*x*x + a4*x*x*x + a3*x*x + a2*x + a1;
    return f;
}

float f(float x) //Ham f(x)
{
    float p;
    p = -(a5/a2)*x*x*x*x - (a4/a2)*x*x*x - (a3/a2)*x*x - (a1/a2);
    return((float) p);
}
float f1(float x) //Dao ham cap 1 cua ham f(x)
{
    float p;
    p = -4*(a5/a2)*x*x*x - 3*(a4/a2)*x*x - 2*(a3/a2)*x ;
    return((float) p);
}
float f2(float x) //Dao ham cap 2 cua ham f(x)
{
    float p;
    p = -12*(a5/a2)*x*x - 6*(a4/a2)*x - 2*(a3/a2);
    return((float) p);
}
// Kiem tra tinh ly nghiem cua khoang (x,y)
float kiemtra(x,y)
float x,y;
{
    float z,t,k;
    t=0;
    for(z=x;z<=y;z=z+0.001)
    {
        if (p(z)*p(z+0.001) > 0) t=t;
        else t=t+1;
    }
    if (t==0) k=0;
    else k=1;
    return k;
}

main()
{
    float a,b,e,x0,x1,d,err,q;
    int t;
    Inputdata();
    printf("Nhap gia tri e,a,b: ");
    fflush(stdin);
    scanf(" %f %f %f",&e,&a,&b);
    if (kiemtra(a,b) == 0) printf("(%f,%f) khong la khoang ly nghiem\n",a,b);
    else
    {
        printf("(%f,%f) la khoang ly nghiem\n",a,b);
        if(f1(a) > f1(b)) { q = f1(a); x0 = b; }
        else { q = f1(b); x0 = a; }
        err =1000;
        if(q<1)
        {
            while(err>e)
            {
                t=t+1;
                x1 = f(x0);
                err = q/(1-q)*GTTD(x1-x0);
                x0 = x1;
            }
        }
        else printf("Phuong trinh khong hoi tu nen khong dung duoc phuong phap nay");
    printf("Nghiem cua phuong trinh la %f va so lan lap la %d",x1,t);
    }
}
