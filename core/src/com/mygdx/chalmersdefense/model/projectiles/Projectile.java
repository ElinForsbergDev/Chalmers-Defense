package com.mygdx.chalmersdefense.model.projectiles;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Elin Forsberg
 * Class defining a projectile object
 * <p>
 * 2021-10-01 Modified by Joel Båtsman Hilmersson: The projectile now holds a list of hashcodes to every virus it has hit before <br>
 */
abstract class Projectile implements IProjectile {

    final List<Integer> haveHitList = new ArrayList<>();    // List of hashcodes of all viruses the projectile has hit before

    private float width;    // Current width of projectile
    private float height;   // Current height of projectile
    private final float speed;    // Speed of projectile
    private final float damage;   // Damage of projectile


    private String spriteKey;   // The key to the Sprite Hashmap
    private float x;            // X coordinate on map
    private float y;            // y coordinate on map

    private float angle;        // Current angle of projectile

    boolean canRemove = false;  // Boolean over if this projectile can be removed by map

    Projectile(float speed, String spriteKey, float x, float y, float angle, float damage) {
        this.speed = speed;
        this.spriteKey = spriteKey;
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.damage = damage;
        // TODO Fix speed calc in children


        try {
            BufferedImage towerImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("projectiles/" + spriteKey + ".png")));
            this.width = towerImage.getWidth();
            this.height = towerImage.getHeight();


        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }


    @Override
    public void update(boolean hasVirusBeenHit, int hitVirusHashCode, float angle) {
        if (hasVirusBeenHit) {
            virusIsHit(hitVirusHashCode, angle);
        }


        float xLength = (float) (Math.cos(Math.toRadians(this.angle)) * speed);
        float yLength = (float) (Math.sin(Math.toRadians(this.angle)) * speed);

        x = x + xLength;
        y = y + yLength;

    }

    /**
     * Method to call when virus is hit
     */
    void virusIsHit(int haveHit, float angle) {
        haveHitList.add(haveHit);
        this.canRemove = true;
    }

    @Override
    public String getSpriteKey() {
        return spriteKey;
    }

    @Override
    public float getAngle() {
        return angle;
    }


    /**
     * Set the angle of the projectile
     *
     * @param angle to be set
     */
    void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public boolean canRemove() {
        return canRemove;
    }

    @Override
    public boolean haveHitBefore(int hashCode) {
        return haveHitList.contains(hashCode);
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getDamageAmount(){ return damage; }

}
