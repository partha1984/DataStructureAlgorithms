package pkgMatrix;

import java.util.Comparator;

public class CMaxHeap<T extends Comparable> implements IMaxHeap<T>
{
    @Override
    public int compare(T object1,T object2)
    {
        return (-1)*(object1.compareTo(object2));
    }

    public boolean accept(int value)
    {
        boolean passed = false;
        if (value > 0)
        {
            passed =  true;
        }
        return passed;
    }
}
