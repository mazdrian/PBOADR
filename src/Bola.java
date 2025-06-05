import java.io.*; //
import java.util.*; //

/**
 * Represents a sphere (Bola), extending Geometri.
 */
public class Bola extends Geometri { //

    private Double radius;

    /**
     * Default constructor.
     */
    public Bola() { //
        super();
        this.nama = "Bola";
    }

    /**
     * Constructor with initial radius.
     * @param radius The radius of the sphere.
     */
    public Bola(Double radius) { // Overloading constructor
        this();
        setRadius(radius);
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
            throw e;
        }
    }

    /**
     * Overrides to calculate the surface area of the sphere.
     * @return The calculated surface area.
     */
    @Override // Implementing BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        if (radius == null) {
            throw new IllegalStateException("Radius harus diatur sebelum menghitung luas permukaan.");
        }
        this.luas = 4 * Math.PI * radius * radius; //
        return this.luas;
    }

    /**
     * Overrides to calculate the volume of the sphere.
     * @return The calculated volume.
     */
    @Override // Implementing BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() { //
        if (radius == null) {
            throw new IllegalStateException("Radius harus diatur sebelum menghitung volume.");
        }
        this.kelilingAtauVolume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3); //
        return this.kelilingAtauVolume;
    }

    // Overloading: Method to set radius and calculate
    public void setRadiusAndCalculate(Double r) {
        setRadius(r);
        hitungLuas(); // Calculate surface area
        hitungKelilingAtauVolume(); // Calculate volume
    }
}