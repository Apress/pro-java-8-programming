public class DelayedReminder implements Delayed {

    private String reminderText;
    private long delayInSeconds;

    public DelayedReminder(String reminder, long seconds) {
        reminderText = reminder;
        delayInSeconds = seconds;
    }

    public String getReminderText() {
        return reminderText;
    }

    public long getDelay(TimeUnit timeUnit) {
        return TimeUnit.SECONDS.convert(delayInSeconds, timeUnit);
    }

    public int compareTo(Delayed delayed) {
        return (int)(delayInSeconds - delayed.getDelay(TimeUnit.SECONDS));
    }

}