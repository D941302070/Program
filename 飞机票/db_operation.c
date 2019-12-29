#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <unistd.h>
#include "db_operation.h"



void make_choice(db_operation_t* p_dbo) {
	//system("clear");
	// ��ʾ�˵�ѡ��
	printf("��ӭʹ�û�Ʊ����ϵͳ��\n");
	printf("------------------------------------------\n");
	printf("------------------------------------------\n");
	printf("0 ��ʾ���к�����Ϣ\n");
	printf("1 ��Ӻ�����Ϣ\n");
	printf("2 ɾ��������Ϣ\n");
	printf("3 ���Һ�����Ϣ\n");
	printf("4 �޸ĺ�����Ϣ\n");
	printf("5 �˳�ϵͳ\n");
	printf("------------------------------------------\n");
	printf("------------------------------------------\n");
	printf("��������ѡ��Ĺ���:");
	scanf("%u", &(p_dbo->choice));
	printf("��ѡ��Ĺ�����%u\n", p_dbo->choice);
}

void start(db_operation_t* p_dbo) {
	read_db(p_dbo);
	while (1) {
		make_choice(p_dbo);
		do_trans(p_dbo);
		system("cls");
	}
}

// ����ѡ��ѡȡ��Ӧ�Ĳ���
void do_trans(db_operation_t* p_dbo) {
	airplane_t air = { 0 };
	switch (p_dbo->choice) {
	case 0: {
		show_db(p_dbo);
		break;
	}
	case 1: {
		add_record(p_dbo);
		break;
	}
	case 2: {
		delete_record(p_dbo);
		break;
	}
	case 3: {
		find_record_by_id(p_dbo);
		break;
	}
	case 4: {
		modify_item(p_dbo);
		break;
	}
	case 5: {
		quit(p_dbo);
		break;
	}
	default:
		printf("û��ѡ���κβ���ѡ��...\n");
	}
}

void quit(db_operation_t* p_dbo) {
	write_db(p_dbo); // �������е�����д�뵽�ļ���
	destroy_list(&p_dbo->db_list); // ��������
	exit(0); // �˳�����
}

// ������ʾ�����е�����
void show_db(struct db_operation const* p_dbo) {
	// ��������
	traverse_list(&p_dbo->db_list);
}

// ��ʼ�����ݿ�����ṹ��
void init_db_operation(struct db_operation* p_dbo, char const* file) {
	// Ĭ�ϳ�ʼ��Ϊ0
	p_dbo->choice = 0;
	// �������ļ��������� db_operation��db_file������
	strcpy(p_dbo->db_file, file);

	// ��ʼ������
	init_list(&p_dbo->db_list);

}

// ���������
void add_record(db_operation_t* p_dbo)
{
	// ���� ����ṹ��   
	airplane_t air = { 0 };
	// �Ӽ��̻�ȡ����ĺ�����Ϣ
	get_info(&air);
	// �ѽ����뵽������
	insert_node(&p_dbo->db_list, &air);
}

// �������
void delete_record(struct db_operation* p_dbo) {
	unsigned id; // Ҫɾ��id

	printf("����������Ҫɾ���ĺ�����:");

	scanf("%u", &id);
	// ����id�������ݲ�ɾ�� 
	remove_node(&p_dbo->db_list, id);
}

// ͨ��id����ĳ������
void find_record_by_id(db_operation_t* p_dbo) {
	unsigned id;

	// ѭ������ ���ָ��
	node_t* p_node = NULL;

	printf("����������Ҫ���ҵĺ�����:");
	scanf("%u", &id);
	// ����id���ҵ��ṹ��ָ��
	p_node = find_node(&p_dbo->db_list, id);
	// �ҵ���չʾ
	if (p_node) {
		// չʾ���ҵ��ĺ�����Ϣ
		show(&p_node->air);
	}
	else {
		// ��ʾû��ƥ������
		printf("�Բ��𣬲��޴˺���!!!\n");
	}
}

