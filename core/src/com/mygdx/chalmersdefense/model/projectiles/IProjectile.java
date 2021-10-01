package com.mygdx.chalmersdefense.model.projectiles;

import com.mygdx.chalmersdefense.model.IMapObject;


public interface IProjectile extends IMapObject {

    boolean getIfDealtDamage();

    void setDealtDamage(boolean bool);

    void update(boolean hitVirus, float angle);

    String getName();

    boolean canRemove();
}
