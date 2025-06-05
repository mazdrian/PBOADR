// PrismaBelahKetupat.java
import javax.swing.JOptionPane;

public class PrismaBelahKetupat extends Geometri {
    private Double diagonal1Alas;
    private Double diagonal2Alas;
    private Double sisiAlas; // For perimeter of base
    private Double tinggiPrisma;

    public PrismaBelahKetupat() {
        super();
        this.nama = "Prisma Belah Ketupat";
    }

    public void setDiagonal1(Double diagonal1Alas) {
        validatePositiveDimension(diagonal1Alas, "Diagonal 1 Alas");
        this.diagonal1Alas = diagonal1Alas;
    }

    public void setDiagonal2(Double diagonal2Alas) {
        validatePositiveDimension(diagonal2Alas, "Diagonal 2 Alas");
        this.diagonal2Alas = diagonal2Alas;
    }

    public void setSisi(Double sisiAlas) {
        validatePositiveDimension(sisiAlas, "Sisi Alas");
        this.sisiAlas = sisiAlas;
    }

    public void setTinggi3D(Double tinggiPrisma) {
        validatePositiveDimension(tinggiPrisma, "Tinggi Prisma");
        this.tinggiPrisma = tinggiPrisma;
    }

    // Volume Prisma Belah Ketupat
    @Override
    public Double hitungKelilingAtauVolume() {
        if (diagonal1Alas == null || diagonal2Alas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Diagonal alas dan tinggi prisma harus diatur untuk menghitung volume.");
        }
        // Area of base (Rhombus) = 0.5 * d1 * d2
        Double luasAlas = 0.5 * diagonal1Alas * diagonal2Alas;
        kelilingAtauVolume = luasAlas * tinggiPrisma;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Prisma Belah Ketupat
    @Override
    public Double hitungLuas() {
        if (diagonal1Alas == null || diagonal2Alas == null || sisiAlas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Diagonal alas, sisi alas, dan tinggi prisma harus diatur untuk menghitung luas permukaan.");
        }
        // Area of base (Rhombus) = 0.5 * d1 * d2
        Double luasAlas = 0.5 * diagonal1Alas * diagonal2Alas;
        // Perimeter of base (Rhombus) = 4 * side
        Double kelilingAlas = 4 * sisiAlas;
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