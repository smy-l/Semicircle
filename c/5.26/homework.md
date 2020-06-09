# 5.26
## 约瑟夫环
1. 理解约瑟夫环使用循环链表来解决的思路
```
10人，数到4
    0 1 2   4 5 6 7 8 9   out3   1
    0 1 2   4 5 6   8 9   out7   2
    0   2   4 5 6   8 9   out1   3
    0   2   4 5     8 9   out6   4
    0       4 5     8 9   out2   5
    0       4 5     8     out9   6
    0       4 5           out8   7
```
参考别人代码，大致思路为每当删除一个结点将其前一个结点next指针指向删除结点next，删除该结点


```
#include<stdio.h>
#include<stdlib.h>
typedef struct node {
	unsigned int number;    // 存放编号
	struct node * next;
}* pt,node;

		/*  循环链表创建 */
void creat (pt * head, int numb)   // head为 node **型，值传递
{								   // numb 为数量
	pt current, prev;
	* head = (pt) malloc (sizeof(node));
	prev = * head;
	for(int i = 1; numb--; i++)    // 创建numb个节点
	{
		current = (pt) malloc (sizeof(node));
		current->number = i;       // 按顺序编号
		prev->next = current;
		prev = current ;
	}
	current->next = (*head)->next;  //尾节点指回头结点
}

/* 解决约瑟夫问题 */
int yue(int m,int n)              // m为总人数，n为报数的次数
{
	pt head, current, prev; 
	creat(&head,m);               // 创建循环链表，m个节点
	current = head->next;
	for (jnt i = 1; i < m; i++)   // 循环 m - 1次， 剩下最后一个人
	{
		for (int j = 0; j < n - 1; j++)   // current指到报道n的人
		{
			current = current->next;
		}
		/* 删除当前编号  */
		prev = current->next;             
		current->number = current->next->number;
		current->next = current->next->next;
		free(prev);
	}
	return current->number;        // 返回最后一个人的编号
}


//测试
int main ()
{
	int m, n;
	while(scanf("%d %d", &m, &n) != EOF)
	{
		printf("最后一个出局的人为%d号\n", yue(m, n%m));
	}
 } 
void creat (pt * c, int a)
{
	pt current, prev;
	* c = (pt) malloc (sizeof(node));
	prev = * c;
	for(int i = 1; a--; i++)
	{
		current = (pt) malloc (sizeof(node));
		current->number = i;
		prev->next = current;
		prev = current ;
	}
	current->next = (*c)->next;
}

int yue(int m,int n)
{
	pt head, current, prev; 
	creat(&head,m);
	current = head->next;
	for (int i = 1; i < m; i++)
	{
		for (int j = 0; j < n - 1; j++)
		{
			current = current->next;
		}
		prev = current->next;
		current->number = current->next->number;
		current->next = current->next->next;
		free(prev);
	}
	return current->number;
}

```
2. 记住链表代码
```
#if 1
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct student {
    int age;
    char name[20];
} Student;

typedef struct node {
    Student st;
    struct node * next;
} Node;

typedef struct {
    int length;
    Node* head;
} LinkedList;


LinkedList* initLinkedList() {
    LinkedList* pList = malloc(sizeof(LinkedList));
    pList->head = NULL;
    pList->length = 0;
    return pList;
}

void insert(LinkedList* list, Student s, int pos) {
    if (pos > list->length || pos < 0) {
        printf("插入的位置不正确\n");
        return;
    }
    
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->st = s;
    
    if (pos == 0) {
        // 新的节点是头结点
        newNode->next = list->head;
        list->head = newNode;
        list->length++;
        return;
    } else {
        Node* pre = list->head;
        // 非头结点
        while(pos > 1) {
            pos--;
            pre = pre->next;
        }
        newNode->next = pre->next;
        pre->next = newNode;
        list->length++;
        return;
    }
}

void delete(LinkedList* list, int pos) {
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

void modify(LinkedList* list, int pos, char name[]) {
    if (pos >= list->length || pos < 0) {
        printf("修改的位置不正确\n");
        return;
    }
    
    Node* curr = list->head;
    while(pos >= 1) {
        curr = curr->next;
        pos--;
    }
    strcpy(curr->st.name, name);
}

Node* search(LinkedList* list, char s[]) {
    Node* t = list->head;
    while(t != NULL) {
        if (strcmp(t->st.name, s) == 0) {
            return t;
        }
        t = t->next;
    }
    return NULL;
}

void displayList(LinkedList* list) {
    Node* t = list->head;
    while(t != NULL) {
        printf("%s\n", t->st.name);
        t = t->next;
    }
    printf("\n");
}

int main() {
    Student s1;
    strcpy(s1.name, "tiantian");
    LinkedList* list = initLinkedList();
    insert(list, s1, 0);
    displayList(list);
    Student s2;
    strcpy(s2.name, "wanqiang");
    insert(list, s2, 1);
    displayList(list);
    Student s3;
    strcpy(s3.name, "yunpeng");
    insert(list, s3, 2);
    displayList(list);
    
    Node* node = search(list, "yunpeng");
    printf("%p\n", node);
    
    printf("------------\n");
    modify(list, 2, "zhangsan");
    displayList(list);
    modify(list, 0, "lisi");
    displayList(list);
    modify(list, 1, "wangwu");
    displayList(list);
    
    printf("************\n");
    delete(list, 1);
    displayList(list);
    
    delete(list, 0);
    displayList(list);
    
    delete(list, 0);
    printf("========\n");
    displayList(list);
    return 0;
    
}
#endif


```


