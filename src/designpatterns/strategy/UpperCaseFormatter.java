package designpatterns.strategy;

public class UpperCaseFormatter implements TextFormatter{
    @Override
    public String format(String input) {
        return "UpperCaseFormatter: "+input.toUpperCase();
    }
}