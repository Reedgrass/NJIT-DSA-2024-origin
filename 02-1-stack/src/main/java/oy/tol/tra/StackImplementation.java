package oy.tol.tra;

import java.util.EmptyStackException;

public class StackImplementation<E> implements StackInterface<E> {
   private Object[] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10;

   public StackImplementation() throws StackAllocationException {
      this(DEFAULT_STACK_SIZE);
   }

   public StackImplementation(int capacity) throws StackAllocationException {
      if (capacity < 2) {
         throw new StackAllocationException("Capacity must be at least 2.");
      }
      try {
         itemArray = new Object[capacity];
         this.capacity = capacity;
      } catch (Exception e) {
         throw new StackAllocationException("Failed to allocate room for the internal array.");
      }
   }

   @Override
   public int capacity() {
      return capacity;
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      if (element == null) {
         throw new NullPointerException("Cannot push null element to stack.");
      }
      if (currentIndex == capacity - 1) {
         // Reallocate array to double its current capacity
         capacity *= 2;
         Object[] newArray = new Object[capacity];
         System.arraycopy(itemArray, 0, newArray, 0, currentIndex + 1);
         itemArray = newArray;
      }
      currentIndex++;
      itemArray[currentIndex] = element;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty, cannot pop.");
      }
      E element = (E) itemArray[currentIndex];
      itemArray[currentIndex] = null; // Dereference to aid garbage collection
      currentIndex--;
      return element;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty, cannot peek.");
      }
      return (E) itemArray[currentIndex];
   }

   @Override
   public int size() {
      return currentIndex + 1;
   }

   @Override
   public void clear() {
      itemArray = new Object[DEFAULT_STACK_SIZE];
      capacity = DEFAULT_STACK_SIZE;
      currentIndex = -1;
   }

   @Override
   public boolean isEmpty() {
      return currentIndex == -1;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (int index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index]);
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}

   @Override
   public void clear() {
      // TODO: Implement this
      
   }

   @Override
   public boolean isEmpty() {
      // TODO: Implement this
      
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}
