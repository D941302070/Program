/*
�����ж�
@author������
*/
#define total_size 100
#include<stdio.h>
typedef struct node//ջ
{
	char data;
	struct node* next;
}LinkStackNode,*LinkStack;
Push(LinkStack top,char* data)//��ջ
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
	printf("������һ����ĸ���У���@��β\n");
	gets(p);
	strcpy(x, p);
	for ( i = 0; i < 100; i++)
	{
		if (x[i] == '@')
			break;
		Push(top, x[i]);
		if (((i+2)%2==0&&x[i+1]=='@')||(x[i]=='\0'&& x[i + 1] != '@'))
		{
			printf("��������");
			exit(0);
		}
	}
	return p;
}
Compare(char* original,LinkStackNode* upside_down)//�Ƚ��Ƿ���ͬ
{
	char x[total_size];
	char* a;//��ʱ��������
	a = (char*)malloc(sizeof(char));
	int i;
	int flag;
	for (i = 0;  i< strlen(original)-1; i++)//��@���ڣ�ѭ������һ��
	{
		Pop(upside_down, a);
		x[i] = *a;
	}	
	x[i] = '@'; x[i + 1] = '\0';
	flag=strcmp(original, x);
	if (flag == 0)
		printf("�������з��ϸ�ģʽ");
	else
		printf("�������в����ϸ�ģʽ");
}
main()
{
	char* original;//ԭʼ�ַ���
	LinkStackNode* upside_down;//�ߵ�����ַ���
	upside_down = (LinkStackNode*)malloc(sizeof(LinkStackNode));
	original = Write(upside_down);
	Compare(original,upside_down);
}