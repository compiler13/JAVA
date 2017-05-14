/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aigame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author ahmed
 */
public class AIgame extends JFrame {

    JPanel pnl = new JPanel();
    JPanel pnl1 = new JPanel();
    JPanel pnl2 = new JPanel();
    static JLabel lbl = new JLabel("COUNT");
    static JLabel lbl1 = new JLabel(" USER :");
    static JLabel lbl2 = new JLabel("      PC :");
    static JLabel turn = new JLabel("USER's Turn...");
    static JLabel think = new JLabel("PC's Turn...");

    static JTextField txt = new JTextField("");
    static JTextField txt1 = new JTextField("");
    final static JButton[][] btn = new JButton[8][8];
    //static JButton btn1 = new JButton();
    static JButton btn2 = new JButton("INSTRUCTION");
    static JButton btn3 = new JButton("RESTART");
    static JButton credit = new JButton("CREDIT");
    //JComboBox<String> comb = new JComboBox<String>();
    static Icon pc = new ImageIcon("/home/ahmed/Dropbox/AIgame/src/aigame/pc.jpg");
    static Icon user = new ImageIcon("/home/ahmed/Dropbox/AIgame/src/aigame/user.jpg");
    static int[][] track = new int[8][8];
    static int[][][] dir = new int[8][8][8];

    static boolean[][] FinalColor = new boolean[8][8];

    static boolean tag = false;

    static boolean endGame = false;

