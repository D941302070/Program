#pragma once
#ifndef     __AIRPLANE_H__
#define     __AIRPLANE_H__

// 定义航班信息结构体
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

// 从键盘读取航班信息存入到航班结构体
void get_info(airplane_t* p_air);
// 输出显示航班结构体
void show(airplane_t const* p_air);

#endif      // __AIRPLANE_H__
