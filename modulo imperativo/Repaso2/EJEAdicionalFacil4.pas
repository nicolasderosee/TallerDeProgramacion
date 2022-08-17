Program ejeRepaso4;
type
   cadena15 = String[25];
   venta = record
       codProd:integer;
       tipo:cadena15;
       fe:cadena15;
       cantVendi:integer;
       monto:real;
    end;
   arbol= ^nodoA;
   nodoA = record
      dato:venta;
      HI:arbol;
      HD:arbol;
    end;

Procedure CrearABB(var a:arbol);

  Procedure LeerVenta(var v:venta);
  begin
    write('ingrese la cantidad de producto vendida:');
    readln(v.cantVendi);
    if(v.cantVendi<>-1) then begin
      write('ingrese el codigo del producto:');
      readln(v.codProd);
      write('ingrese el tipo de producto:');
      readln(v.tipo);
      write('ingrese la fecha (dia, mes y anio):');
      readln(v.fe);
      write('ingrese el monto total de la venta:');
      readln(v.monto);
    end;
  end;

 Procedure Insertar(var a:arbol; v:venta);
 begin
    if(a=nil) then begin
       new(a);
       a^.dato:=v;
       a^.HI:=nil;
       a^.HD:=nil;
    end
    else begin
      if (a^.dato.codProd > v.codProd) then
         insertar(a^.HI,v)
      else
         insertar(a^.HD,v);
    end;
 end;

var v:venta;
begin
  LeerVenta(v);
  writeln();
  while(v.cantVendi<>-1) do begin
     Insertar(a,v);
     LeerVenta(v);
     writeln();
  end;
end;

procedure EnOrden(a:arbol); //imprime el arbol
begin
 if (a <> nil) then begin
   enorden (a^.HI);
   writeln();
   writeln ('codigo del producto:', a^.dato.codProd);
   writeln ('tipo del producto:', a^.dato.tipo);
   writeln ('cantidad vendida:', a^.dato.cantVendi);
   writeln ('fecha:', a^.dato.fe);
   writeln ('monto total de la venta:', a^.dato.monto:3:2);
   enorden (a^.HD);
 end;
end;

procedure VerValoresEnRango(a:arbol; inf,sup: integer);
begin
  if(a<>nil) then begin
    if (a^.dato.codProd >= inf) then begin
       if (a^.dato.codProd <= sup) then begin
            write(a^.dato.tipo,' - ');
            VerValoresEnRango (a^.HI, inf, sup);
            VerValoresEnRango(a^.HD, inf, sup);
       end
       else
          VerValoresEnRango (a^.HI, inf, sup);
    end
    else VerValoresEnRango (a^.HD, inf, sup);
  end;
end;

procedure Recorrer(a:arbol; var cant:integer);  // cuenta la cantidad total de ventas cuyo monto total es sup a 100. recorre de forma completa
begin
 if(a<>nil) then begin
   if(a^.dato.monto > 100) then
     cant:= cant + 1;
   Recorrer(a^.Hi,cant);
   Recorrer(a^.HD,cant);
 end;
end;

var a:arbol; valorini,valorfin,cantTotal:integer;
Begin
  valorini:=1500; valorfin:=2200; cantTotal:=0;
  a:=nil;
  CrearABB(a);
  writeln('informacion de las ventas:');
  EnOrden(a);
  writeln();
  writeln('tipo de productos cuyo codigo esta comprendido entre los valores 1500 y 2200:');
  VerValoresEnRango(a,valorini,valorfin);
  Recorrer(a,cantTotal);
  writeln();
  writeln('Cantidad total de ventas cuyo monto toal es superior a 100 pesos:', cantTotal);
  readln();
End.
