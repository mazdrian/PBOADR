package duadimen;// duadimen.Segitiga.java

public class Segitiga extends DuaDimensi {
    private Double alas;
    private Double tinggi;
    private Double sisi1;
    private Double sisi2;
    private Double sisi3;

    public Segitiga() {
        super();
        this.nama = "duadimen.Segitiga";
    }

    public void setAlas(Double alas) {
        validatePositiveDimension(alas, "Alas");
        this.alas = alas;
    }

    public void setTinggi(Double tinggi) {
        validatePositiveDimension(tinggi, "Tinggi");
        this.tinggi = tinggi;
    }

    public void setSisi1(Double sisi1) {
        validatePositiveDimension(sisi1, "Sisi 1");
        this.sisi1 = sisi1;
    }

    public void setSisi2(Double sisi2) {
        validatePositiveDimension(sisi2, "Sisi 2");
        this.sisi2 = sisi2;
    }

    public void setSisi3(Double sisi3) {
        validatePositiveDimension(sisi3, "Sisi 3");
        this.sisi3 = sisi3;
    }

    @Override
    public Double hitungLuas() {
        if (alas == null || tinggi == null) {
            throw new IllegalStateException("Alas dan tinggi harus diatur untuk menghitung luas duadimen.Segitiga.");
        }
        luas = 0.5 * alas * tinggi;
        return luas;
    }

    @Override
    public Double hitungKeliling() {
        if (sisi1 == null || sisi2 == null || sisi3 == null) {
            throw new IllegalStateException("Ketiga sisi harus diatur untuk menghitung keliling duadimen.Segitiga.");
        }
        kelilingAtauVolume = sisi1 + sisi2 + sisi3;
        return kelilingAtauVolume;
    }
}