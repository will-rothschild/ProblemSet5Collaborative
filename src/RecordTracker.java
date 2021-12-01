public class RecordTracker {

    private int losses;
    private int wins;
    private int total;

    public RecordTracker(){
        this.losses = 0;
        this.wins = 0;
        this.total = 0;
    }

    public int getLosses(){
        return losses;
    }

    public int getWins() {
        return wins;
    }

    public int getTotal() {
        return total;
    }

    public void incWins(){
        wins++;
        total++;
    }

    public void incLosses(){
        losses++;
        total++;
    }






}
