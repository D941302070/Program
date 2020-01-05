#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "global.h"

void make_choice(all_data_t* p_data) {
	// ��ʾ�˵�ѡ��
	printf("\n\n\t --------------------��Ʊ����ϵͳ----------------------\n");
	printf("\t|			      				|\n");
	printf("\t|		0.��ʾ���к�����Ϣ			|\n");
	printf("\t|			      				|\n");
	printf("\t|		1.��Ӻ�����Ϣ				|\n");
	printf("\t|			      				|\n");
	printf("\t|		2.ɾ��������Ϣ				|\n");
	printf("\t|			      				|\n");
	printf("\t|		3.���Һ�����Ϣ				|\n");
	printf("\t|			      				|\n");
	printf("\t|		4.�޸ĺ�����Ϣ				|\n");
	printf("\t|			      				|\n");
	printf("\t|		5.�˳�ϵͳ				|\n");
	printf("\t -------------------------------------------------------\n");
	printf("��������ѡ��Ĺ���:\n");
	scanf("%u", &(p_data->choice));
	printf("\n��ѡ��Ĺ�����%u\n\n", p_data->choice);
}

void start(all_data_t* p_data) {
	read_db(p_data);//��ȡ�ļ���� �ļ�
	while (1) {
		make_choice(p_data);
		do_trans(p_data);//ѡ��ִ��
		system("cls");//����
	}
}

// ����ѡ��ѡȡ��Ӧ�Ĳ���
void do_trans(all_data_t* p_data) {
	switch (p_data->choice) {
	case 0: {
		show_list(p_data);//��ʾ������Ϣ
		break;
	}
	case 1: {
		add_record(p_data);//��Ӻ�����Ϣ
		break;
	}
	case 2: {
		delete_record(p_data);//ɾ��������Ϣ
		break;
	}
	case 3: {
		find_record_by_id(p_data);//���Һ���
		break;
	}
	case 4: {
		modify_item(p_data);//�޸ĺ�����Ϣ
		break;
	}
	case 5: {
		quit(p_data);//�˳�����
		break;
	}
	default:
		printf("û��ѡ���κβ���ѡ��...\n");
	}
	system("pause");//���֣���ͣ
}

void quit(all_data_t* p_data) {//�˳�����
	write_db(p_data); // �������е�����д�뵽�ļ���
	destroy_list(&p_data->air_list); // ��������
	exit(0); // �˳�����
}

// ������ʾ�����е�����
void show_list(all_data_t*  p_data) {
	// ��������
	traverse_list(&p_data->air_list);
}

// ��ʼ���ܽṹ��
void init_struct(all_data_t* p_data, char file[]) {
	// Ĭ�ϳ�ʼ��Ϊ0
	p_data->choice = 0;
	// ��ʼ������
	init_list(&p_data->air_list);
	//��ʼ���ļ���
	strcpy(p_data->file_name, file);
}

// ���������
void add_record(all_data_t* p_data)
{
	// ���� ����ṹ��   
	airplane_t* air;
	air= (airplane_t*)malloc(sizeof(airplane_t));

	// �Ӽ��̻�ȡ����ĺ�����Ϣ
	get_info(air);
	// �ѽ����뵽������
	insert_node(&p_data->air_list, air);
}

// ɾ������
void delete_record(all_data_t* p_data) {
	unsigned id; // Ҫɾ��id
	int temp;//����ɾ�����
	printf("����������Ҫɾ���ĺ�����:");

	scanf("%u", &id);
	// ����id�������ݲ�ɾ�� 
	temp=remove_node(&(p_data->air_list), id);
	if (temp==0)
		printf("\nɾ���ɹ�");
	else
		printf("\nɾ��ʧ��");
}

