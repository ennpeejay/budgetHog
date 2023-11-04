//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.awt.image.*;
class MainMenu 
{
     
static boolean newFileOpen = false;	
public static JScrollPane scrollPane = new JScrollPane();
	public MainMenu() 
	{
		
	}

		public void displayMenu() 
		{
		
	        //Creating main window the Frame
	        JFrame frame = new JFrame("BUDGET HOG");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setSize(screenSize.width-50, screenSize.height-50);
                Global.screenWidth = screenSize.width-50;
                Global.screenHeight = screenSize.height-50;
                
                

                
                Image icon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("hog.png"));  
                

               
                frame.setIconImage(icon);    
	        
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	        
	        //create menu bar
	        JMenuBar mb = new JMenuBar();
	        JMenu m1 = new JMenu("FILE");
	        JMenu m2 = new JMenu("CREATE");
                JMenu m3 = new JMenu("EDIT");
                JMenu m4 = new JMenu("HOW TO");                                  
	        mb.add(m1);
	        mb.add(m2);
                mb.add(m3);
                mb.add(m4);
	        JMenuItem m11 = new JMenuItem("DISPLAY");
	        JMenuItem m12 = new JMenuItem("CLOSE");
	        JMenuItem m13 = new JMenuItem("SAVE");
	        JMenuItem m14 = new JMenuItem("OPEN SAVED");
	        //JMenuItem m15 = new JMenuItem("DELETE");
	        JMenuItem m16 = new JMenuItem("EXIT");
	        m1.add(m11);
	        m1.add(m12);
	        m1.add(m13);
	        m1.add(m14);
	        //m1.add(m15);
	        m1.add(m16);
	        JMenuItem m21 = new JMenuItem("REPORTING DATE PERIOD");
	        JMenuItem m22 = new JMenuItem("INCOME ITEM");
	        JMenuItem m23 = new JMenuItem("BILL ITEM");
	        JMenuItem m24 = new JMenuItem("IRREGULAR ITEM");
	        m2.add(m21);
	        m2.add(m22);
	        m2.add(m23);
	        m2.add(m24);
                JMenuItem m31 = new JMenuItem("DELETE");
                JMenuItem m32 = new JMenuItem("MODIFY");
                JMenuItem m33 = new JMenuItem("RE-ORDER");
                m3.add(m31);
                m3.add(m32);
                m3.add(m33);
                JMenuItem m41 = new JMenuItem("CREATE NEW CHART---first CREATE->REPORTING DATE PERIOD once only --- then CREATE->BILL ITEMs as required --- then CREATE->INCOME ITEMs as required --- then CREATE->IRREGULAR ITEMs if required");
    	        JMenuItem m42 = new JMenuItem("MODIFY AN ITEM ---first go EDIT->MODIFY --- then select the existing item to be modified in the list --- then make any changes to item details --- then submit the changes");
    	        JMenuItem m43 = new JMenuItem("DELETE AN ITEM  ---first go EDIT->DELETE --- than select the existing item to be deleted from the list --- then press delete");
    	        JMenuItem m44 = new JMenuItem("SAVE CHART TO FILE ---first go FILE->SAVE then give your new file a name and location or highlight an existing file --- then press save");
    	        JMenuItem m45 = new JMenuItem("OPEN EXISTING CHART FROM FILE --- first go FILE->OPEN EXISTING --- then select the file to open --- then press open");
    	        JMenuItem m46 = new JMenuItem("RETURN TO CURRENTLY OPEN CHART AT ANY TIME --- go FILE->DISPLAY");
    	        JMenuItem m47 = new JMenuItem("MANUALLY EDIT ONE CELL IN CHART --- first place cursor in cell to be edited --- then edit figures --- then press enter ");
    	        
    	        
    	     
    	        
    	     m4.add(m41);
    	     m4.add(m42);
    	     m4.add(m43);
    	     m4.add(m44);
    	     m4.add(m45);
    	     m4.add(m46);
    	     m4.add(m47);
    	     
    	    // m41.add(mytext);
            
                
                JPanel waitPanel = new JPanel(new BorderLayout());
                JLabel waitLabel = new JLabel("PLEASE WAIT WHILE LOADING");
                waitLabel.setHorizontalAlignment(JLabel.CENTER);
                waitLabel.setVerticalAlignment(JLabel.CENTER);
                waitLabel.setPreferredSize(new Dimension(100, 20));
                waitPanel.add(waitLabel, BorderLayout.CENTER);
                
