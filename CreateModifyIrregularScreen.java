
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
public class CreateModifyIrregularScreen {
    
    
	
	public JPanel displayModifyIrregularScreen()
	{
           JPanel mainJPanel = new JPanel();
          
           mainJPanel.setPreferredSize(new Dimension(Global.screenWidth-50,Global.screenHeight-50));
           GridBagLayout mainGrid = new GridBagLayout();

          mainJPanel.setLayout(mainGrid);
          
          GridBagConstraints gbc = new GridBagConstraints();
         
           
         /////////////////////////////////////////////////////////////////////////////////////////   
          
           

            //////////////////////////////////////////////////////////////////////////////////////////
        
        

        //create category type label
        JLabel jlblheading = new JLabel("MODIFY IRREULAR ITEM COLUMN");
        
        JLabel padding1 = new JLabel();
        JLabel padding2 = new JLabel();
      
        //create title to report on textfield
        JTextField jtfTitle= new JTextField();
        jtfTitle.setText(Global.textFieldArray[Global.modSelIndex][6].getText().toString());
        
        //create title to report on label
        JLabel jlblTitle = new JLabel("Enter the title of this irregular items category to report on");
        
        JLabel padding6 = new JLabel();
        
        
        
        //create submit button to create column
        JButton jbtnSubmit = new JButton("Modify");
        
      //create submit button label
        JLabel jlblSubmit = new JLabel("Enter to modify this irregular item");
        
       
        
        ActionListener submitListener = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==jbtnSubmit)
                {
                    boolean valid = true;
                    String title="";
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
                         if(Global.textFieldArray[Global.modSelIndex][0].getText().toString().equals("irregular"))
                        {
                           Global.textFieldArray[Global.modSelIndex][6].setText(title);
                        Global.textFieldArray[Global.modSelIndex+1][6].setText(title); 
                        }

                         if(Global.textFieldArray[Global.modSelIndex][0].getText().toString().equals("description"))
                        {
                           Global.textFieldArray[Global.modSelIndex][6].setText(title);
                        Global.textFieldArray[Global.modSelIndex-1][6].setText(title); 
                        }



                       // MainMenu.DisplayChart();
                         CreateModifyScreen.listItemSelected = false;
                         MainMenu.DisplayModifyItemScreen();
                    }
                   
                    
                }
            }
        };
        
        jbtnSubmit.addActionListener(submitListener);
        
        gbc.gridx= 0;
        gbc.gridy=0;
        jlblheading.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(jlblheading,gbc);
        
        
        CreateModifyScreen myCreateModifyScreen = new CreateModifyScreen();
        gbc.gridx= 0;
        gbc.gridy=1;
        mainJPanel.add(myCreateModifyScreen.displayCreateModifyScreen(),gbc);
        
          
        gbc.gridx= 0;
        gbc.gridy=2;
        padding1.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(padding1,gbc);
            
        gbc.gridx= 0;
        gbc.gridy=3;
        jtfTitle.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(jtfTitle,gbc);  
        
        gbc.gridx= 0;
        gbc.gridy=4;
        jlblTitle.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(jlblTitle,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=5;
        padding2.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(padding2,gbc);
        
        gbc.gridx= 0;
        gbc.gridy=6;
        jbtnSubmit.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(jbtnSubmit,gbc);
          
        gbc.gridx= 0;
        gbc.gridy=7;
        jlblSubmit.setPreferredSize(new Dimension(400,20));
        mainJPanel.add(jlblSubmit,gbc);
            
            //CreateModifyScreen myCreateModifyScreen = new CreateModifyScreen();
           
           // mainJPanel.add(myCreateModifyScreen.displayCreateModifyScreen());
            
            //mainJPanel.add(createIrregularScreen);




            return mainJPanel;
	}
    
}

