import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

class interfaceWindow extends JFrame {
    JFrame frame1 = new JFrame();
    JLabel label1 = new JLabel("Name");
    JLabel label2 = new JLabel("Receipt Number");
    JLabel label3 = new JLabel("Distance in KM");
    JLabel label4 = new JLabel("TRAVERSE");
    JLabel label5 = new JLabel("Enter Index");
    JLabel label6 = new JLabel("DELETE");
    JLabel label7 = new JLabel("Enter Index");
    JButton btn1 = new JButton("INSERT");
    JButton btn2 = new JButton("VIEW ORDERS");
    JButton btn3 = new JButton("TRAVERSE");
    JButton btn4 = new JButton("DELETE");
    JButton btn5 = new JButton("INSERTION SORT");
    JButton btn6 = new JButton("SELECTION SORT");
    JButton btn7 = new JButton("BUBBLE SORT");
    JTextField ta1 = new JTextField();
    JTextField ta2 = new JTextField();
    JTextField ta3 = new JTextField();
    JTextField ta4 = new JTextField();
    JTextField ta5 = new JTextField();
    JPanel jpl1 = new JPanel();

    JPanel pnlTable = new JPanel();
    String[] tblHead = { "INDEX", "Name", "Receipt No", "Distance" };
    DefaultTableModel dtm = new DefaultTableModel(tblHead, 0);
    JTable table = new JTable(dtm);

    Font fnt = new Font("Arial", Font.BOLD, 14);

    public interfaceWindow() {
        frame1.setTitle("ANURA PHARMACY ONLINE");
        frame1.setSize(500, 600);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setResizable(false);

        frame1.setLocationRelativeTo(null);
        frame1.setLayout(null);

        label1.setSize(250, 15);
        label1.setLocation(10, 10);
        label1.setFont(fnt);
        ta1.setSize(200, 15);
        ta1.setLocation(250, 10);

        label2.setSize(250, 15);
        label2.setLocation(10, 40);
        label2.setFont(fnt);
        ta2.setSize(200, 15);
        ta2.setLocation(250, 40);

        label3.setSize(250, 15);
        label3.setLocation(10, 70);
        label3.setFont(fnt);
        ta3.setSize(200, 15);
        ta3.setLocation(250, 70);

        btn1.setSize(150, 15);
        btn1.setLocation(10, 130);

        btn2.setSize(150, 15);
        btn2.setLocation(250, 130);

        label4.setSize(250, 15);
        label4.setLocation(10, 180);
        label4.setFont(fnt);

        label5.setSize(150, 15);
        label5.setLocation(10, 200);
        label5.setFont(fnt);
        ta4.setSize(70, 15);
        ta4.setLocation(170, 200);
        btn3.setSize(150, 15);
        btn3.setLocation(250, 200);

        label6.setSize(250, 15);
        label6.setLocation(10, 250);
        label6.setFont(fnt);

        label7.setSize(150, 15);
        label7.setLocation(10, 270);
        label7.setFont(fnt);
        ta5.setSize(70, 15);
        ta5.setLocation(170, 270);
        btn4.setSize(150, 15);
        btn4.setLocation(250, 270);

        btn5.setSize(140, 15);
        btn5.setLocation(10, 350);

        btn6.setSize(140, 15);
        btn6.setLocation(170, 350);

        btn7.setSize(140, 15);
        btn7.setLocation(330, 350);

        pnlTable.setSize(470, 150);
        pnlTable.setLocation(10, 400);
        pnlTable.setLayout(new BorderLayout());
        frame1.add(pnlTable);

        table.setFont(fnt);
        pnlTable.add(new JScrollPane(table), BorderLayout.CENTER);

        frame1.add(label1);
        frame1.add(label2);
        frame1.add(label3);
        frame1.add(label4);
        frame1.add(label5);
        frame1.add(label6);
        frame1.add(label7);
        frame1.add(btn1);
        frame1.add(btn2);
        frame1.add(btn3);
        frame1.add(btn4);
        frame1.add(btn5);
        frame1.add(btn6);
        frame1.add(btn7);
        frame1.add(ta1);
        frame1.add(ta2);
        frame1.add(ta3);
        frame1.add(ta4);
        frame1.add(ta5);

        frame1.setVisible(true);

    }

    public static void main(String[] args) {
        interfaceWindow obj = new interfaceWindow();

        // Insert
        obj.btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = obj.ta1.getText();
                    int receiptNo = Integer.parseInt(obj.ta2.getText());
                    int distance = Integer.parseInt(obj.ta3.getText());

                    obj.ta1.setText("");
                    obj.ta2.setText("");
                    obj.ta3.setText("");

                    MainMenuFunctions.InsertData(name, receiptNo, distance);

                    View(obj);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        // View All
        obj.btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                View(obj);

            }
        });

        // Traverse
        obj.btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Order temp = MainMenuFunctions.TraverseData(Integer.parseInt(obj.ta4.getText()));
                    obj.dtm.setRowCount(0);

                    if (temp != null) {

                        String[] item = { "1", temp.name, String.valueOf(temp.receiptNo),
                                String.valueOf(temp.distance) };
                        obj.dtm.addRow(item);

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

        // Delete
        obj.btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    MainMenuFunctions.DeleteData(Integer.parseInt(obj.ta5.getText()));
                    View(obj);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

        // InsertionSort
        obj.btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                MainMenuFunctions.PreformInsertionSort();
                View(obj);
            }
        });

        // SelectionSort
        obj.btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                MainMenuFunctions.PreformSelectionSort();
                View(obj);

            }
        });

        // BubbleSort
        obj.btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                MainMenuFunctions.PreformBubbleSort();
                View(obj);
            }
        });

    }

    public static void View(interfaceWindow obj) {

        Order[] temp = MainMenuFunctions.show();
        obj.dtm.setRowCount(0);

        if (temp != null) {
            for (int i = 0; i < temp.length; i++) {
                String[] item = { String.valueOf(i), temp[i].name, String.valueOf(temp[i].receiptNo),
                        String.valueOf(temp[i].distance) };
                obj.dtm.addRow(item);
            }
        }
    }
}