    AIgame() {

        JFrame fr = new JFrame("REVERSI");

        Font font1 = new Font("Lucida Sans", Font.BOLD, 15);

        fr.add(pnl);
        pnl.add(pnl1);
        pnl.add(pnl2);
        pnl2.add(btn2);
        pnl2.add(btn3);
        pnl2.add(credit);
        pnl2.add(lbl);
        pnl2.add(turn);
        pnl2.add(think);

        pnl2.add(lbl1);
        pnl2.add(lbl2);
        pnl2.add(txt);
        pnl2.add(txt1);
        pnl2.setLayout(null);

        pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
        pnl1.setLayout(new GridLayout(8, 8));

        pnl1.setPreferredSize(new Dimension(450, 450));
        pnl2.setPreferredSize(new Dimension(500, 250));
        btn2.setBounds(5, 170, 130, 30);
        lbl.setBounds(315, 10, 60, 20);
        txt.setBounds(370, 50, 100, 20);
        lbl1.setBounds(300, 50, 60, 20);
        lbl2.setBounds(300, 90, 60, 20);
        turn.setBounds(15, 2, 150, 40);
        think.setBounds(15, 2, 200, 40);
        btn3.setBounds(150, 170, 100, 30);
        txt1.setBounds(370, 90, 100, 20);
        credit.setBounds(260, 170, 130, 30);

        pnl1.setBackground(Color.GRAY);
        pnl2.setBackground(Color.GRAY);
        lbl.setBackground(Color.YELLOW);

        lbl.setFont(font1);
        lbl1.setFont(font1);
        lbl2.setFont(font1);

        turn.setFont(font1);
        think.setFont(font1);
        txt.setFont(font1);
        txt1.setFont(font1);
        
        turn.setForeground(Color.BLACK);
        think.setForeground(Color.BLACK);
        lbl.setForeground(Color.BLACK);
        lbl1.setForeground(Color.BLACK);
        lbl2.setForeground(Color.BLACK);

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                
                pnl1.add(btn[i][j] = new JButton());
                //btn[i][j].setHorizontalAlignment(0);
                //btn[i][j].setHorizontalTextPosition(0);
                //btn[i][j].setVerticalAlignment(0);
                //btn[i][j].setVerticalTextPosition(0);
                btn[i][j].setBackground(Color.ORANGE);

                FinalColor[i][j] = false;
            }
        }

        btn2.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {

                JOptionPane.showMessageDialog(null, "Use your mouse to place user signed logo on\n"
                        + "the board. You may place a logo anywhere on\n"
                        + "the board, as long as it surrounds a group\n"
                        + "of PC's logo on opposite sides.You can\n"
                        + "surround PC's logo horizontally, vertically\n"
                        + "or diagonally. After you place your logo,PC's\n"
                        + "logos that you surrounded will flip over to\n"
                        + "your logo. Try to end the game with as many\n"
                        + "logos of your's as possible! Have Fun... :)");

            }
        }
        );

        btn3.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {

                init();

                Play();

            }
        }
        );
        
        credit.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {

                JOptionPane.showMessageDialog(null, "1.Enamul Haque\n   Reg: 2012331520.\n"
                        + "2.Shahnawaz Hossan\n   Reg: 2012331531.\n"
                        + "3.Sovon Shahriar\n   Reg: 2012331538.");

            }
        }
        );

        fr.setSize(500, 700);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fr.setVisible(true);

        fr.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Lucida Fax", Font.BOLD, 16)));

        AIgame game = new AIgame();

        init();

        Play();

    }

    public static void init() {
        
        System.out.println("Dhukse");

        int i, j, k;

        tag = false;

        endGame = false;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                track[i][j] = 0;

                btn[i][j].setIcon(null);

                btn[i][j].setText(null);

                btn[i][j].setEnabled(true);

                btn[i][j].setBackground(Color.ORANGE);

                FinalColor[i][j] = false;

                dir[i][j][0] = 0;
                dir[i][j][1] = 0;
                dir[i][j][2] = 0;
                dir[i][j][3] = 0;
                dir[i][j][4] = 0;
                dir[i][j][5] = 0;
                dir[i][j][6] = 0;
                dir[i][j][7] = 0;
            }
        }

        btn[3][3].setIcon(pc);
        btn[3][4].setIcon(user);
        btn[4][3].setIcon(user);
        btn[4][4].setIcon(pc);

        track[3][3] = -2;
        track[4][4] = -2;
        track[3][4] = -1;
        track[4][3] = -1;

        FinalColor[3][3] = true;
        FinalColor[3][4] = true;
        FinalColor[4][3] = true;
        FinalColor[4][4] = true;

        // Initialize Direction
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                for (k = 0; k < 8; k++) {

                    dir[i][j][k] = 0;

                }
            }
        }

        // Count track for user
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] == -1) {

                    //System.out.println("track i = " + i + " j= " + j);
                    int cnt = 0;

                    // To Up
                    for (int y = i - 1; y >= 0; y--) {

                        if (track[y][j] == -2) {
                            cnt++;
                        } else if (track[y][j] >= 0 && cnt > 0) {
                            track[y][j] += cnt;
                            dir[y][j][0] = 1;
                            //System.out.println("Down = i " + y + ", j " + j);
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Right
                    for (int y = j + 1; y < 8; y++) {

                        if (track[i][y] == -2) {
                            cnt++;
                        } else if (track[i][y] >= 0 && cnt > 0) {
                            track[i][y] += cnt;
                            dir[i][y][3] = 1;
                            //System.out.println("Left = i " + i + ", j " + y);
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Down
                    for (int y = i + 1; y < 8; y++) {

                        if (track[y][j] == -2) {
                            cnt++;
                        } else if (track[y][j] >= 0 && cnt > 0) {
                            track[y][j] += cnt;
                            dir[y][j][1] = 1;
                            //System.out.println("Up = i " + y + ", j " + j);
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Left
                    for (int y = j - 1; y >= 0; y--) {

                        if (track[i][y] == -2) {
                            cnt++;
                        } else if (track[i][y] >= 0 && cnt > 0) {
                            track[i][y] += cnt;
                            dir[i][y][2] = 1;
                            //System.out.println("Right = i " + i + ", j " + y);
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To UpperLeft
                    for (int y = i - 1, z = j - 1; y >= 0 && z >= 0; y--, z--) {

                        if (track[y][z] == -2) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt > 0) {
                            track[y][z] += cnt;
                            dir[y][z][5] = 1;
                            //System.out.println("RightDown = i " + y + ", j " + z);
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To LowerRight
                    for (int y = i + 1, z = j + 1; y < 8 && z < 8; y++, z++) {

                        if (track[y][z] == -2) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt > 0) {
                            track[y][z] += cnt;
                            dir[y][z][4] = 1;
                            //System.out.println("LeftUp = i " + y + ", j " + z);
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To UpperRight
                    for (int y = i - 1, z = j + 1; y >= 0 && z < 8; y--, z++) {

                        if (track[y][z] == -2) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt > 0) {
                            track[y][z] += cnt;
                            dir[y][z][7] = 1;
                            //System.out.println("LeftDown = i " + y + ", j " + z);
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To LowerLeft
                    for (int y = i + 1, z = j - 1; y < 8 && z >= 0; y++, z--) {

                        if (track[y][z] == -2) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt > 0) {
                            track[y][z] += cnt;
                            dir[y][z][6] = 1;
                            //System.out.println("RightUp = i " + y + ", j " + z);
                            break;
                        } else {
                            break;
                        }

                    }

                }
            }
        }

        // For user's turn,set number on button
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                //System.out.print(" "+track[i][j]);
                if (track[i][j] != -1 && track[i][j] != -2 && track[i][j] != 0) {

                    String s = Integer.toString(track[i][j]);

                    btn[i][j].setText(s);

                }

            }

            //System.out.println("");
        }
        
        txt.setText("2");
        
        txt1.setText("2");

    }

    public static void Play() {

        int i, j, cntPc = 0, cntUs = 0, move = 0;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] == -1) {
                    cntUs++;
                } else if (track[i][j] == -2) {
                    cntPc++;
                }

                if (track[i][j] == -1 || track[i][j] == -2 || track[i][j] == 0) {

                    //btn[i][j].setEnabled(false);
                }

            }
        }

        String Us = Integer.toString(cntUs);

        String Pc = Integer.toString(cntPc);

        txt.setText(Us);

        txt1.setText(Pc);

        txt.setEditable(false);

        txt1.setEditable(false);

        //System.out.println(""+tag);
        if (tag == true) {

            tag = false;

            turn.setVisible(false);

            think.setVisible(true);

            if (endGame == false) {

                TimeForPc tm = new TimeForPc();

                PC nw = new PC();

                nw.work();
            }

        } // Button actions
        else {

            turn.setVisible(true);

            think.setVisible(false);
            
            final boolean check = false;

            for (i = 0; i < 8; i++) {

                for (j = 0; j < 8; j++) {

                    final int r = i, c = j;

                   // if (FinalColor[r][c] == false && track[r][c] > 0) {

                        btn[r][c].addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {

                                //System.out.println("r = " + r + ", c = " + c);
                                if (FinalColor[r][c] == false && track[r][c] > 0) {

                                    btn[r][c].removeActionListener(this);

                                    ActionCheck(r, c);
                                    
                                    //check = true;
                                    //break;
                                }
                            }
                        });

                   // }
                   
                   if(check==true){
                       
                       break;
                   }

                }
                
                if(check==true){
                    
                    break;
                }
            }
        }
    }

    public static void ActionCheck(int r, int c) {

        System.out.println("User clicks r=" + r + " , c = " + c);

        btn[r][c].setText(null);
        
        btn[r][c].setIcon(user);
        
        //btn[r][c].setIcon(pc);

        //btn[r][c].setEnabled(false);

        //btn[r][c].removeActionListener();
        track[r][c] = -1;

        FinalColor[r][c] = true;

        //System.out.println("" + tag);
        //To Down
        if (dir[r][c][0] == 1) {

            System.out.println("Down");

            for (int p = r + 1; p < 8; p++) {

                if (track[p][c] == -2) {

                    btn[p][c].setIcon(user);

                    //btn[p][c].setEnabled(false);

                    FinalColor[p][c] = true;

                    track[p][c] = -1;

                } else {
                    break;
                }

            }

        }

        // To Up
        if (dir[r][c][1] == 1) {

            System.out.println("Up");

            for (int p = r - 1; p >= 0; p--) {

                if (track[p][c] == -2) {

                    btn[p][c].setIcon(user);

                    //btn[p][c].setEnabled(false);

                    FinalColor[p][c] = true;

                    track[p][c] = -1;

                } else {
                    break;
                }

            }

        }

        //System.out.println("dir "+dir[r][c][2]);
        // To Right
        if (dir[r][c][2] == 1) {

            System.out.println("Right");

            for (int p = c + 1; p < 8; p++) {

                //System.out.println("r "+r+", p "+p);
                if (track[r][p] == -2) {

                    btn[r][p].setIcon(user);

                    //btn[r][p].setEnabled(false);

                    FinalColor[r][p] = true;

                    track[r][p] = -1;

                } else {
                    break;
                }

            }

        }

        // To Left
        if (dir[r][c][3] == 1) {

            System.out.println("Left");

            for (int p = c - 1; p >= 0; p--) {

                if (track[r][p] == -2) {

                    btn[r][p].setIcon(user);

                    //btn[r][p].setEnabled(false);

                    FinalColor[r][p] = true;

                    track[r][p] = -1;

                } else {
                    break;
                }

            }

        }

        // To LeftUp
        if (dir[r][c][4] == 1) {

            System.out.println("LeftUp");

            for (int p = r - 1, q = c - 1; p >= 0 && q >= 0; p--, q--) {

                if (track[p][q] == -2) {

                    btn[p][q].setIcon(user);

                    //btn[p][q].setEnabled(false);

                    FinalColor[p][q] = true;

                    track[p][q] = -1;

                } else {
                    break;
                }

            }

        }

        // To RightDown
        if (dir[r][c][5] == 1) {

            System.out.println("RightDown");

            for (int p = r + 1, q = c + 1; p < 8 && q < 8; p++, q++) {

                if (track[p][q] == -2) {

                    btn[p][q].setIcon(user);

                    //btn[p][q].setEnabled(false);

                    FinalColor[p][q] = true;

                    track[p][q] = -1;

                } else {
                    break;
                }

            }

        }

        // To RightUp
        if (dir[r][c][6] == 1) {

            System.out.println("RightUp");

            for (int p = r - 1, q = c + 1; p >= 0 && q < 8; p--, q++) {

                if (track[p][q] == -2) {

                    btn[p][q].setIcon(user);

                    //btn[p][q].setEnabled(false);

                    FinalColor[p][q] = true;

                    track[p][q] = -1;

                } else {
                    break;
                }

            }

        }

        // To LeftDown
        if (dir[r][c][7] == 1) {

            System.out.println("LeftDown");

            for (int p = r + 1, q = c - 1; p < 8 && q >= 0; p++, q--) {

                if (track[p][q] == -2) {

                    btn[p][q].setIcon(user);

                    //btn[p][q].setEnabled(false);

                    FinalColor[p][q] = true;

                    track[p][q] = -1;

                } else {
                    break;
                }

            }

        }

        for (int p = 0; p < 8; p++) {
            for (int q = 0; q < 8; q++) {

                if (track[p][q] > 0) {

                    dir[p][q][0] = 0;
                    dir[p][q][1] = 0;
                    dir[p][q][2] = 0;
                    dir[p][q][3] = 0;
                    dir[p][q][4] = 0;
                    dir[p][q][5] = 0;
                    dir[p][q][6] = 0;
                    dir[p][q][7] = 0;

                    track[p][q] = 0;

                    btn[p][q].setText(null);

                }
            }
        }

        int i, j, cntPc = 0, cntUs = 0;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] == -1) {
                    cntUs++;
                } else if (track[i][j] == -2) {
                    cntPc++;
                }

                if (track[i][j] == -1 || track[i][j] == -2 || track[i][j] == 0) {

                    //btn[i][j].setEnabled(false);
                }

            }
        }

        String Us = Integer.toString(cntUs);

        String Pc = Integer.toString(cntPc);

        txt.setText(Us);

        txt1.setText(Pc);

        txt.setEditable(false);

        txt1.setEditable(false);

        if (endGame == false) {

            tag = true;
        }

        Play();
    }

}