importjava.util.*;
public class DNAPatternSearch
{
	public static void main(String[] args) 
{
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter DNA sequence: ");
	String dna = sc.nextLine().toUpperCase();
	System.out.print("Enter pattern: ");
	String pattern = sc.nextLine().toUpperCase();
	int count = 0;
	// Search pattern in DNA sequence
	for (inti = 0; i<= dna.length() - pattern.length(); i++) 
{
		String part = dna.substring(i, i + pattern.length());
		if (part.equals(pattern)) 	
{
		count++;
		}
	}
	System.out.println("Pattern found " + count + " times.");
	sc.close();
	}
}
OUTPUT:
Input
Enter DNA sequence: ATGCGATGATG
Enter pattern: ATG
Output
Pattern found 3 times.
