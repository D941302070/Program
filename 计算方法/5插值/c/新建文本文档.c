#include<stdio.h>
main() {
    long chushi[50];
	long yushu[50]; 
    int i=2;
    chushi[0];//1��Ԫ�� 
    chushi[1];//2��Ԫ�� 
    for(;i<50;i++) {
    	chushi[i]=chushi[i-1]+chushi[i-2];
    }
    for(i=0;i<50;i++){
        yushu[i]=chushi[i]%3;
    }
    printf("��100������������Ϊ��%d\n",yushu[100%8-1]);
    printf("��200������������Ϊ��%d",yushu[200%8-1]);
}
