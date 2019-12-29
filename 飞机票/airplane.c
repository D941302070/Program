#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "airplane.h"


void set_id(airplane_t* p_air, unsigned id) {
	p_air->id = id;
}
void set_route(airplane_t* p_air, char const* route) {
	strcpy(p_air->route, route);
}
void set_nub(airplane_t* p_air, unsigned nub) {
	p_air->nub = nub;
}
void set_time(airplane_t* p_air, char const* time) {
	strcpy(p_air->time, time);
}
void set_price(airplane_t* p_air, unsigned price) {
	p_air->price = price;
}
void get_info(airplane_t* p_air) {
	printf("ÇëÊäÈëº½°àÐÅÏ¢£º(id,route,nub,time,price):");
	scanf("%u %s %u %s %u", &p_air->id, p_air->route, &p_air->nub, p_air->time, &p_air->price);
}
void show(airplane_t const* p_air) {
	printf("%u\t%s\t%u\t%s\t%u\n", p_air->id, p_air->route,
		p_air->nub, p_air->time, p_air->price);
}