                JPanel savePanel = new JPanel(new BorderLayout());
                JLabel saveLabel = new JLabel("PLEASE WAIT WHILE SAVING");
                saveLabel.setHorizontalAlignment(JLabel.CENTER);
                saveLabel.setVerticalAlignment(JLabel.CENTER);
                saveLabel.setPreferredSize(new Dimension(100, 20));
                savePanel.add(saveLabel, BorderLayout.CENTER);
	        
               
	        //add listener to menu bar
	        ActionListener menuListener = new ActionListener() 
	        {
		        @Override
		        public void actionPerformed(ActionEvent event)
		        {
		            
		        	//FILE - DISPLAY
		        	if(event.getSource()==m11)
                                {
                                    DisplayChart();
                                }
		        	
		        	//FILE - CLOSE
		        	else if(event.getSource()==m12) 
		        	{
                                    scrollPane.setViewportView(null);
                                    scrollPane.setColumnHeaderView(null);
                                    scrollPane.setRowHeaderView(null);
                                    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
		        		
                                    JPanel myPanel2 = new JPanel();
                                    myPanel2.setLayout(new FlowLayout (FlowLayout.LEFT));
		                 
		                 //scrollPane.repaint();
                                    scrollPane.setViewportView(myPanel2);
                                    
                                    Global.tallyCreated = false;
                                    Global.intervalPanelCreated = false;
                                    Global.Init();
                                    
                                    
		                 		
				 

		        	}
                                
                                //FILE - SAVE AS
                                if(event.getSource()==m13) 
                                {
                                	
                                	
                                    if (Global.intervalPanelCreated==true)
                                    {
                                    	 scrollPane.setViewportView(null);
                                         
                                         scrollPane.setColumnHeaderView(null);
                                         scrollPane.setRowHeaderView(null);
                                         scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                     
                                         scrollPane.setViewportView(savePanel);
                                        JFileChooser fileChooser = new JFileChooser();
                                        fileChooser.setApproveButtonText("Save");
                                        fileChooser.setDialogTitle("Save");
                                        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
                                        {
                                        	boolean validFile = true;
                                        	File file = fileChooser.getSelectedFile();
                                        	if(file.exists())
                                        	{
                                        		try
    	                                        {
                                            		FileInputStream fis = new FileInputStream(file);
                                            		ObjectInputStream ois = new ObjectInputStream(fis);
    	
                                            		Global.checkStringArray = (String[][]) ois.readObject();
    	                                          
                                            		ois.close();
    	                                          
    	                                        }
                                            	catch (Exception ois) 
                                        		{
                                            	  validFile=false;
                                              	 JOptionPane.showMessageDialog(null, "save to file failure - please try again");
                                        		}
                                        	}
                                        	
                                        
                                        	
                                          if(validFile==true)
                                          {
                                        	  
                                        	 // boolean loaded = false;
                                             
                                        	  try {
                                        		 
                                        		  
  	                                            FileOutputStream fos = new FileOutputStream(file);
  	                                            ObjectOutputStream oos = new ObjectOutputStream(fos);
  	                                            WriteToStringArray();
  	                                            oos.writeObject(Global.stringArray);
  	                                            oos.flush();
  	                                            oos.close();
  	                                            fos.close();
  	                                            
  	                                          
  	                                                    
  	                                            }
  		                                          
  	                                            catch (Exception ioe) 
  	                                            {
  	                                            	 JOptionPane.showMessageDialog(null, "save to file failure - please try again");
  	                                            	 validFile=false;
  	                                            }
                                        	
  	                                          // load from file
                                          }
                                          Global.tallyCreated = true;
                                          Global.intervalPanelCreated = true;
                                          DisplayChart();
	                                	  		
                                    
                                        }
                                        else
                                        {
                                        	scrollPane.setViewportView(null);
                                            //JOptionPane.showMessageDialog(null,"Cannot save blank chart to file");
                                        }
                                    }
                                    else
                                    {
                                        scrollPane.setViewportView(null);
                                            scrollPane.setColumnHeaderView(null);
                                            scrollPane.setRowHeaderView(null);
                                            scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                        JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE PERIOD column first.");
                                    }
                                }
                                
                                
                                
                                //FILE - OPEN EXISTING
                                if(event.getSource()==m14) 
                                {
                                    boolean loaded = false;
                                    scrollPane.setViewportView(null);
                                     //scrollPane.setViewportView(null);
                                        scrollPane.setColumnHeaderView(null);
                                        scrollPane.setRowHeaderView(null);
                                        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                    
                                    scrollPane.setViewportView(waitPanel);
                                    
                                    JFileChooser fileChooser = new JFileChooser();
                                    //fileChooser.setApproveButtonText("OPEN");
                                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
                                    {
                                      
                                      File file = fileChooser.getSelectedFile();
                                      
                                     
                                        try
                                        {
                                         
                                            FileInputStream fis = new FileInputStream(file);
                                            ObjectInputStream ois = new ObjectInputStream(fis);

                                            Global.stringArray = (String[][]) ois.readObject();
                                            ReadFromStringArray();
                                            
                                            ois.close();
                                           
                                            fis.close();
                                            Global.tallyCreated = true;
                                            Global.intervalPanelCreated = true;
                                            DisplayChart();
                                            ///////////////////////////////////////////////////////////
                                            /**
                                            Global.tallyCreated = true;
                                            Global.intervalPanelCreated = true;
                                            scrollPane.setViewportView(null);
                                            scrollPane.setColumnHeaderView(null);
                                            scrollPane.setRowHeaderView(null);
                                            scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                            
                                            scrollPane.setViewportView(DisplayGrid());
                                            scrollPane.setColumnHeaderView(DisplayColHeader());
                                            scrollPane.setRowHeaderView(DisplayRowHeader());
                                            scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, DisplayCornerHeader());
                                            HighlightToday();
                                            **/ 
                                            ////////////////////////////////////////////////////////////
                                        } 
                                        catch (Exception e) 
                                        {
                                        	scrollPane.setViewportView(null);
                                        	Global.tallyCreated = false;
                                            Global.intervalPanelCreated = false;
                                            Global.Init();
                                        	 JOptionPane.showMessageDialog(null, "Invalid file - please try again");
                                            return;
                                        } 
                                        

                                        
                                    }
                                    else
                                    {
                                        
                                        scrollPane.setViewportView(null);
                                        scrollPane.setColumnHeaderView(null);
                                        scrollPane.setRowHeaderView(null);
                                        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                    }
                                   
                                }
                                
		        	//FILE - EXIT
		        	else if(event.getSource()==m16)
		        	{
		            	
		            	System.exit(0);
                                }
		        	//CREATE - INCOME ITEM
		        	else if(event.getSource()==m22)
                         DisplayCreateIncomeScreen();  
		        	//CREATE - BILLS ITEM
		        	else if(event.getSource()==m23)
                          DisplayCreateBillsScreen();     
                                
                                //CREATE - IRREGULAR ITEM
		        	else if(event.getSource()==m24)
                           DisplayCreateIrregularScreen();

		        	//CREATE - REPORTING DATE INTERVAL
		        	else if(event.getSource()==m21)
		        	{
                                    if(Global.intervalPanelCreated==false)
                                    {
                                        scrollPane.setViewportView(null);
                                        scrollPane.setColumnHeaderView(null);
                                        scrollPane.setRowHeaderView(null);
                                        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
		        		CreateDatesScreen myCreateScreen = new CreateDatesScreen();
		        		JPanel myPanel = new JPanel();
		             
                                        myPanel.add(myCreateScreen.displayCreateDatesScreen());
                                        scrollPane.setViewportView(myPanel);
                                        
                                    }
                                    else
                                    {
                                        scrollPane.setViewportView(null);
                                        scrollPane.setColumnHeaderView(null);
                                        scrollPane.setRowHeaderView(null);
                                        scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                        JOptionPane.showMessageDialog(null, "REPORTING DATE PERIOD column already created. you must DELETE it first if you wish to reCREATE it.");
                                        DisplayChart();
                                    }
                                    
                                    
		            	
		        		
		        	}
                                //EDIT - DELETE ITEM
                                else if(event.getSource()==m31)
                                	DisplayDeleteItemScreen();
                                // EDIT - MODIFY ITEM
                                else if(event.getSource()==m32)
                                	DisplayModifyItemScreen();
                                
                                else if(event.getSource()==m33)
                                	DisplayReorderScreen();
                                    
                                //scrollPane.repaint();
                                	
		        	
                                
		        }
		    };
		    frame.add(mb, BorderLayout.NORTH);
		    frame.add(scrollPane, BorderLayout.CENTER);
		    
