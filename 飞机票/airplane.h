#ifndef     __AIRPLANE_H__
#define     __AIRPLANE_H__

// 定义航班信息结构体
typedef struct airplane {
	unsigned id;//编号
	char route[15];//路线
	unsigned nub;//票数
	char time[8];//时间
	unsigned price;//价格
} airplane_t;

//修改航班数据函数
void set_id(airplane_t* p_air, unsigned id);
void set_route(airplane_t* p_air, char route[]);
void set_nub(airplane_t* p_air, unsigned nub);
void set_time(airplane_t* p_air, char time[]);
void set_price(airplane_t* p_air, unsigned price);

// 获取键盘录入的航班信息
void get_info(airplane_t* p_air);
// 输出显示航班结构体
void show(airplane_t* p_air);

#endif      // __AIRPLANE_H__
