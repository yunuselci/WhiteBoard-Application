package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ServerBoard extends JFrame implements ActionListener, MouseListener {

    public ServerBoard() { // constructor
        super("Teacher Screen");
        borderLayout = new BorderLayout();
        setLayout(borderLayout);
        theMenuBar();
        Components();
        attandanceFileCreate();
        clearTheAttandance();

        for (int minItems = 0; minItems < 60; minItems++) { // Add the numbers of combobox  heere
            if (minItems < 10) {
                minComboBox.addItem("0" + minItems);
            } else {
                minComboBox.addItem(minItems);
            }

        }
        for (int secItems = 0; secItems < 60; secItems++) {
            if (secItems < 10) {
                secComboBox.addItem("0" + secItems);
            } else {
                secComboBox.addItem(secItems);
            }
        }
    }

    public void theMenuBar() { //Menu bar is here
        jMenuBar = new JMenuBar();


        shape = new JMenu("Shape");
        clear = new JMenu("Clear");
        exit = new JMenu("Exit");


        squareSubMenu = new JMenuItem("Square");
        squareSubMenu.addActionListener(this);


        circleSubMenu = new JMenuItem("Circle");
        circleSubMenu.addActionListener(this);

        lineSubMenu = new JMenuItem("Line");
        lineSubMenu.addActionListener(this);

        clearSubMenu = new JMenuItem("Clear The Screen");
        clearSubMenu.addActionListener(this);

        exitSubMenu = new JMenuItem("Close App");
        exitSubMenu.addActionListener(this);


        shape.add(squareSubMenu);
        shape.add(circleSubMenu);
        shape.add(lineSubMenu);
        clear.add(clearSubMenu);
        exit.add(exitSubMenu);


        jMenuBar.add(shape);
        jMenuBar.add(clear);
        jMenuBar.add(exit);

        add(jMenuBar);
        setJMenuBar(jMenuBar);

    }

    public void Components() { //Gui is here
        jpComponent = new ServerPanel();
        jpComponent.addMouseListener(this);

        jpComponent.setBackground(new java.awt.Color(255, 255, 255));
        JScrollPane jScrollPane1 = new JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        buttonStart = new javax.swing.JButton();
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
        secComboBox = new javax.swing.JComboBox<>();
        minComboBox = new javax.swing.JComboBox();


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

        buttonStart.setText("START");
        buttonStart.addActionListener(evt -> btnStartActionPerformed());

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

        secComboBox.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 30)); // NOI18N
        secComboBox.addActionListener(evt -> cboxSecActionPerformed());

        minComboBox.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 30)); // NOI18N
        minComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMinActionPerformed();
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
                                        .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attandanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(shapesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane3)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(minLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(secLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                                .addComponent(minComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(secComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                                        .addComponent(secLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(secComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonStart)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        message.message = "Teacher: " + chatTextField.getText();
        chatTextArea.append("\n" + message.message);
        message.shapeName = "Msg";
        messages.add(message);
        sendTheInformationList(message.shapeName);
        chatTextField.setText("");
    }

    private void cboxMinActionPerformed() {
        minLabel.setText("" + minComboBox.getSelectedItem());
        minute = Integer.parseInt(minLabel.getText());
    }

    private void cboxSecActionPerformed() {
        secLabel.setText("" + secComboBox.getSelectedItem());
        second = Integer.parseInt(secLabel.getText());
    }

    private void btnStartActionPerformed() {

        time.min = minute;

        time.sec = second;

        time.shapeName = "Time";

        times.add(time);

        for (int i = 0; i < times.size(); i++) {
            sendTheInformationList("Time");
        }

        timer = new Timer(1000, e -> { //using actions like this is ide suggestion
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
            }
            else
                {

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

    private void attandanceFileCreate() {
        try {
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

    private void attandanceFileWrite() {
        try
        {
            Files.write(Paths.get("attandance.txt"), "Teacher\n".getBytes(), StandardOpenOption.APPEND);
            System.out.println("Wroted.");
        }
        catch (IOException e)
        {
            System.out.println("Error occurupted.Stack tree is: ");
            e.printStackTrace();
        }
    }

    private void readAttandance() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(
                    "attandance.txt"));
            String readLine = bufferedReader.readLine();
            while (readLine != null)
            {
                attandanceTextArea.append(readLine + "\n");
                readLine = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void clearTheAttandance() {
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

    public static void writeShapeCounter(int numberOfShapes) {
        if (numberOfShapes <= 1) {
            shapesTextArea.setText(numberOfShapes + " " + drawType + " is drawed");
        } else {
            shapesTextArea.setText(numberOfShapes + " " + drawType + " are drawed");
        }

    }

    public void startTheServer() {
        try {
            sendButton.setEnabled(false);
            buttonStart.setEnabled(false);
            serverSocket = new ServerSocket(12345, 100);
            while (true)
            {
                try
                {
                    listenTheConnection();
                    establishTheConnection();
                    serverListenTheConnection();
                }
                catch (EOFException e)
                {
                    displayTheMessage("\nServer Terminated Conn\n");
                }
                finally
                {
                    terminateTheConnection();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void listenTheConnection() throws IOException {
        displayTheMessage("Waiting the Connection...\n");
        socket = serverSocket.accept();
        displayTheMessage("Connection Received\n");
    }

    public void establishTheConnection() throws IOException {
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.flush();

        objectInputStream = new ObjectInputStream(socket.getInputStream());
        displayTheMessage("\nChat Activated.\n");
        attandanceFileWrite();
        displayTheMessage("Teacher has been processed to attandance file\n");
    }

    public void serverListenTheConnection() throws IOException {
        sendButtonEnabler(true);
        readAttandance();

        do {
            try {
                infos = (ArrayList<Informations>) objectInputStream.readObject();
                for (Informations info : infos) {
                    if (info.shapeName.equals("Msg")) {
                        isMessageRecieved = true;
                        isRaiseHand = false;
                    } else if (info.shapeName.equals("Hand")) {
                        isRaiseHand = true;
                        isMessageRecieved = false;
                    }
                }
                if (isMessageRecieved) {
                    isRaiseHand = false;
                    displayTheMessage(infos.get(0).message);
                }
                if (isRaiseHand) {
                    isMessageRecieved = false;
                    JOptionPane.showMessageDialog(rootPane, "Student raised his/her hand", "Hand", JOptionPane.INFORMATION_MESSAGE);

                }

            } catch (ClassNotFoundException e) {
                displayTheMessage("Unknown");
            }
        } while (true);
    }

    public static void sendTheInformationList(String shapeName) {
        try {

            switch (shapeName) {
                case "Square":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(square);
                    objectOutputStream.flush();
                    break;
                case "FSquare":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(FSquare);
                    objectOutputStream.flush();
                    break;
                case "FCircle":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(FCircle);
                    objectOutputStream.flush();
                    break;
                case "Circle":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(circle);
                    objectOutputStream.flush();
                    break;
                case "Line":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(line);
                    objectOutputStream.flush();
                    break;
                case "MSquare":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(squares);
                    objectOutputStream.flush();
                    break;
                case "MCircle":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(circles);
                    objectOutputStream.flush();
                    break;
                case "Clear":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(clears);
                    objectOutputStream.flush();
                    break;
                case "Time":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(times);
                    objectOutputStream.flush();
                    break;
                case "Msg":
                    objectOutputStream.reset();
                    objectOutputStream.writeObject(messages);
                    objectOutputStream.flush();
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void terminateTheConnection() {

        displayTheMessage("\nTerminating Conn\n");
        sendButtonEnabler(false);

        try
        {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void displayTheMessage(final String string) {
        chatTextArea.append("\n" + string);
    }

    public void sendButtonEnabler(final boolean b) {
        SwingUtilities.invokeLater(() -> buttonStart.setEnabled(b));
        SwingUtilities.invokeLater(() -> sendButton.setEnabled(b));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        switch (drawType) {
            case "Square":
                squareInformations.x = e.getX();
                squareInformations.y = e.getY();
                squareInformations.shapeName = "Square";
                square.add(squareInformations);
                break;
            case "Circle":
                circleInformations.x = e.getX();
                circleInformations.y = e.getY();
                circleInformations.shapeName = "Circle";
                circle.add(circleInformations);

                break;
            case "FSquare":
                FSquareInformations.x = e.getX();
                FSquareInformations.y = e.getY();
                FSquareInformations.shapeName = "FSquare";
                FSquare.add(FSquareInformations);
                break;
            case "FCircle":
                FCircleInformations.x = e.getX();
                FCircleInformations.y = e.getY();
                FCircleInformations.shapeName = "FCircle";
                FCircle.add(FCircleInformations);
                break;
            case "MSquare": {
                Informations points = new Informations(x, y);
                points.x = e.getX();
                points.y = e.getY();
                points.shapeName = "MSquare";
                circles.clear();
                squares.add(points);
                break;
            }
            case "MCircle": {
                Informations points = new Informations(x, y);
                points.x = e.getX();
                points.y = e.getY();
                points.shapeName = "MCircle";
                squares.clear();
                circles.add(points);
                break;
            }
            case "Clear": {
                Informations points = new Informations(x, y);
                points.x = 100;
                points.y = 100;
                points.shapeName = "Clear";
                //square.clear();-make bugs
                squares.clear();
                //line.clear();-make bugs
                //circle.clear();-make bugs
                circles.clear();
                //FSquare.clear();-make bugs
                //FCircle.clear();-make bugs
                clears.add(points);
                break;
            }
        }
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (drawType.equals("Line")) {
            points.x1 = x2 = e.getX();
            points.y1 = y2 = e.getY();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (drawType.equals("Line")) {
            points.x2 = e.getX();
            points.y2 = e.getY();
            points.shapeName = "Line";
            line.add(points);

            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lineSubMenu) {
            drawType = "Line";
        } else if (e.getSource() == squareSubMenu) {
            drawType = "Square";
            typeForSquare = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter\n1- Square"+
                    "\n2- Fill Square" + "\n3- Multiple Square" ));
            if (typeForSquare == 1) {
                drawType = "Square";
            } else if(typeForSquare == 2) {
                drawType = "FSquare";
            } else if(typeForSquare == 3) {
                drawType = "MSquare";
            } else{
                JOptionPane.showMessageDialog(this,"Invalid value entered","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Now Click Center Panel for Creating a Square");
        }  else if (e.getSource() == circleSubMenu) {
            drawType = "Circle";
            typeForCircle = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter\n1- Circle"+
                    "\n2- Fill Circle" + "\n3- Multiple Circle"));
            if (typeForCircle == 1) {
                drawType = "Circle";
            } else if(typeForCircle == 2) {
                drawType = "FCircle";
            } else if(typeForCircle == 3){
                drawType = "MCircle";
            }else{
                JOptionPane.showMessageDialog(this,"Invalid value entered","Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Now Click Center Panel for Creating a Circle");
        } else if (e.getSource() == clearSubMenu) {
            drawType = "Clear";
            JOptionPane.showMessageDialog(this, "Now Click Center Panel for Clear The Screen");

        } else if (e.getSource() == exitSubMenu) {
            System.exit(0);
        }

    }

    //Variables
    Timer timer;
    BorderLayout borderLayout;
    JPanel jpComponent;
    JMenuBar jMenuBar;
    JMenu shape, clear, exit;
    JMenuItem lineSubMenu, squareSubMenu, circleSubMenu, clearSubMenu, exitSubMenu;
    public static int minute, second;
    protected static int x, x1, x2;
    protected static int y, y1, y2;
    public static int typeForSquare = 0;
    public static int typeForCircle = 0;
    boolean flagForClock = true;
    public boolean isMessageRecieved = false;
    public boolean isRaiseHand = false;
    public static String drawType = "Empty";
    public static ObjectOutputStream objectOutputStream;
    public static ObjectInputStream objectInputStream;
    public static ServerSocket serverSocket;
    public static Socket socket;
    public static ArrayList<Informations> infos = new ArrayList<>();
    public static ArrayList<Informations> line = new ArrayList<>();
    public static ArrayList<Informations> square = new ArrayList<>();
    public static ArrayList<Informations> FSquare = new ArrayList<>();
    public static ArrayList<Informations> circle = new ArrayList<>();
    public static ArrayList<Informations> FCircle = new ArrayList<>();
    public static ArrayList<Informations> squares = new ArrayList<>();
    public static ArrayList<Informations> circles = new ArrayList<>();
    public static ArrayList<Informations> clears = new ArrayList<>();
    public static ArrayList<Informations> times = new ArrayList<>();
    public static ArrayList<Informations> messages = new ArrayList<>();
    public static Informations message = new Informations("message", "shapename");
    public static Informations time = new Informations(minute, second, "time");
    public static Informations squareInformations = new Informations(x, y);
    public static Informations FSquareInformations = new Informations(x, y);
    public static Informations circleInformations = new Informations(x, y);
    public static Informations FCircleInformations = new Informations(x, y);
    public static Informations points = new Informations(x1, x2, y1, y2);
    public javax.swing.JLabel attandanceLabel;
    public javax.swing.JTextArea attandanceTextArea;
    public javax.swing.JButton buttonStart;
    public javax.swing.JComboBox minComboBox;
    public javax.swing.JComboBox secComboBox;
    public static javax.swing.JTextArea chatTextArea;
    public javax.swing.JTextField chatTextField;
    public javax.swing.JLabel minLabel;
    public javax.swing.JLabel secLabel;
    public javax.swing.JButton sendButton;
    public javax.swing.JLabel shapesLabel;
    static public javax.swing.JTextArea shapesTextArea;
    //End
}


