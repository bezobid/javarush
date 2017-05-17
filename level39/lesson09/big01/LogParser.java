package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.*;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;

    public LogParser(Path logDir) {

        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<LogEntry> filteredByDate = filterLogByDate(after, before);
        Set<String> ips = new HashSet<>();

        for (LogEntry entry : filteredByDate) {
            ips.add(entry.getIp());
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {

        Set<LogEntry> filteredByDate = filterLogByDate(after, before);
        Set<String> ips = new HashSet<>();

        for (LogEntry entry : filteredByDate) {
            if (entry.getUser().equals(user)) {
                ips.add(entry.getIp());
            }
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {

        Set<LogEntry> filteredByDate = filterLogByDate(after, before);
        Set<String> ips = new HashSet<>();

        for (LogEntry entry : filteredByDate) {
            if (entry.getEvent().equals(event)) {
                ips.add(entry.getIp());
            }
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {

        Set<LogEntry> filteredByDate = filterLogByDate(after, before);
        Set<String> ips = new HashSet<>();

        for (LogEntry entry : filteredByDate) {
            if (entry.getStatus().equals(status)) {
                ips.add(entry.getIp());
            }
        }

        return ips;
    }

    private Set<LogEntry> filterLogByDate(Date after, Date before) {
        Set<LogEntry> filtered = new HashSet<>();
        Set<LogEntry> entries = getLogEntries();

        if (after != null && before != null) {
            for (LogEntry entry : entries) {
                if (entry.getDate().getTime() >= after.getTime() &&
                        entry.getDate().getTime() <= before.getTime()) {
                    filtered.add(entry);
                }
            }
        } else if (after == null && before != null) {
            for (LogEntry entry : entries) {
                if (entry.getDate().getTime() <= before.getTime()) {
                    filtered.add(entry);
                }
            }
        } else if (after != null && before == null) {
            for (LogEntry entry : entries) {
                if (entry.getDate().getTime() >= after.getTime()) {
                    filtered.add(entry);
                }
            }
        } else if (after == null && before == null) {
            for (LogEntry entry : entries) {
                filtered.add(entry);
            }
        }

        return filtered;
    }

    private ArrayList<String> getLines() {

        ArrayList<String> lines = new ArrayList<>();
        File dir = logDir.toFile();

        if (logDir == null || dir == null) return lines;

        if (Files.isDirectory(logDir)) {
            for (File file : dir.listFiles()) {
                lines.addAll(getLinesFromFile(file));
            }
        } else if (dir.isFile()) {
            lines.addAll(getLinesFromFile(dir));
        }

        return lines;
    }

    private ArrayList<String> getLinesFromFile(File file) {
        ArrayList<String> lines = new ArrayList<>();

        if (!file.getName().endsWith(".log")) return lines;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {


            while (reader.ready()) {
                lines.add(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private Set<LogEntry> getLogEntries() {
        Set<LogEntry> entries = new HashSet<>();

        for (String line : getLines()) {
            String[] words = line.split("\t");

            String ip = words[0];
            String name = words[1];

            String dateString = words[2];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date date = null;
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Event event;
            int task = 0;

            String[] eventSplit = words[3].split(" ");
            event = Event.valueOf(eventSplit[0]);

            if (eventSplit.length == 2 && event.equals(Event.DONE_TASK) || event.equals(Event.SOLVE_TASK)) {
                task = Integer.parseInt(eventSplit[1]);
            }

            Status status = Status.valueOf(words[4]);

            LogEntry entry = new LogEntry(ip, name, date, event, task, status);
            entries.add(entry);
        }


        return entries;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : getLogEntries()) {
            users.add(entry.getUser());
        }

        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {

        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            users.add(entry.getUser());
        }

        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        int events = 0;
        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getUser().equals(user)) {
                events++;
            }
        }
        return events;
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getIp().equals(ip)) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(Event.LOGIN)) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(Event.WRITE_MESSAGE)) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(Event.SOLVE_TASK)) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(Event.SOLVE_TASK) && entry.getTaskNumber() == task) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(Event.DONE_TASK)) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(Event.DONE_TASK) && entry.getTaskNumber() == task) {
                users.add(entry.getUser());
            }
        }
        return users;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getEvent().equals(event) && entry.getUser().equals(user)) {
                dates.add(entry.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getStatus().equals(Status.FAILED)) {
                dates.add(entry.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getStatus().equals(Status.ERROR)) {
                dates.add(entry.getDate());
            }
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        ArrayList<Date> dates = new ArrayList<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getUser().equals(user) && entry.getEvent().equals(Event.LOGIN)) {
                dates.add(entry.getDate());
            }
        }

        if (dates.size() == 0) return null;

        Collections.sort(dates);

        return dates.get(0);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        ArrayList<Date> dates = new ArrayList<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getUser().equals(user) && entry.getEvent().equals(Event.SOLVE_TASK) && entry.getTaskNumber() == task) {
                dates.add(entry.getDate());
            }
        }

        if (dates.size() == 0) return null;

        Collections.sort(dates);

        return dates.get(0);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        ArrayList<Date> dates = new ArrayList<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getUser().equals(user) && entry.getEvent().equals(Event.DONE_TASK) && entry.getTaskNumber() == task) {
                dates.add(entry.getDate());
            }
        }

        if (dates.size() == 0) return null;

        Collections.sort(dates);

        return dates.get(0);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getUser().equals(user) && entry.getEvent().equals(Event.WRITE_MESSAGE)) {
                dates.add(entry.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getUser().equals(user) && entry.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                dates.add(entry.getDate());
            }
        }
        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            events.add(entry.getEvent());
        }

        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getIp().equals(ip)) {
                events.add(entry.getEvent());
            }
        }

        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getUser().equals(user)) {
                events.add(entry.getEvent());
            }
        }

        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getStatus().equals(Status.FAILED)) {
                events.add(entry.getEvent());
            }
        }

        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getStatus().equals(Status.ERROR)) {
                events.add(entry.getEvent());
            }
        }

        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getTaskNumber() == task && entry.getEvent().equals(Event.SOLVE_TASK)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;

        for (LogEntry entry : filterLogByDate(after, before)) {
            if (entry.getTaskNumber() == task && entry.getEvent().equals(Event.DONE_TASK)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> tasks = new HashMap<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            int task = entry.getTaskNumber();
            if (entry.getTaskNumber() > 0 && entry.getEvent().equals(Event.SOLVE_TASK)) {
                if (tasks.containsKey(entry.getTaskNumber())) {
                    int oldCount = tasks.get(task);
                    tasks.put(task, oldCount + 1);
                } else {
                    tasks.put(task, 1);
                }
            }
        }

        return tasks;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> tasks = new HashMap<>();

        for (LogEntry entry : filterLogByDate(after, before)) {
            int task = entry.getTaskNumber();
            if (entry.getTaskNumber() > 0 && entry.getEvent().equals(Event.DONE_TASK)) {
                if (tasks.containsKey(entry.getTaskNumber())) {
                    int oldCount = tasks.get(task);
                    tasks.put(task, oldCount + 1);
                } else {
                    tasks.put(task, 1);
                }
            }
        }

        return tasks;
    }

    @Override
    public Set<Object> execute(String query) {

        Set<Object> result = new HashSet<>();

        switch (query) {
            case "get ip":
                result.addAll(getUniqueIPs(null, null));
                break;
            case "get user":
                result.addAll(getAllUsers());
                break;
            case "get date":
                for (LogEntry entry : getLogEntries()) {
                    result.add(entry.getDate());
                }
                break;
            case "get event":
                result.addAll(getAllEvents(null, null));
                break;
            case "get status":
                for (LogEntry entry : getLogEntries()) {
                    result.add(entry.getStatus());
                }
        }

        String[] words = query.split(" ");

        if (words.length >= 6 ) {

            String field1 = words[1];
            String field2 = words[3];
            String value1;
            Date after = null;
            Date before = null;
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

            if (query.contains(" and date between")){
                value1 = query.substring(query.indexOf("\"") + 1, query.indexOf(" and date between") - 1);
                String[] dates = query.split("\"");
                try {
                    before = format.parse(dates[dates.length - 1]);
                    after = format.parse(dates[dates.length - 3]);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else{
                value1 = query.substring(query.indexOf("\"") + 1, query.lastIndexOf("\""));
            }

            for (LogEntry entry : filterLogByDate(after, before)) {

                if (field2.equals("ip") && entry.getIp().equals(value1)) {
                    result.add(getFieldByName(entry, field1));
                } else if (field2.equals("user") && entry.getUser().equals(value1)) {
                    result.add(getFieldByName(entry, field1));
                } else if (field2.equals("date")) {


                    try {
                        if (entry.getDate().equals(format.parse(value1))) {
                            result.add(getFieldByName(entry, field1));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else if (field2.equals("event")) {
                    Event event = Event.valueOf(value1);
                    if (entry.getEvent().equals(event)) {
                        result.add(getFieldByName(entry, field1));
                    }
                } else if (field2.equals("status")) {
                    Status status = Status.valueOf(value1);
                    if (entry.getStatus().equals(status)) {
                        result.add(getFieldByName(entry, field1));
                    }
                }
            }
        }

        return result;
    }

    public Object getFieldByName(LogEntry entry, String fieldName) {
        Object object = null;

        try {
            Field field = LogEntry.class.getField(fieldName);
            field.setAccessible(true);
            object = field.get(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    private static class LogEntry {

        public String ip;
        public String user;
        public Date date;
        public Event event;
        public int taskNumber;
        public Status status;

        public LogEntry(String ip, String user, Date date, Event event, int taskNumber, Status status) {
            this.ip = ip;
            this.user = user;
            this.date = date;
            this.event = event;
            this.taskNumber = taskNumber;
            this.status = status;
        }

        public String getIp() {
            return ip;
        }

        public String getUser() {
            return user;
        }

        public Date getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public int getTaskNumber() {
            return taskNumber;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    "ip='" + ip + '\'' +
                    ", user='" + user + '\'' +
                    ", date='" + date + '\'' +
                    ", event=" + event +
                    ", taskNumber=" + taskNumber +
                    ", status=" + status +
                    '}';
        }
    }
}
