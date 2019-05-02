# Project5
UML Image
![Screenshot (38)](https://user-images.githubusercontent.com/24547290/57091895-d17a6400-6ccf-11e9-8897-b5d82ccd848d.png)

HammingDistanceCalculator 
  Variables:
    ArrayList<Integer> nodes = takes in all the node types at the end for a return method
    int sNode0 = Nodes with 0 differences in the given word
    int sNode1 = Nodes with 1 difference in the given word
    int sNode2 = Nodes with 2 differences in the given word
    int sNode3 = Nodes with 3 differences in the given word
    int sNode4 = Nodes with 4 differences in the given word
    ArrayList<String> wordsAtNode1 = stores the words that correspond with sNode1
    ArrayList<String> wordsAtNode2 = stores the words that correspond with sNode2
    ArrayList<String> wordsAtNode3 = stores the words that correspond with sNode3
    ArrayList<String> wordsAtNode4 = stores the words that correspond with sNode4
  
  Methods:
    HammingDistanceCalculator(String, String) = Main method to find all the HammingDistances
    ArrayList<String> getNodes() = returns the nodes ArrayList stated earlier
    String[] getWords() = returns words in the Mesonet file
    ArrayList<String> getNode1Words = returns the words that correspond with sNode1
    ArrayList<String> getNode2Words = returns the words that correspond with sNode2
    ArrayList<String> getNode3Words = returns the words that correspond with sNode3
    ArrayList<String> getNode4Words = returns the words that correspond with sNode4
    HammingDistanceCalculator makeNewHamDisCalc(String, String) = returns a new HammingDistanceCalculator object
    void setNodes(int, int, int, int, int) = resets the values of the nodes to 0
  
  
  
  
HamDisSlider
  Variables:
    None
    
  Methods:
    HamDisSlider() = constructor to outline what the slider will look like
    JSlider makeHamDisSlider() = makes a HamDisSlider object
    
    
    
    
HammingDistanceGUI
  Variables:
    String[] mesonetContents = array with words in Mesonet file
    String wordSelected = says what word is selected in the JComboBox object
    ArrayList<String> hamDisForNumber = has HamDis for number
    int colorStyle = value that determines the clickme button pattern
    JPanel leftSide = left side of the frame
    JPanel rightSide = right side of the frame
    JLabel enteringHD = describes what goes into the text box next to it
    JLabel compareWord = tells user that the box next to it is for comparing
    JLabel hamDisResultLabel0 = describes nodes that have a value of 0
    JLabel hamDisResultLabel1 = describes nodes that have a value of 1
    JLabel hamDisResultLabel2 = describes nodes that have a value of 2
    JLabel hamDisResultLabel3 = describes nodes that have a value of 3
    JLabel hamDisResultLabel4 = describes nodes that have a value of 4
    JTextField hdTextBox = takes input on what HammingDistance to find
    JTextField hamDisResult0 = nodes that have a value of 0 show here
    JTextField hamDisResult1 = nodes that have a value of 1 show here
    JTextField hamDisResult2 = nodes that have a value of 2 show here
    JTextField hamDisResult3 = nodes that have a value of 3 show here
    JTextField hamDisResult4 = nodes that have a value of 4 show here
    JTextField stationPanTextField = allows you to add onto JComboBox object
    JButton stationButton = button that shows words that have x amount of nodes
    JButton calcHDButton = button that tells you all the nodes compared to the selected word
    JButton addStationButton = button that adds the made word to the JComboBox
    JButton clickMe = fun button that changes the screen color
    JSlider hdSliderSelecter = shows the slider version for selecting the Hamming Distance node desired
    JTextArea textArea = area that shows words that match the specificed node
    JScrollBar compareWordScrollBar = scroll bar
    JComboBox compareWordComboBox = box on screen that allows user to choose the word to compare
  
  Method:
    HammingDistanceGUI() = constructor that makes the GUI
    void main(String[] args) = runs the program at the start
    void actionPerformed(ActionEvent e) = fulfills the request of the buttons
    
    
    
BRAINSTORMING CLASS:
Used this class to come up with ideas for each object that I could see from the example GUI. No real code is in this class but lots of pre-planning was done here.

HAMMINGDISTANCECALCULATOR:
This class does all the hard work from a previous project. There is one big method (did this for fun and to see if I could do it in one) with several smaller methods that are basically getters of variables in the big method. These smaller methods include the words in the Mesonet file, the nodes that are made from the big method, etc.

HAMDISSLIDER CLASS:
This class covers the creation of the slider. It makes the basic ticks on the slider, changed the parameters of the slider, enables the slider to move to the nearest tick, and enabled the user to see the ticks/labels of the slider. There is also a Hashtable object that takes the number tick and the String that goes along with the tick

HAMMINGDISTANCEGUI CLASS:
This was the main/driver class that gets the code working. At the very beginning, there was a panel for every item on the example GUI just to be safe, but it became very confusing fast. I then decided to cut it down to be 2 panels with null border layouts. The objects that were made needed to have a border layout for each one to be placed in a similar spot as the Practice GUI. Each object was specifically set to be at a certain spot in the panel to look as similar to the example as possible, making it look a lot neater than 10 panel boxes all over the screen. The objects that were created range from JTextFields to JButtons to JComboBox to account for all the different types of GUI applications brought up in the project. The constructor of the class makes a GUI Frame and adds everything to the left-side Panel expect the ClickMe button. The code will run through the presented variables given by the Mesonet text file and the JComboBox object, showing the Hamming Distance of the code in JTextFields. At the bottom are some actionListeners that activate when a certain button is pushed, changing the objects in the GUI.
