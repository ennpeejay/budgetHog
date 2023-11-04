
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.*;

public class Global {
	
		
		public static boolean rightclick = false;
	
		public static int screenHeight = 0;
		public static int screenWidth = 0;
	
		public static final String space = "-";
    
        public static final int maxVal = 100000;
        public static final int minVal = -100000;
    
        public static final int maxRows = 1000;
        public static final int maxCols = 50;
        
        public static final int cellWidth = 75;
        public static final int cellHeight = 15;
        public static final int cellFontSize = 13;
        
        public static final int irregularDescriptionCellWidth = 200;
    
        public static int modSelIndex = 0;
        
        public static boolean dontTriggerFocus = false;
    
        public static CreateModifyScreen myModifyScreen=null; 
        public static CreateModifyBillsScreen myModifyBillsScreen=null;
         public static CreateModifyIncomeScreen myModifyIncomeScreen=null;
         public static CreateModifyDatesScreen myModifyDatesScreen=null;
          public static CreateModifyIrregularScreen myModifyIrregularScreen=null;
    
        public static String origData = "0";
        public static int y = 0;
        public static int x = 0;
        
        public static boolean inputErr = false;
	
	
	public static boolean intervalPanelCreated = false;
	public static int numRows = 0;
        public static boolean tallyCreated = false;
	public static JTextField[][] textFieldArray = new JTextField[maxCols+1][maxRows+5];
	public static String[][] stringArray = new String[maxCols+1][maxRows+5];
	public static String[][] checkStringArray = new String[maxCols+1][maxRows+5];
        
        public static JTextField[] tempDatesArray = new JTextField[maxRows+5];
        public static JTextField[] tempIrregularArray = new JTextField[maxRows+5];
        public static JTextField[] tempDetailsArray = new JTextField[maxRows+5];
        
        
        public static JTextField[][] tempTextFieldArray = new JTextField[2][maxRows+5];
        
        
        public static JTextField[][] checkTextFieldArray = new JTextField[maxCols+1][maxRows+5];
	
	
        public static int modifyScreenSelectedIndex = 0;
        public static int modifyScreenScrollBarValue = 0;
        
        
        public static MouseListener rightClick = new MouseAdapter() 
        {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
            	
                if (e.getButton() == e.BUTTON3) 
                {
                	//System.out.println(inputErr);
                	//inputErr = true;
                	//MainMenu.DisplayChart(); 
                	//JOptionPane.showMessageDialog(null,"right click");
                	rightclick=true;
                	 if ((e.getSource() instanceof JTextField) && (inputErr==false))
                     {
                		 inputErr = true;
                		 ///////////////////////////////////////////////////////////////////////////////////////////////////////
                		 
                		 for (int y = 0; y < Global.getNumRows(Global.textFieldArray,0); y++) 
                         {
                             for (int x = 1; x < Global.getNumCols(Global.textFieldArray); x++)
                             {
                                 if (e.getSource().equals(Global.textFieldArray[x][y])) 
                                 {
                                 	//System.out.println("rclick entered");
                                     try
                                     {   
                                         if(Global.textFieldArray[x][0].getText().toString().equals("income"))
                                         {
                                             if((Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),1)==true)
                                             &&(Integer.valueOf(Global.textFieldArray[x][y].getText())>-1)
                                             &&(Integer.valueOf(Global.textFieldArray[x][y].getText())<=Global.maxVal))

                                             {
                                             	//inputErr=true;
                                                 Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                                 Global.x=x;
                                                 Global.y=y;
                                                 Global.textFieldArray[x][y].getText().toString();
                                                 
                                                  MainMenu.DisplayChart();  
                                                  Global.textFieldArray[x][y].grabFocus();
                                                  //inputErr=false;
                                                  
                                                 if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                                 {
                                                     //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                                    // Global.textFieldArray[x][y+1].grabFocus();
                                                      
                                                 }
                                                 else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                                 {
                                                     //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                                     //Global.textFieldArray[x+1][5].grabFocus();
                                                   
                                                 }
                                                        
                                             }
                                             else
                                             {
                                             	//System.out.println("enterkey income");
                                             	//inputErr=true;
                                                 JOptionPane.showMessageDialog(null,"Data must be a whole number between 0 and "+Global.maxVal+".");
                                                 
                                                 Global.textFieldArray[x][y].setText(Global.origData);
                                                 Global.x=0;
                                                 Global.y=0;
                                                 
                                                 MainMenu.DisplayChart(); 
                                                Global.textFieldArray[x][y].grabFocus();
                                                //inputErr=false;
                                             }

                                         }
                                     }
                                     catch(Exception f)
                                     {
                                     	
                                     	//System.out.println("enter key income exception");
                                     	//inputErr=true;
                                         JOptionPane.showMessageDialog(null,"Data must be a whole number between 0 and "+Global.maxVal+".");
                                        
                                         Global.textFieldArray[x][y].setText(Global.origData);
                                         Global.x=0;
                                         Global.y=0;
                                         
                                        MainMenu.DisplayChart(); 
                                        Global.textFieldArray[x][y].grabFocus();
                                       // inputErr=false;
                                     }


                                     try
                                     { 

                                         if(Global.textFieldArray[x][0].getText().toString().equals("bills"))
                                         {
                                             if((Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),-1)==true)
                                             &&(Integer.valueOf(Global.textFieldArray[x][y].getText())>=Global.minVal)
                                             &&(Integer.valueOf(Global.textFieldArray[x][y].getText())<1))
                                             {
                                             	//inputErr=true;
                                                 Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                                 Global.x=x;
                                                 Global.y=y;
                                                 Global.textFieldArray[x][y].getText().toString();
                                                 
                                                 if(Global.textFieldArray[x+1][0].getText().toString().equals("totals"))
                                                 {
                                                 	int numRows = Global.getNumRows(Global.textFieldArray, 0);
                                                 	int total=0;
                                                 	for(int i = 7; i < numRows ; i++)
                                         	   		{
                                                 		if(i==7)
                                     		   			{
                                     		   				total=Integer.valueOf(Global.textFieldArray[x][i].getText());
                                     		   				Global.textFieldArray[x+1][i].setText(Global.textFieldArray[x][i].getText().toString());
                                     		   			}
                                     	   				if(i>7)
                                     	   				{
                                     	   					total=total+(Integer.valueOf(Global.textFieldArray[x][i].getText()));
                                     	   					Global.textFieldArray[x+1][i].setText(String.valueOf(total));
                                     	   				}
                                         	   		}
                                                 }
                                                 
                                                 MainMenu.DisplayChart(); 
                                                 Global.textFieldArray[x][y].grabFocus();
                                                // inputErr=false;
                                                 if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                                 {
                                                     //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                                    // Global.textFieldArray[x][y+1].grabFocus();
                                                      
                                                 }
                                                 else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                                 {
                                                     //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                                     //Global.textFieldArray[x+1][5].grabFocus();
                                                   
                                                 }
                                             }
                                             else
                                             {
                                             	//inputErr=true;
                                                 JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and 0");
                                                  Global.textFieldArray[x][y].setText(Global.origData);
                                                 Global.x=0;
                                                 Global.y=0;
                                                 

                                                 MainMenu.DisplayChart(); 
                                                 Global.textFieldArray[x][y].grabFocus();
                                                 //inputErr=false;
                                             }


                                         }


                                     }
                                     catch(Exception g)
                                     {
                                     	//inputErr=true;
                                          JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and 0");
                                          
                                         Global.textFieldArray[x][y].setText(Global.origData);
                                         Global.x=0;
                                         Global.y=0;
                                        

                                        MainMenu.DisplayChart(); 
                                        Global.textFieldArray[x][y].grabFocus();
                                       // inputErr=false;
                                     }

                                     try
                                     {   
                                         if(Global.textFieldArray[x][0].getText().toString().equals("irregular"))
                                         {
                                             if(  (   (Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),1)==true)
                                                   ||  (Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),-1)==true)
                                                     )
                                             &&      (Integer.valueOf(Global.textFieldArray[x][y].getText())>=Global.minVal)
                                             &&      (Integer.valueOf(Global.textFieldArray[x][y].getText())<=Global.maxVal)      
                                             )


