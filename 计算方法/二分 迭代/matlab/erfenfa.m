function x=erfenfa(f,a,b,e)
% fΪ������ ��a��bΪ����˵㣬e�Ǿ���
fa=feval(f,a);
fb=feval(f,b);
%�Ը���������Ķ˵�ȡֵ
if fa*fb>=0
    error('�������䲻����');
    %�ж϶˵��Ƿ�һ��һ��
end
k=0;
x=(a+b)/2;
%ȡ���е��ֵ
while(b-a)>(2*e)
    fx=feval(f,x);
    %ѭ���жϸ��ľ���
    if fa*fx<0
        b=x;
        fb=fx;
    else
        a=x;
        fa=fx;
        %�жϸ����е�����ң�Ȼ���ȡ�µİ�����
    end
    disp(['k=',num2str(k)]);
    disp(['x=',num2str(x)]);
    k=k+1;
    x=(a+b)/2;
end
disp(['k=',num2str(k)]);