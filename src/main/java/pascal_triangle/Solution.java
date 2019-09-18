package pascal_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row0 = new ArrayList<>();
        row0.add(1);
        triangle.add(row0);
        if(numRows == 1) return triangle;

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        triangle.add(row1);
        if(numRows == 2) return triangle;

        for(int i=2; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> pre = triangle.get(i-1);
            int size = pre.size();

            row.add(1);
            for(int j=0; j<size-1; j++){
                row.add(pre.get(j) + pre.get(j+1));
            }
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args){
        System.out.println(generate(0));
    }
}