		    m11.addActionListener(menuListener);
		    m12.addActionListener(menuListener);
		    m13.addActionListener(menuListener);
		    m14.addActionListener(menuListener);
		    //m15.addActionListener(menuListener);
		    m16.addActionListener(menuListener);
		    
		    m21.addActionListener(menuListener);
		    m22.addActionListener(menuListener);
		    m23.addActionListener(menuListener);
		    m24.addActionListener(menuListener);
		    //m25.addActionListener(menuListener);
		    //m26.addActionListener(menuListener);
                    
                    m31.addActionListener(menuListener);
                    m32.addActionListener(menuListener);
                    m33.addActionListener(menuListener);
                    
                    
		   
		    //frame.setSize(1000,1000);
	       
	        frame.setVisible(true);
                
                
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		public static void DisplayCreateIncomeScreen()
        {
            if(Global.intervalPanelCreated==true)
            {
                scrollPane.setViewportView(null);
                scrollPane.setColumnHeaderView(null);
                scrollPane.setRowHeaderView(null);
                scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);

                    CreateIncomeScreen myCreateScreen = new CreateIncomeScreen();
                    JPanel myPanel = new JPanel();

            myPanel.add(myCreateScreen.displayCreateIncomeScreen());

            scrollPane.setViewportView(myPanel);
            }
            else
            {
                scrollPane.setViewportView(null);
                    scrollPane.setColumnHeaderView(null);
                    scrollPane.setRowHeaderView(null);
                    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE PERIOD column first.");
            }
            


        }
		
		public static void DisplayCreateBillsScreen()
		 {
            if(Global.intervalPanelCreated==true)
           {
               scrollPane.setViewportView(null);
                   scrollPane.setColumnHeaderView(null);
                   scrollPane.setRowHeaderView(null);
                   scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);

                       CreateBillsScreen myCreateScreen = new CreateBillsScreen();
                       JPanel myPanel = new JPanel();

               myPanel.add(myCreateScreen.displayCreateBillsScreen());

               scrollPane.setViewportView(myPanel);
               
           }
           else
           {   
               scrollPane.setViewportView(null);
               scrollPane.setColumnHeaderView(null);
               scrollPane.setRowHeaderView(null);
               scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
               JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE PERIOD column first.");
           }
           
 
		 }
		
		
			public static void DisplayCreateIrregularScreen()
		 {
             //JOptionPane.showMessageDialog(null,"in irregular");
              if(Global.intervalPanelCreated==true)
             {
                 scrollPane.setViewportView(null);
                     scrollPane.setColumnHeaderView(null);
                     scrollPane.setRowHeaderView(null);
                     scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);

                         CreateIrregularScreen myCreateScreen = new CreateIrregularScreen();
                         JPanel myPanel = new JPanel();

                 myPanel.add(myCreateScreen.displayCreateIrregularScreen());

                 scrollPane.setViewportView(myPanel);
                 
             }
             else
             {   
                 scrollPane.setViewportView(null);
                 scrollPane.setColumnHeaderView(null);
                 scrollPane.setRowHeaderView(null);
                 scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                 JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE PERIOD column first.");
             }
             
   
}		
			
			public static void DisplayModifyItemScreen()
			{
                if(Global.intervalPanelCreated==true)
                {
                    scrollPane.setViewportView(null);
                scrollPane.setColumnHeaderView(null);
                scrollPane.setRowHeaderView(null);
                scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                Global.myModifyScreen = new CreateModifyScreen();
                JPanel myPanel = new JPanel();
 
                myPanel.add(Global.myModifyScreen.displayCreateModifyScreen());
           
                scrollPane.setViewportView(myPanel);
                }
                else
                {   
                    scrollPane.setViewportView(null);
                    scrollPane.setColumnHeaderView(null);
                    scrollPane.setRowHeaderView(null);
                    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                    JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE PERIOD column first.");
                }
            }			
		
		
		public static void DisplayDeleteScreen()
                {
                    scrollPane.setViewportView(null);
                                    scrollPane.setColumnHeaderView(null);
                                    scrollPane.setRowHeaderView(null);
                                    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
		        		DeleteItem myDeleteItemScreen = new DeleteItem();
		        		JPanel myPanel = new JPanel();
		             
		            	myPanel.add(myDeleteItemScreen.displayDeleteItemScreen());
                               
                                scrollPane.setViewportView(myPanel);
                }
		
		public static void DisplayDeleteItemScreen()
		{
            if(Global.intervalPanelCreated==true)
            {
             
                scrollPane.setViewportView(null);
               scrollPane.setColumnHeaderView(null);
               scrollPane.setRowHeaderView(null);
               scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                   DeleteItem myDeleteItemScreen = new DeleteItem();
                   JPanel myPanel = new JPanel();

                myPanel.add(myDeleteItemScreen.displayDeleteItemScreen());
       
                scrollPane.setViewportView(myPanel);
            }
            else
            {   
                scrollPane.setViewportView(null);
                scrollPane.setColumnHeaderView(null);
                scrollPane.setRowHeaderView(null);
                scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE PERIOD column first.");
            }
       
        	
}
		
		public static void DisplayReorderScreen()
		{
            if(Global.intervalPanelCreated==true)
            {
             
                scrollPane.setViewportView(null);
               scrollPane.setColumnHeaderView(null);
               scrollPane.setRowHeaderView(null);
               scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                   Reorder myReorderScreen = new Reorder();
                   JPanel myPanel = new JPanel();

                myPanel.add(myReorderScreen.displayReorderScreen());
       
                scrollPane.setViewportView(myPanel);
            }
            else
            {   
                scrollPane.setViewportView(null);
                scrollPane.setColumnHeaderView(null);
                scrollPane.setRowHeaderView(null);
                scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE PERIOD column first.");
            }
       
        	
}
		
		
		
                public static JPanel DisplayGrid()
                {
                    GridLayout textFieldGrid = new GridLayout(Global.getNumRows(Global.textFieldArray,0)-5,1);
                                    JPanel[] gridPanel = new JPanel[100];
                                    
                                    
                                    //JPanel colPanel = new JPanel();
                                    //colPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                                    
                                    JPanel mainPanel = new JPanel();
                                    mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                                    
                                    boolean isSum=false;
                                    
                                    GenColumn tallyColumn = new GenColumn("tally", 0, 0,0,0, 0, 0, 0, "",0, 0, "",isSum);
                                    
                                    /**for(int i = 0; i < Global.textFieldArray.length; i++)
                                    {
                                        JOptionPane.showMessageDialog(null,(Global.textFieldArray[i][0].getText().toString()));
                                    }**/
                                   
                                    //JOptionPane.showMessageDialog(null,Global.getNumCols(Global.textFieldArray));
                                    //////////////////////////////////////////////////////////////////////////////
                                   
                                    
                                    
                                    //////////////////////////////////////////////////////////////////////////////
                                    
                                    /**if(Global.tallyCreated==true)
                                    {
                                        for(int j = 5 ; j < Global.textFieldArray[0].length; j++)
                                        {
                                           
                                            Global.textFieldArray[0][j].setEditable(false);
                                        }
                                    }**/
                                    
                                    if(Global.getNumCols(Global.textFieldArray)>1)
                                    {
                                        int i;
                                        for( i =1; i<Global.getNumCols(Global.textFieldArray); i++)
                                        {

                                            gridPanel[i] = new JPanel();
                                            gridPanel[i].setLayout(textFieldGrid);
                                            for(int j=5; j<Global.getNumRows(Global.textFieldArray, i); j++)
                                            {

                                                gridPanel[i].add(Global.textFieldArray[i][j]);
                                                if(Global.tallyCreated==true)
                                                
                                                {
                                                    
                                                    if(i != (Global.getNumCols(Global.textFieldArray)-1))
                                                    {
                                                       //Global.textFieldArray[i][j].addActionListener(Global.tally);
                                                         //Global.textFieldArray[i][j].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
                                                        
                                                        Global.textFieldArray[i][j].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

                                                        //Global.textFieldArray[i][j].addKeyListener(Global.tally);
                                                       //Global.textFieldArray[i][j].addFocusListener(Global.getData2);
                                                    }
                                                    else
                                                    {
                                                       // Global.textFieldArray[i][j].setEditable(false);
                                                    }
                                                }
                                                else
                                                {
                                                    Global.textFieldArray[i][j].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
                                                    //Global.textFieldArray[i][j].addActionListener(Global.tally);
                                                     //Global.textFieldArray[i][j].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
                                                    //Global.textFieldArray[i][j].addKeyListener(Global.tally);
                                                  // Global.textFieldArray[i][j].addFocusListener(Global.getData2);
                                                   
                                                }
                                                
                                            }
                                            mainPanel.add(gridPanel[i]);
                                            //gridPanel.removeAll();
                                        } 
                                    }
                                    
                                    ///////////////////////////////////////////////////////////////////////////////////////////
		        		
		        		
                                        
                                        
                                        
		        		//tallyColumn.GenPanel();
                                        
                                        //HighlightToday();
		        		
		        		
		        		
		            	//scrollPane.setViewportView(myPanel);
		            	//scrollPane.setRowHeaderView(Global.globalPanelArrayList.get(0));
		            	//scrollPane.setColumnHeaderView(myHeaderPanel);
		            	//scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, Global.headerPanelArrayList.get(0));
		            	
                                
                                return mainPanel;
		            	
		        		
                }
                
                public static JPanel ReDisplayGrid()
                {
                    GridLayout textFieldGrid = new GridLayout(Global.getNumRows(Global.textFieldArray,0)-7,1);
                                    JPanel[] gridPanel = new JPanel[100];
                                    
                                    
                               
                                    
                                    JPanel mainPanel = new JPanel();
                                    mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                                    boolean isSum=false;
                                    
                                    GenColumn tallyColumn = new GenColumn("tally", 0, 0,0,0, 0, 0, 0, "",0, 0, "",isSum);
                                    
                                    Cursor cursor = new Cursor(Cursor.HAND_CURSOR); // HAND CURSOR
                                    
                                    if(Global.getNumCols(Global.textFieldArray)>1)
                                    {
                                        int i;
                                        for( i =1; i<Global.getNumCols(Global.textFieldArray); i++)
                                        {

                                            gridPanel[i] = new JPanel();
                                            gridPanel[i].setLayout(textFieldGrid);
                                            for(int j=7; j<Global.getNumRows(Global.textFieldArray, i); j++)
                                            {

                                                gridPanel[i].add(Global.textFieldArray[i][j]);
                                                //Cursor cursor = new Cursor(Cursor.HAND_CURSOR); // HAND CURSOR
                                                Global.textFieldArray[i][j].setCursor(cursor);
                                                if(Global.tallyCreated==true)
                                                
                                                {
                                                    
                                                    if(i != (Global.getNumCols(Global.textFieldArray)-1))
                                                    {
                                                       
                                                    }
                                                    else
                                                    {
                                                        
                                                    }
                                                }
                                                else
                                                {
                                                                                                   }
                                                
                                            }
                                            mainPanel.add(gridPanel[i]);
                                            mainPanel.setCursor(cursor);
                                           
                                        }
                                        
                                        
                                        
                                    }
                                    
                                    ///////////////////////////////////////////////////////////////////////////////////////////
		        		
		        		
                                        
                                        
                                        
		        		//tallyColumn.GenPanel();
                                        
                                        //HighlightToday();
		        		
		        		
		        		
		            	//scrollPane.setViewportView(myPanel);
		            	//scrollPane.setRowHeaderView(Global.globalPanelArrayList.get(0));
		            	//scrollPane.setColumnHeaderView(myHeaderPanel);
		            	//scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, Global.headerPanelArrayList.get(0));
		            	
                                
                                return mainPanel;
		            	
		        		
                }
                
                
                public static JPanel DisplayColHeader()
                {       
                    GridLayout textFieldGrid = new GridLayout(7,1);
                    JPanel[] gridPanel = new JPanel[100];
                    JPanel mainPanel = new JPanel();
                    mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    int i;
                    for( i =1; i<Global.getNumCols(Global.textFieldArray); i++)
                    {

                        gridPanel[i] = new JPanel();
                        gridPanel[i].setLayout(textFieldGrid);
                        for(int j=0; j<7; j++)
                        {
                           // Global.textFieldArray[i][j].setEditable(false);
                            gridPanel[i].add(Global.textFieldArray[i][j]);
                            if(i != (Global.getNumCols(Global.textFieldArray)-1))
                            {
                                //Global.textFieldArray[i][j].addActionListener(tally);
                            }
                        }
                        mainPanel.add(gridPanel[i]);
                        //gridPanel.removeAll();
                    }
                    return mainPanel;
                                    
                }
                
                public static JPanel DisplayRowHeader()
                {       
                    GridLayout textFieldGrid = new GridLayout(Global.getNumRows(Global.textFieldArray, 0)-7,1);
                    JPanel gridPanel = new JPanel();
                    JPanel mainPanel = new JPanel();
                    mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    
                    

                    gridPanel = new JPanel();
                    gridPanel.setLayout(textFieldGrid);
                    for(int j=7; j<Global.getNumRows(Global.textFieldArray, 0); j++)
                    {
                       // Global.textFieldArray[0][j].setEditable(false);
                        gridPanel.add(Global.textFieldArray[0][j]);
                        
                        
                    }
                    mainPanel.add(gridPanel);
                    //gridPanel.removeAll();
                    
                    return mainPanel;
                                    
                }
                
                 public static JPanel DisplayCornerHeader()
                {       
                    GridLayout textFieldGrid = new GridLayout(7,1);
                    JPanel gridPanel = new JPanel();
                    JPanel mainPanel = new JPanel();
                    mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    
                    

                    gridPanel = new JPanel();
                    gridPanel.setLayout(textFieldGrid);
                    for(int j=0; j<7; j++)
                    {
                        //Global.textFieldArray[0][j].setEditable(false);
                        gridPanel.add(Global.textFieldArray[0][j]);
                        
                    }
                    mainPanel.add(gridPanel);
                    //gridPanel.removeAll();
                    
                    return mainPanel;
                                    
                }
                
                public static void DisplayBlank()
                {
                    scrollPane.setViewportView(null);
                    scrollPane.setColumnHeaderView(null);
                    scrollPane.setRowHeaderView(null);
                    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                }
                
                
                
                
                
                
                 
        public static void HighlightToday()
		{
        	/**
        	for(int x=0; x<Global.textFieldArray.length;x++)
        	{
        		for(int y=0; y<Global.textFieldArray[0].length;y++)
        			
        		{
        			if(!((Global.textFieldArray[x][y].getBackground().equals(Color.LIGHT_GRAY))
        				||(Global.textFieldArray[x][y].getBackground().equals(Color.GREEN))))
        			{
        			Global.textFieldArray[x][y].setBackground(Color.WHITE);
        			}
        		}
        	}
        	for(int x = 0; x<Global.getNumCols(Global.textFieldArray);x++)
        	{
        		for(int y=0; y<7;y++)
        		{
        			Global.textFieldArray[x][y].setBackground(Color.ORANGE);
        		}
        	}
        	for(int y = 7; y<Global.getNumRows(Global.textFieldArray,0);y++)
        	{
        		//for(int y=0; y<7;y++)
        		//{
        			Global.textFieldArray[0][y].setBackground(Color.ORANGE);
        			Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][y].setBackground(Color.ORANGE);
        		//}
        	}
            for(int x = 0; x < Global.getNumCols(Global.textFieldArray)-1; x++)
            {
                for(int y = 7 ; y < Global.getNumRows(Global.textFieldArray,0); y++)
                {
                    if(Global.textFieldArray[x][0].getText().toString().equals("totals"))
                    {
                    	Global.textFieldArray[x][y].setBackground(Color.ORANGE);
                    }
                }
            }
            **/
			String test = Global.textFieldArray[0][4].getText().toString();
		   	
		   	Date intervalStartDate = new GregorianCalendar().getTime();
		   	try 
		   	{
	           
			  intervalStartDate = new SimpleDateFormat("dd-MM-yyyy").parse(test);
	        } catch (java.text.ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		  
		   	//Date incomeDate = new Date();
		   	
		   	Date sysDate = new Date();
		 
	   		
		 
	   		//if(sysDate.compareTo(intervalStartDate) >= 0)
	   		//{
	   			int prevOccurance = 0;
	   			int currOccurance = 0;
	   			for(int i = 7; i < Global.getNumRows(Global.textFieldArray, 0)-1; i++)
		   		{
	   				if((Global.textFieldArray[0][i].getBackground().equals(Color.GREEN))
	   					&&(prevOccurance==0))
	   				{
	   					prevOccurance=i;
	   				}
		   			Date currIntervalDate = Global.ddmmyyyyToDate(Global.textFieldArray[0][i].getText().toString());
		   			Date nextIntervalDate = Global.ddmmyyyyToDate(Global.textFieldArray[0][i+1].getText().toString());
		   			//Global.textFieldArray[index][i] = new JTextField();
		   			//Global.textFieldArray[j][i].removeMouseListener(Global.rightClick);
		   			if((sysDate.compareTo(currIntervalDate) >= 0) && (sysDate.compareTo(nextIntervalDate) < 0))
		   			{
		   				currOccurance=i;
		   				
		   				//////////////////////////////////////////////////////////////////
		   				for(int x=0; x<Global.textFieldArray.length;x++)
		   	        	{
		   	        		//for(int y=0; y<Global.textFieldArray[0].length;y++)
		   	        			
		   	        		//{
		   	        			if(
	   	        					(!(Global.textFieldArray[x][i].getBackground().equals(Color.LIGHT_GRAY)))
		   	        				//||(prevOccurance!=currOccurance)
		   	        				)
		   	        			{
		   	        			Global.textFieldArray[x][i].setBackground(Color.WHITE);
		   	        			}
		   	        		//}
		   	        	}
		   	        	
		   				
		   				///////////////////////////////////////////////////////////////////
		   				
		   				//JOptionPane.showMessageDialog(null, "sys " + sysDate.toString() + "curr " + currIntervalDate.toString() + "next " + nextIntervalDate.toString());
		   				for(int j = 0; j < Global.getNumCols(Global.textFieldArray); j++)
		   				{
		   					//if//((j!=0)&&(j!=(Global.getNumCols(Global.textFieldArray)-1))
		   					//	(Global.textFieldArray[j][i].getBackground().equals(Color.GREEN))		
		   						
		   					//{
		   					//	System.out.println("entered rclick call");
		   					//	Global.textFieldArray[j][i].removeMouseListener(Global.rightClick);
		   					//	Global.textFieldArray[j][i].addMouseListener(Global.rightClick);
		   						
		   					//}
		   					//else
		   					//{
		   					//	Global.textFieldArray[j][i].removeMouseListener(Global.rightClick);
		   					//}
		   					//if((!(Global.textFieldArray[j][i].getBackground().equals(Color.LIGHT_GRAY)))||((j==0))||(j==Global.getNumCols(Global.textFieldArray)-1)
		   						//	||(Global.textFieldArray[j][0].getText().toString().equals("totals")))
		   					if(!(Global.textFieldArray[j][i].getBackground().equals(Color.LIGHT_GRAY)))
							{
								Global.textFieldArray[j][i].setBackground(Color.GREEN);
							}
		   					if((j!=0)&&(j!=(Global.getNumCols(Global.textFieldArray)-1))
	   						//&&(Global.textFieldArray[j][i].getBackground().equals(Color.GREEN)))		
	   						&&(!(Global.textFieldArray[j][0].getText().toString().equals("totals"))))
		   					{
		   						//System.out.println("entered rclick call");
		   						Global.textFieldArray[j][i].removeMouseListener(Global.rightClick);
		   						Global.textFieldArray[j][i].addMouseListener(Global.rightClick);
		   						
		   					}
		   					else if(!(Global.textFieldArray[j][i].getBackground().equals(Color.GREEN)))
		   					{
		   						Global.textFieldArray[j][i].removeMouseListener(Global.rightClick);
		   						Global.textFieldArray[j][i].setBackground(Color.ORANGE);
		   						
		   					}
		   					else
		   					{
		   						Global.textFieldArray[j][i].removeMouseListener(Global.rightClick);
		   					}
		   				
	   					
		   					//else
		   					{	
		   						int greyTally = 0;
		   						int intervalTally=0;
		   						int accTally = 0;
		   						for(int z=1; z < Global.getNumCols(Global.textFieldArray)-1; z++)
		   						{
			                		if(Global.textFieldArray[z][i].getBackground().equals(Color.LIGHT_GRAY))
			                		{
			                			greyTally = greyTally + Integer.valueOf(Global.textFieldArray[z][i].getText().toString());
			                			//System.out.println(":"+Global.textFieldArray[z][y].getText().toString());
			                		}
			   					
			   						
			   						
		   						}
			   					intervalTally = Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][i].getText().toString());
			   					accTally = intervalTally-greyTally;
			   					String strAccTally = String.valueOf(accTally);
			   					int lastColIdx = Global.getNumCols(Global.textFieldArray)-1;
			   					//System.out.println("intervalTally:"+intervalTally+"greyTall:"+greyTally);
			   					Global.textFieldArray[lastColIdx][6].setText(strAccTally);
			   					//System.out.println("tl"+Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][6].getText().toString());
		   					}
			   			// MainMenu.DisplayChart();  
		   					//{
		   					//	greyTally = greyTally + Integer.valueOf(Global.textFieldArray[j][i].getText().toString());
		   					//	
		   					//	
		   					//}
		   					//intervalTally = Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][i].getText().toString());
		   					//Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][6].setText(String.valueOf(intervalTally-greyTally));
		   					
		   				}
		   				//sysDate = rollDate(sysDate,period);
		   			}
		   			else
		   			{
		   				for(int x=0; x<Global.textFieldArray.length;x++)
		   	        	{
		   	        		//for(int y=0; y<Global.textFieldArray[0].length;y++)
		   	        			
		   	        		//{
		   	        			//if(
	   	        				//	(!(Global.textFieldArray[x][i].getBackground().equals(Color.LIGHT_GRAY)))
		   	        			//	||(prevOccurance!=currOccurance)
		   	        			//	)
		   	        			//{
		   	        			Global.textFieldArray[x][i].setBackground(Color.WHITE);
		   	        			//}
		   	        		//}
		   	        	}
		   				
		   				for(int j = 0; j < Global.getNumCols(Global.textFieldArray); j++)
		   				{
		   					if((j!=0)&&(j!=(Global.getNumCols(Global.textFieldArray)-1)))
		   					{
		   						Global.textFieldArray[j][i].removeMouseListener(Global.rightClick);
		   						
		   						//if(!(Global.textFieldArray[j][i].getBackground().equals(Color.CYAN)))
		   						//{
		   						//	Global.textFieldArray[j][i].setBackground(Color.WHITE);
		   						//}
		   						
		   					}
		   					//if((!(Global.textFieldArray[j][i].getBackground().equals(Color.LIGHT_GRAY)))&&(!(Global.textFieldArray[j][i].getBackground().equals(Color.CYAN))))
		   						//{
		   							//Global.textFieldArray[j][i].setBackground(Color.WHITE);
		   						//}
		   					
		   					
		   					
		   				}
		   				//sysDate = rollDate(sysDate,period);
		   			}
		   			
		   			
		   		 
					////////////////////////////////////////////////////////////////////////////////////
					
					
		   			
		   			//gridPanel.add(Global.textFieldArray[index][i]);
		   			
	   			}
	   			for(int x = 0; x<Global.getNumCols(Global.textFieldArray);x++)
   	        	{
   	        		for(int y=0; y<7;y++)
   	        		{
   	        			if(!(Global.textFieldArray[x][y].getBackground().equals(Color.GREEN)))
   	        			{
   	        				Global.textFieldArray[x][y].setBackground(Color.ORANGE);
   	        			}
   	        		}
   	        	}
   	        	for(int y = 7; y<Global.getNumRows(Global.textFieldArray,0);y++)
   	        	{
   	        		//for(int y=0; y<7;y++)
   	        		//{
   	        		if(!(Global.textFieldArray[0][y].getBackground().equals(Color.GREEN)))
   	        		{
   	        			Global.textFieldArray[0][y].setBackground(Color.ORANGE);
   	        			Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][y].setBackground(Color.ORANGE);
   	        		}
   	        	}
   	            for(int x = 0; x < Global.getNumCols(Global.textFieldArray)-1; x++)
   	            {
   	                for(int y = 7 ; y < Global.getNumRows(Global.textFieldArray,0); y++)
   	                {
   	                    if((Global.textFieldArray[x][0].getText().toString().equals("totals"))
   	                    &&(!(Global.textFieldArray[x][y].getBackground().equals(Color.GREEN))))
   	                    {
   	                    	Global.textFieldArray[x][y].setBackground(Color.ORANGE);
   	                    }
   	                }
   	            }
	   		//}
	   		
		   	
		}
                
            public static void DisplayChart()
            {
            	//Global.inputErr=true;
                
                Point p = scrollPane.getViewport().getViewPosition();
                Point r = scrollPane.getColumnHeader().getViewPosition();
                Point s = scrollPane.getRowHeader().getViewPosition();
                //Point t = scrollPane.getCorner(JScrollPane.UPPER_LEFT_CORNER).getViewPosition();
                scrollPane.setViewportView(null);
                scrollPane.setColumnHeaderView(null);
                scrollPane.setRowHeaderView(null);
                scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);



                if(Global.intervalPanelCreated==true)
                {
                	
                    
                    scrollPane.setViewportView(ReDisplayGrid());
                   
                    scrollPane.setColumnHeaderView(DisplayColHeader());
                    scrollPane.setRowHeaderView(DisplayRowHeader());
                    scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, DisplayCornerHeader());
                     HighlightToday();
                     
                   /**  boolean inDebit = false;
     				//int lastColNum = Global.getNumCols(Global.textFieldArray);
     				for (int j = 7; j < Global.getNumRows(Global.textFieldArray,Global.getNumCols(Global.textFieldArray)-1); j++) 
     				{
     					if(Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString())<0)
     					{
     						Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].setBackground(Color.YELLOW);
     						inDebit = true;
     					}
     				
     				}
     				if(inDebit==true)
     				{
     					int lastColNum = Global.getNumCols(Global.textFieldArray);
     					//System.out.println("inDebit");
     					//System.out.println(Global.textFieldArray[lastColNum][5].getText().toString());
     					Global.textFieldArray[lastColNum-1][6].setBackground(Color.YELLOW);
     				}**/
                     
                    /** int lowestAmt=Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][7].getText().toString());
						boolean inDebit = false;
						int counter=7;
						//int lastColNum = Global.getNumCols(Global.textFieldArray);
						for (int j = 7; j < Global.getNumRows(Global.textFieldArray,Global.getNumCols(Global.textFieldArray)-1); j++) 
						{
							if(Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString())<0)
							{
								Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].setBackground(Color.YELLOW);
								inDebit = true;
							}
							if(Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString())<lowestAmt)
							{
								lowestAmt=Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString());
								counter =j;
							}
						
						}
						int lastColNum = Global.getNumCols(Global.textFieldArray);
						if(inDebit==true)
						{
							
							//System.out.println("inDebit");
							//System.out.println(Global.textFieldArray[lastColNum][5].getText().toString());
							Global.textFieldArray[lastColNum-1][6].setBackground(Color.YELLOW);
						}
						else
						{
							Global.textFieldArray[lastColNum-1][6].setText(String.valueOf(lowestAmt));
							Global.textFieldArray[lastColNum-1][6].setBackground(Color.YELLOW);
							Global.textFieldArray[lastColNum-1][counter].setBackground(Color.YELLOW);
						}**/
                     
                     scrollPane.getViewport().setViewPosition(p);
                     scrollPane.getColumnHeader().setViewPosition(r);
                     scrollPane.getRowHeader().setViewPosition(s);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You need to CREATE a REPORTING DATE PERIOD first");
                }


                newFileOpen = true;
                /**for(int i =0; i<(Global.textFieldArray.length);i++)
                {
                    for(int j =0; j<(Global.textFieldArray[0].length);j++)
                    {
                        JOptionPane.showMessageDialog(null,Global.textFieldArray[i][j].getText().toString()+"-"+i+"-"+j);
                    }
               }**/

		        	
            }
            
           
            public void UpdateTally()
            {
                if(Global.tallyCreated==true)
                {
                    JOptionPane.showMessageDialog(null,"updating");
                    int numCols = Global.getNumCols(Global.textFieldArray);
                        int numRows = Global.getNumRows(Global.textFieldArray, 0);
                        int amountTl = 0;
			   		for(int i = 7; i < numRows-1 ; i++)//rows
			   		{
			   			//amountTl = 0;
			   			for(int j = 1; j < numCols; j++)//columns
			   			{
			   				amountTl = amountTl + Integer.valueOf(Global.textFieldArray[j][i].getText());
				   			//Global.textFieldArray[j][i].addActionListener(tally);
				   			
			   			}
		                                
		                                
			   			//Global.textFieldArray[numCols][i].setEditable(true);
			   			Global.textFieldArray[numCols][i].setText(String.valueOf(amountTl));
		                               // Global.textFieldArray[numCols][i].setEditable(false);
			   			//Global.textFieldArray[numCols][i].setPreferredSize(new Dimension(100, 20));
		                               
			   			
			   			
			   			
		   			}
                        
                }
            }
            
            public void WriteToStringArray()
            {
            	for(int x=0;x<Global.textFieldArray.length;x++)
            	{
            		for(int y=0;y<Global.textFieldArray[0].length;y++)
            		{
            			Global.stringArray[x][y]=Global.textFieldArray[x][y].getText().toString();
            		}
            	}
            }
            
            public void ReadFromStringArray()
            {
	            for(int x=0;x<Global.textFieldArray.length;x++)
	        	{
	        		for(int y=0;y<Global.textFieldArray[0].length;y++)
	        		{
	        			Global.textFieldArray[x][y].setText(Global.stringArray[x][y]);
	        		}
	        	}
            }
            
		
		
    
}
