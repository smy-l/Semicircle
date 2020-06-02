# 6.2  快排，搜索二叉树
## 快速排序
### 复杂度
快速排序复杂度 n*log(n);
```
void swap(int a[], int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
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

```

## 搜索二叉树
代码
```
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int elem;
    struct node* r;
    struct node* l;
} Node;

typedef struct tree {
    Node* pRoot;
} Tree;

Tree* initTree() {
    Tree* ptree = (Tree*)malloc(sizeof(Tree));
    ptree->pRoot = NULL;
    return ptree;
}

Node* findPosition(Node* pRoot, int newElem) {
    Node* pTemp = pRoot;
    while(1) {
        // pTemp往下找一个位置
        if (pTemp->elem == newElem) {
            break;
        } else if (pTemp->elem > newElem) {
            // 需要在左子树进行查找
            if (pTemp->l == NULL) {
                break;
            } else {
                pTemp = pTemp->l;
            }
        } else {
            // 需要在右子树进行查找
            if (pTemp->r == NULL) {
                break;
            } else {
                pTemp = pTemp->r;
            }
        }
    }
    return pTemp;
}

void insert(Tree* pTree, int newElem) {
    if (pTree->pRoot == NULL) {
        // 这是一颗空树
        Node* pNode = (Node*)malloc(sizeof(Node));
        pNode->elem = 62;
        pNode->l = pNode->r = NULL;
        pTree->pRoot = pNode;
        return;
    }
    
    Node* pRoot = pTree->pRoot;
    
    Node* search = findPosition(pRoot, newElem);
    
    if (search->elem == newElem) {
        // 找到已有该elem的节点
    } else if (newElem > search->elem){
        // 放到search的右边
        Node* pNode = (Node*)malloc(sizeof(Node));
        pNode->elem = newElem;
        pNode->l = pNode->r = NULL;
        search->r = pNode;
    } else {
        Node* pNode = (Node*)malloc(sizeof(Node));
        pNode->elem = newElem;
        pNode->l = pNode->r = NULL;
        search->l = pNode;
    }
}

int main() {
    int a[] = {62  ,6  ,78  ,97  ,73  ,44  ,20  ,39  ,52  ,43};

    Tree* ptree = initTree();

    for(int i = 0; i < 10; i++) {
        int newElem = a[i];
        insert(ptree, newElem);
    }
    
    return 0;
}

```
