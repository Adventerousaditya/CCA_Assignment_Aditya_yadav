package practice;

import java.time.LocalDateTime;
import java.util.*;
enum ActionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    LOGIN,
    FAILED_LOGIN
}

enum Status {
    SUCCESS,
    FAILED
}



class LogEntry {

    private static int counter = 1;

    private final int logId;
    private final String accountNumber;
    private final ActionType actionType;
    private final double amount;
    private final LocalDateTime timestamp;
    private final Status status;

    public LogEntry(String accountNumber, ActionType actionType,
                    double amount, Status status) {

        this.logId = counter++;
        this.accountNumber = accountNumber;
        this.actionType = actionType;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = status;
    }

    public int getLogId() { return logId; }
    public String getAccountNumber() { return accountNumber; }
    public ActionType getActionType() { return actionType; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Status getStatus() { return status; }

    @Override
    public String toString() {
        return "LogID=" + logId +
                ", Account=" + accountNumber +
                ", Action=" + actionType +
                ", Amount=" + amount +
                ", Status=" + status +
                ", Time=" + timestamp;
    }
}


interface LogService {

    void addLog(LogEntry log);
    List<LogEntry> getLogsByAccount(String accountNumber);
    List<LogEntry> getRecentLogs(int n);
    List<LogEntry> getLogsByAction(ActionType actionType);
}



class SuspiciousDetector {

    public List<LogEntry> detectSuspicious(Map<String, List<LogEntry>> accountLogs) {

        List<LogEntry> suspicious = new ArrayList<>();

        for (String acc : accountLogs.keySet()) {

            List<LogEntry> logs = accountLogs.get(acc);
            int size = logs.size();

            // Rule 1: More than 3 FAILED_LOGIN in last 5 logs
            int failedCount = 0;

            for (int i = Math.max(0, size - 5); i < size; i++) {
                if (logs.get(i).getActionType() == ActionType.FAILED_LOGIN) {
                    failedCount++;
                }
            }

            if (failedCount > 3 && size > 0) {
                suspicious.add(logs.get(size - 1));
            }

            // Rule 2: Withdrawal > 50000
            for (LogEntry log : logs) {
                if (log.getActionType() == ActionType.WITHDRAW
                        && log.getAmount() > 50000) {
                    suspicious.add(log);
                }
            }
        }

        return suspicious;
    }
}



class LogManager implements LogService {

    private final List<LogEntry> allLogs = new ArrayList<>();
    private final Map<String, List<LogEntry>> accountLogs = new HashMap<>();
    private final Map<ActionType, List<LogEntry>> actionLogs = new HashMap<>();
    private final Deque<LogEntry> recentLogs = new ArrayDeque<>();

    @Override
    public void addLog(LogEntry log) {

        allLogs.add(log);
        recentLogs.addFirst(log);

        accountLogs
                .computeIfAbsent(log.getAccountNumber(), k -> new ArrayList<>())
                .add(log);

        actionLogs
                .computeIfAbsent(log.getActionType(), k -> new ArrayList<>())
                .add(log);
    }

    @Override
    public List<LogEntry> getLogsByAccount(String accountNumber) {
        return accountLogs.getOrDefault(accountNumber, new ArrayList<>());
    }

    @Override
    public List<LogEntry> getRecentLogs(int n) {

        List<LogEntry> result = new ArrayList<>();
        Iterator<LogEntry> iterator = recentLogs.iterator();

        int count = 0;
        while (iterator.hasNext() && count < n) {
            result.add(iterator.next());
            count++;
        }

        return result;
    }

    @Override
    public List<LogEntry> getLogsByAction(ActionType actionType) {
        return actionLogs.getOrDefault(actionType, new ArrayList<>());
    }

    public Map<String, List<LogEntry>> getAccountLogsMap() {
        return accountLogs;
    }
}



public class SystemBanking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LogManager manager = new LogManager();
        SuspiciousDetector detector = new SuspiciousDetector();

        while (true) {

            System.out.println("\n===== Banking Log Manager =====");
            System.out.println("1. Add Log");
            System.out.println("2. Get Logs by Account");
            System.out.println("3. Get Recent Logs");
            System.out.println("4. Detect Suspicious Activity");
            System.out.println("5. Search by Action Type");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Account Number: ");
                    String acc = sc.nextLine();

                    System.out.print("Action (DEPOSIT, WITHDRAW, TRANSFER, LOGIN, FAILED_LOGIN): ");
                    ActionType action = ActionType.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Amount (0 if not applicable): ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Status (SUCCESS, FAILED): ");
                    Status status = Status.valueOf(sc.nextLine().toUpperCase());

                    manager.addLog(new LogEntry(acc, action, amount, status));
                    System.out.println("Log Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String searchAcc = sc.nextLine();
                    List<LogEntry> accLogs = manager.getLogsByAccount(searchAcc);

                    if (accLogs.isEmpty())
                        System.out.println("No logs found.");
                    else
                        accLogs.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter N: ");
                    int n = sc.nextInt();
                    manager.getRecentLogs(n).forEach(System.out::println);
                    break;

                case 4:
                    List<LogEntry> suspicious =
                            detector.detectSuspicious(manager.getAccountLogsMap());

                    if (suspicious.isEmpty())
                        System.out.println("No suspicious activity detected.");
                    else
                        suspicious.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Action Type: ");
                    ActionType type = ActionType.valueOf(sc.nextLine().toUpperCase());

                    List<LogEntry> actionLogs = manager.getLogsByAction(type);

                    if (actionLogs.isEmpty())
                        System.out.println("No logs found.");
                    else
                        actionLogs.forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

