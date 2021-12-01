import java.util.Scanner;
import java.util.Random;

public class main {


    public static void main(String[] args) {

        Balance userBal = new Balance(100);
        int[][] slotMachine = new int[3][3];
        //8 items
        Scanner scnr = new Scanner(System.in);
        boolean check = true;
        int betAmount;

        while(check = true){

            System.out.println("Press P to Spin or Q to quit");
            //the on key press code here
            StdDraw.pause(500);
            if(StdDraw.isKeyPressed(80)){
                System.out.print("Input bet amount: ");
                betAmount = scnr.nextInt();
                userBal.setBetAmount(betAmount);

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        slotMachine[i][j] = randomNumBetween0And7();
                        System.out.print(slotMachine[i][j] + ", ");
                    }
                    System.out.println();
                }





            }
            if(StdDraw.isKeyPressed(81)){
                check = false;
                break;
            }







        }
        System.out.println("Your final balance was " + userBal.userBalToString());




    }


    public static int randomNumBetween0And7() {
        Random rand = new Random();
        return rand.nextInt((7) + 1);
    }











}
