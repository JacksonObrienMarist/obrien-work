public class test {
    public static void main(String[] args) {
        Canine canine = new Canine("John", 3, "running");
        canine.speak();
        System.out.println(canine.favoriteActivity);
        Dog dog = new Dog(canine.name, canine.age, canine.favoriteActivity, "squish");
        dog.speak();
        System.out.println(dog.favoriteToy);
    }
}
