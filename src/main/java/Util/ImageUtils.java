package Util;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;

public class ImageUtils {
	
	 public BufferedImage Mat2BufferedImage(Mat m) {
	        // Fastest code
	        // output can be assigned either to a BufferedImage or to an Image

	        int type = BufferedImage.TYPE_BYTE_GRAY;
	        if ( m.channels() > 1 ) {
	            type = BufferedImage.TYPE_3BYTE_BGR;
	        }
	        int bufferSize = m.channels()*m.cols()*m.rows();
	        byte [] b = new byte[bufferSize];
	        m.get(0,0,b); // get all the pixels
	        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
	        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	        System.arraycopy(b, 0, targetPixels, 0, b.length);  
	        return image;
	    }
	    
	    public void displayImage(Image img2) {

	        //BufferedImage img=ImageIO.read(new File("/HelloOpenCV/lena.png"));
	        ImageIcon icon=new ImageIcon(img2);
	        JFrame frame=new JFrame();
	        frame.setLayout(new FlowLayout());        
	        frame.setSize(img2.getWidth(null)+50, img2.getHeight(null)+50);     
	        JLabel lbl=new JLabel();
	        lbl.setIcon(icon);
	        frame.add(lbl);
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
}
