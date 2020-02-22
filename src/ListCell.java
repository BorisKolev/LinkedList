package lab2;

public class ListCell<T>
{
    T data;
    ListCell<T> next;

    ListCell(T x, ListCell<T> c)
    {
        data = x;
        next = c;
    }

    public String toString()
    {
        return data + " "  + next;
    }
}

