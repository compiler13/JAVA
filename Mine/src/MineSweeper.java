
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Pabon
 */
public class MineSweeper extends JFrame {

    JPanel pnl = new JPanel();
    JPanel pnl1 = new JPanel();
    JPanel pnl2 = new JPanel();
    JPanel pnl3 = new JPanel();
    JPanel pnl4 = new JPanel();
    JPanel pnl5 = new JPanel();
    JPanel pnl6 = new JPanel();
    JPanel pnl7 = new JPanel();
    JPanel pnl8 = new JPanel();

    JLabel jlab0 = new JLabel(" ");
    JLabel jlab = new JLabel("Time Counter");
    JLabel jlab1 = new JLabel(" ");
    JLabel jlab2 = new JLabel(" ");
    JLabel jlab3 = new JLabel(" ");
    JLabel jlab4 = new JLabel(" ");
    JLabel jlab5 = new JLabel(" ");
    JLabel jlab6 = new JLabel(" ");
    JLabel jlab7 = new JLabel(" ");
    JLabel jlab8 = new JLabel(" ");
    JLabel jlab9 = new JLabel(" ");
    JLabel jlab10 = new JLabel(" ");
    JLabel jlab11 = new JLabel(" ");

    final static JButton[][] buttons = new JButton[10][10];
    static char[][] mines = new char[10][10];
    static int[][] countMine = new int[10][10];

    static boolean[][] FinalColor = new boolean[10][10];

