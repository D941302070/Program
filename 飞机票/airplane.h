#pragma once
#ifndef     __AIRPLANE_H__
#define     __AIRPLANE_H__

// ���庽����Ϣ�ṹ��
typedef struct airplane {
	unsigned id;
	char route[15];
	unsigned nub;
	char time[8];
	unsigned price;
} airplane_t;

void set_id(airplane_t* p_air, unsigned id);
void set_route(airplane_t* p_air, char const* route);
void set_nub(airplane_t* p_air, unsigned nub);
void set_time(airplane_t* p_air, char const* time);
void set_price(airplane_t* p_air, unsigned price);

// �Ӽ��̶�ȡ������Ϣ���뵽����ṹ��
void get_info(airplane_t* p_air);
// �����ʾ����ṹ��
void show(airplane_t const* p_air);

#endif      // __AIRPLANE_H__
