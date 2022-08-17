Program Actividad5Arbol;
Type
  participante= record
    codp:integer;
    codciu:integer;
    edad:integer;
   end;

  arbol= ^nodoA;
  nodoA = Record
    dato: participante;
    HI: arbol;
    HD: arbol;
  end;

  lista = ^nodo;
  nodo = record
    info: participante;
    sig: lista;
  end;


Procedure CrearABB(var a:arbol);

 Procedure LeerParticipante(var p:participante);
 begin
   write('ingrese el codigo del participante:');
   readln(p.codp);
   if(p.codp<>-1) then begin
     write('ingrese el codigo de la ciudad de origen:');
     readln(p.codciu);
     write('ingrese la edad:');
     readln(p.edad);
   end;
 end;

 Procedure Insertar(var a:arbol; p:participante);
 begin
  if(a=nil) then begin
   new(a);
   a^.dato:=p;
   a^.HI:=nil;
   a^.HD:=nil;
  end
  else begin
   if (a^.dato.codp > p.codp) then
     insertar(a^.HI,p)
   else
     insertar(a^.HD,p);
  end;
 end;

var p:participante;
begin
  LeerParticipante(p);
  writeln();
  While(p.codp<>-1) do begin
    Insertar(a,p);
    LeerParticipante(p);
    writeln();
  end;
end;

procedure Recorrer(a:arbol; elem:integer; var L:lista);

    Procedure AgregarAdelante(var L:lista; elem:participante);
    var nue:lista;
    begin
      New(nue);
      nue^.info:=elem;
      nue^.sig:=L;
      L:=nue;
    end;

begin
 if(a<>nil) then begin
   if(a^.dato.codciu = elem) then
     AgregarAdelante(L,a^.dato);
   Recorrer(a^.Hi,elem,L);
   Recorrer(a^.HD,elem,L);
 end;
end;


procedure ImprimirLista(L:lista);
begin
   if (L<>NIL) then begin
     writeln();
     writeln('codigo del participante: ', L^.info.codp);
     writeln('codigo de la ciudad de origen: ', L^.info.codciu);
     writeln('edad: ', L^.info.edad);
     writeln();
     L:=L^.sig;
     ImprimirLista(L);
   end;
end;



procedure VerValoresEnRango(a:arbol; inf,sup: integer; var cant:integer);
begin
   if(a<>nil) then begin
     if (a^.dato.codp >= inf) then begin
        if (a^.dato.codp <= sup) then begin
             cant:= cant + 1;
             VerValoresEnRango (a^.HI, inf, sup,cant);
             VerValoresEnRango(a^.HD, inf, sup,cant);
        end
        else
           VerValoresEnRango (a^.HI, inf, sup,cant);
     end
     else VerValoresEnRango (a^.HD, inf, sup,cant);
   end;
end;

Procedure EdadPromedio(a:arbol; var sumedad,cantp:integer; var prom:real);
begin
 if (a <> nil) then begin
   sumedad:= sumedad + a^.dato.edad;
   cantP:= cantP + 1;
   EdadPromedio(a^.HI,sumedad,cantp,prom);
   EdadPromedio(a^.HD,sumedad,cantp,prom);
   prom:= sumedad div cantp;
 end
end;


var a:arbol; L:lista; prom:real; codciudad,elem1,elem2,cant,sumedad,cantp:integer;
Begin
 cant:=0; cantp:=0; sumedad:=0; prom:=0;
 L:=nil;
 a:=nil;
 CrearABB(a);
 writeln();
 write('ingrese un codigo de ciudad:');
 readln(codciudad);
 Recorrer(a,codciudad,L);
 writeln();
 writeln('Lista de Participantes con el codigo de ciudad ingresado:');
 ImprimirLista(L);
 writeln();
 write('ingrese el valor inicial del rango:');
 readln(elem1);
 write('ingrese el valor final del rango:');
 readln(elem2);
 VerValoresEnRango(a,elem1,elem2,cant);
 writeln();
 writeln('cantidad de participantes dentro del rango:', cant);
 EdadPromedio(a,sumedad,cantp,prom);
 writeln();
 writeln('edad promedio de los participantes del concurso:', Prom:3:2,' ');
 readln;
End.
