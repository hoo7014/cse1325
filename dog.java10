import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Dog extends Animal {
    private String dogBreed;

    public Dog(String dogBreed, String name, String gender, int age) {
        super(name, gender, age);
        this.dogBreed = dogBreed;
    }

    public Dog(BufferedReader br) {
        super(br);
       dogBreed = breed;
    }

    public void save(BufferedWriter bw) throws IOException {
        try {
            bw.write(this.family() + "\n");
            bw.write(this.getName() + "\n");
            bw.write(this.getGender() + "\n");
            bw.write(this.getAge() + "\n");
            bw.write(this.breed() + "\n");

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        bw.flush();
        bw.close();
    }

    public String family() {
        return "dog";
    }

    public String breed() {
        return dogBreed;
    }

    @Override
    public String toString() {
        return super.toString() + " " + dogBreed + " dog)";
    }
}

