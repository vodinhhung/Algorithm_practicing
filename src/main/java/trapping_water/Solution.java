package trapping_water;

public class Solution {
    public static int total(int[] a, int i, int j){
        int min = -1;
        if(a[i] > a[j]){
            min = a[j];
        }else{
            min = a[i];
        }

        int total = (j-i-1)*min;
        for(int k=i+1; k<j; k++){
            total -= a[k];
        }
        return total;
    }

    public static int trap(int[] height) {
        int i=0;
        int j=1;
        int totalWater = 0;

        while(i<height.length-1 && j<height.length){
            if(height[j] >= height[i]){
                totalWater += total(height, i, j);
                i=j;
                j++;
            } else {
                j++;
            }
        }

        return totalWater;
    }

    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int total = trap(height);

        System.out.println(total);
    }
}