// ͨ��id����ĳ������
void find_record_by_id(all_data_t* p_data) {
	unsigned id;

	// ѭ������ ���ָ��
	node_t* p_node = NULL;

	printf("����������Ҫ���ҵĺ�����:\n");
	scanf("%u", &id);
	// ����id���ҵ��ṹ��ָ��
	p_node = find_node(&p_data->air_list, id);
	// �ҵ���չʾ
	if (p_node) {
		// չʾ���ҵ��ĺ�����Ϣ
		printf("\n���ҵ�������Ϣ��\n");
		show(&p_node->air);
	}
	else {
		// ��ʾû��ƥ������
		printf("�Բ��𣬲��޴˺���!!!\n");
	}
}

// �޸ĺ�����Ϣ
void modify_item(all_data_t* p_data)
{
	unsigned id;
	unsigned sel_item; // �޸�ѡ�� 
	node_t* p_node = NULL; //�ҵ���Ӧ��� ��¼��Ӧ���ĵ�ַ
	printf("\n��������Ҫ�޸ĵĺ�����:");
	scanf("%u", &id);
	// ���ݺ���id��Ų��� 
	p_node = find_node(&p_data->air_list, id);
	// δ�ҵ�
	if (NULL == p_node) {
		printf("\n�Բ��𣬲��޴˺���!!!\n");
		return;
	}
	// �ҵ�����˵� ѡ���Ӧ�޸���Ŀ
	while (1)
	{
		printf("\n	1 �޸ĺ�����\n\n");
		printf("	2 �޸ĺ��ຽ��\n\n");
		printf("	3 �޸ĺ���Ʊ��\n\n");
		printf("	4 �޸ĺ���ʱ��\n\n");
		printf("	5 ��ִ���޸�\n\n");
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
			printf("\n�޸����!!!\n");
			return;
		}
		}
	}
}

// ��ȡ�����ļ�
void read_db(all_data_t* p_data)
{
	airplane_t  air; //  ���庽��ṹ��  Ϊ�˴��ļ��ж�ȡ
	//a+�ļ������ڣ������ļ����ļ����ڣ�д�������׷�ӵ��ļ���ĩβ
	FILE* fp = fopen(p_data->file_name, "a+");
	if (NULL == fp) { // ����ļ���ʧ��
		printf("�ı��ļ���ʧ��!!!\n");
		return; // �˳�����
	}
	// �ļ��򿪳ɹ�   
	// !feof(fp)  û�ж����ļ�ĩβ   ������
	while (!feof(fp)) {
		// memset ��սṹ�壨Ҫ��յ�ָ�룬��ֵ���ݣ��ڴ��С��
		memset(&air, 0, sizeof(air)); 
		
		// fscanf���ļ��ж�ȡ������Ϣ���浽�ṹ������У����ز����б��б��ɹ���ֵ�Ĳ���������
		if (fscanf(fp, "%u\t%s\t%u\t%s\t%u", &air.id, air.route, &air.nub, air.time, &air.price) == 5)
		{
			insert_node(&p_data->air_list, &air); // �ѽṹ����뵽������
		}
	}

	fclose(fp); // �ر��ļ�
}

// д�ļ�
void write_db(all_data_t* p_data) {
	// ���������õ� ���ָ��
	node_t* p_node = NULL;
	// w+�ȿ��Զ�ȡҲ����д�룬�ļ������ڣ��������ļ����ļ����ڣ���ô����ļ�����
	FILE* fp = fopen(p_data->file_name, "w+");
	if (NULL == fp) { // ����ļ���ʧ��
		printf("�ı��ļ���ʧ��!!!\n");
		return;// �˳�����
	}
	// �����ļ�ָ��  д�ļ�ʱ���ļ�����ʼλ�ÿ�ʼд��
	/*
	��fp��ƫ��������ʼλ�ã�
	��ʼλ�ã�
	�ļ���ͷ	SEEK_SET	0
    ��ǰλ��	SEEK_CUR	1
    �ļ�ĩβ	SEEK_END	2
	*/
	//ֻ����д��Ϊ��ͷ��������λ�ƣ�ƫ����Ϊ0
	fseek(fp, 0, SEEK_SET); 
	// ��ȡ����ͷ���
	p_node = p_data->air_list.head; //ѭ������ ���ʸ������ p_node

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
