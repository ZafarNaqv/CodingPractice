package functionalinterfaces;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalInterfaces {
    
    public static void main(String[] args) {
        Animal cat = (sentence,legs)-> sentence + " " + legs;
        Animal dog = (sentence,legs)-> sentence + "  BOW";
        Animal ant = (sentence,legs)-> sentence + " " + "some many legs";
        System.out.println(cat.makeSound("MEOW",4));
        System.out.println(dog.makeSound("BOOOO",4));
        System.out.println(ant.makeSound("no sound",104));
        
        List<String> words = List.of("Sana","Marzia","Jumangi","Toyota","Fox");
        
        System.out.println(words.stream().mapToInt((m)->m.length()).boxed().collect(Collectors.toList()));
    }
}