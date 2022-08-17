Program enunci2ado6;
const 
  dimf = 8;

type
  rango = 1..dimf;
  producto = record
    cod:integer;
    desc:string;
    stock:integer;
    precio:real;
    suc:rango;
  end;
  
  prod = record
     cod:integer;
     stock:integer;
     suc:rango;
  end;
  
  lista=^nodo;
  nodo=record
     dato:producto;
     sig:lista;
  end;
  
  lista2=^nodo2;
  
  nodo2=record
     dato:prod;
     sig:lista2;
  end;
  
  vec = array [rango] of lista;
  
  
procedure generar(var v:vec); //se dispone
begin
end;


procedure agregarAtras(var L,ult:lista2; stockM,suc,cod:integer);
var nue:lista2;
begin
   new(nue);
   nue^.dato.cod:= cod;
   nue^.dato.stock:= stockM;
   nue^.dato.suc:= suc;
   if(l <> nil) then 
      ult^.sig := nue
   else
      l:= nue;
   ult:= nue;
end;


procedure minimo(var v:vec; var codMin,stock,suc:integer);
var i,posMin:integer;
begin
   posMin:= -1; codMin:= 999;
   for i:= 1 to dimf do 
      if (v[i]<>NIL) and(v[i]^.dato.cod < codMin) then begin 
          codMin := v[i]^.dato.cod;
          posMin:= i;
      end;
  if(posMin <> -1) then begin 
       stock := v[posMin]^.dato.stock;
       suc := posMin;
       v[posMin]:= v[posMin]^.sig;
  end;
end;
  
procedure merge(v:vec; var lNueva:lista2);
var codMin, act, stockMax,stock,suc,sucAct:integer; ult:lista2;
begin
   lNueva:= nil;
   minimo(v,codMin,stock,suc);
   while(codMin<>999) do begin 
        act:= codMin; sucAct:= suc; stockMax:=-1;
        while(codMin <> 999) and (codMin=act) do begin 
            if(stock>stockMax) then 
                stockMax:= stock;
            minimo(v,codMin,stock,suc)
        end;
        agregarAtras(LNueva,ult,stockMax,sucAct,act);       
   end; 
end;

Var v:vec; l:lista2;
Begin 
  generar(v); //se dispone
  merge(v,l);
End.
