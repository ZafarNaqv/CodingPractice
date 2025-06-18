package designpatterns.template;

public class KNNLearner extends MachineLearner{
    @Override
    protected void evaluateModel() {
        System.out.println("Evaluating KNN model: Accuracy 66%");
    }
    
    @Override
    protected void trainModel() {
        System.out.println("Training KNN model.");
    }
    
    @Override
    protected void initialiseModel() {
        System.out.println("Setting up hyper-paramters for KNN");
    }
    
    @Override
    protected void readData() {
        System.out.println("Additional reading for KNN");
    }
    
}