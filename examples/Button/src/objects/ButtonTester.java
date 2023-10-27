package objects;

import java.util.Random;

public class ButtonTester {
    public static void main(String[] args) {
       Button[] buttons = new Button[3];
       buttons[0] = new Button("Red");
       buttons[1] = new Button("Green");
        buttons[2] = new Button("Blue");

        

        Random rng = new Random();
        for (int i = 0; i < 10; i++) {
            int j = rng.nextInt(buttons.length);
            buttons[j].Press();
        }
    }
}
