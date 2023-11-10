package adventure;

public class Item {
    private String name;
    private int worth;
    private String category;

    public Item(String name, int worth, String category) {
        this.name = name;
        this.worth = worth;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        if (category.equals("combat") || category.equals("equipment") || category.equals("treasures")){
            this.category = category;
        }
    }

    public String getName() {
        return this.name;
    }
    public int getWorth() {
        return this.worth;
    }
    public void setName(String newName) {
        if (newName.length() > 0) {
            this.name = newName;
        }

    }
    public void setWorth(int newWorth) {
        if (newWorth > 0 && newWorth < 1000000) {
            this.worth = newWorth;
        } else {

        }

    }

}
