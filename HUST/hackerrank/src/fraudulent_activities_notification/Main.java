package fraudulent_activities_notification;

public class Main {

	static int getTwiceMedian(int[] count, int d) {
        int[] countRep = new int[count.length];
        countRep[0] = count[0];

        for(int i=1; i<count.length; i++) {
            countRep[i] = countRep[i-1] + count[i];
        }

        int a = 0;
        int b = 0;

        if(d%2 == 0) {
            a = d/2;
            b = d/2 + 1;

            for (int i=0; i< count.length; i++) {
                if(a <= countRep[i]){
                    a = i;
                    break;
                }
            }

            for (int i=0; i< count.length; i++) {
                if(b <= countRep[i]){
                    b = i;
                    break;
                }
            }

            return a+b;
        } else {
            a = d/2 + 1;
            for (int i=0; i< count.length; i++) {
                if(a <= countRep[i]){
                    a = i;
                    break;
                }
            }

            return 2*a;
        }
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int numberOfNoti = 0;
        int[] count = new int[201];

        for(int i=0; i<d; i++) {
            count[expenditure[i]] ++;
        }

        for(int i=d; i<expenditure.length; i++) {
            if(expenditure[i] >= getTwiceMedian(count, d)){
                numberOfNoti++;
            }
            count[expenditure[i-d]]--;
            count[expenditure[i]]++;
        }

        return numberOfNoti;
    }


    public static void main(String[] args) {
        int[] expenditure = {10,20,30,40,50};
        System.out.println(activityNotifications(expenditure, 3));
    }
}
