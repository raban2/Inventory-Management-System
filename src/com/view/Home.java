package com.view;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 995, 591);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 0));
        contentPane.setBackground(new Color(255, 255, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel logo = new JLabel("Quick Bill");
        logo.setIcon(new ImageIcon("C:/Users/HELIOS 300/Desktop/logo/logo.png"));
        logo.setBounds(-20, 10, 286, 79);
        contentPane.add(logo);
        
        logo.setFont(new Font("Tahoma", Font.PLAIN, 30));
            
        JLabel createbill = new JLabel("Create Bill");
        createbill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new NewBill().setVisible(true);
                dispose();
            }
        });
        createbill.setIcon(new ImageIcon("C:/Users/HELIOS 300/Desktop/logo/new.png"));
        createbill.setBounds(277, 17, 159, 72);
        contentPane.add(createbill);
        createbill.setFont(new Font("Tahoma", Font.PLAIN, 16));
        createbill.setBackground(Color.BLUE); // Set background color
        createbill.setOpaque(true); // Make background color visible
        
        JLabel searchbill = new JLabel("Search  Bill");
        searchbill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Search().setVisible(true);
                dispose();
            }
        });
        searchbill.setIcon(new ImageIcon("C:/Users/HELIOS 300/Desktop/logo/search.png"));
        searchbill.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchbill.setBounds(446, 10, 159, 77);
        contentPane.add(searchbill);
        searchbill.setBackground(Color.RED); // Set background color
        searchbill.setOpaque(true); // Make background color visible
        
        JLabel productinformation = new JLabel("Product Information");
        productinformation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SearchProduct().setVisible(true);
                dispose();
            }
        });
        productinformation.setIcon(new ImageIcon("C:/Users/HELIOS 300/Desktop/logo/pi.png"));
        productinformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        productinformation.setBounds(629, 10, 241, 79);
        contentPane.add(productinformation);
        productinformation.setBackground(Color.GREEN); // Set background color
        productinformation.setOpaque(true); // Make background color visible
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(new Color(255, 255, 0));
        lblNewLabel.setBackground(new Color(255, 255, 0));
        lblNewLabel.setBounds(-10, 0, 991, 171);
        contentPane.add(lblNewLabel);
    }
}
