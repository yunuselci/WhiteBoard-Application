package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class ClientBoard extends JFrame implements ActionListener {
    BorderLayout bl;
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    public static String srv;
    public static Socket myClient;
    public static ArrayList<Points> cordinates = new ArrayList<>();
    public static String drawType = "Nothing";

    public ClientBoard(String info) {
        super("Student Screen");
        srv = info;
        bl = new BorderLayout();
        setLayout(bl);
        menu();
        center();
    }

    JPanel jpComponent;
    JMenuBar jmb;
    JMenu exit;
    JMenuItem exit_sbm;

    public void menu() {
        jmb = new JMenuBar();
        exit = new JMenu("Exit");
        exit_sbm = new JMenuItem("Close App");
        exit_sbm.addActionListener(this);
        exit.add(exit_sbm);
        jmb.add(exit);
        add(jmb);
        setJMenuBar(jmb);
    }

    public void center() {
        jpComponent = new ClientPanel();
        jpComponent.setBackground(Color.white);
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        attandanceLabel = new javax.swing.JLabel();
        shapesLabel = new javax.swing.JLabel();
        chatTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        attandanceTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        shapesTextArea = new javax.swing.JTextArea();
        lblSec = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpComponent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpComponentLayout = new javax.swing.GroupLayout(jpComponent);
        jpComponent.setLayout(jpComponentLayout);
        jpComponentLayout.setHorizontalGroup(
                jpComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 764, Short.MAX_VALUE)
        );
        jpComponentLayout.setVerticalGroup(
                jpComponentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 660, Short.MAX_VALUE)
        );

        chatTextArea.setEditable(false);
        chatTextArea.setColumns(20);
        chatTextArea.setRows(5);
        jScrollPane1.setViewportView(chatTextArea);

        sendButton.setText("Send");

        attandanceLabel.setText("Attandance");

        shapesLabel.setText("How Many Shapes Drawed");

        chatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatTextFieldActionPerformed(evt);
            }
        });

        attandanceTextArea.setEditable(false);
        attandanceTextArea.setColumns(20);
        attandanceTextArea.setRows(5);
        jScrollPane2.setViewportView(attandanceTextArea);

        shapesTextArea.setEditable(false);
        shapesTextArea.setColumns(20);
        shapesTextArea.setRows(5);
        jScrollPane3.setViewportView(shapesTextArea);

        lblSec.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        lblSec.setText("00");

        lblMin.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        lblMin.setText("00");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel3.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jpComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chatTextField)
                                        .addComponent(jScrollPane1)
                                        .addComponent(attandanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(shapesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane3)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lblMin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblSec)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(shapesLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(attandanceLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSec, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblMin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jpComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
        );

        pack();
    }

    private void chatTextFieldActionPerformed(ActionEvent evt) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit_sbm) {
            System.exit(0);
        }

    }

    public void runClient() {
        try {
            connToS();
            streams();
            processConn();

        } catch (EOFException e) {
            dispMessage("\nClient Terminated Conn\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }

    }

    public static void connToS() throws IOException {
        dispMessage("Attempting\n");
        myClient = new Socket(InetAddress.getByName(srv), 12345);
    }

    public static void streams() throws IOException {
        oos = new ObjectOutputStream(myClient.getOutputStream());
        oos.flush();

        ois = new ObjectInputStream(myClient.getInputStream());
        dispMessage("\nStreams\n");
    }


    public void processConn() throws IOException {
        dispMessage("Successful");
        do {
            try {

                cordinates = (ArrayList<Points>) ois.readObject();
                for (Points cordinate : cordinates) {
                    switch (cordinate.shapeName) {
                        case "Square":
                            drawType = "Square";
                            break;
                        case "FSquare":
                            drawType = "FSquare";
                            break;
                        case "FCircle":
                            drawType = "FCircle";
                            break;
                        case "Circle":
                            drawType = "Circle";
                            break;
                        case "Line":
                            drawType = "Line";
                            break;
                        case "MSquare":
                            drawType = "MSquare";
                            break;
                        case "MCircle":
                            drawType = "MCircle";
                            break;
                        case "Clear":
                            drawType = "Clear";
                            break;
                    }

                }
                repaint();
            } catch (ClassNotFoundException e) {
                dispMessage("Unknown");
            }
        } while (true);
    }

    public static void closeConn() {
        dispMessage("\nTerminating Conn\n");

        try {
            oos.close();
            ois.close();
            myClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void dispMessage(final String string) {
        System.out.println(string);
    }
    public javax.swing.JLabel attandanceLabel;
    public javax.swing.JTextArea attandanceTextArea;
    public javax.swing.JTextArea chatTextArea;
    public javax.swing.JTextField chatTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel lblMin;
    public javax.swing.JLabel lblSec;
    public javax.swing.JButton sendButton;
    public javax.swing.JLabel shapesLabel;
    private javax.swing.JTextArea shapesTextArea;
}
