/**
 * Write a description of AllCodens here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllCodens {
    public int findStopCoden(String dnaStr, int startIndex , String stopCoden ){
        int  currIndex = dnaStr.indexOf(stopCoden , startIndex + 3);
        while(currIndex != -1){
        if((currIndex - startIndex)% 3 == 0 ){
    return currIndex;
    }else{
    currIndex = dnaStr.indexOf(stopCoden , currIndex +1);
    }
}
//return dnaStr.length();
return -1;
 } 
    public String findGene(String dna ,int where  ){
        int startIndex = dna.indexOf("ATG" , where);
        if(startIndex == -1){
        return "";
    }
    int taaIndex = findStopCoden(dna, startIndex , "TAA");
    int tagIndex = findStopCoden(dna, startIndex , "TAG");
    int tgaIndex = findStopCoden(dna, startIndex , "TGA");
    //int minIndex = Math.min(taa, Math.min(tag, tga));
    //if(minIndex == dna.length()){
        // return "";
    //}else {
        // return dna.substring(startIndex , minIndex +3);
    //}
    int minIndex =0;
    if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
    minIndex = tgaIndex;
    }else{
    minIndex = taaIndex;
    }
    if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex )){
    minIndex = tagIndex;
    }
    if(minIndex == -1){
    return " ";
}else{
return dna.substring(startIndex , minIndex +3);  
}     
    }
 public void printAll(String dna){
    int startIndex = 0;
    while(true){
    String currentGene = findGene(dna, startIndex);
    if(currentGene.isEmpty()){
    break;
    }
    System.out.println(currentGene);
    startIndex = dna.indexOf(currentGene , startIndex )+ currentGene.length();
    }
    }
   public void testOn(String dna){
       System.out.println("testing Print ALL Genes on "+ dna);
       printAll(dna);
    }
    public void test(){
    testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
    testOn(" ");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }

}
 
