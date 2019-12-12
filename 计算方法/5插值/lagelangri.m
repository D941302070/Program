function f = lagelangri( x0,y0,x )
%x0为节点向量，y0为节点函数值，x为插值点，f为返回插值
n=length(x0);
m=length(x);
format long
s=0.0;
for k=1:n
    p=1.0;
    for j=1:n
        if j~=k
            p=p*(x-x0(j))/(x0(k)-x0(j));
        end
    end
    s=p*y0(k)+s;
end
f=s;
end

