#include "stdio.h"
#include "stdlib.h"
/* sap xep day bat ki */
sapxep(n,A)
float A[];
int n;
{
    int i,c;
    float b;
    do
    {
        c=0; b=0;
        for (i=1;i<n;i++)
            if (A[i]>A[i+1])
            {
                c=c+1;
                b=A[i]; A[i]=A[i+1]; A[i+1]=b;
            }
    } while (c!=0);
}
/* khai bao bang va sap xep */
khaibao(a,A)
float A[];
int a;
{
    int i;
    printf("\n Day la: \n");
    for (i=1;i<=a;i++)
    {
        A[i]=rand();
        printf("%.2f\t",A[i]);
    }
    sapxep(a,A);
    printf("\n Day sau khi sap xep theo thu tu tang dan la: \n");
    for (i=1;i<=a;i++) printf("%.2f\t",A[i]);
}
main()
{
    int a,b,c,i;
    float A[100], B[100], C[100];
    printf("\n Nhap so phan tu a cua day A: "); scanf("%d",&a);
    khaibao(a,A);
    printf("\n Nhap so phan tu b cua day B: "); scanf("%d",&b);
    khaibao(b,B);
    c=a+b;
    for (i=1;i<=a;i++) C[i]=A[i];
    for (i=a+1;i<=c;i++) C[i]=B[i-a];
    sapxep(c,C);
    printf("\n 2 day sau khi hop lai và xep theo thu tu tang dan la8: \n");
    for (i=1;i<=c;i++) printf("%f\n",C[i]);
}
