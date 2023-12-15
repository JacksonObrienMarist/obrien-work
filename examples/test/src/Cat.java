public class Cat implements Animal{
    protected String name;
    protected int age;
    protected String favoriteFood;
    public Cat(String name, int age, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }
    @Override
    public void speak() {
        System.out.println("meow");
    }
}
