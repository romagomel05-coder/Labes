import java.util.Scanner;
public class lab1{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        int[] nums = new int[3];
        int max=0, min = 0xFFFFFF;
        for(int i = 0; i < 3 ; i++){
            nums[i] = input.nextInt();
            if(nums[i]>max)max = nums[i];
            if(nums[i]<min)min = nums[i];
        }
        System.out.println();
        for(int i = min; i <= max; i++){
            System.out.print(i + " ");
        }
    }
}