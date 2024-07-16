interface Shape {
    void draw();
}

public class LambdaExample {
    public static void main(String[] args) {
        // lambda expression for the draw method in Shape interface
        Shape rectangle = () -> System.out.println("Rectangle class: draw() method");
        rectangle.draw();
    }
}
