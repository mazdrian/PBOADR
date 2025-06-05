package tigadimen;

import duadimen.DuaDimensi;

/**
 * Represents a parallelogram (Jajar Genjang), extending duadimen.DuaDimensi.
 */
public class JajarGenjang extends DuaDimensi {

    private Double alas;
    private Double tinggi;
    private Double sisiMiring; // For perimeter

    /**
     * Default constructor.
     */
    public JajarGenjang() {
        super();
        this.nama = "Jajar Genjang";
    }

    /**
     * Constructor for area calculation.
     * @param alas The base of the parallelogram.
     * @param tinggi The height of the parallelogram.
     */
    public JajarGenjang(Double alas, Double tinggi) { // Overloading constructor
        this();
        setAlas(alas);
        setTinggi(tinggi);
    }

    /**
     * Constructor for perimeter calculation.
     * @param alas The base of the parallelogram.
     * @param sisiMiring The slanted side of the parallelogram.
     */
    public JajarGenjang(Double alas, Double sisiMiring, boolean forPerimeter) { // Overloading constructor
        this();
        setAlas(alas);
        setSisiMiring(sisiMiring);
    }

    // Encapsulation: Getters and Setters
    public Double getAlas() {
        return alas;
    }

    public void setAlas(Double alas) {
        try {
            validatePositiveDimension(alas, "Alas");
            this.alas = alas;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getTinggi() {
        return tinggi;
    }

    public void setTinggi(Double tinggi) {
        try {
            validatePositiveDimension(tinggi, "Tinggi");
            this.tinggi = tinggi;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getSisiMiring() {
        return sisiMiring;
    }

    public void setSisiMiring(Double sisiMiring) {
        try {
            validatePositiveDimension(sisiMiring, "Sisi Miring");
            this.sisiMiring = sisiMiring;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Overrides to calculate the area of the parallelogram.
     * @return The calculated area.
     */
    @Override
    public Double hitungLuas() {
        if (alas == null || tinggi == null) {
            throw new IllegalStateException("Alas dan Tinggi harus diatur sebelum menghitung luas.");
        }
        this.luas = alas * tinggi;
        return this.luas;
    }

    /**
     * Implements to calculate the perimeter of the parallelogram.
     * @return The calculated perimeter.
     */
    @Override
    public Double hitungKeliling() {
        if (alas == null || sisiMiring == null) {
            throw new IllegalStateException("Alas dan Sisi Miring harus diatur sebelum menghitung keliling.");
        }
        this.kelilingAtauVolume = 2 * (alas + sisiMiring);
        return this.kelilingAtauVolume;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double a, Double t, Double sm) {
        setAlas(a);
        setTinggi(t);
        setSisiMiring(sm);
        try {
            if (a != null && t != null) {
                hitungLuas();
            }
            if (a != null && sm != null) {
                hitungKeliling();
            }
        } catch (IllegalStateException e) {
            // Ignore for now, as not all parameters might be for the same calculation type
        }
    }
}