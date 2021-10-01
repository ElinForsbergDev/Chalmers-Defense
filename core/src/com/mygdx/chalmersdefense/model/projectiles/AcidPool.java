package com.mygdx.chalmersdefense.model.projectiles;

public class AcidPool extends Projectile implements IProjectile{

    private int poolTimer;

    public AcidPool(float x, float y, int upgradeLevel) {
        super(0, "chemistAcid" + upgradeLevel, x, y, 0);
    }

    @Override
    void virusIsHit(){

    }

}
