package lecture20.constructor;

public class Model {
    private Model(){
        throw new UnsupportedOperationException("You try to invoke private constructor");
    }

    public void info() {
        System.out.println("Method info was invoked");
    }
}
