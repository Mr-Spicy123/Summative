package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterCodeFrame {

  JFrame enterCodeFrame = new JFrame();
  Font font = new Font("Ariel", Font.BOLD, 175);
  ActionListener listener;
  JTextField code = new JTextField();

  public EnterCodeFrame(final VerificationCode v, String to) {

    listener = new ActionListener() {

      VerificationCode veri = v;

      @Override
      public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
          JButton button = (JButton) source;
          String currentItem = "";
          switch (button.getText()) {
            case "back":
              new verificationFrame();
              enterCodeFrame.setVisible(false);
              break;
            case "enter":
              if (code.getText().toLowerCase().equals(veri.getCode())) {
                new ChangePasswordFrame();
                enterCodeFrame.setVisible(false);
              } else {
                JOptionPane.showMessageDialog(null, "Incorrect code");
              }
              break;
            case "resend":
              veri = new VerificationCode();
              String correctCode = veri.getCode();
              AppOpener.openGmail();
              SendEmail.send(to, "Spice-E-Store Verification", "Here is your verification code: " + correctCode.toUpperCase());
          }
        }
      }
    };


    ImageIcon enterCodeFrameImg = ImageIconScaler.scaleImageIcon(new ImageIcon("frameDesigns/enterCodeFrame.png"), 1536, 864);
    JLabel enterCodeFrameImgLabel = new JLabel(enterCodeFrameImg);

    JPanel backgroundPanel = new JPanel();
    SwingSetup.setupPanel(backgroundPanel, enterCodeFrameImgLabel, 0, 0, 1536, 864);

    JPanel objectPanel = new JPanel();
    SwingSetup.setupPanel(objectPanel, 0, 0, 1536, 864, null, false);

    JButton backButton = new JButton("back");
    SwingSetup.setupButton(backButton, objectPanel, 20, 10, 200, 100, false, false);
    backButton.addActionListener(listener);

    JButton enterButton = new JButton("enter");
    SwingSetup.setupButton(enterButton, objectPanel, 990, 350, 475, 175, false, false);
    enterButton.addActionListener(listener);

    JButton resendButton = new JButton("resend");
    SwingSetup.setupButton(resendButton, objectPanel, 500, 735, 550, 90, false, false);
    resendButton.addActionListener(listener);

    code = new

            JTextField();
    SwingSetup.setupTextField(code, objectPanel, 150, 350, 735, 160, true);
    code.setFont(font);

    SwingSetup.setupFrame(enterCodeFrame, 0, 0, 1536, 864, false, null);

    enterCodeFrame.add(backgroundPanel);
    enterCodeFrame.add(objectPanel);
    enterCodeFrame.setVisible(true);


  }
}
