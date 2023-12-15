package animalPackage;

public class Cat extends Animal{
    String catFoodPreference;

    public Cat(int age, String name, String catFoodPreference) {
        super(age, name);
        this.catFoodPreference = catFoodPreference;
    }
        @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("meow");
        eat();
        doSomethingPrivate();
    }
}
