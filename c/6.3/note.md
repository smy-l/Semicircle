# 6.3 
## 搜索二叉树代码优化(简化、增加打印、删除)
```
#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int elem;
    int height;
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

void deleteNode(Tree* pTree, int elem);
Node* findFather(Node* pRoot, int elem);

Node* findFather(Node* pRoot, int elem) {
    if (pRoot->elem == elem)
        return NULL; // 根节点就是要找的值，所以没有父节点
    if (elem < pRoot->elem)
        if (pRoot->l->elem == elem)
            return pRoot;
        else
            return findFather(pRoot->l, elem);
    else
        if (pRoot->r->elem == elem)
            return pRoot;
        else
            return findFather(pRoot->r, elem);
}

void deleteNode(Tree* pTree, int elem) {
    // 找elem的父节点
    Node* pFather = findFather(pTree->pRoot, elem);
    Node* pDelete;
    Node* pNewSubRoot;
    int lChild = 0;
    if (pFather == NULL) {
        // 直接生成新的树， 返回新的树的root
        pDelete = pTree->pRoot;
    } else {
        // 生成新的树
        if (pFather->l != NULL && pFather->l->elem == elem) {
            pDelete = pFather->l;
            lChild = 1;
        }
        else
            pDelete = pFather->r;
    }

    if (pDelete->l != NULL) {
        // 1. 找左子树的最右节点
        Node* pMax = pDelete->l;
        while(pMax->r != NULL)
            pMax = pMax->r;
        // 2. 这个最右节点的右子树为现在的右子树
        pMax->r = pDelete->r;
        pNewSubRoot = pDelete->l;
    }
    else {
        pNewSubRoot = pDelete->r;
    }

    // 父节点挂接新的树
    if (pFather == NULL) {
        pTree->pRoot = pNewSubRoot;
    } else {
        if (lChild)
            pFather->l = pNewSubRoot;
        else
            pFather->r = pNewSubRoot;
    }
}

Node* findReverse(Node* pRoot, int elem) {
    if (pRoot == NULL) {
        return NULL;
    }

    if (pRoot->elem == elem) {
        return pRoot;
    }

    if (elem < pRoot->elem) {
        // 应该在左边找
        if (pRoot->l == NULL)
            return pRoot;
        else
            return findReverse(pRoot->l, elem);
    } else {
        if (pRoot->r == NULL)
            return pRoot;
        else
            return findReverse(pRoot->r, elem);
    }
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
        pNode->elem = newElem;
        pNode->l = pNode->r = NULL;
        pNode->height = 1;
        pTree->pRoot = pNode;
        return;
    }
    
    Node* pRoot = pTree->pRoot;
    
    //Node* search = findPosition(pRoot, newElem);
    Node* search = findReverse(pRoot, newElem);
    
    Node* pNode = (Node*)malloc(sizeof(Node));
    pNode->elem = newElem;
    pNode->height = search->height + 1;
    pNode->l = pNode->r = NULL;

    if (search->elem == newElem) {
        // 找到已有该elem的节点
    } else if (newElem > search->elem){
        // 放到search的右边
        search->r = pNode;
    } else {
        search->l = pNode;
    }
}

void printTree(Node* pRoot) {
    if (pRoot == NULL) {
        printf("空树");
        return;
    }

    if (pRoot->l != NULL)
        printTree(pRoot->l);

    printf("%4d" , pRoot->elem);

    if (pRoot->r != NULL)
        printTree(pRoot->r);
}

void printNicely(Node* pRoot) {
    if (pRoot == NULL) {
        printf("空树");
        return;
    }

    // 右子树
    if (pRoot->r != NULL) {
        printNicely(pRoot->r);
    }

    // 中
    for (int i = 0; i < pRoot->height; i++)
        printf("    ");
    printf("%4d", pRoot->elem);
    printf("\n");

    // 左
    if (pRoot->l != NULL) {
        printNicely(pRoot->l);
    }
}

int countNodes(Node* pRoot) {
    int count = 1;
    if (pRoot->l)
        count += countNodes(pRoot->l);
    if (pRoot->r)
        count += countNodes(pRoot->r);
    return count;
}

int countLessThan(Node* pRoot, int elem) {
    Node* pTarget = findPosition(pRoot, elem);
    if (pTarget->l == NULL)
        return 0;
    else {
        return countNodes(pTarget->l);
    }
}

int main() {
    int a[] = {62  ,6  ,78  ,97  ,73  ,44  ,20  ,39  ,52  ,43};

    Tree* ptree = initTree();

    for(int i = 0; i < 10; i++) {
        int newElem = a[i];
        insert(ptree, newElem);
    }
    
    // printTree(ptree->pRoot);
    printf("\n");

    printNicely(ptree->pRoot);

    for(int i = 0; i < 10; i++) {
        printf("%d的左子树有%d节点\n", a[i], countLessThan(ptree->pRoot, a[i]));
    }

    /*
    for (int i = 0; i < 10; i++) {
        deleteNode(ptree, a[i]);
        printTree(ptree->pRoot);
        printf("\n");
    }
    */

    return 0;
}

```
