package min_stack;

public class Main {

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(4);
        minStack.push(2);

        System.out.println(minStack.min);
    }
}
