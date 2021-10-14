package com.mygdx.chalmersdefense.model.projectiles;


import com.mygdx.chalmersdefense.utilities.CountDownTimer;

/**
 * @author Elin Forsberg
 * Class representing a lightning projectile
 */
class LightningProjectile extends Projectile {

    private final CountDownTimer hitCountsLeft = new CountDownTimer(4); // Hit amount left before projectile can be removed

    LightningProjectile(float x, float y, float angle, int upgradeLevel) {
        super(5, "electroProjectile" + upgradeLevel, x, y, angle, 1);
    }


    /**
     * Helper method for counting how many viruses have been hit
     * If hitCountsLeft is 0, then projectile can be removed.
     */
    private void countVirusHit() {
        if (hitCountsLeft.haveReachedZero()) {
            super.canRemove = true;
        }
    }

    @Override
    public void virusIsHit(int hitVirusHashCode, float angle) {
        super.haveHitList.add(hitVirusHashCode);
        this.countVirusHit();

        if (angle >= 0) {
            this.setAngle(angle);
        } else {
            super.canRemove = true;
        }
    }


}
