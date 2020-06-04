# 6.4 C-test
1. 一共1000个苹果，有任意多个箱子用来装苹果，要求一个或多个箱子中的苹果数量之和可以得到1到1000中的任意数目到苹果。<br>
请问最小需要多少个箱子才能满足上述条件？<br>
答：10个数<br>
    1 2 4 8 16 32 64 128 256 489

2. 使用直线划分空间
    1. 写出公式
    L(n) = n*(n+1)/2+1;
    2. 使用C语言实现计算L(n)函数
    ```
    #include <stdio.h>

    int calc_spaces(int n){
        int L = 1;
        /*
        n  0   1   2   3   4   5
        L  1   2   4   7   11  16
        */
        L = n * (n + 1) / 2 + 1;
        return L;
    }

    int main(){
        int n; //线的数量
        int L = 1; //空间数
    
        printf("Please input n\n");
        scanf("%d",&n);
    
        L = calc_spaces(n);
    
        printf("%d条直线最多能划分%d个空间\n",n,L);
    
        return 0;
    }
    ```
3. 使用折线划分空间
    1. 写出公式
    Z(n) = n * (n + 1) + (n - 1)
    2. 使用C语言实现计算Z(n)的函数
    ```
    #include <stdlib.h>
    #include <stdio.h>

    int calc_aig_spaces(int n){
    int result = 1;
    /*
     n    0  1  2  3  4
     Z(n) 1  2  7  14 23
     Z(n) = n*(n+1)+(n-1)
     */
    if(n == 0){
    
    }else{
        result = n * (n + 1) + (n - 1);
    }
    return result;
    }

    int main(){
        int n; //线的数量
        int Z = 1; //空间数
    
        printf("Please input n(n >= 0)\n");
        scanf("%d",&n);
    
        Z = calc_aig_spaces(n);
    
        printf("%d根折线最多能划分%d个空间\n",n,Z);
    
        return 0;
    }
    ```
4. 打印三角形
    ```
    #include <stdio.h>
    #include <stdlib.h>
    
    void draw(unsigned int n);  //n > 0

    void draw(unsigned int n){
        int a[n][n];
        for(int i = 0; i < n; i++){
            a[i][0] = i + 1;
            a[i][i] = i + 1;
        }
        for(int i = 2; i < n; i++){
            for (int j = 1; j < i; j++) {
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }
    
        for (int i = 0; i < n; i++) {
            for(int j = n; j >i ; j--){
                printf("  ");
            }
        
            for(int j = 0; j <= i; j++){
                printf("%4d",a[i][j]);
            }
            printf("\n");
        }
        printf("\n");
    }

    int main(){
        unsigned int n;
        printf("Please input n(n>0)\n");
        scanf("%d",&n);
    
        draw(n);
    
        return 0;
    }
    ```
5. 实现atof函数
    ```
    #include <stdio.h>
    #include <stdlib.h>
    #include <string.h>

    double my_atof(char *nptr){
        double a = 0.0;
        double b = 10.0;

        while(*nptr == ' '){
            nptr++;
        }

        while(*nptr >= '0' && *nptr <='9' && *nptr !='.')//计算小数点前整数部分
        {
            a = a * 10.0 + *nptr - '0';//*nptr - '0'是将字符转换为整形数字
            nptr++;
        }
    
        if(*nptr == '.')//小数点
            nptr++;
    
        while(*nptr >= '0' && *nptr <= '9')//计算小数部分
        {
            a = a + (*nptr - '0')/b;
            b *= 10.0;
            nptr++;
        }
    
        printf("%lf\n",a);
        return a;
    }

    int main(){
        char a[10];
        printf("Please input nums:\n");
        scanf("%s",a);
    
        my_atof(a);
    
        return 0;
    }
    ```
6. 使用栈的数据结构实现队列功能
```
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct stack{
    int elem;
    struct stack *next;
} Stack, Queue;
Stack* init_stack(void);
void free_stack(Stack* head);
int push(Stack* head, int elem);
int pop(Stack* head);
int top(Stack* head);
int is_full(Stack* head);
int is_empty(Stack* head);
void enqueue(Queue* queue, int data);
int dequeue(Queue* queue);

Stack* init_stack(void) {
    Stack* head = malloc(sizeof(Stack));
    head->next = NULL;
    return head;
}
void free_stack(Stack* head) {
    Stack* t;
    while(head->next != NULL) {
        t = head->next;
        free(head);
        head = t;
    }
    free(head);
}
/*
 * === FUNCTION =============================================================
 * Name: push
 * Description: 将元素elem压栈
 * Return: 成功-1；失败-0
 * ============================================================================
 */
int push(Stack* head, int elem) {
    Stack *new_node = malloc(sizeof(Stack));
    if (new_node == NULL) {
        // 分配内存失败
        return 0;
    }
    new_node->elem = elem;
    new_node->next = head->next;
    head->next = new_node;
    return 1;
}
/*
 * === FUNCTION =============================================================
 * Name: pop
 * Description: 弹出栈顶节点, 返回该节点的元素值
 * 注意栈为空时应报错
 * ============================================================================
 */
int pop(Stack* head) {
    if (is_empty(head)) {
        printf("stack is empty\n");
        return INT_MIN;
    }
    Stack* t = head->next;
    head->next = t->next;
    int elem = t->elem;
    free(t);
    return elem;
}
/*
 * === FUNCTION =============================================================
 * Name: top
 * Description: 返回栈顶节点元素的值
 * 注意栈为空时应报错
 * ============================================================================
 */
int top(Stack* head) {
    if (is_empty(head)) {
        printf("stack is empty\n");
        return INT_MIN;
    }
    return head->next->elem;
}
/*
 * === FUNCTION =============================================================
 * Name: is_empty
 * Description:
 * Return: 1: 为空； 0: 不为空
 * ============================================================================
 */
int is_empty(Stack* head) {
    return (head->next == NULL)?1:0;
}

void enqueue(Queue* queue, int data){
    push(queue, data);
}

int dequeue(Queue* queue){
    //将queue栈中的元素压入到stack栈中
    Stack* temp = queue->next;
    Stack* stack = init_stack();
    while(temp != NULL){
        push(stack, temp->elem);
        temp = temp->next;
    }

    //出栈，stack栈中元素少1
    int out = pop(stack);
    
    //将queue栈中元素清空
    while(!is_empty(queue)){
        pop(queue);
    }
    
    //将satck中元素压入到queue栈中
    while(stack->next != NULL){
        push(queue, stack->next->elem);
        stack = stack->next;
    }
    
    return out;
}

int main(void) {
    
    Queue* queue = init_stack();
    int a[5] = {1, 2, 3, 4, 5};
    for(int i = 0; i < 5; i++) {
        enqueue(queue, a[i]); // 可按照自己的函数定义进行修改
    }


    for (int i = 0; i < 5; i++) {
        int out = dequeue(queue);// 可按照自己的函数定义进行修改
        printf("%3d", out);
    }
    printf("\n");
    return 0;
}
```

