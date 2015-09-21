package moneyTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MTOnlineLink {

	public MTOnlineLink() throws IOException {

		URL kclLink = new URL("http://www.gamefaqs.com/gba/582399-who-wants-to-be-a-millionaire/faqs/40043");
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(kclLink.openStream(), "ISO-8859-1")));

		/*UMData stands for unmodified Data, the unmodified data is the data which
		  contains all the lines in the URL*/
		int beginningLine = 0;
		ArrayList<String> startFinder = new ArrayList<String>();
		for(int i=0;i<1926;i++)
		{
			startFinder.add(in.nextLine());
		}
		for(int i=0;i<startFinder.size();i++)
		{	
			if(!(startFinder.get(i).isEmpty()||startFinder.get(i).length()<5))
			{
				//System.out.println(i+" "+startFinder.get(i));
				if(startFinder.get(i).substring(0,3).equals("---"))
				{
					beginningLine = i+1;
					break;
				}
			}
		}
		in.close();
		
		ArrayList<String> UMData = new ArrayList<String>();
		for(int i=beginningLine;i<startFinder.size();i++)
		{	
			UMData.add(startFinder.get(i));
		}
		
		/*MQuestions stands for "modified questions", modified questions are the question
		  that do not have the "#####" code in their start*/
		ArrayList<String> MQuestions = new ArrayList<String>();
		for(int i=0;i<=UMData.size();i+=10)
		{
			try
			{
				MQuestions.add(UMData.get(i).substring(7,UMData.get(i).indexOf("?")+1));
			}
			catch(Exception e)
			{
				MQuestions.add(UMData.get(i).substring(7,UMData.get(i).length())+UMData.get(i+1).substring(6, UMData.get(i+1).indexOf("?")+1));
				i++;
			}

		} 

		/*MCorreectAnswers stands for "modified CorreectAnswers", modified CorreectAnswers are the CorreectAnswers
		  that do not have the "Answer: " String in their start */
		ArrayList<String> MCorreectAnswers = new ArrayList<String>();
		for(int i=7;i<=UMData.size();i+=10)
		{
			if(UMData.get(i).isEmpty())
			{
				i++;
				MCorreectAnswers.add(" *"+UMData.get(i).substring(UMData.get(i).indexOf(' ')+1, UMData.get(i).length()));
			}
			else
			{
				MCorreectAnswers.add(" *"+UMData.get(i).substring(UMData.get(i).indexOf(' ')+1, UMData.get(i).length()));
			}
		}

		/*MAnswersOptions stands for "modified answersOptions", modified answersOptions arrayList contains
		  the answersOptions which are taken from the UNData arrayList */
		ArrayList<String> MAnswersOptions = new ArrayList<String>();
		for(int i=0;i<=UMData.size()-1;i++)
		{
			if(UMData.get(i).isEmpty())
			{}
			else if(UMData.get(i).charAt(1) == '*')
			{
				MAnswersOptions.add(UMData.get(i));
			}

		}

		/*for(int i=0;i<UMData.size();i++)
		{
			System.out.println(i+" "+UMData.get(i));
		}
		for(int i=0;i<MQuestions.size();i++)
		{
			System.out.println(i+" "+MQuestions.get(i));
		}
			for(int i=0;i<MAnswersOptions.size();i++)
		{
			System.out.println(i+" "+MAnswersOptions.get(i));
		}
		for(int i=0;i<MCorreectAnswers.size();i++)
		{
			System.out.println(i+" "+MCorreectAnswers.get(i));
		}*/

		new MTOMethods(MQuestions,MCorreectAnswers,MAnswersOptions);


	}

}