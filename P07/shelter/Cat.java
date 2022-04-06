import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Cat  extends Animal{
    private String catBreed;

    public Cat(String catBreed, String name, String gender, int age) {
        super(name,  gender,  age);
        this.catBreed = catBreed;
    }
    public Cat(BufferedReader br) {
        super(br);
        catBreed = breed;
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
        return "cat";
    }
    public String breed() {
        return catBreed;
    }

    @Override
    public String toString() {
        return super.toString() + " " +catBreed + " cat)";
    }
}
