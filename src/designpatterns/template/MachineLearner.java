package designpatterns.template;

public abstract class MachineLearner {
    public final void train(){
        readData();
        loadData();
        processData();
        initialiseModel();
        trainModel();
        evaluateModel();
    }
    
    protected abstract void evaluateModel();
    
    protected abstract void trainModel();
    
    protected abstract void initialiseModel();
    
    protected void processData() {
        System.out.println("Default process data");
    }
    
    protected void readData() {
        System.out.println("Reading data from particular folder");
    }
    
    protected void loadData() {
        System.out.println("Loading data into memory");
    }
    
    public static void main(String[] args) {
        MachineLearner ml = new SVMLearner();
        ml.train();
        System.out.println("_____________");
        System.out.println("Changing learner");
        ml = new KNNLearner();
        ml.train();
    }
}