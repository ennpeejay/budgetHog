
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author -
 * 
 * 
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class CreateModifyDatesScreen {
    
    
	
	public JPanel displayModifyDatesScreen()
	{
       JPanel mainJPanel = new JPanel();
     
       mainJPanel.setPreferredSize(new Dimension(Global.screenWidth-50,Global.screenHeight-50));
         GridBagLayout mainGrid = new GridBagLayout();

        mainJPanel.setLayout(mainGrid);
       
        GridBagConstraints gbc = new GridBagConstraints();
       

        JLabel jlblHeading = new JLabel("SELECT A REPORT ITEM TO MODIFY");
        

        

        JLabel jlblheading = new JLabel("CREATE YOUR REPORTING INTERVAL DATES");
       
        //create grouping panel for date labels
        JPanel datePanel = new JPanel();
        GridLayout dateGrid = new GridLayout(1,3);
        datePanel.setLayout(dateGrid);
        
        //create labels for date boxes
        JLabel jlbldd = new JLabel("day");
        JLabel jlblmm = new JLabel("month");
        JLabel jlblyyyy = new JLabel("year");
        
        jlbldd.setPreferredSize(new Dimension(133,20)); 
        datePanel.add(jlbldd);
        jlblmm.setPreferredSize(new Dimension(133,20)); 
        datePanel.add(jlblmm);
        jlblyyyy.setPreferredSize(new Dimension(133,20)); 
        datePanel.add(jlblyyyy);
        
       
        //create grouping panel for date comboboxes
        JPanel dateCbPanel = new JPanel();
        GridLayout dateCbGrid = new GridLayout(1,3);
        dateCbPanel.setLayout(dateCbGrid);
        
        int combo = 0;
        int substr = 0;
        

        //create comboboxes for date items
        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        final JComboBox<String> jcbdays = new JComboBox<String>(days);
        
        
        for(int i = 0; i < days.length ; i++)
        {
        	combo = Integer.valueOf(days[i]);
        	substr = Integer.valueOf(Global.textFieldArray[Global.modSelIndex][4].getText().toString().substring(0,2));
            if(combo==substr)
            {
                jcbdays.setSelectedIndex(i);
            }    
        }  
      
        String[] months = { "1","2","3","4","5","6","7","8","9","10","11","12"};
        final JComboBox<String> jcbmonths = new JComboBox<String>(months);
        
        for(int i = 0; i < months.length ; i++)
        {
        	combo = Integer.valueOf(months[i]);
        	substr = Integer.valueOf(Global.textFieldArray[Global.modSelIndex][4].getText().toString().substring(3,5));
            if(combo==substr)
            {
                jcbmonths.setSelectedIndex(i);
            }    
        }  
        
        String[] years = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
        final JComboBox<String> jcbyears = new JComboBox<String>(years);
        
        for(int i = 0; i < years.length ; i++)
        {
        	combo = Integer.valueOf(years[i]);
        	substr = Integer.valueOf(Global.textFieldArray[Global.modSelIndex][4].getText().toString().substring(6));
            if(combo==substr)
            {
                jcbyears.setSelectedIndex(i);
            }    
        }  
        
        jcbdays.setPreferredSize(new Dimension(133,20)); 
        dateCbPanel.add(jcbdays);
        jcbmonths.setPreferredSize(new Dimension(133,20)); 
        dateCbPanel.add(jcbmonths);
        jcbyears.setPreferredSize(new Dimension(133,20)); 
        dateCbPanel.add(jcbyears);
        
       
        
      //create label for report start date
        JLabel jlbldate = new JLabel("Select a date to start reporting from (this is usually your main pay date)");
        
        //create grouping panel for date labels
        JPanel datePanel2 = new JPanel();
        GridLayout dateGrid2 = new GridLayout(1,3);
        datePanel2.setLayout(dateGrid2);
        
        //create labels for date boxes
        JLabel jlbldd2 = new JLabel("day");
        JLabel jlblmm2 = new JLabel("month");
        JLabel jlblyyyy2 = new JLabel("year");
        
        jlbldd2.setPreferredSize(new Dimension(133,20)); 
        datePanel2.add(jlbldd2);
        jlblmm2.setPreferredSize(new Dimension(133,20)); 
        datePanel2.add(jlblmm2);
        jlblyyyy2.setPreferredSize(new Dimension(133,20)); 
        datePanel2.add(jlblyyyy2);
        
       
        
        //create grouping panel for date comboboxes
        JPanel dateCbPanel2 = new JPanel();
        GridLayout dateCbGrid2 = new GridLayout(1,3);
        dateCbPanel2.setLayout(dateCbGrid2);
        
        String[] days2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        final JComboBox<String> jcbdays2 = new JComboBox<String>(days2);
        
        
        for(int i = 0; i < days2.length ; i++)
        {
        	combo = Integer.valueOf(days2[i]);
        	substr = Integer.valueOf(Global.textFieldArray[Global.modSelIndex][5].getText().toString().substring(0,2));
            if(combo==substr)
            {
                jcbdays2.setSelectedIndex(i);
            }    
        }  
      
        String[] months2 = { "1","2","3","4","5","6","7","8","9","10","11","12"};
        final JComboBox<String> jcbmonths2 = new JComboBox<String>(months2);
        
        for(int i = 0; i < months2.length ; i++)
        {
        	combo = Integer.valueOf(months2[i]);
        	substr = Integer.valueOf(Global.textFieldArray[Global.modSelIndex][5].getText().toString().substring(3,5));
            if(combo==substr)
            {
                jcbmonths2.setSelectedIndex(i);
            }    
        }  
        
        String[] years2 = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
        final JComboBox<String> jcbyears2 = new JComboBox<String>(years2);
        
        for(int i = 0; i < years2.length ; i++)
        {
        	combo = Integer.valueOf(years2[i]);
        	substr = Integer.valueOf(Global.textFieldArray[Global.modSelIndex][5].getText().toString().substring(6));
            if(combo==substr)
            {
                jcbyears2.setSelectedIndex(i);
            }    
        }  
        
        jcbdays2.setPreferredSize(new Dimension(133,20)); 
        dateCbPanel2.add(jcbdays2);
        jcbmonths2.setPreferredSize(new Dimension(133,20)); 
        dateCbPanel2.add(jcbmonths2);
        jcbyears2.setPreferredSize(new Dimension(133,20)); 
        dateCbPanel2.add(jcbyears2);
        
      
        
      //create label for report start date
        JLabel jlbldate2 = new JLabel("Select a date to end reporting at");
        
        JLabel padding32 = new JLabel();
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
       
        
        //create reporting interval period combobox
        String[] periods = { "daily","weekly","monthly","yearly"};
        final JComboBox<String> jcbperiods = new JComboBox<String>(periods);
        
          for(int i = 0; i < periods.length ; i++)
            {
                //JOptionPane.showMessageDialog(null,Integer.valueOf(Global.textFieldArray[Global.modSelIndex][3].getText().toString().substring(0,2)));
                if(periods[i].equals(Global.textFieldArray[Global.modSelIndex][2].getText().toString()))
                {
                    jcbperiods.setSelectedIndex(i);
                }
                 
            }  
        
        //create label for reporting interval
        JLabel jlblperiod = new JLabel("Select what period to report on (this is usually on a weekly basis or can be set to any period such as your main income period)");
        
        JLabel padding4 = new JLabel();
        
        /////////////////////////////////
        
        JTextField jtfNumPeriod = new JTextField(Global.textFieldArray[Global.modSelIndex][3].getText().toString());
        
        JLabel jlblNumPeriod = new JLabel("enter number of periods per interval");
        
        JLabel padding8 = new JLabel();
        
        ///////////////////////////////////////
        //create submit button to create column
        JButton jbtnSubmit = new JButton("Modify");
        
      //create submit button label
        JLabel jlblSubmit = new JLabel("Enter to Modify date intervals to report on");
        

        
        gbc.gridx= 0;
        gbc.gridy=0;
        jlblHeading.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(jlblHeading,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=1;
        //gbc.gridheight=5;
        CreateModifyScreen myCreateModifyScreen = new CreateModifyScreen();
        mainJPanel.add(myCreateModifyScreen.displayCreateModifyScreen(),gbc);
        
        gbc.gridx= 0;
        gbc.gridy=2;
        //gbc.gridheight=5;
        datePanel.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(datePanel,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=3;
        //gbc.gridheight=5;
        mainJPanel.add(dateCbPanel,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=4;
        //gbc.gridheight=5;
        mainJPanel.add(jlbldate,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=5;
        JLabel lblpad1 = new JLabel(" ");
        lblpad1.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad1,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=6;
        //gbc.gridheight=5;
        datePanel2.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(datePanel2,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=7;
        //gbc.gridheight=5;
        mainJPanel.add(dateCbPanel2,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=8;
        //gbc.gridheight=5;
        mainJPanel.add(jlbldate2,gbc);
     
        gbc.gridx= 0;
        gbc.gridy=9;
        JLabel lblpad3 = new JLabel(" ");
        lblpad1.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad3,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=10;
        //gbc.gridheight=5;
        jcbperiods.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(jcbperiods,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=11;
        mainJPanel.add(jlblperiod,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=12;
        JLabel lblpad4 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad4,gbc);
        
        /////////////////////////////////////////////////
        gbc.gridx= 0;
        gbc.gridy=13;
        //gbc.gridheight=5;
        jtfNumPeriod.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(jtfNumPeriod,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=14;
        mainJPanel.add(jlblNumPeriod,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=15;
        JLabel lblpad11 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad11,gbc);
        ////////////////////////////////////////////////
        

        gbc.gridx= 0;
        gbc.gridy=16;
        jbtnSubmit.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(jbtnSubmit,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=17;
        mainJPanel.add(jlblSubmit,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=18;
        JLabel lblpad5 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad5,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=19;
        JLabel lblpad6 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad6,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=20;
        JLabel lblpad7 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad7,gbc);
        
       gbc.gridx= 0;
        gbc.gridy=21;
        JLabel lblpad8 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad8,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=22;
        JLabel lblpad9 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad9,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=23;
        JLabel lblpad10 = new JLabel(" ");
        lblpad3.setPreferredSize(new Dimension(400,20)); 
        mainJPanel.add(lblpad10,gbc); 

        ActionListener submitListener = new ActionListener() 
        {
            boolean valid;
	        @Override
	        public void actionPerformed(ActionEvent event)
	        {
                    
	        	if(event.getSource()==jbtnSubmit)
	        	{
                    boolean valid = true;
	        		int numRows=0;
	        		int amt = 0;
                   
                    
                    String dd = (jcbdays.getSelectedItem().toString());
                    String mm = (jcbmonths.getSelectedItem().toString());
                  
                    String yyyy = (jcbyears.getSelectedItem().toString());
                    
                    String strDate = dd + "/" + mm + "/" + yyyy;
                    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
                    sdfrmt.setLenient(false);
                    
                    Date dateStart = null;
                    Date dateEnd = null;
                    
                    try
                    {
                        
                        dateStart = sdfrmt.parse(strDate); 
                       
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, strDate+" is an invalid start Date");
                        valid = false;
                    }
                    
                    String dd2 = (jcbdays2.getSelectedItem().toString());
                    String mm2 = (jcbmonths2.getSelectedItem().toString());
                  
                    String yyyy2 = (jcbyears2.getSelectedItem().toString());
                    
                    String endDate2 = dd2 + "/" + mm2 + "/" + yyyy2;
                    SimpleDateFormat sdfrmt2 = new SimpleDateFormat("dd/MM/yyyy");
                    sdfrmt2.setLenient(false);
                    try
                    {
                        
                        dateEnd = sdfrmt2.parse(endDate2); 
                        //JOptionPane.showMessageDialog(frame, strDate+" is valid date format");
                        //System.out.println(strDate+" is valid date format");
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, endDate2+" is an invalid end Date");
                        valid = false;
                    }
                    
                    try
                    {
                    	int numPeriods = Integer.valueOf(jtfNumPeriod.getText().toString());
                    	if (numPeriods < 1)
                    	{
                    		JOptionPane.showMessageDialog(null, "number of Periods must be greater than 0");
                    		valid=false;
                    	}
                    	
                    	
                    }
                    catch (Exception f)
                    {
                    	valid=false;
                    	JOptionPane.showMessageDialog(null, jtfNumPeriod.getText().toString()+" is an invalid number of periods");
                    	
                    }
                    
                    
                    if(valid==true)
                    {
                    	if(dateStart.compareTo(dateEnd) >= 0)
                    	{
                    		valid=false;
                    		JOptionPane.showMessageDialog(null, "end date must be greater than start date");
                    	}
                    }

		//int numRows = Integer.valueOf(jtfNumPeriods.getText());
                    if (valid==true)
                    {
                        
                        //Global.numRows = numRows - 5;
                        int datesDate = Integer.valueOf(jcbdays.getSelectedItem().toString());
                        int datesMonth = Integer.valueOf(jcbmonths.getSelectedItem().toString());
                        int datesYear = Integer.valueOf(jcbyears.getSelectedItem().toString());
                        
                        int datesDate2 = Integer.valueOf(jcbdays2.getSelectedItem().toString());
                        int datesMonth2 = Integer.valueOf(jcbmonths2.getSelectedItem().toString());
                        int datesYear2 = Integer.valueOf(jcbyears2.getSelectedItem().toString());
                        
                        String datesFreq = jcbperiods.getSelectedItem().toString();
                        int dateNumPeriods = Integer.valueOf(jtfNumPeriod.getText().toString());
                        
                        if(Global.tallyCreated == true)
                        {
                            Global.DeleteTally();
                        }

                        
                       int date=0;
                       int month=0;
                       int year=0;
                       
                       int date2=0;
                       int month2=0;
                       int year2=0;
                       int numPeriods = 0;
                       int j=0;
                       String freq="";
                        //GenColumn myColumn = new GenColumn("dates",i,numRows,date,month,year,freq, amt, "report intervals");
                        //GenColumn myColumn = null;
                        String details="";
                        boolean isSum=false;
                        String title="";
                        
                       int counter = 0;
                        //while(j < Global.getNumCols(Global.textFieldArray))
                        int numCols=Global.getNumCols(Global.textFieldArray)-1;
                        for(j = 0 ; j < numCols+1; j++)
                        //while(j<numCols)
                        {
                        	counter = counter + 1;
                        	//System.out.println("numCols "+numCols+" loop counter " +counter+" j "+j);
                        	
                        	
                        	
                            date=Integer.valueOf(Global.textFieldArray[j][4].getText().toString().substring(0,2));
                            month=Integer.valueOf(Global.textFieldArray[j][4].getText().toString().substring(3,5));
                            year=Integer.valueOf(Global.textFieldArray[j][4].getText().toString().substring(6,10));
                            
                            date2=Integer.valueOf(Global.textFieldArray[j][5].getText().toString().substring(0,2));
                            month2=Integer.valueOf(Global.textFieldArray[j][5].getText().toString().substring(3,5));
                            year2=Integer.valueOf(Global.textFieldArray[j][5].getText().toString().substring(6,10));
                            
                            freq=String.valueOf(Global.textFieldArray[j][2].getText().toString());
                            
                            numPeriods = Integer.valueOf(Global.textFieldArray[j][3].getText().toString());
                            
                            title=Global.textFieldArray[j][0].getText().toString();
                            details=Global.textFieldArray[j][6].getText().toString();
                            
                            //System.out.println("numCols "+numCols+" loop counter " +counter+" j "+j+" "+details);
                            
                             if((Global.textFieldArray[j][0].getText().toString().equals("income"))
                             ||(Global.textFieldArray[j][0].getText().toString().equals("bills")))
                            {
                                amt=Integer.valueOf(Global.textFieldArray[j][1].getText().toString());
                            }
                             else
                             {
                                 amt=0;
                             }
                           
                            //details=Global.textFieldArray[j][6].getText().toString();
                            
                            
                            
                            
                            
                            if(Global.textFieldArray[j][0].getText().toString().equals("dates"))
                            	
                            {
                            	//System.out.println(details+" "+j);
                            	//MainMenu.DisplayChart(); 
                            	//JOptionPane.showMessageDialog(null, "contine");
                            	//System.out.println(Global.textFieldArray[j][6].getText().toString());
                                SetTempDatesArray();
                               Global.InitCol(j);
                                Global.intervalPanelCreated=false;
                                GenColumn myColumn = new GenColumn("dates",j,datesDate,datesMonth,datesYear,datesDate2,datesMonth2,datesYear2,datesFreq,dateNumPeriods, numRows, details,isSum);
                              //// j=j+1;
                               // System.out.println(details+" "+j);
                            }
                            else if(Global.textFieldArray[j][0].getText().toString().equals("income"))
                            {
                            	//System.out.println(details+" "+j);
                            	//JOptionPane.showMessageDialog(null, "contine");
                            	//System.out.println(Global.textFieldArray[j][6].getText().toString());
                               Global.InitCol(j);
                                GenColumn myColumn = new GenColumn("income",j,date,month,year,date2,month2,year2,freq,numPeriods, amt, details,isSum);
                               //j=j+1;
                               // System.out.println(details+" "+j);
                            }
                            else if((Global.textFieldArray[j][0].getText().toString().equals("bills"))
                        	&&(Global.textFieldArray[j+1][0].getText().toString().equals("totals")))
                            {
                            	//System.out.println(details+" "+j);
                            	//JOptionPane.showMessageDialog(null, "contine");
                            
                            	//System.out.println(Global.textFieldArray[j][6].getText().toString());
                                
                               Global.DeleteCol(j+1);
                               Global.InitCol(j);
                               isSum=true;
                                	
                                	
                        		
                                GenColumn myColumn = new GenColumn("bills",j,date,month,year,date2,month2,year2,freq,numPeriods, amt, details,isSum);
                                
                                //Global.DeleteCol(j+2);
                               
                                //isSum=false;
                               //j=j+2;
                                j=j+1;
                                //System.out.println(details+" "+j);
                                isSum=false;
                            }
                            else if((Global.textFieldArray[j][0].getText().toString().equals("bills"))
                        	&&(!(Global.textFieldArray[j+1][0].getText().toString().equals("totals"))))
                                
                            {
                            	//System.out.println(details+" "+j);
                            	//JOptionPane.showMessageDialog(null, "contine");
                            	//System.out.println(Global.textFieldArray[j][6].getText().toString());
                            	isSum=false;
                                Global.InitCol(j);
                               
                                GenColumn myColumn = new GenColumn("bills",j,date,month,year,date2,month2,year2,freq,numPeriods, amt, details,isSum);
                                //j=j+1;
                                //System.out.println(details+" "+j);
                                //Global.DeleteCol(j);
                            }
                            else if(Global.textFieldArray[j][0].getText().toString().equals("irregular"))
                            {
                                
                            	//System.out.println(details+" "+j); 
                            	//JOptionPane.showMessageDialog(null, "contine");
                            	//System.out.println(Global.textFieldArray[j][6].getText().toString());
                                SetTempIrregularArray(j);
                                SetTempDetailsArray(j+1);
                               Global.InitCol(j);
                               Global.InitCol(j+1);
                                ModifyIrregularDetails(j);
                                j=j+1;
                                //System.out.println(details+" "+j);
                               
                                
                            }
                           isSum=false;
                            //JOptionPane.showMessageDialog(null, details);
                           
                           
                        }
                        
                        
                      
                      //MainMenu.DisplayChart(); 
                        CreateModifyScreen.listItemSelected = false;
                        MainMenu.DisplayModifyItemScreen();
                    }
                    
                    
                    //CreateModifyScreen.listItemSelected = false;
                                
	        	}
	        }
        };
          
        jbtnSubmit.addActionListener(submitListener);
        
        return mainJPanel;
	}
        
    public void SetTempDatesArray()
    {
         String space = "-";
        for(int j = 0; j < Global.tempDatesArray.length; j++)
        {
            Global.tempDatesArray[j] = null;
            Global.tempDatesArray[j] = new JTextField();
            Global.tempDatesArray[j].setText(space);
        }
        
        for(int i=0; i<Global.getNumRows(Global.textFieldArray, 0); i++)
        {
            Global.tempDatesArray[i].setText(Global.textFieldArray[0][i].getText().toString());
        }
    }
    
    public void SetTempIrregularArray(int index)
    {
        String space = "-";
        for(int j = 0; j < Global.tempIrregularArray.length; j++)
        {
            Global.tempIrregularArray[j] = null;
            Global.tempIrregularArray[j] = new JTextField();
            Global.tempIrregularArray[j].setText(space);
         
        }
        //for(int i=0; i<Global.getNumRows(Global.textFieldArray, index); i++)
    	for(int i=0; i<Global.getNumRows(Global.textFieldArray, 0)-1; i++)	
        {
            Global.tempIrregularArray[i].setText(Global.textFieldArray[index][i].getText().toString());
        }
    }
    
    public void SetTempDetailsArray(int index)
    {
        String space = "-";
        for(int j = 0; j < Global.tempDetailsArray.length; j++)
        {
            Global.tempDetailsArray[j] = null;
            Global.tempDetailsArray[j] = new JTextField();
            Global.tempDetailsArray[j].setText(space);
         
        }
        //for(int i=0; i<Global.getNumRows(Global.textFieldArray, index); i++)
        	for(int i=0; i<Global.getNumRows(Global.textFieldArray, 0); i++)	
        {
            Global.tempDetailsArray[i].setText(Global.textFieldArray[index][i].getText().toString());
        }
    }
    
    public void ModifyIrregularDetails(int irregColIndex)
    {
        Global.textFieldArray[irregColIndex][0].setText(Global.tempIrregularArray[0].getText().toString());
        Global.textFieldArray[irregColIndex][1].setText(Global.tempIrregularArray[1].getText().toString());
        Global.textFieldArray[irregColIndex][2].setText(Global.tempIrregularArray[2].getText().toString());
        Global.textFieldArray[irregColIndex][3].setText(Global.tempIrregularArray[3].getText().toString());
        Global.textFieldArray[irregColIndex][4].setText(Global.tempIrregularArray[4].getText().toString());
        Global.textFieldArray[irregColIndex][5].setText(Global.tempIrregularArray[5].getText().toString());
        Global.textFieldArray[irregColIndex][6].setText(Global.tempIrregularArray[6].getText().toString());
        
        Global.textFieldArray[irregColIndex+1][0].setText(Global.tempDetailsArray[0].getText().toString());
        Global.textFieldArray[irregColIndex+1][1].setText(Global.tempDetailsArray[1].getText().toString());
        Global.textFieldArray[irregColIndex+1][2].setText(Global.tempDetailsArray[2].getText().toString());
        Global.textFieldArray[irregColIndex+1][3].setText(Global.tempDetailsArray[3].getText().toString());
        Global.textFieldArray[irregColIndex+1][4].setText(Global.tempDetailsArray[4].getText().toString());
        Global.textFieldArray[irregColIndex+1][5].setText(Global.tempDetailsArray[5].getText().toString());
        Global.textFieldArray[irregColIndex+1][6].setText(Global.tempDetailsArray[6].getText().toString());
        
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
        sdfrmt.setLenient(false);
        Date currDate = null;
        Date nextDate = null;
        Date irregDate = null;
        int amt = 0;
        int irregAmt = 0;
        int j = 0;
        String detailDescn = "";
        boolean validDates=false;
        //String space = "-";
        for(int i=7; i<Global.getNumRows(Global.textFieldArray,0); i++)
        {
        	
            for(j=7; j<Global.tempDatesArray.length; j++)
            {
            	
                
                try
                {
                    currDate = sdfrmt.parse(Global.textFieldArray[0][i].getText().toString());
                   
                	nextDate = sdfrmt.parse(Global.textFieldArray[0][i+1].getText().toString());
                    
                    irregDate = sdfrmt.parse(Global.tempDatesArray[j].getText().toString());
                    
                    amt = Integer.valueOf(Global.tempIrregularArray[j].getText().toString());
                    
                    validDates=true;
                }
                catch(Exception e)
                {
                	validDates=false;
                }

                if((irregDate.compareTo(currDate) >= 0)
                &&(irregDate.compareTo(nextDate) < 0)
                &&(validDates==true))
                {
                	
                    irregAmt = irregAmt + amt;
                    if(Integer.valueOf(Global.tempIrregularArray[j].getText().toString())>0)
                    {
                        detailDescn = Global.tempDetailsArray[j].getText().toString();
                    }
                }
	              
            }
            Global.textFieldArray[irregColIndex][i].setText(String.valueOf(irregAmt));
            irregAmt=0;
            //Global.textFieldArray[irregColIndex][i].addKeyListener(Global.tally);
            //Global.textFieldArray[irregColIndex][i].addFocusListener(Global.getData2);
            Global.textFieldArray[irregColIndex+1][i].setText(detailDescn);
            detailDescn="";
        	
            
        }
    }
    
}

