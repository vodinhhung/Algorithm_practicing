package rotated_sort_array;

public class Solution {
    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return search(nums, target, 0, nums.length-1);
    }

    public static int search(int[] nums, int target, int start, int end){
        if(start <= end) {
            int middle = (start + end) / 2;
            if(nums[middle] == target) return middle;

            if(nums[middle] >= nums[start]){
                if(target < nums[middle] && target >= nums[start])
                    return search(nums, target, start, middle-1);
                else
                    return search(nums, target, middle+1, end);
            }
            if(nums[middle] <= nums[end]){
                if(target <= nums[end] && target > nums[middle])
                    return search(nums, target, middle+1, end);
                else
                    return search(nums, target, start, middle-1);
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,1};
        int target = 1;

        int result = search(nums, target);

        System.out.println(result);
    }
}
