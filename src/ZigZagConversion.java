public class ZigZagConversion {
    char[][] grid;
    int currentRow;
    int currentColumn = 0;
    int numRows;
    //could be optimised further but I am just happy that it works
    public ZigZagConversion(int numRows) {
        this.numRows = numRows;
        this.currentRow = numRows-2;
    }

    public static void main(String[] args) {
        int numRows = 491;
        System.out.println(new ZigZagConversion(numRows).convert("ligmsxkuwztqonbyqyqejsmmasmeikjwtrinqukmwdemsikjgdpsxbextqeedpcyimlygxmcbsqtabehetbdwhbqxfwcwyaekmcsloxmgnihooquityeabwzguccscgcqkxcyuqghapyphszasfctccbygdrilvbxsfxmxgwyvupfoohhtkaxocwuhnevkfudmsrkynkvhzawnifiufgkjcetrkqdskgecyqanayvzytoiyxefdorhukafadxkmbpmsrzupuuqpiypffvktorqytvaxsmlvbxpvwkkteaiobawgvgblarjtolsgzdebatyzdksjncyocwwzczkctvyhgqqgwujynhxttpcgscuuyswdsgfncfukwksugbsukqpeftkzwhwwbszvyhicmfnkpfewjzsvphbucmwyvsxwkyukhcnwhcizjpxuorqdarzcfvdcnabzavkixzehdmgoddjrubuwuuycrbehbfgcasmatshygpnkuybqbwmvskxjmcspjztmtfmnxvlemaogarwbnizhuwtgalykmrygzktwhgctjsblkxnzhmhdkamlnkxabvgahbzqjblsumegjtfshmvrohectbevykxhnyxwcirywxefqjzxwxqmevoyyuvzeugrvgqxqhvnezuwiwvgtltzijzjewikrqeoyulpbiehhadrwaapnvrygqhmnrxghbuivfzypdhwdmpcmrtbokzvbghoze",numRows));
        //System.out.println(new ZigZagConversion().getColumns(10,3));
    }

    public String printGrid(int numColumns){

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows ; i++) {
            for (int j = 0; j < numColumns; j++) {
                System.out.print(grid[i][j]);
                if (grid[i][j] != '\0') {
                    result.append(grid[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        return result.toString();
    }


    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }

        int numCols = getColumns(s.length(),numRows);
        grid = new char[numRows][numCols];
        int charIndex=0;
        while(charIndex<s.length()){
            charIndex = populateGridHorizontalDownwards(currentColumn,charIndex,s);
            charIndex = populateGridDiagonalUpwards(charIndex,s);
            currentColumn++;

        }
        return printGrid(numCols);
    }

    private int populateGridDiagonalUpwards(int charIndex, String s) {
        currentRow = numRows-2;
        while(currentRow!=0 && charIndex<s.length()){
            grid[currentRow--][++currentColumn]=s.charAt(charIndex++);
        }
        return charIndex;
    }

    private int populateGridHorizontalDownwards(int currentColumn, int charIndex, String s) {
        for (int i = 0; i < numRows; i++) {
            if(charIndex<s.length()) {
                grid[i][currentColumn] = s.charAt(charIndex++);
            }
            
        }
        return charIndex;
    }

    private int getColumns(int stringLength,int numRows){
        int sum =0;
        int cycleLength = numRows-1;
        int cycle =0;
        int column=0;
        while(sum<stringLength){
            if(cycle==cycleLength || cycle==0){
                sum+=numRows;
                cycle = 0;
            }else{
                sum++;
            }
            column++;
            cycle++;
        }
        return column;
    }
}
