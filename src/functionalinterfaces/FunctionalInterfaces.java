package functionalinterfaces;

public class FunctionalInterfaces {
    
    public static void main(String[] args) {
        Animal cat = (sentence,legs)-> sentence + " " + legs;
        Animal dog = (sentence,legs)-> sentence + "  BOW";
        Animal ant = (sentence,legs)-> sentence + " " + "some many legs";
        System.out.println(cat.makeSound("MEOW",4));
        System.out.println(dog.makeSound("BOOOO",4));
        System.out.println(ant.makeSound("no sound",104));
    }
}