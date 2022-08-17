Program x;
const  
   dimf = 31;
type
   cadena10 = String[10];
   rango = 1..dimf;
   
   entrada = record
      tituloPeli:cadena10;
      horario:cadena10;
      precio:double;
      dia:rango;
   end;
   
   lista = ^nodo;
   nodo = record
      dato:entrada;
      sig:lista;
   end;
   
   arbol = ^nodoA;
   nodoA = record
      dato: entrada;
      HI: arbol;
      HD: arbol;
   end;
   
   vector = array [rango] of lista;


procedure inicializarVector(var v:vector);
var i:rango;
begin
  for i:= 1 to dimf do
     v[i]:= nil;
end;

procedure leerEntrada(var e:entrada);
begin
  writeln('ingrese el titulo de la pelicula:');
  readln(e.tituloPeli);
  if(e.tituloPeli <> 'ZZZ') then begin 
        writeln('ingrese el horario de la funcion:');
        readln(e.horario);
        writeln('ingrese el costo:');
        readln(e.precio);
  end;
end;

procedure insertarOrdenado(var L:lista; e:entrada); 
var nue,ant,act:lista;
begin
  act:= L;
  new(nue);
  nue^.dato.tituloPeli:=e.tituloPeli;
  nue^.dato.horario:=e.horario;
  nue^.dato.precio:=e.precio;
  nue^.sig:=nil;
  while((act <> nil) and (act^.dato.tituloPeli < e.tituloPeli)) do begin
    ant:=act;
    act:=act^.sig;
  end;
  if(act=L)then
    L:=nue
  else
    ant^.sig:=nue;
  nue^.sig:=act;
end;


procedure cargarEntradas(var v:vector); //se dispone
var e:entrada;
begin
  leerEntrada(e);
  while(e.tituloPeli <> 'ZZZ') do begin 
     insertarOrdenado(v[e.dia],e);
     leerEntrada(e);
  end;
end;


procedure agregarArbol(var a:arbol; titulo:cadena10; montoTotal:real);
begin
  if(a = NIL) then begin 
     new(a);
     a^.dato.tituloPeli := titulo;
     a^.dato.precio := montoTotal;
     a^.HI:= NIL;
     a^.HD := NIL;
  end
  else 
     if(montoTotal < a^.dato.precio) then agregarArbol(a^.HI,titulo,montoTotal)
     else agregarArbol(a^.HD,titulo,montoTotal);
end;

procedure minimo (var v:vector; var minT:cadena10; var monto:real);
var i,posMin:integer; 
begin
  minT:= 'ZZZ'; posMin:= -1;
  for i:= 1 to dimf do
      if(v[i] <> NIL) then 
          if (v[i]^.dato.horario = '21hs') and (v[i]^.dato.tituloPeli < minT) then begin 
              minT:= v[i]^.dato.tituloPeli;
              posMin:= i;
          end;
  if(posMin <> -1) then begin 
     monto := v[i]^.dato.precio;
     v[i]:= v[i]^.sig;
  end;
end;

procedure merge (v:vector; var a:arbol);
var minTitulo,actual:cadena10; monto, montoTotal: real; 
begin
  a:= nil;
  minimo(v,minTitulo,monto);
  while(minTitulo <> 'ZZZ') do begin 
     actual:= minTitulo; 
     montoTotal:= 0; 
     while(minTitulo <> 'ZZZ') and (actual = minTitulo) do begin
          montoTotal := montoTotal + monto; 
          minimo(v,minTitulo,monto);
     end;
     agregarArbol(a,actual,montoTotal);
  end;
end;


Var v:vector; a:arbol;

Begin
  inicializarVector(v);
  cargarEntradas(v); //se dispone
  merge(v,a);
End.
