import java.io.*;
import java.util.*;

/**
 * Represents a circle, extending DuaDimensi.
 */
public class Lingkaran extends DuaDimensi {

    private Double radius;

    /**
     * Default constructor.
     */
    public Lingkaran() {
        super();
        this.nama = "Lingkaran";
    }

    /**
     * Constructor with initial radius.
     * @param radius The radius of the circle.
     */
    public Lingkaran(Double radius) {
        this();
        setRadius(radius); // Use setter for validation
    }

    // Encapsulation: Getter and Setter
    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        try {
            validatePositiveDimension(radius, "Radius");
            this.radius = radius;
        } catch (IllegalArgumentException e) {
            // Re-throw or handle as needed, for GUI, JOptionPane is already shown.
            throw e;
        }
    }

    /**
     * Overrides the abstract method to calculate the area of the circle.
     * @return The calculated area.
     */
    @Override
    public Double hitungLuas() {
        if (radius == null) {
            throw new IllegalStateException("Radius harus diatur sebelum menghitung luas.");
        }
        this.luas = Math.PI * radius * radius;
        return this.luas;
    }

    /**
     * Implements the interface method to calculate the perimeter (circumference) of the circle.
     * @return The calculated perimeter.
     */
    @Override
    public Double hitungKeliling() {
        if (radius == null) {
            throw new IllegalStateException("Radius harus diatur sebelum menghitung keliling.");
        }
        this.kelilingAtauVolume = 2 * Math.PI * radius;
        return this.kelilingAtauVolume;
    }

    // Overloading: Example method to set radius and calculate
    public void setRadiusAndCalculate(Double r) {
        setRadius(r);
        hitungLuas();
        hitungKeliling();
    }
}