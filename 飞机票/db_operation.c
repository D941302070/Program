#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//#include <unistd.h>
#include "db_operation.h"



void make_choice(db_operation_t* p_dbo) {
	//system("clear");
	// 显示菜单选项
	printf("欢迎使用机票管理系统！\n");
	printf("------------------------------------------\n");
	printf("------------------------------------------\n");
	printf("0 显示所有航班信息\n");
	printf("1 添加航班信息\n");
	printf("2 删除航班信息\n");
	printf("3 查找航班信息\n");
	printf("4 修改航班信息\n");
	printf("5 退出系统\n");
	printf("------------------------------------------\n");
	printf("------------------------------------------\n");
	printf("请输入您选择的功能:");
	scanf("%u", &(p_dbo->choice));
	printf("您选择的功能是%u\n", p_dbo->choice);
}

void start(db_operation_t* p_dbo) {
	read_db(p_dbo);
	while (1) {
		make_choice(p_dbo);
		do_trans(p_dbo);
		system("cls");
	}
}

// 根据选项选取对应的操作
void do_trans(db_operation_t* p_dbo) {
	airplane_t air = { 0 };
	switch (p_dbo->choice) {
	case 0: {
		show_db(p_dbo);
		break;
	}
	case 1: {
		add_record(p_dbo);
		break;
	}
	case 2: {
		delete_record(p_dbo);
		break;
	}
	case 3: {
		find_record_by_id(p_dbo);
		break;
	}
	case 4: {
		modify_item(p_dbo);
		break;
	}
	case 5: {
		quit(p_dbo);
		break;
	}
	default:
		printf("没有选择任何操作选项...\n");
	}
}

void quit(db_operation_t* p_dbo) {
	write_db(p_dbo); // 将链表中的数据写入到文件中
	destroy_list(&p_dbo->db_list); // 销毁链表
	exit(0); // 退出程序
}

// 遍历显示链表中的数据
void show_db(struct db_operation const* p_dbo) {
	// 遍历链表
	traverse_list(&p_dbo->db_list);
}

// 初始化数据库操作结构体
void init_db_operation(struct db_operation* p_dbo, char const* file) {
	// 默认初始化为0
	p_dbo->choice = 0;
	// 将数据文件名拷贝到 db_operation的db_file数组中
	strcpy(p_dbo->db_file, file);

	// 初始化链表
	init_list(&p_dbo->db_list);

}

// 添加新数据
void add_record(db_operation_t* p_dbo)
{
	// 定义 航班结构体   
	airplane_t air = { 0 };
	// 从键盘获取输入的航班信息
	get_info(&air);
	// 把结点插入到链表里
	insert_node(&p_dbo->db_list, &air);
}

// 输出数据
void delete_record(struct db_operation* p_dbo) {
	unsigned id; // 要删除id

	printf("请输入您想要删除的航班编号:");

	scanf("%u", &id);
	// 按照id查找数据并删除 
	remove_node(&p_dbo->db_list, id);
}

// 通过id查找某条数据
void find_record_by_id(db_operation_t* p_dbo) {
	unsigned id;

	// 循环变量 结点指针
	node_t* p_node = NULL;

	printf("请输入您想要查找的航班编号:");
	scanf("%u", &id);
	// 根据id查找到结构体指针
	p_node = find_node(&p_dbo->db_list, id);
	// 找到即展示
	if (p_node) {
		// 展示查找到的航班信息
		show(&p_node->air);
	}
	else {
		// 提示没有匹配数据
		printf("对不起，查无此航班!!!\n");
	}
}

// 修改航班信息
void modify_item(db_operation_t* p_dbo)
{
	unsigned id;
	unsigned sel_item; // 修改选项 
	node_t* p_node = NULL; //找到对应结点 记录对应结点的地址
	printf("请输入您要修改的航班编号:");
	scanf("%u", &id);
	// 根据航班id序号查找 
	p_node = find_node(&p_dbo->db_list, id);
	// 未找到
	if (NULL == p_node) {
		printf("对不起，查无此航班!!!\n");
		return;
	}
	// 找到输出菜单 选择对应修改项目
	while (1)
	{
		printf("--1 修改航班编号\n");
		printf("--2 修改航班航线\n");
		printf("--3 修改航班票数\n");
		printf("--4 修改航班时间\n");
		printf("--5 OK\n");
		printf("请输入您想要执行的操作:");
		scanf("%u", &sel_item);
		switch (sel_item) {
		case 1: {
			printf("请输入新的航班编号:");
			scanf("%u", &p_node->air.id);// 通过指针找到对应数据 修改
			show(&p_node->air); // 展示
			break;
		}
		case 2: {
			printf("请输入新的航班航线:");
			scanf("%s", p_node->air.route);
			show(&p_node->air);
			break;
		}
		case 3: {
			printf("请输入新的航班票数:");
			scanf("%u", &p_node->air.nub);
			show(&p_node->air);
			break;
		}
		case 4: {
			printf("请输入新的航班时间:");
			scanf("%s", p_node->air.time);
			show(&p_node->air);
			break;
		}
		case 5: {
			printf("修改完成!!!\n");
			return;
		}
		}
	}
}

// 读取数据文件
void read_db(db_operation_t* p_dbo)
{
	airplane_t  air; //  定义航班结构体  为了从文件中读取

	FILE* fp = fopen(p_dbo->db_file, "a+t"); // 打开文件 读取文件内容  a+t 以追加的方式创建或打开文件
	if (NULL == fp) { // 如果文件打开失败
		printf("数据库文件打开失败!!!\n");
		return; // 退出函数
	}
	// 文件打开成功   
	// !feof(fp)  没有读到文件末尾   继续读
	while (!feof(fp)) {
		memset(&air, 0, sizeof(air)); // memset 清空结构体

		// fscanf从文件中读取航班信息，存到结构体变量中
		if (fscanf(fp, "%u\t%s\t%u\t%s\t%u", &air.id, air.route, &air.nub, air.time, &air.price) == 5)
		{
			insert_node(&p_dbo->db_list, &air); // 把结构体插入到链表中
		}
	}

	fclose(fp); // 关闭文件
}

// 写文件
void write_db(db_operation_t* p_dbo) {
	// 遍历链表用到 结点指针
	node_t* p_node = NULL;
	// 打开文件 读取文件内容  w+t 以写入的方式创建或打开文件  +号代表可以读取
	FILE* fp = fopen(p_dbo->db_file, "w+t");
	if (NULL == fp) { // 如果文件打开失败
		printf("数据库文件打开失败!!!\n");
		return;// 退出函数
	}
	// 调整文件指针  写文件时从文件的起始位置开始写入
	fseek(fp, 0, SEEK_SET);  //0 代表偏移量 可以是正数也可以是负数    SEEK_SET 把文件指针调整文件的起始位置
	// 获取链表头结点
	p_node = p_dbo->db_list.head; //循环变量 访问各个结点 p_node

	// 当结点不为空
	while (p_node) {
		// 将航班信息按照格式写入到文件中去
		fprintf(fp, "%u\t%s\t%u\t%s\t%u\n", p_node->air.id, p_node->air.route,
			p_node->air.nub, p_node->air.time, p_node->air.price);
		// 更新结点  更新循环变量的值
		p_node = p_node->p_next;
	}
	// 关闭文件
	fclose(fp);
}
