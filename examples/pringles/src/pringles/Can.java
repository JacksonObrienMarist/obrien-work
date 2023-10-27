package pringles;

public class Can {
    private Chip[] chips;
    private int numChips;

    public Can(int size) {
        this.chips = new Chip[size];
        this.numChips = 0;
    }

    public void addChips(Chip chip) {
        if (numChips == chips.length) {
            System.out.println("Can full!");
            return;
        }
    }

    public void removeChips() {
        if (hasMoreChips()) {
            numChips--;
            chips[numChips] = null;
        }
     }

     public Chip lookAtTopChip() {
        if (hasMoreChips()) {
            return chips[numChips - 1];
        }
        else {
            return null;
        }
     }

     public boolean hasMoreChips() {
         return numChips > 0;
     }


}
