import java.util.EmptyStackException;
import java.util.Iterator;
//implement your ArrayStack implementation here


public class ArrayStack implements DStack
{
    private final int DEFAULT_CAPACITY = 100;
    private int top;
    private transient double[] stack;
     public ArrayStack()
     {
         top = 0;
         stack = (double[])(new double[DEFAULT_CAPACITY]);
     }
    public ArrayStack(int initialCapacity)
    {
        top = 0;
        stack = (double[])(new double[DEFAULT_CAPACITY]);
    }
    public int size() {
         return top;
    }

     @Override
    public boolean isEmpty() 
    {
        return (top == 0);
    }
    @Override
    public void push(double d)
    {
         // Insert your push code here
        if (size() == stack.length)
            expandCapacity();
        stack[top] = d;
        top++;
    }

   public void expandCapacity() {
         double[] larger = (double[])(new double[stack.length*2]);
         System.arraycopy(stack, 0, larger, 0, stack.length);

         stack = larger;
   }

    @Override
    public double pop() throws EmptyStackException
    {
         // Insert your pop code here
        if (isEmpty())
            throw new EmptyStackException();
        top--;
        double result = stack[top];
        stack[top] = stack[top + 1];
        return result;
    }

    @Override
    public double peek() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top-1];
    }
}
