#include "stdio.h"
#include "conio.h"
main()
{
    int x,a,b,c;
    printf("cac so thoa man dieu kien bai toan la: ");
    for(x=150;x<=10000;x++)
    {
        a=x/100;
        b=(x/10)%10;
        c=x%10;
        if (x==a*a*a+b*b*b+c*c*c) printf("%d\n",x);
    }
}
