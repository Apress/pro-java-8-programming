ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
.
.
.
Runnable runner = getNextTask();
executor.execute(runner);
