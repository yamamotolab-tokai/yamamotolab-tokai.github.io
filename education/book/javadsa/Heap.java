public class Heap{
    int key[];
    int size;
    Heap(int k[]){
	key = k;
	size = k.length-1;
    }
    void heapify(int i){
	int l = left(i);
	int r = right(i);
	int largest = i;
	if(l <= size && key[l] > key[i]){
	    largest = l;
	}
	if(r <= size && key[r] > key[largest]){
	    largest = r;
	}
	if(largest != i){
	    int c = key[i];
	    key[i] = key[largest];
	    key[largest] = c;
	    heapify(largest);
	}
    }
    void buildheap(){
	for(int i = size/2; i > 0; --i){
	    heapify(i);
	}
    }
    int extractmax(){
	int max = key[1];
	key[1] = key[size--];
	heapify(1);
	return(max);
    }
    void sort(){
	buildheap();
	for(int i = size; i > 1; --i){
	    int c = extractmax();
	    key[i] = c;
	}
    }
    int p(int i){
	return i/2;
    }
    int left(int i){
	return 2*i;
    }
    int right(int i){
	return 2*i+1;
    }
    public static void main(String argv[]){
	int a[] = {0, 3, 15, 9, 7};//a[0] ‚Íƒ_ƒ~[
	Heap h = new Heap(a);
	h.disp();
	h.buildheap();
	h.disp();
	System.out.println("max = "+ h.extractmax());
	h.disp();
    }
    public void disp(){
        disp(1, "");
    }
    public void disp(int i, String s){
        if(i > size){
	    return;
        }
        System.out.println(s + key[i]);
        disp(left(i), s + "\t");
        disp(right(i), s + "\t");
    }
}
