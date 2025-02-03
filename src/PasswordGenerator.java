import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGenerator extends JFrame{
    private Generator Generator;
    public PasswordGenerator(){
        super("Password Generator ");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Generator = new Generator();

        addGuiComponents();
    }
    private void addGuiComponents() {
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 39);

        add(titleLabel);

        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 480, 70);

        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        JLabel passwordLengthLabel = new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Dialog",Font.BOLD,32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont( new Font("Dialog",Font.PLAIN,32));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);
// for UpperCase
        JToggleButton uppercaseToggle = new JToggleButton("UpperCase");
        uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);
// for Lowercase
        JToggleButton lowercaseToggle = new JToggleButton("LowerCase");
        lowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);
// for Numbers
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);
// for Symbols
        JToggleButton symbolsTOggle = new JToggleButton("Symbols");
        symbolsTOggle.setFont(new Font("Dialog",Font.PLAIN,26));
        symbolsTOggle.setBounds(282,373,225,56);
        add(symbolsTOggle);

        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,26));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordLengthInputArea.getText().length() <=0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected()||
                        uppercaseToggle.isSelected() || numbersToggle.isSelected() || symbolsTOggle.isSelected();

                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatedPassword = Generator.generatePassword(passwordLength,uppercaseToggle.isSelected(),lowercaseToggle.isSelected(),numbersToggle.isSelected(),symbolsTOggle.isSelected());
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}
