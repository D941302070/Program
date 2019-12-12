function Sn = ComSimpson(f,n,a,b)
    h = (b-a)/n;
    d = feval(f,a);
    for i = a+h:h:b-h 
        d = d + (2 * f(i));
    end
    for i = a+h/2:h:b-h/2 
        d = d + (4 * f(i));
    end
    d = d + feval(f,b);
    Sn = (d * h / 6);
