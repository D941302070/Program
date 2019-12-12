#include<stdio.h>
main()
{
int xigua=1;//1为有西瓜 ，0为没西瓜 
int weight=5;
if (xigua==1)
{
    if (weight<=5)
        printf("买10个包子，买1西瓜"); 
    else
    	printf("西瓜太大了，吃不了，不买了"); 
}
else
printf("只买包子"); 
}
