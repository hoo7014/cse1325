import javax.swing.JOptionPane;
import shelter.*;

public class Mass {

    public static void main(String[] args) {
        String[] types = {"Cat", "Dog"};
        String type = (String) JOptionPane.showInputDialog(
                null,
                "Type?",
                "Animals",
                JOptionPane.PLAIN_MESSAGE,
                null,
                types,
                types[0]);
        Animal animal = null;
        if (type.equals("Cat")) {
            String name = JOptionPane.showInputDialog("Name:");
            Gender gender = (Gender) JOptionPane.showInputDialog(
                    null,
                    "Gender?",
                    "Animals",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    Gender.values(),
                    Gender.values()[0]);
            int age = Integer.parseInt(JOptionPane.showInputDialog("Age:"));
            CatBreed breed = (CatBreed) JOptionPane.showInputDialog(
                    null,
                    "Breed?",
                    "Animals",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    CatBreed.values(),
                    CatBreed.values()[0]);
            animal = new Cat(name, gender, age, breed);
        } else {
            String name = JOptionPane.showInputDialog("Name:");
            String[] genders = {"Male", "Female"};
            Gender gender = (Gender) JOptionPane.showInputDialog(
                    null,
                    "Gender?",
                    "Animals",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    Gender.values(),
                    Gender.values()[0]);
            int age = Integer.parseInt(JOptionPane.showInputDialog("Age:"));
            DogBreed breed = (DogBreed) JOptionPane.showInputDialog(
                    null,
                    "Breed?",
                    "Animals",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    DogBreed.values(),
                    DogBreed.values()[0]);
            animal = new Dog(name, gender, age, breed);
        }

        System.out.println(animal);
    }
}
