import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginRegisterPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginRegisterPage() {
        setTitle("Login/Register App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (DatabaseConnector.login(username, password)) {
                    JOptionPane.showMessageDialog(LoginRegisterPage.this, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginRegisterPage.this, "Login Failed. Invalid username or password.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (DatabaseConnector.register(username, password)) {
                    JOptionPane.showMessageDialog(LoginRegisterPage.this, "Registration Successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginRegisterPage.this, "Registration Failed. Please try again.");
                }
            }
        });
        add(panel);
        setVisible(true);
    }

    private void login(String username, String password) {
        // Burada login işlemleri gerçekleştirilebilir
        JOptionPane.showMessageDialog(this, "Login Successful!");
    }

    private void register(String username, String password) {
        // Burada register işlemleri gerçekleştirilebilir
        JOptionPane.showMessageDialog(this, "Registration Successful!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginRegisterPage();
            }
        });
    }
}
