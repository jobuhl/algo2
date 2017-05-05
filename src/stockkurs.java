import java.util.Arrays;

/**
 * Created by Rackenrotz on 16.10.15.
 */
public class stockkurs {

    // Initialisiert die array länge
    int n;

    //Array mit den Kursveränderungen
    double[] array;

    //Array mit den Tageskursen
    StockTick[] array2;

    public stockkurs(int n) {
        this.n = n;

        //Liste die den Startkurs und die Kursveränderungen enthält
        array = new double[this.n];

        //Liste die alle Tageskurse enthält
        array2 = new StockTick[array.length];


    }


    //Methode die das Aufgabenbeispiel implementiert
    public void example() {
        array[0] = 127.5;
        array[1] = -0.5;
        array[2] = 2;
        array[3] = -1;
        array[4] = 1;
        array[5] = 3.5;
        array[6] = -13;
        array[7] = 7;
        array[8] = -2;
        array[9] = -6;
        array[10] = -9;
        array[11] = -21;
        array[12] = -17;
        array[13] = -5;
        array[14] = 0.5;
        array[15] = 4;
        array[16] = -7;
        array[17] = -12;
        array[18] = 2.5;
        array[19] = -3;
        // array[20] = 2;]letzter Eintrag fehlt aus bequemlichkeits Gründen

        fill();
    }


    //Standartimplementation
    public void random() {
        array[0] = Math.random();
        for (int i = 1; i < array.length; i++) {
            array[i] = (Math.random() * 600) - 300;

        }

        //Aufruf der Privaten Methode die array2 füllt
        fill();
    }

    // Methode für Zufallszahlen die für die weitere aufgabe gestellt wird
    public void randomScenario() {
        array[0] = ((Math.random() * 100) + 600);
        for (int i = 1; i < array.length; i++) {
            array[i] = (Math.random() * 60) - 30;

        }

        //Aufruf der Privaten Methode die array2 füllt
        fill();
    }

    //Methode zum erstellen und Füllen des Objektarrays
    private void fill() {

        for (int i = 1; i < array2.length; i++) {
            //erzeugen des 1. Objektes mit 1ner Stelle hinter dem Komma
            array2[0] = new StockTick(Math.round(array[0] * 10) / 10.0);

            //für die Stelle 1 größer 0
            //array2[0] = new StockTick(Math.round(array[0] * 10) / 10.0);

            //erzeugen der restlichen Objekte mit 1ner Stelle hinter dem Komma

            // Überprüft ob die Operation > 0 ist
            if (array2[i - 1].getKurs() + array[i] > 0) {
                array2[i] = new StockTick(Math.round((array2[i - 1].getKurs() + array[i]) * 10) / 10.0);
            } else {
                array2[i] = new StockTick(0);
            }
        }

        //Aufruf der privaten Methode die die Beste möglichkeit ausliefert

        System.out.println("Zwei For Schleifen");
        getbestDays();

        System.out.println("Eine For Schleife");
        getbestDaysAdvanced();
    }


    //Prozentsatz berechnen
    private void getbestDays() {


        // initialwerte
        int buy = 0; //bester Einkaufskurs
        int sell = 0;//bester Verkaufskurs
        double percent = 0; // prozentualer Unterschied

        //erste Schleife die jedes einzelne Stelle nimmt
        for (int i = 0; i < array2.length; i++) {
            //zweite Schleife die ein Vergleich mit allen nachkommenden Stellen macht
            for (int j = i; j < array2.length; j++) {

                //überprüft ob der aktuell gespeicherte prozentualeer Unterschied größer als der
                //aktuell berechnetet ist
                if (array2[j].getKurs() / array2[i].getKurs() > percent) {
                    percent = (array2[j].getKurs() / array2[i].getKurs());
                    buy = i;
                    sell = j;

                }

            }

        }

        //Runden der Prozentzahl auf 4 Stellen hinter dem Komma mit Ausgabe
        percent = Math.round((percent / 0.01 - 100) * 10000) / 10000.0;
        System.out.println("Der bester Einkaufstag waere der " + (buy + 1) + " Boersentag gewesen");
        System.out.println("Der dazugehoerige beste Verkaufstag waere der " + (sell + 1) + " Boersentag gewesen");
        System.out.println("Der so realisierte Gewinn waere " + percent + "% vom eingesaetzten Betrag gewesen");
        System.out.println("");
    }

    private void getbestDaysAdvanced() {


        //Initialwerte
        int small = 0; //
        int big = 0;

        int buy = 0;
        int sell = 0;
        double percent = 0;

        for (int i = 1; i < array2.length - 1; i++) {

            if (array2[i].getKurs() < array2[small].getKurs()) {

                small = i;

            } else if (array2[i].getKurs() > array2[big].getKurs()) ;

            big = i;

            if (array2[big].getKurs() / array2[small].getKurs() > percent) {

                percent = array2[big].getKurs() / array2[small].getKurs();
                buy = small;
                sell = big;
            }

        }

        percent = Math.round((percent / 0.01 - 100) * 10000) / 10000.0;
        System.out.println("Der bester Einkaufstag waere für " + (buy + 1) + " am Besten gewesen");
        System.out.println("Der dazugehoerige beste Verkaufstag waere der " + (sell + 1) + " Boersentag gewesen");
        System.out.println("Der so realisierte Gewinn waere " + percent + "% vom eingesaetzten Betrag gewesen");
        System.out.println("");


    }

    //Methode um die die tägliche Kursveränderungen anzeigt
    public void getArray() {

        System.out.println("Kursveränderungen: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(Math.round(array[i] * 10) / 10.0 + "     ");
        }

        System.out.println("");
        System.out.println("");

    }

    //Methode um die Tageskurse auszugeben
    public void getArray2() {
        System.out.println("Tageskurse: ");
        for (int i = 0; i < array.length; i++) {

            System.out.print(Math.round(array2[i].getKurs() * 10) / 10.0 + "    ");
        }
        System.out.println("");
        System.out.println("");
    }

    //Methode die den % tualen unterschied aller stellen miteinander vergleicht unterteilt in array3[Tag][Folgender Tag]
    public void getArray3() {

        double[][] array3 = new double[array.length][array.length];

        double percent;
        for (int i = 0; i < array2.length; i++) {
            for (int j = i; j < array2.length; j++) {
                // % berrechnen
                percent = (array2[j].getKurs() / array2[i].getKurs());
                percent = Math.round((percent / 0.01 - 100) * 10) / 10.0;

                //prozent wird für jeden folge tag eingespeichert
                array3[i][j] = percent;
            }


        }

        //Ausgabe aller Arraystellen
        for (int i = 0; i < array3.length - 1; i++) {
            System.out.println("Der Tageskurs vom Tag   " + (i + 1) + "   sowie den %tualen Unterschied " +
                    "zu den folge Tagen");
            System.out.println(Arrays.toString(array3[i]));
            System.out.println("");

        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }


}
