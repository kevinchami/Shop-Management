import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        ShoppingPanel s = new ShoppingPanel();

        JFrame frame = new JFrame("Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 900);

        frame.add(s);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
