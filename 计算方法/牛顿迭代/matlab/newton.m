function x= newton(f,fd,x0,e)
N=100;
%f为函数，fd为倒数，x0为初值，e为精度，N为迭代次数
x=x0;
x0=x+e*2;
k=0;
for i=1:N
    if abs(x0-x)<e
        break;
    end
    x0=x;
    k=k+1;
    x=x0-feval(f,x0)/feval(fd,x0);      
    disp(['x=',num2str(x)]);
    disp(['k=',num2str(k)]);
end
if k==N
    warning('迭代次数已经100次');
end