package tigadimen;// tigadimen.LimasPersegiPanjang.java

public class LimasPersegiPanjang extends Geometri {
    private Double panjangAlas;
    private Double lebarAlas;
    private Double tinggiLimas;

    public LimasPersegiPanjang() {
        super();
        this.nama = "Limas duadimen.Persegi Panjang";
    }

    public void setPanjangAlas(Double panjangAlas) {
        validatePositiveDimension(panjangAlas, "Panjang Alas");
        this.panjangAlas = panjangAlas;
    }

    public void setLebarAlas(Double lebarAlas) {
        validatePositiveDimension(lebarAlas, "Lebar Alas");
        this.lebarAlas = lebarAlas;
    }

    public void setTinggiLimas(Double tinggiLimas) {
        validatePositiveDimension(tinggiLimas, "Tinggi Limas");
        this.tinggiLimas = tinggiLimas;
    }

    // Volume Limas duadimen.Persegi Panjang
    @Override
    public Double hitungKelilingAtauVolume() {
        if (panjangAlas == null || lebarAlas == null || tinggiLimas == null) {
            throw new IllegalStateException("Panjang alas, lebar alas, dan tinggi limas harus diatur untuk menghitung volume.");
        }
        Double luasAlas = panjangAlas * lebarAlas;
        kelilingAtauVolume = (1.0 / 3.0) * luasAlas * tinggiLimas;
        return kelilingAtauVolume;
    }

    // Luas Permukaan Limas duadimen.Persegi Panjang
    @Override
    public Double hitungLuas() {
        if (panjangAlas == null || lebarAlas == null || tinggiLimas == null) {
            throw new IllegalStateException("Panjang alas, lebar alas, dan tinggi limas harus diatur untuk menghitung luas permukaan.");
        }

        // Luas alas
        Double luasAlas = panjangAlas * lebarAlas;

        // Tinggi sisi tegak segitiga di panjang (menggunakan Pythagoras)
        Double tinggiSisiTegakPanjang = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(lebarAlas / 2, 2));
        Double luasSisiTegakPanjang = 0.5 * panjangAlas * tinggiSisiTegakPanjang;

        // Tinggi sisi tegak segitiga di lebar (menggunakan Pythagoras)
        Double tinggiSisiTegakLebar = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(panjangAlas / 2, 2));
        Double luasSisiTegakLebar = 0.5 * lebarAlas * tinggiSisiTegakLebar;

        luas = luasAlas + (2 * luasSisiTegakPanjang) + (2 * luasSisiTegakLebar);
        return luas;
    }

    public Double hitungVolumeLimas() {
        return hitungKelilingAtauVolume();
    }

    public Double hitungLuasPermukaanLimas() {
        return hitungLuas();
    }
}