ackage shelter;

public enum DogBreed {
    American_Bulldog("American Bulldog"),
    American_Eskimo("American Eskimo"),
    American_Foxhound("American Foxhound"),
    BOXER("Boxer"),
    CHIHUAHUA("Chihuahua"),
    DOBERMAN("Doberman");

    private String name;

    DogBreed(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
