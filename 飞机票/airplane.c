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
	printf("请输入航班信息，名称(id),路线,票数,时间(默认h）,价格(默认元):\n");
	scanf("%u %s %u %s %u", &p_air->id, p_air->route, &p_air->nub, p_air->time, &p_air->price);
}
void show(airplane_t* p_air) {
	printf("航班id：%u\t航班路线：%s\t航班票数：%u\t航班时间：%s h\t航班价格：%u 元\n\n", p_air->id, p_air->route,
		p_air->nub, p_air->time, p_air->price);
}
