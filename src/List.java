package lab2;

class List<T>
{

    private ListCell<T> front;

    List()
    {
        this.front = null;
    }

    ListCell<T> getFront()
    {
        return this.front;
    }

    void addToFront(T x)
    {
        this.front = new ListCell<T>(x, this.front);
    }

    void addToBack(T x)
    {
        if (this.front==null)
        {
            this.front = new ListCell<T>(x, this.front);
        }
        else
        {
            ListCell<T> c = this.front;
            while (c.next != null)
                c = c.next;
            c.next = new ListCell<T>(x, null);
        }
    }

    T elementAt(int n)
    {
        ListCell<T> c = this.front;
        for (int i = 0; i<n; i++)
        {
            if (c == null)
            throw new ListException("no element at position "+n);
            c = c.next;
        }
        if (c == null)
            throw new ListException("no element at position "+n);
        return c.data;
    }

    int length()
    {
        ListCell<T> c = this.front;
        int result = 0;
        while (c != null)
        {
            result++;
            c = c.next;
        }
        return result;
    }

    int find(T x)
    {
        int location = 0;
        ListCell<T>  c = this.front;
        if(c.data == null)
        {
            return -1;
        }

        while(c != null)
        {

            if(c.data == x)
            {
                return location;
            }
            location++;
            c = c.next;
        }

        return -1;
    }

    boolean removeAll(T x)
    {
        ListCell<T> c = this.front;
        ListCell<T> prev = null;
        boolean removedOne = false;
        while (c != null)
        {
            if(c.data.equals(x))
            {
                if (prev == null)
                {
                    this.front = c.next;
                }
                else
                {
                    prev.next = c.next;
                }
                removedOne = true;
            }
            else
            {
                prev = c;
            }
            c = c.next;
        }
        return removedOne;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("<");
        ListCell<T> c = this.front;
        while (c != null)
        {
            // Not to have space before the > symbol when printing
            if(c.next == null)
            {
                sb.append(c.data);
                break;
            }
            sb.append(c.data).append(" ");
            c = c.next;
        }
        return(sb+">");
    }

}