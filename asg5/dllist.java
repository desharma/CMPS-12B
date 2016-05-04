// dllist.java
// Template code for doubly-linked list of strings.

public class dllist {

   public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};

   private class node {
      String item;
      node prev;
      node next;
   }

   private node first = null;
   private node current = null;
   private node last = null;
   private int currentPosition = 0;

   public void setPosition (position pos) {
      throw new UnsupportedOperationException();
   }

   public boolean isEmpty () {
      if (first == null)
         return true;
      else
         return false;
      //throw new UnsupportedOperationException(); Is this useless?
   }

   public String getItem () {
      throw new UnsupportedOperationException();
   }

   public int getPosition () {
      throw new UnsupportedOperationException();
   }

   public void delete () {
      throw new UnsupportedOperationException();
   }

   public void insert (String item, position pos) {
      throw new UnsupportedOperationException();
   }

}

