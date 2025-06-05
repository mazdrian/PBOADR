// PrismaLayangLayang.java
import javax.swing.JOptionPane;

public class PrismaLayangLayang extends Geometri {
    private Double diagonalHorizontalAlas;
    private Double diagonalVertikalAlas;
    private Double sisiAAlas; // For perimeter of base
    private Double sisiBAlas; // For perimeter of base
    private Double tinggiPrismaLayangLayang;

    public PrismaLayangLayang() {
        super();
        this.nama = "Prisma Layang-Layang";
    }

    public void setDiagonalHorizontal(Double diagonalHorizontalAlas) {
        validatePositiveDimension(diagonalHorizontalAlas, "Diagonal Horizontal Alas");
        this.diagonalHorizontalAlas = diagonalHorizontalAlas;
    }

    public void setDiagonalVertikal(Double diagonalVertikalAlas) {
        validatePositiveDimension(diagonalVertikalAlas, "Diagonal Vertikal Alas");
        this.diagonalVertikalAlas = diagonalVertikalAlas;
    }

    public void setSisiA(Double sisiAAlas) {
        validatePositiveDimension(sisiAAlas, "Sisi A Alas");
        this.sisiAAlas = sisiAAlas;
    }

    public void setSisiB(Double sisiBAlas) {
        validatePositiveDimension(sisiBAlas, "Sisi B Alas");
        this.sisiBAlas = sisiBAlas;
    }

    public void setTinggiPLL(Double tinggiPrismaLayangLayang) {
        validatePositiveDimension(tinggiPrismaLayangLayang, "Tinggi Prisma Layang-Layang");
        this.tinggiPrismaLayangLayang = tinggiPrismaLayangLayang;
    }

    // Volume Prisma Layang-Layang
    @Override
    public Double hitungKelilingAtauVolume() {
        if (diagonalHorizontalAlas == null || diagonalVertikalAlas == null || tinggiPrismaLayangLayang == null) {
            throw new IllegalStateException("Diagonal alas dan tinggi prisma harus diatur untuk menghitung volume.");
        }
        // Area of base (Kite) = 0.5 * d1 * d2
        Double luasAlas = 0.5 * diagonalHorizontalAlas * diagonalVertikalAlas;
        kelilingAtauVolume = luasAlas * tinggiPrismaLayangLayang;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Prisma Layang-Layang
    @Override
    public Double hitungLuas() {
        if (diagonalHorizontalAlas == null || diagonalVertikalAlas == null || sisiAAlas == null || sisiBAlas == null || tinggiPrismaLayangLayang == null) {
            throw new IllegalStateException("Diagonal alas, sisi-sisi alas, dan tinggi prisma harus diatur untuk menghitung luas permukaan.");
        }
        // Area of base (Kite) = 0.5 * d1 * d2
        Double luasAlas = 0.5 * diagonalHorizontalAlas * diagonalVertikalAlas;
        // Perimeter of base (Kite) = 2 * (sideA + sideB)
        Double kelilingAlas = 2 * (sisiAAlas + sisiBAlas);
        luas = (2 * luasAlas) + (kelilingAlas * tinggiPrismaLayangLayang);
        return luas;
    }

    public Double hitungVolume() {
        return hitungKelilingAtauVolume();
    }

    public Double hitungLuasPermukaan() {
        return hitungLuas();
    }
}