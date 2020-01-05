#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include "list.h"


// 初始化列表实现
void init_list(list_t* p_list) {
	// 头指针指向空
	p_list->head = NULL;
	// 结点个数为0
	p_list->count = 0;
}
// 向链表中插入结点实现
int insert_node(list_t* p_list, airplane_t* p_air) {
	node_t* p_node = (node_t*)malloc(sizeof(node_t));
	if (NULL == p_node) {
		return -1;		// 分配结点内存失败，返回-1
	}
	p_node->air = *p_air;//把航班结构体给list链表节点
	p_node->p_next = p_list->head;
	// 新插入的结点成为新的头结点
	p_list->head = p_node;
	// 结点个数加1
	++p_list->count;
	return 0;
}
// 遍历输出链表各结点
void traverse_list(list_t* p_list) {
	node_t* p_node = NULL;
	// 如果p_list指针为空，或结点个数个0，则无需遍历，立即退出该函数
	if (!p_list || !p_list->count) {
		printf("没有数据");
		return;
	}
	// 遍历链表输出各结点的数据域的值
	for (p_node = p_list->head; p_node; p_node = p_node->p_next) {
		show(&p_node->air);
	}
}
// 销毁链表实现
void destroy_list(list_t* p_list) {
	// 如果p_list指针为空，或结点个数个0，则无需遍历，立即退出该函数
	if (!p_list || !p_list->count) {
		return;
	}
	// 删除结点时，每次删除头点结点确
	while (p_list->head) {
		// 定义p_node指向头结点
		node_t* p_node = p_list->head;
		// 头结点的下一个结点成为新的头结点 
		p_list->head = p_list->head->p_next;
		// 释放p_node所记录的结点的内存
		free(p_node);
		// 结点个数自减1
		--p_list->count;
	}
}
// 从链表中移除指定id的结点实现
int remove_node(list_t* p_list, unsigned id) {
	node_t* p_now = NULL;		//当前结点指针
	node_t* p_pre = NULL;		//当前结点的前结点指针 
	// 如果p_list指针为空，或结点个数个0，则无需移除，立即退出该函数
	if (!p_list || !p_list->count) {
		return -1;
	}
	// 前结点指针为头结点指针 
	p_pre = p_list->head;
	// 当前结点为头结点的下一个节点 
	p_now = p_pre->p_next;
	// 若头结点是要删除的结点
	if (p_list->head->air.id == id) {
		// 头结点的下一个结点成为新的头结点 
		p_list->head = p_list->head->p_next;
		// 前结点指针所指向的内存
		free(p_pre);
		// 结点个数自减1
		--p_list->count;
		return 0;
	}
	// 若头结点不是要删除的结点，则遍历查找
	for (; p_now; p_now = p_now->p_next) {
		// 找到要删除的结点
		if (p_now->air.id == id) {
			// 前结点指针的指针域记录当前结点的下一个结点地址
			p_pre->p_next = p_now->p_next;
			// 释放当前结点
			free(p_now);
			// 结点个数自减1
			--p_list->count;
			return 0;
		}
		// 更新前结点指针，前结点记录当前结点指针的值
		p_pre = p_now;
	}
	return -1;
}

// 查找结点(按航班编号)
node_t* find_node(list_t* p_list, unsigned id) {
	// 定义循环指针变量指针
	node_t* p_now = NULL;
	// 如果p_list指针为空，或结点个数个0，立即NULL, 退出该函数
	if (!p_list || !p_list->count) {
		return NULL;
	}
	// p_now记录头结点地址
	p_now = p_list->head;
	// 循环查找指定id的结点 
	while (p_now) {
		// 若找到结点，则退出循环
		if (p_now->air.id == id) {
			break;
		}
		// 更新循环变量
		p_now = p_now->p_next;
	}
	// 返回查找到的结点指针  如果最后一个也不是要找的  则返回null
	return p_now;
}
