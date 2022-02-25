
//package TicTacToe2;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Random;

//java swing adding panel and buttons
public class TTT implements ActionListener {

    public JFrame frame;
    public JButton buttonReset;
    public JButton exit;
    public JTextField OScore;
    public JTextField XScore;


    public JLabel OScorelable;
    public JLabel XScorelable;

    public JTextField text;

    public JPanel titlePanel = new JPanel();
    public JPanel buttonPanel = new JPanel();
    public JPanel scorePanel =  new JPanel();

    public JButton[] buttons= new JButton[9];
    Boolean player1_Turn;
    Random random = new Random();
    int xscore = 0;
    int oscore = 0;

    public TTT(){
        ///////////////////////////////////////////////////////////Frame
        frame = new JFrame();
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.setLayout(null);
        frame.setSize(950,800 );
        frame.setVisible(true);

        /////////////////////////////////////////////////////////TitlePanel
        titlePanel.setBackground(Color.BLUE);
        titlePanel.setBounds(0,0,800,150);
        titlePanel.setLayout(new BorderLayout());

        /////////////////////////////////////////////////////////ButtonPanel
        //buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setBounds(0, 150, 550, 500);
        buttonPanel.setLayout(new GridLayout(3,3));

        ///////////////////////////////////////////////////////// ScorePanel
        scorePanel.setBackground(Color.lightGray);
        scorePanel.setBounds(550, 150, 250, 500);
        scorePanel.setLayout(null);

        ////////////////////////////////////////////////////////////// Score lable

        XScorelable = new JLabel();
        XScorelable.setText("X Score");
        XScorelable.setBounds(50, 10,100,30);
        XScorelable.setFont(new Font("Arial",Font.BOLD,20));
        scorePanel.add(XScorelable);


        OScorelable = new JLabel();
        OScorelable.setText("O Score");
        OScorelable.setBounds(50, 100, 100, 30);
        OScorelable.setFont(new Font("Arial",Font.BOLD,20));
        scorePanel.add(OScorelable);

        ////////////////////////////////////////////////////////////// Score TextField

        //X Score
        XScore = new JTextField("0");
        XScore.setBounds(50, 40, 150, 50);
        XScore.setFont(new Font("Arial", Font.BOLD, 40));
        scorePanel.add(XScore);
        //O score
        OScore = new JTextField("0");
        OScore.setBounds(50, 140, 150,50);
        OScore.setFont(new Font("Arial", Font.BOLD, 40));
        scorePanel.add(OScore);

        ////////////////////////////////////////////////////////////// Score button
        //Reset
        buttonReset = new JButton("Reset");
        buttonReset.setBounds(50, 300, 150, 80);
        buttonReset.setFont(new Font("Arial", Font.BOLD, 40));
        scorePanel.add(buttonReset);
        buttonReset.addActionListener(new reset());
        //Exit
        exit = new JButton("Exit");
        exit.setBounds(50, 400, 150, 80);
        exit.setFont(new Font("Arial", Font.BOLD, 40));
        scorePanel.add(exit);
        exit.addActionListener(new exit());


        ///////////////////////////////////////////////////////// TextField of Title panel
        text = new JTextField();
        text.setBackground(Color.black);
        text.setForeground(Color.white);
        text.setFont(new Font("Arial",Font.BOLD,70));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic Tac Teo");
        text.setOpaque(true);
        titlePanel.add(text);


        /////////////////////////////////////////////////////////// Buttons
        for(int i=0; i<9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setBackground(Color.gray);
            buttons[i].setFont(new Font("Arial", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        ////////////////////////////////////////////////////////////////
        frame.add(scorePanel);
        frame.add(titlePanel);
        frame.add(buttonPanel);

        firstTurn();


    }

    class reset implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //buttonPanel
            //new TTT();

            buttons[0].setText("");
            buttons[1].setText("");
            buttons[2].setText("");
            buttons[3].setText("");
            buttons[4].setText("");
            buttons[5].setText("");
            buttons[6].setText("");
            buttons[7].setText("");
            buttons[8].setText("");
            buttons[9].setText("");
            //firstTurn();
//
//            for(int i=0; i<9; i++) {
//                buttons[i].setEnabled(true);
//                //buttons[i].setBackground(Color.white);
//            }

            for(int i=0; i<9; i++) {

                buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));

                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);

            }

            firstTurn();
        }
    }

    class exit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame2 = new JFrame("Exit");
            if(JOptionPane.showConfirmDialog(frame2, "Confirm You Want to Exit?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
            {
                System.exit(0);
            }
        }
    }
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<9; i++){
            if( e.getSource()==buttons[i]){
                if(player1_Turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_Turn=false;
                        text.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_Turn=true;
                        text.setText("X turn");
                        check();
                    }
                }
            }

        }

    }
    /////////////////////////////////////////////////////////////// FirstTurn

    public void firstTurn(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        if(random.nextInt(2)==0){
            player1_Turn = true;
            text.setText("X Turn");
        }
        else {
            player1_Turn = false;
            text.setText("O Turn");
        }

    }

    ///////////////////////////////////////////////////////////////////// Check
    public void check(){
        ////////////////////////////////// check X win Conditions
        if(     (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
        ){
            xWin(0,1,2);
        }

        if(     (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        ){
            xWin(3,4,5);
        }

        if(     (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWin(6,7,8);
        }
        if(     (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWin(0,3,6);
        }
        if(     (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        ){
            xWin(1,4,7);
        }
        if(     (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWin(2,5,8);
        }
        if(     (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWin(0,4,8);
        }
        if(     (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWin(2,4,6);
        }

        ///////////////////////////////////Check O win conditions
        if(     (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
        ){
            oWin(0,1,2);
        }

        if(     (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
        ){
            oWin(3,4,5);
        }

        if(     (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWin(6,7,8);
        }
        if(     (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            oWin(0,3,6);
        }
        if(     (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        ){
            oWin(1,4,7);
        }
        if(     (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWin(2,5,8);
        }
        if(     (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWin(0,4,8);
        }
        if(     (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            oWin(2,4,6);
        }
    }
    //int score = 1;
    public void xWin(int a, int b, int c)  {
//        buttons[a].setBackground(Color.GREEN);
//        buttons[b].setBackground(Color.GREEN);
//        buttons[c].setBackground(Color.GREEN);

        xscore++;
        XScore.setText(String.valueOf(xscore));
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }

        text.setText("X Win");

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(true);
            //buttons[i].setBackground(Color.white);
        }


    }
    public void oWin(int a, int b, int c){
//        buttons[a].setBackground(Color.GREEN);
//        buttons[b].setBackground(Color.GREEN);
//        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        oscore++;
        OScore.setText(String.valueOf(oscore));
        text.setText("O Win");
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(true);
            //buttons[i].setBackground(Color.white);
        }

    }

    public static void main(String[] args) {

//        new TTT();
        TTT ns = new TTT();
    }
}