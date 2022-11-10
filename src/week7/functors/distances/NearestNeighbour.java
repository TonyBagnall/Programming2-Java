package week7.functors.distances;

/**
 * Demo example for Distance based
 */
public class NearestNeighbour {

    public int nearestNeighbour(double[][] training, double[] test, Distance dist){
        int closest=0;
        double closestDistance=Double.MAX_VALUE;
        for(int i=0;i<training.length;i++){
            double d = dist.distance(training[i], test);
            if(d<closestDistance){
                closest=i;
                closestDistance=d;
            }
        }
        return closest;


    }



}
