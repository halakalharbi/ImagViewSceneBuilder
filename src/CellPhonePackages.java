
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The MenuWindow class demonstrates a menu system.
 */

public class CellPhonePackages extends JFrame {
   private JPanel panel;
   private JLabel label1;
   private JLabel label2;
   private JLabel label3;
   private JTextField packageCost;
   private JTextField phoneCost;
   private JTextField optionsCost;

   private JMenuBar menuBar;
   private JMenu fileMenu;
   private JMenu pachageMenu;
   private JMenu phoneMenu;
   private JMenu optionMenu;
   private JMenuItem exitItem;
   private JRadioButtonMenuItem package1;
   private JRadioButtonMenuItem package2;
   private JRadioButtonMenuItem package3;
   private JRadioButtonMenuItem model1;
   private JRadioButtonMenuItem model2;
   private JRadioButtonMenuItem model3;

   private JCheckBoxMenuItem voiceItem;
   private JCheckBoxMenuItem textItem;

   public CellPhonePackages() {

      setTitle("Cell Phone Package");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      buildMenuBar();
      buildContent();
      add(panel);
      pack();
      setVisible(true);

   }

   private void buildContent() {
      panel = new JPanel();
      panel.setLayout(new GridLayout(3, 3));
      label1 = new JLabel("Package Cost:");
      label2 = new JLabel("Phone Cost:");
      label3 = new JLabel("Options Cost:");
      packageCost = new JTextField("45.00 per month", 10);
      phoneCost = new JTextField("29.95", 10);
      optionsCost = new JTextField("0.00");
      panel.add(label1);
      panel.add(packageCost);
      panel.add(label2);
      panel.add(phoneCost);
      panel.add(label3);
      panel.add(optionsCost);

   }

   private void buildMenuBar() {

      menuBar = new JMenuBar();
      buildFileMenu();
      buildTextMenu();
      buildAddMenu();
      buildCellMenu();
      menuBar.add(fileMenu);
      menuBar.add(pachageMenu);
      menuBar.add(phoneMenu);
      menuBar.add(optionMenu);
      setJMenuBar(menuBar);
   }

   private void buildFileMenu() {

      exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic(KeyEvent.VK_X);
      exitItem.addActionListener(new ExitListener());

      fileMenu = new JMenu("File");
      fileMenu.setMnemonic(KeyEvent.VK_F);

      fileMenu.add(exitItem);
   }

   private void buildTextMenu() {

      package1 = new JRadioButtonMenuItem("300 minutes", true);
      package1.setMnemonic(KeyEvent.VK_3);
      package1.addActionListener(new PlanListener());

      package2 = new JRadioButtonMenuItem("800 minutes");
      package2.setMnemonic(KeyEvent.VK_8);
      package2.addActionListener(new PlanListener());

      package3 = new JRadioButtonMenuItem("1500 minutes");
      package3.setMnemonic(KeyEvent.VK_1);
      package3.addActionListener(new PlanListener());
      ButtonGroup group = new ButtonGroup();
      group.add(package1);
      group.add(package2);
      group.add(package3);

      pachageMenu = new JMenu("Packages");
      pachageMenu.setMnemonic(KeyEvent.VK_P);

      pachageMenu.add(package1);
      pachageMenu.add(package2);
      pachageMenu.add(package3);

   }

   private void buildAddMenu() {

      model1 = new JRadioButtonMenuItem("Model 100", true);
      model1.setMnemonic(KeyEvent.VK_1);
      model1.addActionListener(new PlanListener());

      model2 = new JRadioButtonMenuItem("Model 110");
      model2.setMnemonic(KeyEvent.VK_1);
      model2.addActionListener(new PlanListener());

      model3 = new JRadioButtonMenuItem("Model 200");
      model3.setMnemonic(KeyEvent.VK_3);
      model3.addActionListener(new PlanListener());

      ButtonGroup group = new ButtonGroup();
      group.add(model1);
      group.add(model2);
      group.add(model3);

      phoneMenu = new JMenu("Phones");
      phoneMenu.setMnemonic(KeyEvent.VK_H);

      phoneMenu.add(model1);
      phoneMenu.add(model2);
      phoneMenu.add(model3);

   }

   private void buildCellMenu() {

      voiceItem = new JCheckBoxMenuItem("Voice mail", false);
      voiceItem.setMnemonic(KeyEvent.VK_V);
      voiceItem.addActionListener(new PlanListener());
      textItem = new JCheckBoxMenuItem("Text message", false);
      textItem.setMnemonic(KeyEvent.VK_T);
      textItem.addActionListener(new PlanListener());

      optionMenu = new JMenu("Options");
      optionMenu.setMnemonic(KeyEvent.VK_O);

      optionMenu.add(voiceItem);
      optionMenu.add(textItem);

   }

   private class ExitListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }

   private class PlanListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         double packages = 0;
         double model = 0;
         double option = 0.00;
         if (package1.isSelected())
            packages = 45.00;
         else if (package2.isSelected())
            packages = 65.00;
         else if (package3.isSelected())
            packages = 99.00;

         if (model1.isSelected())
            model = 29.95;
         else if (model2.isSelected())
            model = 49.95;
         else if (model3.isSelected())
            model = 99.95;

         if (voiceItem.isSelected())
            option += 5;

         if (textItem.isSelected())
            option += 10;
         packageCost.setText(String.valueOf(packages) + " per month");
         phoneCost.setText(String.valueOf(model));
         optionsCost.setText(String.valueOf(option));
      }
   }

   public static void main(String[] args) {
      new CellPhonePackages();
   }

}
