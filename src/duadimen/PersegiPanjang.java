package duadimen;

/**
 * Represents a rectangle, extending duadimen.DuaDimensi.
 */
public class PersegiPanjang extends DuaDimensi { //

    private Double panjang; //
    private Double lebar; //

    /**
     * Default constructor.
     */
    public PersegiPanjang() { //
        super();
        this.nama = "duadimen.Persegi Panjang";
    }

    /**
     * Constructor with initial dimensions.
     * @param panjang The length of the rectangle.
     * @param lebar The width of the rectangle.
     */
    public PersegiPanjang(Double panjang, Double lebar) { // Overloading constructor
        this();
        setPanjang(panjang); // Use setter for validation
        setLebar(lebar);     // Use setter for validation
    }

    // Encapsulation: Getters and Setters
    public Double getPanjang() {
        return panjang;
    }

    public void setPanjang(Double panjang) {
        try {
            validatePositiveDimension(panjang, "Panjang");
            this.panjang = panjang;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getLebar() {
        return lebar;
    }

    public void setLebar(Double lebar) {
        try {
            validatePositiveDimension(lebar, "Lebar");
            this.lebar = lebar;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Overrides the abstract method to calculate the area of the rectangle.
     * @return The calculated area.
     */
    @Override
    public Double hitungLuas() { //
        if (panjang == null || lebar == null) {
            throw new IllegalStateException("Panjang dan Lebar harus diatur sebelum menghitung luas.");
        }
        this.luas = panjang * lebar;
        return this.luas;
    }

    /**
     * Implements the interface method to calculate the perimeter of the rectangle.
     * @return The calculated perimeter.
     */
    @Override
    public Double hitungKeliling() { //
        if (panjang == null || lebar == null) {
            throw new IllegalStateException("Panjang dan Lebar harus diatur sebelum menghitung keliling.");
        }
        this.kelilingAtauVolume = 2 * (panjang + lebar);
        return this.kelilingAtauVolume;
    }

    // Overloading: Example of a method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double p, Double l) {
        setPanjang(p);
        setLebar(l);
        hitungLuas();
        hitungKeliling();
    }
}