public class Arrays09{
    public static void main(String[] args) {
        // Exercise: 1
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (i + 1) * (i + 1);
            System.out.println(arr[i]);
        }
        System.out.println(findMax(arr));
        System.out.println(findMin(arr));

        // Exercise: 3
        String[] names = {"Rishabh", "Varun", "Om"};
        for(String n: names){
            System.out.println(n);
        }
        //System.out.println(names[3]);
        System.out.println(names[names.length - 1]);// Om

        // Exercise: 4
        int[][] integers = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        for(int i = 0; i < integers.length; i++){
            for(int j = 0; j < integers[i].length; j++){
                if (i == j) {
                    System.out.println(integers[i][j]);
                }
            }
        }


    }

    // Exercise: 2
    public static int findMax(int[] arr){
        int max = arr[0];
        for (int n = 0; n < arr.length; n++){
            if(arr[n] > max)
                max = arr[n];
        }
        return max;
    }

    public static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return  min;
    }
   
}