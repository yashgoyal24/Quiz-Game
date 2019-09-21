import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import static java.lang.Thread.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
class T extends Thread{
	JLabel h;
	int lim;
	q1 pop;
	public void run()
    {
        for(int i=lim;i>=0;i--){
           
        	try{
                h.setText("Time left: "+i+" seconds");                    
                sleep(1000);
                if(lim>30)
                {lim--;run();}
               
            }
        	catch (InterruptedException ex)
        	{    
            }
        }
        pop.p.removeAll();
    	pop.p.revalidate();pop.p.repaint();
    	GridBagConstraints a=new GridBagConstraints();
    	
    	a.gridx=2;
    	a.gridy=2;
    	JLabel l3=new JLabel("TIME UP!!!");
    	l3.setFont((new Font("Serif", Font.BOLD, 50)));
    	l3.setForeground(Color.yellow);
    	pop.p.add(l3,a);
    	a.gridx=2;
    	a.gridy=4;
    	JLabel l4 = new JLabel("YOUR SCORE: "+pop.point);
    	l4.setFont((new Font("Serif", Font.BOLD,40)));
    	l4.setForeground(Color.yellow);
    	pop.p.add(l4,a);
}}
public class q1 extends JFrame
{

	//Declaring Variables
     JFrame f;
     JPanel p;
     JLabel l1;
    JButton b1,b2,b3,b4,b5,b6;
     JLabel clk;
     JLabel l2;
    String s;
    String opt[]= {"1","2","3","4"};
    int point, correct;
    
int level, qno;
T clock=new T();
	Random r = new Random();
	int lev=1,i, R=0, W=0;
	String [] questions1 = new String[5]; 
	String [] questions2 = new String[5]; 
	String [] questions3 = new String[5]; 
	String [] questions4 = new String[5]; 
	String [] questions5 = new String[5]; 
	void assign(){
		questions1[0]="What is the capital of India?";
		questions1[1]="Which fruit is known as the king of all fruits?";
		questions1[2]="Who is regarded as the father of Geometry?";
		questions2[0]="Where is the Sun Temple located?";
		questions2[1]="Where is the geographical center of India?";
		questions2[2]="When did the Second World War end?";
		questions3[0]="Which country holds the largest forest area?";
		questions3[1]="When was the Third Battle of Panipat fought?";		
		questions3[2]="Which of the following is not a permanent member in the UNSC?";
		questions4[0]="According to Hindu Mythology, how many sons did Kunti have?";
		questions4[1]="Who wrote the book 'The Adventures of Tom Sawyer?";
		questions4[2]="How many Indian citizens have won the Nobel Prize till date?";
		questions5[0]="Who is regarded as the father of Computers?";
		questions5[1]="Where was Mahatma Gandhi buried after death?";
		questions5[2]="Which was the first Indian sound film?";
		int c=r.nextInt(3);
		  s= questions1[c];
		  answers(1,c);
	}
	
    //Constructor
     q1()
    { 
        this.point = 0;
        assign();
        
        gui();
        T clock=new T();
        clock.pop = this;
    }
     
    
     
     void updateques() {
 		qno=r.nextInt(3);
 		if(lev<=5){
 		switch(lev)
 		{
 		case 1: s=questions1[qno];break;
 		case 2: s=questions2[qno];break;
 		case 3: s=questions3[qno];break;
 		case 4: s=questions4[qno];break;
 		case 5: s=questions5[qno];break;
 		}
 		clock.lim=31;
 		answers(lev,qno);
 		l1.setText(s);
 		
 	}
 		
 		}
     
