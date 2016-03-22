package pkgMatrix;

import java.util.Comparator;

public interface IHeap<T extends Comparable> extends Comparator<T>
{
    boolean accept(int value);
}
