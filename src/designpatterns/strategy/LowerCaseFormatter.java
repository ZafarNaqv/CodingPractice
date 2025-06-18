package designpatterns.strategy;

public class LowerCaseFormatter implements TextFormatter {
    @Override
    public String format(String input) {
        return "LowerCaseFormatter: "+input.toLowerCase();
    }
}