    static int[] X = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] Y = {0, 1, 1, 1, 0, -1, -1, -1};

    static int cnt = 1;

    static Timer timer;

    static int g = 1;

    static boolean tag = false;

    static JTextField jtxt = new JTextField();

    static JButton btn1 = new JButton("How To Play");
    static JButton btn2 = new JButton("Credit");
    static JButton btn3 = new JButton("New Game");

    static Icon flag = new ImageIcon("C:\\Users\\Shahnawaz Hossan\\Dropbox\\Java Practice\\Mine\\src\\Flag.png");
    static Icon bomb = new ImageIcon("C:\\Users\\Shahnawaz Hossan\\Dropbox\\Java Practice\\Mine\\src\\Mine.png");

    MineSweeper() {

        JFrame fr = new JFrame("MineSweeper Game");

        fr.add(pnl);

        /* Start Working in Panel */
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

        pnl.add(pnl1);

        pnl.add(pnl2);

        pnl1.setBackground(Color.WHITE);

        pnl2.setBackground(Color.DARK_GRAY);

        pnl1.setPreferredSize(new Dimension(400, 450));

        pnl2.setPreferredSize(new Dimension(125, 125));

        pnl1.setLayout(new GridLayout(10, 10));

        for (int i = 0; i <= 9; i++) {

            for (int j = 0; j <= 9; j++) {

                pnl1.add(buttons[i][j] = new JButton());

                buttons[i][j].setBackground(Color.lightGray);
            }
        }

        pnl2.setLayout(new BoxLayout(pnl2, BoxLayout.X_AXIS));

        pnl2.add(pnl3);

        pnl2.add(pnl4);

        pnl3.setLayout(new BoxLayout(pnl3, BoxLayout.X_AXIS));

        pnl3.add(pnl7);

        pnl3.add(pnl8);

        pnl7.setLayout(new BoxLayout(pnl7, BoxLayout.Y_AXIS));

        pnl7.add(jlab0);

        pnl7.add(jlab);

        jlab.setFont(new Font("Times New Roman", Font.BOLD, 14));

        pnl7.add(jtxt);

        jtxt.setFont(new Font("Times New Roman", Font.BOLD, 16));

        pnl7.add(jlab1);

        pnl7.add(jlab2);

        pnl7.add(jlab3);

        pnl7.add(jlab4);

        pnl7.add(jlab5);

        pnl7.add(jlab6);

        pnl7.add(jlab7);

        pnl7.add(jlab8);

        pnl7.add(jlab9);

        // pnl7.add(jlab10);
        //pnl7.add(jlab11);
        pnl4.setLayout(new BoxLayout(pnl4, BoxLayout.X_AXIS));

        pnl4.add(pnl5);

        pnl4.add(pnl6);

        pnl6.setLayout(new BoxLayout(pnl6, BoxLayout.Y_AXIS));

        pnl6.add(jlab6);

        pnl6.add(btn1);

        pnl6.add(jlab7);

        pnl6.add(btn2);

        pnl6.add(jlab8);

        pnl6.add(btn3);

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "The game is played by revealing squares \n"
                        + "of the grid by clicking or otherwise \n"
                        + "indicating each square. If a square \n"
                        + "containing a mine is revealed, the \n"
                        + "player loses the game. If no mine is \n"
                        + "revealed, a digit is instead displayed \n"
                        + "in the square, indicating how many \n"
                        + "adjacent squares contain mines; \n"
                        + "if no mines are adjacent, the square \n"
                        + "becomes blank, and all adjacent squares \n"
                        + "will be recursively revealed. The player \n"
                        + "uses this information to deduce the \n"
                        + "contents of other squares.The game is \n"
                        + "won when all mine free squares are revealed,\n"
                        + "because all mines have been located.\n"
                        + "There have 14 mines in the grid.\nHave Fun...");
            }

        });

        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "1.Shahnawaz Hossan\nREG:2012331531\n2.Enamul Haque Shawon\nREG:2012331520\n3.Mohaiminul Islam\nREG:2012331503");
            }

        });

        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                for (int i = 0; i <= 9; i++) {

                    for (int j = 0; j <= 9; j++) {

                        buttons[i][j].setText(null);

                        buttons[i][j].setIcon(null);

                        buttons[i][j].setBackground(Color.lightGray);
                    }
                }

                setMine();

                selectStart();

                timer.stop();

                g = 1;

                tag = false;

                jtxt.setText(null);
            }

        });

        pnl5.setPreferredSize(new Dimension(150, 150));

        pnl8.setPreferredSize(new Dimension(150, 150));

        pnl5.setBackground(Color.DARK_GRAY);
        pnl6.setBackground(Color.DARK_GRAY);
        pnl7.setBackground(Color.WHITE);
        pnl8.setBackground(Color.DARK_GRAY);

        fr.setSize(650, 650);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fr.setVisible(true);

        fr.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Times New Roman", Font.BOLD, 18)));

        MineSweeper mineSweeper = new MineSweeper();

        setMine();

        selectStart();

        Play();

    }

    public static void setMine() {

        int i, j;

        Random rand = new Random();

        boolean[][] color = new boolean[10][10];

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                countMine[i][j] = 0;
                color[i][j] = false;
                mines[i][j] = 'O';
            }
        }

        int counter = 0;

        while (counter < 14) {

            int range = 10;

            int row = rand.nextInt(range) + 0;

            int col = rand.nextInt(range) + 0;

            if (color[row][col] == false) {

                color[row][col] = true;

                mines[row][col] = '*';

                counter++;

            }
        }

        for (i = 0; i < 10; i++) {

            for (j = 0; j < 10; j++) {

                if (mines[i][j] != '*') {
                    mines[i][j] = 'O';
                }
            }
        }

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {

                if (mines[i][j] == '*') {

                    countMine[i][j] = -1;

                    koytaMine(i, j);
                }

            }
        }

