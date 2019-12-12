#include<stdio.h>
main() {
    long chushi[50];
	long yushu[50]; 
    int i=2;
    chushi[0];//1号元素 
    chushi[1];//2号元素 
    for(;i<50;i++) {
    	chushi[i]=chushi[i-1]+chushi[i-2];
    }
    for(i=0;i<50;i++){
        yushu[i]=chushi[i]%3;
    }
    printf("第100个数对三求余为：%d\n",yushu[100%8-1]);
    printf("第200个数对三求余为：%d",yushu[200%8-1]);
}
