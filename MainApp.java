import javax.swing.*;
import java.awt.*;

public class MainApp {
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Main Menu Launcher");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel judul = new JLabel("ImageViewer", SwingConstants.CENTER);
        judul.setFont(new Font("Verdana", Font.BOLD, 18));
        
        JButton btnStart = new JButton("MULAI APLIKASI");
        btnStart.setFont(new Font("Arial", Font.BOLD, 14));
        btnStart.setBackground(Color.CYAN);

        btnStart.addActionListener(e -> {
            frame.dispose();
            new LoginSystem();
        });

        frame.add(judul, BorderLayout.CENTER);
        frame.add(btnStart, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
}