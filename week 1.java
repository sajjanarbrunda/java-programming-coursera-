import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
       int  count =0;
        for(Point  p : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(double length, int totalpts) {
       
        return length/totalpts;
    }

    public double getLargestSide(Shape s) {
       double large =0;
        Point prevpt = s.getLastPoint();
        for(Point p: s.getPoints()){
            double currentDist = prevpt.distance(p);
            if(large < currentDist){
               large = currentDist;

            }
             
        }
        return large;
    }

    public double getLargestX(Shape s) {
        String[][] x = s.toString;
       for(Point p : s.getPoints()){
            for(int x : p.getX()){
            if(X < x) {
                X = (int)p;
            }
           
        }
        return X;
    }

    public double getLargestPerimeterMultipleFiles() {
        double length = 0.0;
         DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            length= getPerimeter(s);
        }
       
        return length ;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int totalpts = getNumPoints(s);
        System.out.println("Total number of points = " + totalpts);
        double avgleg=getAverageLength(length,totalpts);
        System.out.println(avgleg);
        System.out.println(getLargestSide(s));
        System.out.println(getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
       System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
