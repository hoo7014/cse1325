package shelter;

public abstract class Animal {

    private String name;
    private Gender gender;
    private int age;

    public Animal(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public abstract String family();

    public abstract String breed();

    @Override
    public String toString() {
        return name + " (" + age + " year old " + gender + " " + family() + ")";
    }
}
