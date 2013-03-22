package com.arthurspirke.simplecode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;


import net.coobird.thumbnailator.filters.Watermark;
import net.coobird.thumbnailator.geometry.Positions;


/**
 * 
 * @author Arthur Spirke
 *
 */

public class AddWatermark {
    private File filesStartDir;
    private String filesFinalDir;
    private WatermarkFactory watermarkFactory;
    

    
    public AddWatermark(String startDir, String finalDir){
	filesStartDir = new File(startDir);
	this.filesFinalDir = finalDir;
	watermarkFactory = new WatermarkFactory();
    }
    
    
    
    private File[] getImagesFromStartDir(){
	File[] allFiles = filesStartDir.listFiles();
	return allFiles;
	
    }
    
    
    public void addWatermark(){
	File[] allFiles = getImagesFromStartDir();
	
	for(int i = 0; i < allFiles.length; i++){

	    File concretFile = allFiles[i];
	    String pathFile = concretFile.getAbsolutePath();

	    
	    try {
		
		//Get BufferedImage object with an image
		ImageIcon fileImgs = new ImageIcon(pathFile);
		BufferedImage image = new BufferedImage(fileImgs.getIconWidth(), fileImgs.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics gr = (Graphics) image.createGraphics();
		fileImgs.paintIcon(null, gr, 0, 0);
		gr.dispose();
		
		//Create new clear image   
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D graphics2d = (Graphics2D) newImage.createGraphics();

		//Get watermark from class WatermarkFactory    
                BufferedImage watermark = watermarkFactory.createWatermark(image.getWidth(), image.getHeight());
                //Our watermark get the same width and height how original product image
                graphics2d.drawImage(watermark, 0, 0, image.getWidth(), image.getHeight(), null);

                //Use library "thumbnailator" (https://code.google.com/p/thumbnailator/) for applied to the image our watermark
                Watermark filter = new Watermark(Positions.CENTER, newImage, 0.4f);
                BufferedImage newBuff = filter.apply(image);

		//Save new image with watermark in directory. New image have the same name how original product image	
                OutputStream out = new PrintStream(filesFinalDir + concretFile.getName());
                ImageIO.write(newBuff, "jpg", out);
                out.close();
                
	    } catch (FileNotFoundException e) {
		e.printStackTrace();

	    } catch (IOException e) {
                e.printStackTrace();

	    }
	   
		

	}
    }
   

}
