package duadimen;


import tigadimen.Geometri;
import main.MainGeometryApp;

/**
 * Abstract class representing a 2D geometric shape.
 * Extends tigadimen.Geometri and implements duadimen.BidangDuaDimensi.
 */
public abstract class DuaDimensi extends Geometri implements BidangDuaDimensi { //

    /**
     * Default constructor.
     */
    public DuaDimensi() { //
        this.nama = "Bangun Dua Dimensi";
    }

    /**
     * Abstract method for calculating area, implemented by concrete 2D shapes.
     */
    @Override
    public abstract Double hitungLuas(); //

    /**
     * Abstract method for calculating perimeter, implemented by concrete 2D shapes.
     */
    @Override
    public abstract Double hitungKeliling(); //

    @Override
    public Double hitungKelilingAtauVolume() {
        return hitungKeliling(); // For 2D shapes, kelilingAtauVolume is keliling
    }
}