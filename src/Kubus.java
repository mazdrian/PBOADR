import java.io.*;
import java.util.*;

/**
 * Represents a cube (Kubus), extending Persegi.
 */
public class Kubus extends Persegi {

    private Double volumeKubus;
    private Double luasPermukaanKubus;

    /**
     * Default constructor.
     */
    public Kubus() {
        super();
        this.nama = "Kubus";
    }

    /**
     * Constructor with side length.
     * @param sisi The side length of the cube.
     */
    public Kubus(Double sisi) { // Overloading constructor
        super(sisi); // Call Persegi's constructor
    }

    public Double getVolumeKubus() {
        return volumeKubus;
    }

    public Double getLuasPermukaanKubus() {
        return luasPermukaanKubus;
    }

    /**
     * Calculates the volume of the cube.
     * Formula: V = S^3
     * @return The calculated volume.
     */
    @Override // Implementing BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeKubus();
    }

    public Double hitungVolumeKubus() { //
        if (getSisi() == null) {
            throw new IllegalStateException("Sisi kubus harus diatur sebelum menghitung volume.");
        }
        this.volumeKubus = Math.pow(getSisi(), 3);
        this.kelilingAtauVolume = this.volumeKubus;
        return this.volumeKubus;
    }

    /**
     * Calculates the surface area of the cube.
     * Formula: A = 6 * S^2
     * @return The calculated surface area.
     */
    @Override // Implementing BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        return hitungLuasPermukaanKubus();
    }

    public Double hitungLuasPermukaanKubus() { //
        if (getSisi() == null) {
            throw new IllegalStateException("Sisi kubus harus diatur sebelum menghitung luas permukaan.");
        }
        this.luasPermukaanKubus = 6 * Math.pow(getSisi(), 2);
        this.luas = this.luasPermukaanKubus;
        return this.luasPermukaanKubus;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double s) {
        setSisi(s);
        hitungVolumeKubus();
        hitungLuasPermukaanKubus();
    }
}