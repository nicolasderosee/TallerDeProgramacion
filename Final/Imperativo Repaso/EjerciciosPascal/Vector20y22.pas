Program x;
const 
 dimF = 20;
type
 rangoVector = 1..dimF;
 participante = record
     cod: integer;
     edad: integer
 end;
 
 lista = ^nodo;
 nodo = record
		dato:participante;
		sig:lista;
 end;

 vec = Array [rangoVector] of participante; 
 
 Procedure leerParticipante (var p: participante);
 begin
    write('ingrese el codigo del participante: ');
    readln(p.cod);
    if(p.cod <> -1)then begin 
       write('ingrese la edad del participante:');
       readln(p.edad);
    end;
 end;
 
 Procedure cargarVector(var v:vec; var diml:integer);
 var
	p:participante;
 begin
	leerParticipante(p);
	while (p.cod <> -1) and (diml < 20) do begin
		diml:= diml + 1;
		v[diml]:= p;
		writeln ('---------Nuevo participante-----------');
		leerParticipante(p);
	end;
 end;
  
  
 Procedure informovec (v:vec; dimL:integer);
 var i:rangoVector;
 begin
	writeln ('---------------informo vector----------------');
	for i:= 1 to dimL do 
		writeln ('Codigo de participante: ',v[i].cod,' Edad del participante: ',v[i].edad);
 end;
 
 Procedure ordenarVector(var v:vec; diml:integer);
 var i,j:integer; actual:participante;
 begin
   for i:=2 to diml do begin
      actual:=v[i];
	  j:=i-1;
	  while(j>0)and(v[j].edad > actual.edad)do begin
	     v[j+1]:=v[j];
		 j:=j-1;
	  end;
	  v[j+1]:=actual;
   end;
 end;

 procedure eliminarParticipantes(var v:vec; var dimL:integer; valor1:integer; valor2:integer);
 var posicion, i, cant : integer;
 begin
  cant := 0;
  i := 1;  
  {busco al primer participante de 20 años o mas}
  while ((i <= dimL) and (v[i].edad < valor1)) do 
	 i := i +1;
	 
  posicion:= i;
  while (i <= dimL) and (v[i].edad <= valor2) do
	i := i + 1;
	
  { vamos a eliminar a todos los parcipantes entre las posiciones posicion e i del vector V }	  
  cant := i - posicion;
  for i := (posicion+cant) to dimL do
     v[i-cant] := v[i];
	  
  dimL := dimL - cant;
	  
 end;
 
 procedure AgregarAdelante(var L:lista;part:participante);
 var
	nuevo:lista;
 begin
	new(nuevo);
	nuevo^.dato:=part;
	nuevo^.sig:=L;
	L:=nuevo;
 end;

// Se recorre el vector de forma inversa y se agrega adelante en la lista.
 procedure GenerarListaB(v:vec; dimL:integer; var L:lista);
 var i:integer;
 begin
	L:=nil;
	for i:=dimL downto 1 do begin
		AgregarAdelante(L,v[i]);
	end;
 end;	


procedure imprimirLista(L : lista);
begin
  while (L <> NIL) do 
  begin
	  writeln('Codigo: ',L^.dato.cod,' - Edad: ',L^.dato.edad);
	  L := L^.sig;
  end;
end;


var v:vec; dimL:integer; L:lista;

Begin
  dimL:= 0;
  cargarVector(v,dimL);
  writeln();
  informovec(v,dimL);
  ordenarVector(v,dimL);
  informovec(v,dimL);
  eliminarParticipantes(v,dimL,20,22);
  informovec(v,dimL);
  GenerarListaB(v,diml,L);  
  writeln('---------------informo lista----------------');
  imprimirLista(L);
End.
