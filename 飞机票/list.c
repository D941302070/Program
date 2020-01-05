#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include "list.h"


// ��ʼ���б�ʵ��
void init_list(list_t* p_list) {
	// ͷָ��ָ���
	p_list->head = NULL;
	// ������Ϊ0
	p_list->count = 0;
}
// �������в�����ʵ��
int insert_node(list_t* p_list, airplane_t* p_air) {
	node_t* p_node = (node_t*)malloc(sizeof(node_t));
	if (NULL == p_node) {
		return -1;		// �������ڴ�ʧ�ܣ�����-1
	}
	p_node->air = *p_air;//�Ѻ���ṹ���list����ڵ�
	p_node->p_next = p_list->head;
	// �²���Ľ���Ϊ�µ�ͷ���
	p_list->head = p_node;
	// ��������1
	++p_list->count;
	return 0;
}
// ���������������
void traverse_list(list_t* p_list) {
	node_t* p_node = NULL;
	// ���p_listָ��Ϊ�գ����������0������������������˳��ú���
	if (!p_list || !p_list->count) {
		printf("û������");
		return;
	}
	// ������������������������ֵ
	for (p_node = p_list->head; p_node; p_node = p_node->p_next) {
		show(&p_node->air);
	}
}
// ��������ʵ��
void destroy_list(list_t* p_list) {
	// ���p_listָ��Ϊ�գ����������0������������������˳��ú���
	if (!p_list || !p_list->count) {
		return;
	}
	// ɾ�����ʱ��ÿ��ɾ��ͷ����ȷ
	while (p_list->head) {
		// ����p_nodeָ��ͷ���
		node_t* p_node = p_list->head;
		// ͷ������һ������Ϊ�µ�ͷ��� 
		p_list->head = p_list->head->p_next;
		// �ͷ�p_node����¼�Ľ����ڴ�
		free(p_node);
		// �������Լ�1
		--p_list->count;
	}
}
// ���������Ƴ�ָ��id�Ľ��ʵ��
int remove_node(list_t* p_list, unsigned id) {
	node_t* p_now = NULL;		//��ǰ���ָ��
	node_t* p_pre = NULL;		//��ǰ����ǰ���ָ�� 
	// ���p_listָ��Ϊ�գ����������0���������Ƴ��������˳��ú���
	if (!p_list || !p_list->count) {
		return -1;
	}
	// ǰ���ָ��Ϊͷ���ָ�� 
	p_pre = p_list->head;
	// ��ǰ���Ϊͷ������һ���ڵ� 
	p_now = p_pre->p_next;
	// ��ͷ�����Ҫɾ���Ľ��
	if (p_list->head->air.id == id) {
		// ͷ������һ������Ϊ�µ�ͷ��� 
		p_list->head = p_list->head->p_next;
		// ǰ���ָ����ָ����ڴ�
		free(p_pre);
		// �������Լ�1
		--p_list->count;
		return 0;
	}
	// ��ͷ��㲻��Ҫɾ���Ľ�㣬���������
	for (; p_now; p_now = p_now->p_next) {
		// �ҵ�Ҫɾ���Ľ��
		if (p_now->air.id == id) {
			// ǰ���ָ���ָ�����¼��ǰ������һ������ַ
			p_pre->p_next = p_now->p_next;
			// �ͷŵ�ǰ���
			free(p_now);
			// �������Լ�1
			--p_list->count;
			return 0;
		}
		// ����ǰ���ָ�룬ǰ����¼��ǰ���ָ���ֵ
		p_pre = p_now;
	}
	return -1;
}

// ���ҽ��(��������)
node_t* find_node(list_t* p_list, unsigned id) {
	// ����ѭ��ָ�����ָ��
	node_t* p_now = NULL;
	// ���p_listָ��Ϊ�գ����������0������NULL, �˳��ú���
	if (!p_list || !p_list->count) {
		return NULL;
	}
	// p_now��¼ͷ����ַ
	p_now = p_list->head;
	// ѭ������ָ��id�Ľ�� 
	while (p_now) {
		// ���ҵ���㣬���˳�ѭ��
		if (p_now->air.id == id) {
			break;
		}
		// ����ѭ������
		p_now = p_now->p_next;
	}
	// ���ز��ҵ��Ľ��ָ��  ������һ��Ҳ����Ҫ�ҵ�  �򷵻�null
	return p_now;
}
