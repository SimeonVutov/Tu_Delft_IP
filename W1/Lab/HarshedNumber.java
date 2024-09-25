import java.util.Scanner;
/**
 * HarshedNumber
 */
public class HarshedNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(func(sc.nextInt()));
    } 
    public static int func(int num) {
        int sumOfDigits = 0;
        
        if(num <= 0) return 0;

        while(true){
            sumOfDigits = getSum(num);
            if(sumOfDigits == 1) return 0;
            else if(num % sumOfDigits != 0) return 0;
            
            num = num / sumOfDigits;
        }
    }

    public static int getSum(int num) {
       
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }   
    
}
