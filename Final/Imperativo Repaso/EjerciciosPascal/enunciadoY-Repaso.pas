program y;
const
  dimf = 250;
type 
  rango1 = 1..10;
  rango2 = 1..dimf;
  afiliado = record
     nro:integer;
     cuil:integer;
     plan:rango1;
     ingreso:integer;
  end;
  
  afiliado2 = record
     nro:integer;
     cuil:integer;
  end;
  
  arbol=^nodo;
  nodo = record
     dato: afiliado;
     HI:arbol;
     HD:arbol;
  end;
  
  vector = Array[rango2] of afiliado2; 
  
procedure cargarArbol(var a:arbol);
begin
end;

procedure agregarVector(var v:vector; cuil,nro:integer; var dimL:integer);
var aux:afiliado2;
begin
	if(dimL < dimf) then begin
		aux.cuil:= cuil;
		aux.nro:= nro;
		dimL:= dimL + 1;
		v[dimL]:= aux;
	end;
end;

procedure recorrido(a:arbol; inf,sup:integer; plan:rango1; var v:vector; var dimL:integer);
begin 
  if (a <> NIL) and (dimL<dimf)then begin 
     recorrido(a^.HD,inf,sup,plan,v,dimL);
     recorrido(a^.HI,inf,sup,plan,v,dimL);
     if(a^.dato.cuil >= inf) and (a^.dato.cuil <= sup) then begin
        if(a^.dato.plan = plan) then
           agregarVector(v,a^.dato.cuil,a^.dato.nro,dimL);
     end;
  end;
end;

procedure ordenar(var v:vector; dimL:integer);
var i,j:integer; elem:afiliado2;
begin
	for i:= 2 to dimL do begin
		elem:= v[i];
		j:= i - 1;
		while(j > 0) and (v[j].cuil > elem.cuil) do begin
			v[j+1]:= v[j];
			j:= j - 1;
		end;

		v[j+1]:= elem;
	end;
end;


procedure generarVector(var v:vector; a:arbol; cui1Inf,cuilSup:integer; plan:rango1; var dimL:integer);
begin
	dimL:= 0;
	recorrido(a,cui1Inf,cuilSup,plan,v,dimL);
	ordenar(v,dimL);
end;

Var
  a:arbol; num1,num2,dimL:integer; nroPlan:integer; v:vector;
Begin
  cargarArbol(a); //se dispone
  readln(num1); readln(num2); readln(nroPlan);
  generarVector(v,a,num1,num2,nroPlan,dimL);
End.
