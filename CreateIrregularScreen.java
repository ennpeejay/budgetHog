
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author -
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
public class CreateIrregularScreen {

        public CreateIrregularScreen()
	{
		
	}

	
    public JPanel displayCreateIrregularScreen()
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
        JPanel createIrregularScreen = new JPanel();
        GridLayout createGrid = new GridLayout(18,1);
        
        createIrregularScreen.setLayout(createGrid);
        
        JPanel createIrregularScreen2 = new JPanel();
        
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
		

        
        

        //create category type label
        JLabel jlblheading = new JLabel("CREATE AN IRREULAR ITEM COLUMN");
        
        JLabel padding1 = new JLabel();
        JLabel padding2 = new JLabel();
       
        
        
        //create labels for date combo boxes
        
        
        //create grouping panel for date labels
       // JPanel datePanel = new JPanel();
       // GridLayout dateGrid = new GridLayout(1,3);
       // datePanel.setLayout(dateGrid);
        
        //create labels for date boxes
       // JLabel jlbldd = new JLabel("day");
       // JLabel jlblmm = new JLabel("month");
       // JLabel jlblyyyy = new JLabel("year");
        
      //  datePanel.add(jlbldd);
       // datePanel.add(jlblmm);
       // datePanel.add(jlblyyyy);
        
        
        
        
        //create grouping panel for date comboboxes
       // JPanel dateCbPanel = new JPanel();
       // GridLayout dateCbGrid = new GridLayout(1,3);
       // dateCbPanel.setLayout(dateCbGrid);
        
        //create comboboxes for date items
       // String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
      //  final JComboBox<String> jcbdays = new JComboBox<String>(days);
        
      //  String[] months = { "1","2","3","4","5","6","7","8","9","10","11","12"};
      //  final JComboBox<String> jcbmonths = new JComboBox<String>(months);
        
      //  String[] years = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
      //  final JComboBox<String> jcbyears = new JComboBox<String>(years);
        
      //  dateCbPanel.add(jcbdays);
     //   dateCbPanel.add(jcbmonths);
     //   dateCbPanel.add(jcbyears);
        
        
        
      //create label for report start date
      //  JLabel jlbldate = new JLabel("Select a bill due date to start reporting from");
        
        
      //  JLabel padding3 = new JLabel();
        
       
        
        //create reporting interval period combobox
       // String[] periods = { "weekly","fortnightly","monthly","2 monthly","quarterly","4 monthly","5 monthly","half yearly","7 monthly","8 monthly","9 monthly","10 monthly","11 monthly","yearly"};
      //  final JComboBox<String> jcbperiods = new JComboBox<String>(periods);
        
        //create label for reporting interval
       // JLabel jlblperiod = new JLabel("Select what interval to make payments on");
        
      //  JLabel padding4 = new JLabel();
        
        
        //create payment amount textfield
      //  JTextField jtfPayment= new JTextField();
        
        //create payment amount label
       // JLabel jlblPayment = new JLabel("Enter the bill amount");
        
      //  JLabel padding5 = new JLabel();
        
        //create title to report on textfield
        JTextField jtfTitle= new JTextField();
    
        
        //create title to report on label
        JLabel jlblTitle = new JLabel("Enter the title of this irregular items category to report on");
        
        JLabel padding6 = new JLabel();
        
        
        
        //create submit button to create column
        JButton jbtnSubmit = new JButton("Submit");
        
      //create submit button label
        JLabel jlblSubmit = new JLabel("Enter to create a column for this irregular items");
        

        //createBillsScreen.add(jlblheading);
        
        //createBillsScreen.add(padding1);
        //createBillsScreen.add(padding2);
        
        //createBillsScreen.add(datePanel);
        //createBillsScreen.add(dateCbPanel);
        //createBillsScreen.add(jlbldate);
        
        //createBillsScreen.add(padding3);
     
        //createBillsScreen.add(jcbperiods);
        //createBillsScreen.add(jlblperiod);
        
        //createBillsScreen.add(padding4);
        
        //createBillsScreen.add(jtfPayment);
        //createBillsScreen.add(jlblPayment);
        
        //createBillsScreen.add(padding5);
        createIrregularScreen.add(jlblheading);
        createIrregularScreen.add(padding1);
        createIrregularScreen.add(padding2);
        
        createIrregularScreen.add(jtfTitle);
        createIrregularScreen.add(jlblTitle);
        
        createIrregularScreen.add(padding6);
        
        createIrregularScreen.add(jbtnSubmit);
        createIrregularScreen.add(jlblSubmit);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        createIrregularScreen2.add(createIrregularScreen);
        createIrregularScreen2.add(deleteItemScrollPane);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        
        ActionListener submitListener = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==jbtnSubmit)
                {
                    String title = "";
                    boolean valid = true;
                    int numRows = Global.getNumRows(Global.textFieldArray,0);
                    
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
                    
                    if(valid==true)
                    {
                        //String title = jtfTitle.getText().toString();

                        if(Global.tallyCreated == true)
                        {
                            Global.DeleteTally();

                        }
                        int i = Global.getNumCols(Global.textFieldArray);
                        boolean isSum=false;

                        GenColumn myColumn = new GenColumn("irregular",i,0,0,0,0,0,0,"",0, 0, title, isSum);

                        MainMenu.DisplayCreateIrregularScreen();
                    }
                    

                }
            }
        };
        
        jbtnSubmit.addActionListener(submitListener);
        
        
        return createIrregularScreen2;
	}
	
}
