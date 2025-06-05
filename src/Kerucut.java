import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Represents a cone (Kerucut), extending Lingkaran.
 */
public class Kerucut extends Lingkaran {

    private Double tinggiKerucut;
    private Double sisiMiring; // Slant height
    private Double volumeKerucut;
    private Double luasPermukaanKerucut;

    /**
     * Default constructor.
     */
    public Kerucut() {
        super();
        this.nama = "Kerucut";
    }

    /**
     * Constructor with radius and height.
     * @param radius The radius of the cone's base.
     * @param tinggiKerucut The height of the cone.
     */
    public Kerucut(Double radius, Double tinggiKerucut) { // Overloading constructor
        super(radius);
        setTinggiKerucut(tinggiKerucut);
    }

    /**
     * Constructor with radius and slant height (sisi miring).
     * @param radius The radius of the cone's base.
     * @param sisiMiring The slant height of the cone.
     * @param forSlantHeight Indicates this constructor is for slant height.
     */
    public Kerucut(Double radius, Double sisiMiring, boolean forSlantHeight) { // Overloading constructor
        super(radius);
        setSisiMiring(sisiMiring);
        // Calculate height from radius and slant height: h = sqrt(L^2 - R^2)
        if (getRadius() != null && sisiMiring != null) {
            if (sisiMiring < getRadius()) {
                String errorMessage = "Sisi miring tidak boleh lebih kecil dari radius.";
                JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException(errorMessage);
            }
            this.tinggiKerucut = Math.sqrt(Math.pow(sisiMiring, 2) - Math.pow(getRadius(), 2));
        }
    }

    // Encapsulation: Getters and Setters
    public Double getTinggiKerucut() {
        return tinggiKerucut;
    }

    public void setTinggiKerucut(Double tinggiKerucut) {
        try {
            validatePositiveDimension(tinggiKerucut, "Tinggi Kerucut");
            this.tinggiKerucut = tinggiKerucut;
            // Calculate slant height if radius is known
            if (getRadius() != null) {
                this.sisiMiring = Math.sqrt(Math.pow(getRadius(), 2) + Math.pow(tinggiKerucut, 2));
            }
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
            // Calculate height if radius is known
            if (getRadius() != null) {
                if (sisiMiring < getRadius()) {
                    String errorMessage = "Sisi miring tidak boleh lebih kecil dari radius.";
                    JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
                    throw new IllegalArgumentException(errorMessage);
                }
                this.tinggiKerucut = Math.sqrt(Math.pow(sisiMiring, 2) - Math.pow(getRadius(), 2));
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getVolumeKerucut() {
        return volumeKerucut;
    }

    public Double getLuasPermukaanKerucut() {
        return luasPermukaanKerucut;
    }

    /**
     * Calculates the volume of the cone.
     * Formula: V = (1/3) * pi * R^2 * h
     * @return The calculated volume.
     */
    @Override // Implementing BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeKerucut();
    }

    public Double hitungVolumeKerucut() { //
        if (getRadius() == null || tinggiKerucut == null) {
            throw new IllegalStateException("Radius alas dan tinggi kerucut harus diatur sebelum menghitung volume.");
        }
        this.volumeKerucut = (1.0 / 3.0) * super.hitungLuas() * tinggiKerucut; // Reuse base area
        this.kelilingAtauVolume = this.volumeKerucut;
        return this.volumeKerucut;
    }

    /**
     * Calculates the surface area of the cone.
     * Formula: A = pi * R * (R + L) where L is slant height
     * @return The calculated surface area.
     */
    @Override // Implementing BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        return hitungLuasPermukaanKerucut();
    }

    public Double hitungLuasPermukaanKerucut() { //
        if (getRadius() == null || sisiMiring == null) {
            throw new IllegalStateException("Radius alas dan sisi miring kerucut harus diatur sebelum menghitung luas permukaan.");
        }
        this.luasPermukaanKerucut = Math.PI * getRadius() * (getRadius() + sisiMiring);
        this.luas = this.luasPermukaanKerucut;
        return this.luasPermukaanKerucut;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double r, Double h, Double l) {
        setRadius(r);
        if (h != null) setTinggiKerucut(h);
        if (l != null) setSisiMiring(l);

        // Ensure both height and slant height are implicitly calculated or derived
        if (getRadius() != null) {
            if (tinggiKerucut != null && sisiMiring == null) {
                this.sisiMiring = Math.sqrt(Math.pow(getRadius(), 2) + Math.pow(tinggiKerucut, 2));
            } else if (sisiMiring != null && tinggiKerucut == null) {
                if (sisiMiring < getRadius()) {
                    throw new IllegalArgumentException("Sisi miring tidak boleh lebih kecil dari radius.");
                }
                this.tinggiKerucut = Math.sqrt(Math.pow(sisiMiring, 2) - Math.pow(getRadius(), 2));
            }
        }

        hitungVolumeKerucut();
        hitungLuasPermukaanKerucut();
    }
}