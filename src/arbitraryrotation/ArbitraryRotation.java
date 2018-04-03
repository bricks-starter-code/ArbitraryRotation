/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbitraryrotation;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author unouser
 */
public class ArbitraryRotation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        BufferedImage in = ImageIO.read(new File("lamp.jpg"));
        
        float roation = 45;
        
        List<Point> points = new ArrayList<Point>();
        List<Point> newPoints = new ArrayList<Point>();
        
        int w = in.getWidth();
        int h = in.getHeight();
        
        points.add(new Point(-w/2, h/2));
        points.add(new Point(w/2, h/2));
        points.add(new Point(-w/2, -h/2));
        points.add(new Point(w/2, -h/2));
        
        for(int i = 0; i < points.size(); i++)
        {
            Point p = points.get(i);
            double hypotenus = Math.sqrt(p.x * p.x + p.y * p.y);
            double angle = Math.atan2(p.y, p.x);
            
            double newAngle = angle + roation;
            
            double newX = Math.cos(newAngle) * hypotenus;
            double newY = Math.sin(newAngle) * hypotenus;
            
            newPoints.add(new Point((int)newX, (int)newY));
            
        }
        
        int minX = newPoints.stream().min((p1,p2)->Integer.compare(p1.x, p2.x)).get().x;
        int minY = newPoints.stream().min((p1,p2)->Integer.compare(p1.y, p2.y)).get().y;
        int maxX = newPoints.stream().max((p1,p2)->Integer.compare(p1.x, p2.x)).get().x;
        int maxY = newPoints.stream().max((p1,p2)->Integer.compare(p1.y, p2.y)).get().y;
        
        
        
        
        BufferedImage out = new BufferedImage(?,?, BufferedImage.TYPE_INT_ARGB);
        
        //Do some magic
        for(int y = 0; y < in.getHeight(); y++)
        {
            for(int x = 0; x < in.getWidth(); x++)
            {
                Color inColor = new Color(in.getRGB(x, y));
                
                //Some magic
                
                out.setRGB(?, ?, inColor);
            }
        }
        
        ImageIO.write(out, "PNG", "out.png");
        
        
    }
    
}
