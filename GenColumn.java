


	import java.awt.event.*;
	import java.lang.*;
    import java.util.*;
    import java.text.*;
	import java.awt.*;
	import javax.swing.*;

	public class GenColumn 
	{
		private String category;
		//private int numRows;
		private int index;
		private int day;
		private int mth;
		private int yr;
		private int day2;
		private int mth2;
		private int yr2;
		private String period;
		private int amount;
		private String title;
		private int numPeriod;
		private boolean isSum;
		
		public GenColumn(String cat, int indx, int dd, int mm, int yyyy, int dd2, int mm2, int yyyy2, String perd, int numPerd, int amt, String titl, boolean checked) 
		{
			category = cat;
			//numRows = rows;
			index = indx;
			day = dd;
			mth = mm - 1;
			yr = yyyy;
			day2 = dd2;
			mth2 = mm2 - 1;
			yr2 = yyyy2;
			period = perd;
			numPeriod = numPerd;
			amount = amt;
			title = titl;
			isSum = checked;
                        
                        
			
			switch (category)
			{
				case "dates":
				{   
                    if(Global.getNumCols(Global.textFieldArray) > (Global.maxCols - 1))
                    {
                        JOptionPane.showMessageDialog(null, "Unable to create Item. Maximum number of report columns that can be created is " + Global.maxCols);
                    }
                    else
                    {
                                    
						if (Global.intervalPanelCreated)
						{
	                                          
							JOptionPane.showMessageDialog(null, "Unable to create another REPORTING DATE INTERVAL column. Only one REPOTING DATE INTERVAL column can be created. Delete existing one if you wish to recreate it.");
							break;
						}
						else
						{
							GenIntervalPanel();
							Global.intervalPanelCreated = true;
	                                               
							
			        		//Global.globalPanelArrayList.add(newPanel);
							//JOptionPane.showMessageDialog(null, "Interval dates column created.");
							break;
						}
                    }
				}
				case "income":
				{
                    if(Global.getNumCols(Global.textFieldArray) > (Global.maxCols - 1))
                    {
                        JOptionPane.showMessageDialog(null, "Unable to create Item. Maximum number of report columns that can be created is " + Global.maxCols);
                    }
                    else
                    {
						if (Global.intervalPanelCreated)
						{
							GenPaymentPanel();
							//JOptionPane.showMessageDialog(null, "Income column created.");
							break;
						}
						else
						{
							
							JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE INTERVAL column first.");
							break;
						}
                    }
					
				}
				case "bills":
				{
                    if(Global.getNumCols(Global.textFieldArray) > (Global.maxCols - 1))
                    {
                        JOptionPane.showMessageDialog(null, "Unable to create Item. Maximum number of report columns that can be created is " + Global.maxCols);
                    }
                    else
                    {
						if (Global.intervalPanelCreated)
						{
							GenPaymentPanel();
							//JOptionPane.showMessageDialog(null, "bills column created.");
							break;
						}
						else
						{
							
							JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE INTERVAL column first.");
							break;
						}
                    }
				}
                case "irregular":
				{
                    if(Global.getNumCols(Global.textFieldArray) > (Global.maxCols - 2))
                    {
                        JOptionPane.showMessageDialog(null, "Unable to create Item. Maximum number of report columns that can be created is " + Global.maxCols);
                    }
                    else
                    {
						if (Global.intervalPanelCreated)
						{
							GenIrregularPanel();
							//JOptionPane.showMessageDialog(null, "irregular column created.");
							break;
						}
						else
						{
							
							JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE INTERVAL column first.");
							break;
						}
                    }
					
				}
				case "tally":
				{
					if (Global.intervalPanelCreated)
					{
						GenTallyPanel();
						//JOptionPane.showMessageDialog(null, "tally column created.");
						break;
					}
					else
					{
						
						JOptionPane.showMessageDialog(null, "You must create a REPORTING DATE INTERVAL column first.");
						break;
					}
					
				}
					
			}
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		public void GenIntervalPanel() 
		{
			
			Date firstDate1 = new GregorianCalendar(yr, mth, day).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate= formatter.format(firstDate1);
			
			Date endDate1 = new GregorianCalendar(yr2, mth2, day2).getTime();
			String endDate= formatter.format(endDate1);
			

		   
//set date column header cells data		
		   	
		   	
		   	
		   	Global.textFieldArray[index][0] = new JTextField(category);
		   	Global.textFieldArray[index][0].setPreferredSize(new Dimension(100, 20));
		   	//Global.textFieldArray[index][1] = new JTextField(String.valueOf(index));
		   	//Global.textFieldArray[index][1].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][1] = new JTextField(String.valueOf("test"));
		   	Global.textFieldArray[index][1].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][2] = new JTextField(period);
		   	Global.textFieldArray[index][2].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][3] = new JTextField(String.valueOf(numPeriod));
		   	Global.textFieldArray[index][3].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][4] = new JTextField(strDate);
		   	Global.textFieldArray[index][4].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][5] = new JTextField(endDate);
		   	Global.textFieldArray[index][5].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][6] = new JTextField(title);
		   	Global.textFieldArray[index][6].setPreferredSize(new Dimension(100, 20));
		   	
		   	
		   	
		   	
		   	
