public class RoundRobinScheduling {
    static class Process {
        int id, remaining, burst, priority;
        Process next;
        Process(int id, int burst, int priority) {
            this.id=id; this.burst=burst; this.remaining=burst; this.priority=priority;
        }
    }
    private Process tail;
    private int size;

    void addProcess(int id, int burst, int priority) {
        if (burst <= 0) throw new IllegalArgumentException("Burst time must be positive.");
        Process x = new Process(id, burst, priority);
        if (tail == null) { tail=x; x.next=x; }
        else { x.next=tail.next; tail.next=x; tail=x; }
        size++;
    }

    void display() {
        if (tail == null) { System.out.println("No active processes."); return; }
        Process first=tail.next, cur=first;
        do {
            System.out.printf("P%d(remaining=%d, priority=%d) ", cur.id, cur.remaining, cur.priority);
            cur=cur.next;
        } while (cur != first);
        System.out.println();
    }

    void simulate(int quantum) {
        if (quantum <= 0) throw new IllegalArgumentException("Time quantum must be positive.");
        if (tail == null) { System.out.println("No processes."); return; }

        int n=size, elapsed=0;
        int[] ids=new int[n], bursts=new int[n], completion=new int[n];
        Process p=tail.next;
        for (int i=0; i<n; i++) { ids[i]=p.id; bursts[i]=p.burst; p=p.next; }

        while (size > 0) {
            int processesThisRound=size;
            Process prev=tail, cur=tail.next;
            for (int i=0; i<processesThisRound; i++) {
                int run=Math.min(quantum, cur.remaining);
                cur.remaining-=run;
                elapsed+=run;

                if (cur.remaining == 0) {
                    for (int j=0; j<n; j++)
                        if (ids[j] == cur.id) { completion[j]=elapsed; break; }

                    if (size == 1) {
                        tail=null;
                        cur=null;
                        size=0;
                    } else {
                        prev.next=cur.next;
                        if (cur == tail) tail=prev;
                        cur=prev.next;
                        tail.next=tail.next; // tail.next remains the head
                        size--;
                    }
                } else {
                    prev=cur;
                    cur=cur.next;
                }
                if (size == 0) break;
            }
            System.out.print("After round: ");
            display();
        }

        double totalWaiting=0, totalTurnaround=0;
        for (int i=0; i<n; i++) {
            totalTurnaround += completion[i];
            totalWaiting += completion[i] - bursts[i];
        }
        System.out.printf("Average waiting time: %.2f%n", totalWaiting/n);
        System.out.printf("Average turnaround time: %.2f%n", totalTurnaround/n);
    }

    public static void main(String[] args) {
        RoundRobinScheduling rr=new RoundRobinScheduling();
        rr.addProcess(1,5,1);
        rr.addProcess(2,4,2);
        rr.addProcess(3,2,1);
        rr.simulate(2);
    }
}
