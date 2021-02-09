import java.util.*;

class Main {
  static char [] t; // class variables so accessible by the methods
  static int [] c; 

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);//user input
    String text = sc.nextLine();//take in string
    sc.close();//close scanner

    t = text.toCharArray();//create char array from string
    int count = 0;//variable to keep track of frequency
    c = new int[t.length]; //int array to store frequency of each element

    for (int i = 0; i<t.length;i++){//1st pointer
    count = 0; //reset count when 1st pointer moves
      for (int j=0;j<t.length;j++){//2nd pointer
        if (t[i]==t[j] && j<i){ //if letter has already been counted
          break;//don't need to count again
        }
        if (t[i] == t[j]){//if char appears more than once 
          count++;//increment count
        }
        c[i] = count;//update int array with frequency of each letter
      }
    }

    freqSort(); //selection sort - max frequency first
    asciiSort();//selection sort - lowest ascii first

    for (int i = 0; i<c.length;i++){ //print output
      if (c[i] != 0){ //don't print chars more than once
        System.out.println(t[i]+" "+c[i]);
      }
    }

  }//end of main
public static void asciiSort(){
  int lower;
  for (int i = 0; i<t.length; i++){
    lower = i;
    for (int j=i+1;j<t.length;j++){
      if (c[lower] != 0 && c[lower] == c[j]){ //if freq the same 
        if(t[lower] > t[j]){ //if ascii is lower than j
          lower = j; //update lower variable
        }
      }
    }
    swap(i, lower); //update ordering
  }
}
public static void freqSort() {
  int max;
  for (int i = 0; i < c.length; i++) {
  // i is the point where the unsorted numbers start
    max = i;
  // max’s default value is the first slot to be checked
  for (int j = i + 1; j < c.length; j++) {
  // j loop checks through the unsorted numbers
  if (c[max] < c[j]) {
    max = j; //inner loop finds the max found so far
    }
  }
  swap(i, max); //update ordering
  }
}
public static void swap(int first, int second){
  char temp = t[first];
  t[first] = t[second];
  t[second] = temp;
  int temp2 = c[first];
  c[first] = c[second];
  c[second] = temp2;
}

}//end of class