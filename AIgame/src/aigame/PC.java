/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aigame;

import static aigame.AIgame.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ahmed
 */
public class PC {

    PC() {
        

    }

    void work() {

        int i, j, k;

        // Initialize Direction
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                for (k = 0; k < 8; k++) {

                    dir[i][j][k] = 0;

                }
            }
        }

        // Initialize track
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] != -1 && track[i][j] != -2) {

                    track[i][j] = 0;

                }
            }
        }

        // Count track for PC
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] == -2) {

                    //System.out.println("i = "+i+" j= "+j);
                    int cnt = 0;

                    // To Up
                    for (int y = i - 1; y >= 0; y--) {

                        if (track[y][j] == -1) {
                            cnt++;
                        } else if (track[y][j] >= 0 && cnt>0) {
                            track[y][j] += cnt;
                            dir[y][j][0] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Right
                    for (int y = j + 1; y < 8; y++) {

                        if (track[i][y] == -1) {
                            cnt++;
                        } else if (track[i][y] >= 0 && cnt>0) {
                            track[i][y] += cnt;
                            dir[i][y][3] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Down
                    for (int y = i + 1; y < 8; y++) {

                        if (track[y][j] == -1) {
                            cnt++;
                        } else if (track[y][j] >= 0 && cnt>0) {
                            track[y][j] += cnt;
                            dir[y][j][1] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To Left
                    for (int y = j - 1; y >= 0; y--) {

                        if (track[i][y] == -1) {
                            cnt++;
                        } else if (track[i][y] >= 0 && cnt>0) {
                            track[i][y] += cnt;
                            dir[i][y][2] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To UpperLeft
                    for (int y = i - 1, z = j - 1; y >= 0 && z >= 0; y--, z--) {

                        if (track[y][z] == -1) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][5] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To LowerRight
                    for (int y = i + 1, z = j + 1; y < 8 && z < 8; y++, z++) {

                        if (track[y][z] == -1) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][4] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To UpperRight
                    for (int y = i - 1, z = j + 1; y >= 0 && z < 8; y--, z++) {

                        if (track[y][z] == -1) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][7] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                    cnt = 0;

                    // To LowerLeft
                    for (int y = i + 1, z = j - 1; y < 8 && z >= 0; y++, z--) {

                        if (track[y][z] == -1) {
                            cnt++;
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][6] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                }
            }
        }

        int mx = 0;

        System.out.println("PC chal debar aage");

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] == -2) {

                    System.out.print("   " + track[i][j]);
                    
                } else if (track[i][j] == -1) {

                    System.out.print("  " + track[i][j]);
                } else {
                    System.out.print("  " + track[i][j]);
                }

                if (track[i][j] > 0) {

                    if (mx < track[i][j]) {

                        mx = track[i][j];

                    }

                }
            }

            System.out.println("");
        }

        boolean check = true;

        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                //System.out.print("*"+track[i][j]);
                if (mx == track[i][j] && mx>0) {

                    //System.out.println("mx = " + mx);
                    check = false;

                    btn[i][j].setIcon(pc);

                    //btn[i][j].setEnabled(false);

                    FinalColor[i][j] = true;

                    track[i][j] = -2;

                    //To Down
                    if (dir[i][j][0] == 1) {

                        // System.out.println("down");
                        for (int p = i + 1; p < 8; p++) {

                            if (track[p][j] == -1) {

                                btn[p][j].setIcon(pc);

                                //btn[p][j].setEnabled(false);

                                FinalColor[p][j] = true;

                                track[p][j] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To Up
                    if (dir[i][j][1] == 1) {

                        // System.out.println("up");
                        for (int p = i - 1; p >= 0; p--) {

                            if (track[p][j] == -1) {

                                btn[p][j].setIcon(pc);

                                //btn[p][j].setEnabled(false);

                                FinalColor[p][j] = true;

                                track[p][j] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    //System.out.println("dir "+dir[r][c][2]);
                    // To Right
                    if (dir[i][j][2] == 1) {

                        //System.out.println("right");
                        for (int p = j + 1; p < 8; p++) {

                            //System.out.println("r "+r+", p "+p);
                            if (track[i][p] == -1) {

                                btn[i][p].setIcon(pc);

                                //btn[i][p].setEnabled(false);

                                FinalColor[i][p] = true;

                                track[i][p] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    //System.out.println("dir = " + dir[i][j][3]);
                    // To Left
                    if (dir[i][j][3] == 1) {

                        // System.out.println("left");
                        for (int p = j - 1; p >= 0; p--) {

                            if (track[i][p] == -1) {

                                btn[i][p].setIcon(pc);

                                //btn[i][p].setEnabled(false);

                                FinalColor[i][p] = true;

                                track[i][p] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To LeftUp
                    if (dir[i][j][4] == 1) {

                        //System.out.println("leftup");
                        for (int p = i - 1, q = j - 1; p >= 0 && q >= 0; p--, q--) {

                            if (track[p][q] == -1) {

                                btn[p][q].setIcon(pc);

                                //btn[p][q].setEnabled(false);

                                FinalColor[p][q] = true;

                                track[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To RightDown
                    if (dir[i][j][5] == 1) {

                        //System.out.println("rightdown");
                        for (int p = i + 1, q = j + 1; p < 8 && q < 8; p++, q++) {

                            if (track[p][q] == -1) {

                                btn[p][q].setIcon(pc);

                                //btn[p][q].setEnabled(false);

                                FinalColor[p][q] = true;

                                track[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To RightUp
                    if (dir[i][j][6] == 1) {

                        //System.out.println("rightup");
                        for (int p = i - 1, q = j + 1; p >= 0 && q < 8; p--, q++) {

                            if (track[p][q] == -1) {

                                btn[p][q].setIcon(pc);

                                //btn[p][q].setEnabled(false);

                                FinalColor[p][q] = true;

                                track[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    // To LeftDown
                    if (dir[i][j][7] == 1) {

                        //System.out.println("leftdown");
                        for (int p = i + 1, q = j - 1; p < 8 && q >= 0; p++, q--) {

                            if (track[p][q] == -1) {

                                btn[p][q].setIcon(pc);

                                //btn[p][q].setEnabled(false);

                                FinalColor[p][q] = true;

                                track[p][q] = -2;

                            } else {
                                break;
                            }

                        }

                    }

                    break;

                }

                //break;
            }

            if (check == false) {

                break;

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

                }
            }
        }

        int cntPc = 0, cntUs = 0;

        boolean dhukse = false;

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

                if (track[i][j] > 0) {

                    dhukse = true;
                }

            }
        }

        String Us = Integer.toString(cntUs);

        String Pc = Integer.toString(cntPc);

        txt.setText(Us);

        txt1.setText(Pc);

        txt.setEditable(false);

        txt1.setEditable(false);

        // Count track for user
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                if (track[i][j] == -1) {

                    //System.out.println("i = "+i+" j= "+j);
                    int cnt = 0;

                    // To Up
                    for (int y = i - 1; y >= 0; y--) {

                        if (track[y][j] == -2) {
                            cnt++;
                        } else if (track[y][j] >= 0 && cnt>0) {
                            track[y][j] += cnt;
                            dir[y][j][0] = 1;
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
                        } else if (track[i][y] >= 0 && cnt>0) {
                            track[i][y] += cnt;
                            dir[i][y][3] = 1;
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
                        } else if (track[y][j] >= 0 && cnt>0) {
                            track[y][j] += cnt;
                            dir[y][j][1] = 1;
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
                        } else if (track[i][y] >= 0 && cnt>0) {
                            track[i][y] += cnt;
                            dir[i][y][2] = 1;
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
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][5] = 1;
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
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][4] = 1;
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
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][7] = 1;
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
                        } else if (track[y][z] >= 0 && cnt>0) {
                            track[y][z] += cnt;
                            dir[y][z][6] = 1;
                            break;
                        } else {
                            break;
                        }

                    }

                }
            }
        }

        boolean enter = false;

        //System.out.println("PC chal debar por");
        // For user's turn,set number on button
        for (i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {

                //System.out.print(" " + track[i][j]);
                if (track[i][j] > 0) {
                    enter = true;
                }

                if (track[i][j] != -1 && track[i][j] != -2 && track[i][j] != 0) {

                    String s = Integer.toString(track[i][j]);

                    btn[i][j].setText(s);

                    btn[i][j].setEnabled(true);

                }

            }

            // System.out.println("");
        }

        tag = false;

        turn.setVisible(true);

        think.setVisible(false);

        if (enter == false) {

            if (cntUs > cntPc) {

                JOptionPane.showMessageDialog(null, "You win the game \nand your score is " + Us);

            } else if (cntUs < cntPc) {
                JOptionPane.showMessageDialog(null, "AI wins the game \nand AI's score is " + Pc);
            } else {

                JOptionPane.showMessageDialog(null, "Game is Drawn");
            }
            
            endGame = true;

            AIgame.init();

        } else {
            
            
            
            AIgame.Play();
            
        }

    }

    public static void main(String[] args) {

    }

}
