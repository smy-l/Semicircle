# 6.1
## 复杂度
选择排序、冒泡排序、插入排序复杂度为O(n*n);

快速排序最差情况下复杂程度为O(n*n);
最好情况为n*log(n);

## 代码
```
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 10

void swap(int a[], int i, int j);
int findMin(int a[], int begin, int end);
void printArray(int a[], int len);
void bubbleSort(int a[], int len);
void selectSort(int a[], int len);

int findMin(int a[], int begin, int end) {
    int min = begin;
    for (int i = begin+1; i <= end; i++) {
        if (a[i] < a[min])
            min = i;
    }
    return min;
}

void printArray(int a[], int len) {
    for (int i = 0; i < len; i++) {
        printf("%4d", a[i]);
    }
    printf("\n");
}


void bubbleSort(int a[], int len) {
    for (int j = len-1; j >= 1; j--) {
        int swapHappen = 0;
        for( int i = 0; i < j; i++) {
            if (a[i] > a[i+1]) {
                swap(a, i, i+1);
                swapHappen = 1;
            }
        }
        if (swapHappen == 0) {
            break;
        }
    }
}

void selectSort(int a[], int len) {
    for (int i = 0; i <= len-2; i++) {
        int min = findMin(a, i, len-1);
        swap(a, i, min);
    }
}


void swap(int a[], int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
}

void insertSort(int a[], int len) {
    for (int i = 1; i < len; i++) {
        while(a[i] < a[i-1]) {
            swap(a, i, i-1);
            i--;
            if (i == 0)
                break;
        }
    }
}

void insertSort2(int a[], int len) {
    int i;
    int j;
    for (i = 1; i < len; i++) {
        // 1. 从i-1...j a[j] < a[i]
        for (j = i-1; j >= 0; j--) {
            if (a[j] < a[i])
                break;
        }
        // 2. j+1 .. i-1 向右移
        int t = a[i];
        for (int k = i-1; k >= j+1; k--) {
            a[k+1] = a[k];
        }
        // 3. a[j+1] = a[i]
        a[j+1] = t;
    }
}

int main() {

    srand((unsigned)(time(NULL)));
    int a[SIZE];

    for (int i = 0; i < SIZE; i++) {
        a[i] = rand() % 100;
    }

    printArray(a, SIZE);

    //bubbleSort(a, SIZE);
    
    // int min = 0;
    // 1. a[n] -> min
    // for (int i = 1; i < SIZE; i++) {
    //     if (a[i] < a[min]) {
    //         min = i;
    //     }
    // }
    // min = findMin(a, 0, SIZE-1);
    // 2. swap(0, min)
    // swap(a, 0, min);


    // selectSort(a, SIZE);
    
    // i;
    
    insertSort2(a, SIZE);

    printArray(a, SIZE);

    return 0;
}


```
