package duadimen;// duadimen.TemberengLingkaran.java

import javax.swing.JOptionPane;

public class TemberengLingkaran extends DuaDimensi {
    private Double radiusLingkaran;
    private Double sudutPusatRadian; // Sudut dalam radian

    public TemberengLingkaran() {
        super();
        this.nama = "Tembereng duadimen.Lingkaran";
    }

    public void setRadius(Double radiusLingkaran) {
        validatePositiveDimension(radiusLingkaran, "Radius duadimen.Lingkaran");
        this.radiusLingkaran = radiusLingkaran;
    }

    public void setSudutPusatRadian(Double sudutPusatRadian) {
        if (sudutPusatRadian == null || sudutPusatRadian <= 0 || sudutPusatRadian > 2 * Math.PI) {
            String errorMessage = "Sudut pusat harus bernilai positif dan tidak lebih dari 2*PI radian.";
            JOptionPane.showMessageDialog(null, errorMessage, "Input Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException(errorMessage);
        }
        this.sudutPusatRadian = sudutPusatRadian;
    }

    @Override
    public Double hitungLuas() { // Luas Tembereng duadimen.Lingkaran
        if (radiusLingkaran == null || sudutPusatRadian == null) {
            throw new IllegalStateException("Radius lingkaran dan sudut pusat harus diatur untuk menghitung luas tembereng.");
        }
        // Area of circular segment = Area of sector - Area of triangle
        luas = 0.5 * radiusLingkaran * radiusLingkaran * (sudutPusatRadian - Math.sin(sudutPusatRadian));
        return luas;
    }

    @Override
    public Double hitungKeliling() { // Keliling Tembereng duadimen.Lingkaran
        if (radiusLingkaran == null || sudutPusatRadian == null) {
            throw new IllegalStateException("Radius lingkaran dan sudut pusat harus diatur untuk menghitung keliling tembereng.");
        }
        // Keliling tembereng = panjang busur + panjang tali busur
        Double panjangBusur = radiusLingkaran * sudutPusatRadian;
        Double panjangTaliBusur = 2 * radiusLingkaran * Math.sin(sudutPusatRadian / 2.0);
        kelilingAtauVolume = panjangBusur + panjangTaliBusur;
        return kelilingAtauVolume;
    }

    public Double hitungLuasTembereng() {
        return hitungLuas();
    }

    public Double hitungKelilingTembereng() {
        return hitungKeliling();
    }
}