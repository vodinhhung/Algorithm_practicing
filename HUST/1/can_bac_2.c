#include "stdio.h"
#include "conio.h"

int main ()
{
   float a, b;
   a = 345;
   b = -345.453;

   printf("Tri tuyet doi: |%d| = %lf\n", a, fabs(a));
   printf("Tri tuyet doi: |%d| = %lf\n", b, fabs(b));

   return(0);
}
