package com.mygdx.chalmersdefense.Model.Path.GamePaths;

import com.mygdx.chalmersdefense.Model.Path.Path;
import com.mygdx.chalmersdefense.Utilities.PositionVector;

import java.awt.*;
import java.util.ArrayList;

public class ClassicPath extends Path {

    public ClassicPath() {
        super();
        startingPoint = new PositionVector(-50, 453);
        setPathWaypoints();
        super.createMapCollision();
    }

    @Override
    protected void setPathWaypoints() {
        if (pathWaypoints.isEmpty()) {
            pathWaypoints.add(new PositionVector(0, 456));
            pathWaypoints.add(new PositionVector(483, 456));
            pathWaypoints.add(new PositionVector(483, 756));
            pathWaypoints.add(new PositionVector(270, 756));
            pathWaypoints.add(new PositionVector(270, 973));
            pathWaypoints.add(new PositionVector(633, 973));
            pathWaypoints.add(new PositionVector(633, 323));
            pathWaypoints.add(new PositionVector(1379, 323));
            pathWaypoints.add(new PositionVector(1379, 901));
            pathWaypoints.add(new PositionVector(1081, 901));
            pathWaypoints.add(new PositionVector(1081, 684));
            pathWaypoints.add(new PositionVector(861, 684));
            pathWaypoints.add(new PositionVector(861, 1130));

        }
    }



}
