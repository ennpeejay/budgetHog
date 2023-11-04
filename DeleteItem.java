
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
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;

public class DeleteItem 
{   
    public JPanel displayDeleteItemScreen()
    {
	JPanel deleteItemScreen = new JPanel();
        deleteItemScreen.setLayout(null);
       // deleteItemScreen.setPreferredSize(new Dimension(1000,1000));
        deleteItemScreen.setPreferredSize(new Dimension(Global.screenWidth-50,Global.screenHeight-50));
        
        JLabel jlblHeading = new JLabel("SELECT A REPORT ITEM TO DELETE");
        jlblHeading.setBounds(200, 80, 600, 20);
        
        JButton jbtnDelete = new JButton("DELETE");
        jbtnDelete.setBounds(200, 401, 600, 20);
        
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
        //JList list = new JList(myList);  
        //list.setLayoutOrientation(JList.VERTICAL);
        
        ActionListener Listener = new ActionListener() 
        {
            @Override
	        public void actionPerformed(ActionEvent event)
	        {
	        	if(event.getSource()==jbtnDelete)
                        {
                            int index = list.getSelectedIndex();
                            if(index==0)
                            {
                                int selectedOption = JOptionPane.showConfirmDialog(null, 
                                          "Deleting DATES column will delete entire chart! Are you sure?", 
                                          "Choose", 
                                          JOptionPane.YES_NO_OPTION); 
                                if (selectedOption == JOptionPane.YES_OPTION) 
                                {

                                    Global.Init();
                                    MainMenu.DisplayBlank();
                                    
                                    Global.intervalPanelCreated = false;
                                    
                                }
                               
                            }
                            if(index>0)
                            {
                                int selectedOption = JOptionPane.showConfirmDialog(null, 
                                          "Are you shure you want to delete this column?", 
                                          "Choose", 
                                          JOptionPane.YES_NO_OPTION); 
                                if (selectedOption == JOptionPane.YES_OPTION) 
                                {
                                	if(Global.textFieldArray[index][0].getText().toString().equals("totals"))
                                    {
                                    	//Global.tallyCreated=true;
                                        Global.DeleteCol(index);
                                        Global.DeleteCol(index-1);
                                        //MainMenu.DisplayChart();
                                        MainMenu.DisplayDeleteItemScreen();
                                    }

                                	else if(Global.textFieldArray[index][0].getText().toString().equals("irregular"))
                                    {
                                    	//Global.tallyCreated=true;
                                        Global.DeleteCol(index);
                                        Global.DeleteCol(index);
                                        //MainMenu.DisplayChart();
                                        MainMenu.DisplayDeleteItemScreen();
                                    }
                                    else if(Global.textFieldArray[index][0].getText().toString().equals("description"))
                                    {
                                    	//Global.tallyCreated=true;
                                        Global.DeleteCol(index);
                                        Global.DeleteCol(index-1);
                                        //MainMenu.DisplayChart();
                                        MainMenu.DisplayDeleteItemScreen();
                                    }
                                    else if((Global.textFieldArray[index][0].getText().toString().equals("bills"))
                                    	&&(Global.textFieldArray[index+1][0].getText().toString().equals("totals")))
                                    {
                                    	//Global.tallyCreated=true;
                                        Global.DeleteCol(index);
                                        Global.DeleteCol(index);
                                        //MainMenu.DisplayChart();
                                        MainMenu.DisplayDeleteItemScreen();
                                    }
                                    else
                                    {
                                    	//Global.tallyCreated=true;
                                        Global.DeleteCol(index);
                                        //MainMenu.DisplayChart();
                                        MainMenu.DisplayDeleteItemScreen();
                                    }
                                    
                                    
                                    
                                }
                            }
                                
                 
                        }
                }
        };
        
        JScrollPane deleteItemScrollPane = new JScrollPane();
        deleteItemScrollPane.setViewportView(list);
        deleteItemScrollPane.setBounds(200, 100, 1300, 300);
        
        
        deleteItemScreen.add(jlblHeading);
        deleteItemScreen.add(deleteItemScrollPane);
        deleteItemScreen.add(jbtnDelete);
        
        jbtnDelete.addActionListener(Listener);
        
        //deleteItemScreen.setVisible(true);
        
   
        return deleteItemScreen;
        
      
    }
    
    
}
	
	
	
	

    

