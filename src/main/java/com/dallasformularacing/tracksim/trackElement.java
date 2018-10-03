/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dallasformularacing.tracksim;

import static com.dallasformularacing.tracksim.trackElementType.*;
import java.awt.geom.Arc2D;
import static java.awt.geom.Arc2D.OPEN;

/**
 *
 * @author Josh
 */
public class trackElement {

    private trackElementType type;
    private double x0, y0, x1, y1, angle, radius;

    /**
     * This constructor is for straight elements only
     *
     * @param t type of track element
     * @param x0 initial x pos
     * @param y0 initial y pos
     * @param x1 ending x pos
     * @param y1 ending y pos
     */
    public trackElement(trackElementType t, double x0, double y0, double x1, double y1) {
            this.x0 = x0;
            this.y0 = y0;
            this.x1 = x1;
            this.y1 = y1;
            this.type = t;
            
            this.angle = Math.toDegrees(Math.atan((y1-y0)/(x1-x0)));
            this.radius = -1;
    }

    /**
     * This constructor is for curve elements only
     *
     * @param t
     * @param x0
     * @param y0
     * @param theta0
     * @param theta1
     * @param radius
     */
    public trackElement(trackElementType t, double x0, double y0, double theta0, double theta1, double radius) {
        this.x0 = x0;
        this.y0 = y0;
        Arc2D arc = new Arc2D.Double(x0 + radius, y0 + radius, radius, radius, theta0, theta1, OPEN);
        this.x1 = arc.getEndPoint().getX();
        this.y1 = arc.getEndPoint().getY();
        this.type = t;
        this.angle = arc.getAngleExtent();
        this.radius = radius;
    }

    public String[] getData() {

        String[] s = {type.toString(), Double.toString(x0), Double.toString(y0), Double.toString(x1), Double.toString(y1), Double.toString(angle), Double.toString(radius)};
        return s;
    }

    public double getX0() {
        return x0;
    }

    public double getY0() {
        return y0;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }
    
    public double getTheta(){
        return angle;
    }

}
