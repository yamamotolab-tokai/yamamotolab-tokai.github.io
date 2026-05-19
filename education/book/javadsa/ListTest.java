public class ListTest{
    public static void main(String args[]){
	List l=new List(""); // リストの生成
	List_element a=new List_element("Ohara"); // リスト要素の生成
	List_element b=new List_element("Yamamoto");
	List_element c=new List_element("Kikuchi");
	List_element d=new List_element("Hamamoto");
		
	// リストの最後へのリスト要素の追加
	l.add(a);
	l.add(b);
		
	// リストの表示
	if (l != null){
	    for(List work=l.next; work!=null; work=work.next){
		System.out.println(work.data);
	    }
	}
		
	// リストへの要素の挿入
	l.insert(c, 2);
	l.insert(d, 3);
		
	// リストの表示
	if (l != null){
	    for(List work=l.next; work!=null; work=work.next){
		System.out.println(work.data);
	    }
	}
    }
}

class	List{
    String	data; // 要素の値
    List_element	next; // 次のリスト要素への参照
	
    List(String m){ // コンストラクタ
	data=m;
    }
	
    // リストの最後にリスト要素を追加するメソッド
    void	add(List_element work){
	List a=this;
	while(a.next!=null) a=a.next;
	a.next=work;
    }
	
    // リスト要素をkey番目の要素として挿入するメソッド
    void	insert(List_element work, int key){
	List a=this;
	int num=0, i;
	while(a.next!=null){
	    num++;
	    if(num==key){
		work.next=a.next;
		a.next=work;
		return;
	    }
	    a=a.next;
	}
	if(key==num+1){
	    this.add(work);
	}
	else if(key>num+1){
	    System.out.println
		("要素の数は"+num+"なので，"+key+"番目には挿入できません。");
	}
    }
}

class	List_element extends List{
    List_element(String m){
	super(m);
    }
}
