package main;

/**
 * Interface representing a generic geometric object.
 * Defines common methods for calculating area/surface area and perimeter/volume.
 */
public interface BendaGeometri { //

    /**
     * Abstract method to calculate the area (for 2D) or surface area (for 3D).
     * @return The calculated area or surface area.
     */
    Double hitungLuas(); //

    /**
     * Abstract method to calculate the perimeter (for 2D) or volume (for 3D).
     * @return The calculated perimeter or volume.
     */
    Double hitungKelilingAtauVolume(); //
}