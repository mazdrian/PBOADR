// Trapesium.java
import javax.swing.JOptionPane;

public class Trapesium extends DuaDimensi {
    private Double sisiAtas;
    private Double sisiBawah;
    private Double sisiMiring1;
    private Double sisiMiring2;
    private Double tinggi;

    public Trapesium() {
        super();
        this.nama = "Trapesium";
    }

    public Double getSisiAtas() {
        return sisiAtas;
    }

    public void setSisiAtas(Double sisiAtas) {
        validatePositiveDimension(sisiAtas, "Sisi Atas");
        this.sisiAtas = sisiAtas;
    }

    public Double getSisiBawah() {
        return sisiBawah;
    }

    public void setSisiBawah(Double sisiBawah) {
        validatePositiveDimension(sisiBawah, "Sisi Bawah");
        this.sisiBawah = sisiBawah;
    }

    public void setSisiMiring1(Double sisiMiring1) {
        validatePositiveDimension(sisiMiring1, "Sisi Miring 1");
        this.sisiMiring1 = sisiMiring1;
    }

    public void setSisiMiring2(Double sisiMiring2) {
        validatePositiveDimension(sisiMiring2, "Sisi Miring 2");
        this.sisiMiring2 = sisiMiring2;
    }

    public void setTinggi(Double tinggi) {
        validatePositiveDimension(tinggi, "Tinggi");
        this.tinggi = tinggi;
    }

    @Override
    public Double hitungLuas() {
        if (sisiAtas == null || sisiBawah == null || tinggi == null) {
            throw new IllegalStateException("Sisi atas, sisi bawah, dan tinggi harus diatur untuk menghitung luas Trapesium.");
        }
        luas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
        return luas;
    }

    @Override
    public Double hitungKeliling() {
        if (sisiAtas == null || sisiBawah == null || sisiMiring1 == null || sisiMiring2 == null) {
            throw new IllegalStateException("Keempat sisi harus diatur untuk menghitung keliling Trapesium.");
        }
        kelilingAtauVolume = sisiAtas + sisiBawah + sisiMiring1 + sisiMiring2;
        return kelilingAtauVolume;
    }
}