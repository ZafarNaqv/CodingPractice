package designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private PIZZASIZE size;
    private List<String> ingredients;
    private String sauce;
    String extraTopping;
    
    //COnstructor is private and contains all attributes and takes the builder as argument
    private Pizza(PizzaBuilder builder) {
        this.ingredients = builder.ingredients;
        this.sauce = builder.sauce;
        this.size = builder.size;
        this.extraTopping = builder.extraTopping;
    }
    
    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", ingredients=" + ingredients +
                ", sauce='" + sauce + '\'' +
                ", extraTopping='" + extraTopping + '\'' +
                '}';
    }
    
    static class PizzaBuilder {
        //attributes are duplicated in both classes
        PIZZASIZE size;
        List<String> ingredients;
        String sauce;
        String extraTopping;
        
        public PizzaBuilder(PIZZASIZE size, List<String> ingredients) {
            this.size = size;
            this.ingredients = new ArrayList<>(ingredients);
        }
        
        public Pizza build(){
            return new Pizza(this);
        }
        
        public PizzaBuilder addCheese(){
            this.ingredients.add("Cheese");
            return this;
        }
        
        public PizzaBuilder addBacon(){
            this.ingredients.add("Bacon");
            return this;
        }
        
        public PizzaBuilder addSauce(String sauce){
            this.sauce = sauce;
            return this;
        }
        
        public PizzaBuilder addTopping(String topping){
            this.extraTopping = topping;
            return this;
        }
    }
    
    
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder(PIZZASIZE.MEDIUM,new ArrayList<>()).addCheese().addTopping("Mayonese").build();
        System.out.println(pizza);
    }
}