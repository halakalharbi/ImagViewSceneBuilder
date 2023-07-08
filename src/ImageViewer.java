
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class ImageViewer extends JFrame {
    private JPanel imagePanel;
    private JPanel buttonPanel;
    private JLabel imageLabel;
    private JButton button;

    public ImageViewer() {

        setTitle("Image viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildImagePanel();
        buildButtonPanel();
        add(imagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void buildImagePanel() {
        imagePanel = new JPanel();
        imageLabel = new JLabel("Click the button to get an image.");
        imagePanel.add(imageLabel);
    }

    private void buildButtonPanel() {

        buttonPanel = new JPanel();

        button = new JButton("Get Image");

        button.addActionListener(new ButtonListener());
        buttonPanel.add(button);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int status = fileChooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filename = selectedFile.getPath();
                ImageIcon selectedFile1 = new ImageIcon(filename);
                imageLabel.setIcon(selectedFile1);
                imageLabel.setText(null);
                pack();
            }

        }
    }

    public static void main(String[] args) {
        new ImageViewer();
    }

}
