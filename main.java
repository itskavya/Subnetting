class Ip { 
      
    // Converts IP address to the binary form 
    public static int[] bina(String[] str) 
    { 
        int re[] = new int[32]; 
        int a, b, c, d, i, rem; 
        a = b = c = d = 1; 
        Stack<Integer> st = new Stack<Integer>(); 
          
        // Separate each number of the IP address 
        if (str != null)  
        {     
            a = Integer.parseInt(str[0]); 
            b = Integer.parseInt(str[1]); 
            c = Integer.parseInt(str[2]); 
            d = Integer.parseInt(str[3]); 
        } 
          
        // convert first number to binary 
        for (i = 0; i <= 7; i++)  
        { 
            rem = a % 2; 
            st.push(rem); 
            a = a / 2; 
        } 
          
        // Obtain First octet 
        for (i = 0; i <= 7; i++) { 
            re[i] = st.pop(); 
        } 
          
        // convert second number to binary 
        for (i = 8; i <= 15; i++) { 
            rem = b % 2; 
            st.push(rem); 
            b = b / 2; 
        } 
          
        // Obtain Second octet 
        for (i = 8; i <= 15; i++) { 
            re[i] = st.pop(); 
        } 
        // convert Third number to binary 
        for (i = 16; i <= 23; i++) { 
            rem = c % 2; 
            st.push(rem); 
            c = c / 2; 
        } 
          
        // Obtain Third octet 
        for (i = 16; i <= 23; i++) { 
            re[i] = st.pop(); 
        } 
          
        // convert fourth number to binary 
        for (i = 24; i <= 31; i++) { 
            rem = d % 2; 
            st.push(rem); 
            d = d / 2; 
        } 
          
        // Obtain Fourth octet 
        for (i = 24; i <= 31; i++) { 
            re[i] = st.pop(); 
        } 
          
        return (re); 
    }
// cls returns class of given IP address 
    public static char cls(String[] str) 
    { 
        int a = Integer.parseInt(str[0]); 
        if (a >= 0 && a <= 127) 
            return ('A'); 
        else if (a >= 128 && a <= 191) 
            return ('B'); 
        else if (a >= 192 && a <= 223) 
            return ('C'); 
        else if (a >= 224 && a <= 239) 
            return ('D'); 
        else
            return ('E'); 
    }
    // Converts IP address  
    // from binary to decimal form 
    public static int[] deci(int[] bi) 
    { 
        int[] arr = new int[4]; 
        int a, b, c, d, i, j; 
        a = b = c = d = 0; 
        j = 7; 
          
        for (i = 0; i < 8; i++) { 
            a = a + (int)(Math.pow(2, j)) * bi[i]; 
            j--; 
        } 
          
        j = 7; 
        for (i = 8; i < 16; i++) { 
            b = b + bi[i] * (int)(Math.pow(2, j)); 
            j--; 
        } 
          
        j = 7; 
        for (i = 16; i < 24; i++) { 
            c = c + bi[i] * (int)(Math.pow(2, j)); 
            j--; 
        } 
          
        j = 7; 
        for (i = 24; i < 32; i++) { 
            d = d + bi[i] * (int)(Math.pow(2, j)); 
            j--; 
        } 
          
        arr[0] = a; 
        arr[1] = b; 
        arr[2] = c; 
        arr[3] = d; 
        return arr; 
    }
public static void main(String args[]) 
    { 
    
    	Scanner sc=new Scanner(System.in);
        int i; 
        String[] str = new String[4]; 
        //input the values of IP address and mask from user in the form(x.y.z.t/n) CIDR
        System.out.println("ENTER THE IP ADDRESS AND MASK(in the form(x.y.z.t/n))");
        String ipr=sc.next();
        
        System.out.println("IP address CIDR format is:" + ipr); 
          
        // Separate IP address and n 
        String[] str1 = ipr.split("/");  
          
        // IP address 
        String tr = str1[0];  
          
        // Split IP address into 4 subparts x, y, z, t 
        str = tr.split("\\.");  
  
        int[] b = new int[32]; 
  
        System.out.println(); 
          
        // Convert IP address to binary form 
        b = bina(str);  
  
        int n = Integer.parseInt(str1[1]); 
        int[] ntwk = new int[32]; 
        int[] brd = new int[32]; 
        int t = 32 - n; 
          
        // Obtanining network address 
        for (i = 0; i <= (31 - t); i++) { 
              
            ntwk[i] = b[i]; 
            brd[i] = b[i]; 
        } 
          
        // Set 32-n bits to 0 
        for (i = 31; i > (31 - t); i--) { 
              
            ntwk[i] = 0; 
        } 
          
        // Obtaining Broadcast address  
        // by setting 32-n bits to 1 
        for (i = 31; i > (31 - t); i--) { 
              
            brd[i] = 1; 
        } 
        System.out.println(); 
  
        // Obtaining class of Address 
        char c = cls(str);  
        System.out.println("Class : " + c); 
          
        // Converting network address to decimal 
        int[] nt = deci(ntwk);  
          
        // Converting broadcast address to decimal 
        int[] br = deci(brd);  
  
        // Printing in dotted decimal format  
        System.out.println("Network Address : " + nt[0]  
                     + "." + nt[1] + "." + nt[2] + "." + nt[3]);  
          
        // Printing in dotted decimal format 
        System.out.println("Broadcast Address : " 
                     + br[0] + "." + br[1] + "." + br[2] + "." + br[3]);  
    } 
}
