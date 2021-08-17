import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class encrypt {
    Scanner keyboard = new Scanner(System.in);

    public String encryptword(String cha,String b,String alphabet)
    {
        char[] originalAlphabet =alphabet.toCharArray();
        char[] givenChar= cha.toCharArray();
        StringBuilder cf= new StringBuilder();
        char[] stringtochar=b.toCharArray();
       for(int i=0;i<stringtochar.length;i++)
       {
          for(int j=0;j<originalAlphabet.length;j++)
          {
              if (originalAlphabet[j] == stringtochar[i])
              {
                  cf.append(givenChar[j]);
              }
              }
          }
       return cf.toString();
        }
      public String generator() {
          Random rand=new Random();
          ArrayList<Character> ch=new ArrayList<Character>();
          String f=" ";
          for(int i=0;i<26;i++)
          {
              char c = (char) ('a' + rand.nextInt(25));
              while(ch.contains(c))
              {
                 c= (char) ('a' + rand.nextInt(26));
              }
                f=f+c;
                  ch.add(c);
            
          }
          return f;
      }

public String customAlphabet() {
    int select;
    long geb;
    String k;
    ArrayList<String> alphabet=new ArrayList<String>();
    System.out.println("Please enter how many word with 26 character you want to generate:");
    System.out.println("In the case you dont know press 0(a defult number of words will be created:");
    geb=keyboard.nextInt();
    if(geb==0)
    {

       geb=100;
    }
    for(int g=0;g<geb;g++)
    {
        k=generator();

        if(alphabet.contains(k))
        {
            k=generator();
        }
        alphabet.add(k);
    }
    System.out.println("Please select one of the following alphabet for substitution cipher.");
    for(int i=0;i<alphabet.size();i++)
    {
        System.out.println((i+1) +". " + alphabet.get(i));
    }
    select=keyboard.nextInt();
   return alphabet.get(select-1);
}
    public String alphabetselection()
    {
        String a="";
        int x;
        System.out.println("1.Select from custom alphabet to decode/encode");
        System.out.println("2.Enter custom alphabet to decode/encode(need to have 26 letter):");
        x=keyboard.nextInt();
        if (x==1) {
            a = customAlphabet();
        }
        else if(x==2)
        {
            System.out.println("Please enter a word with 26 length");

            keyboard.nextLine();
          a=keyboard.nextLine();
          do
          {
              System.out.println("Please enter a word with 26 length");
              a=keyboard.nextLine();
          }while (a.length() != 26);
        }
    return a;
}
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        encrypt f=new encrypt();
        int num;
        String a;
        String b;
        char changeOr;
        String alphabet="abcdefghijklmnopqrstuvwxyz ";
        System.out.println("This program needs 26 letter to Encode and Decode");
        System.out.println("Please enter the string you want to encode using substitution cipher:");
        b=keyboard.nextLine();
        b.toLowerCase();
         a= f.alphabetselection();
        f.generator();
        do {
            System.out.println("Decode/Encode");
            System.out.println("1.Encode");
            System.out.println("2.Decode");
            System.out.println("3.Change String");
            System.out.println("0.Quit");
            num=keyboard.nextInt();
            if(num==1)
            {
            System.out.println("The encrypted text is");
            System.out.println(f.encryptword(a,b,alphabet));
            System.out.println("Do you want to keep this String for later on modification(Y/N):");
            System.out.println("Note:You wont be able to change the string back");
                changeOr=keyboard.next().charAt(0);
                if(changeOr =='Y')
                {
                    b=f.encryptword(a,b,alphabet);
                }

            }
            else if(num==2)
            {
                System.out.println("Do you want to change the your alphabet(Y/N)");

               changeOr=keyboard.next().charAt(0);
               if(changeOr =='Y') {
                   a = f.alphabetselection();
                   System.out.println("The decrypted text is");
                   System.out.println(f.encryptword(alphabet, b, a));
               }
               else if(changeOr == 'N') {
                   System.out.println("The decrypted text is");
                   System.out.println(f.encryptword(alphabet, b, a));
               }

            }
            else if(num==3)
            {
                System.out.println("Please enter the new string:");
                keyboard.nextLine();
                b=keyboard.nextLine();
                b.toLowerCase();
            }
        }while (num !=0);


    }

}