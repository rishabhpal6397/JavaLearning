public class Arrays09{
    public static void main(String[] args) {
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (i + 1) * (i + 1);
            System.out.println(arr[i]);
        }
        System.out.println(findMax(arr));

    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for (int n = 0; n < arr.length; n++){
            if(arr[n] > max)
                max = arr[n];
        }
        return max;
    }
   
}