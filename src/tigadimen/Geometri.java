package tigadimen;

import maininter.BendaGeometri;

import javax.swing.JOptionPane; // Used for simple error display in a GUI context


/**
 * Abstract class representing a generic geometric object, implementing main.BendaGeometri.
 * Provides common properties and abstract methods for calculating
 * area/volume and perimeter/surface area.
 */
public abstract class Geometri implements BendaGeometri { //

    protected String nama; // Name of the geometric shape
    protected Double luas; // Area or surface area
    protected Double kelilingAtauVolume; // Perimeter or Volume

    /**
     * Default constructor.
     */
    public Geometri() { //
    }

    // Encapsulation: Getter for Nama
    public String getNama() {
        return nama;
    }

    // Encapsulation: Getter for calculated values
    @Override
    public Double hitungLuas() { //
        return luas;
    }

    @Override
    public Double hitungKelilingAtauVolume() { //
        return kelilingAtauVolume;
    }

    /**
     * Validates if a given dimension is positive.
     * @param dimension The dimension to validate.
     * @param dimensionName The name of the dimension (for error messages).
     * @throws IllegalArgumentException if the dimension is not positive.
     */
    protected void validatePositiveDimension(Double dimension, String dimensionName) {
        if (dimension == null || dimension <= 0) {
            String errorMessage = dimensionName + " harus bernilai positif.";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Placeholder for hitungVol - will be overridden by 3D shapes.
     */
    public void hitungVol() { //
        // This will typically be overridden by 3D shapes to calculate volume.
        System.out.println("Metode hitungVol() tidak diimplementasikan untuk " + nama);
    }
}