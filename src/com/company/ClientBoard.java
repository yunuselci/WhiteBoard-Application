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

    JPanel jbCenter;
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
        jbCenter = new ClientPanel();
        jbCenter.setBackground(Color.white);
        add(jbCenter, BorderLayout.CENTER);
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

}
