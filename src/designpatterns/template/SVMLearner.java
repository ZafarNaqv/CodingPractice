package designpatterns.template;

public class SVMLearner extends MachineLearner{
    @Override
    protected void evaluateModel() {
        System.out.println("Evaluating SVM model: Accuracy 85%");
    }
    
    @Override
    protected void trainModel() {
        System.out.println("Training SVM model.");
    }
    
    @Override
    protected void initialiseModel() {
        System.out.println("Setting up hyper-paramters for SVM");
    }
}