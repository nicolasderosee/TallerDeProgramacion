program repaso8;
const
  dimf = 10;
type 
  rango = 1..dimf;
  servicio = record 
     centro:rango;
     patente:string;
     nroMotor:integer;
     fecha:string;
     cantRepuestos:integer;
  end;
  
  subServicio = record
     patente:string;
     totalReemplazo:integer;
  end;
   
  lista = ^nodo;
  nodo = record 
    dato:servicio;
    sig:lista;
  end;
  
  arbol = ^nodo2;
  nodo2 = record
    dato:subServicio;
    HI,HD:arbol;
  end;
  
  vector = Array[rango] of lista;
  
  
procedure cargar(var v:vector);
begin
end;

procedure agregarArbol(var a:Arbol; pat:string; cantTR:integer); 
begin
  if(a=nil) then begin 
     new(a);
     a^.dato.patente:= pat;
     a^.dato.totalReemplazo := cantTR;
     a^.HI:= NIL;
     a^.HD:= NIL;
  end
  else
     if(pat < a^.dato.patente) then 
        agregarArbol(a^.HI,pat,cantTR)
     else
        agregarArbol(a^.HD,pat,cantTR);
end;
    

procedure minimo(var v:vector; var motorMin,cantTR:integer; var pat:string);
var i,posMin:integer;
begin
  posMin:= -1; motorMin:= 999;
  for i:= 1 to dimf do begin
     if(v[i] <> NIL) and (v[i]^.dato.nroMotor < motorMin) then begin
         motorMin:= v[i]^.dato.nroMotor;
         posMin:= i;
     end;
  end;
  if(posMin <> -1) then begin 
     pat:= v[posMin]^.dato.patente;
     cantTR:= v[posMin]^.dato.cantRepuestos;
     v[posMin]:= v[posMin]^.sig;
  end;
end;

procedure merge(v:vector; var a:arbol);
var motorMin,act,cantTotalR,cantR:integer; pat,patAct:string;
begin
  a:= nil;
  minimo(v,motorMin,cantR,pat);
  while(motorMin<>999) do begin 
    act:= motorMin; cantTotalR:= 0; patAct:= pat;
    while(motorMin <> 999) and (motorMin = act) do begin 
       cantTotalR:= cantTotalR + cantR;
       minimo(v,motorMin,cantR,pat);
    end;
    agregarArbol(a,patAct,cantTotalR);
  end;
end;

Var v:vector; 
    a:arbol;
Begin
  cargar(v); //se dispone
  merge(v,a);
End.
