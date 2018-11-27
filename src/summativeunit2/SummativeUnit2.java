 /*
 * Gavin Scott
 * Get offensive data 
 */

package summativeunit2;

/**
 *
 * @author gasco1246
 */

import java.util.Scanner;
public class SummativeUnit2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //variable declaration
        boolean cont = true, menu = true;
        Scanner put = new Scanner(System.in);
        int[] ab = new int[162],h = new int[162],twoB = new int[162],threeB = new int[162],hr = new int[162],bb = new int[162];
        int c = 0;
        int let = 0;
        int choice = 0;
        //input all variable and store
        while (cont == true){
            
            System.out.println("How many at bats did you have?");
            ab[c] = put.nextInt();
           
            System.out.println("How many at hits did you have?");
            h[c] = put.nextInt();
            
            System.out.println("How many at doubles did you have?");
            twoB[c] = put.nextInt();
            
            System.out.println("How many at triples did you have?");
            threeB[c] = put.nextInt();
            
            System.out.println("How many at home runs did you have?");
            hr[c] = put.nextInt();
            
            System.out.println("How many at walks did you have?");
            bb[c] = put.nextInt();
            
            System.out.println("Do you want to continue?");
            System.out.println("Type 1 to continue, type 0 to stop entering variables.");
            
            let = put.nextInt();
            switch(let){
                case 1:
                    cont = true;
                    c++;
                   
                    break;
                case 0:
                    cont = false;//end value collection menu
                    break;
            
            }
        }
        int abT = 0, hT = 0, twoBT = 0, threeBT = 0, hrT = 0, bbT = 0;
        
        //empty all arrays and fill them into totals
        for (int i = 0; i <= h.length-1; i++) {
            abT = abT + ab[i];

        }

        for (int i = 0; i <= h.length - 1; i++) {
            hT = hT + h[i];

        }

        for (int i = 0; i <= twoB.length - 1; i++) {
            twoBT = twoBT + twoB[i];

        }

        for (int i = 0; i <= threeB.length - 1; i++) {
            threeBT = threeBT + threeB[i];

        }

        for (int i = 0; i <= hr.length - 1; i++) {
            hrT = hrT + hr[i];

        }

        for (int i = 0; i <= bb.length - 1; i++) {
            bbT = bbT + bb[i];

        }
                   
             
                    
                    
                    
        while(menu == true){
            System.out.println("What stat would you like to see?");
            System.out.println("Type 1 for At bats");
            System.out.println("Type 2 for hits");
            System.out.println("Type 3 for doubles");
            System.out.println("Type 4 for triples");
            System.out.println("Type 5 for home runs");
            System.out.println("Type 6 for walks");
            System.out.println("Type 7 for your on base percentage");
            System.out.println("Type 8 for your slugging percentage");
            System.out.println("Type 9 for your OPS");
            System.out.println("End program");
            choice = put.nextInt();
            //print values
            switch(choice){
                case 1:
                    System.out.println(abT);
                    break;
                case 2:
                    System.out.println(hT);
                    break;
                case 3: 
                    System.out.println(twoBT);
                    break;
                case 4:
                    System.out.println(threeBT);
                    break;
                case 5:
                   System.out.println(hrT);
                    break;
                case 6:
                    System.out.println(bbT);
                    break;
                case 7:
                    System.out.println(SLG(abT,  bases(hT, twoBT, threeBT, hrT) ));
                    //call slugging percentage method
                    break;
                case 8:
                    System.out.println(OBP (bbT,hT,abT));
                    //call on base percentage method
                    break;
                case 9:
                    System.out.println(OPS( OBP (bbT,hT,abT),  SLG(abT,  bases( hT, twoBT, threeBT, hrT) ) ));
                    //call on base plus slugging method
                    break;
                case 10:
                    menu = false;//end program
                    break;
                    
            }
        }   
        
        
    }

    /**
     * This method calculates OPS which is on base percentage plus slugging percentage
     * 
     * @param obp
     * @param slg
     * @return 
     */
    public static double OPS(double obp, double slg){
        
        double ops;
        ops = obp+slg;
        return(ops);
    }
    
    /**
     * This method calculates the slugging percentage which is total bases divided by at bats
     * @param atBat
     * @param bases
     * @return 
     */
    public static double SLG(int atBat, int bases){
        double slg;
        
        slg = bases/((double)atBat);
        return(slg);
    }
    /**
     * This method calculates on base percentage which is hits plus walks divided by at bats
     * @param walks
     * @param hits
     * @param atBat
     * @return 
     */
    public static double OBP(int walks,int hits, int atBat){
        double obp;
        obp = walks+hits;
        obp = obp/atBat;
        
        return(obp);
    }
    
    /**
     * This method calculates total bases due to hits
     * @param hit
     * @param doubles
     * @param triple
     * @param homeRun
     * @return 
     */
    public static int bases( int hit,int doubles,int triple, int homeRun){
        
        int basesT;
        int singles;
        singles = hit-doubles-triple-homeRun;//get singles from hits
        
        //multiply number of kind of hit by number of bases
        basesT = singles;
        basesT = basesT+ doubles*2;
        basesT = basesT+triple*3;
        basesT = basesT+homeRun*4;
       
     
        
        return(basesT);
    }
    
}



