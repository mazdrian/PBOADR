// PrismaTrapesium.java
import javax.swing.JOptionPane;

public class PrismaTrapesium extends Geometri {
    private Double sisiAtasAlas;
    private Double sisiBawahAlas;
    private Double tinggiTrapesiumAlas;
    private Double sisiMiring1Alas; // For perimeter of base
    private Double sisiMiring2Alas; // For perimeter of base
    private Double tinggiPrisma;

    public PrismaTrapesium() {
        super();
        this.nama = "Prisma Trapesium";
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
        validatePositiveDimension(tinggiTrapesiumAlas, "Tinggi Trapesium Alas");
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

    public void setTinggiPrisma(Double tinggiPrisma) {
        validatePositiveDimension(tinggiPrisma, "Tinggi Prisma");
        this.tinggiPrisma = tinggiPrisma;
    }

    // Volume Prisma Trapesium
    @Override
    public Double hitungKelilingAtauVolume() {
        if (sisiAtasAlas == null || sisiBawahAlas == null || tinggiTrapesiumAlas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Dimensi alas trapesium dan tinggi prisma harus diatur untuk menghitung volume.");
        }
        Double luasAlas = 0.5 * (sisiAtasAlas + sisiBawahAlas) * tinggiTrapesiumAlas;
        kelilingAtauVolume = luasAlas * tinggiPrisma;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Prisma Trapesium
    @Override
    public Double hitungLuas() {
        if (sisiAtasAlas == null || sisiBawahAlas == null || tinggiTrapesiumAlas == null || sisiMiring1Alas == null || sisiMiring2Alas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Dimensi alas trapesium (sisi atas, sisi bawah, tinggi, sisi miring) dan tinggi prisma harus diatur untuk menghitung luas permukaan.");
        }
        Double luasAlas = 0.5 * (sisiAtasAlas + sisiBawahAlas) * tinggiTrapesiumAlas;
        Double kelilingAlas = sisiAtasAlas + sisiBawahAlas + sisiMiring1Alas + sisiMiring2Alas;
        luas = (2 * luasAlas) + (kelilingAlas * tinggiPrisma);
        return luas;
    }

    public Double hitungVolume() {
        return hitungKelilingAtauVolume();
    }

    public Double hitungLuasPermukaan() {
        return hitungLuas();
    }
}