public class Main {
    public static void main(String[] args) {
        Grid g = new Grid(10,8);
        Stage stage = new Stage(g);
        System.out.println("Controls: press '1' to have the first actor pick up an item from its cell; 'm' to move actor 1 right.");
    }
};