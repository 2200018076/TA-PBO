import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Puzzle extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, sample, starB, nextPuzzle;
    Icon star;
    Icon ic0 = new ImageIcon("pic/starB0.jpg");
    Icon ic10 = new ImageIcon("pic/starB10.jpg");
    Icon ic20 = new ImageIcon("pic/starB20.jpg");
    Icon samicon1 = new ImageIcon("pic/result.jpg");
    Icon samicon2 = new ImageIcon("pic/result2.jpg");
    Icon samicon3 = new ImageIcon("pic/result3.jpg");
    Icon ic1 = new ImageIcon("pic/1.jpg");
    Icon ic2 = new ImageIcon("pic/5.jpg");
    Icon ic3 = new ImageIcon("pic/2.jpg");
    Icon ic4 = new ImageIcon("pic/7.jpg");
    Icon ic5 = new ImageIcon("pic/4.jpg");
    Icon ic6 = new ImageIcon("pic/6.jpg");
    Icon ic7 = new ImageIcon("pic/8.jpg");
    Icon ic8 = new ImageIcon("pic/9.jpg");
    Icon ic9 = new ImageIcon("pic/3.jpg");

    Icon ic11 = new ImageIcon("pic/12.jpg");
    Icon ic12 = new ImageIcon("pic/13.jpg");
    Icon ic13 = new ImageIcon("pic/16.jpg");
    Icon ic14 = new ImageIcon("pic/11.jpg");
    Icon ic15 = new ImageIcon("pic/14.jpg");
    Icon ic16 = new ImageIcon("pic/19.jpg");
    Icon ic17 = new ImageIcon("pic/17.jpg");
    Icon ic18 = new ImageIcon("pic/15.jpg");
    Icon ic19 = new ImageIcon("pic/18.jpg");

    Icon ic21 = new ImageIcon("pic/24.jpg");
    Icon ic22 = new ImageIcon("pic/25.jpg");
    Icon ic23 = new ImageIcon("pic/21.jpg");
    Icon ic24 = new ImageIcon("pic/27.jpg");
    Icon ic25 = new ImageIcon("pic/23.jpg");
    Icon ic26 = new ImageIcon("pic/29.jpg");
    Icon ic27 = new ImageIcon("pic/28.jpg");
    Icon ic28 = new ImageIcon("pic/22.jpg");
    Icon ic29 = new ImageIcon("pic/26.jpg");

    int puzzleIndex = 0;
    Icon[][] puzzles = {
            {ic1, ic2, ic3, ic4, ic5, ic6, ic7, ic8, ic9},
            {ic11, ic12, ic13, ic14, ic15, ic16, ic17, ic18, ic19},
            {ic21, ic22, ic23, ic24, ic25, ic26, ic27, ic28, ic29}
    };

    Puzzle() {
        super("Cat Puzzle");
        getContentPane().setBackground(new Color(173, 216, 230));

        b1 = new JButton(ic1);
        b1.setBounds(310, 105, 133, 133);
        b2 = new JButton(ic2);
        b2.setBounds(443, 105, 133, 133);
        b3 = new JButton(ic3);
        b3.setBounds(576, 105, 133, 133);
        b4 = new JButton(ic4);
        b4.setBounds(310, 238, 133, 133);
        b5 = new JButton(ic5);
        b5.setBounds(443, 238, 133, 133);
        b6 = new JButton(ic6);
        b6.setBounds(576, 238, 133, 133);
        b7 = new JButton(ic7);
        b7.setBounds(310, 371, 133, 133);
        b8 = new JButton(ic8);
        b8.setBounds(443, 371, 133, 133);
        b9 = new JButton(ic9);
        b9.setBounds(576, 371, 133, 133);
        sample = new JButton(samicon1);
        sample.setBounds(850, 100, 400, 400);
        JLabel l4 = new JLabel("  =============> ");
        l4.setBounds(720, 150, 170, 100);
        JLabel l1 = new JLabel("  HASIL GAMBAR > ");
        l1.setBounds(720, 200, 170, 100);
        JLabel l5 = new JLabel("  =============> ");
        l5.setBounds(720, 250, 570, 100);
        JLabel l2 = new JLabel("Potongan gambar tersebut untuk acuan berpindah => ");
        l2.setBounds(305, 15, 500, 20);
        JLabel l3 = new JLabel("Klik tombol untuk puzzle selanjutnya");
        l3.setBounds(950, 500, 250, 20);
        l3.setForeground(Color.red);

        starB = new JButton(ic0);
        starB.setBounds(630, 5, 50, 50);
        star = b9.getIcon();

        nextPuzzle = new JButton("NEXT");
        nextPuzzle.setBounds(950, 520, 170, 30);
        add(nextPuzzle);
        nextPuzzle.addActionListener(this);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(sample);
        add(l4);
        add(l1);
        add(l5);
        add(l2);
        add(starB);
        add(l3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        sample.addActionListener(this);

        setLayout(null);
        setSize(1300, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inisialisasi puzzle pertama
        setPuzzleIcons(puzzles[puzzleIndex]);
        star = b9.getIcon();
        starB.setIcon(ic0);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            moveIcon(b1);
        } else if (e.getSource() == b2) {
            moveIcon(b2);
        } else if (e.getSource() == b3) {
            moveIcon(b3);
        } else if (e.getSource() == b4) {
            moveIcon(b4);
        } else if (e.getSource() == b5) {
            moveIcon(b5);
        } else if (e.getSource() == b6) {
            moveIcon(b6);
        } else if (e.getSource() == b7) {
            moveIcon(b7);
        } else if (e.getSource() == b8) {
            moveIcon(b8);
        } else if (e.getSource() == b9) {
            moveIcon(b9);
        } else if (e.getSource() == sample) {
            changeSampleImage();
        } else if (e.getSource() == nextPuzzle) {
            changeToNextPuzzle();
        }
    }

    private void moveIcon(JButton button) {
        Icon s1 = button.getIcon();
        if (b2.getIcon() == star) {
            b2.setIcon(s1);
            button.setIcon(star);
        } else if (b1.getIcon() == star) {
            b1.setIcon(s1);
            button.setIcon(star);
        } else if (b3.getIcon() == star) {
            b3.setIcon(s1);
            button.setIcon(star);
        } else if (b4.getIcon() == star) {
            b4.setIcon(s1);
            button.setIcon(star);
        } else if (b5.getIcon() == star) {
            b5.setIcon(s1);
            button.setIcon(star);
        } else if (b6.getIcon() == star) {
            b6.setIcon(s1);
            button.setIcon(star);
        } else if (b7.getIcon() == star) {
            b7.setIcon(s1);
            button.setIcon(star);
        } else if (b8.getIcon() == star) {
            b8.setIcon(s1);
            button.setIcon(star);
        } else if (b9.getIcon() == star) {
            b9.setIcon(s1);
            button.setIcon(star);
        }
    }

    private void changeSampleImage() {
        Icon s1 = sample.getIcon();
        if (s1 == samicon3) {
            sample.setIcon(samicon1);
            setPuzzleIcons(ic1, ic2, ic3, ic4, ic5, ic6, ic7, ic8, ic9);
            star = b9.getIcon();
            starB.setIcon(ic0);
        } else if (s1 == samicon1) {
            sample.setIcon(samicon2);
            setPuzzleIcons(ic11, ic12, ic13, ic14, ic15, ic16, ic17, ic18, ic19);
            star = b6.getIcon();
            starB.setIcon(ic10);
        } else {
            sample.setIcon(samicon3);
            setPuzzleIcons(ic21, ic22, ic23, ic24, ic25, ic26, ic27, ic28, ic29);
            star = b6.getIcon();
            starB.setIcon(ic20);
        }
    }

    private void setPuzzleIcons(Icon... icons) {
        JButton[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9};
        for (int i = 0; i < icons.length; i++) {
            buttons[i].setIcon(icons[i]);
        }
    }

    private void changeToNextPuzzle() {
        puzzleIndex = (puzzleIndex + 1) % puzzles.length;
        setPuzzleIcons(puzzles[puzzleIndex]);
        star = b9.getIcon();
        starB.setIcon(ic0);
        changeSampleImage(); // Update sample image when changing to the next puzzle
    }

    public static void main(String args[]) {
        new Puzzle();
    }
}
