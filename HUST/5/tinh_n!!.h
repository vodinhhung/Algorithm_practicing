#include "stdio.h"
int n;
giaithuachan(n)
{
    int gt,i;
    gt = 1;
    if (n%2==0)
        for (i=2;i<=n;i+=2) gt=gt*i;
    else
        for (i=3;i<=n;i+=2) gt=gt*i;
    return(gt);
}
