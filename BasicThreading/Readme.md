# Basic Thread Ticker

Create an Android application with a single activity and a time ticker thread running in background. 
The worker thread maintains an internal counter which is incremented every second. 
For each iteration, the counter value must be printed in the LogCat debugging console. 
Add two buttons to the main activity: "Start" and "Stop". The "Start" button must reset the counter and start counting. The "Stop" button must stop counting. 

Tips:
Use Log.d() to print the ticking messages.
Use Thread.sleep() to block the worker thread for a programmable amount of time.
To stop the worker thread from the main thread, invoke the interrupt() method of the worker thread and return from the worker thread's loop if an interrupt occurs.
