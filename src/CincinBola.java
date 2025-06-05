
import javax.swing.JOptionPane;

public class CincinBola extends Geometri {
    private Double radiusDalam;
    private Double radiusLuar;

    public CincinBola() {
        super();
        this.nama = "Cincin Bola";
    }

    public void setRadiusDalam(Double radiusDalam) {
        validatePositiveDimension(radiusDalam, "Radius Dalam");
        this.radiusDalam = radiusDalam;
    }

    public void setRadiusLuar(Double radiusLuar) {
        validatePositiveDimension(radiusLuar, "Radius Luar");
        if (radiusLuar <= this.radiusDalam) {
            String errorMessage = "Radius luar harus lebih besar dari radius dalam.";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
        this.radiusLuar = radiusLuar;
    }

    @Override
    public Double hitungLuas() { // Luas Permukaan Cincin Bola (beda dgn cincin biasa)
        // This interpretation assumes it's the surface area of a spherical shell
        if (radiusDalam == null || radiusLuar == null) {
            throw new IllegalStateException("Kedua radius harus diatur untuk menghitung luas permukaan cincin bola.");
        }
        luas = 4 * Math.PI * (Math.pow(radiusLuar, 2) + Math.pow(radiusDalam, 2));
        return luas;
    }

    @Override
    public Double hitungKelilingAtauVolume() { // Volume Cincin Bola (beda dgn cincin biasa)
        // This interpretation assumes it's the volume of a spherical shell
        if (radiusDalam == null || radiusLuar == null) {
            throw new IllegalStateException("Kedua radius harus diatur untuk menghitung volume cincin bola.");
        }
        kelilingAtauVolume = (4.0 / 3.0) * Math.PI * (Math.pow(radiusLuar, 3) - Math.pow(radiusDalam, 3));
        return kelilingAtauVolume;
    }

    public Double hitungVolumeCincinBola() {
        return hitungKelilingAtauVolume();
    }

    public Double hitungLuasPermukaanCincinBola() {
        return hitungLuas();
    }
}