import java.io.*; //
import java.util.*; //

/**
 * Represents a rhombus (Belah Ketupat), extending DuaDimensi.
 */
public class BelahKetupat extends DuaDimensi { //

    private Double diagonal1; // Former 'Diagonal'
    private Double diagonal2; // Former 'DiagonalHorizontal'
    private Double sisi; //

    /**
     * Default constructor.
     */
    public BelahKetupat() { //
        super();
        this.nama = "Belah Ketupat";
    }

    /**
     * Constructor for area calculation.
     * @param diagonal1 The first diagonal.
     * @param diagonal2 The second diagonal.
     */
    public BelahKetupat(Double diagonal1, Double diagonal2) { // Overloading constructor
        this();
        setDiagonal1(diagonal1);
        setDiagonal2(diagonal2);
    }

    /**
     * Constructor for perimeter calculation.
     * @param sisi The side length of the rhombus.
     */
    public BelahKetupat(Double sisi) { // Overloading constructor
        this();
        setSisi(sisi);
    }

    // Encapsulation: Getters and Setters
    public Double getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(Double diagonal1) {
        try {
            validatePositiveDimension(diagonal1, "Diagonal 1");
            this.diagonal1 = diagonal1;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(Double diagonal2) {
        try {
            validatePositiveDimension(diagonal2, "Diagonal 2");
            this.diagonal2 = diagonal2;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getSisi() {
        return sisi;
    }

    public void setSisi(Double sisi) {
        try {
            validatePositiveDimension(sisi, "Sisi");
            this.sisi = sisi;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Overrides to calculate the area of the rhombus.
     * @return The calculated area.
     */
    @Override
    public Double hitungLuas() { //
        if (diagonal1 == null || diagonal2 == null) {
            throw new IllegalStateException("Kedua diagonal harus diatur sebelum menghitung luas.");
        }
        this.luas = 0.5 * diagonal1 * diagonal2; //
        return this.luas;
    }

    /**
     * Implements to calculate the perimeter of the rhombus.
     * @return The calculated perimeter.
     */
    @Override
    public Double hitungKeliling() { //
        if (sisi == null) {
            throw new IllegalStateException("Sisi harus diatur sebelum menghitung keliling.");
        }
        this.kelilingAtauVolume = 4 * sisi; //
        return this.kelilingAtauVolume;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double d1, Double d2, Double s) {
        setDiagonal1(d1);
        setDiagonal2(d2);
        setSisi(s);
        try {
            if (d1 != null && d2 != null) {
                hitungLuas();
            }
            if (s != null) {
                hitungKeliling();
            }
        } catch (IllegalStateException e) {
            // Ignore for now as not all parameters might be for the same calculation type
        }
    }
}