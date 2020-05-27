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
        exit = new JMenu("Exit");
        exitSubMenu = new JMenuItem("Close App");
        exitSubMenu.addActionListener(this);
        exit.add(exitSubMenu);
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
        secLabel = new javax.swing.JLabel();
        minLabel = new javax.swing.JLabel();
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

        secLabel.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 30)); // NOI18N
        secLabel.setText("00");

        minLabel.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 30)); // NOI18N
        minLabel.setText("00");

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
                                                .addComponent(minLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(secLabel)
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
                                                        .addComponent(secLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        try
        {
            File file = new File("attandance.txt");
            if (file.createNewFile())
            {
                System.out.println("Attandance created: " + file.getName());
            }
            else
            {
                System.out.println("Attandance is already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Error occurupted.Stack tree is: ");
            e.printStackTrace();
        }
    }

    private void attandanceFileWrite(String attandance){
        try
        {
            Files.write(Paths.get("attandance.txt"), attandance.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Wroted");
        }
        catch (IOException e)
        {
            System.out.println("Error occurupted.Stack tree is: ");
            e.printStackTrace();
        }
    }

    private void readAttandance(){
        BufferedReader bufferedReader;
        try
        {
            bufferedReader = new BufferedReader(new FileReader(
                    "attandance.txt"));
            String readLine = bufferedReader.readLine();
            while (readLine != null)
            {
                //System.out.println(readLine);
                attandanceTextArea.append(readLine+"\n");
                // read next readLine
                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void clearTheAttandance(){
        try
        {
            FileWriter fileWriter = new FileWriter("attandance.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter, false);
            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void displayTime() {

        timer = new Timer(1000, e -> {
            minLabel.setForeground(Color.black);

            secLabel.setForeground(Color.black);

            if (second == 0)
            {
                second = 60;
                minute--;
            }
            if (minute == 0)
            {
                minLabel.setForeground(Color.red);
                secLabel.setForeground(Color.red);

            }
            if (minute < 0)
            {

                attandanceTextArea.setText("");
                JOptionPane.showMessageDialog(rootPane, "Time is Over", "Stopped", JOptionPane.ERROR_MESSAGE);
                terminateTheConnection();
                minute = 0;
                second = 0;
                timer.stop();

            } else {

                second--;
                if (second < 10)
                {
                    secLabel.setText("0" + second);
                    flagForClock = false;
                }
                if (minute < 10)
                {
                    minLabel.setText("0" + minute);
                    if (second < 10)
                    {
                        secLabel.setText("0" + second);
                    }
                    else
                    {
                        secLabel.setText("" + second);
                    }
                    flagForClock = false;
                }
                if (flagForClock)
                {
                    minLabel.setText("" + minute);
                    secLabel.setText("" + second);
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

        } catch (EOFException e)
        {
            displayTheMessage("\nClient Terminated Conn\n");
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
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
                            isMessageRecieved=false;
                            drawType = "Square";
                            break;
                        case "FSquare":
                            isMessageRecieved=false;
                            drawType = "FSquare";
                            break;
                        case "FCircle":
                            isMessageRecieved=false;
                            drawType = "FCircle";
                            break;
                        case "Circle":
                            isMessageRecieved=false;
                            drawType = "Circle";
                            break;
                        case "Line":
                            isMessageRecieved=false;
                            drawType = "Line";
                            break;
                        case "MSquare":
                            isMessageRecieved=false;
                            drawType = "MSquare";
                            break;
                        case "MCircle":
                            isMessageRecieved=false;
                            drawType = "MCircle";
                            break;
                        case "Clear":
                            isMessageRecieved=false;
                            drawType = "Clear";
                            break;
                        case "Time":
                            isMessageRecieved=false;
                            drawType = "Time";
                            break;
                        case "Msg":
                            isMessageRecieved=true;
                            drawType = "Msg";
                            break;
                    }

                }
                repaint();
                if(isMessageRecieved){
                    displayTheMessage(infos.get(0).message);
                }

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
            chatTextArea.append("\nError occurupted from sendTheInformationList");
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
        }

    }


    //Variables
    BorderLayout borderLayout;
    JPanel jpComponent;
    JMenuBar jMenuBar;
    JMenu exit;
    JMenuItem exitSubMenu;
    public static Component rootPane;
    public static ObjectOutputStream objectOutputStream;
    public static ObjectInputStream objectInputStream;
    public static String serve;
    public static Socket theStudent;
    public static ArrayList<Informations> infos = new ArrayList<>();
    public static String drawType = "Nothing";
    public static int minute, second;
    public static int n = 10000 + new Random().nextInt(90000); //Random id
    public static Timer timer;
    public static boolean flagForClock = true;
    public static ArrayList<Informations> messages = new ArrayList<>();
    public static Informations message = new Informations("message", "shapename");
    public static ArrayList<Informations> handInfos = new ArrayList<>();
    public static Informations handInfo = new Informations("Hand");
    public javax.swing.JLabel attandanceLabel;
    public static javax.swing.JTextArea attandanceTextArea;
    public static javax.swing.JTextArea chatTextArea;
    public javax.swing.JTextField chatTextField;
    public static javax.swing.JLabel minLabel;
    public static javax.swing.JLabel secLabel;
    public static javax.swing.JButton sendButton;
    public javax.swing.JLabel shapesLabel;
    public static javax.swing.JTextArea shapesTextArea;
    public javax.swing.JButton riseHand;
    public static boolean isMessageRecieved = false;

}
