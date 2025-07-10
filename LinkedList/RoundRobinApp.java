class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;

    public void addProcess(int id, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(id, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.println("PID: " + temp.processId + ", BT: " + temp.burstTime + ", Remaining: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void simulate(int timeQuantum) {
        if (head == null) return;

        int totalTime = 0;
        int totalProcesses = 0;
        ProcessNode temp = head;

        // Count total processes
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        boolean done;
        do {
            done = true;
            ProcessNode curr = head;
            do {
                if (curr.remainingTime > 0) {
                    done = false;
                    int execTime = Math.min(timeQuantum, curr.remainingTime);
                    totalTime += execTime;
                    curr.remainingTime -= execTime;

                    if (curr.remainingTime == 0) {
                        curr.turnaroundTime = totalTime;
                        curr.waitingTime = curr.turnaroundTime - curr.burstTime;
                    }
                }
                curr = curr.next;
            } while (curr != head);
        } while (!done);

        // Display results
        System.out.println("\nProcess Completion:");
        double totalWT = 0, totalTAT = 0;
        temp = head;
        do {
            System.out.println("PID: " + temp.processId +
                    " | Waiting Time: " + temp.waitingTime +
                    " | Turnaround Time: " + temp.turnaroundTime);
            totalWT += temp.waitingTime;
            totalTAT += temp.turnaroundTime;
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (totalWT / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTAT / totalProcesses));
    }
}
public class RoundRobinApp {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        System.out.println("Initial Process List:");
        scheduler.displayProcesses();

        System.out.println("\nSimulating Round Robin with Time Quantum = 4:");
        scheduler.simulate(4);
    }
}
