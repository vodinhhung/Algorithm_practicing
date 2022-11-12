package shuffle_an_array;

public class Main {
    public static void main(String[] args){
        int[] num = {1,2,3};
        Solution solution = new Solution(num);

        int[] shuffle = solution.shuffle();
        printInt(shuffle);

        int[] reset = solution.reset();
        printInt(reset);

        shuffle = solution.shuffle();
        printInt(shuffle);
    }

    public static void printInt(int[] num){
        for(int i: num)
            System.out.print(i);
        System.out.print("\n");
    }
}
