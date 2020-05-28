# 5.17
## 约瑟夫环
```

/*循环链表--约瑟夫环(自己写的)*/
#if 1
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct node{
    int id;
    struct node* next;
}Node;

typedef struct {
    Node* head;
    int length;
}CircleList;


CircleList* initLinkedList(){
    CircleList* pList = malloc(sizeof(CircleList));
    pList->head = NULL;
    pList->length = 0;
    return pList;
}

Node* find_pos(CircleList* plist, int n){
    if(n > plist->length || n < 0){
        printf("查找位置不正确：%d\n", n);
        return NULL;
    }
    
    Node* t = plist->head;
    while(n >= 1){
        t = t->next;
        n--;
    }
    
    return t;
}

void insert(CircleList* list, int id, int pos){
    if(pos > list->length || pos < 0){
        printf("插入位置不正确\n");
        return;
    }
    
    Node* newNode = (Node*)malloc(sizeof(Node));//为新结点分配空间
    newNode->id = id;
    
    if(pos == 0){
        //新结点为头结点
        //1.查找最后一个结点
        Node* plist = find_pos(list, list->length-1);
        if(plist == NULL){
            //原来的链表为空链表
            list->head = newNode;
            newNode->next = newNode;//循环链表尾结点指向头结点，目前只有一个结点，自己指自己
        }else{
            //正常插入头结点
            //1. 新结点的next指向原来的0号结点
            newNode->next = list->head;
            //2. list->head 指向新结点
            list->head = newNode;
            //3. last结点的next指向新结点
            plist->next = newNode;
        }
        list->length++;
        return;
    }else{
        //pos不为0
        Node* pre = list->head;
        //非头结点
        while(pos > 1){
            pos--;
            pre = pre->next;
        }
        
        newNode->next = pre->next;
        pre->next = newNode;
        list->length++;
        return;
        
    }
}

void delete(CircleList* list, int pos) {
    if (pos >= list->length || pos < 0) {
        printf("删除的位置不正确\n");
        return;
    }
    
    if (pos == 0) {
        Node* head = list->head; // 释放原来的head节点，不做要求
        list->head = list->head->next; // head 指向原来节点的下一个节点
        list->length--;
        free(head);              // 释放内存, 不做要求
    } else {
        Node* pre = list->head;
        while(pos > 1) {
            pre = pre->next;
            pos--;
        }
        Node* t = pre->next;    //不做要求
        pre->next = pre->next->next;
        list->length--;
        free(t);                //不做要求
    }
}


void displayList(CircleList* list) {
    Node* t = list->head;
    for(int i = 0; i < list->length; i++){
        printf("%4d",t->id);
        t = t->next;
    }
    printf("\n");
    
    
    //    while(t->next != list->head) {
    //        printf("%d\n", t->id);
    //        t = t->next;
    //    }
    //    printf("%d  ", t->id);
    //    printf("\n");
    
}

void yuesefu(CircleList* list, int number){
    while(list->length > number-1){
        Node* temp = (Node*)malloc(sizeof(Node));
        temp = list->head;
        
        for (int i = 0; i < number-1; i++){
            temp = temp->next;
        }
        
        printf("***删除%d***\n",temp->id);
        delete(list, number-1);
        list->head = temp->next;
        
        displayList(list);
        printf("\n");
    }
}


int main(){
    CircleList* pList = initLinkedList();
    for(int i = 1; i <= 10; i++){
        insert(pList, i, pList->length);
    }
    
    displayList(pList);

    yuesefu(pList, 3);
    
}

#endif

/*-----------------------------------------------------------------*/

/*-----------------------------------------------------------------*/

/*-----------------------------------------------------------------*/

/*-----------------------------------------------------------------*/
/*循环链表--约瑟夫环(老师写的)*/

#if 0

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node {
    int id;
    struct node * next;
} Node;

typedef struct {
    int length;
    Node* head;
} CircleList;


CircleList* initCircleList() {
    CircleList* pList = malloc(sizeof(CircleList));
    pList->head = NULL;
    pList->length = 0;
    return pList;
}

Node* find_pos(CircleList* plist, int n) {
    // if (n >= plist->length || n < 0) {
    if (n < 0) {
        printf("查找位置不正确： %d\n", n);
        return NULL;
    }
    
    Node* t = plist->head;
    while(n >= 1) {
        t = t->next;
        n--;
    }
    return t;
}

void insert(CircleList* pList, int id, int pos) {
    if (pos > pList->length || pos < 0) {
        printf("插入的位置不正确\n");
        return;
    }
    
    Node* newNode = (Node*)malloc(sizeof(Node)); //为新节点分配空间
    newNode->id = id;
    
    if (pos == 0) {
        // 新的节点是头结点
        // 1. 查找最后一个节点
        Node* plast = find_pos(pList, pList->length-1);
        if (plast == NULL) {
            // 原来的链表是空链表
            pList->head = newNode;
            newNode->next = newNode;
        } else {
            // 正常插入头节点
            // 1. 新节点的next指向原来的0号节点
            newNode->next = pList->head;
            // 2. pList->head 指向 新节点
            pList->head = newNode;
            // 3. last节点的next指向新节点
            plast->next = newNode;
        }
        pList->length++;
        return;
    } else {
        // pos不为0的情况
        Node* pre = pList->head;
        // 非头结点
        while(pos > 1) {
            pos--;
            pre = pre->next;
        }
        newNode->next = pre->next;
        pre->next = newNode;
        pList->length++;
        return;
    }
}

int delete(CircleList* pList, int pos) {
    int r;
    
    //if (pos >= pList->length || pos < 0) {
    if (pos < 0) {
        printf("删除的位置不正确\n");
        return -1;
    }
    
    if (pos == 0) {
        Node* pLast = find_pos(pList, pList->length-1);
        if (pLast != pList->head) {
            // 多余一个元素
            Node* t = pList->head; //不做要求
            r = t->id;
            pList->head = pList->head->next; // 现在的0节点指向原来的1节点
            pLast->next = pList->head; // 现在的尾节点指向现在的0节点
            
            free(t); //不做要求
            
        } else {
            // 只有1个元素
            r = pList->head->id;
            free(pList->head); //不做要求
            pList->head = NULL;
        }
    } else {
        Node* pre = find_pos(pList, pos-1);
        Node* t = pre->next;    //不做要求
        pre->next = pre->next->next;
        r = t->id;
        free(t);                //不做要求
    }
    pList->length--;
    return r;
}

void displayList(CircleList* pList) {
    Node* t = pList->head;
    for(int i = 0; i < pList->length; i++) {
        printf("%4d", t->id);
        t = t->next;
    }
    printf("\n");
    /*
     Node* t = pList->head;
     while(t->next != pList->head) {
     printf("%d\n", t->id);
     t = t->next;
     }
     printf("%d\n", t->id);
     printf("\n");
     */
}

int main() {
    CircleList* pList = initCircleList();
    for(int i = 1; i <= 10; i++) {
        insert(pList, i, pList->length);
    }
    displayList(pList);
    printf("**************\n");
    
    // 从1到4数到4的人
    while(pList->length > 2) {
        int d = delete(pList, 2);
        printf("delete %d\n", d);
        Node* p = find_pos(pList, 2);
        pList->head = p;
        displayList(pList);
    }
    
}

#endif




```

