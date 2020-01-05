#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "airplane.h"


void set_id(airplane_t* p_air, unsigned id) {
	p_air->id = id;
}
void set_route(airplane_t* p_air, char  route[]) {
	strcpy(p_air->route, route);
}
void set_nub(airplane_t* p_air, unsigned nub) {
	p_air->nub = nub;
}
void set_time(airplane_t* p_air, char time[]) {
	strcpy(p_air->time, time);
}
void set_price(airplane_t* p_air, unsigned price) {
	p_air->price = price;
}
void get_info(airplane_t* p_air) {
	printf("�����뺽����Ϣ������(id),·��,Ʊ��,ʱ��(Ĭ��h��,�۸�(Ĭ��Ԫ):\n");
	scanf("%u %s %u %s %u", &p_air->id, p_air->route, &p_air->nub, p_air->time, &p_air->price);
}
void show(airplane_t* p_air) {
	printf("����id��%u\t����·�ߣ�%s\t����Ʊ����%u\t����ʱ�䣺%s h\t����۸�%u Ԫ\n\n", p_air->id, p_air->route,
		p_air->nub, p_air->time, p_air->price);
}
