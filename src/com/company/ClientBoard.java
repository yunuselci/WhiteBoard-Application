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


    public ClientBoard(String info) {
        super("Student Screen");
        srv = info;
        bl = new BorderLayout();
        setLayout(bl);
        menu();
        Components();


    }

    public void menu() {
        jmb = new JMenuBar();
        hand = new JMenu("Hand");
        exit = new JMenu("Exit");
        hand_sbm = new JMenuItem("Rise Your Hand");
        exit_sbm = new JMenuItem("Close App");
        hand_sbm.addActionListener(this);
        exit_sbm.addActionListener(this);
        hand.add(hand_sbm);
        exit.add(exit_sbm);
        jmb.add(hand);
        jmb.add(exit);
        add(jmb);
        setJMenuBar(jmb);

    }

    public void Components() {
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
        riseHand = new javax.swing.JButton();



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
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

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

        riseHand.setText("Rise Your Hand");
        riseHand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                riseHandActionPerformed(evt);
            }
        });

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
                                                .addComponent(lblSec)
                                                .addGap(18, 18, 18)
                                                .addComponent(riseHand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(riseHand, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                                                .addGap(38, 38, 38)
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

    private void sendButtonActionPerformed(ActionEvent evt) {
        message.message = "Student: " + chatTextField.getText();
        chatTextArea.append("\n"+message.message);
        message.shapeName = "Msg";
        messages.add(message);
        send(message.shapeName);
        chatTextField.setText("");
    }

    public static void displayTime(){

        timer = new Timer(1000, e -> {
            lblMin.setForeground(Color.black);
            lblSec.setForeground(Color.black);

            if (sec == 0) {
                sec = 60;
                min--;
            }
            if (min == 0) {
                lblMin.setForeground(Color.red);
                lblSec.setForeground(Color.red);

            }
            if (min < 0) {
                JOptionPane.showMessageDialog(rootPane, "Time is Over", "Stopped", 0);
                closeConn();
                min = 0;
                sec = 0;
                timer.stop();
            } else {

                sec--;
                if (sec < 10) {
                    lblSec.setText("0" + sec);
                    flag_for_clock = false;
                }
                if (min < 10) {
                    lblMin.setText("0" + min);
                    if (sec < 10) {
                        lblSec.setText("0" + sec);
                    } else {
                        lblSec.setText("" + sec);
                    }
                    flag_for_clock = false;
                }
                if (flag_for_clock) {
                    lblMin.setText("" + min);
                    lblSec.setText("" + sec);
                }

            }
        });
        timer.start();
    }

    public static void writeShapeCounter(int numberOfShapes){
        if(numberOfShapes<=1){
            shapesTextArea.setText(numberOfShapes +" Shape is drawed");

        }else{
            shapesTextArea.setText(numberOfShapes +" Shapes are drawed");

        }

    }
    private void riseHandActionPerformed(java.awt.event.ActionEvent evt) {
        handInfo.shapeName = "Hand";
        handInfos.add(handInfo);
        send("Hand");
    }
    private void chatTextFieldActionPerformed(ActionEvent evt) {
    }
    private void send(String shapeName) {
        try {
            if(shapeName.equals("Hand")){
                oos.reset();
                oos.writeObject(handInfos);
                oos.flush();
            }else if(shapeName.equals("Msg")){
                oos.reset();
                oos.writeObject(messages);
                oos.flush();
            }
        }
        catch (IOException e) {
            chatTextArea.append("\nError");
        }
    }
    private static void setButtonEnabled(final boolean b) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                sendButton.setEnabled(b);

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit_sbm) {
            System.exit(0);
        }else if(e.getSource() == hand_sbm){
            handInfo.shapeName = "Hand";
            handInfos.add(handInfo);
            send("Hand");
        }

    }

    public void runClient() {
        try {
            sendButton.setEnabled(false);
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
        setButtonEnabled(true);
        dispMessage("Successful");
        do {
            try {

                infos = (ArrayList<Points>) ois.readObject();
                for (Points info : infos) {
                    switch (info.shapeName) {
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
                        case "Time":
                            drawType = "Time";
                            break;
                        case "Msg":
                            dispMessage(info.message);
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
        setButtonEnabled(false);
        try {
            oos.close();
            ois.close();
            myClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void dispMessage(final String string) {
        chatTextArea.append("\n" + string);
    }

    private static Component rootPane;
    BorderLayout bl;
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    public static String srv;
    public static Socket myClient;
    public static ArrayList<Points> infos = new ArrayList<>();
    public static String drawType = "Nothing";
    public static int min,sec;
    public static Timer timer;
    public static boolean flag_for_clock = true;
    public static ArrayList<Points> messages = new ArrayList<>();
    public static Points message = new Points("message","shapename");
    public static ArrayList<Points> handInfos = new ArrayList<>();
    public static Points handInfo = new Points("Hand");
    JPanel jpComponent;
    JMenuBar jmb;
    JMenu exit,hand;
    JMenuItem exit_sbm,hand_sbm;
    public javax.swing.JLabel attandanceLabel;
    public javax.swing.JTextArea attandanceTextArea;
    public static javax.swing.JTextArea chatTextArea;
    public javax.swing.JTextField chatTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lblMin;
    public static javax.swing.JLabel lblSec;
    public static javax.swing.JButton sendButton;
    public javax.swing.JLabel shapesLabel;
    public static javax.swing.JTextArea shapesTextArea;
    public javax.swing.JButton riseHand;

}
