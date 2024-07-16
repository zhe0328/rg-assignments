interface DefaultStaticExampleInterface {
    default void defaultShow() {
        System.out.println("default show");
    }
    static void staticDisplay() {
        System.out.println("static display");
    }
}

class DefaultStaticExampleClass implements DefaultStaticExampleInterface {
    // Optionally, we can override the default method
    @Override
    public void defaultShow() {
        System.out.println("Overridden default show");
    }
}

public class DefaultStaticExample {
    public static void main(String[] args) {
        // Call interface static method on Interface
        DefaultStaticExampleInterface.staticDisplay();
        DefaultStaticExampleClass defaultStaticExampleClass = new DefaultStaticExampleClass();

        // Call default method on Class
        defaultStaticExampleClass.defaultShow();
    }
}