      void answers(int l, int q){
    	 switch(l){
    	 case 1: {
    		 switch(q)
    		 {
    		 case 0: {opt[0]="New Delhi"; opt[1]="Mumbai"; opt[2]="Kolkata"; opt[3]="Chennai";  correct = 0; break;}
    		 case 1: {opt[0]="Chikoo"; opt[1]="Pear"; opt[2]="Mango"; opt[3]="Apple"; correct = 2; break;}
    		 case 2: {opt[0]="Pythagoras"; opt[1]="Euclid"; opt[2]="Archimedes"; opt[3]="Bhaskara II";correct =1; break;}
    		 }break;}
    	 case 2: {
    		 switch(q)
    		 {
    		 case 0: {opt[0]="Konark"; opt[1]="Haridwar"; opt[2]="Amritsar"; opt[3]="Bhubaneshwar";  correct = 0; break;}
    		 case 1: {opt[0]="Pune"; opt[1]="Nagpur"; opt[2]="Indore"; opt[3]="Bangalore"; correct = 1; break;}
    		 case 2: {opt[0]="1939"; opt[1]="1925"; opt[2]="1942"; opt[3]="1945";correct =3; break;}
    		 }break;}
    	 case 3: {
    		 switch(q)
    		 {
    		 case 0: {opt[0]="New Zealand"; opt[1]="USA"; opt[2]="Russia"; opt[3]="Australia";  correct = 2; break;}
    		 case 1: {opt[0]="1761"; opt[1]="1768"; opt[2]="1699"; opt[3]="1831"; correct = 0; break;}
    		 case 2:  {opt[0]="China"; opt[1]="Russia"; opt[2]="Germany"; opt[3]="France";  correct = 2; break;}
    		 }break;}
    	 case 4: {
    		 switch(q)
    		 {
    		 case 0: {opt[0]="6"; opt[1]="2"; opt[2]="5"; opt[3]="4";correct =3; break;}
    		 case 1: {opt[0]="Oscar Wilde"; opt[1]="Mark Twain"; opt[2]="Charles Dickens"; opt[3]="George Elliot"; correct = 1; break;}
    		 case 2: {opt[0]="6"; opt[1]="2"; opt[2]="5"; opt[3]="4";correct =2; break;}
    		 }break;}
    	 case 5:{
    		 switch(q)
    		 {
    		 case 0: {opt[0]="Steve Jobs"; opt[1]="Bill Gates"; opt[2]="John Atanasoff"; opt[3]="Charles Babbage";correct =3; break;}
    		 case 1: {opt[0]="Raj Ghat"; opt[1]="Veer Bhoomi"; opt[2]="Smriti Sthal"; opt[3]="Chaitya Bhomi"; correct = 0; break;}
    		 case 2: {opt[0]="Kalidas"; opt[1]="Raja Harishchandra"; opt[2]="Bhakta Vidur"; opt[3]="Alam Ara";correct =3; break;}
    		 }break;}
    	 }
    	 try{
    		 b1.setText(opt[0]);b1.setBackground(Color.white);
    		 b2.setText(opt[1]);b2.setBackground(Color.white);
    		 b3.setText(opt[2]);b3.setBackground(Color.white);
    		 b4.setText(opt[3]);b4.setBackground(Color.white);
    	 }
    	 catch(Exception e){}
     }
     
     
     
