
/**
 * Write a description of part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part2 {
 public int howMany(String a , String b ){
     int count = 0;
	int index = b.indexOf(a);
	while(true){
		if(index == -1 || index >= b.length() ){
			break;
		}
		String  found = b.substring(index , index +3);
		//System.out.println(found );
		count++;
		index = b.indexOf(a,index +3);
	}

   
return count;    
    }
    void testHowMany(){
    int result = howMany("GAA" ,"ATGAACGAATTGAATC");
    System.out.println(result);
    }
}
