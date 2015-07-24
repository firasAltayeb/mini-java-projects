package moneyTime;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;


public class moneyTimeMain {

	static questionList allQuestions = new questionList();
	static answers currentQuestionAnswers = new answers();
	static moneyTimeAudio audio = new moneyTimeAudio();
	static Random random = new Random();
	// qusListArray is an array that holds the questions provided by the questionList class.
	static String[] qusListArray = allQuestions.createArray();
	static String[] answerOptionArray;
	static String correctAnswer;
	static String currentQuestion;
	// questionCounter stores the progress of the game, the higher questionCounter becomes the closer end game gets.
	static int questionCounter = 0;
	//mistakeCounter determine the difficulty of the game, the lower the mistakeCounter becomes the harder the game gets. 
	static int mistakeCounter = 5;



	public static void main(String[] args){

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				new moneyTimeMain();

			}
		});
	}





	public moneyTimeMain(){

		//---------------------------- First Implementation of the values -------------------------------
		final int r = random.nextInt(3);
		// currentQuestion is assign a random question from the three first questions
		currentQuestion = qusListArray[r];
		// answerOptionArray is assigned an array which holds the current question's answer options by the using the currentQuestion.
		answerOptionArray = currentQuestionAnswers.getOptions(currentQuestion);
		//correctAnswer is assigned a string which holds the current question's correct answer by the using the currentQuestion.
		correctAnswer = currentQuestionAnswers.getCorrectAnswer(currentQuestion);

		//---------------------------- JFrame Implementation  -------------------------------------------
		final JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(1100, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		//-----------------------------  Jlabels --------------------------------------------------------

		//JlabelArray holds all the labels used in the class to allow the following for loops to print the labels using less repetitive code.
		JLabel[] JlabelArray = new JLabel[22];
		final JLabel copyRight = new JLabel("@FirasAltayeb");JlabelArray[0]=copyRight;
		final JLabel L100 = new JLabel("100\u00A3");JlabelArray[1]=L100;
		final JLabel L200 = new JLabel("200\u00A3");JlabelArray[2]=L200;
		final JLabel L300 = new JLabel("300\u00A3");JlabelArray[3]=L300;
		final JLabel L500 = new JLabel("500\u00A3");JlabelArray[4]=L500;
		final JLabel L1000 = new JLabel("1000\u00A3");JlabelArray[5]=L1000;
		final JLabel L2000 = new JLabel("2000\u00A3");JlabelArray[6]=L2000;
		final JLabel L4000 = new JLabel("4000\u00A3");JlabelArray[7]=L4000;
		final JLabel L8000 = new JLabel("8000\u00A3");JlabelArray[8]=L8000;
		final JLabel L16000 = new JLabel("16000\u00A3");JlabelArray[9]=L16000;
		final JLabel L32000 = new JLabel("32000\u00A3");JlabelArray[10]=L32000;
		final JLabel L64000 = new JLabel("64000\u00A3");JlabelArray[11]=L64000;
		final JLabel L125000 = new JLabel("125000\u00A3");JlabelArray[12]=L125000;
		final JLabel L250000 = new JLabel("250000\u00A3");JlabelArray[13]=L250000;
		final JLabel L500000 = new JLabel("500000\u00A3");JlabelArray[14]=L500000;
		final JLabel L1000000 = new JLabel("1000000\u00A3");JlabelArray[15]=L1000000;
		final JLabel LC= new JLabel("c.");JlabelArray[16]=LC;
		final JLabel LA = new JLabel("a.");JlabelArray[17]=LA;
		final JLabel QuestionLabel = new JLabel(currentQuestion);JlabelArray[18]=QuestionLabel;
		final JLabel lblmistakeCounter = new JLabel("MISTAKE COUNTER = 5 ");JlabelArray[19]=lblmistakeCounter;
		final JLabel LD = new JLabel("d.");JlabelArray[20]=LD;
		final JLabel LB = new JLabel("b.");JlabelArray[21]=LB;
		
		int yAxis = 480;
		int xAxis;
		//the following for loop prints the first 16 labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=0;i<=16;i++)
		{	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			JlabelArray[i].setForeground(Color.RED);
			JlabelArray[i].setBounds(0, yAxis, 120, 40);
			frame.getContentPane().add(JlabelArray[i]);
			yAxis-=30;
			
		}
	
		yAxis = 375;
		xAxis = 108;
		//the following for loop prints the last 5 labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=16;i<=21;i++)
		{	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 20));
			JlabelArray[i].setForeground(Color.WHITE);
			JlabelArray[i].setBounds(xAxis, yAxis, 950, 60);
			frame.getContentPane().add(JlabelArray[i]);
			yAxis-=100;
			if(i==19)
			{	yAxis=375;
				xAxis=570;		
			}	
		}

		//------------------------ Answer buttons variables  ------------------------------------------------

		final JButton answerButtonOne = new JButton(answerOptionArray[0]);
		answerButtonOne.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		final JButton answerButtonTwo = new JButton(answerOptionArray[1]);
		answerButtonTwo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		final JButton answerButtonThree = new JButton(answerOptionArray[2]);
		answerButtonThree.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		final JButton answerButtonFour = new JButton(answerOptionArray[3]);		
		answerButtonFour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));


		//------------------------------- Answer button one -------------------------------------------------
		yAxis=280;
		xAxis=140;
		//JButtonArray holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray = new JButton[4];
		JButtonArray[0] = answerButtonOne;
		JButtonArray[1] = answerButtonTwo;
		JButtonArray[2] = answerButtonThree;
		JButtonArray[3] = answerButtonFour;	
		//the following for loop prints the buttons in the JButtonArray with the same background and foreground but with different bounds.
		for(int i=0;i<=3;i++)
		{
			JButtonArray[i].setBounds(xAxis, yAxis, 300, 50);
			JButtonArray[i].setForeground(Color.BLACK);
			JButtonArray[i].setBackground(Color.RED);
			frame.getContentPane().add(JButtonArray[i]);
			yAxis+=100;
			if(i==1)
			{	yAxis=280;
				xAxis=620;
			}
		
		}

		answerButtonOne.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				

				if (answerButtonOne.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);

				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);

				}


			}
		});

		//--------------------------------- Answer button two -----------------------------------------------

		answerButtonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (answerButtonTwo.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);

				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);
				}


			}
		});

		//-------------------------------- Answer button three ----------------------------------------------

		answerButtonThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (answerButtonThree.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);

				}

			}
		});

		//--------------------------------- Answer button four ----------------------------------------------

		answerButtonFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (answerButtonFour.getText().equals(correctAnswer))
				{	
					questionCounter++;		
					int randNum = moneyTimeMethods.colorChanger("yellow",L100, L200, L300, L500,
							L1000, L2000, L4000, L8000, L16000, L32000
							,L64000,L125000,L250000, L500000, L1000000);
					moneyTimeMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);

				}
				else
				{
					mistakeCounter--;
					moneyTimeMethods.mistakeAdujster(lblmistakeCounter);
				}

			}
		});


		//------------------------------  Extra buttons -----------------------------------------------------
	
		JButton CollectCashButton = new JButton("Collect Cash");
		final JButton FiftyFifty = new JButton("50/50");
		final JButton Audience = new JButton("Audience");
		JButton ExitB = new JButton("Exit");
		
	
		xAxis=810;
		//JButtonArray2 holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray2 = new JButton[4];
		JButtonArray2[0] = CollectCashButton;
		JButtonArray2[1] = FiftyFifty;
		JButtonArray2[2] = Audience;
		JButtonArray2[3] = ExitB;
		//the following for loop prints the buttons in the JButtonArray2 with the same background and foreground but with different bounds.
		for(int i=0;i<=3;i++){
			JButtonArray2[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray2[i].setBounds(xAxis, 0, 270, 30);
			frame.getContentPane().add(JButtonArray2[i]);
			xAxis-=270;
		}
		// Allows the user to exit the game with the current amount of money the user has gained using questionCounter
		CollectCashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				audio.winningSound();

				switch (questionCounter){
				case 1:	JOptionPane.showMessageDialog(null, "You won 100�");System.exit(0);
				case 2:	JOptionPane.showMessageDialog(null, "You won 200�");System.exit(0);
				case 3:	JOptionPane.showMessageDialog(null, "You won 300�");System.exit(0);
				case 4: JOptionPane.showMessageDialog(null, "You won 500�");System.exit(0);
				case 5:	JOptionPane.showMessageDialog(null, "You won 1000�");System.exit(0);
				case 6:	JOptionPane.showMessageDialog(null, "You won 2000�");System.exit(0);
				case 7:	JOptionPane.showMessageDialog(null, "You won 4000�");System.exit(0);
				case 8:	JOptionPane.showMessageDialog(null, "You won 8000�");System.exit(0);
				case 9:	JOptionPane.showMessageDialog(null, "You won 16000�");System.exit(0);
				case 10: JOptionPane.showMessageDialog(null, "You won 32000�");System.exit(0);
				case 11: JOptionPane.showMessageDialog(null, "You won 64000�");System.exit(0);
				case 12: JOptionPane.showMessageDialog(null, "You won 125000�");System.exit(0);
				case 13: JOptionPane.showMessageDialog(null, "You won 250000�");System.exit(0);
				case 14: JOptionPane.showMessageDialog(null, "You won 500000�");System.exit(0);	
				case 15: JOptionPane.showMessageDialog(null, "You won 1000000�");System.exit(0);
				}

			}
		});
		
		/*Changes the background of the current question's correct answer to yellow plus one other random button,
		after the button is used the button becomes disabled*/
		FiftyFifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				if (answerButtonOne.getText().equals(correctAnswer))
				{
					answerButtonOne.setBackground(Color.YELLOW);
					answerButtonFour.setBackground(Color.YELLOW);
				}

				else if (answerButtonTwo.getText().equals(correctAnswer))
				{
					answerButtonTwo.setBackground(Color.YELLOW);
					answerButtonOne.setBackground(Color.YELLOW);
				}

				else if (answerButtonThree.getText().equals(correctAnswer))
				{
					answerButtonThree.setBackground(Color.YELLOW);
					answerButtonFour.setBackground(Color.YELLOW);
				}

				else if(answerButtonFour.getText().equals(correctAnswer))
				{
					answerButtonFour.setBackground(Color.YELLOW);
					answerButtonTwo.setBackground(Color.YELLOW);
				}

				FiftyFifty.setEnabled(false);
			}
		});
		
		
		Audience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	


				JFrame AudienceFrame = new JFrame();
				AudienceFrame.setSize(400, 300);
				AudienceFrame.setVisible(true);
				double[] values = new double[4];
				String[] names = new String[4];
				values[0] = random.nextInt(15);
				names[0] = "A";

				values[1] = random.nextInt(15);
				names[1] = "B";

				values[2] = random.nextInt(15);
				names[2] = "C";

				values[3] = random.nextInt(15);
				names[3] = "D";

				AudienceFrame.getContentPane().add(new ChartPanel(values, names, "Audience"));

				Audience.setEnabled(false);

			}
		});
		/*When ExitB is clicked the game promotes a frame asking the user if he wants to quit or not
		if the user chose yes the game will close and if the user chose no nothing will happen.*/
		ExitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				Object[] options = { "YES", "NO" };
				int optionButton = JOptionPane.showOptionDialog(frame,
						"Are you sure you wish to quit?", null,
						JOptionPane.PLAIN_MESSAGE,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[1]);

				if (optionButton == JOptionPane.YES_OPTION) {
					System.exit(0);
				}


			}
		});

		//pictureLabel stores the background picture of the game and prints it.
		JLabel pictureLabel = new JLabel("");
		pictureLabel.setHorizontalAlignment(SwingConstants.LEFT);
		Image img = new ImageIcon(this.getClass().getResource("/WM.jpg")).getImage();
		pictureLabel.setIcon(new ImageIcon(img));
		pictureLabel.setBounds(0, 30, 1080, 523);
		frame.getContentPane().add(pictureLabel);
		
	

		//-------------------------- JMenuBar --------------------------------------------------------------

		JMenuBar menuBar = new JMenuBar();
		
		JMenu difficulty = new JMenu("Difficulty");
		difficulty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		difficulty.setMnemonic(KeyEvent.VK_A);
		
		JMenu help = new JMenu("Help");
		help.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		help.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem easy = new JMenuItem("easy");
		JMenuItem hard = new JMenuItem("Hard");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem information = new JMenuItem("Information");
		
		//JMenuItemArray holds four  JMenuItem mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JMenuItem[] JMenuItemArray = new JMenuItem[4];
		JMenuItemArray[0] = easy;
		JMenuItemArray[1] = hard;
		JMenuItemArray[2] = restart;
		JMenuItemArray[3] = information;
		//the following for loop prints the JMenuItems in the JMenuItemArray with the same font and accelerator but with different bounds.
		for(int i=0;i<=3;i++){
			JMenuItemArray[i].setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
			JMenuItemArray[i].setAccelerator(KeyStroke.getKeyStroke
				(KeyEvent.VK_1,ActionEvent.ALT_MASK));	
		}
		
		
		/*The easy menuItem restarts the game with easier difficulty by assigning mistakeCounter to 10 and by
		 assigning the questionCounter to 0, all the labels which are recoloured to yellow return to
		 normal by sending them as an argument to the colorChanger method which will colour all
		 the labels to red and assign randNum to either 0 or 1 or 2 which will be used to assign a new
		 question to questionLabel and options to the answer buttons  */
		easy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				mistakeCounter = 10;
				questionCounter = 0;
				int randNum = moneyTimeMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				moneyTimeMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER = 10 ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);
			
			}

		});
		
		/*The hard menuItem restarts the game with harder difficulty by assigning mistakeCounter to 3 and by
		 assigning the questionCounter to 0, all the labels which are recoloured to yellow return to
		 normal by sending them as an argument to the colorChanger method which will colour all
		 the labels to red and assign randNum to either 0 or 1 or 2 which will be used to assign a new
		 question to questionLabel and options to the answer buttons  */
		hard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				mistakeCounter = 3;
				questionCounter = 0;
				int randNum = moneyTimeMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				moneyTimeMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER =3  ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);
				
			}

		});
		
		/*The restart menuItem restarts the game with the same difficulty by assigning mistakeCounter to 5 and by
		 assigning the questionCounter to 0, all the labels which are recoloured to yellow return to
		 normal by sending them as an argument to the colorChanger method which will colour all
		 the labels to red and assign randNum to either 0 or 1 or 2 which will be used to assign a new
		 question to questionLabel and options to the answer buttons  */
		restart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				questionCounter = 0;
				mistakeCounter = 5;
				int randNum = moneyTimeMethods.colorChanger("red",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				moneyTimeMethods.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				lblmistakeCounter.setText("MISTAKE COUNTER = 5 ");
				FiftyFifty.setEnabled(true);
				Audience.setEnabled(true);

			}

		});
		// Opens the user's browser to a URL page which shows information about the game.
		information.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Desktop.getDesktop().browse(new URL("http:en.wikipedia.org/wiki/Who_Wants_to_Be_a_Millionaire%3F ").toURI());
				}
				catch(Exception e)
				{}
			}

		});

		difficulty.add(easy);
		difficulty.add(hard);
		help.add(restart);
		help.add(information);
		menuBar.add(difficulty);
		menuBar.add(help);
		frame.setJMenuBar(menuBar);
		
	}
}