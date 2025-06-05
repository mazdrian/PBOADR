package tigadimen;// tigadimen.LimasTrapesium.java
import javax.swing.JOptionPane;

public class LimasTrapesium extends Geometri {
    private Double sisiAtasAlas;
    private Double sisiBawahAlas;
    private Double tinggiTrapesiumAlas;
    private Double sisiMiring1Alas; // For perimeter of base
    private Double sisiMiring2Alas; // For perimeter of base
    private Double tinggiLimas;

    public LimasTrapesium() {
        super();
        this.nama = "Limas duadimen.Trapesium";
    }

    public void setSisiAtasAlas(Double sisiAtasAlas) {
        validatePositiveDimension(sisiAtasAlas, "Sisi Atas Alas");
        this.sisiAtasAlas = sisiAtasAlas;
    }

    public void setSisiBawahAlas(Double sisiBawahAlas) {
        validatePositiveDimension(sisiBawahAlas, "Sisi Bawah Alas");
        this.sisiBawahAlas = sisiBawahAlas;
    }

    public void setTinggiTrapesiumAlas(Double tinggiTrapesiumAlas) {
        validatePositiveDimension(tinggiTrapesiumAlas, "Tinggi duadimen.Trapesium Alas");
        this.tinggiTrapesiumAlas = tinggiTrapesiumAlas;
    }

    public void setSisiMiring1Alas(Double sisiMiring1Alas) {
        validatePositiveDimension(sisiMiring1Alas, "Sisi Miring 1 Alas");
        this.sisiMiring1Alas = sisiMiring1Alas;
    }

    public void setSisiMiring2Alas(Double sisiMiring2Alas) {
        validatePositiveDimension(sisiMiring2Alas, "Sisi Miring 2 Alas");
        this.sisiMiring2Alas = sisiMiring2Alas;
    }

    public void setTinggiLimas(Double tinggiLimas) {
        validatePositiveDimension(tinggiLimas, "Tinggi Limas");
        this.tinggiLimas = tinggiLimas;
    }

    // Volume Limas duadimen.Trapesium
    @Override
    public Double hitungKelilingAtauVolume() {
        if (sisiAtasAlas == null || sisiBawahAlas == null || tinggiTrapesiumAlas == null || tinggiLimas == null) {
            throw new IllegalStateException("Dimensi alas trapesium dan tinggi limas harus diatur untuk menghitung volume.");
        }
        Double luasAlas = 0.5 * (sisiAtasAlas + sisiBawahAlas) * tinggiTrapesiumAlas;
        kelilingAtauVolume = (1.0 / 3.0) * luasAlas * tinggiLimas;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Limas duadimen.Trapesium
    @Override
    public Double hitungLuas() {
        if (sisiAtasAlas == null || sisiBawahAlas == null || tinggiTrapesiumAlas == null || sisiMiring1Alas == null || sisiMiring2Alas == null || tinggiLimas == null) {
            throw new IllegalStateException("Dimensi alas trapesium (sisi atas, sisi bawah, tinggi, sisi miring) dan tinggi limas harus diatur untuk menghitung luas permukaan.");
        }

        // Luas alas trapesium
        Double luasAlas = 0.5 * (sisiAtasAlas + sisiBawahAlas) * tinggiTrapesiumAlas;

        // This calculation for lateral surface area is complex and depends on the specific
        // type of trapezoid and whether the pyramid is right or oblique.
        // It generally involves calculating the slant height of each triangular face.
        // For a general trapezoidal pyramid, this is often not straightforward without
        // more specific geometric information (e.g., coordinates, or specific slant heights).

        // Placeholder for calculating lateral surface area - this part is simplified/generalized.
        // In a real application, you'd need more specific inputs for the type of trapezoid base
        // or individual slant heights for each face.
        JOptionPane.showMessageDialog(null, "Luas permukaan limas trapesium memerlukan informasi lebih lanjut (misal: tinggi miring setiap sisi tegak) atau asumsi bentuk alas.");
        luas = luasAlas; // Only base area for now, indicating complexity.
        return luas;
    }

    public Double hitungVolumeLimas() {
        return hitungKelilingAtauVolume();
    }

    public Double hitungLuasPermukaanLimas() {
        return hitungLuas();
    }
}