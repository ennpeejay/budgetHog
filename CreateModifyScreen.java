

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;

public class CreateModifyScreen 
{   
	public static boolean listItemSelected = false;
    public JPanel displayCreateModifyScreen()
    {
        
        
    	
    	
	JPanel deleteItemScreen = new JPanel();
        deleteItemScreen.setLayout(null);
        deleteItemScreen.setPreferredSize(new Dimension(1300,225));
        
        JLabel jlblHeading = new JLabel("SELECT A REPORT ITEM TO MODIFY");
        jlblHeading.setBounds(200, 0, 1000, 20);
        
        //JButton jbtnDelete = new JButton("MODIFY");
        //jbtnDelete.setBounds(200, 401, 600, 20);
        
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
        deleteItemScrollPane.setViewportView(list);
        deleteItemScrollPane.setBounds(200, 20, 1000, 200);
        
        deleteItemScrollPane.getVerticalScrollBar().setMaximum(500);
		
        //int y = (Global.getNumCols(Global.textFieldArray) - x);
        //int z = 500/y;
		//int w = 500/z*Global.modifyScreenSelectedIndex;
		deleteItemScrollPane.getVerticalScrollBar().setValue(Global.modifyScreenScrollBarValue);
		
		//list.setSelectedIndex(Global.modifyScreenSelectedIndex);
		
		//JOptionPane.showMessageDialog(null,Global.modifyScreenScrollBarValue);
		
      
        
        
        
        
        //deleteItemScreen.add(jbtnDelete);
        
  
        //list.setSelectedIndex(Global.modSelIndex);
        //JList list = new JList(myList);  
        //list.setLayoutOrientation(JList.VERTICAL);
        
        ListSelectionListener Listener = new ListSelectionListener() 
        {
          @Override
	        public void valueChanged(ListSelectionEvent event)
	        {
	        	if(event.getSource()==list)
                        {
	        				listItemSelected = true;
	        				Global.modifyScreenScrollBarValue= deleteItemScrollPane.getVerticalScrollBar().getValue();
                            Global.modifyScreenSelectedIndex = list.getSelectedIndex();
                            int index = list.getSelectedIndex();
                            if(Global.textFieldArray[index][0].getText().toString().equals("bills"))
                            {
                                Global.modSelIndex = index;
                                Global.myModifyScreen=null;
                                Global.myModifyBillsScreen = new CreateModifyBillsScreen();
                                //Global.myModifyBillsPanel = new CreateModifyBillsScreen();
                                JPanel myJPanel = new JPanel();

                                myJPanel.add(Global.myModifyBillsScreen.displayModifyBillsScreen());
                                //myJPanel.add(Global.myModifyBillsPanel.displayModifyBillsScreen());
                                 MainMenu.scrollPane.setViewportView(null);
                                    MainMenu.scrollPane.setColumnHeaderView(null);
                                    MainMenu.scrollPane.setRowHeaderView(null);
                                    MainMenu.scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                MainMenu.scrollPane.setViewportView(myJPanel);
                                //JOptionPane.showMessageDialog(null,index);

                               
                            }
                            else if((Global.textFieldArray[index][0].getText().toString().equals("totals"))
                            	&&(Global.textFieldArray[index-1][0].getText().toString().equals("bills")))
                            {
                                Global.modSelIndex = index-1;
                                Global.myModifyScreen=null;
                                Global.myModifyBillsScreen = new CreateModifyBillsScreen();
                                //Global.myModifyBillsPanel = new CreateModifyBillsScreen();
                                JPanel myJPanel = new JPanel();

                                myJPanel.add(Global.myModifyBillsScreen.displayModifyBillsScreen());
                                //myJPanel.add(Global.myModifyBillsPanel.displayModifyBillsScreen());
                                 MainMenu.scrollPane.setViewportView(null);
                                    MainMenu.scrollPane.setColumnHeaderView(null);
                                    MainMenu.scrollPane.setRowHeaderView(null);
                                    MainMenu.scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                MainMenu.scrollPane.setViewportView(myJPanel);
                                //JOptionPane.showMessageDialog(null,index);

                               
                            }
                            else if(Global.textFieldArray[index][0].getText().toString().equals("income"))
                            {
                                Global.modSelIndex = index;
                                Global.myModifyScreen=null;
                                Global.myModifyIncomeScreen = new CreateModifyIncomeScreen();
                                //Global.myModifyBillsPanel = new CreateModifyBillsScreen();
                                JPanel myJPanel = new JPanel();

                                myJPanel.add(Global.myModifyIncomeScreen.displayModifyIncomeScreen());
                                //myJPanel.add(Global.myModifyBillsPanel.displayModifyBillsScreen());
                                 MainMenu.scrollPane.setViewportView(null);
                                    MainMenu.scrollPane.setColumnHeaderView(null);
                                    MainMenu.scrollPane.setRowHeaderView(null);
                                    MainMenu.scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                MainMenu.scrollPane.setViewportView(myJPanel);
                                //JOptionPane.showMessageDialog(null,index);

                               
                            }
                             else if(Global.textFieldArray[index][0].getText().toString().equals("dates"))
                            {
                                Global.modSelIndex = index;
                                Global.myModifyScreen=null;
                                Global.myModifyDatesScreen = new CreateModifyDatesScreen();
                                //Global.myModifyBillsPanel = new CreateModifyBillsScreen();
                                JPanel myJPanel = new JPanel();

                                myJPanel.add(Global.myModifyDatesScreen.displayModifyDatesScreen());
                                //myJPanel.add(Global.myModifyBillsPanel.displayModifyBillsScreen());
                                 MainMenu.scrollPane.setViewportView(null);
                                    MainMenu.scrollPane.setColumnHeaderView(null);
                                    MainMenu.scrollPane.setRowHeaderView(null);
                                    MainMenu.scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                MainMenu.scrollPane.setViewportView(myJPanel);
                                //JOptionPane.showMessageDialog(null,index);

                               
                            }
                             else
                                 {
                                     Global.modSelIndex = index;
                                    Global.myModifyScreen=null;
                                    Global.myModifyIrregularScreen = new CreateModifyIrregularScreen();
                                    //Global.myModifyBillsPanel = new CreateModifyBillsScreen();
                                    JPanel myJPanel = new JPanel();

                                    myJPanel.add(Global.myModifyIrregularScreen.displayModifyIrregularScreen());
                                    //myJPanel.add(Global.myModifyBillsPanel.displayModifyBillsScreen());
                                     MainMenu.scrollPane.setViewportView(null);
                                        MainMenu.scrollPane.setColumnHeaderView(null);
                                        MainMenu.scrollPane.setRowHeaderView(null);
                                        MainMenu.scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, null);
                                    MainMenu.scrollPane.setViewportView(myJPanel);
                                 }
                           
                            
                 
                        }
                }
        };
        
        if( listItemSelected == true)
		{
        	list.setSelectedIndex(Global.modifyScreenSelectedIndex);     
		}
        
        deleteItemScreen.add(jlblHeading);
        deleteItemScreen.add(deleteItemScrollPane);
        
        //jbtnDelete.addActionListener(Listener);
        list.addListSelectionListener(Listener);
        
        
        //deleteItemScreen.setVisible(true);
        
   
        return deleteItemScreen;
        
      
    }
    
    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author -
 */


