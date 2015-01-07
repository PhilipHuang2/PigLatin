import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {



public void setup() {
	String lines[] = loadStrings("LowellHymn.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
	  
	  String sentence = lines[i];
	  String delims = "[ .,?!]+";
	  String[] tokens = sentence.split(delims);
	  String[] trueSentence = new String[tokens.length];
	  for(int a = 0; a < tokens.length; a++)
	  {
	 	 trueSentence[a] = pigLatin(tokens[a]);
	  }
	  String truth ="";
	  for(int b = 0; b < trueSentence.length; b++)
	  {
	 	truth = truth + trueSentence[b] + " ";
	  }
	  System.out.println(truth);
	}
}
public void draw()
{
}

public int findFirstVowel(String word){
  char [] vowels = {'a', 'e', 'i', 'o', 'u'};
  for(int a = 0; a < word.length(); a++)
  {
      for(int b = 0; b < 5; b++)
      { 
         if(word.charAt(a) == vowels[b])
         return a;
      }
  } 
  return -1;
}


public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
	if(findFirstVowel(sWord) == -1)
	{
		return sWord + "ay";
	}
	else if (findFirstVowel(sWord) == 0)
	{
		return sWord + "way";
	}
	else if(sWord.substring(0,2).equals("qu"))
	{
        return sWord.substring(2,sWord.length()) + "quay";
	}
	else if(findFirstVowel(sWord) != 0)
	{
		 return sWord.substring(findFirstVowel(sWord) ,sWord.length()) + sWord.substring(0,findFirstVowel(sWord)) + "ay";
	}
	else	
	{
		return "ERROR!";
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
