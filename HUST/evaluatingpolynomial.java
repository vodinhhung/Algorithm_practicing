import java.util.Scanner;

public class evaluatingpolynomial{
    static Scanner sc = new Scanner(System.in);
    static int m = sc.nextInt(); //power of the polynomial
    static double[] array = new double[m+1]; //array has m elements from 0 to m
    static double[] khoangcachnghiemtruoc, khoangcachnghiemsau, nghiemdep;
    static int sokhoangcachnghiem, nghiem;
    static double[] pointofinterests;
    
    static class array{ //generating elements
    static int n = m+1;
    array(double [] a){// array input
        super();
        for(int i = 0; i<n;i++){
            System.out.println("Coefficient of variable X number " + i +" is: " );
            a[i] = sc.nextDouble();
        }
    }
    }
    
    
    static double abs(double a){
        if (a<0){
            return -a;
        }
        else{
            return a;
        }
    }
    
    static double recursiveexponential(int n, double x){ //powering a number with power n and base x
            if(n == 1){
                return x;
            }
            else if(n == 0){
                return 1;
            }
            else{
                if(n%2==0){
                    n/=2;
                return recursiveexponential(n, x)*recursiveexponential(n, x);
            }
                else{
                    n = (n-1)/2;
                    return recursiveexponential(n, x)*recursiveexponential(n, x)*x;
                }
        }
    }
    
    public static double approximation(double xa){ //caculating the approximation of a decimal number with a limit of 11 number after the dot. 
        double x = abs(xa);
        int a = (int) x;
        double b = x - a;
        int i = 0;
            while(i <=5 ){
                b*=10;
                ++i;
            }
            double c = (int) b;
            b = b - c;
            b *= 10;
            int d = (int) b;
            if(xa>=0){
            if (d>=5){
                return a + (c+1)/((recursiveexponential(i, 10)));
            }
            else{
                return a + c/((recursiveexponential(i, 10)));
            }
    }
            else{
                if (d>=5){
                return -(a + (c+1)/((recursiveexponential(i, 10))));
            }
            else{
                return -(a + c/((recursiveexponential(i, 10))));
            }
            }
        }
    
    private static double polynomial(double x){ // This is created for showing the sum of given polynomial
        double product = array[m];
        for (int i = m-1; i >= 0; i--) {
            product = product*x +array[i];
        }
        System.out.println("Sum of polynomial at point " + x + " is: ");
        return product;
    }
    
    private static double polynomialforcaculating(double x){ // This is created for helping other function running
        double product = array[m];
        for (int i = m-1; i >= 0; i--) {
            product = product*x +array[i];
        }
        return product;
    }
    
    private static double polynomialPractice(double x, double[] array){ // This is created for helping other function running
        double product = array[array.length-1];
        for (int i = array.length-1; i >= 0; i--) {
            product = product*x +array[i];
        }
        return product;
    }
    
    public static double derivation(double x, int y){
        if(y==0){
            return 0;
        }
        else if(y==1){
            return array[1];  
        }
        else
            y-=1;
        return derivation(x,y)+array[y+1]*(y+1)*recursiveexponential(y, x);
    }
    
    public static double derivationtwice(double x){
        double error = 0.000000000001;
        return (derivation(x+error,m)-derivation(x,m))/error;
    }
    
    public static double zerooff(double x){ //caculating the zero-of-f 
        while(abs(polynomialforcaculating(x)) > 0.00000001){
            double y = x;
            x = x - polynomialforcaculating(x)/derivation(x,m);
            if(derivation(x, m)*derivation(y, m)<=0&&derivationtwice(x)*derivationtwice(y)<= 0&&derivationtwice(x)*polynomialforcaculating(x)<=0){
                return Double.NEGATIVE_INFINITY;
            }
        }
        return x;
        }
    
