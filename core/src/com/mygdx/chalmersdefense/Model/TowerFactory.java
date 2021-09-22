package com.mygdx.chalmersdefense.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


/**
 * @author Elin Forsberg
 * A factory class for creating different towers
 */

public class TowerFactory {
    private Sprite smurfImage;
    private Sprite chemistImage;
    private Sprite electroImage;
    private Sprite hackerImage;
    private Sprite meckImage;
    private Sprite ecoImage;

    private String smurfImagePath = "Towers/Smurf.png";
    private String chemistImagePath = "Towers/Chemist.png";
    private String electroImagePath = "Towers/Electro.png";
    private String hackerImagePath = "Towers/Hacker.png";
    private String meckImagePath = "Towers/Meck.png";
    private String ecoImagePath = "Towers/Eco.png" ;


    public Tower CreateSmurf(int startPosX, int startPosY){
        smurfImage = new Sprite(new Texture("Towers/Smurf.png"));
        Tower smurf = new Tower(startPosX,startPosY, smurfImage, smurfImagePath, "SmurfTower", 10,10, 100);

        return smurf;
    }

    public Tower CreateChemist(int startPosX, int startPosY){
        chemistImage = new Sprite(new Texture("Towers/Chemist.png"));
        Tower chemist = new Tower(startPosX,startPosY, chemistImage, chemistImagePath, "ChemistTower", 30,10, 200);
        return chemist;
    }

    public Tower CreateHacker(int startPosX, int startPosY){
        hackerImage = new Sprite(new Texture("Towers/Hacker.png"));
        Tower hacker = new Tower(startPosX,startPosY, hackerImage, hackerImagePath, "HackerTower", 10,10, 300);

        return hacker;
    }

    public Tower CreateElectro(int startPosX, int startPosY){
        electroImage = new Sprite(new Texture("Towers/Electro.png"));
        Tower electro = new Tower(startPosX,startPosY, electroImage, electroImagePath, "ElectroTower", 20,10, 400);
        return electro;
    }


    public Tower CreateMeck(int startPosX, int startPosY){
        meckImage = new Sprite(new Texture("Towers/Meck.png"));
        Tower meck = new Tower(startPosX,startPosY, meckImage, meckImagePath, "MeckTower", 30,10, 500);
        return meck;
    }

    public Tower CreateEco(int startPosX, int startPosY){
        ecoImage = new Sprite(new Texture("Towers/Eco.png"));
        Tower eco = new Tower(startPosX,startPosY, ecoImage, ecoImagePath, "EcoTower", 20,10, 600);
        return eco;
    }




}
