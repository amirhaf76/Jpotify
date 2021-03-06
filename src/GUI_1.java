import Model.Jpotify;
import Model.User;
import storage.ReloadFile;
import storage.Storage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class GUI_1 {
    private Jpotify jpotify;
    public GUI_1() {
        JFrame Jpotify = new JFrame("Jpotify");
        Jpotify.setResizable(false);
        ImageIcon img = new ImageIcon("spotify (1).png");
        Jpotify.setIconImage(img.getImage());
        Jpotify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Jpotify.setLocation(700, 375);
        Jpotify.setLayout(new BorderLayout());
        JPanel start = new JPanel();
        start.setLayout(new BorderLayout());
        start.setBackground(new Color(51, 51, 51));
        JPanel panele = new JPanel();
        panele.setLayout(new BorderLayout());
        panele.setBackground(new Color(51, 51, 51));
        JPanel panelw = new JPanel();
        panelw.setLayout(new BorderLayout());
        panelw.setBackground(new Color(51, 51, 51));
        JPanel panels = new JPanel();
        panels.setLayout(new BorderLayout());
        panels.setBackground(new Color(51, 51, 51));
        JPanel panelc = new JPanel();
        panelc.setLayout(new BorderLayout());
        panelc.setBackground(new Color(51, 51, 51));
        JPanel panelcw = new JPanel();
        panelcw.setLayout(new BorderLayout());
        panelcw.setBackground(new Color(51, 51, 51));
        JPanel panelce = new JPanel();
        panelce.setLayout(new BorderLayout());
        panelce.setBackground(new Color(51, 51, 51));
        JPanel panelsc = new JPanel();
        panelsc.setLayout(new BorderLayout());
        panelsc.setBackground(new Color(51, 51, 51));
        JPanel panelsw = new JPanel();
        panelsw.setLayout(new BorderLayout());
        panelsw.setBackground(new Color(51, 51, 51));
        JPanel panelse = new JPanel();
        panelse.setLayout(new BorderLayout());
        panelse.setBackground(new Color(51, 51, 51));
        start.add(panelw, BorderLayout.WEST);
        JLabel a = new JLabel("Username:  ");
        a.setForeground(new Color(0, 204, 51));
        panelw.add(a, BorderLayout.NORTH);
        JLabel b = new JLabel("Password:  ");
        b.setForeground(new Color(0, 204, 51));
        panelw.add(b, BorderLayout.SOUTH);
        start.add(panelc, BorderLayout.CENTER);
        panelc.add(panelcw, BorderLayout.WEST);
        JTextField Userup = new JTextField();
        panelcw.add(Userup, BorderLayout.NORTH);
        JPasswordField Passup = new JPasswordField();
        Passup.setEchoChar('*');
        panelcw.add(Passup, BorderLayout.SOUTH);
        JLabel c = new JLabel("Username:  ");
        c.setForeground(new Color(0, 204, 51));
        panelce.add(c, BorderLayout.NORTH);
        JLabel d = new JLabel("Password:  ");
        d.setForeground(new Color(0, 204, 51));
        panelce.add(d, BorderLayout.SOUTH);
        JLabel J = new JLabel("Jpotify");
        J.setFont(new Font("Serif", Font.BOLD, 50));
        J.setForeground(new Color(0, 204, 51));
        J.setHorizontalAlignment(SwingConstants.CENTER);
        panelc.add(J, BorderLayout.CENTER);
        panelc.add(panelce, BorderLayout.EAST);
        start.add(panele, BorderLayout.EAST);
        JTextField Userin = new JTextField();
        panele.add(Userin, BorderLayout.NORTH);
        JPasswordField Passin = new JPasswordField();
        Passin.setEchoChar('*');
        panele.add(Passin, BorderLayout.SOUTH);
        start.add(panels, BorderLayout.SOUTH);
        panels.add(panelsc, BorderLayout.CENTER);
        JButton Signup = new JButton("Signup");
        Signup.setBackground(new Color(0, 204, 51));
        panelsc.add(Signup, BorderLayout.WEST);
        JButton Signin = new JButton("Signin");
        Signin.setBackground(new Color(0, 204, 51));
        panelsc.add(Signin, BorderLayout.EAST);
        panels.add(panelsw, BorderLayout.WEST);
        panelsw.add(new JLabel("                       "));
        panels.add(panelse, BorderLayout.EAST);
        panelse.add(new JLabel("    "));
        panelcw.add(new JLabel("                           "), BorderLayout.WEST);
        panele.add(new JLabel("                           "), BorderLayout.EAST);
        Jpotify.add(start);
        Jpotify.setVisible(true);
        Signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = Userin.getText();
                String password = new String(Passin.getPassword());
                name = name.trim();
                password = password.trim();

                for (User user :
                        jpotify.getUsers()) {
                    if ( user.getName().equals(name) ) {
                        if ( user.canPass(password) ) {

                            GUI_2 GUI_2 = new GUI_2(user,jpotify);
                            Jpotify.setVisible(false);
                        }
                        else{
                            Userin.setText("wrong pass");
                        }
                    }
                    else{
                        Userin.setText("invalid name");
                    }
                }
            }
        });
        Signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean same = false;
                try {
                    String name = Userup.getText();
                    String password = new String(Passup.getPassword());
                    name = name.trim();
                    password = password.trim();

                    if ( !name.equals("") && !password.equals("") ) {
                        User newUser = new User(name, password);
                        for (User user :
                                jpotify.getUsers()) {
                            same = user.equals(newUser);
                        }
                        if ( !same ) {

                            jpotify.addUser(newUser);
                            Storage.saveJpotify(jpotify);
                            GUI_2 GUI_2 = new GUI_2(newUser, jpotify);
                            Jpotify.setVisible(false);
                        } else {
                            Userup.setText("Name exists");
                        }
                    }
                    else{
                        Userup.setText("invalid input");
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        Jpotify.pack();
    }

    public void setJpotify(Jpotify jpotify) {
        this.jpotify = jpotify;
    }
}