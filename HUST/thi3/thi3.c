#include "stdio.h"
#include "conio.h"
#include "math.h"


float f(float x) /* Ham f(x) */
{
    float p;
    p = x*x -sin(2*x) - 1.5;
    return((float) p);
}



main()
{
    float a,b,e,dau,z,c,x;
    int t;
    printf("Nhap gia tri cua a,b: ");
    fflush(stdin);
    scanf("%f%f",&a,&b);
    if (f(a) > 0) dau = 1;
    if (f(a) < 0) dau = -1;
    printf("Nhap gia tri muon tinh cua e = "); scanf("%f",&e);
    t=0;
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