     //GUI Method

public void gui()
    {
        // Creating a Frame
       f=new JFrame("WELCOME TO QUIZ GAME");
       f.setVisible(true);
       f.setSize(1140,600);
       f.setLocationRelativeTo(null);
       f.setResizable(false);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
       // Creating a Panel
       p=new JPanel(new GridBagLayout());
       f.getContentPane().add(p);
       p.setBackground(Color.DARK_GRAY);
      
     //  p.setBounds(0, 0, 600, 600);
       b5=new JButton("START");
       p.add(b5);
       b5.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
				           play();
					}
				}
				);
       }
       //AFTER START BUTTON IS PRESSED

	void play(){
		
		p.remove(b5);
       l1=new JLabel(s);    
       l1.setText(s);
       l1.setForeground(Color.white);
      
       l1.setFont((new Font("Serif", Font.ROMAN_BASELINE, 30)));
       p.add(l1);
       
     clk=new JLabel();
       l2=new JLabel();
       l2.setForeground(Color.white);
       clk.setForeground(Color.white);
       //Creating Buttons
       b1=new JButton(opt[0]);
       b2=new JButton(opt[1]);
       b3=new JButton(opt[2]);
       b4=new JButton(opt[3]);
       b6=new JButton("NEXT");
       b1.setBackground(Color.white);
       b2.setBackground(Color.white);
       b3.setBackground(Color.white);
       b4.setBackground(Color.white);
      // Arranging components in Panel
    
      GridBagConstraints a=new GridBagConstraints();
       a.insets=new Insets(10,10,10,10);
       a.gridx=0;
       a.gridy=0;
       p.add(l2,a);
        l2.setText("POINTS : "+point);
      a.gridx=1;
      a.gridy=2;
      p.add(clk,a);
    
      clock.h=clk;
      clock.lim=30;
      clock.start(); 
        
        a.gridx=1;
       a.gridy=01;
        p.add(l1,a);
        
        a.gridx=0;
        a.gridy=2;
        p.add(b1,a);

         a.gridx=2;
       a.gridy=2;
        p.add(b2,a);
        
        a.gridx=0;
        a.gridy=4;
        p.add(b3,a);
        
        a.gridx=2;
        a.gridy=4;
        p.add(b4,a);
       //ACTION LISTENER ON LOCK BUTTON
       b1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						if(correct==0){
							point=point+10;
				           l2.setText("POINTS : "+point);
				           b1.setBackground(Color.GREEN);
				           
				           if(lev>5)
				        	   won();}
						else
						{	b1.setBackground(Color.RED); W=1;lost();}
					}
				}
				);
        
       b2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						if(correct==1){
							point=point+10;
					           l2.setText("POINTS : "+point);
					           b2.setBackground(Color.GREEN);
					        
					           if(lev>5)
					        	   won();}
							else
								{b2.setBackground(Color.RED);
								}W=1;lost();}
					}
				
				);
     
          
        b3.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						if(correct==2){
							point=point+10;
					           l2.setText("POINTS : "+point);
					           b3.setBackground(Color.GREEN);
					           
					           if(lev>5)
					        	   won();}
							else
							{b3.setBackground(Color.RED);
								W=1;lost();}
					}
				}
				);
        
       
        b4.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						if(correct==3){
							point=point+10;
					           l2.setText("POINTS : "+point);
					           b4.setBackground(Color.GREEN);
					       
					           if(lev>5)
					        	   won();}
							else
								{b4.setBackground(Color.RED);
								W=1;lost();
								}
					}

					
				}
				);
       
        
       //adding NEXT wala
       
       b6.setBounds(1100,600,80,20);
       b6.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						
						{updateques();
						lev++;}
					}
				}
				);
       
       a.gridx=1;
       a.gridy=6;
       a.fill= GridBagConstraints.HORIZONTAL;
       a.fill= GridBagConstraints.VERTICAL;
       p.add(b6,a);
    }
    
void won() {
	
	p.removeAll();
	p.revalidate();p.repaint();
	GridBagConstraints a=new GridBagConstraints();
	a.gridx=2;
	a.gridy=2;
	JLabel l3=new JLabel("CONGRATULATIONS!!!");
	l3.setFont((new Font("Serif", Font.BOLD, 50)));
	l3.setForeground(Color.GREEN);
	p.add(l3,a);
	a.gridx=2;
	a.gridy=4;
	JLabel l5=new JLabel("YOU WON!");
	l5.setFont((new Font("Serif", Font.BOLD,40)));
	l5.setForeground(Color.GREEN);
	p.add(l5,a);
	a.gridx=2;
	a.gridy=6;
	JLabel l4 = new JLabel("YOUR SCORE: "+point);
	l4.setFont((new Font("Serif", Font.BOLD,40)));
	l4.setForeground(Color.GREEN);
	p.add(l4,a);
	}

void lost() {
	
		p.removeAll();
		p.revalidate();p.repaint();
		GridBagConstraints a=new GridBagConstraints();
		
		a.gridx=2;
		a.gridy=2;
		JLabel l3=new JLabel("WRONG ANSWER!!!");
		l3.setFont((new Font("Serif", Font.BOLD, 50)));
		l3.setForeground(Color.RED);
		p.add(l3,a);
		a.gridx=2;
		a.gridy=4;
		JLabel l4 = new JLabel("YOUR SCORE: "+point);
		l4.setFont((new Font("Serif", Font.BOLD,40)));
		l4.setForeground(Color.red);
		p.add(l4,a);
	}
void timeup(){
	
	p.removeAll();
	p.revalidate();p.repaint();
	GridBagConstraints a=new GridBagConstraints();
	
	a.gridx=2;
	a.gridy=2;
	JLabel l3=new JLabel("TIME UP!!!");
	l3.setFont((new Font("Serif", Font.BOLD, 50)));
	l3.setForeground(Color.yellow);
	p.add(l3,a);
	a.gridx=2;
	a.gridy=4;
	JLabel l4 = new JLabel("YOUR SCORE: "+point);
	l4.setFont((new Font("Serif", Font.BOLD,40)));
	l4.setForeground(Color.yellow);
	p.add(l4,a);
}


public static void main(String args [])
{
q1 obj =new q1();
}
}
