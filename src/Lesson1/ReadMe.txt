/**
 * There are 2 ways to create a thread in java:
 * 1. Implement Runnable interface
 *      advantage: you can extend from any class you want, does not minimize your extension options, not as heavy as the Thread API.
 *      disadvantage: you need to wrap it in a thread class in order to inherit the "start" method.
 *
 * 2. Extend Thread class
 *      advantage: you inherit all Thread functionality (start, ....)
 *      disadvantage: you inherit all Thread functionality even if you need only specific functionality, prevents other class extensions.
 *
 *   In both options you must implement the method run()     !!!!
*/