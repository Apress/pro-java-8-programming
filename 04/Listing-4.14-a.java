Runnable runnable;
ThreadGroup myGroup = new ThreadGroup("My ThreadGroup");
.
.
.
Thread t = new Thread(myGroup, runnable);
