public class ChessQueens {
    public static void main(String[] args) {
        final byte SIZE = 8;
        int[] a = new int[SIZE];
        int l;
        boolean noBeats;
        int solutionCounter = 0;
        for(int arrangement = 0; arrangement < Math.pow(SIZE, SIZE); arrangement++){
            l = arrangement;
            for(int i = 0; i < SIZE; i++){
                a[i] = l % SIZE;
                l /= SIZE;
            }
            noBeats = true;
            for(int i = 0; i < SIZE && noBeats; i++){
                for(int j = i+1; j < SIZE && noBeats; j++){
                    if(Math.abs(a[i] - a[j]) == Math.abs(i - j) || a[i] == a[j]){
                        noBeats = false;
                    }
                }
            }
            if (noBeats) {  
                System.out.printf("--------%d----------\n", ++solutionCounter);                            //print successful deck
                for(int i = 0; i< SIZE; i++){
                    for(int j = 0; j < a[i]; j++){
                        System.out.printf("o ");
                    }
                    System.out.printf("x ");
                    for(int j = a[i] + 1; j < SIZE; j++){
                        System.out.printf("o ");
                    }
                    System.out.printf("\n");
                }
            }
        }
    }    
}