//        System.out.println("");
//
//        int cntr = 0;
//
//        for (i = 0; i < 10; i++) {
//
//            for (j = 0; j < 10; j++) {
//
//                System.out.print(" " + countMine[i][j]);
//            }
//            System.out.println("");
//        }
    }

    public static void selectStart() {

        Random rand = new Random();

        int i, j;

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                FinalColor[i][j] = false;
            }
        }

        int counter = 0;

        while (counter < 1) {

            int range = 10;

            int row = rand.nextInt(range) + 0;

            int col = rand.nextInt(range) + 0;

            if (mines[row][col] == '*') {
                continue;
            } else {

                counter++;

                buttons[row][col].setText("Start");

                buttons[row][col].setBackground(Color.ORANGE);
            }
        }
    }

    public static void StartTimer() {

        ActionListener timertask = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                jtxt.setText("" + g);

                g++;
            }

        };

        timer = new Timer(1000, timertask);

        timer.start();

    }

    public static void Play() {

        int i, j;

        for (i = 0; i <= 9; i++) {

            for (j = 0; j <= 9; j++) {

                final int r = i, c = j;

                if (FinalColor[r][c] == false) {

                    buttons[r][c].addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {

                            buttonActionToCheck(r, c);

                            if (tag == false && FinalColor[r][c] == true) {

                                StartTimer();

                                tag = true;

                            }
                        }
                    });
                }
            }
        }
    }

    public static void koytaMine(int i, int j) {

        int k, x, y;

        for (k = 0; k < 8; k++) {
            x = i + X[k];
            y = j + Y[k];
            if ((x >= 0 && x < 10) && (y >= 0 && y < 10)) {
                if (mines[x][y] != '*') {
                    countMine[x][y]++;
                }
            }
        }
    }

    public static void buttonActionToCheck(int r, int c) {

        int i, j;

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (FinalColor[i][j] == true) {
                    cnt++;
                }
            }
        }

        //System.out.println("" + cnt);

        String s;

        if (countMine[r][c] == -1) {

            timer.stop();

            for (i = 0; i < 10; i++) {
                for (j = 0; j < 10; j++) {
                    if (countMine[i][j] == -1) {
                        buttons[i][j].setIcon(bomb);
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Sorry You loose");

            g = 1;

            tag = false;

            for (i = 0; i <= 9; i++) {

                for (j = 0; j <= 9; j++) {

                    buttons[i][j].setText(null);

                    buttons[i][j].setIcon(null);

                    buttons[i][j].setBackground(Color.lightGray);
                }
            }

            cnt = 1;

            setMine();

            selectStart();

            jtxt.setText(null);

            return;

        } else if (cnt == 86) {

            timer.stop();

            s = String.valueOf(countMine[r][c]);

            buttons[r][c].setBackground(Color.WHITE);

            buttons[r][c].setText(s);

            FinalColor[r][c] = true;

            for (i = 0; i < 10; i++) {
                for (j = 0; j < 10; j++) {
                    if (countMine[i][j] == -1) {
                        buttons[i][j].setIcon(flag);
                    }
                }
            }

            g = 1;

            String print = jtxt.getText();

            JOptionPane.showMessageDialog(null, "You win the game.\nYou take " + print + " seconds to complete the game.");

            cnt = 1;

            tag = false;

            for (i = 0; i <= 9; i++) {

                for (j = 0; j <= 9; j++) {

                    buttons[i][j].setText(null);

                    buttons[i][j].setIcon(null);

                    buttons[i][j].setBackground(Color.lightGray);
                }
            }

            setMine();

            selectStart();

            jtxt.setText(null);

            return;

        } else if (countMine[r][c] > 0) {

            s = String.valueOf(countMine[r][c]);

            buttons[r][c].setBackground(Color.WHITE);

            buttons[r][c].setText(s);

            FinalColor[r][c] = true;

            cnt = 1;

            return;

        } else if (countMine[r][c] == 0) {

            buttons[r][c].setBackground(Color.WHITE);

            buttons[r][c].setText(null);

            AnotherCall(r, c);

            cnt = 1;

            return;
        }
    }

    public static void AnotherCall(int r, int c) {

        if ((r < 0 || r >= 10 || c < 0 || c >= 10)) {
            return;
        }

        if (FinalColor[r][c] == true) {
            return;
        }

        if (countMine[r][c] > 0) {

            FinalColor[r][c] = true;

            buttons[r][c].setBackground(Color.WHITE);

            String s = String.valueOf(countMine[r][c]);

            buttons[r][c].setText(s);

            return;
        }

        if (countMine[r][c] == -1) {
            return;
        }

        FinalColor[r][c] = true;

        buttons[r][c].setBackground(Color.WHITE);

        if (countMine[r][c] == 0) {

            AnotherCall(r, c + 1);
            AnotherCall(r, c - 1);
            AnotherCall(r + 1, c);
            AnotherCall(r - 1, c);
            AnotherCall(r + 1, c + 1);
            AnotherCall(r - 1, c - 1);
            AnotherCall(r + 1, c - 1);
            AnotherCall(r - 1, c + 1);
        }

    }
}
