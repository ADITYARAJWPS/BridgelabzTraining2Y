public class MovieManagement {
    static class Movie {
        String title,director; int year; double rating; Movie prev,next;
        Movie(String t,String d,int y,double r){title=t;director=d;year=y;rating=r;}
    }
    private Movie head,tail;
    void addFirst(String t,String d,int y,double r){
        Movie x=new Movie(t,d,y,r);
        if(head==null)head=tail=x;
        else{x.next=head;head.prev=x;head=x;}
    }
    void addLast(String t,String d,int y,double r){
        Movie x=new Movie(t,d,y,r);
        if(tail==null)head=tail=x;
        else{tail.next=x;x.prev=tail;tail=x;}
    }
    void addAt(int p,String t,String d,int y,double r){
        if(p<1)throw new IllegalArgumentException("Position starts at 1");
        if(p==1){addFirst(t,d,y,r);return;}
        Movie cur=head; for(int i=1;cur!=null && i<p-1;i++)cur=cur.next;
        if(cur==null)throw new IndexOutOfBoundsException("Invalid position");
        if(cur==tail){addLast(t,d,y,r);return;}
        Movie x=new Movie(t,d,y,r); x.next=cur.next;x.prev=cur;
        cur.next.prev=x;cur.next=x;
    }
    boolean remove(String title){
        Movie x=findTitle(title); if(x==null)return false;
        if(x.prev!=null)x.prev.next=x.next;else head=x.next;
        if(x.next!=null)x.next.prev=x.prev;else tail=x.prev;
        x.next=x.prev=null;return true;
    }
    Movie findTitle(String title){
        for(Movie x=head;x!=null;x=x.next)if(x.title.equalsIgnoreCase(title))return x;
        return null;
    }
    void searchDirector(String d){
        boolean found=false;
        for(Movie x=head;x!=null;x=x.next)if(x.director.equalsIgnoreCase(d)){print(x);found=true;}
        if(!found)System.out.println("No movie found for director: "+d);
    }
    void searchRating(double r){
        boolean found=false;
        for(Movie x=head;x!=null;x=x.next)if(Double.compare(x.rating,r)==0){print(x);found=true;}
        if(!found)System.out.println("No movie found with rating: "+r);
    }
    boolean updateRating(String title,double rating){
        Movie x=findTitle(title);if(x==null)return false;x.rating=rating;return true;
    }
    private void print(Movie x){System.out.printf("%s | %s | %d | %.1f%n",x.title,x.director,x.year,x.rating);}
    void displayForward(){for(Movie x=head;x!=null;x=x.next)print(x);}
    void displayReverse(){for(Movie x=tail;x!=null;x=x.prev)print(x);}
    public static void main(String[] args){
        MovieManagement m=new MovieManagement();
        m.addLast("3 Idiots","Rajkumar Hirani",2009,8.4);
        m.addFirst("Dangal","Nitesh Tiwari",2016,8.3);
        m.addAt(2,"Taare Zameen Par","Aamir Khan",2007,8.3);
        System.out.println("Forward:");m.displayForward();
        System.out.println("Reverse:");m.displayReverse();
        m.updateRating("3 Idiots",9.0);m.remove("Dangal");
        System.out.println("After update/removal:");m.displayForward();
    }
}
