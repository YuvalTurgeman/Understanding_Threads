in the upcoming example we have 2 threads trying to increment an integer variable AT THE SAME TIME
we will expect that the value count at the end of the run will be 20000
but as we can see after running the program, it is not the case.

count++ is not an atomic action, its equal to count = count + 1 which is actually comprised out of 3 actions:
1. reading the current count value.
2. adding a 1 to it (incrementing it).
3. assigning the new value to the count variable.

the fact that count++ is comprised out of multiple actions means that at any given moment
(assuming we did not synchronize the operation), when thread number 1 is trying to increment count,
thread number 2 can interrupt its actions and compromise the operation.
for example:

thread number 1 is reading current value of count
contact switch
thread number 2 is reading current value of count
thread number 2 is incrementing the value of count
contact switch
thread number 1 increments the current value of count
contact switch
thread number 2 is storing the new value to count
thread number 1 is storing the new value to count

as we can wee, instead of incrementing twice, we actually increment only once.

in order to solve this problem we use thread synchronization,
we explicitly decide which code block can be run at any given time only by a single
thread and cannot be interrupted by another, which allows the thread to finish
its desired job before we move on and let a different thread perform any kind of work.