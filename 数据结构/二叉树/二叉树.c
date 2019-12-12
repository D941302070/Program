#include <stdio.h>
#define SIZE 100

typedef struct 
{
	char data;
	struct TreeNode* Lchild;
	struct TreeNode* Rchild;
}TreeNode,*treenode;

void CreatTree(treenode *root)
{
	char data;
	data = getchar();
	if (data == ' ')
		*root = NULL;
	else
	{
		(*root) = (treenode)malloc(sizeof(TreeNode));
		(*root)->data = data;
		CreatTree(&((*root)->Lchild));
		CreatTree(&((*root)->Rchild));
	}
	
}

void PreOrder(treenode root)
{
	if (root!=NULL)
	{
		printf("%c ", root->data);
		PreOrder(root->Lchild);
		PreOrder(root->Rchild);
	}
}

void InOrder(treenode root)
{
	if (root != NULL)
	{
		InOrder(root->Lchild);
		printf("%c ", root->data);
		InOrder(root->Rchild);
	}
}

void PostOrder(treenode root)
{
	if (root != NULL)
	{
		PostOrder(root->Lchild);
		PostOrder(root->Rchild);
		printf("%c ", root->data);
	}
}

main()
{
	treenode root;
	root = (treenode)malloc(sizeof(TreeNode));
	printf("请输入序列，输入”.“后停止\n");
	CreatTree(&root);
	printf("dsd");
	printf("前序输出");
	PreOrder(root);
	printf("中序输出");
	InOrder(root);
	printf("后续输出");
	PostOrder(root);
}