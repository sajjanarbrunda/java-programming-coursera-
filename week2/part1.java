
/**
 * Write a description of FindGeneWhile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneWhile {
    public String findGene(String dna ){
        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        while(currIndex != -1){
        if((currIndex - startIndex) % 3 == 0){
        return dna.substring(startIndex , currIndex);
    }else{
        currIndex = dna.indexOf("TAA", currIndex+1);
    }
    }
    return " ";    
        
    }
     void testSimpleGene(){
        String DNA = "ATGCGTAATATGGT";
        System.out.println("DNA String =" +DNA);
        String Gene = findGene(DNA);
        System.out.println("Gene =" + Gene );
        
         String DNA1 = "ATGCGTAGTATGGT";
        System.out.println("DNA String =" +DNA1);
        String Gene1 = findGene(DNA1);
        System.out.println("Gene =" + Gene1 );
        
         String DNA2 = "ATCGGTAATATGGT";
        System.out.println("DNA String =" +DNA2);
        String Gene2 = findGene(DNA2);
        System.out.println("Gene =" + Gene2 );
        
        
         String DNA3 = "ATGCTGTAATATGGT";
        System.out.println("DNA String =" +DNA3);
        String Gene3 = findGene(DNA3);
        System.out.println("Gene =" + Gene3 );
        
         String DNA4 = "ATGCGTCGCGTCTAATATGGT";
        System.out.println("DNA String =" +DNA4);
        String Gene4 = findGene(DNA4);
        System.out.println("Gene =" + Gene4 );
    }

}
   
