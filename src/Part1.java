public class Part1{
    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
            int start = startIndex;
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
    public static String findGene(String dna, int where) {
        int startIndex = dna.indexOf("atg", where);
            if (startIndex == -1) {
                return "";
            }
            int stopTaa = findStopCodon(dna, startIndex, "taa");
            int stopTag = findStopCodon(dna, startIndex, "tag");
            int stopTga = findStopCodon(dna, startIndex, "tga");
            int stopCodon = Math.min(stopTga, Math.min(stopTaa, stopTag));
            if (stopCodon > startIndex && stopCodon < dna.length() + 1) {
               return dna.substring(startIndex, stopCodon + 3);
            }
        return "";
    }
    public static void printAllGenes(String dna){
           int startIndex = 0;
           int currIndex;
           while (startIndex != -1) {
               currIndex = startIndex;
               String currGene = findGene(dna, currIndex);
               if (currGene.isEmpty()) {
                   break;
               }
               System.out.println(currGene);
               startIndex = dna.indexOf(currGene, startIndex + currGene.length());
               System.out.println(startIndex);
           }
           System.out.println(startIndex);
    }
    public static void main(String[]args){
        String dna = "atgaaatgaatgtgtaaatgcatgccctaatgcgatagatgtaaatgtgtgaatgccctaaatgaaatgaatgttttagatgaatgaatgtagatgttctaaatgaaaataaatgtgggtgaatgtttttag";
        printAllGenes(dna);
    }
}
