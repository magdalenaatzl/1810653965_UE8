package at.ac.fh_kufstein.uebung;

import javax.swing.*;

public class Aufruf {
    public static void main(String[] args) {
        Authentication authentication = new Authentication();
        Log logger = new Log();

        int eingabe = JOptionPane.showConfirmDialog(null, "Sind Sie bereits ein User?","User", JOptionPane.YES_NO_OPTION);

        //Login
        if(eingabe==0){
            String user = JOptionPane.showInputDialog("Wie lautet dein Benutzername?");
            String pw = JOptionPane.showInputDialog("Wie lautet dein Passwort?");
            crypter(pw);
            if (authentication.login(user) != null) {
                if (crypter(authentication.login(user)).equals(pw)) {
                    secret();
                    logger.logs(user, pw, true);
                }

                else {
                    JOptionPane.showMessageDialog(null, "falsches Passwort");
                    logger.logs(user, pw, false);
                }
            }
        }
        //Register
        if(eingabe==1) {
            String _user = JOptionPane.showInputDialog("Wie soll ihr Username lauten?");
            String _pw = JOptionPane.showInputDialog("Wie soll ihr Passwort lauten?");
            authentication.register(_user, _pw);
            JOptionPane.showMessageDialog(null, "Geschafft! Du bist jetzt ein neuer User");
        }

        System.out.println(logger.failedLogIn());

    }

    private static void secret(){
        JOptionPane.showMessageDialog(null, "Geheimnis: \nDas war nicht leicht");

    }
    public static String crypter (String value) {
        char[] values = value.toCharArray();
        //einen String in ein Array mit Werten der einzelnen Zeichen umwandeln

        for (int i = 0; i < values.length; i++) {
            char letter = values[i];

            if (letter >= 'a' && letter <= 'z') {
                if (letter > 'm') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            } else if (letter >= 'A' && letter <= 'Z') {
                if (letter > 'M') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            }
            values[i] = letter;
        }
        return new String(values); // Array wieder in String umwandeln
    }
}






