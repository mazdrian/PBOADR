package tigadimen;

import duadimen.Lingkaran;

/**
 * Represents a sphere (tigadimen.Bola), extending duadimen.Lingkaran.
 * Menerapkan inheritance secara penuh dari Lingkaran.
 */
public class Bola extends Lingkaran {

    /**
     * Default constructor.
     * Memanggil konstruktor default dari Lingkaran.
     */
    public Bola() {
        super(); // Memanggil Lingkaran()
        this.nama = "tigadimen.Bola"; // Set nama objek untuk Bola
    }

    /**
     * Constructor with initial radius.
     * Menggunakan konstruktor Lingkaran untuk mengatur radius.
     * @param radius The radius of the sphere.
     */
    public Bola(Double radius) {
        super(radius); // Memanggil Lingkaran(radius) untuk mengatur radius
        this.nama = "tigadimen.Bola"; // Set nama objek untuk Bola
    }

    // Variabel 'radius' tidak perlu dideklarasikan di sini karena sudah diwarisi dari Lingkaran.
    // Metode getRadius() dan setRadius() juga diwarisi dari Lingkaran.

    /**
     * Overrides to calculate the surface area of the sphere.
     * Menggunakan luas lingkaran dari superclass (Lingkaran) untuk perhitungan.
     * @return The calculated surface area.
     */
    @Override // Mengimplementasikan metode abstrak hitungLuas dari BendaGeometri (melalui Lingkaran)
    public Double hitungLuas() {
        // Kita tidak perlu memeriksa 'radius' di sini, karena sudah diwarisi dan diatur oleh Lingkaran.
        // Jika radius belum diatur di Lingkaran, super.hitungLuas() akan menangani pengecualian.

        // Luas permukaan bola adalah 4 kali luas lingkaran dengan radius yang sama.
        // super.hitungLuas() akan menghitung luas lingkaran (πr^2).
        this.luas = 4 * super.hitungLuas();
        return this.luas;
    }

    /**
     * Overrides to calculate the volume of the sphere.
     * Menggunakan radius yang diwarisi dari Lingkaran.
     * @return The calculated volume.
     */
    @Override // Mengimplementasikan metode abstrak hitungKelilingAtauVolume dari BendaGeometri (melalui Lingkaran)
    public Double hitungKelilingAtauVolume() { // Di sini kita asumsikan ini adalah hitung volume
        // Kita menggunakan getRadius() yang diwarisi dari Lingkaran.
        if (super.getRadius() == null) {
            throw new IllegalStateException("Radius harus diatur sebelum menghitung volume.");
        }
        this.kelilingAtauVolume = (4.0 / 3.0) * Math.PI * Math.pow(super.getRadius(), 3);
        return this.kelilingAtauVolume;
    }

    /**
     * Overloading: Method to set radius and calculate both surface area and volume.
     * Menggunakan setRadius() yang diwarisi dari Lingkaran.
     * @param r The radius to set.
     */
    public void setRadiusAndCalculate(Double r) {
        super.setRadius(r); // Atur radius melalui method setter Lingkaran
        hitungLuas(); // Hitung luas permukaan bola
        hitungKelilingAtauVolume(); // Hitung volume bola
    }
}