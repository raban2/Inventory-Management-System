package com.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.model.Cashier;
import com.service.CashierService;
import com.service.CashierServiceImpl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Table2 extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
    private JTextField idtxt;
    private JTextField nametxt;
    private JTextField mobiletxt;
    private JTextField addresstxt;
    private JTextField emailtxt;
    private JTextField passwordtxt;

    public Table2() {
        setLayout(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        add(inputPanel, BorderLayout.NORTH);

        inputPanel.add(new JLabel("Cashier Id:"));
        idtxt = new JTextField();
        inputPanel.add(idtxt);

        inputPanel.add(new JLabel("Cashier Name:"));
        nametxt = new JTextField();
        inputPanel.add(nametxt);

        inputPanel.add(new JLabel("Mobile Number:"));
        mobiletxt = new JTextField();
        inputPanel.add(mobiletxt);

        inputPanel.add(new JLabel("Address:"));
        addresstxt = new JTextField();
        inputPanel.add(addresstxt);

        inputPanel.add(new JLabel("Email-Id:"));
        emailtxt = new JTextField();
        inputPanel.add(emailtxt);

        inputPanel.add(new JLabel("Password:"));
        passwordtxt = new JTextField();
        inputPanel.add(passwordtxt);

        JButton addButton = new JButton("Add New");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idtxt.getText());
                    String name = nametxt.getText();
                    String mobile = mobiletxt.getText();
                    String address = addresstxt.getText();
                    String email = emailtxt.getText();
                    String pass = passwordtxt.getText();

                    Cashier cashier = new Cashier();
                    cashier.setCashierId(id);
                    cashier.setcName(name);
                    cashier.setMobileNumber(mobile);
                    cashier.setAddress(address);
                    cashier.setEmailId(email);
                    cashier.setPassword(pass);

                    CashierService cs = new CashierServiceImpl();
                    cs.addCashier(cashier);
                    JOptionPane.showMessageDialog(null, "Cashier Added Successfully");
                    display();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for Cashier Id");
                }
            }
        });
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int cashierId = (int) table.getValueAt(selectedRow, 0);
                    CashierService cs = new CashierServiceImpl();
                    int count = cs.deleteCashier(cashierId);
                    if (count > 0) {
                        JOptionPane.showMessageDialog(null, "Cashier Deleted Successfully");
                        display();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to Delete Cashier");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete");
                }
            }
        });
        inputPanel.add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) table.getValueAt(selectedRow, 0);
                    String name = (String) table.getValueAt(selectedRow, 1);
                    String mobileNo = (String) table.getValueAt(selectedRow, 2);
                    String address = (String) table.getValueAt(selectedRow, 3);
                    String email = (String) table.getValueAt(selectedRow, 4);
                    String password = (String) table.getValueAt(selectedRow, 5);

                    idtxt.setText(String.valueOf(id));
                    nametxt.setText(name);
                    mobiletxt.setText(mobileNo);
                    addresstxt.setText(address);
                    emailtxt.setText(email);
                    passwordtxt.setText(password);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to update");
                }
            }
        });
        inputPanel.add(updateButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idtxt.getText());
                String name = nametxt.getText();
                String mobile = mobiletxt.getText();
                String address = addresstxt.getText();
                String email = emailtxt.getText();
                String password = passwordtxt.getText();

                Cashier c = new Cashier();
                c.setCashierId(id);
                c.setcName(name);
                c.setMobileNumber(mobile);
                c.setAddress(address);
                c.setEmailId(email);
                c.setPassword(password);

                CashierService cs = new CashierServiceImpl();
                if (cs.updateCashier(c) > 0) {
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    display();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Update");
                }
            }
        });
        inputPanel.add(saveButton);

        display();
    }

    private void display() {
        CashierService rs = new CashierServiceImpl();
        List<Cashier> clist = rs.getAllCashier();
        DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
        tmodel.setRowCount(0);

        for (Cashier c : clist) {
            tmodel.addRow(new Object[]{c.getCashierId(), c.getcName(), c.getMobileNumber(), c.getAddress(), c.getEmailId(), c.getPassword()});
        }
    }
}
