import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class Main{

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Talky");
        jframe.setSize(300, 400);
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea msg = new JTextArea();
        msg.setBounds(20, 300, 250, 50);
        msg.setLineWrap(true);
        msg.setWrapStyleWord(true);
        
        System.out.println("hello world");
        try{
            Socket socket = new Socket("localhost",5000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            msg.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "sendMessage");
            msg.getActionMap().put("sendMessage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = msg.getText();
                writer.println(inputText);
                msg.setText("");
            }
        });
        }
        catch(IOException e){
            e.printStackTrace();
        }

        jframe.add(msg);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
