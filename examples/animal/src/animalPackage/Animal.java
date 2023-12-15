package animalPackage;

public class Animal {
    int age;
    String name;

    public Animal (int age, String name) {
        this.age = age;
        this.name = name;
    }
    public void makeNoise() {
        System.out.println("noise");
    }
    public void eat(){
        System.out.println("eat");
    }

    protected void doSomethingPrivate(){
        System.out.println("private");
    }
}
