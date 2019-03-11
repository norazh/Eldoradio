package UI;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;

/**
 * The RotatedIcon allows you to change the orientation of an Icon by rotating
 * the Icon before it is painted. This class supports the following
 * orientations:
 *
 * <ul>
 * <li>DOWN - rotated 90 degrees
 * <li>UP (default) - rotated -90 degrees
 * </ul>
 */
public class RotatedIcon implements Icon {

    public enum Rotate {
        HORAIRE,
        ANTIHORAIRE,
    }

    private Icon icon;

    private Rotate rotate;

    private double degrees;
    private boolean circularIcon;

    /**
     * Convenience constructor to create a RotatedIcon that is rotated DOWN.
     *
     * @param icon the Icon to rotate
     */
    public RotatedIcon(Icon icon) {
        this(icon, Rotate.ANTIHORAIRE);
    }

    /**
     * Create a RotatedIcon
     *
     * @param icon	the Icon to rotate
     * @param rotate the direction of rotation
     */
    public RotatedIcon(Icon icon, Rotate rotate) {
        this.icon = icon;
        this.rotate = rotate;
    }

    /**
     * Gets the Icon to be rotated
     *
     * @return the Icon to be rotated
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Gets the Rotate enum which indicates the direction of rotation
     *
     * @return the Rotate enum
     */
    public Rotate getRotate() {
        return rotate;
    }

    /**
     * Gets the degrees of rotation. Only used for Rotate.ABOUT_CENTER.
     *
     * @return the degrees of rotation
     */
    public double getDegrees() {
        return degrees;
    }

    /**
     * Set the degrees of rotation. Only used for Rotate.ABOUT_CENTER. This
     * method only sets the degress of rotation, it will not cause the Icon to
     * be repainted. You must invoke repaint() on any component using this icon
     * for it to be repainted.
     *
     * @param degrees the degrees of rotation
     */
    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    /**
     * Is the image circular or rectangular? Only used for Rotate.ABOUT_CENTER.
     * When true, the icon width/height will not change as the Icon is rotated.
     *
     * @return true for a circular Icon, false otherwise
     */
    public boolean isCircularIcon() {
        return circularIcon;
    }

    /**
     * Set the Icon as circular or rectangular. Only used for
     * Rotate.ABOUT_CENTER. When true, the icon width/height will not change as
     * the Icon is rotated.
     *
     * @param true for a circular Icon, false otherwise
     */
    public void setCircularIcon(boolean circularIcon) {
        this.circularIcon = circularIcon;
    }

//
//  Implement the Icon Interface
//
    /**
     * Prend la largeur de l'icône
     *
     * @return la largeur de l'icône en pixels.
     */
    public int getIconWidth() {
        return icon.getIconHeight();
    }

    /**
     * Prend la hauteur de l'icône
     *
     * @return la hauteur de l'icône en pixels.
     */
    public int getIconHeight() {
        return icon.getIconWidth();
    }

    /**
     * Paint the icons of this compound icon at the specified location
     *
     * @param c Le component dans lequel icon est "painted"
     * @param g the graphics context
     * @param x the X coordinate of the icon's top-left corner L'abscisse du coin gauche haut
     * @param y the Y coordinate of the icon's top-left corner L'ordonnée du point dans le coin gauche haut
     */
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();

        int cWidth = icon.getIconWidth() / 2;
        int cHeight = icon.getIconHeight() / 2;
        int xAdjustment = (icon.getIconWidth() % 2) == 0 ? 0 : -1;
        int yAdjustment = (icon.getIconHeight() % 2) == 0 ? 0 : -1;

        if (rotate == Rotate.HORAIRE) {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate(Math.toRadians(90));
            icon.paintIcon(c, g2, -cWidth, yAdjustment - cHeight);
        } else if (rotate == Rotate.ANTIHORAIRE) {
            g2.translate(x + cHeight, y + cWidth);
            g2.rotate(Math.toRadians(-90));
            icon.paintIcon(c, g2, xAdjustment - cWidth, -cHeight);
        }

        g2.dispose();
    }
}
