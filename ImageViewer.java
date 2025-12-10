import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;

    public ImageViewer() {
        setTitle("Aplikasi Image Viewer (Secured)");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Selamat Datang di Galeri Rahasia", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        add(header, BorderLayout.NORTH);

        imageLabel = new JLabel("Pilih gambar untuk ditampilkan...", SwingConstants.CENTER);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        JButton openButton = new JButton("Buka File Gambar");
        openButton.addActionListener(e -> bukaFileGambar());
        add(openButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void bukaFileGambar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "jpeg"));
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            
            Image img = icon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
            imageLabel.setText("");
        }
    }
}