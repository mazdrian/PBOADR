import java.io.*;
import java.util.*;

/**
 * Represents a square pyramid (Limas Persegi), extending Persegi.
 */
public class LimasPersegi extends Persegi { // Corrected class name

    private Double tinggiLimas;
    private Double volumeLimas;
    private Double luasPermukaanLimas;

    /**
     * Default constructor.
     */
    public LimasPersegi() {
        super();
        this.nama = "Limas Persegi";
    }

    /**
     * Constructor for a square pyramid.
     * @param sisi The side length of the square base.
     * @param tinggiLimas The height of the pyramid.
     */
    public LimasPersegi(Double sisi, Double tinggiLimas) { // Overloading constructor
        super(sisi); // Pass side to Persegi constructor for base
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
     * Calculates the volume of the square pyramid.
     * Volume = (1/3) * Base Area * Height
     * @return The calculated volume.
     */
    @Override // Implementing BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeLimas();
    }

    public Double hitungVolumeLimas() { //
        if (getSisi() == null || tinggiLimas == null) {
            throw new IllegalStateException("Sisi alas dan tinggi limas harus diatur sebelum menghitung volume.");
        }
        // Reuse hitungLuas() from Persegi for base area
        this.volumeLimas = (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
        this.kelilingAtauVolume = this.volumeLimas;
        return this.volumeLimas;
    }

    /**
     * Calculates the surface area of the square pyramid.
     * Surface Area = Base Area + 4 * (Area of one triangular face)
     * Area of one triangular face = 0.5 * base_side * slant_height_of_face
     * For a square pyramid, the apothem of the base = side / 2.
     * Slant height of face (h_f) = sqrt(pyramid_height^2 + (apothem_of_base)^2)
     * @return The calculated surface area.
     */
    @Override // Implementing BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        return hitungLuasPermukaanLimas();
    }

    public Double hitungLuasPermukaanLimas() { //
        if (getSisi() == null || tinggiLimas == null) {
            throw new IllegalStateException("Sisi alas dan tinggi limas harus diatur sebelum menghitung luas permukaan.");
        }
        Double baseArea = super.hitungLuas(); // Area of square base
        Double apothemOfBase = getSisi() / 2; // Apothem of a square is half its side
        Double slantHeightOfFace = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(apothemOfBase, 2));

        Double areaOfOneLateralFace = 0.5 * getSisi() * slantHeightOfFace;
        Double lateralSurfaceArea = 4 * areaOfOneLateralFace; // 4 congruent triangular faces
        this.luasPermukaanLimas = baseArea + lateralSurfaceArea;
        this.luas = this.luasPermukaanLimas;
        return this.luasPermukaanLimas;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double sisiBase, Double hLimas) {
        setSisi(sisiBase);
        setTinggiLimas(hLimas);
        hitungVolumeLimas();
        hitungLuasPermukaanLimas();
    }
}