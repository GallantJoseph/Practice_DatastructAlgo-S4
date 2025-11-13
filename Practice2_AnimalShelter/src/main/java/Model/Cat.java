package Model;

public class Cat extends Animal {
    public Cat() {
        super();
        this.setType("Cat");
    }

    public Cat(String name) {
        super(name, "Cat");
    }
}
