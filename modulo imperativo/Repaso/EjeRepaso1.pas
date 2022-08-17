Program ejeRepaso1VectorDe4Listas;
const
  DimF = 4;
type
  rango1 = 1..DimF;
  rango2 = 1980..2019;
  cadena20 = String[20];
  empleado = record
     nro:integer;
     ap:cadena20;
     anioi:rango2;
     cat:rango1;
   end;
  emp = record
      nro:integer;
      ap:cadena20;
      anioi:rango2;
   end;
  lista=^nodo;
  nodo=record
    datos:emp;
    sig:lista;
   end;
  vector = Array [rango1] of lista;  //vector de 4 listas, cada lista es la categoria donde pertenece el empleado

procedure CrearVectorDeListas (var v:vector);

   procedure inivec(var v:vector);
   var i:integer;
   begin
       for i:=1 to Dimf do
          v[i]:= NIL;
   end;

   procedure LeerEmpleado(var e:empleado);
   begin
      write('Ingrese el numero del empleado:');
      readln(e.nro);
      if(e.nro<>0) then begin
         write('Ingrese el apellido del empleado:');
         readln(e.ap);
         write('Ingrese el anio de ingreso del empleado:');
         readln(e.anioi);
         write('Ingrese la categoria del empleado:');
         readln(e.cat);
         writeln();
     end
   end;

  Procedure CargarEmp(e:empleado; var e1:emp);
  begin
     e1.nro:=e.nro;
     e1.ap:=e.ap;
     e1.anioi:=e.anioi;
  end;

  Procedure InsertarEnLista(var pri:lista; elem:emp);
  var ant, nue, act: lista;
  begin
    new (nue);
    nue^.datos:=elem;
    act :=pri;
    while (act<>NIL) and (act^.datos.ap < elem.ap) do begin
        ant := act;
        act := act^.sig ;
    end;
    if (act = pri)  then pri:= nue
    else ant^.sig:= nue;
    nue^.sig:= act;
  end;


var e:empleado; e1:emp;
begin
   inivec(v);
   LeerEmpleado(e);
   while(e.nro<>0) do begin
      CargarEmp(e,e1);
      InsertarEnLista(v[e.cat],e1); {de esta forma enviandole e1 se carga en la lista los datos del empleado sin la categoria}
      LeerEmpleado(e);
   end;
end;

procedure ImprimirVectorDeListas(v:vector);
  Procedure recorrerlista(L:lista);
  begin
     while(L<>NIL) do begin
        writeln('apellido y numero del empleado: ' , L^.datos.ap , ' ', L^.datos.nro);
        L:=L^.sig;
     end;
  end;

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
 ImprimirVectorDeListas(v);
 readln;
end.
