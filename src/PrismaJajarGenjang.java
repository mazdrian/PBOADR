// PrismaJajarGenjang.java
import javax.swing.JOptionPane;

public class PrismaJajarGenjang extends Geometri {
    private Double alasJajarGenjang;
    private Double tinggiJajarGenjangAlas;
    private Double sisiMiringAlas; // For perimeter of base
    private Double tinggiPrisma;

    public PrismaJajarGenjang() {
        super();
        this.nama = "Prisma Jajar Genjang";
    }

    public void setAlasJajarGenjang(Double alasJajarGenjang) {
        validatePositiveDimension(alasJajarGenjang, "Alas Jajar Genjang");
        this.alasJajarGenjang = alasJajarGenjang;
    }

    public void setTinggiJajarGenjangAlas(Double tinggiJajarGenjangAlas) {
        validatePositiveDimension(tinggiJajarGenjangAlas, "Tinggi Jajar Genjang Alas");
        this.tinggiJajarGenjangAlas = tinggiJajarGenjangAlas;
    }

    public void setSisiMiringAlas(Double sisiMiringAlas) {
        validatePositiveDimension(sisiMiringAlas, "Sisi Miring Alas");
        this.sisiMiringAlas = sisiMiringAlas;
    }

    public void setTinggiPrisma(Double tinggiPrisma) {
        validatePositiveDimension(tinggiPrisma, "Tinggi Prisma");
        this.tinggiPrisma = tinggiPrisma;
    }

    // Volume Prisma Jajar Genjang
    @Override
    public Double hitungKelilingAtauVolume() {
        if (alasJajarGenjang == null || tinggiJajarGenjangAlas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Alas jajar genjang, tinggi jajar genjang alas, dan tinggi prisma harus diatur untuk menghitung volume.");
        }
        Double luasAlas = alasJajarGenjang * tinggiJajarGenjangAlas;
        kelilingAtauVolume = luasAlas * tinggiPrisma;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Prisma Jajar Genjang
    @Override
    public Double hitungLuas() {
        if (alasJajarGenjang == null || tinggiJajarGenjangAlas == null || sisiMiringAlas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Alas jajar genjang, tinggi jajar genjang alas, sisi miring alas, dan tinggi prisma harus diatur untuk menghitung luas permukaan.");
        }
        Double luasAlas = alasJajarGenjang * tinggiJajarGenjangAlas;
        Double kelilingAlas = 2 * (alasJajarGenjang + sisiMiringAlas);
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