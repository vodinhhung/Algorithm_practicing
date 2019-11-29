package group_anagram;

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.print(solution.groupAnagrams(strs));
    }
}
