function x=diedaifa(f,a,b,e)
% fΪ���������� a��bΪ����eΪ����
N=15;
% NΪ��������
if (feval(f,a)*feval(f,b))>0
    error('���򲻷���');
end
%�ж�����Χ
x0=(a+b)/2;
%ȡ��
for k=1:N
    x1=feval(f,x0);
    disp(['k=',num2str(k)]);
    disp(['x=',num2str(x1)]);
    %���k��x
    if abs(x0-x1)<e
        disp('�������');
        break;
        %�жϵ�������
    else
        x0=x1;      
    end
end
if k==15
    error('������������15�Σ���ֹ����');
end