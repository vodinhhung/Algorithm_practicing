#include "stdio.h"
#include "conio.h"
main()
{
    int N,i,b,c;
    int a[100];
    printf("Nhap so N: "); scanf("%d",&N);
    for (i=1;i<=N;i++)
    {
        printf("Nhap so a[%d]: ",i);
        scanf("\n%d",&a[i]);
    }
    do
    {
        c=0;
        for (i=1;i<N;i++)
            if (a[i]>a[i+1])
            {
                c=c+1;
                b=a[i]; a[i]=a[i+1]; a[i+1]=b;
            }
    } while (c!=0);
    printf("Day sau khi sap xep la: ");
    for (i=1;i<=N;i++) printf("%d\n",a[i]);
}
