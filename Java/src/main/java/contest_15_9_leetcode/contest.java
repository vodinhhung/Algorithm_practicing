package contest_15_9_leetcode;

public class contest {
    public static int maxNumberOfBalloons(String text) {
        int[] counting = new int[26];
        char[] ch = text.toCharArray();

        if(ch.length < 7){
            return 0;
        }

        for(int i=0; i<ch.length; i++){
            counting[ch[i]-97]++;
        }

        for(int i =0; i<26; i++){
            System.out.println(counting[i]);
        }

        int min = 1;
        int[] su = {counting[0], counting[1], counting[11], counting[13], counting[14]};
        int[] divide = {1,1,2,1,2};
        for(int i=0; i<5; i++){
            if(min > su[i]/divide[i]){
                min = su[i]/divide[i];
            }
        }

        return min;
    }

    public static void main(String[] args){
        String text = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text));
    }
}
