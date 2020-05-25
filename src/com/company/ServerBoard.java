package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ServerBoard extends JFrame implements ActionListener,
        KeyListener,
        MouseListener,
        MouseMotionListener {

    public static int min,sec;
    Timer timer;
    boolean flag_for_clock = true;

    public ServerBoard() {
        super("Teacher Screen");
        bl = new BorderLayout();
        setLayout(bl);
        menu();
        Components();

        for (int i = 0; i < 60; i++) {
            if(i<10){
                cboxMin.addItem("0"+i);
            }else{
                cboxMin.addItem(i);
            }

        }
        for (int i = 0; i < 60; i++) {
            if(i<10){
                cboxSec.addItem("0"+i);
            }else{
                cboxSec.addItem(i);
            }
        }
    }



    public void menu() {
        jmb = new JMenuBar();

        color_m = new JMenu("Color");
        shape = new JMenu("Shape");
        clear = new JMenu("Clear");
        exit = new JMenu("Exit");

        color_sbm = new JMenuItem("Color Chooser");
        color_sbm.addActionListener(this);

        square_sbm = new JMenuItem("Square");
        square_sbm.addActionListener(this);

        msquare_sbm = new JMenuItem("Multiple Square");
        msquare_sbm.addActionListener(this);

        circle_sbm = new JMenuItem("Circle");
        circle_sbm.addActionListener(this);

        mcircle_sbm = new JMenuItem("Multiple Circle");
        mcircle_sbm.addActionListener(this);

        line_sbm = new JMenuItem("Line");
        line_sbm.addActionListener(this);

        clear_sbm = new JMenuItem("Clear The Screen");
        clear_sbm.addActionListener(this);

        exit_sbm = new JMenuItem("Close App");
        exit_sbm.addActionListener(this);

        addKeyListener(this);

        color_m.add(color_sbm);
        shape.add(square_sbm);
        shape.add(msquare_sbm);
        shape.add(circle_sbm);
        shape.add(mcircle_sbm);
        shape.add(line_sbm);
        clear.add(clear_sbm);
        exit.add(exit_sbm);


        jmb.add(color_m);
        jmb.add(shape);
        jmb.add(clear);
        jmb.add(exit);

        add(jmb);
        setJMenuBar(jmb);

    }

    public void Components() {
        jpComponent = new ServerPanel();
        jpComponent.addMouseListener(this);
        jpComponent.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
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
        cboxSec = new javax.swing.JComboBox<>();
        cboxMin = new javax.swing.JComboBox();



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

        btnStart.setText("START");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
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

        cboxSec.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        cboxSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxSecActionPerformed(evt);
            }
        });

        cboxMin.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        cboxMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMinActionPerformed(evt);
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
                                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attandanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(shapesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane3)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lblMin)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblSec)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                                .addComponent(cboxMin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cboxSec, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cboxSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cboxMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnStart)
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

    private void cboxMinActionPerformed(java.awt.event.ActionEvent evt) {
        lblMin.setText(""+cboxMin.getSelectedItem());
        min = Integer.parseInt(lblMin.getText());
    }

    private void cboxSecActionPerformed(java.awt.event.ActionEvent evt) {
        lblSec.setText(""+cboxSec.getSelectedItem());
        sec = Integer.parseInt(lblSec.getText());
    }

    private void chatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        time.min=min;
        time.sec=sec;
        time.shapeName="Time";
        times.add(time);
        for (int i = 0; i < times.size(); i++) {
            sendList("Time");
        }

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblMin.setForeground(Color.black);
                lblSec.setForeground(Color.black);

                if(sec == 0){
                    sec=60;
                    min--;
                }
                if(min ==0){
                    lblMin.setForeground(Color.red);
                    lblSec.setForeground(Color.red);

                }
                if(min <0){
                    JOptionPane.showMessageDialog(rootPane,"Time is Over","Stopped",0);
                    min=0;sec=0;
                    timer.stop();
                }else{

                    sec--;
                    if(sec<10){
                        lblSec.setText("0"+sec);
                        flag_for_clock = false;
                    }
                    if(min<10){
                        lblMin.setText("0"+min);
                        if(sec<10){
                            lblSec.setText("0"+sec);
                        }else{
                            lblSec.setText(""+sec);
                        }
                        flag_for_clock=false;
                    }
                    if(flag_for_clock){
                        lblMin.setText(""+min);
                        lblSec.setText(""+sec);
                    }

                }


            }
        });
        timer.start();
    }

    public static void writeShapeCounter(int numberOfShapes){
        if(numberOfShapes<=1){
            shapesTextArea.setText(numberOfShapes + " " + draw_type +" is drawed");

        }else{
            shapesTextArea.setText(numberOfShapes +" "+ draw_type +" are drawed");

        }

    }

    public void runServer() {
        try {
            server = new ServerSocket(12345, 100);

            while (true) {
                try {
                    waitConn();
                    streams();
                    processConn();
                } catch (EOFException e) {
                    dispMessage("\nServer Terminated Conn\n");
                } finally {
                    closeConn();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitConn() throws IOException {
        dispMessage("Please Wait...\n");
        conn = server.accept();
        dispMessage("Connection Received\n");
    }

    public void streams() throws IOException {
        oos = new ObjectOutputStream(conn.getOutputStream());
        oos.flush();

        ois = new ObjectInputStream(conn.getInputStream());
        dispMessage("\nStreams\n");
    }

    public void processConn() throws IOException {
        //send("Successful");

        System.out.println("successfull");

        //setButtonEnabled(true);
        String msg = "";

        do {
            try {
                msg = (String) ois.readObject();
                dispMessage("\n" + msg);
            } catch (ClassNotFoundException e) {
                dispMessage("Unknown");
            }
        } while (!msg.equals("C:ExitTheSystem"));
    }

    public void closeConn() {
        dispMessage("\nTerminating Conn\n");
        setButtonEnabled(false);

        try {
            oos.close();
            ois.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendList(String shapeName) {
        try {

            switch (shapeName) {
                case "Square":
                    oos.reset();
                    oos.writeObject(square);
                    oos.flush();
                    break;
                case "FSquare":
                    oos.reset();
                    oos.writeObject(FSquare);
                    oos.flush();
                    break;
                case "FCircle":
                    oos.reset();
                    oos.writeObject(FCircle);
                    oos.flush();
                    break;
                case "Circle":
                    oos.reset();
                    oos.writeObject(circle);
                    oos.flush();
                    break;
                case "Line":
                    oos.reset();
                    oos.writeObject(line);
                    oos.flush();
                    break;
                case "MSquare":
                    oos.reset();
                    oos.writeObject(squares);
                    oos.flush();
                    break;
                case "MCircle":
                    oos.reset();
                    oos.writeObject(circles);
                    oos.flush();
                    break;
                case "Clear":
                    oos.reset();
                    oos.writeObject(clears);
                    oos.flush();
                    break;
                case "Time":
                    oos.reset();
                    oos.writeObject(times);
                    oos.flush();
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void dispMessage(final String string) {
        System.out.println(string);
    }

    public void setButtonEnabled(final boolean b) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //jbSend.setEnabled(b);

            }
        });
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        switch (draw_type) {
            case "Square":
                squarePoints.x = e.getX();
                squarePoints.y = e.getY();
                squarePoints.shapeName = "Square";
                square.add(squarePoints);
                break;
            case "Circle":
                circlePoints.x = e.getX();
                circlePoints.y = e.getY();
                circlePoints.shapeName = "Circle";
                circle.add(circlePoints);

                break;
            case "FSquare":
                FSquarePoints.x = e.getX();
                FSquarePoints.y = e.getY();
                FSquarePoints.shapeName = "FSquare";
                FSquare.add(FSquarePoints);
                break;
            case "FCircle":
                FCirclePoints.x = e.getX();
                FCirclePoints.y = e.getY();
                FCirclePoints.shapeName = "FCircle";
                FCircle.add(FCirclePoints);
                break;
            case "MSquare": {
                Points p = new Points(x, y);
                p.x = e.getX();
                p.y = e.getY();
                p.shapeName = "MSquare";
                circles.clear();
                squares.add(p);
                break;
            }
            case "MCircle": {
                Points p = new Points(x, y);
                p.x = e.getX();
                p.y = e.getY();
                p.shapeName = "MCircle";
                squares.clear();
                circles.add(p);
                break;
            }
            case "Clear": {
                Points p = new Points(x, y);
                p.x = 100;
                p.y = 100;
                p.shapeName = "Clear";
                square.clear();
                squares.clear();
                line.clear();
                circle.clear();
                circles.clear();
                FSquare.clear();
                FCircle.clear();
                clears.add(p);
                break;
            }
        }
        repaint();

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (draw_type.equals("Line")) {
            p.x1 = x2 = e.getX();
            p.y1 = y2 = e.getY();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (draw_type.equals("Line")) {
            p.x2 = e.getX();
            p.y2 = e.getY();
            p.shapeName = "Line";
            line.add(p);

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
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == color_sbm) {

            c = JColorChooser.showDialog(this, "Choose Color", Color.red);
            repaint();
        } else if (e.getSource() == line_sbm) {
            draw_type = "Line";
        } else if (e.getSource() == square_sbm) {
            draw_type = "Square";
            type_for_square = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter\n1- Square\n2- Fill Square"));
            if (type_for_square == 2) {
                draw_type = "FSquare";
            } else {
                draw_type = "Square";
            }
            JOptionPane.showMessageDialog(this, "Now Click Center Panel for Creating a Square");
        } else if (e.getSource() == msquare_sbm) {
            draw_type = "MSquare";
        } else if (e.getSource() == circle_sbm) {
            draw_type = "Circle";
            type_for_circle = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter\n1- Circle\n2- Fill Circle"));
            if (type_for_circle == 2) {
                draw_type = "FCircle";
            } else {
                draw_type = "Circle";
            }
            JOptionPane.showMessageDialog(this, "Now Click Center Panel for Creating a Circle");
        } else if (e.getSource() == mcircle_sbm) {
            draw_type = "MCircle";
        } else if (e.getSource() == clear_sbm) {
            draw_type = "Clear";
            JOptionPane.showMessageDialog(this, "Now Click Center Panel for Clear The Screen");

        } else if (e.getSource() == exit_sbm) {
            System.exit(0);
        }

    }

    BorderLayout bl;
    protected static Color c;
    protected static int x, x1, x2;
    protected static int y, y1, y2;
    public static String draw_type = "Empty";
    public static int type_for_square = 0;
    public static int type_for_circle = 0;
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    public static ServerSocket server;
    public static Socket conn;
    public static ArrayList<Points> line = new ArrayList<>();
    public static ArrayList<Points> square = new ArrayList<>();
    public static ArrayList<Points> FSquare = new ArrayList<>();
    public static ArrayList<Points> circle = new ArrayList<>();
    public static ArrayList<Points> FCircle = new ArrayList<>();
    public static ArrayList<Points> squares = new ArrayList<>();
    public static ArrayList<Points> circles = new ArrayList<>();
    public static ArrayList<Points> clears = new ArrayList<>();
    public static ArrayList<Points> times = new ArrayList<>();
    public static Points time=new Points(min,sec,"time");
    public static Points squarePoints = new Points(x, y);
    public static Points FSquarePoints = new Points(x, y);
    public static Points circlePoints = new Points(x, y);
    public static Points FCirclePoints = new Points(x, y);
    public static Points p = new Points(x1, x2, y1, y2);
    JPanel jpComponent;
    JMenuBar jmb;
    JMenu color_m, shape, clear, exit;
    JMenuItem color_sbm, line_sbm, square_sbm, msquare_sbm, circle_sbm, mcircle_sbm, clear_sbm, exit_sbm;
    public javax.swing.JLabel attandanceLabel;
    public javax.swing.JTextArea attandanceTextArea;
    public javax.swing.JButton btnStart;
    public javax.swing.JComboBox cboxMin;
    public javax.swing.JComboBox cboxSec;
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
    static public javax.swing.JTextArea shapesTextArea;

}


