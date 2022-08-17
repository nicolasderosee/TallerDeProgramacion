Program vectordelistas;
Const
 DimF = 4;
Type
 cadena=string[20];
 rango1=1..Dimf;
 rango2=1980..2019;
 empleado=record
   nro:integer;
   ap:cadena;
   anio:rango2;
   cat:rango1;
 end;
 emp=record
   nro:integer;
   ap:cadena;
   anio:rango2;
 end;
 lista=^nodo;
 nodo=record
  datos:emp;
  sig:lista;
 end;

vector = Array [rango1] of lista;


Procedure CrearVectorDeListas(var v:vector);

 Procedure inivec(var v:vector);
 var i:integer;
 begin
  for i:=1 to Dimf do
    v[i]:= NIL;
 end;

 Procedure LeerEmpleado(var e:empleado);
 begin
  write('ingrese el numero del empleado:');
  readln(e.nro);
  if(e.nro<>0)then begin
   write('ingrese el apellido del empleado:');
   readln(e.ap);
   write('ingrese el anio en que ingreso el empleado a la empresa:');
   readln(e.anio);
   write('ingrese la categoria del empleado:');
   readln(e.cat);
  end;
 end;

 Procedure CargarEmp(e:empleado; var e1:emp);
 begin
  e1.nro:=e.nro;
  e1.ap:=e.ap;
  e1.anio:=e.anio;
 end;


 Procedure InsertarEnLista(var pri:lista; elem:emp);  //ordenada por apellido
 var ant, nue, act: lista;
 begin
  new (nue);
  nue^.datos:=elem;
  act :=pri;
  while (act<>NIL) and (act^.datos.ap < elem.ap) do begin
    ant := act;
    act := act^.sig ;
  end;
  if (act = pri)  then
    pri:= nue
  else
    ant^.sig:= nue;
  nue^.sig:= act ;
 end;

var e:empleado; e1:emp;
begin
 iniVec(v);
 LeerEmpleado(e);
 while(e.nro<>0) do begin
  CargarEmp(e,e1);
  InsertarEnLista(v[e.cat],e1); {de esta forma enviandole e1 se carga en la lista los datos del empleado sin la categoria}
  writeln();
  LeerEmpleado(e);
 end;
end;

Procedure recorrerlista(L:lista);
begin
 while(L<>NIL) do begin
  writeln('apellido y numero del empleado: ' , L^.datos.ap , L^.datos.nro);
  L:=L^.sig;
 end;
end;

Procedure informar(v:vector);
 var i:integer;
begin
 for i:= 1 to Dimf do begin
  writeln('categoria ' , i);
  recorrerlista(v[i]);
  writeln();
 end;
end;


var
 v:vector;
begin
 CrearVectorDeListas(v);
 writeln();
 informar(v);
 readln;
end.


