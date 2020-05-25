package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerBoard extends JFrame implements ActionListener,
        KeyListener,
        MouseListener,
MouseMotionListener{


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
    public static Points squarePoints = new Points(x, y);
    public static Points FSquarePoints = new Points(x, y);
    public static Points circlePoints = new Points(x, y);
    public static Points FCirclePoints = new Points(x, y);
    public static Points p = new Points(x1,x2,y1,y2);


    public ServerBoard() {
        super("Teacher Screen");
        bl = new BorderLayout();
        setLayout(bl);
        menu();
        center();

    }

    JPanel jpCenter;
    JMenuBar jmb;
    JMenu color_m, shape, clear, exit;
    JMenuItem color_sbm, line_sbm, square_sbm, msquare_sbm, circle_sbm, mcircle_sbm, clear_sbm, exit_sbm;

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

    public void center() {
        jpCenter = new ServerPanel();
        jpCenter.addMouseListener(this);
        jpCenter.setBackground(Color.white);

        add(jpCenter, BorderLayout.CENTER);

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
                squarePoints.counter += 1;
                square.add(squarePoints);
                break;
            case "Circle":
                circlePoints.x = e.getX();
                circlePoints.y = e.getY();
                circlePoints.shapeName = "Circle";
                circlePoints.counter += 1;
                circle.add(circlePoints);

                break;
            case "FSquare":
                FSquarePoints.x = e.getX();
                FSquarePoints.y = e.getY();
                FSquarePoints.shapeName = "FSquare";
                FSquarePoints.counter += 1;
                FSquare.add(FSquarePoints);
                break;
            case "FCircle":
                FCirclePoints.x = e.getX();
                FCirclePoints.y = e.getY();
                FCirclePoints.shapeName = "FCircle";
                FCirclePoints.counter += 1;
                FCircle.add(FCirclePoints);
                break;
            case "MSquare": {
                Points p = new Points(x, y);
                p.x = e.getX();
                p.y = e.getY();
                p.shapeName = "MSquare";
                p.counter += 1;
                circles.clear();
                squares.add(p);
                break;
            }
            case "MCircle": {
                Points p = new Points(x, y);
                p.x = e.getX();
                p.y = e.getY();
                p.shapeName = "MCircle";
                p.counter += 1;
                squares.clear();
                circles.add(p);
                break;
            }
            case "Clear": {
                Points p = new Points(x, y);
                p.x = 100;
                p.y = 100;
                p.shapeName = "Clear";
                p.counter = 0;
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
        if(draw_type.equals("Line")){
            p.x1 =x2 =e.getX();
            p.y1 =y2= e.getY();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(draw_type.equals("Line")){
            p.x2=e.getX();
            p.y2=e.getY();
            p.shapeName = "Line";
            p.counter += 1;
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
        }  else if (e.getSource() == square_sbm) {
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



}


