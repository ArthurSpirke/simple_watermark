package com.arthurspirke.simplecode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 
 * @author Arthur Spirke
 *
 */



public class WatermarkFactory {

    
    public BufferedImage createWatermark(int width, int height){

              BufferedImage img = null;
	try{
	if((width > 30 && width < 70) || (height > 30 && height < 70)){
	    img = ImageIO.read(new File("watermarks/55.png"));
	    return img;
	} else if((width > 71 && width < 120) || (height > 71 && height < 120)){
	    img = ImageIO.read(new File("watermarks/105.png"));	
	    return img;
	} else if((width > 121 && width < 190) || (height > 121 && height < 190)){
	    img = ImageIO.read(new File("watermarks/170.png"));
	    return img;
	} else if((width > 191 && width < 280) || (height > 191 && height < 280)){
	    img = ImageIO.read(new File("watermarks/270.png"));
	    return img;
	} else if((width > 281 && width < 400) || (height > 281 && height < 400)){
	    img = ImageIO.read(new File("watermarks/360.png"));
	    return img;
	} else if((width > 401 && width < 600) || (height > 401 && height < 600)){
	    img = ImageIO.read(new File("watermarks/570.png"));
	    return img;
	} else if((width > 601 && width < 900) || (height > 601 && height < 900)){
	    img = ImageIO.read(new File("watermarks/830.png"));
	    return img;
	} else if((width > 901 && width < 1400) || (height > 901 && height < 1400)){
	    img = ImageIO.read(new File("watermarks/1300.png"));
	    return img;
	} else if((width > 1401 && width < 1900) || (height > 1400 && height < 1900)){
	    img = ImageIO.read(new File("watermarks/1800.png"));
	    return img;
	} else{
	    img = ImageIO.read(new File("watermarks/1800.png"));
	    return img;

	}
	
      } catch(IOException ex){
	  ex.printStackTrace();
	  return null;
      }
		
	
    }
    

}
