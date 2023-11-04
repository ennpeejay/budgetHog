
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
public class CreateModifyIncomeScreen {
    
    
	
	public JPanel displayModifyIncomeScreen()
	{
		   JPanel mainJPanel = new JPanel();
	          // mainJPanel.setLayout(null);
	            mainJPanel.setPreferredSize(new Dimension(Global.screenWidth-50,Global.screenHeight-50));
	             GridBagLayout mainGrid = new GridBagLayout();

	            mainJPanel.setLayout(mainGrid);
	            
	            GridBagConstraints gbc = new GridBagConstraints();
	           
	         /////////////////////////////////////////////////////////////////////////////////////////   
	           // JPanel deleteItemScreen = new JPanel();
	           
	           // GridLayout deleteGrid = new GridLayout(1,1);
	           // deleteItemScreen.setLayout(deleteGrid);

	            JLabel jlblHeading = new JLabel("SELECT A REPORT ITEM TO MODIFY");
	           
	            
	            
	            		
	            
	           


	           

	            //create category type label
	            //JLabel jlblheading = new JLabel("MODIFY BILLS PAYMENTS COLUMN");

	          

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
	            JLabel jlbldate = new JLabel("Select an income payment date to start reporting from");


	          
	            
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
	            JLabel jlbldate2 = new JLabel("Select an income payment date to end reporting at");


	            
	            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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
	            JLabel jlblperiod = new JLabel("Select what interval to receive income payments on");

	            JLabel padding4 = new JLabel();
	            
	            //////////////////////////////////////////////
	            JTextField jtfNumPeriods= new JTextField();
	            jtfNumPeriods.setText(Global.textFieldArray[Global.modSelIndex][3].getText().toString());

	            //create payment amount label
	            JLabel jlblNumPeriods = new JLabel("Enter number of periods per interval");

	            JLabel padding7 = new JLabel();
	            /////////////////////////////////////////////

	            //create payment amount textfield
	            JTextField jtfPayment= new JTextField();
	            jtfPayment.setText(Global.textFieldArray[Global.modSelIndex][1].getText().toString());

	            //create payment amount label
	            JLabel jlblPayment = new JLabel("Enter the income payment amount");

	            JLabel padding5 = new JLabel();

	            //create title to report on textfield
	            JTextField jtfTitle= new JTextField();
	            jtfTitle.setText(Global.textFieldArray[Global.modSelIndex][6].getText().toString());


	            //create title to report on label
	            JLabel jlblTitle = new JLabel("Enter the title of this income payment category to report on");

	            JLabel padding6 = new JLabel();



	            //create submit button to create column
	            JButton jbtnSubmit = new JButton("Modify");

	          //create submit button label
	            JLabel jlblSubmit = new JLabel("Enter to modify the column for this income");

	          
	            
	            gbc.gridx= 0;
	            gbc.gridy=0;
	            jlblHeading.setPreferredSize(new Dimension(400,20));
	            mainJPanel.add(jlblHeading,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=1;
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
	            JLabel lblpad2 = new JLabel(" ");
	            lblpad1.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(lblpad2,gbc);
	            
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
	            JLabel lblpad3 = new JLabel(" ");
	            lblpad3.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(lblpad3,gbc);
	            
	           //////////////////////////////////////////////////
	            gbc.gridx= 0;
	            gbc.gridy=13;
	            //gbc.gridheight=5;
	            jtfNumPeriods.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(jtfNumPeriods,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=14;
	            mainJPanel.add(jlblNumPeriods,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=15;
	            JLabel lblpad6 = new JLabel(" ");
	            lblpad6.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(lblpad6,gbc);
	            //////////////////////////////////////////////////
	            
	            gbc.gridx= 0;
	            gbc.gridy=16;
	            //gbc.gridheight=5;
	            jtfPayment.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(jtfPayment,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=17;
	            mainJPanel.add(jlblPayment,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=18;
	            JLabel lblpad4 = new JLabel(" ");
	            lblpad4.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(lblpad4,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=19;
	            jtfTitle.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(jtfTitle,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=20;
	            mainJPanel.add(jlblTitle,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=21;
	            JLabel lblpad5 = new JLabel(" ");
	            lblpad5.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(lblpad5,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=22;
	            jbtnSubmit.setPreferredSize(new Dimension(400,20)); 
	            mainJPanel.add(jbtnSubmit,gbc);
	            
	            gbc.gridx= 0;
	            gbc.gridy=23;
	            mainJPanel.add(jlblSubmit,gbc);

	           

	            ActionListener submitListener = new ActionListener() 
	            {
	                    @Override
	                    public void actionPerformed(ActionEvent event)
	                    {
	                            if(event.getSource()==jbtnSubmit)
	                            {
	                                    String title="";
	                                    boolean valid = true;
	                                    try
	                                    {
	                                        int amt = Integer.valueOf(jtfPayment.getText());
	                                        if ((amt>Global.maxVal)||(amt<0))
	                                        {
	                                            valid = false;
	                                            JOptionPane.showMessageDialog(null, "Income amount must be a whole munber between 0 and "+Global.maxVal+" (no cents or $ sign).");
	                                        }

	                                    }
	                                    catch (Exception e) 
	                                    {
	                                        JOptionPane.showMessageDialog(null, "Income amount must be a whole munber between 0 and "+Global.maxVal+" (no cents or $ sign).");
	                                        valid = false;
	                                    }


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
	                                        //JOptionPane.showMessageDialog(frame, strDate+" is valid date format");
	                                        //System.out.println(strDate+" is valid date format");
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
	                                    
	                                    
	                                    if(jtfTitle.getText().toString().trim().isEmpty())
	                                    {
	                                        JOptionPane.showMessageDialog(null, "must enter a title for this item");
	                                        valid = false;
	                                    }
	                                    else
	                                    {
	                                    	
	                                    	boolean validTitle = true;
	                                        title=jtfTitle.getText().toString().trim();
	                                        
	                                        validTitle=(Global.ValidateTitle(title, Global.modSelIndex));
	                                        if (validTitle==false)
	                                        {
	                                        	valid=false;
	                                        	JOptionPane.showMessageDialog(null, "that item title already exist. Please enter an unique one");
	                                        }
	                                        
	                                    }
	                                    
	                                    try
	                                    {
	                                    	int numPeriods = Integer.valueOf(jtfNumPeriods.getText().toString());
	                                    	if (numPeriods < 1)
	                                    	{
	                                    		JOptionPane.showMessageDialog(null, "number of Periods must be greater than 0");
	                                    		valid=false;
	                                    	}
	                                    	
	                                    	
	                                    }
	                                    catch (Exception f)
	                                    {
	                                    	valid=false;
	                                    	JOptionPane.showMessageDialog(null, jtfNumPeriods.getText().toString()+" is an invalid number of periods");
	                                    	
	                                    }

	                                    if(valid==true)
	                                    {
	                                    	if(dateStart.compareTo(dateEnd) >= 0)
	                                    	{
	                                    		valid=false;
	                                    		JOptionPane.showMessageDialog(null, "end date must be greater than start date");
	                                    	}
	                                    }



	                                    if (valid==true)
	                                    {
	                                        int amt = Integer.valueOf(jtfPayment.getText());
	                                        int numRows = Global.getNumRows(Global.textFieldArray,0);
	                                        int date = Integer.valueOf(jcbdays.getSelectedItem().toString());
	                                        int month = Integer.valueOf(jcbmonths.getSelectedItem().toString());
	                                        int year = Integer.valueOf(jcbyears.getSelectedItem().toString());
	                                        
	                                        int date2 = Integer.valueOf(jcbdays2.getSelectedItem().toString());
	                                        int month2 = Integer.valueOf(jcbmonths2.getSelectedItem().toString());
	                                        int year2 = Integer.valueOf(jcbyears2.getSelectedItem().toString());
	                                        
	                                        String freq = jcbperiods.getSelectedItem().toString();
	                                        int numPeriods = Integer.valueOf(jtfNumPeriods.getText().toString());
	                                        //String title = jtfTitle.getText().toString();
	                                        boolean isSum=false;

	                                        if(Global.tallyCreated == true)
	                                        {
	                                            Global.DeleteTally();



	                                        }
	                                        int i = Global.modSelIndex;
	                                        
	                                        Global.InitCol(i);

	                                        GenColumn myColumn = new GenColumn("income",i,date,month,year,date2,month2,year2,freq,numPeriods, amt, title,isSum);
	                                   
	                                        //MainMenu.DisplayChart();
	                                        CreateModifyScreen.listItemSelected = false;
	                                        MainMenu.DisplayModifyItemScreen();	
	                                    }
	                                    
	                                   

	                            }
	                    }
	            };

	            jbtnSubmit.addActionListener(submitListener);
	            
	            
	            

	            return mainJPanel;
	}
    
}

