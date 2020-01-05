#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "global.h"

void make_choice(all_data_t* p_data) {
	// 显示菜单选项
	printf("\n\n\t --------------------机票管理系统----------------------\n");
	printf("\t|			      				|\n");
	printf("\t|		0.显示所有航班信息			|\n");
	printf("\t|			      				|\n");
	printf("\t|		1.添加航班信息				|\n");
	printf("\t|			      				|\n");
	printf("\t|		2.删除航班信息				|\n");
	printf("\t|			      				|\n");
	printf("\t|		3.查找航班信息				|\n");
	printf("\t|			      				|\n");
	printf("\t|		4.修改航班信息				|\n");
	printf("\t|			      				|\n");
	printf("\t|		5.退出系统				|\n");
	printf("\t -------------------------------------------------------\n");
	printf("请输入您选择的功能:\n");
	scanf("%u", &(p_data->choice));
	printf("\n您选择的功能是%u\n\n", p_data->choice);
}

void start(all_data_t* p_data) {
	read_db(p_data);//读取文件里的 文件
	while (1) {
		make_choice(p_data);
		do_trans(p_data);//选项执行
		system("cls");//清屏
	}
}

// 根据选项选取对应的操作
void do_trans(all_data_t* p_data) {
	switch (p_data->choice) {
	case 0: {
		show_list(p_data);//显示航班信息
		break;
	}
	case 1: {
		add_record(p_data);//添加航班信息
		break;
	}
	case 2: {
		delete_record(p_data);//删除航班信息
		break;
	}
	case 3: {
		find_record_by_id(p_data);//查找航班
		break;
	}
	case 4: {
		modify_item(p_data);//修改航班信息
		break;
	}
	case 5: {
		quit(p_data);//退出程序
		break;
	}
	default:
		printf("没有选择任何操作选项...\n");
	}
	system("pause");//保持，暂停
}

void quit(all_data_t* p_data) {//退出程序
	write_db(p_data); // 将链表中的数据写入到文件中
	destroy_list(&p_data->air_list); // 销毁链表
	exit(0); // 退出程序
}

// 遍历显示链表中的数据
void show_list(all_data_t*  p_data) {
	// 遍历链表
	traverse_list(&p_data->air_list);
}

// 初始化总结构体
void init_struct(all_data_t* p_data, char file[]) {
	// 默认初始化为0
	p_data->choice = 0;
	// 初始化链表
	init_list(&p_data->air_list);
	//初始化文件名
	strcpy(p_data->file_name, file);
}

// 添加新数据
void add_record(all_data_t* p_data)
{
	// 定义 航班结构体   
	airplane_t* air;
	air= (airplane_t*)malloc(sizeof(airplane_t));

	// 从键盘获取输入的航班信息
	get_info(air);
	// 把结点插入到链表里
	insert_node(&p_data->air_list, air);
}

// 删除数据
void delete_record(all_data_t* p_data) {
	unsigned id; // 要删除id
	int temp;//返回删除结果
	printf("请输入您想要删除的航班编号:");

	scanf("%u", &id);
	// 按照id查找数据并删除 
	temp=remove_node(&(p_data->air_list), id);
	if (temp==0)
		printf("\n删除成功");
	else
		printf("\n删除失败");
}

// 通过id查找某条数据
void find_record_by_id(all_data_t* p_data) {
	unsigned id;

	// 循环变量 结点指针
	node_t* p_node = NULL;

	printf("请输入您想要查找的航班编号:\n");
	scanf("%u", &id);
	// 根据id查找到结构体指针
	p_node = find_node(&p_data->air_list, id);
	// 找到即展示
	if (p_node) {
		// 展示查找到的航班信息
		printf("\n查找到以下信息：\n");
		show(&p_node->air);
	}
	else {
		// 提示没有匹配数据
		printf("对不起，查无此航班!!!\n");
	}
}

// 修改航班信息
void modify_item(all_data_t* p_data)
{
	unsigned id;
	unsigned sel_item; // 修改选项 
	node_t* p_node = NULL; //找到对应结点 记录对应结点的地址
	printf("\n请输入您要修改的航班编号:");
	scanf("%u", &id);
	// 根据航班id序号查找 
	p_node = find_node(&p_data->air_list, id);
	// 未找到
	if (NULL == p_node) {
		printf("\n对不起，查无此航班!!!\n");
		return;
	}
	// 找到输出菜单 选择对应修改项目
	while (1)
	{
		printf("\n	1 修改航班编号\n\n");
		printf("	2 修改航班航线\n\n");
		printf("	3 修改航班票数\n\n");
		printf("	4 修改航班时间\n\n");
		printf("	5 不执行修改\n\n");
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
			printf("\n修改完成!!!\n");
			return;
		}
		}
	}
}

// 读取数据文件
void read_db(all_data_t* p_data)
{
	airplane_t  air; //  定义航班结构体  为了从文件中读取
	//a+文件不存在，建新文件；文件存在，写入的数据追加到文件的末尾
	FILE* fp = fopen(p_data->file_name, "a+");
	if (NULL == fp) { // 如果文件打开失败
		printf("文本文件打开失败!!!\n");
		return; // 退出函数
	}
	// 文件打开成功   
	// !feof(fp)  没有读到文件末尾   继续读
	while (!feof(fp)) {
		// memset 清空结构体（要清空的指针，赋值内容，内存大小）
		memset(&air, 0, sizeof(air)); 
		
		// fscanf从文件中读取航班信息，存到结构体变量中，返回参数列表中被成功赋值的参数个数。
		if (fscanf(fp, "%u\t%s\t%u\t%s\t%u", &air.id, air.route, &air.nub, air.time, &air.price) == 5)
		{
			insert_node(&p_data->air_list, &air); // 把结构体插入到链表中
		}
	}

	fclose(fp); // 关闭文件
}

// 写文件
void write_db(all_data_t* p_data) {
	// 遍历链表用到 结点指针
	node_t* p_node = NULL;
	// w+既可以读取也可以写入，文件不存在，创建新文件；文件存在，那么清空文件内容
	FILE* fp = fopen(p_data->file_name, "w+");
	if (NULL == fp) { // 如果文件打开失败
		printf("文本文件打开失败!!!\n");
		return;// 退出函数
	}
	// 调整文件指针  写文件时从文件的起始位置开始写入
	/*
	（fp，偏移量，起始位置）
	起始位置：
	文件开头	SEEK_SET	0
    当前位置	SEEK_CUR	1
    文件末尾	SEEK_END	2
	*/
	//只调节写入为开头，不具体位移，偏移量为0
	fseek(fp, 0, SEEK_SET); 
	// 获取链表头结点
	p_node = p_data->air_list.head; //循环变量 访问各个结点 p_node

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
