class ArrayOperations {
    
    public static int[][][] createCube() {
        int[][][] array = new int[3][3][3];
        int m = 0;
        int iteration = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    array[i][j][k] = m;
                    m++;
                }
            }
            m = 0;
        }
        return array;
    }
}
