package duadimen;


import maininter.BendaGeometri;

/**
 * Interface representing a 2D geometric plane.
 * Extends main.BendaGeometri and defines methods for calculating area and perimeter.
 */
public interface BidangDuaDimensi extends BendaGeometri { //

    /**
     * Method to calculate the perimeter (Keliling) of a 2D shape.
     * @return The calculated perimeter.
     */
    Double hitungKeliling();
}