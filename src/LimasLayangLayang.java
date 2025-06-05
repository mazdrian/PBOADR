import java.io.*;
import java.util.*;

/**
 * Represents a kite pyramid (Limas Layang-Layang), extending LayangLayang.
 */
public class LimasLayangLayang extends LayangLayang { // Corrected class name

    private Double tinggiLimas;
    private Double volumeLimas;
    private Double luasPermukaanLimas;

    /**
     * Default constructor.
     */
    public LimasLayangLayang() {
        super();
        this.nama = "Limas Layang-Layang";
    }

    /**
     * Constructor for a kite pyramid.
     * @param diagonalHorizontal The horizontal diagonal of the kite base.
     * @param diagonalVertikal The vertical diagonal of the kite base.
     * @param sisiA The side length of one pair of equal sides of the kite base.
     * @param sisiB The side length of the other pair of equal sides of the kite base.
     * @param tinggiLimas The height of the pyramid.
     */
    public LimasLayangLayang(Double diagonalHorizontal, Double diagonalVertikal, Double sisiA, Double sisiB, Double tinggiLimas) { // Overloading constructor
        super(diagonalHorizontal, diagonalVertikal); // Pass diagonals for base area
        setSisiA(sisiA); // For base perimeter
        setSisiB(sisiB); // For base perimeter
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
     * Calculates the volume of the kite pyramid.
     * Volume = (1/3) * Base Area * Height
     * @return The calculated volume.
     */
    @Override // Implementing BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeLimas();
    }

    public Double hitungVolumeLimas() { //
        if (getDiagonalHorizontal() == null || getDiagonalVertikal() == null || tinggiLimas == null) {
            throw new IllegalStateException("Diagonal alas dan tinggi limas harus diatur sebelum menghitung volume.");
        }
        // Reuse hitungLuas() from LayangLayang for base area
        this.volumeLimas = (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
        this.kelilingAtauVolume = this.volumeLimas;
        return this.volumeLimas;
    }

    /**
     * Calculates the surface area of the kite pyramid.
     * Similar complexity to other pyramids. Will use simplified average apothem approach.
     */
    @Override // Implementing BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        return hitungLuasPermukaanLimas();
    }

    public Double hitungLuasPermukaanLimas() { //
        if (getDiagonalHorizontal() == null || getDiagonalVertikal() == null || getSisiA() == null || getSisiB() == null || tinggiLimas == null) {
            throw new IllegalStateException("Diagonal, sisi alas, dan tinggi limas harus diatur sebelum menghitung luas permukaan.");
        }
        Double baseArea = super.hitungLuas(); // Area of kite base
        Double basePerimeter = super.hitungKeliling(); // Perimeter of kite base

        // Calculate a conceptual "average" apothem for the base
        // This is a simplification as a kite typically has two pairs of slant heights for its faces.
        Double apothemOfBase = (2 * baseArea) / basePerimeter;

        // Calculate a conceptual "average" slant height of the triangular faces
        Double avgSlantHeightOfFace = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(apothemOfBase, 2));

        Double lateralSurfaceArea = 0.5 * basePerimeter * avgSlantHeightOfFace;
        this.luasPermukaanLimas = baseArea + lateralSurfaceArea;
        this.luas = this.luasPermukaanLimas;
        return this.luasPermukaanLimas;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double dH, Double dV, Double sA, Double sB, Double hLimas) {
        setDiagonalHorizontal(dH);
        setDiagonalVertikal(dV);
        setSisiA(sA);
        setSisiB(sB);
        setTinggiLimas(hLimas);
        hitungVolumeLimas();
        super.hitungKeliling(); // Ensure base perimeter is calculated
        hitungLuasPermukaanLimas();
    }
}