package kmp;
import java.util.Random;
import java.util.Scanner;

public class kmp 
{
	public static String randomArray(int deger)  
	{  
		Random rn = new Random();
		String str= "";
		for(int i =0; i < deger; i++)
		{
		   str += Integer.toString(rn.nextInt(2));
		}
		System.out.println(str);
		return str;  
	} 

	public static void KMP(String pattern, String text)
    {
		int N = text.length();
        int M = pattern.length();
        int longestpresuffix[] = new int[M];
        int j = 0;
        LPS(pattern, M, longestpresuffix);
        int i = 0;
        int sayac=0;
        while (i < N) 
        {
            if (pattern.charAt(j) == text.charAt(i)) 
            {
                j++;
                i++;
            }
            if (j == M) 
            {
            	sayac++;
                System.out.print((i - j+1)+" ");
                j = longestpresuffix[j - 1];
            }
  
            else if (i < N && pattern.charAt(j) != text.charAt(i)) 
            {
                if (j != 0)
                    j = longestpresuffix[j - 1];
                else
                    i = i + 1;
            }
        }
        System.out.println();
        System.out.println(sayac + " farkli eslestirme gerceklestirildi.");
    }
  
    public static void LPS(String pattern, int M, int longestpresuffix[])
    {
        int length = 0;
        int i = 1;
        longestpresuffix[0] = 0;
        while (i < M) 
        {
            if (pattern.charAt(i) == pattern.charAt(length)) 
            {
                length++;
                longestpresuffix[i] = length;
                i++;
            }
            else
            {
                if (length != 0) 
                    length = longestpresuffix[length - 1];
                else
                {
                	longestpresuffix[i] = length;
                    i++;
                }
            }
        }
    }
    
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); 
		System.out.print("N degerini giriniz:");
		int n=sc.nextInt();
		System.out.print("M degerini giriniz:");
		int m=sc.nextInt();
		System.out.println("Text:");
		String text    = randomArray(n);
		System.out.println("Pattern:");
		String pattern = randomArray(m);
		System.out.printf("Patternin bulundugu konumlar:");
		KMP(pattern,text);
	}
}
