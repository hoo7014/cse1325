package shelter;

public class Dog extends Animal {

    private DogBreed breed;

    public Dog(String name, Gender gender, int age, DogBreed breed) {
        super(name, gender, age);
        this.breed = breed;
    }

    public String family() {
        return "Dog";
    }

    public String breed() {
        return breed.toString();
    }

    public String toString() {
        return super.toString() + " breed " + breed();
    }

}
