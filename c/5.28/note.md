# 5.28
## 栈
```
#if 0
/*
 顺序栈
 */
#include <stdio.h>
#include <stdlib.h>

#define SIZE 5

typedef struct {
    int arr[SIZE];
    int top;
}Stack;



Stack* initStack(){
    Stack* stack = malloc(sizeof(Stack));
    stack->top = -1;
    return stack;
}

//is_full
int is_full(Stack* stack){
    if(stack->top < SIZE){
        return 0;
    }else{
        return 1;
    }
}


//push
int push(Stack* stack, int elem){
    if(is_full(stack)){
        return -1;
    }
    stack->top++;
    stack->arr[stack->top] = elem;
    return 0;
}
//是否为空
//是空返回1，或true
//非空返回0，或false

//is_empty
int is_empty(Stack* stack){
    if(stack->top == -1){
        //空
        return 1;
    }else{
        //非空
        return 0;
    }
}

//pop,成功返回0，失败返回-1；栈顶元素放到如参中返回
int pop(Stack* stack, int* pElem){
    if(is_empty(stack)){
        return -1;
    }else{
        int t = stack->arr[stack->top];
        *pElem = t;
        stack->top--;
        return 0;
    }
}

//peep
void peep(Stack* stack){
    int elem;
    if(is_empty(stack)){
        elem = stack->arr[stack->top];
        printf("栈顶元素为%d\n",elem);
    }else{
        printf("栈为空，无法查看\n");
    }
}


int main(){
    Stack* pStack = initStack();
    
    push(pStack, 10);
    push(pStack, 20);
    
    int elem;
    
    if(pop(pStack, &elem )== 0){
        printf("pop成功,弹出元素%d\n",elem);
    }else{
        printf("pop失败\n");
    }

    
    if(pop(pStack, &elem )== 0){
        printf("pop成功,弹出元素%d\n",elem);
        
    }else{
        printf("pop失败\n");
    }
    
}


#endif


/*---------------------------------------------------*/


/*---------------------------------------------------*/


/*---------------------------------------------------*/


/*---------------------------------------------------*/


#if 1
/*
 链栈
 */
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






