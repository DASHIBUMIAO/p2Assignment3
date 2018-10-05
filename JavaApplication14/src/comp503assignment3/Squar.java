package comp503assignment3;

import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xuchang
 */
public class Squar extends Shape implements EnclosesRegion {

    private boolean filled;

    public Squar(Point startPoint) {
        super(startPoint);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColour());

        int minX = Math.min(controlPoint.x, startPoint.x);
        int minY = Math.min(controlPoint.y, startPoint.y);
        int maxX = Math.max(controlPoint.x, startPoint.x);
        int maxY = Math.max(controlPoint.y, startPoint.y);

        int size = Math.min(maxX - minX, maxY - minY);

        if (minX < startPoint.x) {
            minX = startPoint.x - size;
        }
        if (minY < startPoint.y) {
            minY = startPoint.y - size;
        }

        if (filled) {
            g.fillOval(minX, minY, size, size);
        } else {
            g.drawOval(minX, minY, size, size);
        }
    }

    @Override
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

}
