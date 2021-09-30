package com.mygdx.chalmersdefense.model.towers;

import com.mygdx.chalmersdefense.model.Player;
import com.mygdx.chalmersdefense.model.projectiles.IProjectile;
import com.mygdx.chalmersdefense.model.targetMode.ITargetMode;

import java.util.List;

/**
 * @author Elin Forsberg
 * Class representing the MechTower
 */

public class EcoTower extends Tower {

    int currentReload;
    private int reloadTime = 60*10; //how many updates from model
    private Player player;

    public EcoTower(float x, float y, String name, int attackSpeed, int cost, int range, List<ITargetMode> targetModes, Player player) {
        super(x, y, name, attackSpeed, cost, range, targetModes);
        this.player = player;
        currentReload = 0;

    }

    @Override
    void createProjectile(List<IProjectile> projectileList) {

    }

    @Override
    public void update(List<IProjectile> projectilesList, List<ITower> towersList){
        if(currentReload < 1 && this.isPlaced()){
            currentReload = reloadTime;
            player.increaseMoney(20);
        }
        else{
            currentReload --;
        }
        this.setAngle(0);
    }





}
