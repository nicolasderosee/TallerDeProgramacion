Program ejeRep4;
Type
  cadena15 = String[15];
  proyecto = record
     topico:cadena15;
     cantVotos:integer;
   end;
  lista=^nodo;
  nodo=record
      datos:proyecto;
      sig:lista;
   end;
  voto=record
      nom:cadena15;
      topico:cadena15;
   end;
  arbol= ^nodoA;
  nodoA = record
     datoNom:cadena15;
     datoProyecto:lista;
     HI: arbol;
     HD: arbol;
   end;


Procedure CrearABB(var a:arbol);

  Procedure LeerVoto(var v:voto);
  begin
    write('ingrese el nombre del alumno que quiera votar:');
    readln(v.nom);
    if(v.nom<>'zzz') then begin
      write('ingrese el topico del proyecto:');
      readln(v.topico);
      writeln();
    end;
  end;

  Procedure agregarVoto(var L:lista; elem:cadena15);

       Procedure InsertarEnLista(var pri:lista; elem:cadena15);  //agrego ordenando por topico del proyecto
       var ant, nue, act: lista;
       begin
            new (nue);
            nue^.datos.topico:=elem;
            nue^.datos.cantVotos:=1;
            act :=pri;
            while (act<>NIL) and (act^.datos.topico < elem) do begin
                ant:= act;
                act:= act^.sig ;
            end;
            if (act = pri)  then pri:= nue
            else ant^.sig:= nue;
            nue^.sig:= act;
      end;
  begin
     if(L^.datos.topico = elem) then
          L^.datos.cantVotos:= L^.datos.cantVotos + 1 // si el proyecto ya está agregado, se incrementa la cantidad de votos de dicho proyecto
     else
          agregarVoto(L^.sig,elem); //si el proyecto no está, se debe agregar a la lista y poner la cantidad de votos en 1
          InsertarEnLista(L,elem);
  end;

  Procedure insertarEnABBdeListas (var a: arbol; v:voto);
  begin
     if(a=nil) then begin
         new(a);
         a^.datoNom:=v.nom;
         a^.datoProyecto:=nil;
         a^.HI:=nil;
         a^.HD:=nil;  //si llega acá es porque el alumno no estaba en el abb
         agregarVoto(a^.datoProyecto, v.topico);
     end
     else
         if(a^.datoNom > v.nom) then
                insertarEnABBdeListas(a^.HI,v)
         else
            if(a^.datoNom < v.nom) then
                insertarEnABBdeListas(a^.HD,v)
            else
                agregarVoto(a^.datoProyecto, v.topico) // si el nombre no es ni menor ni mayor, el alumno es el mismo que busco
  end;

var v:voto;
begin
  LeerVoto(v);
  while(v.nom<>'zzz') do begin
     insertarEnABBdeListas(a,v);
     LeerVoto(v);
  end;
end;

var a:arbol;
Begin
   CrearABB(a);
   readln;
End.
