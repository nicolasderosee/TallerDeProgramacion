program repaso3;
Const
 DimF = 6;
Type
 rango=1..Dimf;
 rango2=-1..10;
 cadena15 = String[15];
 alumno=record
    nom:cadena15;
    ap:cadena15;
    aniocurso:rango;
    nota:rango2;
  end;
 alum=record
    nom:cadena15;
    ap:cadena15;
    nota:rango2;
  end;
 nuevo=record
    nota:rango2;
    cant:integer;
  end;
 lista=^nodo;
 nodo=record
    datos:alum;
    sig:lista;
  end;
 listaNueva=^nodoNuevo;
   nodoNuevo=record
      datos:nuevo;
      sig:listaNueva;
    end;
 vector = Array [rango] of lista; //vector de listas de alumnos

procedure CrearVectorDeListas (var v:vector);

   procedure inivec(var v:vector);
   var i:integer;
   begin
       for i:=1 to Dimf do
          v[i]:= NIL;
   end;

   procedure LeerAlumno(var a:alumno);
   begin
      write('Ingrese el curso del alumno:');
      readln(a.aniocurso);
      if(a.aniocurso<>0) then begin
         write('Ingrese el nombre del alumno:');
         readln(a.nom);
         write('Ingrese el apellido del alumno:');
         readln(a.ap);
         write('Ingrese la nota del alumno:');
         readln(a.nota);
         writeln();
     end
   end;

  Procedure CargarAlum(a:alumno; var a1:alum);
  begin
     a1.nom:=a.nom;
     a1.ap:=a.ap;
     a1.nota:=a.nota;
  end;

  Procedure InsertarEnLista(var pri:lista; elem:alum);
  var ant, nue, act: lista;
  begin
    new (nue);
    nue^.datos:=elem;
    act :=pri;
    while (act<>NIL) and (act^.datos.nota > elem.nota) do begin
        ant := act;
        act := act^.sig ;
    end;
    if (act = pri)  then pri:= nue
    else ant^.sig:= nue;
    nue^.sig:= act;
  end;


var a:alumno; a1:alum;
begin
   inivec(v);
   LeerAlumno(a);
   while(a.aniocurso<>0) do begin
      CargarAlum(a,a1);
      InsertarEnLista(v[a.aniocurso],a1); {de esta forma enviandole a1 se carga en la lista los datos del alumno sin el año}
      LeerAlumno(a);
   end;
end;

procedure ImprimirVectorDeListas(v:vector);
  Procedure recorrerlista(L:lista);
  begin
     writeln();
     writeln('apellido, nombre y nota de los alumnos:');
     while(L<>NIL) do begin
        writeln();
        writeln(L^.datos.ap , ' ', L^.datos.nom, ' ', L^.datos.nota);
        L:=L^.sig;
     end;
  end;

var i:integer;
begin
 for i:= 1 to Dimf do begin
   writeln('anio de curso ' , i ,':');
   recorrerlista(v[i]);
   writeln();
 end;
end;

Procedure MergeAcumulador(v:vector; var L:listaNueva);

   Procedure DeterminarMaximo(var v:vector; var max:alum);
   var i,posMax:rango;
   begin
      max.nota:=-1;
      for i:=1 to DimF do begin
         if (v[i]<>nil) and (v[i]^.datos.nota>max.nota) then begin
            max:=v[i]^.datos;
            posMax:=i;
         end;
      end;
      if(max.nota<>-1) then
         v[posMax]:=v[posMax]^.sig;
   end;

  Procedure InsertarOrdenado(var pri:listaNueva; elem:nuevo); //cargo por orden de contabilidad de menor a mayor
  var ant, nue, act: listaNueva;
  begin
    new (nue);
    nue^.datos:=elem;
    act :=pri;
    while (act<>NIL) and (act^.datos.cant < elem.cant) do begin
        ant := act;
        act := act^.sig ;
    end;
    if (act = pri)  then pri:= nue
    else ant^.sig:= nue;
    nue^.sig:= act;
  end;


var
   max:alum; actual:rango2; total:integer; nuev:nuevo;
begin
   L:=nil;
   DeterminarMaximo(v,max);
   while(max.nota<>-1) do begin
      actual:=max.nota;
      total:=0;
      while (actual=max.nota) do begin
         total:=total+1;
         DeterminarMaximo(v,max);
      end;
      nuev.nota:=actual;
      nuev.cant:=total;
      InsertarOrdenado(L,nuev);
   end;
end;

procedure ImprimirListaMerge(L:listaNueva);
begin
   if (L<>NIL) then begin
     writeln;
     writeln(L^.datos.cant , ' alumnos sacaron: ' , L^.datos.nota);
     L:=L^.sig;
     ImprimirListaMerge(L);
   end;
end;


var
 v:vector; Lnuev:listaNueva;
begin
 CrearVectorDeListas(v);
 writeln();
 ImprimirVectorDeListas(v);
 MergeAcumulador(v,Lnuev);
 writeln('Nueva estructura ordenada por la cant de alumnos que sacaron las mismas notas: ');
 ImprimirListaMerge(Lnuev);
 readln;
end.
