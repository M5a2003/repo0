/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chequesprint;

/**
 *
 * @author seebdcell
 */
public class NumberToWord

{
    
	private static final String[] specialNames = { java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(""), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" THOUSAND"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" MILLION"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" BILLION"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" TRILLION"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" QUADRILLION"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" QUINTILLION") };

        private static final String[] tensNames = { java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(""), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" TEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" TWENTY"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" THIRTY"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" FOURTY"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" FIFTY"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" SIXTY"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" SEVENTY"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" EIGHTY"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" NINETY") };

        private static final String[] numNames = { java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(""), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" ONE"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" TWO"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" THREE"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" FOUR"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" FIVE"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" SIX"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" SEVEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" EIGHT"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" NINE"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" TEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" ELEVEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" TWELVE"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" THIRTEEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" FOURTEEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" FIFTEEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" SIXTEEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" SEVENTEEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" EIGHTEEN"), java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" NINETEEN") };
 
   
 

   private String convertLessThanOneThousand(int number) 
    
{ 

        String current; 
 
       if (number % 100 < 20)
        { current = numNames[number % 100]; number /= 100; }
  
      else
        {
 
	           current = numNames[number % 10];
 
	           number /= 10;
            
	           current = tensNames[number % 10] + current;
 
	           number /= 10; }
 

       if (number == 0) return current; return numNames[number] + java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString(" HUNDRED{0}"), new Object[] {current});
    }
  

  
    
    public String convert(int number)
 
   {
       
	 if (number == 0) { return java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("ZERO"); }
 
       String prefix = java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("");


        if (number < 0) { number = -number; prefix = java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("NEGATIVE"); }
  
      String current = java.util.ResourceBundle.getBundle("chequesprint/Bundle").getString("");
 
       int place = 0; 
        
do 
        { 

            int n = number % 1000;
 
            if (n != 0)
 
           { String s = convertLessThanOneThousand(n);

            current = s + specialNames[place] + current;
            }
    
    place++; number /= 1000; 
        }
 

       
        while (number > 0);
        return (prefix + current).trim();
 
  }
}

