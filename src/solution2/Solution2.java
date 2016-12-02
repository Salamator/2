package solution2;

import java.util.List;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {        
        
        Scanner read = new Scanner(System.in);
        int value = read.nextInt();
        Calculator calc = new Calculator();
        List<Integer> result = calc.calculate(value);
        
        for(int res : result)
            System.out.println(res);
    }
    
}
