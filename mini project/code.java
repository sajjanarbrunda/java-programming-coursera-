

/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

 public class BabyNames {
    public void totalBirths(FileResource fr){
        int totalNum =0;
        int totalGirl =0;
        int totalBoys =0;
    for(CSVRecord rec : fr.getCSVParser(false)){
        int numBorn = Integer.parseInt(rec.get(2));
        totalNum += numBorn;
        if(rec.get(1).equals("M")){
        totalBoys ++;
        //System.out.println("Name of boy :" + rec.get(0));
        }
        if(rec.get(1).equals("F")){
        totalGirl ++;
       // System.out.println("Name of girl " + rec.get(0));
        }
    }
    System.out.println("Total nor baby names = "+totalNum);
    System.out.println("Total nor girl Baby names =" + totalGirl);
    System.out.println("Total nor Boys Baby names =" + totalBoys);
        }
    public int getRank(int year , String name, String gender){
       FileResource fr = new FileResource("BabyNames/us_babynames_by_year/yob" + year + ".csv");
    int rank =0;
    boolean recordFound = false;
    for(CSVRecord re : fr.getCSVParser(false)){
    String currentName = re.get(0);
     // System.out.println(currentName);
    String currentGender = re.get(1);
    // System.out.println(currentGender);
    if(currentGender.equals(gender)){
    rank++;
   // System.out.println(" Rank ="+ rank);
    if(currentName.equals(name)){
    recordFound = true;
    break;
    }
      }  
    }
       if(recordFound) {
        return rank;
    }else{
        return -1;
    }
    }
    public String getName(int year , int rank, String gender){
        FileResource fr = new FileResource("BabyNames/us_babynames_by_year/yob"+ year+".csv");
        String name = "no Name";
        int currentRank = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
        String Gender = rec.get(1);
        if(Gender.equals(gender)){
        currentRank++;
    
        System.out.println(currentRank);
        if(currentRank == rank){
        name = rec.get(0);
          }    
        
        }
        }
        return name;
}
public void  WhatIsNameInYear(String name , int year , int newYear ,String gender ){
    int currentRank = getRank(year, name , gender);
   // System.out.println( "current Rank " + currentRank);
    String CurrentName = getName(newYear,currentRank,gender);
    System.out.println(name +" born in "+ year+ " would be "+ CurrentName +" if she was born in "+ newYear );
}
 public int YearOfHighestRank(String name , String gender ){
     int year = Integer.MIN_VALUE;
     int rank = Integer.MAX_VALUE;
     
     DirectoryResource dr = new DirectoryResource();
     
     for( File f : dr.selectedFiles()){
         
        int currYear = Integer.parseInt(f.getName().substring(3,7));
        int curRank = getRank(currYear , name , gender);
         if(curRank !=  -1 && curRank < rank){
            rank = curRank;
            year =  currYear;
            
            }
        
        }
        if(year == Integer.MIN_VALUE){
        return -1;
        }else{
        return year;
        }
}
public double getAverageRank(String name , String gender){

double totalRank =0;
int recordCount = 0;
DirectoryResource dr = new DirectoryResource();

for(File f : dr.selectedFiles()){
int currYear = Integer.parseInt(f.getName().substring(3,7));
int currRank = getRank(currYear , name , gender );
if(currRank != -1){

totalRank += currRank;
recordCount++;
}

}
if(recordCount == 0){
return -1.0;
}else{
return  totalRank / recordCount;
}
}
public int getTotalBirthsRankedHigher(int year , String name , String gender){
FileResource fr = new FileResource();
int rank = getRank(year, name , gender);
int totalBirths = 0;
int currentRank =0;
for(CSVRecord rec : fr.getCSVParser(false)){
String currGender = rec.get(1);
if(currGender.equals(gender)){
currentRank++;
}
if(currentRank < rank ){
int currentBirth = Integer.parseInt(rec.get(2));
totalBirths += currentBirth;
}else{
break;
}
}
return totalBirths;
}
 public void testCaseForTotalBirths(){
    FileResource fr = new FileResource();
     totalBirths(fr);
    }
 public void testCaseForRank(){
      int rank = getRank(1971,"Frank","M");
     System.out.println( "rank =" +rank);
    }
 public void testForName(){
     String name = getName(1982,450,"M");
     System.out.println("Name ="+ name);
    }
    public void testForAlterName(){ 
     WhatIsNameInYear("Susan", 1972,2014,"F");
      WhatIsNameInYear("Owen", 1974,2014,"F");
 }
  public void testForHighestRankInYear(){
    int year = YearOfHighestRank("Genevieve" , "F");
    System.out.println("Highest Rank In year " +year);
    int year1 = YearOfHighestRank("Mich" , "M");
    System.out.println("Highest Rank In year " +year1);
  
  }
  public void testForAverRank(){
  double avgRank = getAverageRank("Susan","F");
  System.out.println("Average Rank = " +avgRank);
  double avgRank1 = getAverageRank("Robert","M");
  System.out.println("Average Rank = " +avgRank1);
  }
  public void testForHigherRank(){
  int HigherRanked = getTotalBirthsRankedHigher(1990,"Emily","F");
  System.out.println("Total Births Ranked Higher ="+HigherRanked);
   int HigherRanked1 = getTotalBirthsRankedHigher(1990,"Drew","M");
  System.out.println("Total Births Ranked Higher ="+HigherRanked1);
  }
    }    

