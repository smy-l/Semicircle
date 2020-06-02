# 6.2 
## 实现二分查找(binarySearch)
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

void quickSort(int a[], int begin, int end) {
    if (begin >= end)
        return;
    int i, j;
    i = begin+1;
    j = end;
    int c = a[begin];

    while(i <= j) {
        for( ; i <= end; i++) {
            if (a[i] > c)
                break;
        }

        if (i == end+1) {
            // begin就是最大值
            swap(a, begin, end);
            // 继续处理 begin .. end-1
            return quickSort(a, begin, end-1);
        }
        // 找j
        for (; j > begin; j--) {
            if (a[j] < c)
                break;
        }

        if (j == begin) {
            // begin 就是最小值
            printf("j:a[j] = %d:%d 为最小值\n", j, a[j]);
            // 继续处理 begin+1 .. end
            return quickSort(a, begin+1, end);
        }

        if (i < j) {
            swap(a, i, j);
            printf("交换%d和%d\n", i, j);
            printArray(a, SIZE);
            i++;
            j--;
        }
    }
    swap(a, begin, j);
    // 处理 bgein .. j-1
    quickSort(a, begin, j-1);
    // 处理 j+1 .. end
    quickSort(a, j+1, end);
}

int binarySearch(int a[], int elem){
    int mid;
    int low = 0;
    int high = SIZE;
    while(low <= high){
        mid = (low + high) / 2;
        if(a[mid] == elem){
            printf("查找元素在数组第%d个位置\n",mid);
            return mid;
        }else{
            if(a[mid] < elem){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    }
    printf("该数组中没有该元素\n");
    return -1;
}

int main() {

    srand((unsigned)(time(NULL)));
    /*
    int a[] = {4, 5, 6, 7, 3, 2, 1};
    */
    
    
    int a[SIZE];
    for (int i = 0; i < SIZE; i++) {
        a[i] = rand() % 100;
    }
    
    printArray(a, SIZE);

    quickSort(a, 0, SIZE-1);

    printArray(a, SIZE);
    
    binarySearch(a, 69);
    return 0;
}




```