    public static double phanly(double[] coefficience, double a, double b){
        double buocnhay = 0.01;
        int sokhoangcachnghiem = 0;
        int nghiem=0;
        double k = a;
        int i =0;
        int j=0;
        while(k<=b){
            if(polynomialforcaculating(k)*polynomialforcaculating(k+buocnhay)<0){
                ++sokhoangcachnghiem;
            }
            if(polynomialforcaculating(k)==0){
            ++nghiem;
        }
            k = approximation(k+0.01);
            //System.out.println(" "+k);
        }
        if(sokhoangcachnghiem == 0&&nghiem==0){
            return 0;
        }
        else {
            evaluatingpolynomial.nghiem = nghiem;
            evaluatingpolynomial.sokhoangcachnghiem = sokhoangcachnghiem;
            nghiemdep = new double [nghiem];
            khoangcachnghiemsau = new double[sokhoangcachnghiem];
            khoangcachnghiemtruoc = new double[sokhoangcachnghiem];
            while(k>=a){
                if(polynomialforcaculating(k)*polynomialforcaculating(k-buocnhay)<0){
                    khoangcachnghiemsau[i] = k - buocnhay;
                    khoangcachnghiemtruoc[i] = k;
                    //System.out.println("          " + khoangcachnghiemtruoc[i] + "       "+ khoangcachnghiemsau[i]);
                    ++i;
                }
                if(polynomialforcaculating(k)==0){
                    //System.out.println("                " + k);
                    nghiemdep[j] = k;
                    ++j;
                }
                k = approximation(k-0.01);
            }
            return 1;
        }
    }
    
    public static double pointofinterest(){
        if(phanly(array, -1000, 1000)==0){
            return 0;
        }
        else{
            pointofinterests = new double[2*sokhoangcachnghiem];
            int j = 0;
            int k = sokhoangcachnghiem;
            for(int i = 0; i< sokhoangcachnghiem;i++){
                pointofinterests[i] = khoangcachnghiemtruoc[i];
            }
            while(j <sokhoangcachnghiem && k<sokhoangcachnghiem*2){
            pointofinterests[k] = khoangcachnghiemsau[j];
            ++j;
            ++k;
        }
        }
        return 1;
    }
    
    public static double equation(int power){
        for(int i = 0; i<power; i++){
            System.out.print(array[i]+"*x^"+i+" + ");
        }
        System.out.print(array[power]+"*x^"+power);
        System.out.println(" = 0");
        return 1;
    }
        
        public static double equationDisplay(int power, double[] array){
        for(int i = 0; i<power; i++){
            System.out.print(array[i]+"*x^"+i+" + ");
        }
        System.out.print(array[power]+"*x^"+power);
        System.out.println(" = 0");
        return 1;
    }
   
    
    public static void main(String[] args) {
        System.out.println(" is the power of the polynomial.");
        int fakePower = m;
        int count=-1;
        array generating = new array(array);
        equation(fakePower);
        phanly(array, -1000, 1000);
        double[] arrayNghiem = new double[2*sokhoangcachnghiem];
        if(pointofinterest()==0){
            System.out.println("Phuong trinh vo nghiem.");
        }
        else{
        for(int i = 0; i<nghiem;i++){
            System.out.println("x = "+nghiemdep[i]);
        }
        for(int i = 0; i<2*sokhoangcachnghiem; i++){ // newton
            double a = zerooff(pointofinterests[i]);
            if(a!=Double.NEGATIVE_INFINITY){
                ++count;
                arrayNghiem[count] = a;
            }
        }
        for(int i = 0; i<=count;i++){
            int check = 1;
            for(int j = i-1;j>=0;j--){
                if(approximation(arrayNghiem[j])==approximation(arrayNghiem[i])){
                    check = 0;
                }
            }
            if(check==1){
            System.out.println("x = "+approximation(arrayNghiem[i])+". Error = " + abs(approximation(arrayNghiem[i])-arrayNghiem[i]));
            }
        }
        
    }
    }
}
    