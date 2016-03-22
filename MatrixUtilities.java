package pkgMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
	The below program is to find the smallest of largest nth element from a list of numbers
*/

public class MatrixUtilities<T>
{
    public static<T extends Comparable> List<T> kthElements(List<T> numbers,
                                                            int K,
                                                            IHeap<T> heap)
    throws IllegalArgumentException
    {
        List<T> leastKNumbers = new LinkedList<T>();

        if (numbers == null || numbers.size() == 0)
        {
            throw new IllegalArgumentException("The collection of numbers passed is null/empty.");
        }

        if (heap == null)
        {
            throw new IllegalArgumentException("The min heap passed is null.");
        }


        int numberLength = numbers.size();

        int priorityQueueSize = Math.min(numberLength,K);

        PriorityQueue<T> queue = new PriorityQueue<T>(priorityQueueSize,heap);

        for(int i = 0;i < priorityQueueSize;i++)
        {
            if (numbers.get(i) != null)
            {
                queue.add(numbers.get(i));
            }
        }

        if (priorityQueueSize < numberLength)
        {
            for(int i = priorityQueueSize;i < numberLength;i++)
            {
                T data = numbers.get(i);
                if (data != null)
                {
                    T queuePeek = queue.peek();
                    if (queuePeek != null)
                    {
                        int comparisonRes = queuePeek.compareTo(data);
                        if (heap.accept(comparisonRes))
                        {
                            queue.poll();
                            queue.offer(data);
                        }
                    }
                }
            }
        }

        if (queue.size() > 0)
        {
            while (!queue.isEmpty())
            {
                T data  = queue.poll();
                if (data != null)
                {
                    leastKNumbers.add(data);
                }
            }
        }
        return leastKNumbers;
    }

}
