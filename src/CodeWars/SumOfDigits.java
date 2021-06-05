public class sumOfDigits {

public static void main(String[] args){
  
}


  public static int digital_root(int n) {
    int result = 0;
    int sum = sumOfDigits(n);
    if(sum > 9){
      while(sum>9){
        result = sumOfDigits(sum);
      }
      return result;
    } else {
      return sum;
    }
  }
  public static int sumOfDigits(int n){
    int sum = 0;
    while(n!=0){
      sum = sum + (n % 10);
      n = n/10;
    }
    return sum;
  }
}
