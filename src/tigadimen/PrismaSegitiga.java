package tigadimen;// tigadimen.PrismaSegitiga.java

public class PrismaSegitiga extends Geometri {
    private Double alasSegitigaAlas;
    private Double tinggiSegitigaAlas;
    private Double sisi1Alas; // For perimeter of base
    private Double sisi2Alas;
    private Double sisi3Alas;
    private Double tinggiPrisma;

    public PrismaSegitiga() {
        super();
        this.nama = "Prisma duadimen.Segitiga";
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

    public void setTinggiPrisma(Double tinggiPrisma) {
        validatePositiveDimension(tinggiPrisma, "Tinggi Prisma");
        this.tinggiPrisma = tinggiPrisma;
    }

    // Volume Prisma duadimen.Segitiga
    @Override
    public Double hitungKelilingAtauVolume() {
        if (alasSegitigaAlas == null || tinggiSegitigaAlas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Alas segitiga alas, tinggi segitiga alas, dan tinggi prisma harus diatur untuk menghitung volume.");
        }
        Double luasAlas = 0.5 * alasSegitigaAlas * tinggiSegitigaAlas;
        kelilingAtauVolume = luasAlas * tinggiPrisma;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Prisma duadimen.Segitiga
    @Override
    public Double hitungLuas() {
        if (alasSegitigaAlas == null || tinggiSegitigaAlas == null || sisi1Alas == null || sisi2Alas == null || sisi3Alas == null || tinggiPrisma == null) {
            throw new IllegalStateException("Dimensi alas segitiga (alas, tinggi, sisi-sisi) dan tinggi prisma harus diatur untuk menghitung luas permukaan.");
        }
        Double luasAlas = 0.5 * alasSegitigaAlas * tinggiSegitigaAlas;
        Double kelilingAlas = sisi1Alas + sisi2Alas + sisi3Alas;
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