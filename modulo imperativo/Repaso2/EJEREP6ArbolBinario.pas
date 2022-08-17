Program ArbolBinarioRepaso;
type
  participante = record
     codP:integer;
     codCiu:integer;
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


Procedure crearABB(var a:arbol);

 procedure leerParticipante(var p:participante);
 begin
   write('ingrese el codigo del participante:');
   read(p.codP);
   if(p.codP <> -1) then begin
      writeln('ingrese el codigo de la ciudad de origen:');
      readln(p.codCiu);
      writeln('ingrese la edad del participante:');
      readln(p.edad);
   end;
 end;

 procedure Insertar(var a:arbol; p:participante);
 begin
  if(a=nil) then begin
    new(a);
    a^.dato:=p;
    a^.HI:=nil;
    a^.HD:=nil;
  end
  else begin
   if (a^.dato.codP > p.codP) then
     insertar(a^.HI,p)
   else
     insertar(a^.HD,p);
  end;
 end;

var p:participante;
begin
  leerParticipante(p);
  While(p.codP<>-1) do begin
    Insertar(a,p);
    writeln();
    leerParticipante(p);
  end;
end;

Procedure Recorrer(a:arbol; elem:integer; var L:lista);   //no puedo realizar una busqueda eficiente porque el elemento que estoy evaluando es el cod de ciudad, no el cod de participante con lo que está ordenado el árbol.

    procedure AgregarAdelante(var L:lista; elem:participante);
    var nue:lista;
    begin
      New(nue);
      nue^.info:=elem;
      nue^.sig:=L;
      L:=nue;
    end;

begin
 if(a<>nil) then begin
    if(a^.dato.codCiu = elem) then
      AgregarAdelante(L,a^.dato);
    Recorrer(a^.Hi,elem,L);
    Recorrer(a^.HD,elem,L);
 end;
end;

Procedure imprimirLista(l:lista);
begin
  if(l<>nil) then begin
     writeln('codigo del participante: ', l^.info.codP);
     writeln('edad: ', l^.info.edad);
     l:= l^.sig;
     imprimirLista(l);
  end;
end;

procedure verValoresEnRango(a:arbol; inf,sup:integer; var cant:integer);
begin
   if(a<>nil) then begin
     if (a^.dato.codP >= inf) then begin
        if (a^.dato.codP <= sup) then begin
             cant:= cant + 1;
             verValoresEnRango (a^.HI, inf, sup,cant);
             verValoresEnRango(a^.HD, inf, sup,cant);
        end
        else
           verValoresEnRango (a^.HI, inf, sup,cant);
     end
     else verValoresEnRango (a^.HD, inf, sup,cant);
   end;
end;


Procedure edadPromedio(a:arbol; var sumaedad,cantp:integer; var prom:real);
begin
   if(a<>nil) then begin
        sumaedad:= sumaedad + a^.dato.edad;
        cantP:= cantP + 1;
        edadPromedio(a^.HI,sumaedad,cantp,prom);
        edadPromedio(a^.HD,sumaedad,cantp,prom);
        prom:= sumaedad div cantP;
   end;
end;


var a:arbol; L:lista; codCiudad,valor1,valor2,cant,sumedad,cantp:integer; prom:real;

Begin
  a:=nil; L:=nil; cant:=0; cantp:=0; sumedad:=0; prom:=0;
  crearABB(a);
  writeln('ingrese el codigo de ciudad:');
  readln(codCiudad);
  Recorrer(a,codCiudad,L);
  writeln('participantes de la ciudad', codCiudad);
  imprimirLista(L);
  writeln('ingrese el valor inicial del rango:');
  readln(valor1);
  writeln('ingrese el valor final del rango:');
  readln(valor2);
  verValoresEnRango(a,valor1,valor2,cant);
  writeln('cantidad de participantes dentro del rango:', cant);
  EdadPromedio(a,sumedad,cantp,prom);
  writeln('edad promedio de los participantes del concurso:', Prom:3:2,' ');
  readln;
End.

