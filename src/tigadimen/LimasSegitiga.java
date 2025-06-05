package tigadimen;// tigadimen.LimasSegitiga.java
import javax.swing.JOptionPane;

public class LimasSegitiga extends Geometri {
    private Double alasSegitigaAlas;
    private Double tinggiSegitigaAlas;
    private Double sisi1Alas; // For perimeter of base if not right triangle
    private Double sisi2Alas;
    private Double sisi3Alas;
    private Double tinggiLimas;

    public LimasSegitiga() {
        super();
        this.nama = "Limas duadimen.Segitiga";
    }

    public void setAlasSegitigaAlas(Double alasSegitigaAlas) {
        validatePositiveDimension(alasSegitigaAlas, "Alas duadimen.Segitiga Alas");
        this.alasSegitigaAlas = alasSegitigaAlas;
    }

    public void setTinggiSegitigaAlas(Double tinggiSegitigaAlas) {
        validatePositiveDimension(tinggiSegitigaAlas, "Tinggi duadimen.Segitiga Alas");
        this.tinggiSegitigaAlas = tinggiSegitigaAlas;
    }

    public void setSisi1Alas(Double sisi1Alas) {
        validatePositiveDimension(sisi1Alas, "Sisi 1 Alas");
        this.sisi1Alas = sisi1Alas;
    }

    public void setSisi2Alas(Double sisi2Alas) {
        validatePositiveDimension(sisi2Alas, "Sisi 2 Alas");
        this.sisi2Alas = sisi2Alas;
    }

    public void setSisi3Alas(Double sisi3Alas) {
        validatePositiveDimension(sisi3Alas, "Sisi 3 Alas");
        this.sisi3Alas = sisi3Alas;
    }

    public void setTinggiLimas(Double tinggiLimas) {
        validatePositiveDimension(tinggiLimas, "Tinggi Limas");
        this.tinggiLimas = tinggiLimas;
    }

    // Volume Limas duadimen.Segitiga
    @Override
    public Double hitungKelilingAtauVolume() {
        if (alasSegitigaAlas == null || tinggiSegitigaAlas == null || tinggiLimas == null) {
            throw new IllegalStateException("Alas segitiga alas, tinggi segitiga alas, dan tinggi limas harus diatur untuk menghitung volume.");
        }
        Double luasAlas = 0.5 * alasSegitigaAlas * tinggiSegitigaAlas;
        kelilingAtauVolume = (1.0 / 3.0) * luasAlas * tinggiLimas;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Limas duadimen.Segitiga (assuming base is a general triangle, might need more info for specific side heights)
    @Override
    public Double hitungLuas() {
        if (alasSegitigaAlas == null || tinggiSegitigaAlas == null || tinggiLimas == null || sisi1Alas == null || sisi2Alas == null || sisi3Alas == null) {
            throw new IllegalStateException("Dimensi alas (alas, tinggi, sisi-sisi) dan tinggi limas harus diatur untuk menghitung luas permukaan.");
        }

        // Luas alas segitiga
        Double luasAlas = 0.5 * alasSegitigaAlas * tinggiSegitigaAlas;

        // Calculate area of each triangular face. This is complex and depends on whether it's a regular pyramid
        // or if we have specific slant heights. For simplicity, we'll assume it's a regular pyramid base
        // or that the individual face heights can be derived.
        // A more robust solution would require slant heights for each side or more specific base properties.
        // For now, we'll use a simplified approach assuming a "center" projection.

        // Perhitungan luas permukaan limas segitiga sangat tergantung pada bentuk alas
        // dan apakah itu limas tegak atau miring.
        // Untuk tujuan demonstrasi ini, kita akan menghitung luas alas dan memberikan
        // pesan bahwa luas sisi tegak memerlukan lebih banyak informasi atau asumsi.

        // This calculation is highly dependent on the type of triangular base (equilateral, isosceles, right)
        // and if it's a right pyramid. Without that information, calculating the slant heights for the lateral
        // faces is ambiguous.

        // A simple approach for a regular triangular pyramid (equilateral base)
        // For a general triangle base, this calculation is more involved.
        // If it's not a regular pyramid, the slant height for each face needs to be calculated
        // based on the height of the pyramid and the apothem/distance from the center of the base
        // to the midpoint of each base side.

        // Let's make an assumption for a general triangle: we need the height of each lateral face.
        // This would require either the centroid/incenter of the base and distances to midpoints,
        // or the lengths of the slant edges.

        // Placeholder for calculating lateral surface area - this part is simplified/generalized.
        // In a real application, you'd need more specific inputs for the type of triangle base
        // or individual slant heights for each face.
        JOptionPane.showMessageDialog(null, "Luas permukaan limas segitiga memerlukan informasi lebih lanjut (misal: tinggi miring setiap sisi tegak) atau asumsi bentuk alas (misal: segitiga sama sisi).");
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