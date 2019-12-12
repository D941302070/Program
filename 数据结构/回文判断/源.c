/*
回文判断
@author段星雨
*/
#define total_size 100
#include<stdio.h>
typedef struct node//栈
{
	char data;
	struct node* next;
}LinkStackNode,*LinkStack;
Push(LinkStack top,char* data)//进栈
{
	LinkStackNode* temp;
	temp= (LinkStackNode*)malloc(sizeof(LinkStackNode));
	temp->data = data;
	temp->next = top->next;
	top->next = temp;
}
Pop(LinkStack top, char* x)
{
	LinkStackNode* temp;
	temp = top->next;
	top->next = temp->next;
	*x = temp->data;
	free(temp);
}
char* Write(LinkStack top)
{
	int i;
	char x[total_size];
	char* p;
	p = (char*)malloc(total_size * sizeof(char));
	//for (i = 0; i < total_size; i++)
		//x[i] = '\0';
	printf("请输入一段字母序列，以@结尾\n");
	gets(p);
	strcpy(x, p);
	for ( i = 0; i < 100; i++)
	{
		if (x[i] == '@')
			break;
		Push(top, x[i]);
		if (((i+2)%2==0&&x[i+1]=='@')||(x[i]=='\0'&& x[i + 1] != '@'))
		{
			printf("输入有误");
			exit(0);
		}
	}
	return p;
}
Compare(char* original,LinkStackNode* upside_down)//比较是否相同
{
	char x[total_size];
	char* a;//临时储存数据
	a = (char*)malloc(sizeof(char));
	int i;
	int flag;
	for (i = 0;  i< strlen(original)-1; i++)//有@存在，循环减少一次
	{
		Pop(upside_down, a);
		x[i] = *a;
	}	
	x[i] = '@'; x[i + 1] = '\0';
	flag=strcmp(original, x);
	if (flag == 0)
		printf("输入序列符合该模式");
	else
		printf("输入序列不符合该模式");
}
main()
{
	char* original;//原始字符串
	LinkStackNode* upside_down;//颠倒后的字符串
	upside_down = (LinkStackNode*)malloc(sizeof(LinkStackNode));
	original = Write(upside_down);
	Compare(original,upside_down);
}