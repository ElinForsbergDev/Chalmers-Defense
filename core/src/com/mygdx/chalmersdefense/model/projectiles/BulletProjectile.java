package com.mygdx.chalmersdefense.model.projectiles;

/**
 * @author Elin Forsberg
 * Class representing a specific projectile
 */
public class BulletProjectile extends Projectile{
    private static String name = "bullet";

    public BulletProjectile(int speed , float x, float y, double angle) {
        super(speed, name, x, y, angle);
    }

}