// �޸ĺ�����Ϣ
void modify_item(db_operation_t* p_dbo)
{
	unsigned id;
	unsigned sel_item; // �޸�ѡ�� 
	node_t* p_node = NULL; //�ҵ���Ӧ��� ��¼��Ӧ���ĵ�ַ
	printf("��������Ҫ�޸ĵĺ�����:");
	scanf("%u", &id);
	// ���ݺ���id��Ų��� 
	p_node = find_node(&p_dbo->db_list, id);
	// δ�ҵ�
	if (NULL == p_node) {
		printf("�Բ��𣬲��޴˺���!!!\n");
		return;
	}
	// �ҵ�����˵� ѡ���Ӧ�޸���Ŀ
	while (1)
	{
		printf("--1 �޸ĺ�����\n");
		printf("--2 �޸ĺ��ຽ��\n");
		printf("--3 �޸ĺ���Ʊ��\n");
		printf("--4 �޸ĺ���ʱ��\n");
		printf("--5 OK\n");
		printf("����������Ҫִ�еĲ���:");
		scanf("%u", &sel_item);
		switch (sel_item) {
		case 1: {
			printf("�������µĺ�����:");
			scanf("%u", &p_node->air.id);// ͨ��ָ���ҵ���Ӧ���� �޸�
			show(&p_node->air); // չʾ
			break;
		}
		case 2: {
			printf("�������µĺ��ຽ��:");
			scanf("%s", p_node->air.route);
			show(&p_node->air);
			break;
		}
		case 3: {
			printf("�������µĺ���Ʊ��:");
			scanf("%u", &p_node->air.nub);
			show(&p_node->air);
			break;
		}
		case 4: {
			printf("�������µĺ���ʱ��:");
			scanf("%s", p_node->air.time);
			show(&p_node->air);
			break;
		}
		case 5: {
			printf("�޸����!!!\n");
			return;
		}
		}
	}
}

// ��ȡ�����ļ�
void read_db(db_operation_t* p_dbo)
{
	airplane_t  air; //  ���庽��ṹ��  Ϊ�˴��ļ��ж�ȡ

	FILE* fp = fopen(p_dbo->db_file, "a+t"); // ���ļ� ��ȡ�ļ�����  a+t ��׷�ӵķ�ʽ��������ļ�
	if (NULL == fp) { // ����ļ���ʧ��
		printf("���ݿ��ļ���ʧ��!!!\n");
		return; // �˳�����
	}
	// �ļ��򿪳ɹ�   
	// !feof(fp)  û�ж����ļ�ĩβ   ������
	while (!feof(fp)) {
		memset(&air, 0, sizeof(air)); // memset ��սṹ��

		// fscanf���ļ��ж�ȡ������Ϣ���浽�ṹ�������
		if (fscanf(fp, "%u\t%s\t%u\t%s\t%u", &air.id, air.route, &air.nub, air.time, &air.price) == 5)
		{
			insert_node(&p_dbo->db_list, &air); // �ѽṹ����뵽������
		}
	}

	fclose(fp); // �ر��ļ�
}

// д�ļ�
void write_db(db_operation_t* p_dbo) {
	// ���������õ� ���ָ��
	node_t* p_node = NULL;
	// ���ļ� ��ȡ�ļ�����  w+t ��д��ķ�ʽ��������ļ�  +�Ŵ�����Զ�ȡ
	FILE* fp = fopen(p_dbo->db_file, "w+t");
	if (NULL == fp) { // ����ļ���ʧ��
		printf("���ݿ��ļ���ʧ��!!!\n");
		return;// �˳�����
	}
	// �����ļ�ָ��  д�ļ�ʱ���ļ�����ʼλ�ÿ�ʼд��
	fseek(fp, 0, SEEK_SET);  //0 ����ƫ���� ����������Ҳ�����Ǹ���    SEEK_SET ���ļ�ָ������ļ�����ʼλ��
	// ��ȡ����ͷ���
	p_node = p_dbo->db_list.head; //ѭ������ ���ʸ������ p_node

	// ����㲻Ϊ��
	while (p_node) {
		// ��������Ϣ���ո�ʽд�뵽�ļ���ȥ
		fprintf(fp, "%u\t%s\t%u\t%s\t%u\n", p_node->air.id, p_node->air.route,
			p_node->air.nub, p_node->air.time, p_node->air.price);
		// ���½��  ����ѭ��������ֵ
		p_node = p_node->p_next;
	}
	// �ر��ļ�
	fclose(fp);
}
