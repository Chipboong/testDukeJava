import edu.duke.*;
import java.io.*;
public class Part1{
		public static int findStopCodon(String dna, int startIndex, String stopCodon) {
            int start = dna.indexOf("atg");
            int stop = dna.indexOf(stopCodon, startIndex+3);
            if ((start - stop) % 3 == 0) {
                return stop;
            } else {
                return dna.length();
            }
        }
    public static void findStopCodon() {
        String dna = "atgcgatgaattacttaaasss";
        findStopCodon(dna, 0, "taa");
        System.out.println(findStopCodon(dna, 0, "taa"));
        System.out.println(dna.substring(0,findStopCodon(dna, 0, "taa")+3));
    }
    public static void main(String[]args){
            findStopCodon();

    }
}