//set initial cell of dates column with user start date			   	
		   	//Calendar a = Calendar.getInstance(); 
    		//a.setTime(firstDate1); 
    		
    		//firstDate1 = a.getTime();  
    		
    		String displayDate = formatter.format(firstDate1);
    		
    		Global.textFieldArray[index][7] = new JTextField(strDate);
    		Global.textFieldArray[index][7].setPreferredSize(new Dimension(100, 20));
 	        //Global.textFieldArray[index][6].addActionListener(listener);
 	        
 	        
 	        
		   	
		   	
//populate cells of date column with incremented dates			 
	    	int j =8;
    		while((firstDate1.compareTo(endDate1) < 0)
    			&&(j<Global.maxRows))
	    	{	
    			
    			
    			firstDate1 = Global.rollDate('f', firstDate1, period, numPeriod);
    			displayDate = formatter.format(firstDate1);
    			Global.textFieldArray[index][j] = new JTextField(displayDate);
	    		
	    		
	
	    		j=j+1;
	    		
	 	    }
            Global.intervalPanelCreated=true;
            //JOptionPane.showMessageDialog(null, "j=" + j);
         
		}
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		public void GenPaymentPanel() 
		{
		
                    if(Global.tallyCreated == true)
                    {
                        Global.DeleteTally();
                    }
			
			
			
		
			Date startDate1 = new GregorianCalendar(yr, mth, day).getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate= formatter.format(startDate1);
			
			Date endDate1 = new GregorianCalendar(yr2, mth2, day2).getTime();
			String endDate= formatter.format(endDate1);
			
			
			if(isSum==true)
   			{
   				Global.createColumn(index+1);
   				
   			}
			
		  

		 
		   
//set date column header cells data		
		   	
		   	
		   	Global.textFieldArray[index][0] = new JTextField(category);
		   	Global.textFieldArray[index][0].setPreferredSize(new Dimension(100, 20));
		   	//Global.textFieldArray[index][1] = new JTextField(String.valueOf(index));
		   	//Global.textFieldArray[index][1].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][1] = new JTextField(String.valueOf(amount));
		   	Global.textFieldArray[index][1].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][2] = new JTextField(period);
		   	Global.textFieldArray[index][2].setPreferredSize(new Dimension(100, 20));
		  
		   	Global.textFieldArray[index][3] = new JTextField(String.valueOf(numPeriod));
		   	
		   	Global.textFieldArray[index][3].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][4] = new JTextField(strDate);
		   	Global.textFieldArray[index][4].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][5] = new JTextField(endDate);
		   	Global.textFieldArray[index][5].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[index][6] = new JTextField(title);
		   	Global.textFieldArray[index][6].setPreferredSize(new Dimension(100, 20));
		 
		   	
		   	Date intervalStartDate = Global.ddmmyyyyToDate(Global.textFieldArray[0][4].getText().toString());
		   
		   	Date sysDate = startDate1;
		   	
		   
	   		while(sysDate.compareTo(intervalStartDate) < 0)
	   		{
	   			sysDate = Global.rollDate('f',sysDate, period, numPeriod);
	   		}
		   
		   	int numCols = Global.getNumCols(Global.textFieldArray);
            int numRows = Global.getNumRows(Global.textFieldArray, 0);
		   	
		   	Date prevSysDate = Global.rollDate('b',sysDate,period, numPeriod);
		   	float amountTl = 0;
		   	
		   	Date currIntervalDate = null;
   			
   			Date nextIntervalDate = null;
   			
   			int total=0;

		   	
	   		for(int i = 7; i < numRows ; i++)
	   		{
	   			
	   			
	   			
	   			currIntervalDate = Global.ddmmyyyyToDate(Global.textFieldArray[0][i].getText().toString());
	   			
	   			if(!(Global.textFieldArray[0][i+1].getText().toString().equals(Global.space)))
	   			{
	   				nextIntervalDate = Global.ddmmyyyyToDate(Global.textFieldArray[0][i+1].getText().toString());
	   			}
	   			
	   		
	   			/**
	   			System.out.println("sysDate:"+formatter.format(sysDate)+">="+"currIntervalDate:"+formatter.format(currIntervalDate));
	   			System.out.println("sysDate:"+formatter.format(sysDate)+"<"+"nextIntervalDate:"+formatter.format(nextIntervalDate));
                System.out.println("startDate1:"+formatter.format(startDate1)+"<="+"currIntervalDate:"+formatter.format(currIntervalDate));
                System.out.println("endDate1:"+formatter.format(endDate1)+">="+"currIntervalDate:"+formatter.format(currIntervalDate));
               **/
                
               
                
                
	   			if((sysDate.compareTo(currIntervalDate) >= 0) 
				&& (sysDate.compareTo(nextIntervalDate) < 0) 
				&& (startDate1.compareTo(nextIntervalDate) <= 0)
				&& (endDate1.compareTo(currIntervalDate) >= 0))
	   			{
	   				
                    while(nextIntervalDate.compareTo(sysDate)>0)
                    {

                            amountTl = amountTl + Global.getProrataAmount(amount, sysDate, prevSysDate, nextIntervalDate, currIntervalDate);

                            prevSysDate = sysDate;
                            sysDate = Global.rollDate('f',sysDate,period,numPeriod);

                    }
                    if((Global.daysDiff(nextIntervalDate, currIntervalDate)) > (Global.daysDiff(Global.rollDate('f', sysDate, period, numPeriod), sysDate)))
                    {
                            amountTl = amountTl + Global.getProrataAmount(amount, sysDate, prevSysDate, nextIntervalDate, currIntervalDate);
                    }
                    else
                    {
                            amountTl = amount;
                    }

                    if(category=="bills")
                    {
                            amountTl = amountTl * -1;
                    }
                    int textAmount = (int) Math.ceil(amountTl);
                   
                    Global.textFieldArray[index][i] = new JTextField(String.valueOf(textAmount));

	   			}
                else
                {
                    Global.textFieldArray[index][i] = new JTextField(String.valueOf(0));
                    while(nextIntervalDate.compareTo(sysDate)>0)
                    {

                            //amountTl = amountTl + Global.getProrataAmount(amount, sysDate, prevSysDate, nextIntervalDate, currIntervalDate);

                            prevSysDate = sysDate;
                            sysDate = Global.rollDate('f',sysDate,period, numPeriod);

                    }
                }
	   			
                                
	   			
	   			Global.textFieldArray[index][i].setPreferredSize(new Dimension(100, 20));
                Global.textFieldArray[index][i].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
                //Global.textFieldArray[index][i].addKeyListener(Global.tally);
               
                //Global.textFieldArray[index][i].addFocusListener(Global.getData2);
                
	   			
	   			amountTl = 0;
	   			
	   			//Global.textFieldArray[index+1][0].setText("totals");
	   			//Global.textFieldArray[index+1][6].setText(title);
	   			
	   			
	   			
	   			
	   			
	   			
	   			if(isSum==true)
	   			{
	   				
	   				
	   				
	   				Global.textFieldArray[index+1][0] = new JTextField("totals");
				   	Global.textFieldArray[index+1][0].setPreferredSize(new Dimension(100, 20));
				   	//Global.textFieldArray[index][1] = new JTextField(String.valueOf(index));
				   	//Global.textFieldArray[index][1].setPreferredSize(new Dimension(100, 20));
				   	//Global.textFieldArray[index][1] = new JTextField(String.valueOf(amount));
				   	Global.textFieldArray[index+1][1].setPreferredSize(new Dimension(100, 20));
				   	Global.textFieldArray[index+1][2] = new JTextField(period);
				   	Global.textFieldArray[index+1][2].setPreferredSize(new Dimension(100, 20));
				  
				   	Global.textFieldArray[index+1][3] = new JTextField(String.valueOf(numPeriod));
				   	
				   	Global.textFieldArray[index+1][3].setPreferredSize(new Dimension(100, 20));
				   	Global.textFieldArray[index+1][4] = new JTextField(strDate);
				   	Global.textFieldArray[index+1][4].setPreferredSize(new Dimension(100, 20));
				   	Global.textFieldArray[index+1][5] = new JTextField(endDate);
				   	Global.textFieldArray[index+1][5].setPreferredSize(new Dimension(100, 20));
				   	Global.textFieldArray[index+1][6] = new JTextField(title);
				   	Global.textFieldArray[index+1][6].setPreferredSize(new Dimension(100, 20));
		   			
	   				if(i==7)
		   			{
		   				total=Integer.valueOf(Global.textFieldArray[index][i].getText());
		   				Global.textFieldArray[index+1][i].setText(Global.textFieldArray[index][i].getText().toString());
		   			}
	   				if(i>7)
	   				{
	   					total=total+(Integer.valueOf(Global.textFieldArray[index][i].getText()));
	   					Global.textFieldArray[index+1][i].setText(String.valueOf(total));
	   				}
	   				Global.textFieldArray[index+1][i].removeMouseListener(Global.rightClick);
	   			}
	   			
                                
            	Global.tallyCreated = false;
	   			
   			}
	   		
			if((Global.textFieldArray[index+1][0].getText().toString().equals("totals"))
				&&(isSum==false))
			{
				Global.DeleteCol(index+1); 
			}
   			
                      
		}
                
                public void GenIrregularPanel()
                {
                	int numRows = Global.getNumRows(Global.textFieldArray, 0);
                	
                    Global.textFieldArray[index][0] = new JTextField(category);
                    Global.textFieldArray[index][0].setPreferredSize(new Dimension(100, 20));
                   
                    Global.textFieldArray[index][1] = new JTextField("VARIOUS");
                    Global.textFieldArray[index][1].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index][2] = new JTextField(Global.textFieldArray[0][2].getText().toString());
                    Global.textFieldArray[index][2].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index][3] = new JTextField(Global.textFieldArray[0][3].getText().toString());
                    Global.textFieldArray[index][3].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index][4] = new JTextField(Global.textFieldArray[0][4].getText().toString());
                    Global.textFieldArray[index][4].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index][5] = new JTextField(Global.textFieldArray[0][5].getText().toString());
                    Global.textFieldArray[index][5].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index][6] = new JTextField(title);
                    Global.textFieldArray[index][6].setPreferredSize(new Dimension(100, 20));
                    
                     Global.textFieldArray[index+1][0] = new JTextField("description");
                    Global.textFieldArray[index+1][0].setPreferredSize(new Dimension(100, 20));
                   
                    Global.textFieldArray[index+1][1] = new JTextField("VARIOUS");
                    Global.textFieldArray[index+1][1].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index+1][2] = new JTextField(Global.textFieldArray[0][2].getText().toString());
                    Global.textFieldArray[index+1][2].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index+1][3] = new JTextField(Global.textFieldArray[0][3].getText().toString());
                    Global.textFieldArray[index+1][3].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index+1][4] = new JTextField(Global.textFieldArray[0][4].getText().toString());
                    Global.textFieldArray[index+1][4].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index+1][5] = new JTextField(Global.textFieldArray[0][5].getText().toString());
                    Global.textFieldArray[index+1][5].setPreferredSize(new Dimension(100, 20));
                    Global.textFieldArray[index+1][6] = new JTextField(title);
                    Global.textFieldArray[index+1][6].setPreferredSize(new Dimension(100, 20));
                    
                    for(int i = 7; i < numRows ; i++)
                    {
                        Global.textFieldArray[index][i] = new JTextField(String.valueOf(0));
                        Global.textFieldArray[index+1][i] = new JTextField("");
                        
                        Global.textFieldArray[index][i].setPreferredSize(new Dimension(100, 20));
                        Global.textFieldArray[index+1][i].setPreferredSize(new Dimension(100, 20));
                        //Global.textFieldArray[index][i].addFocusListener(Global.getData2);
                        //Global.textFieldArray[index+1][i].addFocusListener(Global.getData2);
                        Global.textFieldArray[index][i].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
                        Global.textFieldArray[index][i].addKeyListener(Global.tally);
                        Global.textFieldArray[index+1][i].addKeyListener(Global.tally);
                        //Global.textFieldArray[index][i].addFocusListener(Global.getData2);
                        //Global.textFieldArray[index+1][i].addFocusListener(Global.getData2);
                        
                        Global.textFieldArray[index+1][i].setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
                        
                        
                        //Global.textFieldArray[index][i].addKeyListener(Global.tally);

                        Global.tallyCreated = false;
                    }
                }
                
               
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
		public void GenTallyPanel() 
		{
            if(Global.tallyCreated == true)
            {
                Global.DeleteTally();
            }
	
            int numCols = Global.getNumCols(Global.textFieldArray);
            int numRows = Global.getNumRows(Global.textFieldArray, 0);
            //JOptionPane.showMessageDialog(null, "numrows="+numRows);
                    
			//GridLayout textFieldGrid = new GridLayout(numRows,1);
			
		   	Global.textFieldArray[numCols][0] = new JTextField("<<Category");
		   	Global.textFieldArray[numCols][0].setPreferredSize(new Dimension(100, 20));
		   	
		   	Global.textFieldArray[numCols][1] = new JTextField("<<Amount");
		   	Global.textFieldArray[numCols][1].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[numCols][2] = new JTextField("<<Fequency");
		   	Global.textFieldArray[numCols][2].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[numCols][3] = new JTextField("<<Fequency");
		   	Global.textFieldArray[numCols][3].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[numCols][4] = new JTextField("<<Start");
		   	Global.textFieldArray[numCols][4].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[numCols][5] = new JTextField("<<End");
		   	Global.textFieldArray[numCols][5].setPreferredSize(new Dimension(100, 20));
		   	Global.textFieldArray[numCols][6] = new JTextField("Totals");
		   	Global.textFieldArray[numCols][6].setPreferredSize(new Dimension(100, 20));
		   	
		   	
		 
		   	
		   	
		  
		   	int amountTl = 0;
	   		for(int i = 7; i < numRows ; i++)//rows
	   		{
	   			//amountTl = 0;
	   			for(int j = 1; j < numCols; j++)//columns
	   			{
                    if((!(Global.textFieldArray[j][0].getText().toString().equals("description")))&&
                    		(!(Global.textFieldArray[j][0].getText().toString().equals("totals"))))
                      
                    {
                    	amountTl = amountTl + Integer.valueOf(Global.textFieldArray[j][i].getText());
	
                    }
	   			}
                  
	   			Global.textFieldArray[numCols][i].setText(String.valueOf(amountTl));
	   			if(amountTl < 0)
	   			{
	   				Global.textFieldArray[numCols][i].setBackground(Color.YELLOW);
	   			}
	   			
	   			
	   			Global.textFieldArray[numCols][i].setPreferredSize(new Dimension(100, 20));
	   			//if (amountTl < 1)
	   			//{
	   			//	Global.textFieldArray[numCols][i].setBackground(Color.YELLOW);
	   			//}
              
   			}
            Global.tallyCreated = true;
            
            for(int x=0; x<Global.textFieldArray.length;x++)
            {
            	for (int y=0; y<Global.textFieldArray[0].length;y++)
            	{
            		Global.textFieldArray[x][y].setEditable(true);
            		Global.textFieldArray[x][y].removeKeyListener(Global.tally);
					//Global.textFieldArray[p][n].addKeyListener(Global.tally);
					Global.textFieldArray[x][y].removeFocusListener(Global.getData2);
					//Global.textFieldArray[p][n].addFocusListener(Global.getData2);
            	}
            }
            
            for (int k = 0; k < 7; k++) 
			{
				for (int l = 0; l < Global.getNumCols(Global.textFieldArray); l++)
				{
					Global.textFieldArray[l][k].setEditable(false);
				}
			}
            for (int m = 0; m < Global.getNumRows(Global.textFieldArray,0); m++)
			{
				Global.textFieldArray[0][m].setEditable(false);
				Global.textFieldArray[Global.getNumCols(Global.textFieldArray)][m].setEditable(false);
				
			}
            for (int m = 7; m < Global.getNumRows(Global.textFieldArray,0); m++)
			{
				Global.textFieldArray[Global.getNumCols(Global.textFieldArray)-1][m].setEditable(false);
				
				
			}
            
            for (int n = 7; n < Global.getNumRows(Global.textFieldArray, 0); n++) 
			{
				for (int p = 1; p < Global.getNumCols(Global.textFieldArray)-1; p++)
				{
					Global.textFieldArray[p][n].removeKeyListener(Global.tally);
					Global.textFieldArray[p][n].addKeyListener(Global.tally);
					Global.textFieldArray[p][n].removeFocusListener(Global.getData2);
					Global.textFieldArray[p][n].addFocusListener(Global.getData2);
					
					if(Global.textFieldArray[p][0].getText().toString().equals("totals"))
					{
						Global.textFieldArray[p][n].setEditable(false);
					}
					
					//Global.textFieldArray[p][n].addMouseListener(Global.rightClick);
					
					//Global.textFieldArray[irregColIndex][i].addKeyListener(Global.tally);
		            //Global.textFieldArray[irregColIndex][i].addFocusListener(Global.getData2);
					//529: Global.textFieldArray[i][j].addFocusListener(Global.getData2);  
				}
			}
            
            for (int q = 0; q < Global.textFieldArray.length - 1; q++) 
			{
				for (int r = 0; r < Global.textFieldArray[0].length -1; r++)
				{
					Global.textFieldArray[q][r].setPreferredSize(new Dimension(Global.cellWidth,Global.cellHeight)); 
					Global.textFieldArray[q][r].setFont(new Font("Serif",Font.PLAIN,Global.cellFontSize));
					
					
					//System.out.println(Global.textFieldArray[q][0].getText().toString());
					if(Global.textFieldArray[q][0].getText().toString().equals("description"))
					{
						//System.out.println(Global.textFieldArray[q][0].getText().toString());
						Global.textFieldArray[q][r].setPreferredSize(new Dimension(Global.irregularDescriptionCellWidth,Global.cellHeight)); 
					}
				}
			}
            
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
	   		
		}
			
	}





