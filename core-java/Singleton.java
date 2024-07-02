public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void show() {
        System.out.println("Hello from the Singleton!");
    }
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        // Show a message
        singleton.show();
    }
}

