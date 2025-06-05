package tigadimen;// tigadimen.Tabung.java

public class Tabung extends Geometri {
    private Double radius;
    private Double tinggiTabung;

    public Tabung() {
        super();
        this.nama = "tigadimen.Tabung";
    }

    public void setRadius(Double radius) {
        validatePositiveDimension(radius, "Radius");
        this.radius = radius;
    }

    public void setTinggiTabung(Double tinggiTabung) {
        validatePositiveDimension(tinggiTabung, "Tinggi tigadimen.Tabung");
        this.tinggiTabung = tinggiTabung;
    }

    // Luas Permukaan tigadimen.Tabung
    @Override
    public Double hitungLuas() {
        if (radius == null || tinggiTabung == null) {
            throw new IllegalStateException("Radius dan tinggi tabung harus diatur untuk menghitung luas permukaan.");
        }
        luas = 2 * Math.PI * radius * (radius + tinggiTabung);
        return luas;
    }

    // Volume tigadimen.Tabung
    @Override
    public Double hitungKelilingAtauVolume() { // Used for volume
        if (radius == null || tinggiTabung == null) {
            throw new IllegalStateException("Radius dan tinggi tabung harus diatur untuk menghitung volume.");
        }
        kelilingAtauVolume = Math.PI * radius * radius * tinggiTabung;
        return kelilingAtauVolume;
    }

    // Specific method for volume for clarity in MainGeometryApp
    public Double hitungVolume() {
        return hitungKelilingAtauVolume();
    }

    // Specific method for surface area for clarity in MainGeometryApp
    public Double hitungLuasPermukaan() {
        return hitungLuas();
    }
}