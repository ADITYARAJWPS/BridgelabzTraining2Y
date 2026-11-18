public class LibraryManagement {
    static class Book {String title,author,genre;int id;boolean available;Book prev,next;
        Book(String t,String a,String g,int i,boolean av){title=t;author=a;genre=g;id=i;available=av;}}
    private Book head,tail;private int size;
    void addFirst(String t,String a,String g,int id,boolean av){Book x=new Book(t,a,g,id,av);
        if(head==null)head=tail=x;else{x.next=head;head.prev=x;head=x;}size++;}
    void addLast(String t,String a,String g,int id,boolean av){Book x=new Book(t,a,g,id,av);
        if(tail==null)head=tail=x;else{tail.next=x;x.prev=tail;tail=x;}size++;}
    void addAt(int p,String t,String a,String g,int id,boolean av){
        if(p<1||p>size+1)throw new IndexOutOfBoundsException("Invalid position");
        if(p==1){addFirst(t,a,g,id,av);return;}if(p==size+1){addLast(t,a,g,id,av);return;}
        Book cur=head;for(int i=1;i<p;i++)cur=cur.next;
        Book x=new Book(t,a,g,id,av);x.prev=cur.prev;x.next=cur;cur.prev.next=x;cur.prev=x;size++;}
    boolean remove(int id){Book x=findId(id);if(x==null)return false;
        if(x.prev!=null)x.prev.next=x.next;else head=x.next;
        if(x.next!=null)x.next.prev=x.prev;else tail=x.prev;
        x.next=x.prev=null;size--;return true;}
    Book findId(int id){for(Book x=head;x!=null;x=x.next)if(x.id==id)return x;return null;}
    void searchTitle(String s){boolean f=false;for(Book x=head;x!=null;x=x.next)
        if(x.title.equalsIgnoreCase(s)){print(x);f=true;}if(!f)System.out.println("Book not found.");}
    void searchAuthor(String s){boolean f=false;for(Book x=head;x!=null;x=x.next)
        if(x.author.equalsIgnoreCase(s)){print(x);f=true;}if(!f)System.out.println("Book not found.");}
    boolean updateAvailability(int id,boolean value){Book x=findId(id);if(x==null)return false;x.available=value;return true;}
    void displayForward(){for(Book x=head;x!=null;x=x.next)print(x);}
    void displayReverse(){for(Book x=tail;x!=null;x=x.prev)print(x);}
    int count(){return size;}
    private void print(Book x){System.out.printf("ID:%d | %s | %s | %s | %s%n",x.id,x.title,x.author,x.genre,x.available?"Available":"Issued");}
    public static void main(String[] args){LibraryManagement l=new LibraryManagement();
        l.addLast("Clean Code","Robert Martin","Technology",1,true);
        l.addFirst("The Alchemist","Paulo Coelho","Fiction",2,false);
        l.addAt(2,"Atomic Habits","James Clear","Self-help",3,true);
        System.out.println("Forward:");l.displayForward();System.out.println("Reverse:");l.displayReverse();
        l.updateAvailability(2,true);l.remove(1);System.out.println("Book count: "+l.count());}
}
