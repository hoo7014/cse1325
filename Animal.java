import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Animal {
    private String name;
    private String gender;
    private int age;
    protected String breed;

    public Animal(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Animal(BufferedReader br) {
        try (br) {
            String line = br.readLine();
            name = line;
            br.readLine();
            line = br.readLine();
            if (line.equals("dog")) {
                name = br.readLine();
                gender = br.readLine();
                age = Integer.parseInt(br.readLine());
                breed = br.readLine();
            } else if (line.equals("cat")) {
                name = br.readLine();
                gender = br.readLine();
                age = Integer.parseInt(br.readLine());
                breed = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return "animal";
    }

    public String breed() {
        return "breed";
    }
    public String breed( String breed) {
        return breed;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + "(" + age + " year old " + gender;
    }

}
