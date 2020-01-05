#ifndef     __GLOBAL_H__
#define     __GLOBAL_H__
#include "list.h"

// �����ļ������ṹ��
typedef struct all_data {
	unsigned choice;// ����˵�ѡ����
	char file_name[20];//�ļ���
	list_t air_list;// �洢������Ϣ�õ����� 
} all_data_t;

// ��ʾ�˵�ѡ���� 
void make_choice(all_data_t*);
// ����ϵͳ 
void start(all_data_t*);
//����ѡ��ִ�г���
void do_trans(all_data_t*);
// ����ļ��еļ�¼ 
void show_list(all_data_t *);
// ��Ӽ�¼
void add_record(all_data_t*);
// ɾ��ĳ����¼ 
void delete_record(all_data_t*);
// ͨ��id���ҵ�ĳ����¼�������еĽ�� 
void find_record_by_id(all_data_t*);

// �޸ļ�¼�е�ĳЩ�� 
void modify_item(all_data_t*);
// �˳�ϵͳ 
void quit(all_data_t*);
// ���ļ��ж�ȡ��Ϣ�������� 
void read_db(all_data_t*);
// �������е�����д�뵽�ļ�
void write_db(all_data_t*);

// ��ʼ��globa�ṹ����� 
void init_struct(all_data_t*,char[]);

#endif 
