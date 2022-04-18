package shelter;

public class Cat extends Animal {

    CatBreed breed;

    public Cat(String name, Gender gender, int age, CatBreed catBreed) {
        super(name, gender, age);
        this.breed = catBreed;
    }

    public String family() {
        return "Cat";
    }

    public String breed() {
        return breed.toString();
    }

    public String toString() {
        return super.toString() + " breed " + breed();
    }

}
