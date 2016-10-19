DelayQueue queue = new DelayQueue();
DelayedReminder reminder = new DelayedReminder("Wake me up in 60 seconds", 60);
queue.add(reminder);
reminder = new DelayedReminder("Wake me up in 30 seconds", 30);
queue.add(reminder);