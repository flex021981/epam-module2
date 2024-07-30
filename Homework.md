**Tasks** 

Let's take as the base of our homework "Effective Java" book by Joshua Bloch. 

1) Implement cache service. Cache entries (objects) – simple custom class with one String field. Your cache service should have 2 methods: get and put. 

Your cache service should fit next requirements: 

    Max Size = 100 000 

    Eviction policy 

    Time-based on last access (5 seconds) 

    Removal listener 

    Just add to log of removed entry 

    Give statistic to user 

    Average time spent for putting new values into cache 

    Number of cache evictions 

    Support concurrency 

This task should be implemented in two ways: 

    Simple Java (60 points) (Strategy: LFU) 

    Guava (40 point) (Strategy: LRU) 

Don't forget about good tests, checkstyle and other staff that already included into your build phase.  

Total mark for it is 100 points

Extramile: 
2) Implement binary search algorithm: 

- recursively

- iteratively

- discover implementation effectiveness (using unit tests and benchmarks) and provide description of results in readme.md (discover complexity, provide time comparison, and explore which approach is more suitable in different situations). 

3) Implement merge-sort algorithm with desired complexity of O(N log(N)). Provide unit and benchmark tests.

4) Implement insertion-sort algorithm with desired complexity of O (N^2) in worst case and space complexity O (1). Provide unit and benchmark tests.

5) Integrate sort implementations into binary search implementation in the most efficient way using appropriate software design and patterns. Use parametrized tests for testing similar cases in different sort implementations. Use suggestions from “Effective java”.

6) Implement binary tree bypass algorithm. Become familiar with binary tree as data structure and its implementation\usage in JDK. 
 
