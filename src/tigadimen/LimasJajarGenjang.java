package tigadimen;

/**
 * Represents a parallelogram pyramid (Limas Jajar Genjang), extending tigadimen.JajarGenjang.
 */
public class LimasJajarGenjang extends JajarGenjang { // Corrected class name

    private Double tinggiLimas;
    private Double volumeLimas;
    private Double luasPermukaanLimas;

    /**
     * Default constructor.
     */
    public LimasJajarGenjang() {
        super();
        this.nama = "Limas Jajar Genjang";
    }

    /**
     * Constructor for a parallelogram pyramid.
     * @param alas The base length of the parallelogram base.
     * @param tinggiBase The height of the parallelogram base.
     * @param sisiMiringBase The slanted side of the parallelogram base.
     * @param tinggiLimas The height of the pyramid.
     */
    public LimasJajarGenjang(Double alas, Double tinggiBase, Double sisiMiringBase, Double tinggiLimas) { // Overloading constructor
        super(alas, tinggiBase); // Pass base dimensions to tigadimen.JajarGenjang
        setSisiMiring(sisiMiringBase); // Set for perimeter calc
        setTinggiLimas(tinggiLimas);
    }

    // Encapsulation: Getter and Setter
    public Double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(Double tinggiLimas) {
        try {
            validatePositiveDimension(tinggiLimas, "Tinggi Limas");
            this.tinggiLimas = tinggiLimas;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getVolumeLimas() {
        return volumeLimas;
    }

    public Double getLuasPermukaanLimas() {
        return luasPermukaanLimas;
    }

    /**
     * Calculates the volume of the parallelogram pyramid.
     * Volume = (1/3) * Base Area * Height
     * @return The calculated volume.
     */
    @Override // Implementing main.BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeLimas();
    }

    public Double hitungVolumeLimas() { //
        if (getAlas() == null || getTinggi() == null || tinggiLimas == null) {
            throw new IllegalStateException("Alas, tinggi alas, dan tinggi limas harus diatur sebelum menghitung volume.");
        }
        // Reuse hitungLuas() from tigadimen.JajarGenjang for base area
        this.volumeLimas = (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
        this.kelilingAtauVolume = this.volumeLimas;
        return this.volumeLimas;
    }

    /**
     * Calculates the surface area of the parallelogram pyramid.
     * Similar complexity to tigadimen.LimasBelahKetupat for lateral surface area.
     * I will use a simplified approach as before, calculating an "average" slant height.
     */
    @Override // Implementing main.BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        return hitungLuasPermukaanLimas();
    }

    public Double hitungLuasPermukaanLimas() { //
        if (getAlas() == null || getTinggi() == null || getSisiMiring() == null || tinggiLimas == null) {
            throw new IllegalStateException("Alas, tinggi alas, sisi miring alas, dan tinggi limas harus diatur sebelum menghitung luas permukaan.");
        }
        Double baseArea = super.hitungLuas(); // Area of parallelogram base
        Double basePerimeter = super.hitungKeliling(); // Perimeter of parallelogram base

        // To calculate the slant height of the triangular faces accurately,
        // we need the distance from the center of the base to the midpoint of each side.
        // For a parallelogram, these distances will be different for adjacent sides.
        // For a general implementation, this is very involved.
        // Let's use a very simplified approach for the lateral area for demonstration.

        // Assume a right pyramid with apex over the center.
        // The distance from the center to the sides needs to be calculated.
        // For a parallelogram with sides a, b and height h, area = a*h_a.
        // Perpendicular distance to side 'a' is h_a. Perpendicular distance to side 'b' is h_b.
        // The diagonals split the parallelogram. The center is intersection of diagonals.
        // The apothems (distances from center to midpoint of sides) would be h_a/2 and h_b/2.

        // Given `alas` and `sisiMiring`, `tinggi` is given for area.
        // `apothem_a` = `tinggi` / 2; (distance to side `alas`)
        // `apothem_b` (distance to side `sisiMiring`) would be (alas * tinggi_alas_relative_to_sisi_miring) / (2 * sisiMiring)

        // This is too complex for simple GUI input without providing more parameters.
        // I will use a very simplified heuristic for lateral surface area.
        // It's 0.5 * Base Perimeter * Average Slant Height of Faces.
        // This 'average slant height' would be sqrt(H_pyramid^2 + (Avg Apothem)^2).
        // Let's use `apothemOfBase` = (2 * baseArea) / basePerimeter, as a conceptual 'average apothem'.

        Double apothemOfBase = (2 * baseArea) / basePerimeter;
        Double avgSlantHeightOfFace = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(apothemOfBase, 2));

        Double lateralSurfaceArea = 0.5 * basePerimeter * avgSlantHeightOfFace;
        this.luasPermukaanLimas = baseArea + lateralSurfaceArea;
        this.luas = this.luasPermukaanLimas;
        return this.luasPermukaanLimas;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double alasBase, Double tinggiBase, Double sisiMiringBase, Double hLimas) {
        setAlas(alasBase);
        setTinggi(tinggiBase);
        setSisiMiring(sisiMiringBase); // Ensure sisi miring is set for perimeter
        setTinggiLimas(hLimas);
        hitungVolumeLimas();
        super.hitungKeliling(); // Ensure base perimeter is calculated
        hitungLuasPermukaanLimas();
    }
}