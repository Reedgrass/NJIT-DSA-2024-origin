package oy.tol.tra;

public class Grades {

   private Integer[] grades = null;

   public Grades(Integer[] grades) {
      this.grades = new Integer[grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
      }
   }

   public void reverse() {

      int i = 0;
      while (i < grades.length / 2) {
         int temp = grades[i];
         grades[i] = grades[grades.length - i - 1];
         grades[grades.length - i - 1] = temp;
         i++;
      }
   }

   // public void sort() {

   // int i = grades.length - 1;
   // while (i > 0) {
   // if (grades[i] < grades[i - 1]) {
   // int tmp = grades[i];
   // grades[i] = grades[i - 1];
   // grades[i - 1] = tmp;
   // }
   // i--;
   // }
   // }
   public void sort() {
      int n = grades.length;
      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
            if (grades[j] > grades[j + 1]) {
               // Swap grades[j] and grades[j+1]
               int temp = grades[j];
               grades[j] = grades[j + 1];
               grades[j + 1] = temp;
            }
         }
      }
   }

   // // public void sort() {
   // // boolean swapped;
   // // for (int i = grades.length - 1; i > 0; i--) {
   // // swapped = false;
   // // for (int j = 0; j < i; j++) {
   // // if (grades[j] > grades[j + 1]) {
   // // int tmp = grades[j];
   // // grades[j] = grades[j + 1];
   // // grades[j + 1] = tmp;
   // // swapped = true;
   // // }
   // // }
   // // if (!swapped) {
   // // break;
   // // }
   // // }
   // // }

   public Integer[] getArray() {
      return grades;
   }
}

