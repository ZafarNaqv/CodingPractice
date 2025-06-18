public class TomTomTest {
    public static void main(String[] args) {
        TomTomTest runner = new TomTomTest();
        System.out.println(runner.solution(9, 5));
    }

    public int solution(int A, int B) {
       if(A+B<4){
           return 0; //not possible to make square
       }
       int idealCut = (A+B)/4;
       int piecesA = A / idealCut;
       int piecesB = B/ idealCut;
       if(piecesA+piecesB>=4){
           return idealCut;
       }
       return idealCut-1;
    }
}
