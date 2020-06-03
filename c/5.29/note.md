# 5.29
## 栈
### 栈（数组）
```
#if 0
#include <stdio.h>
#include <stdlib.h>

#define QUEUE_LEN 5

typedef struct {
    int a[QUEUE_LEN];
    int realtop;
    int realend;
    int top;
    int end;
} Queue;

int isFull(Queue queue);

void printQueue(Queue queue) {
    
    if (queue.end > queue.top) {
        for (int i = queue.top; i < queue.end; i++) {
            printf("%4d", queue.a[i]);
        }
    }
    else if (isFull(queue) || queue.end < queue.top){
        for (int i = queue.top; i < QUEUE_LEN; i++) {
            printf("%4d", queue.a[i]);
        }
        for (int i = 0; i < queue.end; i++) {
            printf("%4d", queue.a[i]);
        }
    } else {
        // 队列为空
    }
    
    printf("\n");
}

Queue enqueue(Queue queue, int elem) {
    if (!isFull(queue)) {
        queue.a[queue.end] = elem;
        queue.end++;
        queue.realend++;
        if (queue.end >= QUEUE_LEN){
            queue.end = queue.end % QUEUE_LEN;
        }
    } else {
        printf("队列满了，不能入队列\n");
    }
    return queue;
}

Queue dequeue(Queue queue, int *t) {
    *t = queue.a[queue.top];
    queue.top++;
    queue.realtop++;
    if (queue.top >= QUEUE_LEN) {
        queue.top = queue.top % QUEUE_LEN;
    }
    return queue;
}

int peep(Queue queue) {
    return queue.a[queue.top];
}

int isEmpty(Queue queue) {
    if (queue.realend == queue.realtop)
        return 1;
    else
        return 0;
}

int isFull(Queue queue) {
    return ((queue.end == queue.top) && (queue.realend > queue.realtop));
}
    
int main() {
    Queue queue;
    queue.end = 0;
    queue.top = 0;
    queue.realend = queue.realtop = 0;
    int t;
    for (int i = 100; i < 110; i++) {
        queue = enqueue(queue, i);
        printQueue(queue);
    }
    printQueue(queue);
    
    for (int i = 100; i < 110; i++) {
        queue = dequeue(queue, &t);
        printf("出队列的元素是 %d\n", t);
    }
    printQueue(queue);
    
    for (int i = 0; i < 20; i++) {
        queue = enqueue(queue, 100 + i);
    }
    for (int i = 0; i < 5; i++) {
        queue = dequeue(queue, &t);
        printf("出队列的元素是 %d\n", t);
    }
    printQueue(queue);
}

#endif
```

### 栈（链表）
```
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int elem;
    struct node* next;
} Node, Stack;

Stack* initStack() {
    return NULL;
}

void print_list(Node* head) {
    printf("*** print a list*** \n");
    while(head != NULL) {
        printf("%4d", head->elem);
        head = head->next;
    }
    printf("\n");
}


Stack* push(Stack* pStack, int elem) {
    Stack* pNew = malloc(sizeof(Stack));
    pNew->elem = elem;
    pNew->next = pStack;
    return pNew;
}

Stack* pop(Stack* pStack, int* t) {
    *t = pStack->elem;
    return pStack->next;
}

int is_empty(Stack* pStack) {
    if (pStack == NULL) {
        return 1;
    } else {
        return 0;
    }
}

int peep(Stack* pStack) {
    return pStack->elem;
}

int main() {
    Stack* pStack = NULL;
    // 10
    Stack* pNew = malloc(sizeof(Stack));
    pNew->elem = 10;
    pNew->next = pStack;
    pStack = pNew;

    //pStack = malloc(sizeof(Stack));
    //pStack->elem = 10;
    //pStack->next = NULL;
    print_list(pStack);
    
    
    // 20
    pNew = malloc(sizeof(Stack));
    pNew->elem = 20;
    pNew->next = pStack;
    pStack = pNew;
    print_list(pStack);
    
    // 30
    pStack = push(pStack, 30);
    print_list(pStack);
    
    int t;
    t = pStack->elem;
    printf("弹出%d\n", t);
    pStack = pStack->next;
    print_list(pStack);
    
    pStack = pop(pStack, &t);
    printf("弹出%d\n", t);
    print_list(pStack);

    
    pStack = pop(pStack, &t);
    printf("弹出%d\n", t);
    print_list(pStack);
    
    if (is_empty(pStack)) {
        printf("空栈，弹出失败\n");
    } else {
        pStack = pop(pStack, &t);
        printf("弹出%d\n", t);
        print_list(pStack);
    }

}

#endif

```