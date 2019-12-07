# Sorter Visualizer

A Java visualizer for common sorting algorithms, written using Swing. Features:

* Change algorithms to visualize
* Adjustable array size and number range
* Adjustable delay between steps (logarithmetic scale)
* Change render style between bar graph and circle graph
* Built using built-in Swing library
* Thread safe

![image](https://i.imgur.com/icBfNv0.png)

## Included algorithms

* Bubble Sort

* Counting Sort

* Double Selection Sort

* Insertion Sort

* Pigeonhole Sort

* Quick Sort (inplace)

* Radix Sort (Base 10 LSD)

* Radix Sort (Base 2 LSD)

* Selection Sort

## File/package breakdown

* `framework/MyArray`: Holds the numbers to be sorted
* `framework/Sorter`: General definition of a Sorter    
    * `sorters/`: The root package for all sorters
* `framework/WindowManager`: Manages all Swing UI
* `Main`: Entry point for program