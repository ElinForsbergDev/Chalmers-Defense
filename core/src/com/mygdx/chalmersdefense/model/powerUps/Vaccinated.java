package com.mygdx.chalmersdefense.model.powerUps;

import com.mygdx.chalmersdefense.model.viruses.IVirus;
import com.mygdx.chalmersdefense.utilities.CountDownTimer;

import java.util.List;

/**
 * @author Joel Båtsman Hilmersson
 *
 * Class representing Vaccinated powerup
 */
public class Vaccinated {
    //private int cooldownTimer = 750;    // Cooldown timer
    private final CountDownTimer cooldownTimer = new CountDownTimer(1000);
    private final CountDownTimer activeTimer = new CountDownTimer(380);


    private boolean canBeUsed = true;   // If this powerup can be used at the moment
    private boolean activated = false;   // If this powerup is activated at the moment

    private boolean hurtVirus = false;

    private List<IVirus> viruses;

    public void activatePowerUp(List<IVirus> allViruses){
        if (canBeUsed) {
            canBeUsed = false;
            activated = true;
            viruses = allViruses;
        }
    }

    private void decreaseLife(List<IVirus> allViruses){
        for (IVirus virus : allViruses){
            virus.decreaseHealth(1);
        }
    }

    public void decreaseTimer(){

        if (activated && activeTimer.haveReachedZero()){
            activated = false;
            hurtVirus = false;
        }

        if (!canBeUsed && cooldownTimer.haveReachedZero()){
            canBeUsed = true;
        }

        if(activated && activeTimer.getCurrentCountTime() <= 325 && !hurtVirus){
            decreaseLife(viruses);
            hurtVirus = true;

        }

    }


    /**
     * Return the active timer amount
     * @return active timer
     */
    public int getTimer() {
        if(activated && !canBeUsed){
            return (activeTimer.getCurrentCountTime() * 5) / 1000;
        }
        else if(activated){
            return -1;
        }
        else if(!canBeUsed){
            return (cooldownTimer.getCurrentCountTime() * 5) / 1000;
        }
        else{
            return -1;
        }
    }

    public boolean isActivated() {
        return activated;
    }
}
