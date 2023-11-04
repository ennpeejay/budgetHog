
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

public class CreateDatesScreen 
{
	public CreateDatesScreen()
	{
		
	}
	
	public JPanel displayCreateDatesScreen()
	{
		//Creating main window the Frame
        JFrame frame = new JFrame("Create a column in your report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        
        //inset main scroll pane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        
        //create user panel to get details of column to be created
        JPanel createDatesScreen = new JPanel();
        GridLayout createGrid = new GridLayout(22,1);
        
        createDatesScreen.setLayout(createGrid);
        
        

        //padding.setSize(200,20);
        //JPanel padding = new JPanel();
     
       
        
        //create category type label
        JLabel jlblheading = new JLabel("CREATE YOUR REPORTING INTERVAL DATES");
        
        JLabel padding1 = new JLabel();
        JLabel padding2 = new JLabel();
       
        
        
        //create labels for date combo boxes
        
        
        //create grouping panel for date labels
        JPanel datePanel = new JPanel();
        GridLayout dateGrid = new GridLayout(1,3);
        datePanel.setLayout(dateGrid);
        
        //create labels for date boxes
        JLabel jlbldd = new JLabel("day");
        JLabel jlblmm = new JLabel("month");
        JLabel jlblyyyy = new JLabel("year");
        
        datePanel.add(jlbldd);
        datePanel.add(jlblmm);
        datePanel.add(jlblyyyy);
        
        
        
        
        //create grouping panel for date comboboxes
        JPanel dateCbPanel = new JPanel();
        GridLayout dateCbGrid = new GridLayout(1,3);
        dateCbPanel.setLayout(dateCbGrid);
        
        //create comboboxes for date items
        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        final JComboBox<String> jcbdays = new JComboBox<String>(days);
        
        String[] months = { "1","2","3","4","5","6","7","8","9","10","11","12"};
        final JComboBox<String> jcbmonths = new JComboBox<String>(months);
        
        String[] years = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
        final JComboBox<String> jcbyears = new JComboBox<String>(years);
        
        dateCbPanel.add(jcbdays);
        dateCbPanel.add(jcbmonths);
        dateCbPanel.add(jcbyears);
        
        
        
      //create label for report start date
        JLabel jlbldate = new JLabel("Select a date to start reporting from (this is usually your main pay date)");
        
        JLabel padding3 = new JLabel();
        
        
        //end date
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //create grouping panel for date labels
        JPanel datePanel2 = new JPanel();
        GridLayout dateGrid2 = new GridLayout(1,3);
        datePanel2.setLayout(dateGrid2);
        
        //create labels for date boxes
        JLabel jlbldd2 = new JLabel("day");
        JLabel jlblmm2 = new JLabel("month");
        JLabel jlblyyyy2 = new JLabel("year");
        
        datePanel2.add(jlbldd2);
        datePanel2.add(jlblmm2);
        datePanel2.add(jlblyyyy2);
        
        //create grouping panel for date comboboxes
        JPanel dateCbPanel2 = new JPanel();
        GridLayout dateCbGrid2 = new GridLayout(1,3);
        dateCbPanel2.setLayout(dateCbGrid2);
        
        //create comboboxes for date items
        String[] days2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        final JComboBox<String> jcbdays2 = new JComboBox<String>(days);
        
        String[] months2 = { "1","2","3","4","5","6","7","8","9","10","11","12"};
        final JComboBox<String> jcbmonths2 = new JComboBox<String>(months);
        
        String[] years2 = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
        final JComboBox<String> jcbyears2 = new JComboBox<String>(years);
        
        dateCbPanel2.add(jcbdays2);
        dateCbPanel2.add(jcbmonths2);
        dateCbPanel2.add(jcbyears2);
        
      //create label for report start date
        JLabel jlbldate2 = new JLabel("Select a date to end reporting at");
        
        
        JLabel padding32 = new JLabel();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
       
        
        //create reporting interval period combobox
        String[] periods = { "daily","weekly","monthly","yearly"};
        final JComboBox<String> jcbperiods = new JComboBox<String>(periods);
        
        //create label for reporting interval
        JLabel jlblperiod = new JLabel("Select what period to report on (this is usually on a weekly basis or can be set to any period such as your main income period)");
        
        JLabel padding4 = new JLabel();
        
        
        //create number of periods to report on textfield
        JTextField jtfNumPeriods= new JTextField();
        
        //create number of periods to report on label
        JLabel jlblNumPeriods = new JLabel("Enter the number of periods to report on");
        
        JLabel padding5 = new JLabel();
        
     
        
        //create submit button to create column
        JButton jbtnSubmit = new JButton("Submit");
        
      //create submit button label
        JLabel jlblSubmit = new JLabel("Enter to create a column of date intervals to report on");
        

        createDatesScreen.add(jlblheading);
        
        createDatesScreen.add(padding1);
        createDatesScreen.add(padding2);
        
        createDatesScreen.add(datePanel);
        createDatesScreen.add(dateCbPanel);
        createDatesScreen.add(jlbldate);
        
        createDatesScreen.add(padding3);
        
        createDatesScreen.add(datePanel2);
        createDatesScreen.add(dateCbPanel2);
        createDatesScreen.add(jlbldate2);
        
        createDatesScreen.add(padding32);
     
        createDatesScreen.add(jcbperiods);
        createDatesScreen.add(jlblperiod);
        
        createDatesScreen.add(padding4);
        
        createDatesScreen.add(jtfNumPeriods);
        createDatesScreen.add(jlblNumPeriods);
        
        createDatesScreen.add(padding5);
        
        
        
        createDatesScreen.add(jbtnSubmit);
        createDatesScreen.add(jlblSubmit);
        
        ActionListener submitListener = new ActionListener() 
        {
            boolean valid;
	        @Override
	        public void actionPerformed(ActionEvent event)
	        {
                    
	        	if(event.getSource()==jbtnSubmit)
	        	{
                                boolean valid = true;
	        		//int numRows=0;
	        		int amt = 0;
	        		/**
                                try 
                                {
                                    numRows = Integer.valueOf(jtfNumPeriods.getText());
                                    if ((numRows > Global.maxRows) || (numRows < 1))
                                    {
                                        valid=false;
                                        JOptionPane.showMessageDialog(frame, "number of periods must be a whole number between 1 and "+ Global.maxRows);
                                    }
                                }
                                catch(Exception e) 
                                {
                                    JOptionPane.showMessageDialog(frame, "number of periods must be a whole number between 1 and "+ Global.maxRows);
                                    valid = false;
                                    
                                }
                       **/         
                                
                                
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
                                    JOptionPane.showMessageDialog(frame, strDate+" is an invalid Date");
                                    valid = false;
                                }
                                //////////////////////////////////////////////////////////////////////////////////////////
                                String dd2 = (jcbdays2.getSelectedItem().toString());
                                String mm2 = (jcbmonths2.getSelectedItem().toString());
                              
                                String yyyy2 = (jcbyears2.getSelectedItem().toString());
                                
                                String endDate = dd2 + "/" + mm2 + "/" + yyyy2;
                                //SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
                                sdfrmt.setLenient(false);
                                try
                                {
                                    
                                    dateEnd = sdfrmt.parse(endDate); 
                                    //JOptionPane.showMessageDialog(frame, strDate+" is valid date format");
                                    //System.out.println(strDate+" is valid date format");
                                }
                                catch (Exception e)
                                {
                                    JOptionPane.showMessageDialog(frame, endDate+" is an invalid Date");
                                    valid = false;
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
                                	JOptionPane.showMessageDialog(frame, jtfNumPeriods.getText().toString()+" is an invalid number of periods");
                                	
                                }
                                
                                
                                
                                if(valid==true)
                                {
                                	if(dateStart.compareTo(dateEnd) >= 0)
                                	{
                                		valid=false;
                                		JOptionPane.showMessageDialog(null, "end date must be greater than start date");
                                	}
                                }
                                
                               
                                
                                ////////////////////////////////////////////////////////////////////////////////////////
                                

	        		//int numRows = Integer.valueOf(jtfNumPeriods.getText());
                                if (valid==true)
                                {
                                    
                                    //Global.numRows = numRows - 5;
                                    int date = Integer.valueOf(jcbdays.getSelectedItem().toString());
                                    int month = Integer.valueOf(jcbmonths.getSelectedItem().toString());
                                    int year = Integer.valueOf(jcbyears.getSelectedItem().toString());
                                    
                                    int date2 = Integer.valueOf(jcbdays2.getSelectedItem().toString());
                                    int month2 = Integer.valueOf(jcbmonths2.getSelectedItem().toString());
                                    int year2 = Integer.valueOf(jcbyears2.getSelectedItem().toString());
                                    
                                    String period = jcbperiods.getSelectedItem().toString();
                                    int numPeriods = Integer.valueOf(jtfNumPeriods.getText().toString());

                                    
                                    int i = Global.getNumCols(Global.textFieldArray);
                                    
                                    boolean isSum = false;
                                    
                                   
                                    GenColumn myColumn = new GenColumn("dates",i,date,month,year,date2,month2,year2,period, numPeriods, amt, "report intervals", isSum);
                                    //myColumn.GenPanel();
                                       
                                       
                                    jcbdays.setSelectedIndex(0);
                                    jcbmonths.setSelectedIndex(0);
                                    jcbyears.setSelectedIndex(0);
                                    jcbperiods.setSelectedIndex(0);
                                    jtfNumPeriods.setText("");
                                        
                                  MainMenu.DisplayChart();  
                                    
                                }
                                
                            //MainMenu.DisplayChart();
	        		
	        	}
	        }
        };
        
        jbtnSubmit.addActionListener(submitListener);
        
        
        return createDatesScreen;
	}
	
	
	
	
}

