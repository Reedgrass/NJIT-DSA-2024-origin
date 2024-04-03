package oy.tol.tra;

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
      this.capacity = capacity;
      this.itemArray = new Object[capacity];
   }

   @Override
   public int capacity() {
      return capacity;
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      checkAndGrow();
      if (element == null) {
         throw new NullPointerException("Element cannot be null.");
      }

      itemArray[++currentIndex] = element; // 先增加currentIndex，然后添加元素
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty.");
      }
      E element = (E) itemArray[currentIndex];
      itemArray[currentIndex--] = null; // 移除元素，并减少currentIndex
      return element;
   }

   @Override
   public int size() {
      return currentIndex + 1;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty.");
      }
      return (E) itemArray[currentIndex];
   }

   @Override
   public void clear() {

      currentIndex = -1;
   }

   @Override
   public boolean isEmpty() {
      return currentIndex < 0;
   }

   private void checkAndGrow() {
      if (currentIndex + 1 == capacity) {
         int newCapacity = capacity + (capacity >> 1);
         Object[] newArray = new Object[newCapacity];
         System.arraycopy(itemArray, 0, newArray, 0, capacity);
         itemArray = newArray;
         capacity = newCapacity;
      }
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
