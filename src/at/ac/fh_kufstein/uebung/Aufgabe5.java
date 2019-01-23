package at.ac.fh_kufstein.uebung;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Aufgabe5 {
    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Zahl bitte"));

        File f = new File("C:\\Users\\Magda\\Documents\\FH Kufstein\\Aufgabe5.txt");
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            //in Datei schreiben
            bw = new BufferedWriter(new FileWriter(f));

            for(int i = 0; i<50;i++){
                Random rnd = new Random();
                int number = rnd.nextInt(5);
                bw.write(number + System.lineSeparator());
            }

            //aus Datein rauslesen und in ArrayListe speichern
            br = new BufferedReader(new FileReader(f));

            ArrayList<String> numbers = new ArrayList<>();

            int i=0;
            String zeile;
            while((zeile = br.readLine()) != null){
                numbers.add(zeile);
            }

            int count = 0;
            for(String s : numbers){
                if(s.contains(String.valueOf(n)))
                    count++;
            }



            System.out.println("Die Zahl wurde "+ count+" mal ausgegeben");

        }catch (IOException e){

        }finally {
            try{
                if(bw!=null)
                    bw.close();
            }catch (IOException ioEx){
                ioEx.printStackTrace();
            }
            try{
                if(br!=null)
                    bw.close();
            }catch (IOException ioEx){
                ioEx.printStackTrace();
            }
        }
    }
}
