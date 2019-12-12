/*
约瑟夫环问题
@author 段星雨
*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct People //定义节点
{
	int mima;
	int num;
	struct node* next;
}node, * linklist;

void CreateList(linklist L) //创建链表,返回去除头结点的链表长度
{
	node* s, * r;
	char mima[100];//密码
	int k = 0;//检测输入的次数
	r = L;
	printf("请输入第1个人的密码,若结束请输入end\n");
	gets(mima);
	while (strcmp(mima, "end"))//开始建表，当输入end的时候建表结束
	{
		s = (linklist*)malloc(sizeof(node));
		s->mima = atoi(mima);//将字符串转换为int
		s->num = k + 1;
		k = k + 1;
		r->next = s;
		r = s;
		printf("请输入第%d个人的密码\n", k + 1);
		gets(mima);
	}
	r->next = L;
}

node* Del(linklist L, int m, linklist start) //m为报数次数,start为开始节点
{
	node* del_before, * del;
	del = start;
	while (m != 1)//找到删除的前一个节点
	{
		del = del->next;
		if (del == L)
			continue;
		m--;
	}
	del_before = del;

	if (L->next == del)
	{
		while (del_before->next != L)
			del_before = del_before->next;
		L->next = del->next;
	}
	else
	{
		while (del_before->next != del)
			del_before = del_before->next;
		del_before->next = del->next;
	}
	printf("出列%d号\n", del->num);
	return del;
}

void Method(linklist L, int m)//删除节点，并打印,start为开始报数编号
{
	node* del, * start;
	start = L->next;
	while (L->next != L)
	{
		del = Del(L, m, start);
		m = del->mima;
		if (del->next == L)
			start = L->next;
		else
			start = del->next;
	}
}

int main()
{
	node* L;
	int m;//报数上限值
	L = (linklist)malloc(sizeof(node));
	L->next = NULL;
	CreateList(L);
	printf("请输入报数上限值m\n");
	scanf("%d", &m);
	Method(L, m);
}