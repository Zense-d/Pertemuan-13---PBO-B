import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class LoginSystem extends JFrame {
    private static HashMap<String, String> dataUser = new HashMap<>();

    private JTextField userField;
    private JPasswordField passField;
    private JLabel statusLabel;

    public LoginSystem() {
        dataUser.put("admin", "123"); 

        setTitle("Login / Register System");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10)); 

        JPanel panelUser = new JPanel();
        panelUser.add(new JLabel("Username: "));
        userField = new JTextField(15);
        panelUser.add(userField);

        JPanel panelPass = new JPanel();
        panelPass.add(new JLabel("Password: "));
        passField = new JPasswordField(15);
        panelPass.add(passField);

        JPanel panelTombol = new JPanel();
        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Daftar Akun (Register)");
        panelTombol.add(btnLogin);
        panelTombol.add(btnRegister);

        statusLabel = new JLabel("Silakan Login atau Daftar dulu.", SwingConstants.CENTER);
        statusLabel.setForeground(Color.BLUE);

        add(new JLabel("SISTEM KEAMANAN", SwingConstants.CENTER));
        add(panelUser);
        add(panelPass);
        add(panelTombol);
        add(statusLabel);
        
        btnRegister.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                showMessage("Username/Password tidak boleh kosong!", Color.RED);
            } else if (dataUser.containsKey(user)) {
                showMessage("Username sudah terdaftar! Gunakan nama lain.", Color.RED);
            } else {
                dataUser.put(user, pass); 
                showMessage("Akun berhasil dibuat! Silakan Login.", Color.GREEN);
               
                userField.setText("");
                passField.setText("");
            }
        });

        btnLogin.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (dataUser.containsKey(user)) {
                if (dataUser.get(user).equals(pass)) {
                    JOptionPane.showMessageDialog(this, "Login Berhasil!");
                    dispose(); 
                    new ImageViewer();
                } else {
                    showMessage("Password Salah!", Color.RED);
                }
            } else {
                showMessage("Username tidak ditemukan. Daftar dulu!", Color.RED);
            }
        });

        setVisible(true);
    }

    private void showMessage(String msg, Color c) {
        statusLabel.setText(msg);
        statusLabel.setForeground(c);
    }
}