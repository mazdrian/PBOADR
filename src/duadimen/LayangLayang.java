package duadimen;

/**
 * Represents a kite (Layang Layang), extending duadimen.DuaDimensi.
 */
public class LayangLayang extends DuaDimensi {

    private Double diagonalHorizontal;
    private Double diagonalVertikal;
    private Double sisiA; // Two pairs of equal sides
    private Double sisiB;

    /**
     * Default constructor.
     */
    public LayangLayang() {
        super();
        this.nama = "Layang-Layang";
    }

    /**
     * Constructor for area calculation.
     * @param diagonalHorizontal The horizontal diagonal.
     * @param diagonalVertikal The vertical diagonal.
     */
    public LayangLayang(Double diagonalHorizontal, Double diagonalVertikal) { // Overloading constructor
        this();
        setDiagonalHorizontal(diagonalHorizontal);
        setDiagonalVertikal(diagonalVertikal);
    }

    /**
     * Constructor for perimeter calculation.
     * @param sisiA The length of one pair of equal sides.
     * @param sisiB The length of the other pair of equal sides.
     * @param isPerimeterCalc A dummy boolean to distinguish constructors.
     */
    public LayangLayang(Double sisiA, Double sisiB, boolean isPerimeterCalc) { // Overloading constructor
        this();
        setSisiA(sisiA);
        setSisiB(sisiB);
    }

    // Encapsulation: Getters and Setters
    public Double getDiagonalHorizontal() {
        return diagonalHorizontal;
    }

    public void setDiagonalHorizontal(Double diagonalHorizontal) {
        try {
            validatePositiveDimension(diagonalHorizontal, "Diagonal Horizontal");
            this.diagonalHorizontal = diagonalHorizontal;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getDiagonalVertikal() {
        return diagonalVertikal;
    }

    public void setDiagonalVertikal(Double diagonalVertikal) {
        try {
            validatePositiveDimension(diagonalVertikal, "Diagonal Vertikal");
            this.diagonalVertikal = diagonalVertikal;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getSisiA() {
        return sisiA;
    }

    public void setSisiA(Double sisiA) {
        try {
            validatePositiveDimension(sisiA, "Sisi A");
            this.sisiA = sisiA;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getSisiB() {
        return sisiB;
    }

    public void setSisiB(Double sisiB) {
        try {
            validatePositiveDimension(sisiB, "Sisi B");
            this.sisiB = sisiB;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Overrides to calculate the area of the kite.
     * @return The calculated area.
     */
    @Override
    public Double hitungLuas() {
        if (diagonalHorizontal == null || diagonalVertikal == null) {
            throw new IllegalStateException("Kedua diagonal harus diatur sebelum menghitung luas.");
        }
        this.luas = 0.5 * diagonalHorizontal * diagonalVertikal;
        return this.luas;
    }

    /**
     * Implements to calculate the perimeter of the kite.
     * @return The calculated perimeter.
     */
    @Override
    public Double hitungKeliling() {
        if (sisiA == null || sisiB == null) {
            throw new IllegalStateException("Kedua pasang sisi harus diatur sebelum menghitung keliling.");
        }
        this.kelilingAtauVolume = 2 * (sisiA + sisiB);
        return this.kelilingAtauVolume;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double dH, Double dV, Double sA, Double sB) {
        setDiagonalHorizontal(dH);
        setDiagonalVertikal(dV);
        setSisiA(sA);
        setSisiB(sB);
        try {
            if (dH != null && dV != null) {
                hitungLuas();
            }
            if (sA != null && sB != null) {
                hitungKeliling();
            }
        } catch (IllegalStateException e) {
            // Ignore for now
        }
    }
}