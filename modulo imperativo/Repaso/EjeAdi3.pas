Program EjercicioAdicional3;
Type
  cadena15 = String[15];
  rango = 2010..2018;
  auto= record
     pat:cadena15;
     aniof:rango;
     marca:cadena15;
     modelo:cadena15;
   end;
  nuevo = record
     pat:cadena15;
     marca:cadena15;
     modelo:cadena15;
   end;
  arbol= ^nodoA;
  nodoA = Record
     dato: auto;
     HI: arbol;
     HD: arbol;
   end;

  lista = ^nodo;
  nodo = record
     info: nuevo;
     sig: lista;
   end;

  vector = Array[rango] of lista;


Procedure CrearABB(var a:arbol);

  Procedure LeerAuto(var au:auto);
  begin
    write('ingrese la patente del auto:');
    readln(au.pat);
    if(au.pat<>'zzz') then begin
      write('ingrese el aio de fabricacion:');
      readln(au.aniof);
      write('ingrese la marca:');
      readln(au.marca);
      write('ingrede el modelo:');
      readln(au.modelo);
    end
  end;

 Procedure Insertar(var a:arbol; au:auto);
 begin
    if(a=nil) then begin
       new(a);
       a^.dato:=au;
       a^.HI:=nil;
       a^.HD:=nil;
    end
    else begin
      if (a^.dato.pat > au.pat) then
         insertar(a^.HI,au)
      else
         insertar(a^.HD,au);
    end;
 end;

var au:auto;
begin
  LeerAuto(au);
  writeln();
  while(au.pat<>'zzz') do begin
     Insertar(a,au);
     LeerAuto(au);
     writeln();
  end;
end;

Procedure BuscarMarca(a:arbol; elem:cadena15; var cant:integer);
begin
 if(a<>nil) then begin
   if(a^.dato.marca = elem) then
      cant:= cant + 1;
   BuscarMarca(a^.Hi,elem,cant);
   BuscarMarca(a^.HD,elem,cant);
 end;
end;

procedure CrearVectorDeListas (a:arbol; var v:vector);

   procedure inivec(var v:vector);
   var i:integer;
   begin
       for i:= 2010 to 2018 do
          v[i]:= NIL;
   end;


  Procedure CargarNuevo(a:arbol; var n:nuevo);

       Procedure AgregarAdelante(var L:lista; elem:nuevo);
       var nue:lista;
       begin
          New(nue);
          nue^.info:=elem;
          nue^.sig:=L;
          L:=nue;
       end;

  begin
       if(a<>nil) then begin
            n.pat:=a^.dato.pat;
            n.marca:= a^.dato.marca;
            n.modelo:= a^.dato.modelo;
            AgregarAdelante(v[a^.dato.aniof],n);
            CargarNuevo(a^.Hi,n);
            CargarNuevo(a^.HD,n);
       end;
  end;

var n:nuevo;
begin
   inivec(v);
   CargarNuevo(a,n);
end;

procedure ImprimirVectorDeListas(v:vector);

  Procedure recorrerlista(L:lista);
  begin
     while(L<>NIL) do begin
        writeln('patente:' , L^.info.pat);
        writeln('marca:', L^.info.marca);
        writeln('modelo:',L^.info.modelo);
        writeln();
        L:=L^.sig;
     end;
  end;

var i:integer;
begin
 for i:= 2010 to 2018 do begin
  writeln('anio' , i);
  recorrerlista(v[i]);
  writeln();
 end;
end;


Procedure BuscarPatente(a:arbol; elem:cadena15; var aniof:integer);
begin
 if(a<>nil) then begin
   if(a^.dato.pat = elem) then aniof:= a^.dato.aniof
   else
      if(elem < a^.dato.pat) then BuscarPatente(a^.Hi,elem,aniof)
      else BuscarPatente(a^.HD,elem,aniof);
 end;
end;

var a:arbol; pat,marcaAu:cadena15; cant,aniof:integer; v:vector;
Begin
 cant:=0;
 aniof:=0;
 a:=nil;
 CrearABB(a);
 writeln();
 write('ingrese una marca de auto que quiera buscar:');
 readln(marcaAu);
 BuscarMarca(a,marcaAu,cant);
 writeln('cantidad de autos que poseen la marca ingresada:',cant);
 writeln();
 CrearVectorDeListas (a,v);
 writeln('nueva estructura con la informacion de los autos agrupados por anio de fabrica:');
 writeln();
 ImprimirVectorDeListas(v);
 writeln();
 write('ingrese una patente:');
 readln(pat);
 BuscarPatente(a,pat,aniof);
 writeln('anio de fabricacion del auto con dicha patente:', aniof);
 readln();
End.
