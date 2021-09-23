package com.mygdx.chalmersdefense.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


/**
 * @author Elin Forsberg
 * A factory class for creating different towers
 */

public class TowerFactory {

    private String smurfImagePath = "Towers/Smurf.png";
    private String chemistImagePath = "Towers/Chemist.png";
    private String electroImagePath = "Towers/Electro.png";
    private String hackerImagePath = "Towers/Hacker.png";
    private String meckImagePath = "Towers/Meck.png";
    private String ecoImagePath = "Towers/Eco.png" ;


    public Tower CreateSmurf(int startPosX, int startPosY){
        Tower smurf = new Tower(startPosX,startPosY, smurfImagePath, "SmurfTower", 10,10, 100, 1);

        return smurf;
    }

    public Tower CreateChemist(int startPosX, int startPosY){
        Tower chemist = new Tower(startPosX,startPosY, chemistImagePath, "ChemistTower", 30,10, 200, 1);
        return chemist;
    }

    public Tower CreateHacker(int startPosX, int startPosY){
        Tower hacker = new Tower(startPosX,startPosY,  hackerImagePath, "HackerTower", 10,10, 300, 1);

        return hacker;
    }

    public Tower CreateElectro(int startPosX, int startPosY){
        Tower electro = new Tower(startPosX,startPosY,  electroImagePath, "ElectroTower", 20,10, 400, 1);
        return electro;
    }


    public Tower CreateMeck(int startPosX, int startPosY){
        Tower meck = new Tower(startPosX,startPosY,  meckImagePath, "MeckTower", 30,10, 500, 1);
        return meck;
    }

    public Tower CreateEco(int startPosX, int startPosY){
        Tower eco = new Tower(startPosX,startPosY, ecoImagePath, "EcoTower", 20,10, 600, 1);
        return eco;
    }




}
