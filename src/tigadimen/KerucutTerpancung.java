package tigadimen;

import javax.swing.JOptionPane;

/**
 * Represents a frustum of a cone (tigadimen.Kerucut Terpancung), extending tigadimen.Geometri.
 */
public class KerucutTerpancung extends Geometri { // Corrected class name

    private Double radiusAtas;
    private Double radiusBawah;
    private Double tinggiKerucutTerpancung; // Height of the frustum
    private Double sisiMiringTerpancung; // Slant height of the frustum

    private Double volumeFrustum;
    private Double luasPermukaanFrustum;

    /**
     * Default constructor.
     */
    public KerucutTerpancung() {
        super();
        this.nama = "tigadimen.Kerucut Terpancung";
    }

    /**
     * Constructor with two radii and height.
     * @param radiusAtas The radius of the top base.
     * @param radiusBawah The radius of the bottom base.
     * @param tinggi The height of the frustum.
     */
    public KerucutTerpancung(Double radiusAtas, Double radiusBawah, Double tinggi) { // Overloading constructor
        this();
        setRadiusAtas(radiusAtas);
        setRadiusBawah(radiusBawah);
        setTinggiKerucutTerpancung(tinggi);
        // Calculate slant height if height is set
        calculateSlantHeight();
    }

    /**
     * Constructor with two radii and slant height.
     * @param radiusAtas The radius of the top base.
     * @param radiusBawah The radius of the bottom base.
     * @param sisiMiring The slant height of the frustum.
     * @param forSlantHeight Indicates this constructor is for slant height.
     */
    public KerucutTerpancung(Double radiusAtas, Double radiusBawah, Double sisiMiring, boolean forSlantHeight) { // Overloading constructor
        this();
        setRadiusAtas(radiusAtas);
        setRadiusBawah(radiusBawah);
        setSisiMiringTerpancung(sisiMiring);
        // Calculate height if slant height is set
        calculateHeightFromSlantHeight();
    }

    // Encapsulation: Getters and Setters
    public Double getRadiusAtas() {
        return radiusAtas;
    }

    public void setRadiusAtas(Double radiusAtas) {
        try {
            validatePositiveDimension(radiusAtas, "Radius Atas");
            this.radiusAtas = radiusAtas;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getRadiusBawah() {
        return radiusBawah;
    }

    public void setRadiusBawah(Double radiusBawah) {
        try {
            validatePositiveDimension(radiusBawah, "Radius Bawah");
            this.radiusBawah = radiusBawah;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getTinggiKerucutTerpancung() {
        return tinggiKerucutTerpancung;
    }

    public void setTinggiKerucutTerpancung(Double tinggiKerucutTerpancung) {
        try {
            validatePositiveDimension(tinggiKerucutTerpancung, "Tinggi tigadimen.Kerucut Terpancung");
            this.tinggiKerucutTerpancung = tinggiKerucutTerpancung;
            calculateSlantHeight(); // Recalculate slant height if height changes
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getSisiMiringTerpancung() {
        return sisiMiringTerpancung;
    }

    public void setSisiMiringTerpancung(Double sisiMiringTerpancung) {
        try {
            validatePositiveDimension(sisiMiringTerpancung, "Sisi Miring Terpancung");
            this.sisiMiringTerpancung = sisiMiringTerpancung;
            calculateHeightFromSlantHeight(); // Recalculate height if slant height changes
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getVolumeFrustum() {
        return volumeFrustum;
    }

    public Double getLuasPermukaanFrustum() {
        return luasPermukaanFrustum;
    }

    private void calculateSlantHeight() {
        if (radiusAtas != null && radiusBawah != null && tinggiKerucutTerpancung != null) {
            this.sisiMiringTerpancung = Math.sqrt(Math.pow(tinggiKerucutTerpancung, 2) + Math.pow(Math.abs(radiusBawah - radiusAtas), 2));
        }
    }

    private void calculateHeightFromSlantHeight() {
        if (radiusAtas != null && radiusBawah != null && sisiMiringTerpancung != null) {
            if (sisiMiringTerpancung < Math.abs(radiusBawah - radiusAtas)) {
                String errorMessage = "Sisi miring terpancung terlalu pendek untuk radius yang diberikan.";
                JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException(errorMessage);
            }
            this.tinggiKerucutTerpancung = Math.sqrt(Math.pow(sisiMiringTerpancung, 2) - Math.pow(Math.abs(radiusBawah - radiusAtas), 2));
        }
    }

    /**
     * Calculates the volume of the frustum of a cone.
     * Formula: V = (1/3) * pi * h * (R1^2 + R1*R2 + R2^2)
     * @return The calculated volume.
     */
    @Override
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeFrustum();
    }

    public Double hitungVolumeFrustum() { //
        if (radiusAtas == null || radiusBawah == null || tinggiKerucutTerpancung == null) {
            throw new IllegalStateException("Kedua radius dan tinggi kerucut terpancung harus diatur sebelum menghitung volume.");
        }
        this.volumeFrustum = (1.0 / 3.0) * Math.PI * tinggiKerucutTerpancung * (Math.pow(radiusAtas, 2) + (radiusAtas * radiusBawah) + Math.pow(radiusBawah, 2));
        this.kelilingAtauVolume = this.volumeFrustum;
        return this.volumeFrustum;
    }

    /**
     * Calculates the surface area of the frustum of a cone.
     * Formula: A = pi * (R1^2 + R2^2 + L * (R1 + R2)) where L is slant height
     * @return The calculated surface area.
     */
    @Override
    public Double hitungLuas() {
        return hitungLuasPermukaanFrustum();
    }

    public Double hitungLuasPermukaanFrustum() { //
        if (radiusAtas == null || radiusBawah == null || sisiMiringTerpancung == null) {
            throw new IllegalStateException("Kedua radius dan sisi miring kerucut terpancung harus diatur sebelum menghitung luas permukaan.");
        }
        this.luasPermukaanFrustum = Math.PI * (Math.pow(radiusAtas, 2) + Math.pow(radiusBawah, 2) + (sisiMiringTerpancung * (radiusAtas + radiusBawah)));
        this.luas = this.luasPermukaanFrustum;
        return this.luasPermukaanFrustum;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double r1, Double r2, Double h, Double l) {
        setRadiusAtas(r1);
        setRadiusBawah(r2);
        if (h != null) setTinggiKerucutTerpancung(h);
        if (l != null) setSisiMiringTerpancung(l);

        // Ensure consistency between height and slant height
        if (radiusAtas != null && radiusBawah != null) {
            if (tinggiKerucutTerpancung == null && sisiMiringTerpancung != null) {
                calculateHeightFromSlantHeight();
            } else if (tinggiKerucutTerpancung != null && sisiMiringTerpancung == null) {
                calculateSlantHeight();
            }
        }

        hitungVolumeFrustum();
        hitungLuasPermukaanFrustum();
    }
}