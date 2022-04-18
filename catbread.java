package shelter;

public enum CatBreed {
    American_Ringtail("American_Ringtail");

    private String name;

    CatBreed(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
