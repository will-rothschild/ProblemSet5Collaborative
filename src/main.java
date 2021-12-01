import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;


public class main {


    public static void main(String[] args) {



        Balance userBal = new Balance(100);
        RecordTracker userRecord = new RecordTracker();
        int[][] slotMachine = new int[3][3];

        Scanner scnr = new Scanner(System.in);
        boolean check = true;
        int betAmount;



        while(check = true){

            StdDraw.setCanvasSize(500, 500);
            StdDraw.setScale(-5, 125);
            drawBoard(slotMachine);
            StdDraw.picture(60, 106, "marioslot.png", 120,30);

            System.out.println("Press P to Spin or Q to quit");
            //the on key press code here
            StdDraw.pause(1000);
            if(StdDraw.isKeyPressed(80)){
                System.out.print("Input bet amount: ");
                betAmount = scnr.nextInt();
                userBal.setBetAmount(betAmount);

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        slotMachine[i][j] = randomNumBetween0And5();
                        System.out.print(slotMachine[i][j] + ", ");
                    }
                    System.out.println();
                }

            if(betWin(slotMachine) == true){
                userBal.winBet();
                userRecord.incWins();
            } else {
                userBal.loseBet();
                userRecord.incLosses();
            }



            }
            StdDraw.pause(1000);
            if(StdDraw.isKeyPressed(81)){
                check = false;
                break;
            }







        }
        System.out.println("Your final balance was " + userBal.userBalToString());




    }



    public static int randomNumBetween0And5() {
        Random rand = new Random();
        return rand.nextInt((5) + 1);
    }

public static boolean betWin(int[][] arr){

    for(int i = 0; i < 3; i++){
        if(arr[i][0] == arr[i][1] && arr[i][0] == arr[i][2]){
            return true;
        }
        }
    for(int i = 0; i < 3; i++){
        if(arr[0][i] == arr[1][i] && arr[0][i] == arr[2][i]){
            return true;
        }
    }
    if(arr[0][0]==arr[1][1] && arr[0][0] == arr[2][2]){
        return true;
    }
    if(arr[0][2]==arr[1][1] && arr[0][2] == arr[2][0]){
        return true;
    }
    return false;
}
    public static void drawBoard(int[][] board) {

        final int Empty = 0;

        //draw board
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(60,60,90);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(15, 0, 105, 0);
        StdDraw.line(15, 30, 105, 30);
        StdDraw.line(15, 60, 105, 60);
        StdDraw.line(15, 90, 105, 90);
        StdDraw.line(15, 0, 15, 90);
        StdDraw.line(45, 0, 45, 90);
        StdDraw.line(75, 0, 75, 90);
        StdDraw.line(105, 0, 105, 90);
    }
    }







