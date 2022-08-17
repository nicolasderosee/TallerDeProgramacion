program repaso2;
Type
  cadena15 = String[15];
  rango = 0..1;
  auto= record
     pat:cadena15;
     edad:integer;
     papeles:rango;
   end;
  arbol= ^nodoA;
  nodoA = record
     dato: auto;
     HI: arbol;
     HD: arbol;
   end;


Procedure CrearABB(var a:arbol);

  Procedure LeerAuto(var au:auto);
  begin
    write('ingrese la edad del conductor:');
    readln(au.edad);
    if(au.edad<>0) then begin
      write('ingrese la patente del auto:');
      readln(au.pat);
      write('ingrese 1 si tiene los papeles en regla o 0 si no los tiene en regla:');
      readln(au.papeles);
      writeln();
    end;
  end;

 Procedure Insertar(var a:arbol; au:auto; var estaba:boolean); //esta estructura va a tener autos que ya usaron su unico permiso de acceso
 begin
    if(a=nil) then begin
       new(a);
       a^.dato:=au;
       a^.HI:=nil;
       a^.HD:=nil;
    end
    else begin
      if (a^.dato.pat = au.pat) then estaba:= true // el auto ya estaba en la estructura
      else begin
         estaba:= false;                           //el auto no estaba en la estructura
         if (a^.dato.pat > au.pat) then
             insertar(a^.HI,au,estaba)
         else
             insertar(a^.HD,au,estaba);
      end;
    end;
 end;

var au:auto; estaba:boolean;
begin
  LeerAuto(au);
  while(au.edad<>0) do begin
     estaba:= false;
     Insertar(a,au,estaba); //inserto el auto en la estructura si es que no estaba, si leo un auto que ya esta en la estructura signifia q ya uso su permiso, no lo tengo que dejar pasar
     if(estaba = true) then writeln('no puede pasar');
     writeln();
     LeerAuto(au);
  end;
end;

procedure EnOrden(a:arbol);
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln();
   writeln ('patente:',a^.dato.pat);
   writeln ('edad del conductor:',a^.dato.edad);
   writeln('papeles en regla:', a^.dato.papeles);
   enorden (a^.HD);
 end;
end;

procedure VerValoresEnRango(a:arbol; inf,sup: integer; var cant:integer); //calcula la cantidad de conductores que ingresaron al centro con edad comprendida en un rango.
begin
  if(a<>nil) then begin
    if (a^.dato.edad >= inf) then begin
       if (a^.dato.edad <= sup) then begin
            cant:= cant + 1;
            VerValoresEnRango (a^.HI, inf, sup, cant);
            VerValoresEnRango(a^.HD, inf, sup, cant);
       end
       else
          VerValoresEnRango (a^.HI, inf, sup, cant);
    end
    else VerValoresEnRango (a^.HD, inf, sup, cant);
  end;
end;

Function Vermin (a:arbol): cadena15; //retorna el auto mas viejo que ingreso al centro, aquel con menor pat
begin
 if (a=nil) then Vermin:='zzz'
 else begin
   if (a^.HI = nil) then
     Vermin:= a^.dato.pat
   else
     Vermin:=Vermin(a^.HI)
 end;
end;

var a:arbol; var valorini,valorfin,cant:integer; vmin:cadena15;
Begin
  cant:=0;
  a:=nil;
  CrearABB(a);
  writeln();
  write('estructura con info de los autos que ya usaron su permiso:');
  EnOrden(a);
  writeln();
  write('ingrese el valor inicial del rango de edad:');
  readln(valorini);
  writeln();
  write('ingrese el valor final del rango de edad:');
  readln(valorfin);
  writeln();
  VerValoresEnRango(a,valorini,valorfin,cant);
  write('cantidad de edades dentro del rango ingresado:' , cant);
  writeln();
  vmin:=VerMin(a);
  writeln();
  if(vmin<>'zzz') then write ('patente del auto mas viejo que ingreso al centro:', vmin)
  else writeln ('el arbol esta vacio');
  readln;
End.
