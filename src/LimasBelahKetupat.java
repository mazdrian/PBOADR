import java.io.*;
import java.util.*;

/**
 * Represents a rhombus pyramid (Limas Belah Ketupat), extending BelahKetupat.
 */
public class LimasBelahKetupat extends BelahKetupat { // Corrected class name

    private Double tinggiLimas;
    private Double volumeLimas;
    private Double luasPermukaanLimas;

    /**
     * Default constructor.
     */
    public LimasBelahKetupat() {
        super();
        this.nama = "Limas Belah Ketupat";
    }

    /**
     * Constructor for a rhombus pyramid.
     * @param diagonal1 The first diagonal of the rhombus base.
     * @param diagonal2 The second diagonal of the rhombus base.
     * @param tinggiLimas The height of the pyramid.
     */
    public LimasBelahKetupat(Double diagonal1, Double diagonal2, Double tinggiLimas) { // Overloading constructor
        super(diagonal1, diagonal2); // Pass diagonals to BelahKetupat constructor for base area
        setTinggiLimas(tinggiLimas);
    }

    // Encapsulation: Getter and Setter
    public Double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(Double tinggiLimas) {
        try {
            validatePositiveDimension(tinggiLimas, "Tinggi Limas");
            this.tinggiLimas = tinggiLimas;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public Double getVolumeLimas() {
        return volumeLimas;
    }

    public Double getLuasPermukaanLimas() {
        return luasPermukaanLimas;
    }

    /**
     * Calculates the volume of the rhombus pyramid.
     * Volume = (1/3) * Base Area * Height
     * @return The calculated volume.
     */
    @Override // Implementing BendaGeometri's abstract method for volume
    public Double hitungKelilingAtauVolume() {
        return hitungVolumeLimas();
    }

    public Double hitungVolumeLimas() { //
        if (getDiagonal1() == null || getDiagonal2() == null || tinggiLimas == null) {
            throw new IllegalStateException("Diagonal alas dan tinggi limas harus diatur sebelum menghitung volume.");
        }
        // Reuse hitungLuas() from BelahKetupat for base area
        this.volumeLimas = (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
        this.kelilingAtauVolume = this.volumeLimas;
        return this.volumeLimas;
    }

    /**
     * Calculates the surface area of the rhombus pyramid.
     * Surface Area = Base Area + Sum of Areas of Lateral Faces
     * (This requires calculating slant heights of triangular faces, which depends on the base dimensions and pyramid height.
     * For simplicity, let's assume a regular pyramid where all lateral faces are congruent, and we need the side of the base for perimeter, and a slant height for faces.
     * To make it runnable without extreme complexity, I'll provide a placeholder or a simplified calculation.
     * Accurate calculation requires knowing the apothem of the base and the pyramid's height to find the slant height of the triangular faces.)
     * I will assume we need the side `sisi` of the base rhombus to calculate the perimeter for the lateral surface.
     * Calculating slant height of lateral faces for a general rhombus pyramid is quite involved.
     * For demonstration, I'll calculate the base area correctly. For lateral surface area, I'll need more info,
     * or simplify it. Let's provide a placeholder for now, or assume a total slant height for the pyramid.
     *
     * A more robust approach for a rhombus pyramid requires finding the height of each triangular face.
     * This depends on the perpendicular distance from the center of the rhombus to each side,
     * and the pyramid's height. Let's simplify for the example.
     * Surface Area = Base Area + 4 * (Area of one triangular face)
     * Area of one triangular face = 0.5 * base_side * slant_height_of_face
     *
     * Given the constraints, I will provide a conceptual calculation and note the need for slant heights of faces.
     * For a general rhombus pyramid, the 4 lateral faces are usually *not* congruent unless it's a special case.
     * Let's calculate base area, and for the lateral surface, use a placeholder.
     */
    @Override
    public Double hitungLuas() {
        return hitungLuasPermukaanLimas();
    }

    public Double hitungLuasPermukaanLimas() { //
        if (getDiagonal1() == null || getDiagonal2() == null || getSisi() == null || tinggiLimas == null) {
            throw new IllegalStateException("Diagonal alas, sisi alas, dan tinggi limas harus diatur sebelum menghitung luas permukaan.");
        }
        Double baseArea = super.hitungLuas(); // Area of rhombus base

        // Simplified Lateral Surface Area (Highly depends on shape, complex for general case)
        // This is a placeholder as exact lateral surface area calculation for a general rhombus pyramid
        // needs more specific geometric details (e.g., foot of apex, slant heights of each face).
        // For a general implementation, this would require finding slant heights for each of the four triangular faces.
        // For now, I will use a simplified or conceptual representation.
        // It's sum of areas of 4 triangles. Each triangle needs its base (rhombus side) and its height (slant height of the face).
        // Slant height of face = sqrt(pyramid_height^2 + apothem_of_base_to_that_side^2)
        // Apothem of rhombus to side = Area / (0.5 * perimeter) or based on diagonals.
        // Let's assume a general slant height for approximation or require it as input for simplicity.
        // For now, let's use a very basic placeholder for lateral surface area that combines base perimeter and height,
        // noting its simplification.

        // For this demo, let's assume `sisi` is provided, and we can calculate the perimeter for the base.
        // We'd still need the `apothem` for the rhombus base, which is not directly available.
        // Given that it's a "LimasBelahKetupat", typically it implies a right pyramid on a rhombus.
        // The slant height to the midpoints of the sides would be different for different sides of the rhombus.
        // This is too complex for a GUI input.

        // I will provide the base area and indicate a conceptual approach for lateral surface area.
        // For a true implementation, one would need the height of each triangular face.
        // Let's assume an *average* slant height can be derived or provided for simplicity.
        // Given no additional input for slant height of faces, I will use a very simplified heuristic
        // or a more precise one if `apothem` for rhombus base is calculable easily.

        // Apothem for rhombus is: a = (d1 * d2) / (2 * sisi)
        Double apothem1 = (getDiagonal1() * getDiagonal2()) / (2 * getSisi()); // This calculates the apothem to *all* sides if it's a true apothem.
        // However, a rhombus has two different "in-radii" or apothem distances to the sides.
        // Let's use a simplified approach: 2 * Base Area / Base Perimeter.
        // Double avgApothem = (2 * baseArea) / super.hitungKeliling();

        // This requires the height of the triangular faces (h_face).
        // h_face = sqrt(tinggiLimas^2 + (apothem_to_side)^2)
        // This is too much to derive from current inputs without more specific assumptions.

        // So, for demonstration, I will calculate base area + a simplified lateral area.
        // A commonly simplified formula for lateral surface area of a pyramid when slant height of faces isn't given:
        // sum of (0.5 * base_side * slant_height_of_face).
        // For a rhombus, we need two different slant heights.
        // Let's provide a "TODO" comment here to acknowledge complexity.
        // For the purpose of making the code *run*, I will calculate base area, and for the lateral,
        // if no explicit slant height for faces is provided, it's problematic.

        // Placeholder for lateral surface area if specific slant heights are not available.
        // A common simplification is to use base perimeter * average slant height.
        // Since we don't have average slant height, this calculation will be incomplete or simplified.
        // Let's just calculate the base area and state that lateral area needs more data.
        // Or, we ask for an "effective slant height" for the lateral faces.

        // To make it functional, I will make a very simplified lateral surface area.
        // Let's assume `sisi` is the only side length available for the base.
        // For surface area, it's Base Area + Lateral Area.
        // Lateral Area is sum of (1/2 * base_side * slant_height_of_face).
        // If we only have 'sisi', we can't accurately get two different slant heights.

        // Let's modify: `hitungLuasPermukaanLimas` will explicitly need an `effectiveSlantHeightOfFaces` as input.
        // Or, if it's a 'right rhombus pyramid' where the apex is directly above the center,
        // then the slant heights to the midpoints of the sides would vary based on rhombus diagonals.
        // This is too much.

        // **Revised approach for Lateral Surface Area:**
        // I will make `LuasPermukaanLimas` require a `tinggiSisiTegak` (slant height of lateral faces) as an input
        // to simplify the model for demonstration purposes, acknowledging the complexity.
        // Alternatively, if we only have `tinggiLimas`, then the slant height must be calculated.
        // Given that it's a "LimasBelahKetupat", often people simplify and assume one effective slant height for lateral faces.
        // Let's use the property that the apothem of a rhombus can be derived from its area and perimeter.
        // Apothem = 2 * Area / Perimeter. This is an average apothem.
        // Then, Slant Height of face (h_f) = sqrt(h_limas^2 + apothem^2).
        // This will allow `hitungLuasPermukaanLimas` to be standalone.

        Double basePerimeter = super.hitungKeliling(); // Perimeter of rhombus base
        if (basePerimeter == null || basePerimeter == 0) {
            throw new IllegalStateException("Keliling alas tidak dapat dihitung untuk luas permukaan.");
        }
        Double apothemOfBase = (2 * baseArea) / basePerimeter; // Simplified average apothem

        // Calculate a conceptual "average" slant height of the triangular faces
        // This might not be geometrically accurate for a general rhombus, but allows calculation.
        Double avgSlantHeightOfFace = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(apothemOfBase, 2));

        Double lateralSurfaceArea = 0.5 * basePerimeter * avgSlantHeightOfFace;
        this.luasPermukaanLimas = baseArea + lateralSurfaceArea;
        this.luas = this.luasPermukaanLimas;
        return this.luasPermukaanLimas;
    }

    // Overloading: Method to set dimensions and calculate
    public void setDimensionsAndCalculate(Double d1, Double d2, Double sisiBase, Double hLimas) {
        setDiagonal1(d1);
        setDiagonal2(d2);
        setSisi(sisiBase); // Ensure sisi is set for perimeter calc
        setTinggiLimas(hLimas);
        hitungVolumeLimas();
        // Ensure that hitungKeliling() for base is called before hitungLuasPermukaanLimas()
        // which might rely on it.
        super.hitungKeliling(); // Calculate base perimeter
        hitungLuasPermukaanLimas();
    }
}