
public class Dummy {

	public static int numberOfDigit(int x) {
		if (x < 9)
			return 1;
		int i = 0;
		while (x >= 10) {
			x = x / 10;
			i++;
		}
		return i+1;

	}

	public static void main(String[] args) {
		System.out.println(printNextPalindrome(888));
	}
	
	
	
	static int printNextPalindrome(int n) 
    {
        int num = n;
        int temp,rev=0;
        for (int i = num+1; i >= num; i++) 
        {
            temp = i;
            rev = 0;
            while (temp != 0) 
            {
                int remainder = temp % 10;
                rev = rev * 10 + remainder;
                temp = temp / 10;
            }
            if (rev == i) 
            {
                break;
            }
        }
        return rev;
    }
}
