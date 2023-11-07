package adventure;

public class Item {
    private String name;
    private int worth;

    public String getName() {
        return this.name;
    }
    public int getWorth() {
        return this.worth;
    }
    public void setName(String newName) {
       this.name = newName;
    }
    public void setWorth(int newWorth) {
        this.worth = newWorth;
    }

}
