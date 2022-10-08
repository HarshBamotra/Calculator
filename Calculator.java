 //Harsh Bamotra 
//Project-1 (Calculator using awt)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import result.Result;

class Calculator extends Frame implements ActionListener
    {
	String s = "" , cal = "";
	JButton b1 , b2 , b3 , b4 , b5 , b6 , b7 , b8 , b9 , b10;
	JButton b11 , b12 , b13 , b14 , b16 , b17 , b18 , b19;
	TextField t1;

	Calculator()
		{
			b1 = new JButton("1");
			b2 = new JButton("2");
			b3 = new JButton("3");
			b4 = new JButton("4");
			b5 = new JButton("5");
			b6 = new JButton("6");
			b7 = new JButton("7");
			b8 = new JButton("8");
			b9 = new JButton("9");
			b10 = new JButton("0");
			b11 = new JButton("+");
			b12 = new JButton("-");
			b13 = new JButton("x");
			b14 = new JButton("/");
			b16 = new JButton(".");
			b17 = new JButton("<--");
			b18 = new JButton("=");
			b19 = new JButton("C");

			b1.setBounds(0 , 100 , 50 , 50 );
			b2.setBounds(50 , 100 , 50 , 50 );
			b3.setBounds(100 , 100 , 50 , 50 );
			b11.setBounds(150 , 100 , 50 , 50 );
			b12.setBounds(200 , 100 , 50 , 50 );

			b4.setBounds(0 , 150 , 50 , 50 );
			b5.setBounds(50 , 150 , 50 , 50 );
			b6.setBounds(100 , 150 , 50 , 50 );
			b13.setBounds(150 , 150 , 50 , 50 );
			b14.setBounds(200 , 150 , 50 , 50 );

			b7.setBounds(0 , 200 , 50 , 50 );
			b8.setBounds(50 , 200 , 50 , 50 );
			b9.setBounds(100 , 200 , 50 , 50 );

			b16.setBounds(0 , 250 , 50 , 50 );
			b10.setBounds(50 , 250 , 50 , 50 );
			b17.setBounds(100 , 250 , 50 , 50 );
			b18.setBounds(200 , 200 , 50 , 100 );
			b19.setBounds(150 , 200 , 50 , 100 );
			
			t1 = new TextField(s);
			t1.setBounds(10 , 40 , 230 , 60);
			t1.setEditable(false);
			
			b1.addActionListener(this);b2.addActionListener(this);b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
			b6.addActionListener(this);b7.addActionListener(this);b8.addActionListener(this);b9.addActionListener(this);b10.addActionListener(this);
			b11.addActionListener(this);b12.addActionListener(this);b13.addActionListener(this);b14.addActionListener(this);
			b16.addActionListener(this);b17.addActionListener(this);b18.addActionListener(this);b19.addActionListener(this);
			

			addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent v)
						{
							dispose();
						}
				});

			add(b1) ; add(b2) ; add(b3) ; add(b11) ; add(b12) ; add(b4) ; add(b5) ; add(b6) ; add(b13) ; add(b14);
			add(b7) ; add(b8) ; add(b9) ; add(b16) ; add(b10) ; add(b17) ; add(b18); add(b19) ; add(t1);

			
			setSize(250 , 300);
			setLayout(null);
			setVisible(true);
		}
	public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==b1)
				{
					t1.setText(s=s.concat("1"));
					cal=cal.concat("1");
				}
			if(e.getSource()==b2)
				{
					t1.setText(s=s.concat("2"));
					cal=cal.concat("2");
				}
			if(e.getSource()==b3)
				{
					t1.setText(s=s.concat("3"));
					cal=cal.concat("3");
				}
			if(e.getSource()==b4)
				{
					t1.setText(s=s.concat("4"));
					cal=cal.concat("4");
				}
			if(e.getSource()==b5)
				{
					t1.setText(s=s.concat("5"));
					cal=cal.concat("5");
				}	
			if(e.getSource()==b6)
				{
					t1.setText(s=s.concat("6"));
					cal=cal.concat("6");
				}
			if(e.getSource()==b7)
				{
					t1.setText(s=s.concat("7"));
					cal=cal.concat("7");
				}
			if(e.getSource()==b8)
				{
					t1.setText(s=s.concat("8"));
					cal=cal.concat("8");
				}
			if(e.getSource()==b9)
				{
					t1.setText(s=s.concat("9"));
					cal=cal.concat("9");
				}
			if(e.getSource()==b10)
				{
					t1.setText(s=s.concat("0"));
					cal=cal.concat("0");
				}
			if(e.getSource()==b11)
				{
					t1.setText(s=s.concat("+"));
					cal=cal.concat(",+,");
				}
			if(e.getSource()==b12)
				{
					t1.setText(s=s.concat("-"));
					cal=cal.concat(",-,");
				}
			if(e.getSource()==b13)
				{
					t1.setText(s=s.concat("x"));
					cal=cal.concat(",x,");
				}
			if(e.getSource()==b14)
				{
					t1.setText(s=s.concat("/"));
					cal=cal.concat(",/,");
				}	
			if(e.getSource()==b16)
				{
					t1.setText(s=s.concat("."));
					cal=cal.concat(".");
				}
			if(e.getSource()==b17)
				{
					t1.setText(s=s.substring(0 , s.length()-1));
					cal=cal.substring(0 , s.length()-1);
				}	
			if(e.getSource()==b18)
				{
					Result obj = new Result(cal);
					if(obj.FindErrors()[0]==true)
						{
							t1.setText("Expression error !!");
							s=cal="";

						}
					else if(obj.FindErrors()[1]==true)
						{
							t1.setText("Divide by zero error !!");
							s=cal="";
						}
					else
						{
							s=cal=Double.toString(obj.FindResult());
							t1.setText(cal);
						}
				}
			if(e.getSource()==b19)
				{
					t1.setText(s="");
					cal="";
				}
		}
	public static void main(String args[])
		{
			new Calculator();
		}
    }