
import java.util.EmptyStackException;

class Node {
    double data;
    Node next;
}

public class ListStack implements DStack
{
    private Node top;
    private int nodesCount;

    public ListStack() {
        this.top = null;
        this.nodesCount = 0;
    }

     @Override
    public boolean isEmpty() 
    {
        return (top == null);
    }
    @Override
    public void push(double data)
    {
        Node node = new Node();
        node.data = data;
        node.next = top;
        top = node;
        this.nodesCount++;
    }

    @Override
    public double pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        this.nodesCount--;
        double top = peek();
        this.top = (this.top).next;
        return top;
    }
    @Override
    public double peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

}
