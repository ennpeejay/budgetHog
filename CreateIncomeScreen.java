
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

public class CreateIncomeScreen 
{
	public CreateIncomeScreen()
	{
		
	}
	
	public JPanel displayCreateIncomeScreen()
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
        JPanel createIncomeScreen = new JPanel();
        GridLayout createGrid = new GridLayout(25,1);
        
        createIncomeScreen.setLayout(createGrid);
        
        JPanel createIncomeScreen2 = new JPanel();
        
        

        //create category type label
        JLabel jlblheading = new JLabel("CREATE AN INCOME PAYMENTS COLUMN");
        
        JLabel padding1 = new JLabel();
        JLabel padding2 = new JLabel();
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        DefaultListModel<String> model = new DefaultListModel<>();  
        //JList myList = new JList(); 
        JList<String> list = new JList<String>(model);  
        list.setLayoutOrientation(JList.VERTICAL);
        list.setFont(new Font("monospaced", Font.PLAIN, 12));
        int x = 0;
        if(Global.tallyCreated == true)
        {
            x = 1;
        }
        
       
        for(int i = 0; i < Global.getNumCols(Global.textFieldArray)-x; i++)
        {
            
          
           model.addElement(Global.FormatString(Global.textFieldArray[i][0].getText().toString(),20)
                               + Global.FormatString(Global.textFieldArray[i][1].getText().toString(),20)
                                + Global.FormatString(Global.textFieldArray[i][2].getText().toString(),20)
                                +  Global.FormatString(Global.textFieldArray[i][3].getText().toString(),20)
                                +  Global.FormatString(Global.textFieldArray[i][4].getText().toString(),20)
                                +  Global.FormatString(Global.textFieldArray[i][5].getText().toString(),20)
           						+  Global.FormatString(Global.textFieldArray[i][6].getText().toString(),20));  
           
        }
        
        JScrollPane deleteItemScrollPane = new JScrollPane();
        
        int y = Global.getNumCols(Global.textFieldArray)-x;
        
        //list.ensureIndexIsVisible(y);
        
        //list.setSelectedIndex(2);
        deleteItemScrollPane.setViewportView(list);
        
       
        
       // int y = Global.getNumCols(Global.textFieldArray)-x;
        
       
        deleteItemScrollPane.setBounds(200, 100, 1300, 300);
        
        deleteItemScrollPane.getVerticalScrollBar().setMaximum(500);
        
       //list.ensureIndexIsVisible(y);
       // int y = deleteItemScrollPane.getVerticalScrollBar().getMaximum() -1;
        //deleteItemScrollPane.getViewport().setViewPosition(new Point(0,y));
        //JOptionPane.showMessageDialog(null, z);
        //
        deleteItemScrollPane.getVerticalScrollBar().setValue(500);
        
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        
        
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
        JLabel jlbldate = new JLabel("Select a payment receive date to start reporting from");
        
        JLabel padding3 = new JLabel();
        
        
      //report end date
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
        JLabel jlblperiod = new JLabel("Select what intervals to report payments on");
        
        JLabel padding4 = new JLabel();
        
        JTextField jtfNumPeriods = new JTextField();
        JLabel jlblNumPeriods = new JLabel("Enter the number of periods to report on");
        
        JLabel padding7 = new JLabel();
        
        //create payment amount textfield
        JTextField jtfPayment= new JTextField();
        
        //create payment amount label
        JLabel jlblPayment = new JLabel("Enter the payment amount received that you wish to report");
        
        JLabel padding5 = new JLabel();
        
        //create title to report on textfield
        JTextField jtfTitle= new JTextField();
        
        //create title to report on label
        JLabel jlblTitle = new JLabel("Enter the title of this category to report on");
        
        JLabel padding6 = new JLabel();
        
        
        
        //create submit button to create column
        JButton jbtnSubmit = new JButton("Submit");
        
      //create submit button label
        JLabel jlblSubmit = new JLabel("Enter to create a column of income payments");
        
        
        createIncomeScreen.add(jlblheading);
        
        createIncomeScreen.add(padding1);
        createIncomeScreen.add(padding2);
        
        createIncomeScreen.add(datePanel);
        createIncomeScreen.add(dateCbPanel);
        createIncomeScreen.add(jlbldate);
        
        createIncomeScreen.add(padding3);
        
///////////////////////////////////////////////////////
        
		createIncomeScreen.add(datePanel2);
		createIncomeScreen.add(dateCbPanel2);
		createIncomeScreen.add(jlbldate2);
		
		createIncomeScreen.add(padding32);
///////////////////////////////////////////////////////
     
        createIncomeScreen.add(jcbperiods);
        createIncomeScreen.add(jlblperiod);
        
        createIncomeScreen.add(padding4);
        
        createIncomeScreen.add(jtfNumPeriods);
        createIncomeScreen.add(jlblNumPeriods);
        
        createIncomeScreen.add(padding7);
        
        createIncomeScreen.add(jtfPayment);
        createIncomeScreen.add(jlblPayment);
        
        createIncomeScreen.add(padding5);
        
        createIncomeScreen.add(jtfTitle);
        createIncomeScreen.add(jlblTitle);
        
        createIncomeScreen.add(padding6);
        
        createIncomeScreen.add(jbtnSubmit);
        createIncomeScreen.add(jlblSubmit);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        createIncomeScreen2.add(createIncomeScreen);
        createIncomeScreen2.add(deleteItemScrollPane);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        
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
                                JOptionPane.showMessageDialog(frame, "Income amount must be a whole munber between 0 and "+Global.maxVal+  " (no cents or $ sign).");
                            }
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(frame, "Income amount must be a whole munber between 0 and "+Global.maxVal+" (no cents or $ sign).");
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
                    
                	String dd = (jcbdays.getSelectedItem().toString());
                    String mm = (jcbmonths.getSelectedItem().toString());
                  
                    String yyyy = (jcbyears.getSelectedItem().toString());
                    
                    String strDate = dd + "/" + mm + "/" + yyyy;
                    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
                    sdfrmt.setLenient(false);
                    
                    Date dateStart = null;
                    Date dateEnd =  null;
                    
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
                    
                    String dd2 = (jcbdays2.getSelectedItem().toString());
                    String mm2 = (jcbmonths2.getSelectedItem().toString());
                  
                    String yyyy2 = (jcbyears2.getSelectedItem().toString());
                    
                    strDate = dd2 + "/" + mm2 + "/" + yyyy2;
                    sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
                    sdfrmt.setLenient(false);
                    try
                    {
                        
                        dateEnd = sdfrmt.parse(strDate); 
                        
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(frame, strDate+" is an invalid Date");
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
	                                
		        		if(Global.tallyCreated == true)
                        {
                            Global.DeleteTally();
                        
                        }
                        int i = Global.getNumCols(Global.textFieldArray);
                        
                        boolean isSum = false;
		        		
		        		
		        		GenColumn myColumn = new GenColumn("income",i,date,month,year,date2,month2,year2,freq,numPeriods, amt, title, isSum);
		        		
                        //MainMenu.DisplayChart();
		        		///////////////////////////////////////////////////////////////////////////////////////////
		        		MainMenu.DisplayCreateIncomeScreen();
		        		/////////////////////////////////////////////////////////////////////////////////////////////
                    }
                  
	        	     
	        	}
	        }
        };
        
        jbtnSubmit.addActionListener(submitListener);
        
        
        return createIncomeScreen2;
	}
	
	
	
	
}


