public class Canine implements Animal{
    protected String name;
    protected int age;
    protected String favoriteActivity;
    public Canine(String name, int age, String favoriteActivity) {
        this.name = name;
        this.age = age;
        this.favoriteActivity = favoriteActivity;
    }

    @Override
    public void speak() {
        System.out.println("canine barks");
    }
}
