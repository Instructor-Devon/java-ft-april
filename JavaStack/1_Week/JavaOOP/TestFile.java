public class TestFile {
    public static void main(String[] args) {
        Animal bear = new Animal("Bear", "Brown", 13, 100000);
        Animal puppy = new Animal("Puppy Dog", "Black", 0, 1);

        Animal defaultAnimal = new Animal();
      
        System.out.println(puppy.greeting());
        System.out.println(bear.greeting("sup"));
        System.out.println(defaultAnimal.greeting("Heya"));

    }
}