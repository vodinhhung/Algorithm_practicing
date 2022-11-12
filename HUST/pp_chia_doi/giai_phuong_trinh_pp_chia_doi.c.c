#include "stdio.h"
#include "conio.h"
#include "math.h"

float f(float x)
{
    float p;
    p = x*x*x*x + 2*x*x*x - x - 1;
    return((float)p);
}
main()
{
    float a,b,e,dau,z,c,x;
    a=0; b=1;
    if (f(a) > 0) dau = 1;
    if (f(a) < 0) dau = -1;
    printf("Nhap gia tri muon tinh cua e = "); scanf("%f",&e);
    for(;;)
    {
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
    printf(" Gia tri cua nghiem phuong trinh la %f ",x);
}
