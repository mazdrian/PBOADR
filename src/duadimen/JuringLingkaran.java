package duadimen;

import javax.swing.*;

/**
 * Represents a circular sector (Juring duadimen.Lingkaran), extending duadimen.Lingkaran.
 */
public class JuringLingkaran extends Lingkaran { // Corrected class name

    private Double sudutPusatDerajat; // Central angle in degrees
    private Double sudutPusatRadian; // Central angle in radians

    private Double luasJuring;
    private Double panjangBusur; // Arc length

    /**
     * Default constructor.
     */
    public JuringLingkaran() {
        super();
        this.nama = "Juring duadimen.Lingkaran";
    }

    /**
     * Constructor with radius and angle in degrees.
     * @param radius The radius of the circle.
     * @param sudutPusatDerajat The central angle in degrees.
     */
    public JuringLingkaran(Double radius, Double sudutPusatDerajat) { // Overloading constructor
        super(radius);
        setSudutPusatDerajat(sudutPusatDerajat);
    }

    /**
     * Constructor with radius and angle in radians.
     * @param radius The radius of the circle.
     * @param sudutPusatRadian The central angle in radians.
     */
    public JuringLingkaran(Double radius, Double sudutPusatRadian, boolean isRadian) { // Overloading constructor
        super(radius);
        setSudutPusatRadian(sudutPusatRadian);
    }

    // Encapsuulation: Getters and Setters
    public Double getSudutPusatDerajat() {
        return sudutPusatDerajat;
    }

    public void setSudutPusatDerajat(Double sudutPusatDerajat) {
        if (sudutPusatDerajat == null || sudutPusatDerajat <= 0 || sudutPusatDerajat > 360) {
            String errorMessage = "Sudut pusat harus antara 0 dan 360 derajat.";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
        this.sudutPusatDerajat = sudutPusatDerajat;
        this.sudutPusatRadian = Math.toRadians(sudutPusatDerajat);
    }

    public Double getSudutPusatRadian() {
        return sudutPusatRadian;
    }

    public void setSudutPusatRadian(Double sudutPusatRadian) {
        if (sudutPusatRadian == null || sudutPusatRadian <= 0 || sudutPusatRadian > 2 * Math.PI) {
            String errorMessage = "Sudut pusat harus antara 0 dan 2*PI radian.";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
        this.sudutPusatRadian = sudutPusatRadian;
        this.sudutPusatDerajat = Math.toDegrees(sudutPusatRadian);
    }

    public Double getLuasJuring() {
        return luasJuring;
    }

    public Double getPanjangBusur() {
        return panjangBusur;
    }

    /**
     * Calculates the area of the circular sector.
     * Formula: A = (theta / 2) * R^2 where theta is in radians.
     * @return The calculated area.
     */
    @Override
    public Double hitungLuas() {
        return hitungLuasJuring();
    }

    public Double hitungLuasJuring() { //
        if (getRadius() == null || sudutPusatRadian == null) {
            throw new IllegalStateException("Radius dan sudut pusat harus diatur sebelum menghitung luas juring.");
        }
        this.luasJuring = 0.5 * Math.pow(getRadius(), 2) * sudutPusatRadian;
        this.luas = this.luasJuring;
        return this.luasJuring;
    }

    /**
     * Calculates the perimeter of the circular sector (arc length + 2 * radius).
     * Arc length: s = R * theta where theta is in radians.
     * @return The calculated perimeter.
     */
    @Override
    public Double hitungKeliling() {
        return hitungPanjangBusur() + 2 * getRadius(); // Perimeter of sector includes two radii
    }

    public Double hitungPanjangBusur() {
        if (getRadius() == null || sudutPusatRadian == null) {
            throw new IllegalStateException("Radius dan sudut pusat harus diatur sebelum menghitung panjang busur.");
        }
        this.panjangBusur = getRadius() * sudutPusatRadian;
        return this.panjangBusur;
    }

    @Override
    public Double hitungKelilingAtauVolume() { // From main.BendaGeometri
        return hitungKeliling();
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double r, Double angle, boolean isRadian) {
        setRadius(r);
        if (isRadian) {
            setSudutPusatRadian(angle);
        } else {
            setSudutPusatDerajat(angle);
        }
        hitungLuasJuring();
        hitungKeliling(); // Calculates perimeter including radii
    }
}