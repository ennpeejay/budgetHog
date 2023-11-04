

	

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

public class Reorder { 
    public JPanel displayReorderScreen()
    {
    	JPanel reorderItemScreen = new JPanel();
        reorderItemScreen.setLayout(null);
       // deleteItemScreen.setPreferredSize(new Dimension(1000,1000));
        reorderItemScreen.setPreferredSize(new Dimension(Global.screenWidth-50,Global.screenHeight-50));
        
        JLabel jlblMoveHeading = new JLabel("SELECT AN ITEM TO MOVE");
        jlblMoveHeading.setBounds(200, 80, 600, 20);
        //jlblMoveHeading.setSize(200,20);
        //JButton jbtnDelete = new JButton("DELETE");
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
        
        JScrollPane moveItemScrollPane = new JScrollPane();
        moveItemScrollPane.setViewportView(list);
        moveItemScrollPane.setBounds(200, 100, 1300, 300);
        //moveItemScrollPane.setSize(1000,300);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JLabel jlblInsertHeading = new JLabel("SELECT AN ITEM TO INSERT AFTER");
        jlblInsertHeading.setBounds(200, 400, 600, 20);
        
        
        
        DefaultListModel<String> model2 = new DefaultListModel<>();  
        //JList myList = new JList(); 
        JList<String> list2 = new JList<String>(model2);  
        list2.setLayoutOrientation(JList.VERTICAL);
        list2.setFont(new Font("monospaced", Font.PLAIN, 12));
        int y = 0;
        if(Global.tallyCreated == true)
        {
            y = 1;
        }
        
       
        for(int i = 0; i < Global.getNumCols(Global.textFieldArray)-y; i++)
        {
            
          
           model2.addElement(Global.FormatString(Global.textFieldArray[i][0].getText().toString(),20)
                               + Global.FormatString(Global.textFieldArray[i][1].getText().toString(),20)
                                + Global.FormatString(Global.textFieldArray[i][2].getText().toString(),20)
                                +  Global.FormatString(Global.textFieldArray[i][3].getText().toString(),20)
                                +  Global.FormatString(Global.textFieldArray[i][4].getText().toString(),20)
                                +  Global.FormatString(Global.textFieldArray[i][5].getText().toString(),20)
           						+  Global.FormatString(Global.textFieldArray[i][6].getText().toString(),20));  
           
        }
        
        JScrollPane insertItemScrollPane = new JScrollPane();
        insertItemScrollPane.setViewportView(list2);
        insertItemScrollPane.setBounds(200, 420, 1300, 300);
        
        
        JButton jbtnMove = new JButton("MOVE ITEM");
        jbtnMove.setBounds(200, 720, 600, 20);
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //JList list = new JList(myList);  
        //list.setLayoutOrientation(JList.VERTICAL);
        
        reorderItemScreen.add(jlblMoveHeading);
        reorderItemScreen.add(moveItemScrollPane);
        reorderItemScreen.add(jlblInsertHeading);
        reorderItemScreen.add(insertItemScrollPane);
        reorderItemScreen.add(jbtnMove);
        
      
        
        
        //deleteItemScreen.add(jbtnDelete);
        
        ActionListener Listener = new ActionListener() 
        {
            @Override
	        public void actionPerformed(ActionEvent event)
	        {
	        	if(event.getSource()==jbtnMove)
                        {
                            int index = list.getSelectedIndex();
                            int index2 = list2.getSelectedIndex();
                            //int tmpIndex = index;
                            //int tmpIndex2 = index2;
                            if((Global.textFieldArray[index2][0].getText().toString().equals("description"))
                            	||(Global.textFieldArray[index2][0].getText().toString().equals("totals")))
                            {
                            	index2 = index2-1;
                            }
                            if((Global.textFieldArray[index][0].getText().toString().equals("description"))
                            	||(Global.textFieldArray[index][0].getText().toString().equals("totals")))
                            {
                            	index = index-1;
                            }
                            
                            if(index==0)
                            {
                            	JOptionPane.showMessageDialog(null, "unable to move DATES column");
                            }
                            else if(index==index2)
                            {
                            	JOptionPane.showMessageDialog(null, "unable to move COLUMN to itself");
                            }
                            else if((index<index2)||(index>index2))
                            {
                            	Global.MoveCol(index, index2);
                            	MainMenu.DisplayReorderScreen();
                            }
                            	
                            	
                            	
                               
                               
                            }
                            
                                
                 
                        }
                
        };
        
       
        
        jbtnMove.addActionListener(Listener);
        
        //deleteItemScreen.setVisible(true);
        
   
        return reorderItemScreen;
        
      
    
    
    
}
	
	
	
	

    



}
