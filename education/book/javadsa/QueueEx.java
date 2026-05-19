class Queue{
    final static int QLIMIT = 100;
    char item[] = new char[QLIMIT];
    int head,tail;

    Queue(){
	head = 0;
	tail = 0;
    }

    char dequeue(){
	char tmp;

	tmp = item[head];
	head = (head + 1) % QLIMIT;
	return tmp;
    }

    boolean empty(){
	if (head == tail){
	    return (true);
	} else {
	    return (false);
	}
    }

    void enqueue(char x){
	item[tail]= x;
	tail = (tail + 1) % QLIMIT;
    }
}

class QueueEx{
    public static void main(String args[]){
	Queue s = new Queue();
	char c;

	s.enqueue('a');
	s.enqueue('b');
	s.enqueue('c');
	s.enqueue('d');
	while (!s.empty()){
	    c = s.dequeue();
	    System.out.println(c);
	}
    }
}
