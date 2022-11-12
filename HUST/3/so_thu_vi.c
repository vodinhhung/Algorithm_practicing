#include"stdio.h"
#include"conio.h"
main()
{
    int x,a,k;
    for(x=0;x<=3000;x++)
    {
        a=0;
        for(k=1;k<x;k++) if (x%k==0) a=a+k;
        if (x==a) printf("%d la so thu vi\n",x);
    }
}
