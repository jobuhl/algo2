/**
 * Created by Rackenrotz on 16.10.15.
 */
public class StockTick {

    private double kurs;


    //Konstruktor
    public StockTick(double kurs) {
        this.kurs = kurs;
    }

    //Setter-Mehtode
    public void setKurs(double lastkurs, float kursDiff) {
        this.kurs = lastkurs + kursDiff;
    }

    //Getter Methode
    public double getKurs() {
        return kurs;
    }


}
