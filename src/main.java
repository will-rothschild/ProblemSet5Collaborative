import java.util.Scanner;
import java.util.Random;

public class main {


    public static void main(String[] args) {

        Balance userBal = new Balance(100);
        int[][] slotMachine = new int[3][3];
        Scanner scnr = new Scanner(System.in);
        boolean check = true;
        int betAmount;

        while(check = true){
            System.out.print("Input bet amount");
            betAmount = scnr.nextInt();
            userBal.setBetAmount(betAmount);
            System.out.print("Press any key to Spin");
            //the on key press code here








        }




        System.out.println("1");
    }














}
