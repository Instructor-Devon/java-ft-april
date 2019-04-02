public class Animal {
    private String species;
    private String color;
    private int age;
    private int iqLevel;

    // Getter
    public String getSpecies() {
        return this.species;
    }
    // Setter
    public void setSpecies(String species) {
        this.species = species;
    }

    public static String ClassName = "Animal";

    public Animal(String species, String color, int age, int iqLevel) {
        this.species = species;
        this.color = color;
        this.age = age;
        this.iqLevel = iqLevel;
    }
    public Animal() {
        this.species = "Human";
        this.color = "Flesh";
        this.age = 11000;
        this.iqLevel = 12;
    }

    public void getDetails() {
        System.out.println("Species: " + this.species);
        System.out.println("Color: " + this.color);
        System.out.println("Age: " + this.age);
        System.out.println("IQ: " + this.iqLevel);
    }

    public String greeting() {
        return String.format("Hi i am a %s", this.species);
    }

    public String greeting(String customGreet) {
        return String.format("%s i am a %s", customGreet, this.species);
    }

}