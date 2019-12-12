function x=erfenfa(f,a,b,e)
% f为函数名 ；a，b为区间端点，e是精度
fa=feval(f,a);
fb=feval(f,b);
%对给定的区间的端点取值
if fa*fb>=0
    error('隔根区间不符合');
    %判断端点是否一正一负
end
k=0;
x=(a+b)/2;
%取出中点的值
while(b-a)>(2*e)
    fx=feval(f,x);
    %循环判断根的精度
    if fa*fx<0
        b=x;
        fb=fx;
    else
        a=x;
        fa=fx;
        %判断根在中点的左右，然后获取新的半区间
    end
    disp(['k=',num2str(k)]);
    disp(['x=',num2str(x)]);
    k=k+1;
    x=(a+b)/2;
end
disp(['k=',num2str(k)]);