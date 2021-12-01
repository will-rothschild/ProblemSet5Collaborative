public class Balance {

    private int balance;
    private int betAmount;

    public Balance(int startingBal){

        this.balance = startingBal;

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int modifier){
        balance -= modifier;
    }

    public void setBetAmount(int bet){
        betAmount = bet;
    }

    public void bet(int betVal){
        setBetAmount(betVal);
        setBalance(betVal);
    }

    public void winBet(){
        setBalance(-1*betAmount);
        setBetAmount(0);
    }

    public void loseBet(){
        setBalance(betAmount);
        setBetAmount(0);
    }

    public String userBalToString(){
        String strBal = "" + balance;
        return strBal;
    }



}
