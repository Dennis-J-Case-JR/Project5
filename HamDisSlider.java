import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class HamDisSlider {
	
	//Makes the slider object for the GUI
	public JSlider makeHamDisSlider(){
		
		JSlider slider = new JSlider(1, 4, 1);
		
		//Creates spacing between the ticks		
		slider.setMajorTickSpacing(1);
		
		slider.setSnapToTicks(true);
		
		slider.setPaintTicks(true);
		
		Hashtable<Integer, JLabel> tickMarks = new Hashtable<>();
		
		JLabel one = new JLabel("1");
		JLabel two = new JLabel("2");
		JLabel three = new JLabel("3");
		JLabel four = new JLabel("4");
		
		tickMarks.put(1, one);
		tickMarks.put(2, two);
		tickMarks.put(3, three);
		tickMarks.put(4, four);
		
		return slider;
	}
	
}
