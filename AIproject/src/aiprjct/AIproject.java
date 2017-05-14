/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiprjct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import java.util.Random;
import javax.swing.*;

/**
 *
 * @author SHAWON
 */
/**
 * It is a Java project
 */
public class AIproject extends JFrame {

    JPanel pnl = new JPanel();
    JPanel pnl1 = new JPanel();
    JPanel pnl2 = new JPanel();
    JPanel pnl3 = new JPanel();
    JPanel pnl4 = new JPanel();
    JLabel lbl = new JLabel("X");
    JLabel lbl1 = new JLabel("Y");
    JLabel lbl2 = new JLabel("DIRT");
    JLabel lbl3 = new JLabel("DIRECTION");
    JTextArea txta = new JTextArea();
    JTextField txt = new JTextField();
    JTextField txt1 = new JTextField();
    JTextField txt2 = new JTextField();
    JScrollPane spane = new JScrollPane(txta,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
    

    final static JButton[][] bt = new JButton[5][5];
    static JButton bt1 = new JButton("PRESS");
    static JButton bt2 = new JButton("SHOW");
    static JButton bt3 = new JButton("CLEAR");
    static Icon flag = new ImageIcon("/home/ahmed/Dropbox/AIproject/src/aiprjct/ps.jpg" );
    static Icon drt = new ImageIcon("/home/ahmed/Dropbox/AIproject/src/aiprjct/dirt.jpg");
    int[][] chk = new int[10][10];
    int koyta, a, b;

    AIproject() {
        JFrame fr = new JFrame("VACCUM CLEANER");

        fr.add(pnl);
        fr.setVisible(true);
        fr.setSize(550, 500);

        pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));

        pnl3.setLayout(new GridLayout(5, 5));

        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        pnl2.setLayout(null);
        pnl4.setLayout(null);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                pnl3.add(bt[i][j] = new JButton());
                bt[i][j].setBackground(Color.ORANGE);
            }

        }

        pnl.add(pnl1);
        pnl.add(pnl2);
        pnl1.setBackground(Color.WHITE);
        pnl2.setBackground(Color.GRAY);

        pnl1.add(pnl3);
        pnl1.add(pnl4);
        pnl3.setBackground(Color.WHITE);
        pnl4.setBackground(Color.DARK_GRAY);
        pnl4.add(lbl);
        pnl4.add(lbl1);
        pnl4.add(lbl2);
        pnl2.add(lbl3);
        pnl4.add(txt);
        pnl4.add(txt1);
        pnl4.add(txt2);
        pnl4.add(bt1);
        pnl4.add(bt2);
        pnl2.add(bt3);
        pnl2.add(txta);
        pnl2.add(spane);
        
        //pnl.add(spane);
        
        
        //txta.add(spane);
     

        pnl1.setPreferredSize(new Dimension(550, 250));
        pnl2.setPreferredSize(new Dimension(550, 250));
        pnl3.setPreferredSize(new Dimension(250, 250));
        pnl4.setPreferredSize(new Dimension(275, 250));

        lbl.setBounds(10, 50, 25, 15);
        txt.setBounds(30, 50, 40, 20);
        lbl1.setBounds(100, 50, 40, 20);
        txt1.setBounds(120, 50, 40, 20);
        lbl2.setBounds(85, 80, 60, 20);
        txt2.setBounds(80, 100, 50, 20);
        lbl3.setBounds(5, 20, 100, 20);
        bt1.setBounds(80, 200, 100, 30);
        bt2.setBounds(80, 160, 100, 30);
        bt3.setBounds(450, 20, 100, 30);
        txta.setBounds(10, 40, 250, 150);
        spane.setBounds(10,40,300,150);
      
        lbl.setBackground(Color.yellow);
        lbl1.setBackground(Color.yellow);
        lbl2.setBackground(Color.WHITE);
     
         

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s1, s2, s3;
                int c, range = 5, cnt = 0;
                Random rand = new Random();
                s1 = txt.getText();
                s2 = txt1.getText();
                s3 = txt2.getText();
                a = Integer.parseInt(s1);
                b = Integer.parseInt(s2);
                c = Integer.parseInt(s3);
                koyta = c;
                bt[a - 1][b - 1].setIcon(flag);
                chk[a - 1][b - 1] = -1;
                while (cnt < c) {

                    int row = rand.nextInt(range) + 0;

                    int col = rand.nextInt(range) + 0;
                    if (chk[row][col] != -1 && chk[row][col] != 1) {
                        chk[row][col] = 1;
                        bt[row][col].setIcon(drt);
                        cnt++;

                    }
                }
            }
        });

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int[] x = {0, -1, 0, 1};
                int[] y = {1, 0, -1, 0};
                String str = "";

                int cnt = 0;
                
                int d=a-1,e=b-1;
                
               // System.out.println("d= "+d+" e= "+e);
                
                int i, j, p = d, q = e;

                while (cnt < koyta) {
                    
                    for (i = 0; i < 4; i++) {
                        p = x[i] + d;
                        q = y[i] + e;
                        
                        //System.out.println("p= "+p+" q= "+q);
                         
                        if (p < 0 || p >= 5 || q < 0 || q >= 5 || chk[p][q] == -1) {
                            continue;
                        } else {

                            break;
                        }
                    }

                    if (d == p && e+1 == q) {
                       
                         str += "RIGHT";
                           //txta.append(str);
                    } else if (d == p && e-1 == q) {
                        
                         str += "LEFT";
                           //txta.append(str);

                    } else if (d-1 == p && e == q) {
                        
                        str += "UP";
                          //txta.append(str);
                    } else if (d+1 == p && e == q) {
                      
                        str += "DOWN";
                          //txta.append(str);
                    }

                    if (chk[p][q] == 1) {
                        cnt++;
                       
                        str += " --> CLEAN\n";
                         //txta.append(str);
                    } else {
                        str += "\n";
                        
                    }
                    d = p;
                    e = q;
                    chk[p][q] = -1;
                 System.out.println("" + str);
                  
                
                    //System.out.println("p= "+p+" q= "+q);
                    //str="";
                }
                
                txta.setText(str);
            }

        });

        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        bt[i][j].setIcon(null);

                        bt[i][j].setBackground(Color.ORANGE);
                        chk[i][j] = 0;

                    }

                }
                txt.setText(null);
                txt1.setText(null);
                txt2.setText(null);
                txta.setText(null);
                
                
                
                
               

                

            }
        }
        );
        
         fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    public static void main(String[] args) {

        AIproject ai = new AIproject();

    }

}
