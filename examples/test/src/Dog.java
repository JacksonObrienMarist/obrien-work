public class Dog extends Canine{
    protected String favoriteToy;

    public Dog(String name, int age, String favoriteActivity, String favoriteToy) {
        super(name,age, favoriteActivity);
        this.favoriteToy = favoriteToy;
    }

    @Override
    public void speak() {
        System.out.println("Dog barks");
    }
}
