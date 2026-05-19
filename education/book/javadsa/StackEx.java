class Stack{
    final static int SLIMIT = 100;
    char item[] = new char[SLIMIT];
    int top;

    Stack(){
	top = -1;
    }

    boolean empty(){
	if (top==-1){
	    return (true);
	} else {
	    return (false);
	}
    }

    char pop(){
	top--;
	return item[top+1];
    }

    void push(char x){
	top++;
	item[top] = x;
    }
}

class StackEx{
    public static void main(String args[]){
	Stack s = new Stack();
	char c;

	s.push('a');
	s.push('b');
	s.push('c');
	s.push('d');
	while (!s.empty()){
	    c = s.pop();
	    System.out.println(c);
	}
    }
}
