#ifndef     __AIRPLANE_H__
#define     __AIRPLANE_H__

// ���庽����Ϣ�ṹ��
typedef struct airplane {
	unsigned id;//���
	char route[15];//·��
	unsigned nub;//Ʊ��
	char time[8];//ʱ��
	unsigned price;//�۸�
} airplane_t;

//�޸ĺ������ݺ���
void set_id(airplane_t* p_air, unsigned id);
void set_route(airplane_t* p_air, char route[]);
void set_nub(airplane_t* p_air, unsigned nub);
void set_time(airplane_t* p_air, char time[]);
void set_price(airplane_t* p_air, unsigned price);

// ��ȡ����¼��ĺ�����Ϣ
void get_info(airplane_t* p_air);
// �����ʾ����ṹ��
void show(airplane_t* p_air);

#endif      // __AIRPLANE_H__
