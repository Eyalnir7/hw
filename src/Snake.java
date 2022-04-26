public class Snake {
    private int head;
    private int tail;

    public Snake(int head ,int tail)
    {
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail()
    {
        return this.tail;
    }

    public void setTail(int tail)
    {
        this.tail = tail;
    }
}
