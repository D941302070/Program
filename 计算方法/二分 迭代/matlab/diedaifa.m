function x=diedaifa(f,a,b,e)
% f为迭代函数， a，b为领域，e为精度
N=15;
% N为迭代次数
if (feval(f,a)*feval(f,b))>0
    error('领域不符合');
end
%判断领域范围
x0=(a+b)/2;
%取点
for k=1:N
    x1=feval(f,x0);
    disp(['k=',num2str(k)]);
    disp(['x=',num2str(x1)]);
    %输出k和x
    if abs(x0-x1)<e
        disp('迭代完成');
        break;
        %判断迭代精度
    else
        x0=x1;      
    end
end
if k==15
    error('迭代次数超过15次，终止计算');
end