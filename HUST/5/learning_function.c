#include "stdio.h"
#include "tinh_n!!.h"
#include "math.h"
main()
{
    float tong;
    int i;
    tong=0;
    printf("Nhap so n: "); scanf("%d",&n);
    for (i=1;i<=n;i++)
    {
        tong = tong + pow(giaithuachan(i),pow(-1,i));
    }
    printf("Tong can tim la %f",tong);
    getch();
}
