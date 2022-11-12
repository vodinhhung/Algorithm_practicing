#include "stdio.h"
#include "conio.h"
#include "stdlib.h"

int m,n,i,j;
int A[100];

writeresult()
{
    j+=1;
    printf("\n %d ",j);
    for (i=1;i<=n;i++)
        printf("\t %d \t",A[i]);
    return 0;
}
cachchia(m,n)
{
    A[n]+=1;
    if (m>1) cachchia(m-1,n);
    else writeresult();
    A[n]-=1;
    if (n>1) cachchia(m,n-1);
}
main()
{
    printf("Nhap so keo m: "); scanf("%d",&m);
    printf("Nhap so nguoi n: "); scanf("%d",&n);
    for (i=1;i<=n;i++)
        A[i] = 0;
    j=0;
    cachchia(m,n);
}
