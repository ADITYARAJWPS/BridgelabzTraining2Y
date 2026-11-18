public class TaskScheduler {
    static class Task {
        int id,priority; String name,dueDate; Task next;
        Task(int i,String n,int p,String d){id=i;name=n;priority=p;dueDate=d;}
    }
    private Task head,tail,current; private int size;
    void addFirst(int id,String name,int priority,String due){
        Task x=new Task(id,name,priority,due);
        x.dueDate=due;
        if(head==null){head=tail=x;x.next=x;}
        else{x.next=head;head=x;tail.next=head;}
        if(current==null)current=x;size++;
    }
    void addLast(int id,String name,int priority,String due){
        Task x=new Task(id,name,priority,due);
        if(head==null){head=tail=x;x.next=x;current=x;}
        else{x.next=head;tail.next=x;tail=x;}
        size++;
    }
    void addAt(int p,int id,String name,int priority,String due){
        if(p<1||p>size+1)throw new IndexOutOfBoundsException("Invalid position");
        if(p==1){addFirst(id,name,priority,due);return;}
        if(p==size+1){addLast(id,name,priority,due);return;}
        Task prev=head;for(int i=1;i<p-1;i++)prev=prev.next;
        Task x=new Task(id,name,priority,due);x.next=prev.next;prev.next=x;size++;
    }
    boolean remove(int id){
        if(head==null)return false;
        Task prev=tail,cur=head;
        do{
            if(cur.id==id){
                if(size==1){head=tail=current=null;}
                else{prev.next=cur.next;if(cur==head)head=cur.next;if(cur==tail)tail=prev;
                    if(current==cur)current=cur.next;tail.next=head;}
                size--;return true;
            }
            prev=cur;cur=cur.next;
        }while(cur!=head);
        return false;
    }
    Task currentTask(){return current;}
    Task moveNext(){if(current!=null)current=current.next;return current;}
    void searchPriority(int p){
        if(head==null){System.out.println("No tasks.");return;}
        Task t=head;do{if(t.priority==p)print(t);t=t.next;}while(t!=head);
    }
    void display(){
        if(head==null){System.out.println("No tasks.");return;}
        Task t=head;do{print(t);t=t.next;}while(t!=head);
    }
    private void print(Task t){System.out.printf("ID:%d | %s | Priority:%d | Due:%s%n",t.id,t.name,t.priority,t.dueDate);}
    public static void main(String[] args){
        TaskScheduler q=new TaskScheduler();
        q.addLast(1,"Assignment",1,"2026-11-20");q.addLast(2,"Revision",2,"2026-11-22");
        q.addFirst(3,"Project",1,"2026-11-25");q.display();
        System.out.println("Current task:");if(q.currentTask()!=null)q.searchPriority(q.currentTask().priority);
        q.moveNext();q.remove(1);System.out.println("After moving/removing:");q.display();
    }
}
