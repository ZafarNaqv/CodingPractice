package designpatterns.singleton;

import java.time.LocalDateTime;

public class SingletonLogger {
    public static SingletonLogger instance;
    private SingletonLogger() {
    
    }
    public static synchronized SingletonLogger getLogger(){
        if(instance==null){
            instance =  new SingletonLogger();
        }
        return instance;
    }
    
    public void log(String msg){
        System.out.println(LocalDateTime.now()+" : "+msg);
    }
}