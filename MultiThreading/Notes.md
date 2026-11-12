1: A thread is an independent path of execution within a program. Until now, your code has run on one thread, the main thread. Threads let a program do several things at once, such as downloading a file while the user keeps working in the interface.

2: Two rules to remember:
    - Call start(), not run(). start() creates a new thread. Calling run() directly just executes the code on the current thread, so no concurrency happens.
    - The order of output between threads is not guaranteed. “Main continues” may print before or after the task’s line.

3: Waiting with join()
    - join() makes the current thread wait until another thread finishes: