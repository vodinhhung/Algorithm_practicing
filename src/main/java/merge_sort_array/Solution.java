package merge_sort_array;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length-1;
        int i=m-1;
        int j=n-1;

        while(i>=0 && j>=0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        if(j>=0){
            while(j>=0){
                nums1[j] = nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args){
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1, 0, nums2, 1);

        for(int i=0; i<nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
}
