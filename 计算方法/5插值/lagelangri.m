function f = lagelangri( x0,y0,x )
%x0Ϊ�ڵ�������y0Ϊ�ڵ㺯��ֵ��xΪ��ֵ�㣬fΪ���ز�ֵ
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

