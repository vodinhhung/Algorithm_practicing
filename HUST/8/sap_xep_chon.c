#include "stdio.h"
#include "stdlib.h"
gtnn(a,A)
int a;
float A[100];
{
    float gt;
    int i;
    gt = A[1];
    for (i=1;i<=a;i++)
    {
        if (gt>=A[i]) gt=A[i];
    }
    return (gt);
}
/* Tim gia tri nho nhat 1 mang bang thuat chon */
main()
{
    int a,i,k;
    float A[100], B[100],h,t;
    printf("Nhap so phan tu a cua mang: "); scanf("%d",&a);
    printf("Mang truoc khi sap xep la: \n");
    for (i=1;i<=a;i++)
    {
        A[i]=rand();
        printf("%f\t",A[i]);
    }
    printf("\n Day sau khi sap xep la: \n");
    k=1;
    do
    {
        t = gtnn(a,A);
        for (i=1;i<=a;i++)
            if (A[i]==t) h=i;
        B[k]=t;
        for (i=h;i<=(a-1);i++)
            A[i] = A[i+1];
        printf("%f\t",B[k]);
        a=a-1;
        k=k+1;
    } while (a>=1);
    for (k=1;k<=a;k++)
        printf("%f\t",B[k]);
}
