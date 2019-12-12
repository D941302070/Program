#include <stdio.h>


#define MaxVertexNum 50  
#define QueueSize 50
#define True 1
#define False 0
#define Error -1
int visited[MaxVertexNum];

typedef char VertexData;   //顶点是字符型

/*图的邻接矩阵存储结构*/
typedef struct  {
	int v;
}ArcNodeMatrix;

typedef struct    
{
	VertexData vexs[MaxVertexNum];  //顶点
	ArcNodeMatrix arcs[MaxVertexNum][MaxVertexNum];     //邻接矩阵  
	int vexnum, arcnum;    //图中当前的顶点数和弧数
}AdjMatrix;//邻接矩阵

/*邻接表*/
typedef struct ArcNodeList {
	int adjvex;//该弧指向定点的位置
	struct ArcNodeList* nextarc;
 }ArcNodeList;

typedef struct VertexNode {
	VertexData data;
	ArcNodeList* firstarc;
} VertexNode;

typedef struct {
	VertexNode vertex[MaxVertexNum];
	int vexnum, arcnum;
}AdjList;

/*创建邻接矩阵*/
void CreateMatrix(AdjMatrix* G,AdjList *g)
{
	int i, j, k;
	char v1, v2;
	ArcNodeList* p1, * p2;

	printf("请输入顶点数和边数:\n");
	scanf_s("%d%d", &(G->vexnum), &(G->arcnum));
	g->arcnum = G->arcnum;
	g->vexnum = G->vexnum;
	printf("请输入顶点名称：\n");
	for (i = 0; i < G->vexnum; i++)
	{
		getchar();
		scanf_s("%c", &(G->vexs[i]));
		g->vertex[i].data = G->vexs[i];
		g->vertex[i].firstarc = NULL;
	}

	for (i = 0; i < G->vexnum; i++)
		for (j = 0; j < G->vexnum; j++)
			G->arcs[i][j].v = 0;
	printf("请输入每条边对应的两个顶点名称:\n");
	
	for (k = 0; k < G->arcnum; k++)
	{
		getchar();
		scanf_s("%c", &v1);
		getchar();
		scanf_s("%c", &v2);
		for (i = 0; v1 != G->vexs[i]; i++);
		for (j = 0; v2 != G->vexs[j]; j++);
		G->arcs[j][i].v = 1;
		G->arcs[i][j].v = 1;
		i = LocateVertex(g, v1);
		j = LocateVertex(g, v2);
		p1 = (ArcNodeList*)malloc(sizeof(ArcNodeList));
		p2 = (ArcNodeList*)malloc(sizeof(ArcNodeList));
		p1->adjvex = j;
		p1->nextarc = g->vertex[i].firstarc;
		g->vertex[i].firstarc = p1;
		p2->adjvex =i;
		p2->nextarc = g->vertex[j].firstarc;
		g->vertex[j].firstarc = p2;
	}
}

int LocateVertex(AdjList* G, VertexData v)
{
	int j=Error,k;
	for(k=0;k<G->vexnum;k++)
	{
		if (G->vertex[k].data==v)
		{
			j = k; 
			break;
		}
	}
	return j;
}

/*邻接矩阵深度*/
void DepthMatrix(AdjMatrix *G, int v0)//邻接矩阵深度优先遍历
{
	int vj;

	printf("%c ", G->vexs[v0]);   //访问顶点vi  
	visited[v0] = True;

	for (vj = 0; vj < G->vexnum; vj++)           //依次搜索vi邻接点  
		if (G->arcs[v0][vj].v == True && !visited[vj])
			DepthMatrix(G, vj);
}

void DepthSearchMatrix(AdjMatrix* G)//邻接矩阵深度优先遍历
{
	int i;
	for (i = 0; i < G->vexnum; i++)
		visited[i] = False;
	for (i = 0; i < G->vexnum; i++)
		if (!visited[i])
			DepthMatrix(G, i);
}

/*邻接表深度*/
void DepthList(AdjList *g,int v0)
{
	printf("%c ", g->vertex[v0].data);
	visited[v0] = True;
	ArcNodeList* p ;
	p = g->vertex[v0].firstarc;
	while (p!=NULL)
	{
		if (!visited[p->adjvex])
			DepthList(g, p->adjvex);
		p = p->nextarc;
	}
}

void	DepthSearchList(AdjList* g) 
{
	int i;
	for (i = 0; i < g->vexnum; i++)
		visited[i] = 0;
	for (i = 0; i < g->vexnum; i++)
		if (!visited[i])
			DepthList(g, i);
}

/*广度邻接矩阵*/
typedef struct
{
	int front;
	int rear;
	int count;
	int data[QueueSize];
}Queue;

void InitQueue(Queue* Q)//初始化
{
	Q->front = Q->rear = 0;
	Q->count = 0;
}

int QueueEmpty(Queue* Q)//队列是否为空
{
	return Q->count != QueueSize;

}

int QueueFull(Queue* Q)//判断队列是否为满
{
	return Q->count == QueueSize;
}

void EnterQueue(Queue* Q, int x)
{

	if (QueueFull(Q))
		printf("队列溢出");
	else
	{
		Q->count++;
		Q->data[Q->rear] = x;
		Q->rear = (Q->rear + 1) % QueueSize;
	}
}

int DeleteQueue(Queue* Q)
{
	int temp;
	if (QueueEmpty(Q))
	{
		printf("错误");
		return 0;
	}
	else
	{
		temp = Q->data[Q->front];
		Q->count--;
		Q->front = (Q->front + 1) % QueueSize;
		return temp;
	}
}

void BreadthMatrix(AdjMatrix* G, int k)
{
	int i, j;
	Queue Q;
	InitQueue(&Q);
	printf("%c ", G->vexs[k]);
	visited[k] = True;
	EnterQueue(&Q, k);
	while (QueueEmpty(&Q))
	{
		i = DeleteQueue(&Q);
		for (j = 0; j < G->vexnum; j++)
			if (G->arcs[i][j].v == 1 && !visited[j])
			{
				printf("%c\n", G->vexs[j]);
				visited[j] = True;
				EnterQueue(&Q, j);
			}
	}
}
void BreadthSearchMatrix(AdjMatrix* G)
{
	int i;
	for (i = 0; i < G->vexnum; i++)
		visited[i] = False;
	for (i = 0; i < G->vexnum; i++)
		if (!visited[i])
			BreadthMatrix(G, i);
}


main()
{
	AdjList* g;
	AdjMatrix* G;
	G = (AdjMatrix*)malloc(sizeof(AdjMatrix));
	g = (AdjList*)malloc(sizeof(AdjList));
	CreateMatrix(G,g);
	printf("邻接矩阵深度优先搜索结果为：\n");
	DepthSearchMatrix(G);
	printf("\n");
	printf("邻接矩阵广度优先搜索结果为：\n");
	BreadthSearchMatrix(G);
	printf("\n");
	printf("邻接表深度优先搜索结果为：\n");
	DepthSearchList(g);
	printf("\n");
	printf("邻接表深度优先搜索结果为：\n");
	printf("\n");
}



