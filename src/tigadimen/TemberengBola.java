package tigadimen;// tigadimen.TemberengBola.java

public class TemberengBola extends Geometri {
    private Double radiusBola;
    private Double tinggiTembereng;

    public TemberengBola() {
        super();
        this.nama = "Tembereng tigadimen.Bola";
    }

    public void setRadius(Double radiusBola) {
        validatePositiveDimension(radiusBola, "Radius tigadimen.Bola");
        this.radiusBola = radiusBola;
    }

    public void setTinggiTembereng(Double tinggiTembereng) {
        validatePositiveDimension(tinggiTembereng, "Tinggi Tembereng");
        if (tinggiTembereng > radiusBola * 2) {
            throw new IllegalArgumentException("Tinggi tembereng tidak boleh lebih besar dari diameter bola.");
        }
        this.tinggiTembereng = tinggiTembereng;
    }

    @Override
    public Double hitungLuas() { // Luas Permukaan Tembereng tigadimen.Bola
        if (radiusBola == null || tinggiTembereng == null) {
            throw new IllegalStateException("Radius bola dan tinggi tembereng harus diatur untuk menghitung luas permukaan tembereng.");
        }
        // Formula for the curved surface area of a spherical cap
        luas = 2 * Math.PI * radiusBola * tinggiTembereng;
        return luas;
    }

    @Override
    public Double hitungKelilingAtauVolume() { // Volume Tembereng tigadimen.Bola
        if (radiusBola == null || tinggiTembereng == null) {
            throw new IllegalStateException("Radius bola dan tinggi tembereng harus diatur untuk menghitung volume tembereng.");
        }
        // Formula for the volume of a spherical cap
        kelilingAtauVolume = (1.0 / 3.0) * Math.PI * tinggiTembereng * tinggiTembereng * (3 * radiusBola - tinggiTembereng);
        return kelilingAtauVolume;
    }

    public Double hitungVolumeTembereng() {
        return hitungKelilingAtauVolume();
    }

    public Double hitungLuasPermukaanTembereng() {
        return hitungLuas();
    }
}