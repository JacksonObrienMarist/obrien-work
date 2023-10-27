package objects;
public class Button {
    private String color;

    public Button(String color) {
        this.color = color;
    }
    public void Press() {
        System.out.println(color + "button clicked");
    }

    public String getColor() {
        return color;
    }


}
