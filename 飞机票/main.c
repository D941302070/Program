#include <stdio.h>
#include "global.h"
/*
interface�����������
implement�����������
*/
int main(void) {
	all_data_t* p_data;
	p_data = (all_data_t*)malloc(sizeof(all_data_t));
	init_struct(p_data,"data.txt");
	start(p_data);
	return 0;
}
