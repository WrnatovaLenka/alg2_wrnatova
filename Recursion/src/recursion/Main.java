package recursion;

/**
 *
 * @author lenka.wrnatova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(factorialIterative(5));
//        System.out.println(factorialRecursive(5));
System.out.println(mystery(3,11));
int[] pole = {11, 250, 8, -16, 15};
        System.out.println(findMax1(pole, 0,pole.length-1));
       
    }
    
    //factorial iterativně
    public static int factorialIterative(int n){
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    //factorial rekurzivne
    public static int factorialRecursive(int n){
        if(n<=1){
            return 1;
        }else{
            return n * factorialRecursive(n-1);
        }
    }
    
    public static int mystery(int a, int b){
        if (b==0) return 0;
        if (b%2==0) return mystery(a+a,b/2);
        return mystery(a+a,b/2)+a;
    }
    
    /*
    mystery(3, 11)
    mystery(6,5)+3
    mystery(12,2)+6
    mystery(24,1)
    mystery(48,0)+24
    return 0
    
    0+24+6+3=33
    
    */
    public static int findMax(int[] a, int n){
//        if(n == 1){
//            return a[0];
//        }
        
        if(n == 2){
            return Math.max(a[0], a[1]);
        }
        return Math.max(a[n-1], findMax(a, n-1));
        
    }
    
    public static int findMax1(int[] a, int from, int to){
        if(from >= to){
            return a[from];
        }
        int half = (from+to)/2;
        int left = findMax1(a, from, half);
        int right = findMax1(a, half+1, to);
        if(left>=right){
            return left;
        }else{
            return right;
        }
    }
   
}
