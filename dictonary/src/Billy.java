import java.io.*;
import java.util.Scanner;

public class Billy
{

    private String[] vokabeln;
    private String[] bedeutungen;

    private Billy()
    {
        System.out.println("Hallo mein Name ist Billy. Ich bin dein Vokabel Trainer");
    }

    private void run()
    {
        this.showHelp();

        String vokabel;
        String bedeutung;
        int index;

        while (true) {
            int auswahl = this.leseAuswahl();

            if (auswahl == 1) {
               this.vokabelnLernen();
               System.out.println();
               this.showHelp();
            } else if (auswahl == 2) {
                this.vokabelnEingeben();
                this.showHelp();
            } else if (auswahl == 3) {
                System.out.println("Oh du willst schon gehen? Schade. Dann bis zum nächsten Mal!");
                System.exit(0);
            } else {
                System.out.println("Ich habe dich leider nicht verstanden. Was willst du als nächstes tun?");
                this.showHelp();
            }

            System.out.println();
        }
    }

    private void vokabelnLernen()
    {
        if (this.vokabeln == null) {
            System.out.println("Du hast doch noch gar keine Vokabeln. Gib bitte erstmal welche ein");
            this.showHelp();
            return;
        }
        System.out.println("Ok legen wir los!");

        for (int i = 0; i < this.vokabeln.length; i++) {
            System.out.println("Was bedeutet: " + this.vokabeln[i]);

            String antwort = this.leseText();

            if (this.bedeutungen[i].toLowerCase().equals(antwort.toLowerCase())) {
                System.out.println("Richtig. Du bist spitze!");
            } else {
                System.out.println("Leider nicht richtig. Es bedeutet: " + this.bedeutungen[i]);
            }
        }
    }

    private void vokabelnEingeben()
    {
        String vokabel;
        String bedeutung;
        System.out.println("Wieviele Vokabeln möchtest du eingeben?");

        int anzahl = this.leseAuswahl();

        this.vokabeln = new String[anzahl];
        this.bedeutungen = new String[anzahl];

        for (int i = 0; i < anzahl; i++) {
            System.out.println("Gib die Vokabel ein die ich lernen soll");
            vokabel = this.leseText();

            System.out.println("Gib die Bedeutung für die Vokabel ein");
            bedeutung = this.leseText();

            this.vokabeln[i] = vokabel;
            this.bedeutungen[i] = bedeutung;
        }
    }

    private String leseText()
    {
        Scanner sc = new Scanner(System.in);
        return sc.next().trim();
    }

    private int leseAuswahl()
    {
        int auswahl;

        Scanner sc = new Scanner(System.in);
        auswahl = sc.nextInt();

        return auswahl;
    }

    private void showHelp()
    {
        System.out.println("Was möchtest du als nächstes tun?");

        System.out.println("1 - Vokabeln lernen");
        System.out.println("2 - Vokabeln eingeben");
        System.out.println("3 - Beenden");
    }

    public static void main (String[] args)
    {
        Billy b = new Billy();
        b.run();
    }
}
