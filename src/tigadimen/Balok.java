package tigadimen;

import duadimen.PersegiPanjang;

/**
 * Represents a cuboid (tigadimen.Balok), extending duadimen.PersegiPanjang.
 */
public class Balok extends PersegiPanjang { //

    private Double tinggi3D; //

    /**
     * Default constructor.
     */
    public Balok() { //
        super(); // Calls duadimen.PersegiPanjang's default constructor
        this.nama = "tigadimen.Balok";
    }

    /**
     * Constructor with dimensions.
     * @param panjang The length of the cuboid's base.
     * @param lebar The width of the cuboid's base.
     * @param tinggi3D The height of the cuboid.
     */
    public Balok(Double panjang, Double lebar, Double tinggi3D) { // Overloading constructor
        super(panjang, lebar); // Call duadimen.PersegiPanjang's constructor
        setTinggi3D(tinggi3D); // Use setter for validation
    }

    // Encapsulation: Getter and Setter
    public Double getTinggi3D() {
        return tinggi3D;
    }

    public void setTinggi3D(Double tinggi3D) {
        try {
            validatePositiveDimension(tinggi3D, "Tinggi tigadimen.Balok");
            this.tinggi3D = tinggi3D;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Overrides to calculate the volume of the cuboid.
     * Volume = Base Area * Height
     * @return The calculated volume.
     */
    @Override // Implementing main.BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolume();
    }

    public Double hitungVolume() { //
        if (getPanjang() == null || getLebar() == null || tinggi3D == null) {
            throw new IllegalStateException("Panjang, Lebar alas, dan Tinggi tigadimen.Balok harus diatur sebelum menghitung volume.");
        }
        // Reuse hitungLuas() from duadimen.PersegiPanjang for base area
        this.kelilingAtauVolume = super.hitungLuas() * tinggi3D; //
        return this.kelilingAtauVolume;
    }

    /**
     * Overrides to calculate the surface area of the cuboid.
     * Surface Area = 2 * (lw + lh + wh)
     * @return The calculated surface area.
     */
    @Override // Implementing main.BendaGeometri's abstract method for surface area
    public Double hitungLuas() {
        return hitungLuasPermukaan();
    }

    public Double hitungLuasPermukaan() { //
        if (getPanjang() == null || getLebar() == null || tinggi3D == null) {
            throw new IllegalStateException("Panjang, Lebar alas, dan Tinggi tigadimen.Balok harus diatur sebelum menghitung luas permukaan.");
        }
        Double l = getPanjang();
        Double w = getLebar();
        Double h = tinggi3D;
        this.luas = 2 * (l * w + l * h + w * h); //
        return this.luas;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double p, Double l, Double t) {
        setPanjang(p);
        setLebar(l);
        setTinggi3D(t);
        hitungVolume();
        hitungLuasPermukaan();
    }
}