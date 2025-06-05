import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Represents a spherical sector (Juring Bola), extending Bola.
 */
public class JuringBola extends Bola { // Corrected class name

    private Double sudutPusatRadian; // Angle from center to arc, in radians (for 2D sector, or similar for 3D)
    private Double tinggiKerucutBagianDalam; // Height of the cone part within the sector

    private Double volumeJuring;
    private Double luasPermukaanJuring; // Curved surface area of cone + surface area of spherical cap

    /**
     * Default constructor.
     */
    public JuringBola() {
        super();
        this.nama = "Juring Bola";
    }

    /**
     * Constructor for a spherical sector.
     * @param radius The radius of the sphere.
     * @param tinggiKerucut The height of the cone part of the spherical sector.
     */
    public JuringBola(Double radius, Double tinggiKerucut) { // Overloading constructor
        super(radius);
        setTinggiKerucutBagianDalam(tinggiKerucut);
    }

    // Encapsulation: Getters and Setters
    public Double getSudutPusatRadian() {
        return sudutPusatRadian;
    }

    public void setSudutPusatRadian(Double sudutPusatRadian) {
        if (sudutPusatRadian == null || sudutPusatRadian <= 0 || sudutPusatRadian > Math.PI) { // Assuming angle for one-half sphere
            String errorMessage = "Sudut pusat harus antara 0 dan PI radian untuk juring bola (untuk kasus umum).";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
        this.sudutPusatRadian = sudutPusatRadian;
        // Calculate tinggiKerucutBagianDalam based on radius and angle (R(1-cos(theta/2)))
        if (getRadius() != null) {
            this.tinggiKerucutBagianDalam = getRadius() * (1 - Math.cos(sudutPusatRadian / 2));
        }
    }

    public Double getTinggiKerucutBagianDalam() {
        return tinggiKerucutBagianDalam;
    }

    public void setTinggiKerucutBagianDalam(Double tinggiKerucutBagianDalam) {
        try {
            validatePositiveDimension(tinggiKerucutBagianDalam, "Tinggi Kerucut Bagian Dalam");
            if (getRadius() != null && tinggiKerucutBagianDalam > getRadius()) { // Cone height cannot exceed sphere radius
                String errorMessage = "Tinggi kerucut bagian dalam tidak boleh lebih besar dari radius bola.";
                JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException(errorMessage);
            }
            this.tinggiKerucutBagianDalam = tinggiKerucutBagianDalam;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getVolumeJuring() {
        return volumeJuring;
    }

    public Double getLuasPermukaanJuring() {
        return luasPermukaanJuring;
    }

    /**
     * Calculates the volume of the spherical sector.
     * Formula: V = (2/3) * pi * R^2 * h
     * R = radius of the sphere, h = height of the spherical cap
     * Note: h is typically the height of the spherical cap, not the cone.
     * For a sector, it's the radius from the center to the cap.
     * Let's clarify: a spherical sector is a cone with its vertex at the sphere's center,
     * and its base is a spherical cap. So V = (2/3) * pi * R^2 * h (height of the spherical cap).
     * The `tinggiKerucutBagianDalam` here seems to refer to `R - h_cap`. Let's re-align.
     * For simplicity, let's assume `tinggiKerucutBagianDalam` is the `h` in V = (2/3) * pi * R^2 * h_cap where h_cap = R - dist_to_base.
     * The `h_cap` is the height of the spherical cap.
     * Let's assume `tinggiKerucutBagianDalam` refers to `h_cap`.
     */
    @Override // Implementing BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeJuring();
    }

    public Double hitungVolumeJuring() {
        if (getRadius() == null || tinggiKerucutBagianDalam == null) { // tinggiKerucutBagianDalam is h_cap
            throw new IllegalStateException("Radius bola dan tinggi tembereng bola harus diatur sebelum menghitung volume juring.");
        }
        this.volumeJuring = (2.0 / 3.0) * Math.PI * Math.pow(getRadius(), 2) * tinggiKerucutBagianDalam;
        this.kelilingAtauVolume = this.volumeJuring;
        return this.volumeJuring;
    }

    /**
     * Calculates the surface area of the spherical sector (curved surface of the cone part and the spherical cap surface).
     * Area of spherical cap: 2 * pi * R * h_cap
     * Area of cone: pi * r_base * L (slant height)
     * This is complex. Standard definition: Curved surface area of sector = 2 * PI * R * h_cap
     * Let's stick to the common formula for the curved surface area of the spherical sector.
     * It's just the area of the spherical cap if we consider the cone's curved surface as internal.
     * If it refers to the entire surface, it's Area of spherical cap + Area of cone base (circle) + Area of cone side.
     * Given the naming, let's assume it refers to the surface area of the spherical cap only.
     */
    @Override // Implementing BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        return hitungLuasPermukaanJuring();
    }

    public Double hitungLuasPermukaanJuring() {
        if (getRadius() == null || tinggiKerucutBagianDalam == null) {
            throw new IllegalStateException("Radius bola dan tinggi tembereng bola harus diatur sebelum menghitung luas permukaan juring.");
        }
        // This is the formula for the surface area of the spherical cap.
        this.luasPermukaanJuring = 2 * Math.PI * getRadius() * tinggiKerucutBagianDalam;
        this.luas = this.luasPermukaanJuring;
        return this.luasPermukaanJuring;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double r, Double h) {
        setRadius(r);
        setTinggiKerucutBagianDalam(h);
        hitungVolumeJuring();
        hitungLuasPermukaanJuring();
    }
}