package pkgMatrix;

import java.util.Comparator;

public class CMinHeap<T extends Comparable> implements IMinHeap<T>
{
    @Override
    public int compare(T object1,T object2)
    {
        return (object1.compareTo(object2));
    }

    public boolean accept(int value)
    {
        boolean passed = false;
        if (value < 0)
        {
            passed =  true;
        }
        return passed;
    }
}
