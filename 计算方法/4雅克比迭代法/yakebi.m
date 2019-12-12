function x = yakebi( A,b )
%AÎª¾ØÕó£¬bÎªb¾ØÕó
N=100;
Ai= length(A);
D=zeros(Ai);
x0=zeros(Ai,1);
for i=1:Ai
    D(i,i)=A(i,i);
end
I=eye(Ai);
L=-tril(A,-1);
U=-tril(A,1);
Bj=I-inv(D)*A
fJ=inv(D)*b
for i=1:N
    x=Bj*x0+fJ;
    x0=x;
end
x;

