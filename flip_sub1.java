package flip_game;

import org.w3c.dom.ls.LSOutput;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class flip_sub1 extends JFrame implements ActionListener {
    protected JPanel panelButtons;
    JPanel panel;
    protected JPanel panelBoard;
    protected JLabel labelPlayer1Score;
    protected JLabel labelPlayer2Score;
    protected JLabel labelWinner;
    protected JLabel lableWinnerText;
    protected JButton[][] buttons = new JButton[3][4];
    protected int buttonsWidth = 100;
    protected int buttonsHight = 100;
    protected int[] GeneratedNumbers = new int[12];
    protected ImageIcon[] icons = new ImageIcon[12];
    protected ImageIcon[] newIcons=new ImageIcon[12];
    protected Timer timer;
    protected int buttonClickCounter=0;
    protected    int firstIndex1;
    protected int firstIndex2;
    protected int secondIndex1;
    protected int secondIndex2;
    protected int player1Score=0;
    protected int player2Score=0;
    protected int scoreCounter=0;
    protected String Winner;
    protected String player1;
    protected String player2;
    protected JTextField textField1;
    protected JTextField textField2;
    protected JLabel labelTextFild1;
    protected JLabel labelTextFild2;


    protected String[][] visibilityChaker=new String[3][4];
    Random random = new Random();
    protected  JLabel StartLabel;
    protected   JButton start;
    protected int[][] DoubleClickCheker= new int[3][4];

    public void setNewIcons(ImageIcon[] icons)
    {
        for(int i=0;i<icons.length;i++)
        {
            icons[i]=new ImageIcon("7.jpg");
        }
    }

    // class constractor
    flip_sub1() {
        start = new JButton("start_game");
        start.setLayout(null);
        start.setVisible(true);
        start.setBounds(300, 170, 100, 50);
        start.setFocusable(false);
        start.addActionListener(this);

        labelTextFild1=new JLabel("Name of player 1: ");
        labelTextFild1.setLayout(null);
        labelTextFild1.setBounds(3,20,190,50);
        labelTextFild1.setFont(new Font("Arial",Font.PLAIN,20));
        labelTextFild1.setForeground(Color.white);

        textField1=new JTextField();
        textField1.setLayout(null);
        textField1.setBounds(180,20,390,50);
        textField1.setFont(new Font("Mv boli",Font.PLAIN,30));
        textField1.setForeground(Color.BLACK);


        labelTextFild2=new JLabel("Name of player 2: ");
        labelTextFild2.setLayout(null);
        labelTextFild2.setBounds(3,90,190,50);
        labelTextFild2.setFont(new Font("Arial",Font.PLAIN,20));
        labelTextFild2.setForeground(Color.white);

        textField2=new JTextField();
        textField2.setLayout(null);
        textField2.setBounds(180,90,390,50);
        textField2.setFont(new Font("Mv boli",Font.PLAIN,30));
        textField2.setForeground(Color.BLACK);


        StartLabel=new JLabel();
        StartLabel.setLayout(null);
        StartLabel.setBounds(400, 200,600 , 300);
        StartLabel.setBackground(Color.BLACK);
        StartLabel.setOpaque(true);
        StartLabel.setVisible(true);

        StartLabel.add(labelTextFild1);
        StartLabel.add(textField1);
        StartLabel.add(labelTextFild2);
        StartLabel.add(textField2);
        StartLabel.add(start);



        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50, 200, 450, 350);
        panel.setBackground(Color.green);
        panel.setOpaque(true);
        panel.setVisible(false);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(panel);

        panelButtons = new JPanel();
        panelButtons.setLayout(null);
        panelButtons.setBounds(50, 200, 450, 350);
        panelButtons.setBackground(Color.white);
        panelButtons.setVisible(false);

        panelBoard = new JPanel();
        panelBoard.setLayout(null);
        panelBoard.setBounds(600, 200, 400, 350);
        panelBoard.setBackground(Color.BLACK);
        panelBoard.setVisible(false);


        labelPlayer1Score=new JLabel();
        labelPlayer1Score.setLayout(null);
        labelPlayer1Score.setBounds(30,30,340,50);
        labelPlayer1Score.setBackground(Color.white);
        labelPlayer1Score.setForeground(Color.black);
        labelPlayer1Score.setOpaque(true);
        labelPlayer1Score.setFont(new Font("Mv boli",Font.PLAIN,25));

        labelPlayer2Score=new JLabel();
        labelPlayer2Score.setLayout(null);
        labelPlayer2Score.setBounds(30,100,340,50);
        labelPlayer2Score.setBackground(Color.white);
        labelPlayer2Score.setOpaque(true);
        labelPlayer2Score.setForeground(Color.black);
        labelPlayer2Score.setFont(new Font("Mv boli",Font.PLAIN,25));

        lableWinnerText=new JLabel();
        lableWinnerText.setLayout(null);
        lableWinnerText.setBounds(150,180,100,20);
        lableWinnerText.setText("winner");
        lableWinnerText.setForeground(Color.white);
        lableWinnerText.setFont(new Font("Mv boli",Font.PLAIN,25));

        labelWinner=new JLabel();
        labelWinner.setLayout(null);
        labelWinner.setBounds(100,220,200,50);
        labelWinner.setBackground(Color.white);
        labelWinner.setText("");
        labelWinner.setOpaque(true);
        labelWinner.setForeground(Color.black);
        labelWinner.setFont(new Font("Mv boli",Font.PLAIN,25));

        panelBoard.add(labelPlayer1Score);
        panelBoard.add(labelPlayer2Score);
        panelBoard.add(lableWinnerText);
        panelBoard.add(labelWinner);



        CreateRandomNumber(GeneratedNumbers, 12);
        setButtons(buttons, 23, 23, panelButtons, buttonsHight, buttonsWidth);
        setIcons(icons, 12);
        setButtonsIcon(icons, GeneratedNumbers);


        this.add(panelButtons);
        this.add(panelBoard);
        this.add(StartLabel);
        this.pack();
    }



    // a method to set icons to ImageIcon array
    public void setIcons(ImageIcon[] icons, int size) {
        int startOver = 0;
        for (int i = 0; i < size; i++) {
            if (i < 6)
                icons[i] = new ImageIcon(i + ".jpg");
            else {
                icons[i] = new ImageIcon(startOver + ".jpg");
                startOver++;
            }
        }
    }

    public void setButtonsIcon(ImageIcon[] icons, int[] randomNumber) {
        int countIcon = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setIcon(icons[randomNumber[countIcon]]);
                visibilityChaker[i][j]=buttons[i][j].getIcon().toString();
                countIcon++;

            }

        }
    }


    // a method to generate a non-repeating random numbers between
    public void CreateRandomNumber(int[] GeneratedNumbers, int NumberofRandomNumbersWanted) {
        int counter = 0;
        while (counter < NumberofRandomNumbersWanted) {
            int randomNumber = random.nextInt(NumberofRandomNumbersWanted);
            boolean isRepetead = false;
            for (int i = 0; i < counter; i++) {
                if (GeneratedNumbers[i] == randomNumber) {
                    isRepetead = true;
                    break;
                }
            }
            if (!isRepetead) {
                GeneratedNumbers[counter] = randomNumber;
                counter++;
            }
        }
    }



    // a method to create and set buttons of our choice
    public void setButtons(JButton[][] buttons, int x_axis, int y_axis, JPanel panel, int buttonsHight, int buttonsWidth) {
        int x_axisReminder = x_axis;
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setVisible(false);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 2));
                buttons[i][j].setOpaque(true);
                buttons[i][j].setBounds(x_axis, y_axis, buttonsWidth, buttonsHight);
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
                DoubleClickCheker[i][j]=0;
                panel.add(buttons[i][j]);
                x_axis += (buttonsWidth + 1);
            }
            y_axis += (buttonsHight + 1);
            x_axis = x_axisReminder;
        }

    }





    int visiblityCounter=0;
    // @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == start) {
          panelButtons.setVisible(true);
          panelBoard.setVisible(true);
          StartLabel.setVisible(false);
          player1=textField1.getText();
          player2=textField2.getText();
          labelPlayer2Score.setText(player2 +": "+player2Score);
          labelPlayer1Score.setText( player1 +": "+player1Score);

            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[0].length; j++) {
                    buttons[i][j].setVisible(true);
                }
            }

          int countNewIcon=0;
            for (int i = 0; i < buttons.length; i++) {
                for (int j = 0; j < buttons[0].length; j++) {
                   buttons[i][j].setIcon(newIcons[countNewIcon]);
                   countNewIcon++;

                }
            }
        }
        for(int i=0;i<buttons.length;i++)
        {
            for(int j=0;j<buttons[0].length;j++)
            {
                if(e.getSource()==buttons[i][j])
                {
                    if(buttonClickCounter==0)
                      {  DoubleClickCheker[i][j]++;
                        buttonClickCounter++;
                        firstIndex1 = i;
                        firstIndex2 = j;
                        buttons[i][j].setIcon(new ImageIcon(visibilityChaker[i][j]));
                        scoreCounter++;


                      }
                    else if (buttonClickCounter==1)
                     {    DoubleClickCheker[i][j]++;
                         if(DoubleClickCheker[i][j]>=2)
                         {  DoubleClickCheker[i][j]=1;
                             break;
                         }
                         buttonClickCounter++;
                         DoubleClickCheker[i][j]=0;
                         secondIndex1=i;
                         secondIndex2=j;
                         buttons[i][j].setIcon(new ImageIcon(visibilityChaker[i][j]));

                         scoreCounter++;
                     }

                    if(buttonClickCounter==2) {
                        String button1 = visibilityChaker[firstIndex1][firstIndex2];
                        String button2 = visibilityChaker[secondIndex1][secondIndex2];

                        if (button1.equals(button2)) {
                            buttons[firstIndex1][firstIndex2].setVisible(false);
                            buttons[secondIndex1][secondIndex2].setVisible(false);
                            int temp = scoreCounter / 2;
                            if (temp % 2 != 0) {
                                player1Score++;
                                labelPlayer1Score.setText(player1+": " + player1Score);
                                scoreCounter=scoreCounter-2;
                            } else if (temp % 2 == 0) {
                                player2Score++;
                                labelPlayer2Score.setText( player2+ ": "+ player2Score);
                                scoreCounter=scoreCounter-2;
                            }

                        } else {

                            buttons[firstIndex1][firstIndex2].setIcon(new ImageIcon("7.jpg"));
                            buttons[secondIndex1][secondIndex2].setIcon(new ImageIcon("7.jpg"));
                            buttons[firstIndex1][firstIndex2].setEnabled(true);
                            buttons[secondIndex1][secondIndex2].setEnabled(true);
                         }
                        buttonClickCounter = 0;
                        }
                     }
                   }
                }
        // check if the game is ended or not
        for ( int i=0;i<buttons.length;i++)
        {
            for (int j=0;j<buttons[0].length;j++) {
                if (!buttons[i][j].isVisible()) {
                    visiblityCounter++;
                    if (visiblityCounter == 12) {
                        if (player1Score > player2Score)
                        {
                            Winner = "player1";
                            labelWinner.setText(Winner);
                        }
                        else if (player1Score < player2Score)
                        {
                            Winner = "player2";
                            labelWinner.setText(Winner);
                        }
                        else {
                            Winner = "Draw";
                            labelWinner.setText(Winner);
                        }
                    }
                }
            }
        }
        visiblityCounter=0;
    }
}





