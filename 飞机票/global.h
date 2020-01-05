#ifndef     __GLOBAL_H__
#define     __GLOBAL_H__
#include "list.h"

// 定义文件操作结构体
typedef struct all_data {
	unsigned choice;// 保存菜单选项编号
	char file_name[20];//文件名
	list_t air_list;// 存储航线信息用的链表 
} all_data_t;

// 显示菜单选择项 
void make_choice(all_data_t*);
// 启动系统 
void start(all_data_t*);
//根据选项执行程序
void do_trans(all_data_t*);
// 输出文件中的记录 
void show_list(all_data_t *);
// 添加记录
void add_record(all_data_t*);
// 删除某条记录 
void delete_record(all_data_t*);
// 通过id查找到某条记录在链表中的结点 
void find_record_by_id(all_data_t*);

// 修改记录中的某些项 
void modify_item(all_data_t*);
// 退出系统 
void quit(all_data_t*);
// 从文件中读取信息到链表中 
void read_db(all_data_t*);
// 将链表中的数据写入到文件
void write_db(all_data_t*);

// 初始化globa结构体操作 
void init_struct(all_data_t*,char[]);

#endif 
