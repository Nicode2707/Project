import java.util.Random;
import java.util.Scanner;
public class OIBSIP1
{
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int min=1;
        int max=100;
        int maxAtt=10;
        int sco=0;
        int roun=3;
        System.out.println("Welcome to Guess The Number Game");
        for(int i=1;i<=roun;i++)
        {
            int numToGuess=random.nextInt(max-min+1)+min;
            int att=0;
            boolean guessed=false;
            System.out.println(" Round "+i+" of "+roun);
            System.out.println("I have selected a number between "+min+" and "+max+" Can you guess it ? ");
            while(att<maxAtt)
            {
                System.out.print("Enter your guess ");
                int usGuess=scanner.nextInt();
                att++;
                if(usGuess<numToGuess)
                {
                    System.out.println(" Higher ");
                }
                else if(usGuess>numToGuess)
                {
                    System.out.println(" Lower ");
                }
                else

{
    System.out.println("Congratulations! You have guessed the number correctly ");
    guessed=true;
    sco=sco+(maxAtt-att+1);
    break;
}
}
if(!guessed)
System.out.println("Sorry , you have used all your attempts. The number was "+numToGuess);
}
System.out.println("Your current score is "+sco);
System.out.println();
System.out.println("Game Over ! Your final score is "+sco);
}
}
