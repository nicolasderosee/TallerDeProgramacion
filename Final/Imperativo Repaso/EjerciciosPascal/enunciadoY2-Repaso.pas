program enunciadoY2;
const
	dimF = 250;
type 
    rango1= 1..dimF;
	rango2 = 1..10;
	arbol = ^nodo;
	afiliado = record
		nro:integer;
		cuil:integer;
		plan:rango2;
		ingreso:integer
	end;
	nodo = record
		dato:afiliado;
		HI,HD:arbol
	end;
	afiliado2 = record
		nro:integer;
		cuil:integer
	end;
	vector = array[rango1] of afiliado2;

procedure cargarArbol(var a:arbol);
begin
end;

procedure ordenar(var v:vector; dimL:integer);
var
	i,j:integer; act:afiliado2;
begin
	for i:= 2 to dimL do begin
		act:= v[i];
		j:= i - 1;
		
		while(j > 0) and (v[j].cuil > act.cuil)do begin
			v[j+1]:= v[j];
			j:= j - 1;
		end;

		v[j+1]:= act;
	end;
end;

procedure agregarVector(var v:vector; cuil,nro:integer; var dimL:integer);
var
	aux:afiliado2;
begin
	if(dimL < dimF) then begin
		aux.cuil:= cuil;
		aux.nro:= nro;
		dimL:= dimL + 1;
		v[dimL]:= aux;
	end;
end;

procedure recorridoAcotado(a:arbol; inf,sup:integer; plan:rango2; var v:vector; var dimL:integer);
begin
	if(a <> nil) and (dimL < dimF)then begin
		if(a^.dato.cuil >= inf)then begin
			if(a^.dato.cuil <= sup)then begin
				recorridoAcotado(a^.HI,inf,sup,plan,v,dimL);
				if(a^.dato.plan = plan)then
					agregarVector(v,a^.dato.cuil,a^.dato.nro,dimL);
				recorridoAcotado(a^.HD,inf,sup,plan,v,dimL);
			end
			else
				recorridoAcotado(a^.HI,inf,sup,plan,v,dimL);
		end
		else
			recorridoAcotado(a^.HD,inf,sup,plan,v,dimL);
	end;
end;

procedure generarVector(var v:vector; a:arbol; cuiInf,cuilSup:integer; plan:rango2; var dimL:integer);
begin
	dimL:= 0;
	recorridoAcotado(a,cuiInf,cuilSup,plan,v,dimL);
	ordenar(v,dimL);
end;

var
	a:arbol;
	v:vector;
	dl:integer;
begin
	cargarArbol(a);//se dispone
	generarVector(v,a,1,5,2,dl);
end.
