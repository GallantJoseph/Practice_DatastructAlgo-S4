package Model;

public class Dog extends Animal {
    public Dog() {
        super();
        this.setType("Dog");
    }

    public Dog(String name) {
        super(name, "Dog");
    }
}
