//compile command: gcc -o -lm a.out solve.c
//global variables is allowed to reduce the lengths of function calls
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct kq
{
	int count;
	float r[100];
}kq;
typedef struct fourier
{
	float x,y;
}fourier; // diem fourier
kq results,range;
//global variables
float heso[100];
float current[100];
float currentForLapDon[100];
int bac,count;

void input()
{
	int i;
	printf("nhap bac phuong trinh: ");
	scanf("%d",&bac);
	for (i = 0; i <= bac; i++){
		printf("nhap he so bac %d: 	", bac - i);
		scanf("%f",&heso[i]);
	}
}
/*thuat toan de quy: tu pt bac n, dao ham ra pt bac n-1, bai toan quy ve giai pt bac n-1, moi 1 nghiem tuong ung voi 1 cuc tri 
cua ham ban dau, co n-1 nghiem -> n khoang li nghiem cua pt ban dau, tiep tuc nhu vay toi n -2 .... 1
tu pt bac 1 -> 2 khoang li nghiem -> 2 nghiem -> blabla
*/
//helping stuff
float calc(float x)
{
	int i;
	float result = 0;
	for (i = 0; i <= bac; i++) result += current[i]*pow(x,bac - i);
	return result;
}
float calcf1(float x)
{
	int i;
	float result = 0;
	for (i = 0; i < bac; i++) result += current[i]*i*pow(x,bac - i - 1);
	return result;
}
float calcLapDon(float x)
{
	int i;
	float result = 0;
	for (i = 0; i <= bac; i++) result += currentForLapDon[i]*pow(x,bac - i);
	return result;
}
int giaithua(int k)
{
	if (k <= 1) return 1; 
	return giaithua(k-1)*k;
}
float max()
{
	//fabsf used to get absolute value of float, fabs for double, abs for int
	int i,max = 0;
	for (i = 0; i <= bac; i++) if (max < fabsf(heso[i])) max = fabsf(heso[i]);
	return max;
}
void makeCurrent(int i)
{
	int j;
	for (j = 0; j <= bac; j++) current[j] = 0;
	for (j = i; j <= bac; j++){
		current[j] = heso[j-i]*(giaithua(bac-j + i))/(giaithua(bac -j));
	}
}
//working stuff
float chiadoi(float a, float b, float epsilon)
{
	float temp = b - a;
	float left = a;
	float right = b;
	float mid = (a + b)/2;
	while (temp >= epsilon){
		if (calc(mid) == 0) {
			return mid;
		} else 
		if ((calc(left)*calc(mid))<0) right = mid; 
			else left = mid;
		mid = (left + right)/2;
		temp = right - left;
	}
	return mid;
}
float lapdon(float a, float b, float epsilon)
{
	int j;
	for (j = 0; j<= bac; j++)
		if (j != bac - 1) currentForLapDon[j] = -current[j]/current[bac - 1];
	currentForLapDon[bac - 1] = 0;
	float x = (a + b)/2;
	float y = calcLapDon(x);
	//for (j = 0; j<= bac; j++) printf("%.5f ", currentForLapDon[j]);
 	//	printf("\n");
	while (fabsf(x - y) > epsilon/10) {
		x = y;
		y = calcLapDon(x);
	}
	return x;
}
float tieptuyen(float a, float b, float epsilon)
{
	//tim diem fourier
	int i;
	float ffa = 0, ffb = 0;
	float x1,x2;
	fourier m;
	for (i=0;i<=bac-2;i++)
	{
			ffa +=current[i]*i*(i-1)*pow(a,bac - i - 2);
			ffb +=current[i]*i*(i-1)*pow(b,bac - i - 2);	
	}
	if (ffa*calc(a) > 0){
		m.x = a;
		m.y = calc(a);
		
	}
	else 
	{
		m.x = b;
		m.y = calc(b);
	}
	// tao vong lap
	x1 = m.x;
	x2 = x1 - calc(x1)/calcf1(x1);
	while (fabsf(x1 - x2) > epsilon/2){
		x1 = x2;
		x2 = x1 - calc(x1)/calcf1(x1);
	}
	return x1;
}
float daycung(float a, float b, float epsilon)
{
	//tim diem fourier
	int i;
	float ffa = 0, ffb = 0;
	float x1,x2;
	fourier m;
	for (i=0;i<=bac-2;i++)
	{
			ffa +=current[i]*i*(i-1)*pow(a,bac - i - 2);
			ffb +=current[i]*i*(i-1)*pow(b,bac - i - 2);	
	}
	if (ffa*calc(a) > 0){
		m.x = a;
		m.y = calc(a);	
	}
	else 
	{
		m.x = b;
		m.y = calc(b);
	}
	// tao vong lap
	x1 = m.x;
	x2 = x1 - (calc(x1)*(x1 - m.x))/(calc(x1) - m.y);
	while (fabsf(x1 - x2) > epsilon/2){
		x1 = x2;
		x2 = x1 - (calc(x1)*(x1 - m.x))/(calc(x1) - m.y);
	}
	return x1;
}
int process(int i,float absolute,float epsilon)
{
 	int j;
 	//printf("%d\n\n",i);
 	//chuyen nghiem cua dao ham thanh khoang li nghiem cua pt goc
 	if (i <= bac ){
 		makeCurrent(bac - i);
 		//for (j = 0; j<= bac; j++) printf("%.5f ", current[j]);
 		//printf("\n");
 		// reset cho qua trinh tim nghiem tiep theo
 		count = 0;
 		for (j = 0; j< bac; j++) results.r[j] = 0; 
 		//for (j = 0; j<	range.count; j++) printf("%.5f ", range.r[j]);
 		//printf("\n");
 	
 		// giai pt 
 		for (j = 0; j< range.count-1; j++){
 			{
 				if (calc(range.r[j]) * calc(range.r[j+1]) > 0) {
 					printf("\n");
 				} else
 				if (fabsf(calc(range.r[j])) <= epsilon) {
 					results.r[count] = range.r[j];
 					printf("bien duoi \n\n");
 					count++;
 					j++;
 				}
 				else if (fabsf(calc(range.r[j+1])) <= epsilon) {
 					results.r[count] = range.r[j + 1];
 					printf("bien tren \n\n");
 					count++;
 					j++;
 				}
 				else {
 					// 4 ham cho 4 phuong phap dc thay vao day, 100% co nghiem			
 					//results.r[count] = chiadoi(range.r[j],range.r[j+1],epsilon);
 					//results.r[count] = lapdon(range.r[j],range.r[j+1], epsilon);
 					results.r[count] = daycung(range.r[j],range.r[j+1], epsilon);
 					//printf("li nghiem\n\n");
 					count++;
 				}
 			}
 		}
 		// chuyen nghiem
 		for (j = 0; j< count; j++) 
 			{
 				range.r[j+1] = results.r[j];
 			}
 		range.r[j+1] = absolute;
 		range.count = count + 2;
 		results.count = count;
 		//printf("%d %d %d\n\n",range.count,results.count,count);
 		//for (j = 0; j< results.count; j++) printf("%.2f ", results.r[j]);
 		//printf("\n");
 		process(i+1,absolute,epsilon);
 	} else
 	{
 		for ( j = 0; j < results.count; j++)
 		{
 			/* code */
 			printf("ngiem %.5f   ",results.r[j]);
 		}
 	}
 }
int main()
{
	/* code */

	//initialization
	int i;
	float epsilon;
	input();
	printf("nhap sai so cho phep cua nghiem: ");
	scanf("%f",&epsilon);
	results.count = 0;
	range.count = 0;
	float absolute = 1 + max(bac)/fabsf(heso[0]); // khoang chua nghiem lon nhat
	for (i = 0; i< bac ; i++){
		range.r[i] = 0;
		current[i] = 0;
		results.r[i] = 0;
		currentForLapDon[i] = 0;
	}
	range.r[0] = -absolute;
	range.r[1] = absolute;
	range.count = 2;
	//lets do it
	process(1,absolute,epsilon);
	return 0;
}