                                             {
                                             	//inputErr=true;
                                                 Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                                
                                                 Global.x=x;
                                                 Global.y=y;
                                                 Global.textFieldArray[x][y].getText().toString();
                                                  MainMenu.DisplayChart(); 
                                                  Global.textFieldArray[x][y].grabFocus();
                                                  //inputErr=false;
                                                  if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                                 {
                                                     //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                                     //Global.textFieldArray[x][y+1].grabFocus();
                                                      
                                                 }
                                                 else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                                 {
                                                     //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                                    // Global.textFieldArray[x+1][5].grabFocus();
                                                   
                                                 }
                                             }
                                             else
                                             {
                                             	//inputErr=true;
                                             	JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and "+Global.maxVal+".");
                                                  Global.textFieldArray[x][y].setText(Global.origData);
                                                 Global.x=0;
                                                Global.y=0;
                                                 

                                                 MainMenu.DisplayChart(); 
                                                 Global.textFieldArray[x][y].grabFocus();
                                                // inputErr=false;
                                             }



                                         }
                                     }
                                     catch(Exception h)
                                     {
                                     	//inputErr=true;
                                     	JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and "+Global.maxVal+".");
                                         Global.textFieldArray[x][y].setText(Global.origData);
                                         Global.x=0;
                                         Global.y=0;
                                         

                                        MainMenu.DisplayChart(); 
                                        Global.textFieldArray[x][y].grabFocus();
                                       // inputErr=false;
                                     }


                                     if(Global.textFieldArray[x][0].getText().toString().equals("description"))
                                     {

                                     	//inputErr=true;
                                         Global.textFieldArray[x][y].setText(Global.textFieldArray[x][y].getText());
                                         // UpdateTally();
                                         Global.x=x;
                                          Global.y=y;
                                          Global.textFieldArray[x][y].getText().toString();
                                          MainMenu.DisplayChart();
                                          Global.textFieldArray[x][y].grabFocus();
                                         // inputErr=false;
                                         if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                         {
                                             //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                             //Global.textFieldArray[x][y+1].grabFocus();

                                         }
                                         else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                         {
                                             //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                             //Global.textFieldArray[x+1][5].grabFocus();

                                         }

                                     }
                                     //inputErr=true;
                                     //Global.textFieldArray[x][y].grabFocus();
                                     //inputErr=false;
                                     
                                     
                                    // for(int j=0; j<10; j++)
                                     //{
                                    // 	System.out.println(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)][j].getText().toString());
                                    // }

                                 }
                             }
                         }
                         
                		 ///////////////////////////////////////////////////////////////////////////////////////////////////////
                		 
                        
                         for (int y = 0; y < Global.getNumRows(Global.textFieldArray,0); y++) 
                         {
                             for (int x = 1; x < Global.getNumCols(Global.textFieldArray); x++)
                             {
                                 if (e.getSource().equals(Global.textFieldArray[x][y])) 
                                 {
                                	MainMenu.HighlightToday();
                                	 
                                	 if(!(Global.textFieldArray[x][y].getBackground().equals(Color.LIGHT_GRAY)))
                                	 {
                                		 Global.textFieldArray[x][y].setBackground(Color.LIGHT_GRAY);
                                		 //System.out.println("right click");
                                	 }
                                	 else
                                	 {
                                		 Global.textFieldArray[x][y].setBackground(Color.GREEN);
                                	 }
                                	 
                                	
                                	 //=================================================================================
                                	 /**for (int j = 0; j < Global.getNumRows(Global.textFieldArray,0); j++) 
     								{
     									
     									for (int k = 0; k < Global.getNumCols(Global.textFieldArray); k++)
     									{
     										if(!((Global.textFieldArray[k][j].getBackground().equals(Color.LIGHT_GRAY))||(Global.textFieldArray[k][j].getBackground().equals(Color.GREEN))))
     										{
     											Global.textFieldArray[k][j].setBackground(Color.WHITE);
     										}
     										
     									}
     								}**/
                                	 MainMenu.HighlightToday();
                              
     								////////////////////////////////////////////////////////////////////////////////////
     								for (int j = 0; j < Global.getNumRows(Global.textFieldArray,0); j++) 
     								{
     									//if(!(Global.textFieldArray[x][j].getBackground().equals(Color.LIGHT_GRAY)))
     									if(!((Global.textFieldArray[x][j].getBackground().equals(Color.LIGHT_GRAY))||(Global.textFieldArray[x][j].getBackground().equals(Color.GREEN))))
     									{
     										Global.textFieldArray[x][j].setBackground(Color.CYAN);
     									}
     									//Global.textFieldArray[x][j].setBackground(Color.CYAN);
     									for (int k = 0; k < Global.getNumCols(Global.textFieldArray); k++)
     									{
     										//if(!(Global.textFieldArray[k][y].getBackground().equals(Color.LIGHT_GRAY)))
     										if(!((Global.textFieldArray[k][y].getBackground().equals(Color.LIGHT_GRAY))||(Global.textFieldArray[k][y].getBackground().equals(Color.GREEN))))
     										{
     											Global.textFieldArray[k][y].setBackground(Color.CYAN);
     										}
     										//Global.textFieldArray[k][y].setBackground(Color.CYAN);
     									}
     								}
                                	//====================================================================================
     								//int greyTally = 0;
     			                	 //int intervalTally=0;
     			                	 //int accTally = 0;
     			                	 //for(int z=1; z < Global.getNumCols(Global.textFieldArray)-1; z++)
     			                	 //{
     			                		//if(Global.textFieldArray[z][y].getBackground().equals(Color.LIGHT_GRAY))
     			                		//{
     			                			//greyTally = greyTally + Integer.valueOf(Global.textFieldArray[z][y].getText().toString());
     			                			//System.out.println(":"+Global.textFieldArray[z][y].getText().toString());
     			                		//}
     				   					
     				   						
     				   						
     			                	 //}
     				   					//intervalTally = Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][y].getText().toString());
     				   					//accTally = intervalTally-greyTally;
     				   					//String strAccTally = String.valueOf(accTally);
     				   					//int lastColIdx = Global.getNumCols(Global.textFieldArray)-1;
     				   				//System.out.println("intervalTally:"+intervalTally+"greyTall:"+greyTally);
     				   					//Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][6].setText("strAccTally");
     				   				//System.out.println("tl"+Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][6].getText().toString());
     				   			// MainMenu.DisplayChart();  
     			                	 //========================================================================================
     								
     								 //MainMenu.DisplayChart();
     			                	 //Global.textFieldArray[x][y].grabFocus();
     			                	 //inputErr=false;
                                 }
                             }
                         }
                        //MainMenu.DisplayChart();  
                         inputErr=false;
                     }
                	 else
                	 {
                		// inputErr = false;
                	 }
                	 
                	
                	
                }
            }
        };
        
        
    
        
        public static KeyListener tally = new KeyAdapter() 
        {
            //@Override
            public void keyPressed(KeyEvent e) 
            {
            	
                if ((e.getSource() instanceof JTextField) && (inputErr==false))
                	
                {
                	inputErr=true;
                    if (e.getKeyCode() == e.VK_ENTER)
                        
                    {
                        //System.out.println("tab or enter pressed");
                        for (int y = 0; y < Global.getNumRows(Global.textFieldArray,0); y++) 
                        {
                            for (int x = 1; x < Global.getNumCols(Global.textFieldArray); x++)
                            {
                                if (e.getSource().equals(Global.textFieldArray[x][y])) 
                                {
                                	//System.out.println("enterkey entered");
                                    try
                                    {   
                                        if(Global.textFieldArray[x][0].getText().toString().equals("income"))
                                        {
                                            if((Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),1)==true)
                                            &&(Integer.valueOf(Global.textFieldArray[x][y].getText())>-1)
                                            &&(Integer.valueOf(Global.textFieldArray[x][y].getText())<=Global.maxVal))

                                            {
                                            	//inputErr=true;
                                                Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                                Global.x=x;
                                                Global.y=y;
                                                Global.textFieldArray[x][y].getText().toString();
                                                
                                                 MainMenu.DisplayChart();  
                                                 Global.textFieldArray[x][y].grabFocus();
                                                 //inputErr=false;
                                                 
                                                if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                                {
                                                    //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                                   // Global.textFieldArray[x][y+1].grabFocus();
                                                     
                                                }
                                                else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                                {
                                                    //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                                    //Global.textFieldArray[x+1][5].grabFocus();
                                                  
                                                }
                                                       
                                            }
                                            else
                                            {
                                            	//System.out.println("enterkey income");
                                            	//inputErr=true;
                                                JOptionPane.showMessageDialog(null,"Data must be a whole number between 0 and "+Global.maxVal+".");
                                                
                                                Global.textFieldArray[x][y].setText(Global.origData);
                                                Global.x=0;
                                                Global.y=0;
                                                
                                                MainMenu.DisplayChart(); 
                                               Global.textFieldArray[x][y].grabFocus();
                                               //inputErr=false;
                                            }

                                        }
                                    }
                                    catch(Exception f)
                                    {
                                    	
                                    	//System.out.println("enter key income exception");
                                    	//inputErr=true;
                                        JOptionPane.showMessageDialog(null,"Data must be a whole number between 0 and "+Global.maxVal+".");
                                       
                                        Global.textFieldArray[x][y].setText(Global.origData);
                                        Global.x=0;
                                        Global.y=0;
                                        
                                       MainMenu.DisplayChart(); 
                                       Global.textFieldArray[x][y].grabFocus();
                                      // inputErr=false;
                                    }


                                    try
                                    { 

                                        if(Global.textFieldArray[x][0].getText().toString().equals("bills"))
                                        {
                                            if((Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),-1)==true)
                                            &&(Integer.valueOf(Global.textFieldArray[x][y].getText())>=Global.minVal)
                                            &&(Integer.valueOf(Global.textFieldArray[x][y].getText())<1))
                                            {
                                            	//inputErr=true;
                                                Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                                Global.x=x;
                                                Global.y=y;
                                                Global.textFieldArray[x][y].getText().toString();
                                                
                                                if(Global.textFieldArray[x+1][0].getText().toString().equals("totals"))
                                                {
                                                	int numRows = Global.getNumRows(Global.textFieldArray, 0);
                                                	int total=0;
                                                	for(int i = 7; i < numRows ; i++)
                                        	   		{
                                                		if(i==7)
                                    		   			{
                                    		   				total=Integer.valueOf(Global.textFieldArray[x][i].getText());
                                    		   				Global.textFieldArray[x+1][i].setText(Global.textFieldArray[x][i].getText().toString());
                                    		   			}
                                    	   				if(i>7)
                                    	   				{
                                    	   					total=total+(Integer.valueOf(Global.textFieldArray[x][i].getText()));
                                    	   					Global.textFieldArray[x+1][i].setText(String.valueOf(total));
                                    	   				}
                                        	   		}
                                                }
                                                
                                                MainMenu.DisplayChart(); 
                                                Global.textFieldArray[x][y].grabFocus();
                                               // inputErr=false;
                                                if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                                {
                                                    //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                                   // Global.textFieldArray[x][y+1].grabFocus();
                                                     
                                                }
                                                else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                                {
                                                    //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                                    //Global.textFieldArray[x+1][5].grabFocus();
                                                  
                                                }
                                            }
                                            else
                                            {
                                            	//inputErr=true;
                                                JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and 0");
                                                 Global.textFieldArray[x][y].setText(Global.origData);
                                                Global.x=0;
                                                Global.y=0;
                                                

                                                MainMenu.DisplayChart(); 
                                                Global.textFieldArray[x][y].grabFocus();
                                                //inputErr=false;
                                            }


                                        }


                                    }
                                    catch(Exception g)
                                    {
                                    	//inputErr=true;
                                         JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and 0");
                                         
                                        Global.textFieldArray[x][y].setText(Global.origData);
                                        Global.x=0;
                                        Global.y=0;
                                       

                                       MainMenu.DisplayChart(); 
                                       Global.textFieldArray[x][y].grabFocus();
                                      // inputErr=false;
                                    }

                                    try
                                    {   
                                        if(Global.textFieldArray[x][0].getText().toString().equals("irregular"))
                                        {
                                            if(  (   (Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),1)==true)
                                                  ||  (Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),-1)==true)
                                                    )
                                            &&      (Integer.valueOf(Global.textFieldArray[x][y].getText())>=Global.minVal)
                                            &&      (Integer.valueOf(Global.textFieldArray[x][y].getText())<=Global.maxVal)      
                                            )


                                            {
                                            	//inputErr=true;
                                                Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                               
                                                Global.x=x;
                                                Global.y=y;
                                                Global.textFieldArray[x][y].getText().toString();
                                                 MainMenu.DisplayChart(); 
                                                 Global.textFieldArray[x][y].grabFocus();
                                                 //inputErr=false;
                                                 if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                                {
                                                    //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                                    //Global.textFieldArray[x][y+1].grabFocus();
                                                     
                                                }
                                                else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                                {
                                                    //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                                   // Global.textFieldArray[x+1][5].grabFocus();
                                                  
                                                }
                                            }
                                            else
                                            {
                                            	//inputErr=true;
                                            	JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and "+Global.maxVal+".");
                                                 Global.textFieldArray[x][y].setText(Global.origData);
                                                Global.x=0;
                                               Global.y=0;
                                                

                                                MainMenu.DisplayChart(); 
                                                Global.textFieldArray[x][y].grabFocus();
                                               // inputErr=false;
                                            }



                                        }
                                    }
                                    catch(Exception h)
                                    {
                                    	//inputErr=true;
                                    	JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and "+Global.maxVal+".");
                                        Global.textFieldArray[x][y].setText(Global.origData);
                                        Global.x=0;
                                        Global.y=0;
                                        

                                       MainMenu.DisplayChart(); 
                                       Global.textFieldArray[x][y].grabFocus();
                                      // inputErr=false;
                                    }


                                    if(Global.textFieldArray[x][0].getText().toString().equals("description"))
                                    {

                                    	//inputErr=true;
                                        Global.textFieldArray[x][y].setText(Global.textFieldArray[x][y].getText());
                                        // UpdateTally();
                                        Global.x=x;
                                         Global.y=y;
                                         Global.textFieldArray[x][y].getText().toString();
                                         MainMenu.DisplayChart();
                                         Global.textFieldArray[x][y].grabFocus();
                                        // inputErr=false;
                                        if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                        {
                                            //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                            //Global.textFieldArray[x][y+1].grabFocus();

                                        }
                                        else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                        {
                                            //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                            //Global.textFieldArray[x+1][5].grabFocus();

                                        }

                                    }
                                    //inputErr=true;
                                    //Global.textFieldArray[x][y].grabFocus();
                                    //inputErr=false;
                                    
                                    
                                   // for(int j=0; j<10; j++)
                                    //{
                                   // 	System.out.println(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)][j].getText().toString());
                                   // }

                                }
                            }
                        }
                        //MainMenu.DisplayChart();
                        //Global.textFieldArray[Global.x][Global.y].grabFocus();
                        
                    }
                    
                    inputErr=false;
                }
                else
                {
                	//inputErr=false;
                }
                //inputErr=false;
                //System.out.println("enter key exited");

            }

        };
        
        
        
       /** public static MouseListener getData = new MouseAdapter()
                                    {
                                        //@Override
                                        public void mouseClicked(MouseEvent g)
                                        {
                                            if (g.getSource() instanceof JTextField) 
                                            {
                                                for (int y = 0; y < Global.getNumRows(Global.textFieldArray,0); y++) 
                                                {
                                                        for (int x = 1; x < Global.getNumCols(Global.textFieldArray); x++)
                                                        {
                                                            if (g.getSource().equals(Global.textFieldArray[x][y])) 
                                                            {
                                                                if(!((x==Global.x)&&(y==Global.y)))
                                                                {
                                                                    
                                                                    Global.origData = Global.textFieldArray[x][y].getText().toString();
                                                                }
                                                                        
                                                                
                                                                //JOptionPane.showMessageDialog(null,"clicked");
                                                                
                                                               
                                                                

                                                            }
                                                        }
                                                }
                                            }
                                        
                                        }
                                    };  **/
        
        public static FocusListener getData2 = new FocusAdapter()
    {
        	
			
        @Override
        public void focusGained(FocusEvent h)
        {
        	
            //JOptionPane.showMessageDialog(null,"focus gained");
            if ((h.getSource() instanceof JTextField) && (inputErr==false) && (rightclick==false)) 
            {
            	inputErr=true;
            	//System.out.println("focus gained entered");
                for (int y = 0; y < Global.getNumRows(Global.textFieldArray,0); y++) 
                {
                        for (int x = 1; x < Global.getNumCols(Global.textFieldArray); x++)
                        {
                            if (h.getSource().equals(Global.textFieldArray[x][y])) 
                            {
                            	//System.out.println("focus gained entered");
                                //if(!((x==Global.x)&&(y==Global.y)))
                                //{
                                    
                                    Global.origData = Global.textFieldArray[x][y].getText().toString();
                                    //System.out.println("focus gained");
                                    //JOptionPane.showMessageDialog(null,x+"-"+Global.x+"   "+y+"-"+Global.y);
                                   
                                    
                                    
                                //}
                                    Global.x=x;
                                    Global.y=y;
                                
                                MainMenu.HighlightToday();
                                //Global.textFieldArray[x][y].grabFocus();
                                
                                
                               /** for (int j = 0; j < Global.getNumRows(Global.textFieldArray,0); j++) 
								{
									
									for (int k = 0; k < Global.getNumCols(Global.textFieldArray); k++)
									{
										if(!((Global.textFieldArray[k][j].getBackground().equals(Color.LIGHT_GRAY))
												||(Global.textFieldArray[k][j].getBackground().equals(Color.GREEN))
												||(Global.textFieldArray[k][j].getBackground().equals(Color.MAGENTA))))
										{
											Global.textFieldArray[k][j].setBackground(Color.WHITE);
										}
										
									}
								}**/
								////////////////////////////////////////////////////////////////////////////////////
								for (int j = 0; j < Global.getNumRows(Global.textFieldArray,0); j++) 
								{
									//if(!(Global.textFieldArray[x][j].getBackground().equals(Color.LIGHT_GRAY)))
									if(!((Global.textFieldArray[x][j].getBackground().equals(Color.LIGHT_GRAY))||(Global.textFieldArray[x][j].getBackground().equals(Color.GREEN))))
									{
										Global.textFieldArray[x][j].setBackground(Color.CYAN);
									}
									//Global.textFieldArray[x][j].setBackground(Color.CYAN);
									for (int k = 0; k < Global.getNumCols(Global.textFieldArray); k++)
									{
										//if(!(Global.textFieldArray[k][y].getBackground().equals(Color.LIGHT_GRAY)))
										if(!((Global.textFieldArray[k][y].getBackground().equals(Color.LIGHT_GRAY))||(Global.textFieldArray[k][y].getBackground().equals(Color.GREEN))))
										{
											Global.textFieldArray[k][y].setBackground(Color.CYAN);
										}
										//Global.textFieldArray[k][y].setBackground(Color.CYAN);
									}
								}
								
								
								
								
								
								
								
								///////////////////////////////////////////////////////////////////////////////////
								//for(int j=0; j<10; j++)
                                //{
                                //	System.out.println(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)][j].getText().toString());
                               // }
								if(!((Global.textFieldArray[x][y].getBackground().equals(Color.LIGHT_GRAY))
									||(Global.textFieldArray[x][y].getBackground().equals(Color.GREEN))))
								{
									
									int lowestAmt=Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][7].getText().toString());
									boolean inDebit = false;
									int counter=7;
									//int j=0;
									int currentPeriodCounter = 0;
									//int lastColNum = Global.getNumCols(Global.textFieldArray);
									for (int j = 7; j < Global.getNumRows(Global.textFieldArray,Global.getNumCols(Global.textFieldArray)-1); j++) 
									{
										if(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getBackground().equals(Color.GREEN))
										{
											currentPeriodCounter=j;
											lowestAmt=Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][currentPeriodCounter].getText().toString());
											//System.out.println("green :"+currentPeriodCounter);
											lowestAmt=Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString());
											
											
										}
										if(Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString())<0)
										{
											Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].setBackground(Color.YELLOW);
											inDebit = true;
										}
										//System.out.println("green :"+currentPeriodCounter);
										if((Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString())<=lowestAmt)
											&&(j>=currentPeriodCounter))
										{
											//System.out.println("lowestAmt :"+j);
											lowestAmt=Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][j].getText().toString());
											counter=j;
											//System.out.println(counter);
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
										//System.out.println(counter + " setCell");
									}
									
									/**for (int j = 0; j < Global.getNumRows(Global.textFieldArray,0); j++) 
									{
										for (int k = 0; k < Global.getNumCols(Global.textFieldArray); k++)
										{
											if((Global.textFieldArray[k][j].getBackground().equals(Color.LIGHT_GRAY))
												&&(j>7)
												&&(k!=0)
												&&(k!=Global.getNumCols(textFieldArray)-1)
												&&(!(Global.textFieldArray[k][0].getText().toString().equals("totals"))))
											{
												Global.textFieldArray[k][j].setBackground(Color.GREEN);
											}
										}
									}**/
								}
                        	}
                            else
                            {
                            	//MainMenu.HighlightToday();
                            }
                        }
                }
                inputErr=false;
                
            }
            rightclick=false;
            //System.out.println("focus gaine exited");
        
        }
        
        
        public void focusLost(FocusEvent i)
        {
        	
        	if ((i.getSource() instanceof JTextField) && (inputErr==false) && (rightclick==false))
            {
                inputErr=true;
        		System.out.println("focus lost entered");
                for (int y = 0; y < Global.getNumRows(Global.textFieldArray,0); y++) 
                {
                    for (int x = 1; x < Global.getNumCols(Global.textFieldArray); x++)
                    {
                        if ((i.getSource().equals(Global.textFieldArray[x][y]))) 
                        {
                        	//System.out.println("focus lost entered");
                            try
                            {   
                                if(Global.textFieldArray[x][0].getText().toString().equals("income"))
                                {
                                    if((Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),1)==true)
                                    &&(Integer.valueOf(Global.textFieldArray[x][y].getText())>-1)
                                    &&(Integer.valueOf(Global.textFieldArray[x][y].getText())<=Global.maxVal))

                                    {
                                    	//inputErr=true;
                                        Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                        Global.x=x;
                                        Global.y=y;
                                        Global.origData = Global.textFieldArray[x][y].getText().toString();
                                        
                                         MainMenu.DisplayChart(); 
                                        // Global.textFieldArray[x][y].grabFocus();
                                         //inputErr=false;
                                        if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                        {
                                            //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                           // Global.textFieldArray[x][y+1].grabFocus();
                                             
                                        }
                                        else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                        {
                                            //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                            //Global.textFieldArray[x+1][5].grabFocus();
                                          
                                        }
                                               
                                    }
                                    else
                                    {
                                    	//System.out.println("enterkey income");
                                    	//inputErr=true;
                                        JOptionPane.showMessageDialog(null,"Data must be a whole number between 0 and "+Global.maxVal+".");
                                       // inputErr=false;
                                        Global.textFieldArray[x][y].setText(Global.origData);
                                        Global.x=0;
                                        Global.y=0;
                                        
                                        MainMenu.DisplayChart(); 
                                       Global.textFieldArray[x][y].grabFocus();
                                      // inputErr=false;
                                    }

                                }
                            }
                            catch(Exception f)
                            {
                            	//inputErr=true;
                            	System.out.println("enter key income exception");
                            	//inputErr=true;
                                JOptionPane.showMessageDialog(null,"Data must be a whole number between 0 and "+Global.maxVal+".");
                                
                                System.out.println(Global.origData);
                                System.out.println("x="+String.valueOf(x)+"y="+String.valueOf(y));
                                
                                Global.textFieldArray[x][y].setText(Global.origData);
                                //Global.x=0;
                               // Global.y=0;
                                
                               MainMenu.DisplayChart(); 
                               Global.textFieldArray[x][y].grabFocus();
                               //inputErr=false;
                            }


                            try
                            { 

                                if(Global.textFieldArray[x][0].getText().toString().equals("bills"))
                                {
                                    if((Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),-1)==true)
                                    &&(Integer.valueOf(Global.textFieldArray[x][y].getText())>=Global.minVal)
                                    &&(Integer.valueOf(Global.textFieldArray[x][y].getText())<1))
                                    {
                                    	//inputErr=true;
                                        Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                        Global.x=x;
                                        Global.y=y;
                                        Global.textFieldArray[x][y].getText().toString();
                                        
                                        if(Global.textFieldArray[x+1][0].getText().toString().equals("totals"))
                                        {
                                        	int numRows = Global.getNumRows(Global.textFieldArray, 0);
                                        	int total=0;
                                        	for(int k = 7; k < numRows ; k++)
                                	   		{
                                        		if(k==7)
                            		   			{
                            		   				total=Integer.valueOf(Global.textFieldArray[x][k].getText());
                            		   				Global.textFieldArray[x+1][k].setText(Global.textFieldArray[x][k].getText().toString());
                            		   			}
                            	   				if(k>7)
                            	   				{
                            	   					total=total+(Integer.valueOf(Global.textFieldArray[x][k].getText()));
                            	   					Global.textFieldArray[x+1][k].setText(String.valueOf(total));
                            	   				}
                                	   		}
                                        }
                                        
                                        MainMenu.DisplayChart(); 
                                       // Global.textFieldArray[x][y].grabFocus();
                                       // inputErr=false;
                                        if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                        {
                                            //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                           // Global.textFieldArray[x][y+1].grabFocus();
                                             
                                        }
                                        else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                        {
                                            //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                            //Global.textFieldArray[x+1][5].grabFocus();
                                          
                                        }
                                    }
                                    else
                                    {
                                    	//inputErr=true;
                                        JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and 0");
                                         Global.textFieldArray[x][y].setText(Global.origData);
                                        Global.x=0;
                                        Global.y=0;
                                        

                                        MainMenu.DisplayChart(); 
                                        Global.textFieldArray[x][y].grabFocus();
                                        //inputErr=false;
                                    }


                                }


                            }
                            catch(Exception g)
                            {
                            	//inputErr=true;
                                 JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and 0");
                                
                                Global.textFieldArray[x][y].setText(Global.origData);
                                Global.x=0;
                                Global.y=0;
                               

                               MainMenu.DisplayChart(); 
                               Global.textFieldArray[x][y].grabFocus();
                              // inputErr=false;
                            }

                            try
                            {   
                                if(Global.textFieldArray[x][0].getText().toString().equals("irregular"))
                                {
                                    if(  (   (Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),1)==true)
                                          ||  (Global.ValidateInt(Integer.valueOf(Global.textFieldArray[x][y].getText()),-1)==true)
                                            )
                                    &&      (Integer.valueOf(Global.textFieldArray[x][y].getText())>=Global.minVal)
                                    &&      (Integer.valueOf(Global.textFieldArray[x][y].getText())<=Global.maxVal)      
                                    )


                                    {
                                    	//inputErr=true;
                                        Global.textFieldArray[x][y].setText(removeLeadingZeroes(Global.textFieldArray[x][y].getText()).toString());
                                       
                                        Global.x=x;
                                        Global.y=y;
                                        Global.textFieldArray[x][y].getText().toString();
                                         MainMenu.DisplayChart(); 
                                        // Global.textFieldArray[x][y].grabFocus();
                                        // inputErr=false;
                                         if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                        {
                                            //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                            //Global.textFieldArray[x][y+1].grabFocus();
                                             
                                        }
                                        else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                        {
                                            //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                           // Global.textFieldArray[x+1][5].grabFocus();
                                          
                                        }
                                    }
                                    else
                                    {
                                    	//inputErr=true;
                                    	JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and "+Global.maxVal+".");
                                         Global.textFieldArray[x][y].setText(Global.origData);
                                        Global.x=0;
                                       Global.y=0;
                                        

                                        MainMenu.DisplayChart(); 
                                        Global.textFieldArray[x][y].grabFocus();
                                      //  inputErr=false;
                                    }



                                }
                            }
                            catch(Exception h)
                            {
                            	//inputErr=true;
                            	JOptionPane.showMessageDialog(null,"Data must be a whole number between "+Global.minVal+" and "+Global.maxVal+".");
                                Global.textFieldArray[x][y].setText(Global.origData);
                                Global.x=0;
                                Global.y=0;
                                

                               MainMenu.DisplayChart(); 
                               Global.textFieldArray[x][y].grabFocus();
                              // inputErr=false;
                            }


                            if((Global.textFieldArray[x][0].getText().toString().equals("description"))||(Global.textFieldArray[x][0].getText().toString().equals("totals")))
                            {

                            	//inputErr=true;
                                Global.textFieldArray[x][y].setText(Global.textFieldArray[x][y].getText());
                                // UpdateTally();
                                Global.x=x;
                                 Global.y=y;
                                 Global.textFieldArray[x][y].getText().toString();
                                 MainMenu.DisplayChart();
                                // Global.textFieldArray[x][y].grabFocus();
                                // inputErr=false;
                                if(!(Global.textFieldArray[x][y+1].getText().toString().equals("-")))
                                {
                                    //Global.textFieldArray[x][y+1].setText(Global.textFieldArray[x][y+1].getText());
                                    //Global.textFieldArray[x][y+1].grabFocus();

                                }
                                else if(!(Global.textFieldArray[x+1][0].getText().toString().equals("<<CATEGORY")))
                                {
                                    //Global.textFieldArray[x+1][5].setText(Global.textFieldArray[x+1][5].getText());
                                    //Global.textFieldArray[x+1][5].grabFocus();

                                }

                            }
                            //inputErr=true;
                            //Global.textFieldArray[x][y].grabFocus();
                            //inputErr=false;
                            
                            
                            
                            
                            
                            
                            
                       /**     for (int j = 0; j < Global.getNumRows(Global.textFieldArray,0); j++) 
            				{
            					
            					for (int k = 0; k < Global.getNumCols(Global.textFieldArray); k++)
            					{
            						//if(!(Global.textFieldArray[k][j].getBackground().equals(Color.LIGHT_GRAY)))
            						if(!((Global.textFieldArray[k][j].getBackground().equals(Color.LIGHT_GRAY))
            								||(Global.textFieldArray[k][j].getBackground().equals(Color.GREEN))
            								||(Global.textFieldArray[k][j].getBackground().equals(Color.MAGENTA))))
            						{
            							Global.textFieldArray[k][j].setBackground(Color.WHITE);
            						}
            						
            					}
            				}**/
                            
                            
            				////////////////////////////////////////////////////////////////////////////////////
            				/**for (int j = 0; j < Global.getNumRows(Global.textFieldArray,0); j++) 
            				{
            					//if(!(Global.textFieldArray[x][j].getBackground().equals(Color.LIGHT_GRAY)))
            					if(!((Global.textFieldArray[x][j].getBackground().equals(Color.LIGHT_GRAY))||(Global.textFieldArray[x][j].getBackground().equals(Color.GREEN))))
								{
									Global.textFieldArray[x][j].setBackground(Color.CYAN);
								}
            					//Global.textFieldArray[x][j].setBackground(Color.CYAN);
            					for (int k = 0; k < Global.getNumCols(Global.textFieldArray); k++)
            					{
            						//if(!(Global.textFieldArray[k][y].getBackground().equals(Color.LIGHT_GRAY)))
            						if(!((Global.textFieldArray[k][y].getBackground().equals(Color.LIGHT_GRAY))||(Global.textFieldArray[k][y].getBackground().equals(Color.GREEN))))
									{
										Global.textFieldArray[k][y].setBackground(Color.CYAN);
									}
            						//Global.textFieldArray[k][y].setBackground(Color.CYAN);
            					}
            				}**/
            				
            				
            				
            				/**boolean inDebit = false;
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
            				
            				/**int lowestAmt=Integer.valueOf(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][7].getText().toString());
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
            				
 
            				
            				
            				
            				
            				//for(int j=0; j<10; j++)
                           // {
                           // 	System.out.println(Global.textFieldArray[Global.getNumCols(Global.textFieldArray)][j].getText().toString());
                           // }

                        }
                        //MainMenu.DisplayChart();
                        //Global.textFieldArray[Global.x][Global.y].grabFocus();
                    }
                }
                
                
                inputErr=false;
                

            }
        	else
        	{
            	//inputErr=false;
            }
        	//inputErr=false;
        	//System.out.println("focus lost exited");
        	//rightclick=false;
        }
        
        

    };

	
	//Global.getProrataAmount(amount, sysDate, prevSysDate, nextIntervalDate, currIntervalDate);
	public static float getProrataAmount(float amount, Date currSysDate, Date prevSysDate, Date currIntervalDate, Date prevIntervalDate)
	{
		float prorataAmount = 0;
		float diffDays = 0;
		float periodDays = 0;
		if(prevSysDate.compareTo(prevIntervalDate) < 0)
		{
			diffDays = daysDiff(currSysDate, prevIntervalDate);
			periodDays = daysDiff(currSysDate, prevSysDate);
			prorataAmount = amount * (diffDays/periodDays);
			
		}
		if((prevSysDate.compareTo(prevIntervalDate) >= 0) && (currSysDate.compareTo(currIntervalDate) <= 0))
		{
			prorataAmount = amount;
		}
		if(currSysDate.compareTo(currIntervalDate) > 0)
		{
			diffDays = daysDiff(currIntervalDate, prevSysDate);
			periodDays = daysDiff(currSysDate, prevSysDate);
			prorataAmount = amount * (diffDays/periodDays);
			
		}
		//JOptionPane.showMessageDialog(null, String.valueOf(prorataAmount));
		return prorataAmount;
	}
	
	public static float daysDiff(Date date1, Date date2)
	{
		float diff = date1.getTime() - date2.getTime();
		float diffDays = (float)(diff/(24 * 60 * 60 * 1000));
		
		return diffDays;
	}
	
	public static Date rollDate(char direction, Date date, String period, int numPeriods)
   	{
		switch (period)
		{
		
			case "daily":
			{
				Calendar c = Calendar.getInstance(); 
	    		c.setTime(date); 
	    		if(direction == 'f')
	    		{
	    			c.add(Calendar.DATE, 1*numPeriods);
	    		}
	    		if(direction == 'b')
	    		{
	    			c.add(Calendar.DATE, -1*numPeriods);
	    		}
	    		date = c.getTime();
 	        
 	        break;
			}
			case "weekly":
			{
				Calendar c = Calendar.getInstance(); 
	    		c.setTime(date); 
	    		if(direction == 'f')
	    		{
	    			c.add(Calendar.DATE, 7*numPeriods);
	    		}
	    		if(direction == 'b')
	    		{
	    			c.add(Calendar.DATE, -7*numPeriods);
	    		}
	    		date = c.getTime();
	 	        
	 	        break;
			}
	 	        
			
			case "monthly":
			{
				Calendar c = Calendar.getInstance(); 
	    		c.setTime(date);
	    		if(direction == 'f')
	    		{
	    			c.add(Calendar.MONTH, 1*numPeriods);
	    		}
	    		if(direction == 'b')
	    		{
	    			c.add(Calendar.MONTH, -1*numPeriods);
	    		}
	    		date = c.getTime();
				
	 	        break;
			}
			
			case "yearly":
			{
				Calendar c = Calendar.getInstance(); 
	    		c.setTime(date);
	    		if(direction == 'f')
	    		{
	    			c.add(Calendar.YEAR, 1*numPeriods);
	    		}
	    		if(direction == 'b')
	    		{
	    			c.add(Calendar.YEAR, -1*numPeriods);
	    		}
	    		date = c.getTime();
				
	 	        break;
			}

		}
   		
   		
   		return date;
   	}
	
	static Date ddmmyyyyToDate(String date)
	{
		Date newDate = new GregorianCalendar().getTime();
	   	try 
	   	{
           
		  newDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return newDate;
	}
	
	static String dateToddmmyyyy(Date date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate= formatter.format(date);
		return strDate;
	}

	public Global() {
		// TODO Auto-generated constructor stub
	}
        
        static int getNumCols(JTextField[][] textFieldArray)
        {
            int numCols = 0;
            
  
            
            String space = "-";
            for(int i = 0; i<textFieldArray.length; i++)
            {
                
                
                if (!(textFieldArray[i][0].getText().toString().equals(space)))
                {
                    //JOptionPane.showMessageDialog(null,textFieldArray[i][0].getText());
                    numCols = numCols + 1;
                }
            }
            //JOptionPane.showMessageDialog(null, String.valueOf(numCols));
            
            return numCols;
        }
        
        static int getNumRows(JTextField[][] textFieldArray, int x)
        {
            int numRows = 0;
            
            
            for(int i = 0; i<textFieldArray[x].length; i++)
            {
                String space = "-";
                if (!textFieldArray[x][i].getText().toString().equals(space))
                {
                    numRows = numRows + 1;
                }
            }
            
            return numRows;
        }
        
        static void DeleteTally()
                {
                    String space = "-";
                    int x = Global.getNumCols(Global.textFieldArray)-1;
                    for(int i = 0; i< Global.textFieldArray[x].length; i++)
                    {
                        Global.textFieldArray[x][i].setText(space);
                        //JOptionPane.showMessageDialog(null,"del " + x);
                        
                    }
                    Global.tallyCreated = false;
                }
        static void DeleteCol(int col)
                {
                    if(tallyCreated == true)
                    {
                       DeleteTally(); 
                    }
                    String space = "-";
                    //int x = Global.getNumRows(Global.textFieldArray,col);
                    for(int i = col; i < Global.getNumCols(Global.textFieldArray); i++)
                    {
                        for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
                            Global.textFieldArray[i][j].setText(Global.textFieldArray[i+1][j].getText().toString()); 
                        }
                        
                    }
                    for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
                        Global.textFieldArray[Global.textFieldArray.length-1][j] = null;
                        Global.textFieldArray[Global.textFieldArray.length-1][j] = new JTextField();
                        Global.textFieldArray[Global.textFieldArray.length-1][j].setText("-");
                    }
                    
                    //Global.tallyCreated = false;
                }
        
        static void MoveCol(int fromCol, int toCol)
        {
        	if((Global.textFieldArray[toCol+1][0].getText().toString().equals("description"))
        			||(Global.textFieldArray[toCol+1][0].getText().toString().equals("totals")))
        	{
        		toCol=toCol+1;
        	}
    				
            
        	if(fromCol > toCol) 
        	{
        		if((Global.textFieldArray[fromCol][0].getText().toString().equals("irregular"))
    			||((Global.textFieldArray[fromCol][0].getText().toString().equals("bills"))
				&&(Global.textFieldArray[fromCol+1][0].getText().toString().equals("totals"))))
            		
            		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////working V
            		
            		{
            			//fromCol=fromCol-1;
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				Global.tempTextFieldArray[0][j] = new JTextField();
                            Global.tempTextFieldArray[1][j] = new JTextField();
            				
                            Global.tempTextFieldArray[0][j].setText(Global.textFieldArray[fromCol][j].getText().toString()); 
                            Global.tempTextFieldArray[1][j].setText(Global.textFieldArray[fromCol+1][j].getText().toString()); 
                           
                        }
            			
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				
                            for(int x = fromCol-1; x > toCol; x--) 
                            {
                            	Global.textFieldArray[x+2][j].setText(Global.textFieldArray[x][j].getText().toString()); 
                            }
                            
                        }
            			
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				
                            Global.textFieldArray[toCol+1][j].setText(Global.tempTextFieldArray[0][j].getText().toString()); 
                            Global.textFieldArray[toCol+2][j].setText(Global.tempTextFieldArray[1][j].getText().toString()); 
                        }
            			
            		}
            		
            		
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////this part working V
            		else if((Global.textFieldArray[fromCol][0].getText().toString().equals("description")) 
            			||(Global.textFieldArray[fromCol][0].getText().toString().equals("totals")))
            		{
            			fromCol=fromCol-1;
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				Global.tempTextFieldArray[0][j] = new JTextField();
                            Global.tempTextFieldArray[1][j] = new JTextField();
            				
                            Global.tempTextFieldArray[0][j].setText(Global.textFieldArray[fromCol][j].getText().toString()); 
                            Global.tempTextFieldArray[1][j].setText(Global.textFieldArray[fromCol+1][j].getText().toString()); 
                           
                        }
            			
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				
                            for(int x = fromCol-1; x > toCol; x--) 
                            {
                            	Global.textFieldArray[x+2][j].setText(Global.textFieldArray[x][j].getText().toString()); 
                            }
                            
                        }
            			
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				
                            Global.textFieldArray[toCol+1][j].setText(Global.tempTextFieldArray[0][j].getText().toString()); 
                            Global.textFieldArray[toCol+2][j].setText(Global.tempTextFieldArray[1][j].getText().toString()); 
                        }
            			
            		}
            		
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////working V
            		else if( (Global.textFieldArray[fromCol][0].getText().toString().equals("bills"))
            				 ||(Global.textFieldArray[fromCol][0].getText().toString().equals("income")))
            		{
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				Global.tempTextFieldArray[0][j] = new JTextField();
                            Global.tempTextFieldArray[0][j].setText(Global.textFieldArray[fromCol][j].getText().toString()); 
                           
                        }
            			
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				
                            
                            for(int x=fromCol-1; x > toCol; x--) 
                            {
                            	Global.textFieldArray[x+1][j].setText(Global.textFieldArray[x][j].getText().toString());
                            	
                            }
                            
                        }
            			
            			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                        {
            				
                            Global.textFieldArray[toCol+1][j].setText(Global.tempTextFieldArray[0][j].getText().toString()); 
                            
                        }
            			
            		}
            		
            		
            		
            		
            	}
     	
        	else if(fromCol < toCol) {
        		if((Global.textFieldArray[fromCol][0].getText().toString().equals("irregular"))
        			||((Global.textFieldArray[fromCol][0].getText().toString().equals("bills"))
        					&&(Global.textFieldArray[fromCol+1][0].getText().toString().equals("totals"))))
        		
        		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////working V
        		
        		{
        			//fromCol=fromCol-1;
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				Global.tempTextFieldArray[0][j] = new JTextField();
                        Global.tempTextFieldArray[1][j] = new JTextField();
        				
                        Global.tempTextFieldArray[0][j].setText(Global.textFieldArray[fromCol][j].getText().toString()); 
                        Global.tempTextFieldArray[1][j].setText(Global.textFieldArray[fromCol+1][j].getText().toString()); 
                       
                    }
        			
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				
                        for(int x = fromCol+2; x < toCol+1; x++) 
                        {
                        	Global.textFieldArray[x-2][j].setText(Global.textFieldArray[x][j].getText().toString()); 
                        }
                        
                    }
        			
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				
                        Global.textFieldArray[toCol-1][j].setText(Global.tempTextFieldArray[0][j].getText().toString()); 
                        Global.textFieldArray[toCol][j].setText(Global.tempTextFieldArray[1][j].getText().toString()); 
                    }
        			
        		}
        		
        		
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////this part working V
        		else if((Global.textFieldArray[fromCol][0].getText().toString().equals("description")) 
        			||(Global.textFieldArray[fromCol][0].getText().toString().equals("totals")))
        		{
        			fromCol=fromCol-1;
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				Global.tempTextFieldArray[0][j] = new JTextField();
                        Global.tempTextFieldArray[1][j] = new JTextField();
        				
                        Global.tempTextFieldArray[0][j].setText(Global.textFieldArray[fromCol][j].getText().toString()); 
                        Global.tempTextFieldArray[1][j].setText(Global.textFieldArray[fromCol+1][j].getText().toString()); 
                       
                    }
        			
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				
                        for(int x = fromCol+2; x < toCol+1; x++) 
                        {
                        	Global.textFieldArray[x-2][j].setText(Global.textFieldArray[x][j].getText().toString()); 
                        }
                        
                    }
        			
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				
                        Global.textFieldArray[toCol-1][j].setText(Global.tempTextFieldArray[0][j].getText().toString()); 
                        Global.textFieldArray[toCol][j].setText(Global.tempTextFieldArray[1][j].getText().toString()); 
                    }
        			
        		}
        		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////working V
        		else if( (Global.textFieldArray[fromCol][0].getText().toString().equals("bills"))
        				 ||(Global.textFieldArray[fromCol][0].getText().toString().equals("income")))
        		{
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				Global.tempTextFieldArray[0][j] = new JTextField();
                        Global.tempTextFieldArray[0][j].setText(Global.textFieldArray[fromCol][j].getText().toString()); 
                       
                    }
        			
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				
                        
                        for(int x = fromCol+1; x < toCol+1; x++) 
                        {
                        	Global.textFieldArray[x-1][j].setText(Global.textFieldArray[x][j].getText().toString()); 
                        }
                        
                    }
        			
        			for(int j = 0; j < Global.textFieldArray[0].length; j++)
                    {
        				
                        Global.textFieldArray[toCol][j].setText(Global.tempTextFieldArray[0][j].getText().toString()); 
                        
                    }
        			
        		}
        		
        		
        		
        		
        	}
        	else if(fromCol == toCol) {
        		
        		
        		
        		
        	}
        	else if (fromCol == 0) {
        		
        		
        		
        		
        		
        	}
        	
        	
        	
        	
            
        }
        
        public static void InitCol(int col)
        {
             String space = "-";
            for(int j = 0; j < Global.textFieldArray[col].length; j++)
            {
                Global.textFieldArray[col][j] = null;
                Global.textFieldArray[col][j] = new JTextField();
                Global.textFieldArray[col][j].setText(space);
                Global.textFieldArray[col][j].setPreferredSize(new Dimension(100, 20));
            }
        }
        
        
        
        static void Init()
        {
             
            String space = "-";
                for(int i = 0 ; i < Global.textFieldArray.length ; i++)
                {
                    for(int j = 0 ; j < Global.textFieldArray[0].length ; j++)
                    {
                        Global.textFieldArray[i][j] = null;
                        Global.textFieldArray[i][j] = new JTextField();
                        Global.textFieldArray[i][j].setText(space);
                        Global.textFieldArray[i][j].setPreferredSize(new Dimension(100, 20));
                    }
                }
                Global.intervalPanelCreated=false;
                Global.tallyCreated=false;
        }
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        static boolean ValidateTitle(String title, int col)
        {
        	boolean valid = true;
        	
        	
                for(int j = 0 ; j < Global.textFieldArray.length ; j++)
                {
                    if((Global.textFieldArray[j][5].getText().toString().trim().equals(title.trim()))
                    && (!(j==col)))
                    {
                    	valid=false;
                    }
                   
                }
           
        	
        	return valid;
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////
        
        static boolean ValidateInt(int value, int indicator)
        {
            boolean result = false;
            if(indicator>0)
            {
                if(value>=0)
                {
                    result=true;
                }
            }
            if(indicator<0)
            {
                 if(value<=0)
                {
                    result=true;
                }
            }
            return result;
        }
        
         public static String FormatString(String string, int length)
    {
        
    
   
        char fill = ' ';
        String padded = "";

        String toPad = string;
        if((length - toPad.length()) > 0)
        {
            padded = toPad + new String(new char[length - toPad.length()]).replace('\0', fill);
           
        }
        else
        {
            padded = toPad;
        }
      
        StringBuilder str
            = new StringBuilder(padded);
    
       str.setLength(length);
       
       padded = str.toString();
       
       // System.out.println("After setLength() String = ."
       //                    + str.toString() + ".");
               
        //Font font = new Font("monospaced", Font.PLAIN, 12);
        //AttributedString atString= new AttributedString(padded);
        //atString.addAttribute(TextAttribute.FONT, font);
        //Graphic.drawString(atString.getIterator(),x,y);
        //padded = atString.toString();
        
    return padded;
    }
         
         public static String removeLeadingZeroes(String str) {
             String strPattern = "^0+(?!$)";
             str = str.replaceAll(strPattern, "");
             return str;
     }
         
         public static void createColumn(int index)
         {
        	for(int x=Global.getNumCols(textFieldArray); x>index-1; x--)
        	{
        		for(int y=0; y<Global.getNumRows(textFieldArray,0); y++)
        		{
        			Global.textFieldArray[x+1][y].setText(Global.textFieldArray[x][y].getText().toString());
        		}
        	}
        	InitCol(index);
         }
         
         

}
