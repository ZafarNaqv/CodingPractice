package designpatterns.strategy;

public class Runner {
    private TextFormatter textFormatter;
    
    public String format(String input) {
        return textFormatter.format(input);
    }
    
    public void setTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }
    
    public static void main(String[] args) {
        String someString = "yo yo Honey singh thIs is mY Life and i rule ich bin krank.";
        Runner runner = new Runner();
        TextFormatter camelCaseFormatter = new CamelCaseFormatter();
        TextFormatter lowerCaseFormatter = new LowerCaseFormatter();
        TextFormatter upperCaseFormatter = new UpperCaseFormatter();
        runner.setTextFormatter(camelCaseFormatter);
        System.out.println(runner.format(someString));
        runner.setTextFormatter(lowerCaseFormatter);
        System.out.println(runner.format(someString));
        runner.setTextFormatter(upperCaseFormatter);
        System.out.println(runner.format(someString));
    }
}