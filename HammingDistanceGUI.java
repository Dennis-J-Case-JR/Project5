import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class HammingDistanceGUI extends JFrame implements ActionListener{
	
	// Contents inside the mesonet file
	public String[] mesonetContents = {"Hi"};
	
	public String wordSelected = "";
	
	public HammingDistanceCalculator HammDist = new HammingDistanceCalculator("ACME", "BESS");;
	
	public ArrayList<String> hamDisForNumber = new ArrayList<String>();
	
	public int colorStyle = 0;
	
	// GUI Panels that hold all the other content made
	JPanel leftSide = new JPanel(null);
	JPanel rightSide = new JPanel(null);
	
	
	// GUI Labels to title areas
	JLabel enteringHD = new JLabel("Enter Hamming Distance:"); 
	JLabel compareWord = new JLabel("Compare With:"); 
	
	JLabel hamDisResultLabel0 = new JLabel("Distance 0"); 
	JLabel hamDisResultLabel1 = new JLabel("Distance 1"); 
	JLabel hamDisResultLabel2 = new JLabel("Distance 2"); 
	JLabel hamDisResultLabel3 = new JLabel("Distance 3"); 
	JLabel hamDisResultLabel4 = new JLabel("Distance 4"); 
	
	
	// GUI TextFields to type text into
	JTextField hdTextBox = new JTextField("1"); 
	
	JTextField hamDisResult0 = new JTextField(""); 
	JTextField hamDisResult1 = new JTextField(""); 
	JTextField hamDisResult2 = new JTextField(""); 
	JTextField hamDisResult3 = new JTextField(""); 
	JTextField hamDisResult4 = new JTextField(""); 
	
	JTextField stationPanTextField = new JTextField(""); 
	
	
	// GUI Buttons to complete an action
	JButton stationButton = new JButton("Show Station"); 
	JButton calcHDButton = new JButton("Calculate HD"); 
	JButton addStationButton = new JButton("Add Station"); 
	JButton clickMe = new JButton("Click Me");
	
	
	// GUI slider bar
	JSlider hdSliderSelecter = new HamDisSlider().makeHamDisSlider(); 
	
	
	// GUI TextArea Boxes
	JTextArea textArea = new JTextArea(100, 100); 
	
	
	// GUI Box for text/scroll bar
	JScrollBar compareWordScrollBar = new JScrollBar();
	
	
	// GUI Selection Pull-Down Box
	@SuppressWarnings("unchecked")
	JComboBox compareWordComboBox = new JComboBox(mesonetContents); 
	
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public HammingDistanceGUI() throws IOException {
		//Sets how many panels can be on this frame
		this.setLayout(new GridLayout(1, 2));
		
		mesonetContents = HammDist.getWords();
		
		compareWordComboBox = new JComboBox(mesonetContents);
		
		compareWordComboBox.addActionListener((e) -> {
			if(e.getSource() == compareWordComboBox) {
				JComboBox cwcb = (JComboBox)e.getSource();
				wordSelected = (String) cwcb.getSelectedItem();
				try {
					HammDist = new HammingDistanceCalculator(wordSelected, "BESS");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//Adds the top left side of the GUI
		enteringHD.setBounds(25, 25, 150, 20);
		leftSide.add(enteringHD);
		hdTextBox.setBounds(175, 25, 150, 20);
		leftSide.add(hdTextBox);
		
		
		
		
		
		//Adds the slider bar at the top left
		hdSliderSelecter.setBounds(25, 70, 300, 20);
		leftSide.add(hdSliderSelecter);
		
		leftSide.addMouseMotionListener(new MouseMotionListener()
		{
			@Override
			public void mouseMoved(MouseEvent e) {}

			@Override
			public void mouseDragged(MouseEvent e)
			{
				// TODO: add a point to the panel on drag and reassign hdTextBox.
				Point mousePos = e.getPoint();
				if(hdSliderSelecter.getBounds().contains(mousePos)) {
					hdTextBox.setText("" + hdSliderSelecter.getValue());
				}
				
			}
		});
		
		//Adds the Station Button
		stationButton.setBounds(10, 120, 125, 20);
		leftSide.add(stationButton);
		stationButton.addActionListener(this);

		//Adds giant TextField for the result layout
		textArea.setBounds(25, 150, 275, 350);
		textArea.setEditable(false);
		leftSide.add(textArea);

		//Adds scroll bar variable chooser to compare words against other words
		compareWord.setBounds(10, 520, 125, 20);
		leftSide.add(compareWord);
		compareWordComboBox.setBounds(150, 520, 125, 20);
		leftSide.add(compareWordComboBox);
		
		//Adds calcHDButton
		calcHDButton.setBounds(10, 560, 125, 20);
		leftSide.add(calcHDButton);
		
		calcHDButton.addActionListener(this);
		
		//Adds Hamming Distance Labels and answers with them appropriately		
		hamDisResultLabel0.setBounds(25, 600, 125, 20);
		hamDisResult0.setBounds(160, 600, 125, 20);
		leftSide.add(hamDisResultLabel0);
		leftSide.add(hamDisResult0);
		
		hamDisResultLabel1.setBounds(25, 640, 125, 20);
		hamDisResult1.setBounds(160, 640, 125, 20);
		leftSide.add(hamDisResultLabel1);
		leftSide.add(hamDisResult1);
		
		hamDisResultLabel2.setBounds(25, 680, 125, 20);
		hamDisResult2.setBounds(160, 680, 125, 20);
		leftSide.add(hamDisResultLabel2);
		leftSide.add(hamDisResult2);
		
		hamDisResultLabel3.setBounds(25, 720, 125, 20);
		hamDisResult3.setBounds(160, 720, 125, 20);
		leftSide.add(hamDisResultLabel3);
		leftSide.add(hamDisResult3);
		
		hamDisResultLabel4.setBounds(25, 760, 125, 20);
		hamDisResult4.setBounds(160, 760, 125, 20);
		leftSide.add(hamDisResultLabel4);
		leftSide.add(hamDisResult4);
		
		hamDisResult0.setEditable(false);
		hamDisResult1.setEditable(false);
		hamDisResult2.setEditable(false);
		hamDisResult3.setEditable(false);
		hamDisResult4.setEditable(false);
		
		addStationButton.setBounds(10, 800, 125, 20);
		leftSide.add(addStationButton);
		stationPanTextField.setBounds(160, 800, 125, 20);
		leftSide.add(stationPanTextField);
		//Adds Station Button and TextField
		addStationButton.addActionListener(this);
		
		//Add leftSide Panel to the Frame
		this.add(leftSide);
		
		
		//Add rightSide Panel to the Frame
		clickMe.setBounds(62, 475, 125, 50);
		rightSide.add(clickMe);
		clickMe.addActionListener(this);
		
		this.add(rightSide);
		
		//Basic GUI set-up
		this.setTitle("Hamming Distance");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 875);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) throws IOException {		
		new HammingDistanceGUI();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == stationButton) {
			//Compare with gets put into hammingDisCalc method
			Integer hamWant = Integer.parseInt(hdTextBox.getText());
			int hamWanted = hamWant.intValue();
			//HammDist = new HammingDistanceCalculator(wordSelected, "BESS");
			if(hamWanted == 1) {
				hamDisForNumber = HammDist.getNode1Words();
			}
			else if(hamWanted == 2) {
				hamDisForNumber = HammDist.getNode2Words();
			}
			else if(hamWanted == 3) {
				hamDisForNumber = HammDist.getNode3Words();
			}
			else if(hamWanted == 4) {
				hamDisForNumber = HammDist.getNode4Words();
			}
			else {
				//errorField.setText("Error: Wanted Hamming number not available");
			}
			textArea.setText("");
			for(int i = 0; i < hamDisForNumber.size(); i++) {
				textArea.append(hamDisForNumber.get(i) + "\n");
			}
		}
		else if(e.getSource() == calcHDButton) {
			HammDist.setNodes(0, 0, 0, 0, 0);
			
			String j = (String)compareWordComboBox.getSelectedItem();
			
			//HammDist.makeNewHamDisCalc(j, "BESS");
			
			hamDisResult0.setText("" + HammDist.getNodes().get(0));
			hamDisResult1.setText("" + HammDist.getNodes().get(1));
			hamDisResult2.setText("" + HammDist.getNodes().get(2));
			hamDisResult3.setText("" + HammDist.getNodes().get(3));
			hamDisResult4.setText("" + HammDist.getNodes().get(4));
		}
		else if(e.getSource() == addStationButton) {
			compareWordComboBox.addItem(stationPanTextField.getText());;
		}
		else if(e.getSource() == clickMe) {
			colorStyle++;
			if(colorStyle == 0) {
				rightSide.setBackground(Color.YELLOW);
				rightSide.setForeground(Color.GREEN);
				leftSide.setBackground(Color.GREEN);
				leftSide.setForeground(Color.YELLOW);
			}
			else if (colorStyle == 1) {
				rightSide.setBackground(Color.BLUE);
				rightSide.setForeground(Color.RED);
				leftSide.setBackground(Color.RED);
				leftSide.setForeground(Color.BLUE);
			}
			else if (colorStyle == 2) {
				rightSide.setBackground(Color.CYAN);
				rightSide.setForeground(Color.ORANGE);
				leftSide.setBackground(Color.ORANGE);
				leftSide.setForeground(Color.CYAN);
			}
			else if (colorStyle == 3) {
				rightSide.setBackground(Color.BLACK);
				rightSide.setForeground(Color.MAGENTA);
				leftSide.setBackground(Color.MAGENTA);
				leftSide.setForeground(Color.BLACK);
			}
			else if (colorStyle == 4) {
				rightSide.setBackground(Color.GRAY);
				rightSide.setForeground(Color.WHITE);
				leftSide.setBackground(Color.WHITE);
				leftSide.setForeground(Color.GRAY);
			}
			else if (colorStyle == 5) {
				rightSide.setBackground(Color.BLUE);
				rightSide.setForeground(Color.YELLOW);
				leftSide.setBackground(Color.YELLOW);
				leftSide.setForeground(Color.BLUE);
			}
			else if (colorStyle == 6) {
				rightSide.setBackground(Color.GREEN);
				rightSide.setForeground(Color.RED);
				leftSide.setBackground(Color.RED);
				leftSide.setForeground(Color.GREEN);
			}
			else if (colorStyle == 7) {
				rightSide.setBackground(Color.BLACK);
				rightSide.setForeground(Color.CYAN);
				leftSide.setBackground(Color.CYAN);
				leftSide.setForeground(Color.BLACK);
			}
			else if (colorStyle == 8) {
				rightSide.setBackground(Color.ORANGE);
				rightSide.setForeground(Color.MAGENTA);
				leftSide.setBackground(Color.MAGENTA);
				leftSide.setForeground(Color.ORANGE);
			}
			else if (colorStyle == 9) {
				rightSide.setBackground(Color.BLACK);
				rightSide.setForeground(Color.RED);
				leftSide.setBackground(Color.RED);
				leftSide.setForeground(Color.BLACK);
				colorStyle = 0;
			}
		}
		
		
	}
	
}
