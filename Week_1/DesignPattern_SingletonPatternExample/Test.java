package SingletonPatternExample;

public class Test {
    public static void main(String args[]){
        Logger ob1=Logger.getInstance();
        Logger ob2=Logger.getInstance();
        System.out.print(ob1==ob2?"Only one instance of Logger is created.":"Multiple instances of Logger are created.");
    }
 }

 class Logger{
    private static Logger ob=new Logger();
    private Logger(){
    }
    public static Logger getInstance(){
        return ob;
    }
 }