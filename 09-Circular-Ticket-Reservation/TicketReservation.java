public class TicketReservation {
    static class Ticket {int id,seat;String customer,movie,bookingTime;Ticket next;
        Ticket(int i,String c,String m,int s,String b){id=i;customer=c;movie=m;seat=s;bookingTime=b;}}
    private Ticket tail;private int size;
    void addLast(int id,String customer,String movie,int seat,String time){
        Ticket x=new Ticket(id,customer,movie,seat,time);
        if(tail==null){tail=x;x.next=x;}else{x.next=tail.next;tail.next=x;tail=x;}size++;}
    boolean remove(int id){if(tail==null)return false;Ticket prev=tail,cur=tail.next;
        do{if(cur.id==id){if(size==1)tail=null;else{prev.next=cur.next;if(cur==tail)tail=prev;}
            size--;return true;}prev=cur;cur=cur.next;}while(cur!=tail.next);return false;}
    void searchCustomer(String name){search(name,true);}
    void searchMovie(String name){search(name,false);}
    private void search(String value,boolean byCustomer){if(tail==null){System.out.println("No bookings.");return;}
        Ticket t=tail.next;boolean found=false;do{String field=byCustomer?t.customer:t.movie;
            if(field.equalsIgnoreCase(value)){print(t);found=true;}t=t.next;}while(t!=tail.next);
        if(!found)System.out.println("No matching ticket.");}
    void display(){if(tail==null){System.out.println("No bookings.");return;}Ticket t=tail.next;
        do{print(t);t=t.next;}while(t!=tail.next);}
    int count(){return size;}
    private void print(Ticket t){System.out.printf("Ticket:%d | Customer:%s | Movie:%s | Seat:%d | Time:%s%n",
        t.id,t.customer,t.movie,t.seat,t.bookingTime);}
    public static void main(String[] args){TicketReservation r=new TicketReservation();
        r.addLast(501,"Aman","Dangal",12,"2026-11-18 14:00");
        r.addLast(502,"Riya","3 Idiots",13,"2026-11-18 14:05");
        r.addLast(503,"Karan","Dangal",14,"2026-11-18 14:10");
        r.display();r.searchMovie("Dangal");r.remove(502);System.out.println("Booked ticket count: "+r.count());r.display();}
}
