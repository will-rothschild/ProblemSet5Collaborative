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



        while(check = true && userBal.getBalance() > 0){

            StdDraw.setCanvasSize(500, 500);
            StdDraw.setScale(-20, 140);
            drawBoard(slotMachine);
            StdDraw.picture(60, 126, "marioslot.png", 150,30);
            StdDraw.picture(-4, 30, "tube.png", 25,110);
            StdDraw.picture(123, 30, "tube.png", 25,110);
            StdDraw.picture(60, -15, "grass.png", 170,15);

            upperCard(userRecord.getWins(), userRecord.getLosses(), userBal.getBalance());
            StdDraw.text(60, 110, "Hold P to Spin or Q to Quit");

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
            slot1A(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot2A(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot3A(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot1B(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot2B(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot3B(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot1C(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot2C(slotMachine);
                drawBoard(slotMachine);
                StdDraw.pause(800);
            slot3C(slotMachine);
                drawBoard(slotMachine);

            StdDraw.pause(5000);



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

        StdDraw.setCanvasSize(500, 500);
        StdDraw.setScale(-20, 140);
        drawBoard(slotMachine);
        StdDraw.picture(60, 126, "marioslot.png", 150,30);
        StdDraw.picture(-4, 30, "tube.png", 25,110);
        StdDraw.picture(123, 30, "tube.png", 25,110);
        StdDraw.picture(60, -15, "grass.png", 170,15);

        upperCard(userRecord.getWins(), userRecord.getLosses(), userBal.getBalance());


        if(userBal.getBalance()> 0) {
            StdDraw.text(60, 75,"Your final balance was " + userBal.userBalToString());
        } else {
            StdDraw.text(60, 75, "Sorry, You're Out of Money");
        }


//        StdDraw.setPenColor(StdDraw.WHITE);
//        StdDraw.filledSquare(60,60,90);
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



    public static void upperCard(int wins, int losses, int balance) {
        StdDraw.text(60, 100, "Balance: " + balance + "   Wins: " + wins + "   Losses: " + losses);
    }



    public static void slot1A(int[][]slotMachine) {
        switch (slotMachine[0][0]) {
            case 1:  StdDraw.picture(30, 15, "star.png", 30,30);
                break;
            case 2: StdDraw.picture(30, 15, "coin.png", 30,30);
                break;
            case 3:  StdDraw.picture(30, 15, "mushroom.png", 30,30);
                break;
            case 4:  StdDraw.picture(30, 15, "pow.png", 30,30);
                break;
            case 5:  StdDraw.picture(30, 15, "flag.png", 30,30);
                break;
            default: StdDraw.picture(30, 15, "flower.png", 30,30);
                break;
        }

    }
    public static void slot2A(int[][]slotMachine) {
        switch (slotMachine[1][0]) {
            case 1:
                StdDraw.picture(60, 15, "star.png", 30, 30);
                break;
            case 2:
                StdDraw.picture(60, 15, "coin.png", 30, 30);
                break;
            case 3:
                StdDraw.picture(60, 15, "mushroom.png", 30, 30);
                break;
            case 4:
                StdDraw.picture(60, 15, "pow.png", 30, 30);
                break;
            case 5:
                StdDraw.picture(60, 15, "flag.png", 30, 30);
                break;
            default:
                StdDraw.picture(60, 15, "flower.png", 30, 30);
                break;
        }
    }
    public static void slot3A(int[][]slotMachine) {
            switch (slotMachine[2][0]) {
                case 1:  StdDraw.picture(90, 15, "star.png", 30,30);
                    break;
                case 2: StdDraw.picture(90, 15, "coin.png", 30,30);
                    break;
                case 3:  StdDraw.picture(90, 15, "mushroom.png", 30,30);
                    break;
                case 4:  StdDraw.picture(90, 15, "pow.png", 30,30);
                    break;
                case 5:  StdDraw.picture(90, 15, "flag.png", 30,30);
                    break;
                default: StdDraw.picture(90, 15, "flower.png", 30,30);
                    break;
            }
        }
    public static void slot1B(int[][]slotMachine) {
                switch (slotMachine[0][1]) {
                    case 1:  StdDraw.picture(30, 45, "star.png", 30,30);
                        break;
                    case 2: StdDraw.picture(30, 45, "coin.png", 30,30);
                        break;
                    case 3:  StdDraw.picture(30, 45, "mushroom.png", 30,30);
                        break;
                    case 4:  StdDraw.picture(30, 45, "pow.png", 30,30);
                        break;
                    case 5:  StdDraw.picture(30, 45, "flag.png", 30,30);
                        break;
                    default: StdDraw.picture(30, 45, "flower.png", 30,30);
                        break;
                }
        }
    public static void slot2B(int[][]slotMachine) {
                    switch (slotMachine[1][1]) {
                        case 1:  StdDraw.picture(60, 45, "star.png", 30,30);
                            break;
                        case 2: StdDraw.picture(60, 45, "coin.png", 30,30);
                            break;
                        case 3:  StdDraw.picture(60, 45, "mushroom.png", 30,30);
                            break;
                        case 4:  StdDraw.picture(60, 45, "pow.png", 30,30);
                            break;
                        case 5:  StdDraw.picture(60, 45, "flag.png", 30,30);
                            break;
                        default: StdDraw.picture(60, 45, "flower.png", 30,30);
                            break;
                    }
        }
    public static void slot3B(int[][]slotMachine) {
             switch (slotMachine[2][1]) {
                 case 1:  StdDraw.picture(90, 45, "star.png", 30,30);
                                break;
                 case 2: StdDraw.picture(90, 45, "coin.png", 30,30);
                                break;
                 case 3:  StdDraw.picture(90, 45, "mushroom.png", 30,30);
                                break;
                 case 4:  StdDraw.picture(90, 45, "pow.png", 30,30);
                                break;
                 case 5:  StdDraw.picture(90, 45, "flag.png", 30,30);
                                break;
                 default: StdDraw.picture(90, 45, "flower.png", 30,30);
                                break;
                        }
        }
    public static void slot1C(int[][]slotMachine) {
        switch (slotMachine[0][2]) {
            case 1:
                StdDraw.picture(30, 75, "star.png", 30, 30);
                break;
            case 2:
                StdDraw.picture(30, 75, "coin.png", 30, 30);
                break;
            case 3:
                StdDraw.picture(30, 75, "mushroom.png", 30, 30);
                break;
            case 4:
                StdDraw.picture(30, 75, "pow.png", 30, 30);
                break;
            case 5:
                StdDraw.picture(30, 75, "flag.png", 30, 30);
                break;
            default:
                StdDraw.picture(30, 75, "flower.png", 30, 30);
                break;
        }
    }
    public static void slot2C(int[][]slotMachine) {
        switch (slotMachine[1][2]) {
            case 1:
                StdDraw.picture(60, 75, "star.png", 30, 30);
                break;
            case 2:
                StdDraw.picture(60, 75, "coin.png", 30, 30);
                break;
            case 3:
                StdDraw.picture(60, 75, "mushroom.png", 30, 30);
                break;
            case 4:
                StdDraw.picture(60, 75, "pow.png", 30, 30);
                break;
            case 5:
                StdDraw.picture(60, 75, "flag.png", 30, 30);
                break;
            default:
                StdDraw.picture(60, 75, "flower.png", 30, 30);
                break;
        }
    }
    public static void slot3C(int[][]slotMachine) {
        switch (slotMachine[2][2]) {
            case 1:
                StdDraw.picture(90, 75, "star.png", 30, 30);
                break;
            case 2:
                StdDraw.picture(90, 75, "coin.png", 30, 30);
                break;
            case 3:
                StdDraw.picture(90, 75, "mushroom.png", 30, 30);
                break;
            case 4:
                StdDraw.picture(90, 75, "pow.png", 30, 30);
                break;
            case 5:
                StdDraw.picture(90, 75, "flag.png", 30, 30);
                break;
            default:
                StdDraw.picture(90, 75, "flower.png", 30, 30);
                break;
        }
    }
}












