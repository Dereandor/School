import java.util.Random;

public class Datamengde {
    
    //Sorterngsmetode
    public static void sort(int length, int limit){
        int[] unsortedArray =  randomArray(length);
        if (unsortedArray == null || unsortedArray.length == 0) return;
        long start = System.currentTimeMillis();
        int[] sortedArray = quickSort(unsortedArray, 0, unsortedArray.length - 1, limit);
        long end = System.currentTimeMillis();
        boolean testfailed = false;
        
        for (int i = 0; i < sortedArray.length - 2; i++){
            if (!(sortedArray[i+1] >= sortedArray[i])){
                testfailed = true;
                break;
            }
        }
        if (testfailed) System.out.println("Sorting failed");
        else System.out.println("Time used: "+(end-start)+" ms. Array length: "+length+ ". Limit: "+limit);
        
        if (sortedArray.length <= 10){
            for (int i = 0; i < sortedArray.length; i++){
                System.out.println(sortedArray[i]);
            }
        }
    }
    
    //quicksortmetode for større tabeller
    private static int[] quickSort(int[] array, int left, int right, int limit){
        int i = left, j = right;
        int[] output = array;
        if ((right-left) <= limit) output = insertionSort(array, left, right); //sjekker her hvor mange sorteringer som gjenstår ift. å skifte til insert sortering
        else {
            int median = array[i + (j-i)/2];
            while(i <= j){
                while(array[i] < median) i++;
                while(array[j] > median) j--;
                if (i <= j){
                    output = changePosition(array, i, j);
                    i++;
                    j--;
                }
            }
            if(left < j) quickSort(output, left, j, limit);
            if(i < right) quickSort(output, i, right, limit);
        }
        return output;
    }
    
    //insertmetode som tar over når når det er lite sortering som gjenstår.
    private static int[] insertionSort(int[] input, int start, int end){
        int i, j;
        for (j = start + 1; j <= end; j++){
            int temp = input[j];
            i = j;
            
            while (i > start && input[i - 1] >= temp){
                input[i] = input[i -1];
                i--;
            }
            input[i] = temp;
        }
        return input;
    }
    
    //metode for bytte av posisjon i tabell
    private static int[] changePosition(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }
    
    //metode som genererer et array av bestemt lengde og fyller det med random int.
    private static int[] randomArray(int length){
        java.util.Random ran = new Random();
        int[] output = new int[length];
        for(int i = 0; i < length; i++){
            output[i] = ran.nextInt((100000) + 1);
        }
        return output;
    }
    
    public static void main(String[] args){
        int arraylength = 1000000; //bestemmer størrelsen på arrayet
        int[] limit = new int[] {10, 30, 50, 70, 100, 150, 200, 300, 400, 500, 750, 1000}; //array med forskjellige cut-offs for hvor det skal skiftes fra quicksort til insert.
        
        for (int i = 0; i < limit.length; i++){
            sort(arraylength, limit[i]);
        }
    }
}
