package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;

public class ClientBoard extends JFrame implements ActionListener {


    public ClientBoard(String info) {
        super("Student Screen");
        serve = info;
        borderLayout = new BorderLayout();
        setLayout(borderLayout);
        theMenuBar();
        Components();
        attandanceFileCreate();
        clearTheAttandance();



    }

    public void theMenuBar() {
        jMenuBar = new JMenuBar();
        hand = new JMenu("Hand");
        exit = new JMenu("Exit");
        handSubMenu = new JMenuItem("Rise Your Hand");
        exitSubMenu = new JMenuItem("Close App");
        handSubMenu.addActionListener(this);
        exitSubMenu.addActionListener(this);
        hand.add(handSubMenu);
        exit.add(exitSubMenu);
        jMenuBar.add(hand);
        jMenuBar.add(exit);
        add(jMenuBar);
        setJMenuBar(jMenuBar);

    }

    public void Components() {
        jpComponent = new ClientPanel();
        jpComponent.setBackground(Color.white);

        JScrollPane jScrollPane1 = new JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        attandanceLabel = new javax.swing.JLabel();
        shapesLabel = new javax.swing.JLabel();
        chatTextField = new javax.swing.JTextField();
        JScrollPane jScrollPane2 = new JScrollPane();
        attandanceTextArea = new javax.swing.JTextArea();
        JScrollPane jScrollPane3 = new JScrollPane();
        shapesTextArea = new javax.swing.JTextArea();
        lblSec = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        JLabel jLabel3 = new JLabel();
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
        sendButton.addActionListener(evt -> sendButtonActionPerformed());

        attandanceLabel.setText("Attandance");

        shapesLabel.setText("How Many Shapes Drawed");

        attandanceTextArea.setEditable(false);
        attandanceTextArea.setColumns(20);
        attandanceTextArea.setRows(5);
        jScrollPane2.setViewportView(attandanceTextArea);

        shapesTextArea.setEditable(false);
        shapesTextArea.setColumns(20);
        shapesTextArea.setRows(5);
        jScrollPane3.setViewportView(shapesTextArea);

        lblSec.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 30)); // NOI18N
        lblSec.setText("00");

        lblMin.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 30)); // NOI18N
        lblMin.setText("00");

        jLabel3.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 30)); // NOI18N
        jLabel3.setText(":");

        riseHand.setText("Rise Your Hand");
        riseHand.addActionListener(evt -> riseHandActionPerformed());

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

    private void sendButtonActionPerformed() {
        message.message = "ID:"+ n +  " Student: " + chatTextField.getText();
        chatTextArea.append("\n" + message.message);
        message.shapeName = "Msg";
        messages.add(message);
        sendTheInformationList(message.shapeName);
        chatTextField.setText("");
    }

    private void attandanceFileCreate(){
        try {
            File myObj = new File("attandance.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void attandanceFileWrite(String attandance){
        try {
            Files.write(Paths.get("attandance.txt"), attandance.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void readAttandance(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Yunus\\IntellijIdeaProjects\\yunus_berkay\\attandance.txt"));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                attandanceTextArea.append(line+"\n");
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearTheAttandance(){
        try{
            FileWriter fwOb = new FileWriter("attandance.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void displayTime() {

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
                attandanceTextArea.setText("");
                JOptionPane.showMessageDialog(rootPane, "Time is Over", "Stopped", JOptionPane.ERROR_MESSAGE);
                terminateTheConnection();
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

    public static void writeShapeCounter(int numberOfShapes) {
        if (numberOfShapes <= 1) {
            shapesTextArea.setText(numberOfShapes + " Shape is drawed");

        } else {
            shapesTextArea.setText(numberOfShapes + " Shapes are drawed");

        }

    }

    private void riseHandActionPerformed() {
        handInfo.shapeName = "Hand";
        handInfos.add(handInfo);
        sendTheInformationList("Hand");
    }

    public void startTheClient() {
        try {
            sendButton.setEnabled(false);
            attemptToConnect();
            establishTheConnection();
            clientListenTheConnection();

        } catch (EOFException e) {
            displayTheMessage("\nClient Terminated Conn\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            terminateTheConnection();
        }

    }

    public static void attemptToConnect() throws IOException {
        displayTheMessage("Trying to connect..\n");
        theStudent = new Socket(InetAddress.getByName(serve), 12345);
    }

    public void establishTheConnection() throws IOException {
        objectOutputStream = new ObjectOutputStream(theStudent.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(theStudent.getInputStream());
        displayTheMessage("\nConnected.\n");
        displayTheMessage("Chat Activated:");
        attandanceFileWrite("ID:"+ n + " Student\n");
        displayTheMessage("Student has been processed to attandance file\n");
    }

    public void clientListenTheConnection() throws IOException {
        sendButtonEnabler(true);
        readAttandance();
        do {
            try {

                infos = (ArrayList<Informations>) objectInputStream.readObject();
                for (Informations info : infos) {
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
                            displayTheMessage(info.message);
                            break;
                    }

                }
                repaint();
            } catch (ClassNotFoundException e) {
                displayTheMessage("Unknown");
            }
        } while (true);
    }

    private void sendTheInformationList(String shapeName) {
        try {
            if (shapeName.equals("Hand")) {
                objectOutputStream.reset();
                objectOutputStream.writeObject(handInfos);
                objectOutputStream.flush();
            } else if (shapeName.equals("Msg")) {
                objectOutputStream.reset();
                objectOutputStream.writeObject(messages);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            chatTextArea.append("\nError");
        }
    }

    public static void terminateTheConnection() {
        attandanceTextArea.setText("");
        displayTheMessage("\nTerminating the Connection\n");
        sendButtonEnabler(false);
        try {
            objectOutputStream.close();
            objectInputStream.close();
            theStudent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayTheMessage(final String string) {
        chatTextArea.append("\n" + string);
    }

    private static void sendButtonEnabler(final boolean b) {
        SwingUtilities.invokeLater(() -> sendButton.setEnabled(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitSubMenu) {
            System.exit(0);
        } else if (e.getSource() == handSubMenu) {
            handInfo.shapeName = "Hand";
            handInfos.add(handInfo);
            sendTheInformationList("Hand");
        }

    }


    //Variables
    public static Component rootPane;
    BorderLayout borderLayout;
    public static ObjectOutputStream objectOutputStream;
    public static ObjectInputStream objectInputStream;
    public static String serve;
    public static Socket theStudent;
    public static ArrayList<Informations> infos = new ArrayList<>();
    public static String drawType = "Nothing";
    public static int min, sec;
    public static int n = 10000 + new Random().nextInt(90000);

    public static Timer timer;
    public static boolean flag_for_clock = true;
    public static ArrayList<Informations> messages = new ArrayList<>();
    public static Informations message = new Informations("message", "shapename");
    public static ArrayList<Informations> handInfos = new ArrayList<>();
    public static Informations handInfo = new Informations("Hand");
    JPanel jpComponent;
    JMenuBar jMenuBar;
    JMenu exit, hand;
    JMenuItem exitSubMenu, handSubMenu;
    public javax.swing.JLabel attandanceLabel;
    public static javax.swing.JTextArea attandanceTextArea;
    public static javax.swing.JTextArea chatTextArea;
    public javax.swing.JTextField chatTextField;
    public static javax.swing.JLabel lblMin;
    public static javax.swing.JLabel lblSec;
    public static javax.swing.JButton sendButton;
    public javax.swing.JLabel shapesLabel;
    public static javax.swing.JTextArea shapesTextArea;
    public javax.swing.JButton riseHand;

}
