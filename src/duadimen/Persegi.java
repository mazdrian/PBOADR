package duadimen;// If duadimen.Persegi.java was not in the previous set, include this file

/**
 * Represents a square, extending duadimen.DuaDimensi.
 */
public class Persegi extends DuaDimensi {

    private Double sisi;

    /**
     * Default constructor.
     */
    public Persegi() {
        super();
        this.nama = "duadimen.Persegi";
    }

    /**
     * Constructor with initial side length.
     * @param sisi The side length of the square.
     */
    public Persegi(Double sisi) {
        this();
        setSisi(sisi); // Use setter for validation
    }

    // Encapsulation: Getter and Setter
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
     * Overrides the abstract method to calculate the area of the square.
     * @return The calculated area.
     */
    @Override
    public Double hitungLuas() {
        if (sisi == null) {
            throw new IllegalStateException("Sisi harus diatur sebelum menghitung luas.");
        }
        this.luas = sisi * sisi;
        return this.luas;
    }

    /**
     * Implements the interface method to calculate the perimeter of the square.
     * @return The calculated perimeter.
     */
    @Override
    public Double hitungKeliling() {
        if (sisi == null) {
            throw new IllegalStateException("Sisi harus diatur sebelum menghitung keliling.");
        }
        this.kelilingAtauVolume = 4 * sisi;
        return this.kelilingAtauVolume;
    }

    // Overloading: Example of a method to set dimension and calculate
    public void setDimensionAndCalculate(Double s) {
        setSisi(s);
        hitungLuas();
        hitungKeliling();
    }
}