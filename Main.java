import java.awt.event.*;
import javax.swing.*;

class Main {
    public static void main(String[] args) {
        System.out.println("hello world");

        JFrame jframe = new JFrame("Talky");
        jframe.setSize(300, 400);
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea msg = new JTextArea();
        msg.setBounds(20, 300, 250, 50);

        msg.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "sendMessage");
        msg.getActionMap().put("sendMessage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = msg.getText();
                System.out.println("Message: " + inputText);
                msg.setText("");
            }
        });

        jframe.add(msg);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}